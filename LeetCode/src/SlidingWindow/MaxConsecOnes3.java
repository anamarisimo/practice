package SlidingWindow;

public class MaxConsecOnes3
{
    public int longestOnes(int[] nums, int k)
    {
        int right = 0;
        int left = 0;
        int flipped = 0;
        int seqLen=0;
        int max=0;

        while(right<nums.length)
        {
            if(nums[right] == 0)
            {
                if(flipped < k)
                {
                    flipped++; seqLen++; right++;
                }
                else
                {
                    while(left<nums.length && nums[left]==1)
                    {
                        left++; seqLen--;
                    }
                    left++; seqLen--; flipped--;
                }

            }
            else
            {
                right++; seqLen++;
            }

            if(seqLen > max)
                max = seqLen;
        }

        return max;
    }
}
