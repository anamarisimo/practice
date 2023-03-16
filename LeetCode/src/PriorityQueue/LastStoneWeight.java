package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight
{
    public int lastStoneWeight(int[] stones)
    {

        PriorityQueue<Integer> weights = arrayToPriorityQueue(stones);
        while(weights.size() > 1)
        {
            int weight1 = weights.poll();
            int weight2 = weights.poll();
            if(weight1 > weight2)
                weights.add(weight1 - weight2);
            else if( weight2 > weight1)
                weights.add(weight2 - weight1);
        }
        if(weights.size() == 0)
            return 0;
        else return weights.poll();
    }

    public PriorityQueue<Integer> arrayToPriorityQueue(int[] arr)
    {
        PriorityQueue<Integer> result = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int item : arr)
        {
            result.add(item);
        }
        return result;
    }
}
