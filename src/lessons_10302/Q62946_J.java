package lessons_10302;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class Q62946_J {
    public static void main(String[] args) {
        Q62946_J main = new Q62946_J();

        Assert.assertEquals(3, main.solution(11, new int[]{4, 11}, 1));
        Assert.assertEquals(3, main.solution(16, new int[]{9}, 2));
    }

    public int solution(int n, int[] stations, int w) {

        int answer = 0;
        int position = 1;
        int sIndex = 0;

        while (position <= n) {
            if (sIndex < stations.length && stations[sIndex] - w <= position) {
                position = stations[sIndex] + w + 1;
                sIndex++;
            } else {
                answer++;
                position += w * 2 + 1;
            }
        }

        return answer;
    }

    private void checkPoint(boolean[] arr, int station, int w) {
        int startIndex = station - w;
        if (startIndex <= 0) {
            startIndex = 0;
        }

        int endIndex = station + w;
        if (endIndex >= arr.length) {
            endIndex = arr.length - 1;
        }

        for (; startIndex <= endIndex; startIndex++) {
            arr[startIndex] = true;
        }
    }
}
