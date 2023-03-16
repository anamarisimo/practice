
public class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(low <= high)
        {
            mid = (low+high)/2;

            if(target == nums[mid])
                return mid;

            if(target > nums[mid])
                low=mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}
