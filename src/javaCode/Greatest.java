public class Greatest {
    public static int theGreatest(int... vars) {
        int greatest = 0;
        for (int e : vars) {
            // if e greater than greatest then bind greatest to e else bind greatest to greatest
            greatest = (e > greatest) ? e : greatest;
        }
        return greatest;
    }
    public static int greatestOfThree(int num1, int num2, int num3) {
        int[] vars = {num1,num2,num3};
        int greatest = 0;
        for (int e : vars) {
            // if e greater than greatest then bind greatest to e else bind greatest to greatest
            greatest = (e > greatest) ? e : greatest;
        }
        return greatest;
    }

        public static void main(String[] args) {

        System.out.println(7 == theGreatest(1,2,3,4,5,6,7));
        System.out.println(8 == greatestOfThree(3,8,2));
    }
}
