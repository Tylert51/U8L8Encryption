import java.util.Enumeration;

public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        for(int i = 0; i < numRows; i++) {
            for(int x = 0; x < numCols; x++) {
                int nextLetter = (numCols * i) + x;

                if(nextLetter < str.length()) {
                    String letter = str.charAt(nextLetter) + "";

                    letterBlock[i][x] = letter;
                } else {
                    letterBlock[i][x] = "A";
                }
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String encrypt = "";

        for(int c = 0; c < numCols; c++) {
            for(int r = 0; r < numRows; r++) {
                encrypt += letterBlock[r][c];
            }
        }

        return encrypt;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String eMsg = "";

        while(message.length() > numRows * numCols) {

            fillBlock(message);
            eMsg += encryptBlock();
            message = message.substring(numCols * numRows);
        }
        if(message.length() != 0) {
            fillBlock(message);
            eMsg += encryptBlock();
        }

        return eMsg;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the ???encryption key??? that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String dMsg = "";


        while(encryptedMessage.length() > numRows * numRows) {

            fillEBlock(encryptedMessage);
            dMsg += decryptBlock();
            encryptedMessage = encryptedMessage.substring(numCols * numRows);
        }
        if(encryptedMessage.length() != 0) {
            fillEBlock(encryptedMessage);
            dMsg += decryptBlock();

        }

        if(dMsg.length() != 0) {
            while ((dMsg.charAt(dMsg.length() - 1) + "").equals("A")) {
                dMsg = dMsg.substring(0, dMsg.length() - 1);
            }
        }

        return dMsg;
    }

    private void fillEBlock(String encrypt) {

        for(int c = 0; c < numCols; c++) {
            for(int r = 0; r < numRows; r++) {
                int nextLetter = (numRows * c) + r;

                if(nextLetter < encrypt.length()) {
                    String letter = encrypt.charAt(nextLetter) + "";

                    letterBlock[r][c] = letter;
                } else {
                    letterBlock[r][c] = "";
                }
            }
        }
    }

    private String decryptBlock() {
        String decrypt = "";

        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {
                decrypt += letterBlock[r][c];
            }
        }

        return decrypt;

    }



}