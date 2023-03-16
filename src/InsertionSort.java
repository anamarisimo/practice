public class InsertionSort
{
    public void sort(int [] arr)
    {
        int curr = 1;

        while(curr < arr.length)
        {
            if(arr[curr] < arr[curr-1])
            {
                int valueToInsert = arr[curr];
                int i = curr-1;
                while(i >= 0 && valueToInsert < arr[i])
                {
                    arr[i+1] = arr[i];
                    i--;
                }
                arr[i+1] = valueToInsert;
            }
            curr++;
        }
    }
    public void sortSection(int [] arr, int low, int high)
    {
        int curr = low+1;

        while(curr <= high)
        {
            if(arr[curr] < arr[curr-1])
            {
                int valueToInsert = arr[curr];
                int i = curr-1;
                while(i >= 0 && valueToInsert < arr[i])
                {
                    arr[i+1] = arr[i];
                    i--;
                }
                arr[i+1] = valueToInsert;
            }
            curr++;
        }
    }
}
