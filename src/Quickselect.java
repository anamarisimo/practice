import java.util.Random;

public class Quickselect
{
    public int findKthLargest(int[] nums, int k)
    {
        return quickSelect(nums, 0, nums.length-1, k);
    }

        private int quickSelect(int[] arr, int low, int high, int k)
        {
            if(low == high)
            {
                if(arr.length - k == low)
                    return arr[low];
            }
            if(low > high)
                return -1;
            int pivotIndex = partition(arr, low, high);
            if(pivotIndex == arr.length - k)
                return arr[pivotIndex];
            else if(pivotIndex < arr.length - k)
                return quickSelect(arr, pivotIndex+1, high, k);
            else
                return quickSelect(arr, low, pivotIndex-1, k);
        }

    private int partition(int[] arr, int low, int high)
    {
        int lowIterPos = low;
        int highIterPos = high + 1;
        int pivotPosition = selectPivot(arr, low, high);
        exchangeArrayElements(arr, low, pivotPosition);
        int pivot = arr[low];
        while(true)
        {
            lowIterPos++;
            highIterPos--;
            while(arr[lowIterPos] < pivot && lowIterPos < high)
                lowIterPos++;
            while(arr[highIterPos] > pivot && highIterPos > low)
                highIterPos--;

            if(lowIterPos >= highIterPos)
                break;
            exchangeArrayElements(arr, lowIterPos,highIterPos);
        }
        exchangeArrayElements(arr, low,highIterPos);
        return highIterPos;
    }

        private int selectPivot(int[] arr, int low, int high)
        {
            Random random = new Random();
            return random.ints(low, high)
                    .findFirst()
                    .getAsInt();
        }
        private void exchangeArrayElements(int[] arr, int poz1, int poz2)
        {
            int aux = arr[poz1];
            arr[poz1]=arr[poz2];
            arr[poz2]=aux;
        }
}
