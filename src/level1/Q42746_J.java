package level1;

import org.junit.Assert;

import java.util.Arrays;

public class Q42746_J {

    public static void main(String[] args) {
        Q42746_J main = new Q42746_J();

        int[] nums1 = {6, 10, 2};
        Assert.assertEquals("6210", main.solution(nums1));

        int[] nums2 = {3, 30, 34, 5, 9};
        Assert.assertEquals("9534330", main.solution(nums2));

        int[] nums3 = {0};
        Assert.assertEquals("0", main.solution(nums3));

        int[] nums4 = {0, 0, 0, 0};
        Assert.assertEquals("0", main.solution(nums4));
    }

    public String solution(int[] numbers) {

        String[] sArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sArr, (s1, s2) -> {
            if (s1.charAt(0) == s2.charAt(0)) {
                return (s2 + s1).compareTo(s1 + s2);
            } else {
                return s2.compareTo(s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : sArr) {
            sb.append(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
