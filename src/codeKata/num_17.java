package codeKata;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.Scanner;

// 자연수 뒤집어 배열로 만들기
// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
// 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
public class num_17 {
        class Solution {
            public int[] solution(long n) {
                int lNum = (int)n;

                String[] arr = String.valueOf(lNum).split(""); // 나눠서 배열에 넣고

                int[] intArr = new int[arr.length];
                int[] answer = new int[arr.length];

                for (int i = 0; i < arr.length; i++) {
                    intArr[i] = Integer.parseInt(arr[i]); // String 배열을 int 배열로
                    int length = arr.length -1 ;
                    length -= i;
                    answer[i] =  intArr[length];
                }
                return answer;
            }
        }
    }

