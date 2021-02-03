package level1;

import org.junit.Assert;

import java.util.Set;
import java.util.TreeSet;

public class Q68644_J {
    public static void main(String[] args) {
        Q68644_J main = new Q68644_J();

        Assert.assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, main.solution(new int[]{2, 1, 3, 4, 1}));
        Assert.assertArrayEquals(new int[]{2, 5, 7, 9, 12}, main.solution(new int[]{5, 0, 2, 7}));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(n -> n).toArray();
    }
}
