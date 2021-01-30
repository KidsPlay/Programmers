package lessons_18;

import org.junit.Assert;

public class Q1876_J {
    public static void main(String[] args) {
        Q1876_J main = new Q1876_J();

        Assert.assertEquals(6, main.solution(123));
        Assert.assertEquals(24, main.solution(987));
    }

    public int solution(int n) {
        char[] charArr = String.valueOf(n).toCharArray();

        int answer = 0;
        for (char ch : charArr) {
            answer += ch - '0';
        }

        return answer;
    }
}
