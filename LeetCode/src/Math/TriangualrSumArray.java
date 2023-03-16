package Math;

//GRESIT - FACE OVERFLOW

public class TriangualrSumArray {
    public int triangularSum(int[] nums)
    {
        long result = 0;
        int n = nums.length-1;
        int currentCombination = 1;

        for(int i=0; i< nums.length; i++)
        {
            System.out.println((long)nums[i] * (long)currentCombination);
            System.out.println("----");

            long comb = nums[i] * currentCombination;
            System.out.println(Long.sum(result, comb));
            System.out.println("----");
            result = Long.sum(result, comb);
            currentCombination = currentCombination * (n-i)/(i+1);
            System.out.println(result);
        }

        return (int)(result % 10);

    }
}
