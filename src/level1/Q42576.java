package level1;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Iterator;

public class Q42576 {
    public static void main(String[] args) {
        Q42576 main = new Q42576();

        Assert.assertEquals("leo", main.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"kiki", "eden"}));
        Assert.assertEquals("vinko", main.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        Assert.assertEquals("mislav", main.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            if (map.containsKey(c)) {
                int cCount = map.get(c);
                if (cCount > 1) {
                    map.replace(c, cCount - 1);
                } else {
                    map.remove(c);
                }
            }
        }

        return map.keySet().iterator().next();
    }
}
