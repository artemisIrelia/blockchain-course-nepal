package historicalciphers;

/**
 *
 * @author sandippandey
 */
public class CaesarCipherImpl implements CaesarCipher {

    public static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String encrypt(int key, String plainText) {
        // check if key is invalid
        if(key<0){
            throw new IllegalArgumentException("Key cannot be negative.");
        }
        
        // check if plain text message is invalid
        if (plainText == null || plainText.isEmpty()) {
            throw new IllegalArgumentException("Plain text message is invalid");
        }
        
        String cipherText = "";
        for (char plainTextChar : plainText.toCharArray()) {
            // find position of plainTextChar in CHARSET
            int plainTextCharIndex = CHARSET.indexOf(plainTextChar);
            if (plainTextCharIndex > 0) {
                // compute the encrypted character
                int encryptedCharIndex = (plainTextCharIndex + key) % CHARSET.length();
                // add char to cipherText
                cipherText += CHARSET.charAt(encryptedCharIndex);
            } else {
                // if char is not found, then don't encrypt, just add to the cipher text
                cipherText += plainTextChar;
            }
        }
        return cipherText;
    }

    @Override
    public String decrypt(int key, String cipherText) {
        // check if key is invalid
        if(key<0){
            throw new IllegalArgumentException("Key cannot be negative.");
        }
        
        // check if cipher text is invalid
        if (cipherText == null || cipherText.isEmpty()) {
            throw new IllegalArgumentException("Cipher text message is invalid");
        }
        
        String plainText = "";
        for (char cipherTextChar : cipherText.toCharArray()) {
            // find position of plainTextChar in CHARSET
            int encryptedCharIndex = CHARSET.indexOf(cipherTextChar);
            if (encryptedCharIndex > 0) {
                // compute the encrypted character
                int plainTextCharIndex = (cipherTextChar - key) % CHARSET.length();
                // add char to cipherText
                plainText += CHARSET.charAt(plainTextCharIndex);
            } else {
                // if char is not found, then don't encrypt, just add to the cipher text
                plainText += cipherTextChar;
            }
        }
        return plainText;
    }

}
