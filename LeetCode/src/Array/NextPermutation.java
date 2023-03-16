package Array;

import java.util.Arrays;

public class NextPermutation
{
    public void nextPermutation(int[] nums)
    {
        int positionSmaller = findFirstDecreasingNumberPositionFromEnd(nums);
        System.out.println(positionSmaller);
        if(positionSmaller==-1)
        {
            Arrays.sort(nums);
            return;
        }

        int positionLarger = findPositionOfMinNextAfterCurrent(positionSmaller, nums);
        System.out.println(positionLarger);
        swapNumbers(positionSmaller, positionLarger, nums);
        reverseNumbersAfterPosition(positionSmaller,nums);
    }

    public void reverseNumbersAfterPosition(int position, int[] nums)
    {
        int i=position+1;
        int j=nums.length -1;
        while(i<j)
        {
            if(nums[i] == nums[j])
            {
                i++;
                continue;
            }
            if(nums[i] > nums[j])
            {
                swapNumbers(i,j,nums);
                j--;
            }
            if(nums[i] < nums[j])
            {
                i++;
            }


        }
    }

    public void swapNumbers(int positionSmaller,int positionLarger, int[] nums)
    {
        int aux = nums[positionSmaller];
        nums[positionSmaller] = nums[positionLarger];
        nums[positionLarger] = aux;
    }

    public int findPositionOfMinNextAfterCurrent(int position, int[] nums)
    {
        int currentNumber = nums[position];
        int minNextPosition=position+1;
        for(int i=position+1; i<nums.length;i++)
        {
            if(nums[i] <= nums[minNextPosition] && nums[i] > currentNumber)
                minNextPosition=i;
        }
        return minNextPosition;
    }

    public int findFirstDecreasingNumberPositionFromEnd(int[] nums)
    {
        for(int i=nums.length -1;i>=0;i--)
        {
            if(i-1 >= 0 && nums[i] > nums[i-1])
                return i-1;
        }
        return -1;
    }
}
