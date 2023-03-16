package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrentONLogN(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> orderedNumbers = new PriorityQueue<Integer>();
        HashMap<Integer, ArrayList<Integer>> uniqueNumbers = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = uniqueNumbers.get(nums[i]);

            if (list == null) {
                list = new ArrayList<Integer>();
                list.add(i);
                orderedNumbers.add(nums[i]);
                uniqueNumbers.put(nums[i], list);
            } else {
                list.add(i);
            }
        }

        int counter = 0;

        while (orderedNumbers != null && orderedNumbers.size() > 0) {
            int number = orderedNumbers.poll();
            ArrayList<Integer> list = uniqueNumbers.get(number);
            for (int i = 0; i < list.size(); i++) {
                ans[list.get(i)] = counter;

            }
            counter = counter + list.size();
        }
        return ans;

    }

    public int[] smallerNumbersThanCurrentON(int[] nums) {
        int[] ans = new int[nums.length];
        int[] freqArr = new int[101];

        for (int i = 0; i < nums.length; i++) {
            freqArr[nums[i]] = freqArr[nums[i]] + 1;
        }

        int counter = 0;
        for (int i = 0; i < 101; i++) {
            if (freqArr[i] != 0) {
                counter = counter + freqArr[i];
                freqArr[i] = counter - freqArr[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = freqArr[nums[i]];
        }
        return ans;

    }
}
