package lessons_10302;

import org.junit.Assert;

import java.util.Arrays;

public class Q62950_J {
    public static void main(String[] args) {
        Q62950_J main = new Q62950_J();

        Assert.assertEquals(
                5,
                main.solution(new String[][]{
                        {"yellow_hat", "headgear"},
                        {"blue_sunglasses", "eyewear"},
                        {"green_turban", "headgear"}
                }));

        Assert.assertEquals(
                3,
                main.solution(new String[][]{
                        {"crow_mask", "face"},
                        {"blue_sunglasses", "face"},
                        {"smoky_makeup", "face"}
                }));
    }

    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .map(c -> c[1])
                .distinct()
                .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
                .map(c -> c + 1)
                .reduce(1, (c, n) -> c * n) - 1;

//        Map<String, Integer> hm = new HashMap<>();
//
//        for (String[] cloth : clothes) {
//            String clothType = cloth[1];
//            hm.put(clothType, hm.getOrDefault(clothType, 0) + 1);
//        }
//
//        int answer = 1;
//
//        for (Integer count : hm.values()) {
//            answer *= count + 1;
//        }
//
//        return answer - 1;
    }
}
