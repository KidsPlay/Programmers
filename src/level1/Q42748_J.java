package level1;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;

public class Q42748_J {
    public static void main(String[] args) {
        Q42748_J main = new Q42748_J();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = {5, 6, 3};

        Assert.assertArrayEquals(result, main.solution(array, commands));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            int arrStartIndex = command[0] - 1;
            int arrLength = command[1];
            int arrSearchIndex = command[2] - 1;

            int[] cutArr = Arrays.copyOfRange(array, arrStartIndex, arrLength);
            Arrays.sort(cutArr);
            answer[i] = cutArr[arrSearchIndex];
        }

        return answer;
    }
}
