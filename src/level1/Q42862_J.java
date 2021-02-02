package level1;

import org.junit.Assert;

public class Q42862_J {
    public static void main(String[] args) {
        Q42862_J main = new Q42862_J();

        Assert.assertEquals(5, main.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        Assert.assertEquals(4, main.solution(5, new int[]{2, 4}, new int[]{3}));
        Assert.assertEquals(2, main.solution(3, new int[]{3}, new int[]{1}));
        Assert.assertEquals(3, main.solution(5, new int[]{1, 2, 4, 5}, new int[]{2, 3, 4}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        int answer = n;

        for (int l : lost) {
            students[l - 1]--;
        }

        for (int r : reserve) {
            students[r - 1]++;
        }

        //안가져온 자리는 -1, 추가로 가져온 자리는 1
        for (int i = 0; i < students.length; i++) {
            if (students[i] == -1) {
                if (i > 1 && students[i - 1] > 0) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i < students.length - 1 && students[i + 1] > 0) {
                    students[i]++;
                    students[i + 1]--;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }

//    public int solution(int n, int[] lost, int[] reserve) {
//        Set<Integer> lostSet = new HashSet<>();
//        Set<Integer> tempLostSet = new HashSet<>();
//        for (int l : lost) {
//            lostSet.add(l);
//            tempLostSet.add(l);
//        }
//
//        Set<Integer> reserveSet = new HashSet<>();
//        for (int r : reserve) {
//            reserveSet.add(r);
//        }
//
//        lostSet.removeAll(reserveSet);
//        reserveSet.removeAll(tempLostSet);
//
//        int answer = n;
//
//        for (int l : lostSet) {
//            if (!reserveSet.remove(l - 1) && !reserveSet.remove(l + 1)) {
//                answer--;
//            }
//        }
//
//        return answer;
//    }
}
