public class ReverseString {
    public static String rev01(String toReverse) {
        return new StringBuilder(toReverse).reverse().toString();
    }
    public static void rev02(char[] s) {
        int left = 0, right = s.length-1;
        while(left < right) {
            char temp = s[right];
            s[right--] = s[left]; // dynamic scope
            s[left++] = temp;
        }

    }
    public static String rev03(String str) {
        byte[] s = str.getBytes();
        int left = 0, right = s.length-1;
        while(left < right) {
            byte temp = s[right];
            s[right--] = s[left]; // dynamic scope
            s[left++] = temp;
        }
        return new String(s);

    }
    public static void main(String[] args) {
        System.out.println("woWwoW".equals(rev01("WowWow")));
        char[] s = {'W','o','w', 'W','o','w'};
        rev02(s);
        System.out.println("woWwoW".equals(new String(s)));
        System.out.println("woWwoW".equals(rev03("WowWow")));
    }
}
