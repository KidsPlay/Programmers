package lessons_10302;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q62948_J {
    public static void main(String[] args) {
        Q62948_J main = new Q62948_J();

        Assert.assertEquals("6210", main.solution(new int[]{6, 10, 2}));
        Assert.assertEquals("9534330", main.solution(new int[]{3, 30, 34, 5, 9}));
    }

    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        return answer.startsWith("0") ? "0" : answer;
    }
}
