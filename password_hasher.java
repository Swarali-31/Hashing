package mini_project;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.util.Scanner;

class converter
{
	public void hash()
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter a sentence/word : ");
			String word=sc.nextLine();
			
	        byte[] salt = new byte[16];
	        SecureRandom sr = new SecureRandom();
	        sr.nextBytes(salt);

	        byte[] wordBytes = word.getBytes();
	        byte[] saltedWord = new byte[salt.length + wordBytes.length];

	        System.arraycopy(salt, 0, saltedWord, 0, salt.length);
	        System.arraycopy(wordBytes, 0, saltedWord, salt.length, wordBytes.length);
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed_word = md.digest(saltedWord);
			
			for(byte b: hashed_word)
			{
				System.out.print(String.format("%02x", b));
			}
			
		}
		catch(NoSuchAlgorithmException e)
		{
			System.out.println("No such algorithm found");
		}
	}
}
public class password_hasher {
public static void main(String args[])
{
	converter c=new converter();
	c.hash();
}
}
