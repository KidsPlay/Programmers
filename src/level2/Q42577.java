package level2;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.Comparator;

public class Q42577 {

    public static void main(String[] args) {
        Q42577 main = new Q42577();

        MatcherAssert.assertThat(main.solution(new String[]{"119", "97674223", "1195524421"}), Matchers.is(false));
        MatcherAssert.assertThat(main.solution(new String[]{"123", "456", "789"}), Matchers.is(true));
        MatcherAssert.assertThat(main.solution(new String[]{"12", "123", "1235", "567", "88"}), Matchers.is(false));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length; i++) {
            String basedPhoneNumber = phone_book[i];

            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(basedPhoneNumber)) {
                    return false;
                }
            }
        }

        return true;
    }
}
