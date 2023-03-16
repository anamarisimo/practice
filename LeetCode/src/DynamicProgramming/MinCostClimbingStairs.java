package DynamicProgramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost)
    {
        int[] minCost = new int[cost.length+1];
        minCost[0] = 0;
        minCost[1] = 0;

        for(int i=2; i<minCost.length; i++)
        {
            minCost[i] = Math.min(minCost[i-2]+cost[i-2], minCost[i-1]+cost[i-1]);
        }

        return minCost[minCost.length-1];
    }

    public int minCostClimbingStairsConstantSpace(int[] cost)
    {
        int previous2steps = 0;
        int previous1step = 0;

        for(int i=2; i<=cost.length; i++)
        {
            int temp = previous1step;
            previous1step = Math.min(previous1step+cost[i-1], previous2steps+cost[i-2]);
            previous2steps = temp;
        }

        return previous1step;
    }
}
