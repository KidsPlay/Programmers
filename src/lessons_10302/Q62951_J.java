package lessons_10302;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class Q62951_J {
    public static void main(String[] args) {
        Q62951_J main = new Q62951_J();

        Assert.assertEquals(11, main.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));

        Assert.assertEquals(-1, main.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        }));
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = maps.length - 1;
        int m = maps[0].length - 1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        maps[0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tempX = node.x + dx[i];
                int tempY = node.y + dy[i];

                if (tempX < 0 || tempX > n || tempY < 0 || tempY > m) {
                    continue;
                }

                if (maps[tempX][tempY] == 1) {
                    maps[tempX][tempY] = maps[node.x][node.y] + 1;
                    queue.offer(new Node(tempX, tempY));
                }
            }
        }

        print(maps);
        System.out.println();

        return maps[n][m] != 1 ? maps[n][m] : -1;
    }

    private void print(int[][] maps) {
        for (int[] map : maps) {
            for (int i : map) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
