public class PriorityQueueMax {
    private int[] prioQueue;
    private int NrElements = 0;

    public PriorityQueueMax(int maxLength) {
        prioQueue = new int[maxLength];
    }

    public int getMax() {
        return prioQueue[0];
    }

    public void insert(int element) {
        prioQueue[NrElements++] = element;
        moveUpElement(NrElements-1);
    }

    public void deleteMax() {
        replaceFirstElementWithLast();
        moveDownElement(0);
    }
    //sink
    private void moveDownElement(int position)
    {
        if(position*2 <= NrElements && position*2+1 <= NrElements){
            int childPositionWithMaxValue = getMaxValue(prioQueue[position*2],prioQueue[position*2+1]);
            if(prioQueue[position] < childPositionWithMaxValue)
            {
                swapInPrioQueue(position, childPositionWithMaxValue);
                moveDownElement(childPositionWithMaxValue);
            }
        }
    }

    //swim
    private void moveUpElement(int position) {
        if ((position == 2 || position == 1 ||  position == 0) && prioQueue[position] > prioQueue[0])
        {
            swapInPrioQueue(position, 0);
        }
        if (position % 2 == 0 && prioQueue[position] > prioQueue[position / 2])
        {
            swapInPrioQueue(position, position / 2);
            moveUpElement(position / 2);
        }
        else if (position % 2 != 0 && prioQueue[position] > prioQueue[(position - 1) / 2])
        {
            swapInPrioQueue(position, (position - 1) / 2);
            moveUpElement((position - 1) / 2);
        }
    }

    private void swapInPrioQueue(int position1, int position2) {
        int aux = prioQueue[position1];
        prioQueue[position2] = prioQueue[position1];
        prioQueue[position1] = aux;
    }

    private void replaceFirstElementWithLast()
    {
        prioQueue[0] = prioQueue[NrElements-1];
    }

    private int getMaxValue(int position1, int position2)
    {
        if(prioQueue[position1] > prioQueue[position2])
            return position1;
        else
            return position2;
    }

}
