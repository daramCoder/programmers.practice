import java.util.Map;

public class num_40_2_morseCode {
    public static void main(String[] args) {

    }

    public static String solution(String letter) {
        String answer = "";
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        String[] morseSplit = letter.split(" ");


        for (String s : morseSplit) {
            for (int i = 0; i < morse.length; i++) {

                if(s.equals(morse[i]))
                    answer += Character.toString(i + 'a');
            }
        }

        return answer;
    }
}


