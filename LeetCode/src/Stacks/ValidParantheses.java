package Stacks;

import java.util.HashMap;
import java.util.Stack;

class ValidParantheses {
    public boolean isValid(String s)
    {
        Stack<Character> needStack = new Stack<Character>();
        HashMap<Character,Character> opposites = new HashMap<Character, Character>();
        opposites.put('(', ')');
        opposites.put('[', ']');
        opposites.put('{', '}');

        for(int i =0; i<s.length(); i++)
        {
            char character = s.charAt(i);
            if(isClosing(character))
            {
                if(needStack.size() > 0)
                {
                    char matching = needStack.pop();
                    if(matching!=character)
                        return false;
                }
                else return false;
            }
            else
            {
                needStack.push(opposites.get(character));
            }
        }
        if(needStack.size() == 0)
            return true;
        else
            return false;

    }

    private boolean isClosing(char c)
    {
        if(c == '}' || c == ']' || c == ')')
            return true;
        else
            return false;
    }
}
