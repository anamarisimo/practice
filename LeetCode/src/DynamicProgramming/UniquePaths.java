package DynamicProgramming;

import java.math.BigInteger;

public class UniquePaths {
    public int uniquePaths(int m, int n)
    {
        int[][] numberPaths = new int[m][n];
        numberPaths[0][0] = 1;


        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i-1>=0)
                    numberPaths[i][j]= numberPaths[i-1][j];
                if(j-1>=0)
                    numberPaths[i][j] =numberPaths[i][j] + numberPaths[i][j-1];
            }
        }
        return numberPaths[m-1][n-1];
    }

    public int uniquePathsCombinariConstantSpace(int m, int n)
    {
        int downNeeded = m-1;
        int positions = m-1 + n-1;
        int number = positions;

        BigInteger duplicates = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;

        while(number > positions-downNeeded)
        {
            result = result.multiply(BigInteger.valueOf(number--));
        }

        while(downNeeded>1)
        {
            duplicates = duplicates.multiply(BigInteger.valueOf(downNeeded--));
        }

        System.out.println(result);
        System.out.println(duplicates);
        BigInteger res = result.divide(duplicates);
        return res.intValue();

    }
}
