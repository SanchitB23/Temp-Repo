package config;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.security.MessageDigest;

public class HexConfig {
    public static void main(String[] args)
	{
		try
		   {
		     FileOutputStream outfile = new FileOutputStream("hashout");
		     PrintStream output = new PrintStream(outfile);

		     String s;
		     byte b;

	         //SHA-1

		     MessageDigest sha = MessageDigest.getInstance("SHA-1");

		     FileInputStream infile= new FileInputStream(args[0]);
		     while(infile.available()!= 0)
		      {
		        b = (byte)infile.read();
		        sha.update(b);
		      };

		     infile.close();

		     byte[]hash = sha.digest();
		     s = new String(HexCodec.bytesToHex(hash));

		     output.println("SHA-1 hash of " +args[0]+ "is :" + s);

	         //MD5

	         MessageDigest md5 = MessageDigest.getInstance("MD5");

	         infile = new FileInputStream(args[0]);
	         while(infile.available()!= 0)
	          {
		        b = (byte)infile.read();
		        md5.update(b);
		      };

		     infile.close();

		     hash = md5.digest();
		     s = new String(HexCodec.bytesToHex(hash));

		     output.println("MD-5 hash of " +args[0]+ "is : " + s);


		     //RIPEMD128

		     MessageDigest rpm128 = MessageDigest.getInstance("RIPEMD128");

		     infile = new FileInputStream(args[0]);
		     while(infile.available()!= 0)
		      {
		        b = (byte)infile.read();
		        rpm128.update(b);
		      };

		     infile.close();

		     hash = rpm128.digest();
		     s = new String(HexCodec.bytesToHex(hash));

		     output.println("RIPEMD128 hash of " +args[0]+ "is :" + s);


		     //RIPEMD160


		     MessageDigest rpm160 = MessageDigest.getInstance("RIPEMD160");

		     infile= new FileInputStream(args[0]);
		     while(infile.available()!= 0)
		      {
		        b = (byte) infile.read();
		        rpm160.update(b);
		      };

		     infile.close();

		     hash = rpm160.digest();
		     s = new String(HexCodec.bytesToHex(hash));

		     output.println("RIPEMD160 hash of " +args[0]+ "is :" + s);

		     }

		  catch(Exception e)
		     {
	          System.err.println("Caught Exception " + e.toString());
		     }

	}
}
