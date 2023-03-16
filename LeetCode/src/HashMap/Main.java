package HashMap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testRelativeRanks();
    }

    private static void testRelativeRanks(){
        System.out.println(Float.floatToIntBits(1.365f));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(1.365f)));
        System.out.println(Long.toBinaryString(30147483700L));
        RelativeRanks ranks = new RelativeRanks();
        String[] result1 = ranks.findRelativeRanks(new int[]{5,4,3,2,1});
        String[] result2 = ranks.findRelativeRanks(new int[]{10,3,8,9,4});

        if(Arrays.equals(result1, new String[]{"Gold Medal","Silver Medal","Bronze Medal","4","5"})
                && Arrays.equals(result2, new String[]{"Gold Medal","5","Bronze Medal","Silver Medal","4"}))
            System.out.println("results correct");
        else
            System.out.println("results incorrect");
    }
}
