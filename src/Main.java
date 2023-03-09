public class Main {
    public static void main(String[] args) {

        int r = 3;
        int c = 8;

        Encryptor e = new Encryptor(r, c);

        String encrypted = "F:eu  nyr oefuaa dcaitrngi  gmthohtsi tsn  olrwikaseualsyyes   bifetuc n AAfAAaAAcAAtAAAAAAAAAAA";
        System.out.println(e.decryptMessage(encrypted));

        String reg = "";

        System.out.println(e.encryptMessage(reg));
    }
}
