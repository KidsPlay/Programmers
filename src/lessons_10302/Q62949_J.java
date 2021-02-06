package lessons_10302;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q62949_J {
    public static void main(String[] args) {
        Q62949_J main = new Q62949_J();

        Assert.assertEquals(127, main.solution(new int[]{120, 110, 140, 150}, 485));
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0);
        int mid;

        while (min <= max) {
            mid = (min + max) / 2;

            int sum = 0;
            for (int b : budgets) {
                sum += Math.min(b, mid);
            }

            if (sum > M) {
                max = mid - 1;
            } else if (sum < M) {
                min = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }


//    int min = 0;
//    int max = IntStream.of(budgets).max().orElse(0);
//
//    int answer = 0;
//        while (min <= max) {
//        int mid = (min + max) / 2;
//
//        int sum = IntStream.of(budgets)
//                .map(b -> Math.min(b, mid))
//                .sum();
//
//        if (sum < M) {
//            min = mid + 1;
//            answer = mid;
//        } else {
//            max = mid - 1;
//        }
//    }
//
//        return answer;
}
