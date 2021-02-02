package level1;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Q42862_J {
    public static void main(String[] args) {
        Q42862_J main = new Q42862_J();

//        Assert.assertEquals(5, main.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        Assert.assertEquals(4, main.solution(5, new int[]{2, 4}, new int[]{3}));
//        Assert.assertEquals(2, main.solution(3, new int[]{3}, new int[]{1}));
        Assert.assertEquals(3, main.solution(5, new int[]{1,2,4,5}, new int[]{2,3,4}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = n;
//
//        for (int lostNum : lost) {
//            boolean isRent = false;
//
//            for (int j = 0; j < reserve.length; j++) {
//                if (Math.abs(lostNum - reserve[j]) <= 1) {
//                    reserve[j] = -1;
//                    isRent = true;
//                    break;
//                }
//            }
//
//            if (!isRent) {
//                answer--;
//            }
//        }
//
//        return answer;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = 0;
        int lIndex = 0;
        int rIndex = 0;

        for (int sNum = 1; sNum <= n; sNum++) {
            if (lIndex >= lost.length || sNum != lost[lIndex]) {
                answer++;

            } else {
                for (; rIndex < reserve.length; rIndex++) {
                    if (Math.abs(sNum - reserve[rIndex]) <= 1) {
                        answer++;
                        rIndex++;
                        break;

                    } else if (sNum < reserve[rIndex]) {
                        break;
                    }
                }

                lIndex++;
            }
        }

        return answer;
    }
}
