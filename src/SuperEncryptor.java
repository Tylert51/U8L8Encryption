import java.util.ArrayList;

public class SuperEncryptor {
    private String[][] box;
    private int rows;
    private int cols;
    private int shiftA;
    private int shiftR;
    private int shiftC;

    public SuperEncryptor(int r, int c, int sA, int sR, int sC) {
        rows = r;
        cols = c;
        shiftA = sA;
        shiftR = sR;
        shiftC = sC;

        box = new String[r][c];
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


    public String encryptMessage(String message) {
        String encrypted = "";

        message = shiftLetters(message);

        while(message.length() > rows * cols) {
            fillBlock(message);


            shiftRows(shiftR);
            shiftCol(shiftC);

            encrypted += readBoxBackwards();

            message = message.substring(rows * cols);
        }
        if(message.length() != 0) {
            fillBlock(message);

            shiftRows(shiftR);
            shiftCol(shiftC);

            encrypted += readBoxBackwards();
        }

        return encrypted;
    }

    public String decryptMessage(String eMsg) {

        eMsg = unshiftLetters(eMsg);

        String dMsg = "";

        while(eMsg.length() > rows * cols) {

            fillEBlock(eMsg);

            unshiftCol();
            unshiftRows();

            dMsg += readBox();
            eMsg = eMsg.substring(rows * cols);
        }
        if(eMsg.length() != 0) {
            fillEBlock(eMsg);

            unshiftCol();
            unshiftRows();

            dMsg += readBox();
        }

        if(dMsg.length() != 0) {
            while ((dMsg.charAt(dMsg.length() - 1) + "").equals("-")) {
                dMsg = dMsg.substring(0, dMsg.length() - 1);
            }
        }

        return dMsg;
    }

    public void fillEBlock(String str) {
        int indOfNextLetter = 0;

        for(int r = box.length - 1; r >= 0; r--) {
            for(int c = box[0].length - 1; c >= 0; c--) {

                box[r][c] = str.charAt(indOfNextLetter) + "";
                indOfNextLetter++;
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
                indx += shiftA;

                newLetter = capital.charAt(indx % 26) + "";

            } else if (lowercase.contains(letter)) {
                int indx = lowercase.indexOf(letter);
                indx += shiftA;

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
                indx += shiftA;

                newLetter = capital.charAt(indx % 26) + "";

            } else if (lowercase.contains(letter)) {
                int indx = lowercase.indexOf(letter);
                indx += shiftA;

                newLetter = lowercase.charAt(indx % 26) + "";

            } else {
                newLetter = letter;
            }

            scramble += newLetter;
        }

        return scramble;
    }

    public String[][] shiftRows(int shiftFactor) {
        shiftFactor %= rows;

        for(int i = 0; i < shiftFactor; i++) {
            String[] temp = box[0].clone();

            for(int x = 0; x < box.length - 1; x++) {
                box[x] = box[x + 1].clone();
            }
            box[box.length - 1] = temp;
        }

        return box;
    }

    public String[][] unshiftRows() {
        int unshift = rows - (shiftR % rows);

        return shiftRows(unshift);
    }

    public String[][] shiftCol(int shiftFactor) {
        shiftFactor %= cols;

        ArrayList<String[]> differentCol = new ArrayList<>();
        String[] tempCol = new String[box.length];

        for(int c = 0; c < box[0].length; c++) {
            for(int r = 0; r < box.length; r++) {
                tempCol[r] = box[r][c];
            }
            differentCol.add(tempCol.clone());
        }

        for(int i = 0; i < shiftFactor; i++) {
            differentCol.add(differentCol.remove(0));
        }

        for(int c = 0; c < differentCol.size(); c++) {
            for(int r = 0; r < box.length; r++) {
                String[] temp = differentCol.get(c);

                box[r][c] = temp[r];
            }
        }

        return box;
    }

    public String[][] unshiftCol() {
        int unshiftFactor = cols - (shiftC % cols);

        return shiftCol(unshiftFactor);

    }

    public String readBoxBackwards() {
        String str = "";

        for(int r = box.length - 1; r >= 0; r--) {
            for(int c = box[0].length - 1; c >= 0; c--) {
                str += box[r][c];
            }
        }

        return str;
    }

    public String readBox() {
        String str = "";

        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[0].length; c++) {
                str += box[r][c];
            }
        }

        return str;
    }

    public void setBox(String[][] b) {
        box = b;
    }

    public String[][] getBox() {
        return box;
    }

}
