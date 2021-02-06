package lessons_10302;

import org.junit.Assert;

import java.util.Arrays;

public class Q62947_J {
    public static void main(String[] args) {
        Q62947_J main = new Q62947_J();

        Assert.assertEquals(3, main.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        Assert.assertEquals(0, main.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int aIndex = 0;

        for (int b : B) {
            if (A[aIndex] < b) {
                aIndex++;
                answer++;
            } else if (A[aIndex] == b) {
                aIndex++;
            }
        }

        return answer;
    }











//    Arrays.sort(A);
//        Arrays.sort(B);
//
//    int aIndex = 0;
//    int answer = 0;
//
//        for (int b : B) {
//        if (A[aIndex] < b) {
//            answer++;
//            aIndex++;
//        }
//    }
//
//        return answer;
}
