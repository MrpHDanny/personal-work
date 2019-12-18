public class CaesarCipher {
    private String message;
    private int key;

    public CaesarCipher(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String encryptMessage() {
        String encryptedMessage = "";

            int len = message.length();
            for (int x = 0; x < len; x++) {
                encryptedMessage += (char) (message.charAt(x) + key);
            }
            return encryptedMessage;
        }

}
