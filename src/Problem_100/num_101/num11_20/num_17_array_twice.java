package Problem_100.num_101.num11_20;

public class num_17_array_twice {
    public int[] solution(int[] numbers) {

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = numbers[i] *2;
        }
        return numbers;
    }
}
