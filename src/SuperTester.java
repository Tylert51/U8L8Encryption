public class SuperTester {
    public static void main(String[] args) {

        SuperEncryptor s = new SuperEncryptor(5, 5, 2);

        String test = s.shiftLetters("Heloo dueede");

        System.out.println(test);
        System.out.println(s.unshiftLetters(test));

    }
}
