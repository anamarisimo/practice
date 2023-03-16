package SlidingWindow;

public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates(int[] nums)
    {
        int slowPointer = 0;
        int fastPointer = 1;
        int uniqueCount = 1;
        while(fastPointer<nums.length)
        {
            while(fastPointer<nums.length && nums[slowPointer] == nums[fastPointer])
                fastPointer++;
            if(fastPointer-slowPointer==1 && nums[slowPointer] != nums[fastPointer])
            {
                slowPointer++;
                fastPointer++;
                uniqueCount++;
            }
            else if(fastPointer<nums.length)
            {
                nums[slowPointer+1] = nums[fastPointer];
                slowPointer++;
                fastPointer++;
                uniqueCount++;
            }

        }
        return uniqueCount;
    }
}
