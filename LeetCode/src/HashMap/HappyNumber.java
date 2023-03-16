package HashMap;

import java.util.HashSet;

public class HappyNumber
{
    public boolean isHappy(int n)
    {
        HashSet<Integer> seen = new HashSet<Integer>();

        int currentSum = n;

        while(currentSum!=1)
        {
            currentSum = getDigitsSum(currentSum);
            if(seen.contains(currentSum))
                return false;
            else
                seen.add(currentSum);
        }
        return true;

    }

    private int getDigitsSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int lastDigit = n%10;
            sum = sum + (lastDigit*lastDigit);
            n=n/10;
        }
        return sum;
    }
}
