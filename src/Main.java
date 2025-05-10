public class Main {
    public static void main(String[] args) {
        MorseEncoder encoder = new MorseEncoder();

        System.out.println(encoder.toMorse("Hello world"));
        System.out.println(encoder.decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. "));
    }
}