package level1;

import org.junit.Assert;

import java.util.*;

public class Q42578_J {
    public static void main(String[] args) {
        Q42578_J main = new Q42578_J();

        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Assert.assertEquals(5, main.solution(arr));

        arr = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Assert.assertEquals(3, main.solution(arr));
    }

    public int solution(String[][] clothes) {

        Map<String, Integer> hm = new HashMap<>();
        for (String[] cloth : clothes) {
            String clothType = cloth[1];
            hm.put(clothType, hm.getOrDefault(clothType, 0) + 1);
        }

        int answer = 1;

        for (Integer integer : hm.values()) {
            answer *= integer + 1;
        }

        return answer - 1;
    }
}
