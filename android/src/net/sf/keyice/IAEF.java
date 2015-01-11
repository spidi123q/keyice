package net.sf.keyice;

import java.util.Random;

public class IAEF {
	public static String enoutput,deoutput,toencrypt,todecrypt;
	public static boolean val;
	public static int key,password;

	public void simpleEncrypt(String toEncry )
	{
		int charNum = 0;
	    String text="";

	    for(int i=0;i<toEncry.length();i++)
	    {
	        charNum = toEncry.charAt(i);
	        charNum=charNum+1;
	        text+=(char)charNum;
	    }
	        enoutput=text;
	        
		
	
	}
	
	public void simpleDecrypt(String toDecry )
	{
		int charNum = 0;
	    String text="";

	    for(int i=0;i<toDecry.length();i++)
	    {
	        charNum = toDecry.charAt(i);
	        charNum=charNum-1;
	        text+=(char)charNum;
	    }
	        deoutput=text;
	        
		
	
	}
	public void keyGen ()
	{
		Random rand = new Random();
		int range = 999999 - 111111+ 1;
		key = ( rand.nextInt((range) + 1) );
		password = key % 10 + 1;
	}
	public void advancedEncrypt(String toEncry )
	{
		int charNum = 0;
	    String text="";

	    for(int i=0;i<toEncry.length();i++)
	    {
	        charNum = toEncry.charAt(i);
	        charNum=charNum+password;
	        text+=(char)charNum;
	    }
	        enoutput=text;
	        
		
	
	}
	public void advancedDecrypt(String toDecry ,int key )
	{
		int charNum = 0;
	    String text="";
	    password = key % 10 + 1;

	    for(int i=0;i<toDecry.length();i++)
	    {
	        charNum = toDecry.charAt(i);
	        charNum=charNum-password;
	        text+=(char)charNum;
	    }
	        deoutput=text;
	}
	public IAEF()
	{
		enoutput = "hai keyice";
		deoutput = "hai keyice";
		toencrypt ="";
		todecrypt = "";
		val = false;
	}
	
	

}
