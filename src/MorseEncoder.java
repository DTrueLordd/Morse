import java.util.HashMap;
import java.util.Map;


public class MorseEncoder {
    private final Map<Character, String> morseAlphabet = new HashMap<>();
    private final Map<String, Character> reverseMorseAlphabet = new HashMap<>();


    private final static String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
    };
    private final static String[] morseNums =
            {"-----", ".----", "..---",
            "...--", "....-", ".....",
            "-....","--...","---..", "----."};


   public MorseEncoder(){
       for(int i = 0; i<morseCode.length; i++){
           morseAlphabet.put((char) ('A'+i),morseCode[i]);
           reverseMorseAlphabet.put(morseCode[i], (char)('A'+i));
       }
       for (int i = 0; i< morseNums.length; i++) {
           morseAlphabet.put((char) (i + 48), morseNums[i]);
           reverseMorseAlphabet.put(morseNums[i], (char)(i+48));
       }
        morseAlphabet.put(' ', "/");
        reverseMorseAlphabet.put("/",' ');
   }


   public void showMorseMap(){
       for(Character key : morseAlphabet.keySet()){
           System.out.println(key + " = " + morseAlphabet.get(key));
       }
   }

   public String toMorse(String str){
       str = str.toUpperCase();
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i<str.length(); i++){
            sb.append(morseAlphabet.get(str.charAt(i))).append(" ");
       }

       return sb.toString();
   }

   public  String decode(String str){
       StringBuilder sb = new StringBuilder();
       String[] arr = str.split(" ");
       for (int i = 0; i< arr.length; i++ ) {
           sb.append(reverseMorseAlphabet.get(arr[i]));
       }

       return sb.toString();
   }

}
