package level1;

import org.junit.Assert;

import java.util.ArrayList;

public class Q42840_J {
    public static void main(String[] args) {
        Q42840_J main = new Q42840_J();

        Assert.assertArrayEquals(new int[]{1}, main.solution(new int[]{1,2,3,4,5}));
        Assert.assertArrayEquals(new int[]{1, 2, 3}, main.solution(new int[]{1, 3, 2, 4, 2}));
    }

    public int[] solution(int[] answers) {
        int[][] p = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int maxAnswer = 0;
        ArrayList<Integer> winners = new ArrayList<>();

        for (int pIndex = 0; pIndex < p.length; pIndex++) {
            int[] arr = p[pIndex];
            int answer = 0;

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == arr[i % arr.length]) {
                    answer++;
                }
            }

            if (answer > maxAnswer) {
                maxAnswer = answer;
                winners.clear();
                winners.add(pIndex + 1);

            } else if (answer == maxAnswer) {
                winners.add(pIndex + 1);
            }
        }

        return winners.stream().mapToInt(n -> n).toArray();
    }
}
