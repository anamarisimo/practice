package Array;

public class ContainerWithMostWater {
    public int maxArea(int[] height)
    {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left<right && right<height.length)
        {
            int heightContainer = Math.min(height[left], height[right]);
            int widthContainer = right-left;

            if(heightContainer*widthContainer > maxArea)
                maxArea = heightContainer*widthContainer;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
