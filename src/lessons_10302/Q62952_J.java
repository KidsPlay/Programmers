package lessons_10302;

import org.junit.Assert;

import java.util.Stack;

public class Q62952_J {
    public static void main(String[] args) {
        Q62952_J main = new Q62952_J();

        Assert.assertEquals(2, main.solution(2));
        Assert.assertEquals(5, main.solution(3));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int n) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(n - 1, n));

        int answer = 0;

        while (!stack.isEmpty()) {
            Point p = stack.pop();

            if (p.x == 0 && p.y == 0) {
                answer++;
            }

            // x 보다 y가 더 작아지면 안된다.
            if (p.x > 0) {
                stack.push(new Point(p.x - 1, p.y));
            }

            if (p.y > 0 && p.y > p.x) {
                stack.push(new Point(p.x, p.y - 1));
            }
        }


        return answer;
    }
}
