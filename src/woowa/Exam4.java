package woowa;

import org.junit.Assert;

import java.util.Arrays;

public class Exam4 {
    public static void main(String[] args) {
        Exam4 main = new Exam4();
        Assert.assertEquals(5, main.solution(new int[]{5}, new int[]{4, 2, 5, 3, 2}));
        Assert.assertEquals(4, main.solution(new int[]{4, 2, 5, 3, 2}, new int[]{4, 5}));
        Assert.assertEquals(4, main.solution(new int[]{4, 2, 5, 3, 2}, new int[]{4}));
        Assert.assertEquals(2, main.solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2}));
        Assert.assertEquals(-1, main.solution(new int[]{2, 1}, new int[]{3, 3}));
    }

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i])
                return A[k];
        }

        return -1;
    }
}
