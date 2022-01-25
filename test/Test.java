package test;

public class Test {


    public int removePalindromeSub(String s) {
        //char[] cs = s.toCharArray();
        return isPalindrome(s, 0, s.length() - 1) ? 1 : 2;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) { return false; }
            start ++;
            end --;
        }
        return true;
    }



    public static void main(String[] args) {
        Test ins = new Test();
        System.out.println(ins.removePalindromeSub("babaa"));
    }
}
