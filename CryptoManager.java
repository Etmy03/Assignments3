

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		char myChar;
		for(int i=0; i<plainText.length(); i++) {
			myChar = (char)(plainText.charAt(i));
			if((myChar<LOWER_BOUND) || (myChar>UPPER_BOUND)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		String encryptedText = "";
		char encryptedChar; 
		for(int i=0; i<plainText.length(); i++) {
			encryptedChar = (char)(plainText.charAt(i)+ key);
			
			encryptedText += encryptedChar;
		}
		return encryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		char encryptedChar;
		char plainTextChar;
		char bellasoChar;
		int len=bellasoStr.length();
		for(int i=0; i<plainText.length(); i++) {
			
			plainTextChar = plainText.charAt(i);
			bellasoChar = bellasoStr.charAt(i%len);
			encryptedChar = (char)( (plainTextChar + bellasoChar));
			while(encryptedChar>UPPER_BOUND) {
				encryptedChar -=RANGE;
			}
			encryptedText += encryptedChar;
		
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String newPlainText = "";
		for(int i=0; i<encryptedText.length(); i++) {
			newPlainText = newPlainText + (char)(encryptedText.charAt(i)-key); 
		}
		return newPlainText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String newPlainText = "";
		int newChar;
		int len=bellasoStr.length();
		for(int i=0; i<encryptedText.length(); i++) {
			newChar = ( (encryptedText.charAt(i)) - (bellasoStr.charAt(i%len)) );
			while(newChar<LOWER_BOUND) {
				newChar +=RANGE;
			}
			newPlainText = newPlainText + (char)newChar;
			
		}
		return newPlainText;
		//throw new RuntimeException("method not implemented");
	}
}
