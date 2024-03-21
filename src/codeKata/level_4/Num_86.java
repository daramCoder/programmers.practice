package codeKata.level_4;

import java.util.Arrays;

// H-index
public class Num_86 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        solution(citations);
        solution3(citations);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = Math.min(citations[i], citations.length - i);

            if (h >= answer) {
                answer = Math.max(answer, h);
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static int solution2(int[] citations) {
        int answer = 0;
        int h = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {

            h = i + 1;
            int over = 0;
            int left = 0;
            boolean flag = false;
            if (citations[i] >= h) {
                over++;
            }
            if (h >= over) {
                flag = true;
            } else if (citations[i] <= h) {
                left++;
            }
            if (h <= left) {
                flag = true;
            }
            h = i + 1;
        }

        System.out.println("answer 2 : " + answer);
        return answer;
    }

    public static int solution3(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);  // 0, 1, 3, 5, 6

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;  // 논문의 수 5 , 4, 3, 2, 1

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        System.out.println("answer :" + answer);
        return answer;
    }


    // 다른 사람 풀이
    public static int solution4(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }
        return max;
    }


}
