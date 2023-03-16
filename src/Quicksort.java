import java.util.Random;

public class Quicksort
{
    InsertionSort sort = new InsertionSort();
    public void sort(int[] numbers)
    {
        quickSort(numbers, 0, numbers.length-1);
    }

    public void quickSort3Way(int[] numbers, int low, int high)
    {
        if(low<high)
        {
            int left = low;
            int right = high;
            int i = low+1;
            int val = numbers[low];

            while(i<=right)
            {
                if(numbers[i] < val)
                    swap(numbers, i++, left++);
                else if(numbers[i] > val)
                    swap(numbers, i, right--);
                else
                    i++;
            }
            quickSort3Way(numbers, low, left-1);
            quickSort3Way(numbers, right+1, high);
        }


    }

    private void quickSort(int[] numbers, int low, int high)
    {
        if(low<high)
        {
            if(high-low+1 > 10)
            {
                int pivot = partition(numbers, low, high);
                quickSort(numbers, low, pivot-1);
                quickSort(numbers, pivot+1, high);
            }
            else
                sort.sortSection(numbers, low, high);
        }
    }

    private int partition(int[] numbers, int low, int high)
    {
        int pivotPosition = getRandomPivotMedianOf3(numbers, low, high);
        swap(numbers, pivotPosition, low);
        int left = low;
        int right = high+1;
        int pivot = numbers[low];
        while(true)
        {
            left++;
            right--;
            while(left < high && numbers[left]<pivot) left++;
            while(right > low && numbers[right]>pivot) right--;
            if(left>=right)
            {
                swap(numbers, low, right);
                break;
            }
            else
                swap(numbers, left, right);
        }
        return right;
    }

    private int getRandomPivotMedianOf3(int[] numbers, int low, int high)
    {
        int random1 = new Random().nextInt(numbers.length);
        int random2 = new Random().nextInt(numbers.length);
        int random3 = new Random().nextInt(numbers.length);

        if ((random3 >= random1 && random3 <= random2) || (random3 <= random1 && random3 >= random2))
            return random3;
        else if ((random2 >= random1 && random2 <= random3) || (random2 <= random1 && random2 >= random3))
            return random2;
        else
            return random1;
    }
    private void swap(Comparable[] numbers, int pos1,int pos2)
    {
        Comparable aux = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = aux;
    }

    private void swap(int[] numbers, int pos1,int pos2)
    {
        int aux = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = aux;
    }
}
