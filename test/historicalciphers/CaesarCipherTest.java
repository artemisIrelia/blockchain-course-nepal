package historicalciphers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sandippandey
 */
public class CaesarCipherTest {
    
    private CaesarCipher caesarCipher;
    private int cipherKey;
    
    @Before
    public void setUp() {
        caesarCipher = new CaesarCipherImpl();
        cipherKey = 5;
    }
    
    @Test
    public void testEncryptionDecryptionWorks(){
        String plainMessage = "hello world";
        String cipherMessage = caesarCipher.encrypt(cipherKey, plainMessage);
        String decryptedMessage = caesarCipher.decrypt(cipherKey, cipherMessage);
        assertEquals("Decrypted message does not match the original message",decryptedMessage, plainMessage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMessageEncryption(){
        String plainMessage = null;
        String cipherMessage = caesarCipher.encrypt(cipherKey, plainMessage);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeKey(){
        int negativeKey = -3;
        String plainMessage = "hello world";
        String cipherMessage = caesarCipher.encrypt(negativeKey, plainMessage);
    }
    
}
