public class SuperEncryptor {
    private String[][] box;
    private int rows;
    private int cols;
    private int shift;

    public SuperEncryptor(int r, int c, int shift) {
        rows = r;
        cols = c;
        this.shift = shift;
    }

    public void fillBlock(String str)
    {
        for(int i = 0; i < rows; i++) {
            for(int x = 0; x < cols; x++) {
                int nextLetter = (cols * i) + x;

                if(nextLetter < str.length()) {
                    String letter = str.charAt(nextLetter) + "";

                    box[i][x] = letter;
                } else {
                    box[i][x] = "-";
                }
            }
        }
    }

    public String shiftLetters(String str) {
        String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = capital.toLowerCase();

        String scramble = "";

        for(int i = 0; i < str.length(); i++) {
            String letter = str.charAt(i) + "";
            String newLetter = "";

            if(capital.contains(letter)) {
                int indx = capital.indexOf(letter);
                indx += shift;

                newLetter = capital.charAt(indx % 26) + "";

            } else if (lowercase.contains(letter)) {
                int indx = lowercase.indexOf(letter);
                indx += shift;

                newLetter = lowercase.charAt(indx % 26) + "";

            } else {
                newLetter = letter;
            }

            scramble += newLetter;
        }

        return scramble;
    }

    public String unshiftLetters(String str) {
        String capital = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowercase = capital.toLowerCase();

        String scramble = "";

        for(int i = 0; i < str.length(); i++) {
            String letter = str.charAt(i) + "";
            String newLetter = "";

            if(capital.contains(letter)) {
                int indx = capital.indexOf(letter);
                indx += shift;

                newLetter = capital.charAt(indx % 26) + "";

            } else if (lowercase.contains(letter)) {
                int indx = lowercase.indexOf(letter);
                indx += shift;

                newLetter = lowercase.charAt(indx % 26) + "";

            } else {
                newLetter = letter;
            }

            scramble += newLetter;
        }

        return scramble;
    }

}
