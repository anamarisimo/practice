package Queue;

import java.util.LinkedList;

public class MovingAverageFromDataStream {
    private int _size = 0;
    private LinkedList<Integer> queue;
    private int currentSum = 0;
    private int currentCount = 0;

    public MovingAverageFromDataStream(int size)
    {
        _size = size;
        queue = new LinkedList<Integer>();
    }

    public double next(int val)
    {

        if(queue.size() < _size)
        {
            queue.add(val);
        }
        else
        {
            currentSum = currentSum - queue.poll();
            queue.add(val);
            currentCount--;

        }
        currentSum = currentSum + val;
        currentCount++;
        return currentSum/(double)currentCount;
    }
}
