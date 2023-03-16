public class MergeSort
{
    private int[] auxArr;
    private InsertionSort insSort = new InsertionSort();
    public void sort(int[] arr)
    {
        auxArr = new int[arr.length];
        for (int i=0; i<arr.length;i++ )
        {
            auxArr[i] = arr[i];
        }
        mergeSortTop(arr, 0, arr.length-1);
    }

    public void mergeSortTop(int[] arr, int low, int high)
    {
        if(low<high){
            if(high-low+1 > 10)
            {
                int mid = (low+high)/2;
                mergeSortTop(arr, low, mid);
                mergeSortTop(arr, mid+1, high);
                merge(arr, low, mid, high);
            }
            else insSort.sortSection(arr, low, high);

        }
    }

    public void mergeSortBottom(int[] arr)
    {
        int i = 1;
        int low=0;
        int mid=0;
        int high=0;
        while(i < arr.length)
        {
            while(low < arr.length - i)
            {
                mid = low + i - 1;
                high = high+i*2-1;
                if(high > arr.length)
                    high = arr.length-1;

                merge(arr, low, mid, high);

                low = low+i*2;

            }
            i = i*2;
        }
    }

    public void merge(int[] arr, int low, int mid, int high)
    {
        int i=low;
        int j=mid+1;
        for(int position=low; position<=high; position++)
        {
            if(i>mid && j<=high)
                auxArr[position] = arr[j++];
            else if(i<=mid && j>high)
                auxArr[position] = arr[i++];
            else if(arr[i]<arr[j])
                auxArr[position] = arr[i++];
            else
                auxArr[position] = arr[j++];
        }

        for (int y=low; y<=high;y++ )
        {
            arr[y] = auxArr[y];
        }
    }
}
