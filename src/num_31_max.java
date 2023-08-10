public class num_31_max {
    public static void main(String[] args) {

    }

    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;

//            int max = numbers[0];
//            int second = 0;
//
//            for(int i = 0; i <numbers.length; i++ ){
//                if(numbers[i] > max){
//                    max = numbers[i];
//                }
//            }
            int tmp;
            for(int i = 0; i < numbers.length -1; i++){
                for (int j = i +1; j < numbers.length; j++){
                    if(numbers[j] > numbers[i]){
                        tmp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = tmp;
                    }
                }
            }




            return answer;
        }
    }
}
