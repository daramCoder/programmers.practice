public class num_39_ant {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int hp) {
            int answer = 0;
//            int rose = 5;
//            int sold = 3;
//            int ergate = 1;
//
//            if (!((hp / rose) == 0)) {
//                answer += (hp / rose);
//                if (!(((hp % rose) / sold) == 0)) {
//                    answer += ((hp % rose)) / sold;
//                    if (!((((hp % rose) % sold) % ergate) == 0)) {
//                        answer += ((hp % rose) % sold)/ergate;
//                    }
//                    else {
//                        answer += ((hp % rose) % sold)/ergate;
//                    }
//                }
//                else{
//                    answer += ((hp % rose)) / sold;
//                }
//            }
//            else{
//                answer += (hp / rose);
//            }
//            return answer;
            // ----------------------


            return hp/ 5 + (hp%5)/ 3 + ((hp%5)%3)/1;


        }
    }
}

