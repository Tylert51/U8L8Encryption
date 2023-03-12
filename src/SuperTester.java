import java.util.Arrays;

public class SuperTester {
    public static void main(String[] args) {

        int shiftR = 2;
        int shiftC = 10;

        SuperEncryptor s = new SuperEncryptor(4, 3, 2, shiftR, shiftC);

        String test = s.shiftLetters("Heloo dueede");

        String[][] testB = {{"H", "E", "L"},
                            {"L", "L", "O"},
                            {" ", "D", "U"},
                            {"D", "E", "-"}};

        s.setBox(testB);

        /*
        printArray(s.shiftRows(shiftR));
        System.out.println();
        printArray(s.unshiftRows());

         */


        printArray(s.shiftCol(shiftC));
        System.out.println();
        printArray(s.unshiftCol());



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
