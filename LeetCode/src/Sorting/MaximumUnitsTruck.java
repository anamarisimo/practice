package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        int maxUnits = 0;
        int currentNrBoxes = 0;


        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1]));

        for(int i = boxTypes.length - 1; i>=0; i--)
        {
            if(currentNrBoxes + boxTypes[i][0] > truckSize)
            {
                maxUnits = maxUnits + (truckSize - currentNrBoxes) * boxTypes[i][1];
                currentNrBoxes = truckSize;
                break;
            }
            else
            {
                currentNrBoxes = currentNrBoxes + boxTypes[i][0];
                maxUnits = maxUnits + boxTypes[i][0] * boxTypes[i][1];
            }

        }
        return maxUnits;
    }
}
