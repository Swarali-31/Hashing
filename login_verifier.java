package mini_project;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

class hasher
{
	static byte[] s_salt;
	static byte[] s_hash;
	
	public static  void generateSalt()
	{
		SecureRandom sr=new SecureRandom();
		byte[]salt=new byte[16];
		sr.nextBytes(salt);
		s_salt=salt;
	}
	
	public static void password(String password) throws NoSuchAlgorithmException
	{
		byte[] p_word=password.getBytes();
		byte[]salted_word=new byte[p_word.length+ s_salt.length];
		
	    System.arraycopy(s_salt, 0, salted_word, 0, s_salt.length);
	    System.arraycopy(p_word, 0, salted_word, s_salt.length, p_word.length);
	    
	    MessageDigest md=MessageDigest.getInstance("SHA-256");
	    s_hash=md.digest(salted_word);
	}

	public static void login() throws NoSuchAlgorithmException
	{
		int i=1;
		while(i<=3)
		{
	        if (s_salt==null || s_hash==null) {
	            System.out.println("New? Register first.");
	            return;
	       }	
	        
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter a valid password");
	        String word=sc.nextLine();
	        
	        byte[] hash_pass=word.getBytes();
	        byte[]salted_hash=new byte[hash_pass.length + s_salt.length];
	        
	        System.arraycopy(s_salt, 0, salted_hash, 0, s_salt.length);
	        System.arraycopy(hash_pass, 0, salted_hash, s_salt.length, hash_pass.length);
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] inputHash = md.digest(salted_hash);

	        if (Arrays.equals(inputHash, s_hash)) {
	            System.out.println("Login successful!");
	            i=0;
	            break;
	        } else {
	            System.out.println("Incorrect password.");
	            i++;
	        }   
	}
		if(i!=0)
		{
			System.out.println("Try again!");
		}
		
	}
}
public class login_verifier {

	public static void main(String[] args) {
		 try {
	            Scanner sc = new Scanner(System.in);

	            System.out.print("Set your password: ");
	            String pass = sc.nextLine();

	            hasher.generateSalt();        
	            hasher.password(pass);    

	            hasher.login();           

	        } catch (NoSuchAlgorithmException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }

	}

}
