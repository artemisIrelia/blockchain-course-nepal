package historicalciphers;

/**
 *
 * @author sandippandey
 */
public interface CaesarCipher {
    
    public String encrypt(int key, String plainText);
    
    public String decrypt(int key, String cipherText);
    
}
