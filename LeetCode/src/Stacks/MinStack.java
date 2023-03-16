package Stacks;

import java.util.ArrayDeque;

class StackNode
{
    int val;
    StackNode next;
    public StackNode(int val, StackNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class MinStack {

    private StackNode top;
    private ArrayDeque<Integer> minHistory;

    public MinStack() {
        minHistory = new ArrayDeque<Integer>();
    }

    public void push(int val)
    {
        StackNode newTop;
        if(top == null)
        {
            newTop = new StackNode(val, null);
            minHistory.addFirst(newTop.val);
        }
        else
        {
            newTop = new StackNode(val, top);
            if(minHistory.peek()!=null && newTop.val <= minHistory.peek())
                minHistory.addFirst(newTop.val);
        }
        top = newTop;
    }

    public void pop() {
        if(top!=null)
        {
            if(top.val == minHistory.peek())
                minHistory.poll();
            top = top.next;
        }
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return minHistory.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
