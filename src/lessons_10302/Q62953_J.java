package lessons_10302;

import org.junit.Assert;

public class Q62953_J {
    public static void main(String[] args) {
        Q62953_J main = new Q62953_J();

        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Assert.assertEquals(30, main.solution(arr));
    }

    public int solution(int[][] triangle) {

        int answer = 0;

        for (int row = 1; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {

                if (col == 0) {
                    triangle[row][col] = triangle[row][col] + triangle[row - 1][col];

                } else if (row == col) {
                    triangle[row][col] = triangle[row][col] + triangle[row - 1][col - 1];

                } else {
                    int leftSum = triangle[row][col] + triangle[row - 1][col - 1];
                    int rightSum = triangle[row][col] + triangle[row - 1][col];
                    triangle[row][col] = Math.max(leftSum, rightSum);
                }

                answer = Math.max(answer, triangle[row][col]);

            }
        }

        return answer;
    }
}
