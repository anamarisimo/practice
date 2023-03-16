package HashSet;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        int[] result = new int[getMinLength(nums1,nums2)];
        HashSet<Integer> n2Set = arrayToHashSet(nums2);
        HashSet<Integer> n1Set = arrayToHashSet(nums1);

        int resIndex= 0;
        for(int item : n1Set)
        {
            if(n2Set.contains(item))
            {
                result[resIndex]=item;
                resIndex++;
            }
        }

        return Arrays.copyOf(result,resIndex);
    }

    private HashSet<Integer> arrayToHashSet(int[] arr)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i< arr.length; i++)
        {
            set.add(arr[i]);
        }
        return set;
    }

    private int getMinLength(int[] arr1, int[] arr2)
    {
        if(arr1.length< arr2.length)
            return arr1.length;
        else
            return arr2.length;
    }
}
