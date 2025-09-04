package utilities;

import org.apache.commons.codec.binary.Base64;

public class encodeString {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "test123";
		
		byte[] encodedString=Base64.encodeBase64(str.getBytes());
		System.out.println("Encode string: "+new String(encodedString));
		
//		byte[] decodedString=Base64.decodeBase64(encodedString);
//		System.out.println("decoded string: "+new String(decodedString));
//		
//		System.out.print(decodeString("&*^&$##123"));
		
	}
	
	//Method to decode password
		public static String decodeString(String password)
		{
			byte[] decodedString=Base64.decodeBase64(password);
			return(new String(decodedString));
		}

		
		//use the above decodeString method like below ex:
		// driver.findElement(By.xpath("//@id-password").sendKeys(decodeString("^%$test1234")
		
}
