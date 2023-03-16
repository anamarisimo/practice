package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    private PriorityQueue<Integer> numbersSmallHalf;
    private PriorityQueue<Integer> numbersBigHalf;

    public MedianFromDataStream() {
        numbersSmallHalf = new PriorityQueue<>(Collections.reverseOrder());
        numbersBigHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        System.out.println(num);
        addNumberInAppropriateQueue(num);
        System.out.println(numbersBigHalf.size());
        System.out.println(numbersSmallHalf.size());
        rebalanceQueues();
    }

    private void rebalanceQueues()
    {
        if(numbersBigHalf.size()+ 2 == numbersSmallHalf.size())
            moveFromSmallToBig();
        else if(numbersSmallHalf.size() + 1 == numbersBigHalf.size())
            moveFromBigToSmall();
    }

    private void moveFromSmallToBig()
    {
        int item = numbersSmallHalf.poll();
        numbersBigHalf.add(item);
    }

    private void moveFromBigToSmall()
    {
        int item = numbersBigHalf.poll();
        numbersSmallHalf.add(item);
    }

    private void addNumberInAppropriateQueue(int num)
    {
        if(numbersSmallHalf.isEmpty() && numbersBigHalf.isEmpty())
        {
            numbersSmallHalf.add(num);
            return;
        }
        Integer small = numbersSmallHalf.peek();
        Integer big = numbersBigHalf.peek();

        if(numbersBigHalf.isEmpty())
        {
            if(num < small)
                numbersSmallHalf.add(num);
            else
                numbersBigHalf.add(num);
            return;
        }

        if(num > small && num > big)
        {
            numbersBigHalf.add(num);
        }

        else if(num < small && num < big)
        {
            numbersSmallHalf.add(num);
        }

        else
            numbersSmallHalf.add(num);
    }


    public double findMedian() {
        if(numbersBigHalf.size() + 1 == numbersSmallHalf.size())
        {
            return numbersSmallHalf.peek();
        }
        else
        {
            Double sum = Double.valueOf(numbersSmallHalf.peek() + numbersBigHalf.peek());
            return sum / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
