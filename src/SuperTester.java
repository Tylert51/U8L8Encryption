import java.util.Arrays;

public class SuperTester {
    public static void main(String[] args) {

        int shiftR = 5;
        int shiftC = 2;

        SuperEncryptor s = new SuperEncryptor(4, 3, 2, shiftR, shiftC);

        String test = s.shiftLetters("Heloo dueede");

        String[][] testB = {{"H", "E", "L"},
                            {"L", "L", "O"},
                            {" ", "D", "U"},
                            {"D", "E", " "}};

        String[][] testB2 = {{"W", "H", "A"},
                            {"T", "'", "S"},
                            {" ", "U", "P"},
                            {"-", "-", "-"}};

        /*

        s.setBox(testB2);

        printArray(s.shiftRows(shiftR));
        System.out.println();

        printArray(s.shiftCol(shiftC));
        System.out.println();
        System.out.println(s.readBoxBackwards());

         */

        String msg = s.encryptMessage("This isn't just a coinky dink");

        System.out.println(msg);

        System.out.println(s.decryptMessage(msg));




    }

    public static void printArray(String[][] arr) {
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
    }
}
