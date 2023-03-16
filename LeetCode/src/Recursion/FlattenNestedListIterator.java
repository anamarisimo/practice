package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
    /*
    int mainIndex = 0;
    Stack<Integer> currentIndexPositions = new Stack<>();
    List<NestedInteger> nestedListLocal;
    List<Integer> nums = new ArrayList<>();
    int numsIndex = -1;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList, 0);
    }


    private void flatten(List<NestedInteger> nestedList, int currentIndex)
    {
        if(currentIndex >= nestedList.size())
        {
            return;
        }
        if(nestedList.get(currentIndex).isInteger())
        {
            nums.add(nestedList.get(currentIndex).getInteger());
            currentIndex++;
            flatten(nestedList, currentIndex);
        }
        else
        {
            flatten(nestedList.get(currentIndex).getList(), 0);
            flatten(nestedList, currentIndex+1);
        }
    }


    @Override
    public Integer next() {

        numsIndex++;
        return nums.get(numsIndex);
    }

    @Override
    public boolean hasNext() {
        if(numsIndex == nums.size()-1)
            return false;
        else
            return true;
    }
    */
}
