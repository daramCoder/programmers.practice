package codeKata.level_4;

import java.util.Stack;

public class 크레인인형뽑기 {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        solution(board, moves);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();  // 선언 및 생성
        stack.push(0);

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.peek() == board[j][move - 1]) {  // 같은 인형이면
                        stack.pop(); // 꺼낸다.
                        answer += 2;  // 2개를 더해준다.
                    } else { // 다르면
                        stack.push(board[j][move - 1]); // 저장한다.
                    }
                    board[j][move - 1] = 0; // board에서 꺼낸 인형 없애주기
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
