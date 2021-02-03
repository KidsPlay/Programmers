package level2;

import org.junit.Assert;

public class Q42860_J {
    public static void main(String[] args) {
//        int a = 'A';
//        int z = 'Z';
//        int middle = (a + z) / 2;
//        System.out.println(a);
//        System.out.println(z);
//        System.out.println(middle);

        Q42860_J main = new Q42860_J();

        Assert.assertEquals(56, main.solution("JEROEN"));
        Assert.assertEquals(23, main.solution("JAN"));
    }

    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            //방향 이동
            //A가 연속으로 이어진 개수가 arr.length / 2 이상이면 거꾸로 가는게 더 빠르다.

            if(i != 0 && arr[i] != 'A'){
                answer++;
            }

            //알파벳 변환 확인
            if (arr[i] <= 'N') {
                answer += arr[i] - 'A';
            } else {
                answer += 'Z' - arr[i] + 1;
            }
        }

        return answer;
    }
}
