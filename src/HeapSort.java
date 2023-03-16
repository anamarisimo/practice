public class HeapSort {
    public int[] sortArray(int[] nums)
    {
        int[] heap = buildMaxHeap(nums);
        for (int j : heap) {
            System.out.print(j);
            System.out.print(" ");
        }
        heapsort(heap);
        return heap;
    }

    public void heapsort(int[] heap)
    {
        int lastIndex = heap.length-1;
        while(lastIndex >= 1)
        {
            swap(heap, 0, lastIndex);
            if(lastIndex!=1)
            sink(heap, 0, lastIndex);
            lastIndex--;
        }
    }

    public int[] buildMaxHeap(int[] nums)
    {
        int elementToSink = (nums.length-2) / 2;
        while(elementToSink>=0)
        {
            sink(nums, elementToSink, nums.length);
            elementToSink--;
        }
        return nums;
    }

    public void sink(int[] heap, int element, int len)
    {

        int currentPosition = element;

        while(currentPosition < len/2)
        {
            int child1 = heap[(currentPosition+1)*2-1];
            int child2;
            if((currentPosition+1)*2 > len-1)
            {
                if(heap[currentPosition] >= child1)
                    return;
                else
                {
                    swap(heap, currentPosition, (currentPosition+1)*2-1);
                    return;
                }
            }
            child2 = heap[(currentPosition+1)*2];
            if(heap[currentPosition] >= child1 && heap[currentPosition] >= child2)
                return;
            else if(child1 >= child2)
            {
                swap(heap, currentPosition, (currentPosition+1)*2-1);
                currentPosition = (currentPosition+1)*2-1;
            }
            else
            {
                swap(heap, currentPosition, (currentPosition+1)*2);
                currentPosition = (currentPosition+1)*2;
            }

        }
    }

    public void swap(int[] heap, int el1, int el2)
    {
        int temp = heap[el2];
        heap[el2]=heap[el1];
        heap[el1]=temp;
    }
}
