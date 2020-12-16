package Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESEncryptionDecryption {
	public static void main(String[] args) {
		try{
			String plainText = "Hello World";
			SecretKey secKey = getSecretEncryptionKey();
			//System.out.println(secKey);
			byte[] encText = encryptText(plainText, secKey);
			String plainString = decryptText(encText, secKey);
			System.out.println(plainString);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public static SecretKey getSecretEncryptionKey() throws Exception{
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey secKey = keyGen.generateKey();
		return secKey;
		
	}
	
	public static byte[] encryptText(String plainText,SecretKey secKey)throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secKey);
		byte[] byteCipherText = cipher.doFinal(plainText.getBytes());
		return byteCipherText;
	}
	
	public static String decryptText(byte[] decText,SecretKey secKey)throws Exception{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secKey);
		byte[] bytePlainText = cipher.doFinal(decText);
		return new String(bytePlainText);
		
	}
}
