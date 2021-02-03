package level1;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class Q72410_J {
    public static void main(String[] args) {
        Q72410_J main = new Q72410_J();

        Assert.assertEquals("bat.y.abcdefghi", main.solution("...!@BaT#*..y.abcdefghijklm"));
        Assert.assertEquals("z--", main.solution("z-+.^."));
        Assert.assertEquals("aaa", main.solution("=.="));
        Assert.assertEquals("123_.def", main.solution("123_.def"));
        Assert.assertEquals("abcdefghijklmn", main.solution("abcdefghijklmn.p"));
    }

    public String solution(String new_id) {
        return getRecommendId(new_id);
    }

    private String getRecommendId(String new_id) {
        char[] arr = new_id.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : arr) {
            list.add(c);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            char c = list.get(i);
            //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            if (c >= 'A' && c <= 'Z') {
                list.set(i, (char) (c + ('a' - 'A')));
            }

            c = list.get(i);
            //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            if (!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && c != '-' && c != '_' && c != '.') {
                list.remove(i);
                i = Math.min(++i , list.size() - 1);
                continue;
            }

            //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            if (i > 0 && c == '.' && list.get(i - 1) == '.') {
                list.remove(i);
                i = Math.min(++i , list.size() - 1);
            }
        }

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (list.size() > 0 && list.getFirst() == '.') {
            list.removeFirst();
        }
        if (list.size() > 0 && list.getLast() == '.') {
            list.removeLast();
        }

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(list.size() == 0){
            list.add('a');
        }

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        while(list.size() > 15){
            list.removeLast();
        }
        while(list.size() > 0 && list.getLast() == '.'){
            list.removeLast();
        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(list.size() <= 2){
            list.add(list.getLast());
        }

        return getStr(list);
    }

    private String getStr(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
