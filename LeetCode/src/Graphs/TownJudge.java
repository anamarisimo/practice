package Graphs;

public class TownJudge {
    public int findJudge(int n, int[][] trust)
    {
        if(trust.length < n-1)
            return -1;
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];

        for(int i=0;i<trust.length; i++)
        {
            outDegrees[trust[i][0]]++;
            inDegrees[trust[i][1]]++;
        }

        for(int i=1; i<=n;i++)
        {
            if(inDegrees[i]==n-1 && outDegrees[i]==0)
                return i;
        }
        return -1;
    }
}
