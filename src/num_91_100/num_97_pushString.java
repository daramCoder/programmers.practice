package num_91_100;

public class num_97_pushString {
    public static void main(String[] args) {
        String A = "hello";
        String B = "ohell";
        Solution.solution(A, B);
    }

    class Solution {
        public static int solution(String A, String B) {
            int answer = 0;
            String[] Aarr = A.split("");
            String[] newArr = new String[Aarr.length];
            for (int i = 0; i <= A.length(); i++){
                    newArr[i + 1] = String.valueOf(A.indexOf(Aarr[i]));
                    if (i == A.indexOf(Aarr[Aarr.length])){
                        newArr[0] = String.valueOf(A.indexOf(Aarr[i]));
                    }
            }


            return answer;
        }
    }

}
