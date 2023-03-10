public class Main {
    public static void main(String[] args) {

        int r = 3;
        int c = 5;

        Encryptor e = new Encryptor(r, c);

        String encrypted = "I   aog no7 t8mytP  UU6Sn HiA T  eGdsoatsr.hn o ioTtk. e BrWagAstAhoAinAn!A";
        System.out.println(e.decryptMessage(encrypted));

        String reg = "";

        System.out.println(e.encryptMessage(reg));
    }
}
