package HashMap;

import java.util.HashMap;

public class RomanToInteger
{
    public int romanToInt(String s)
    {
        HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);

        int sum = 0;
        char currentChar;
        int currentVal;
        char nextChar;
        int nextVal;
        char[] characters = s.toCharArray();

        for(int i=0; i<characters.length; i++)
        {
            currentChar = characters[i];
            currentVal = mapping.get(currentChar);
            if(i+1 < characters.length)
            {
                nextChar = characters[i+1];
                nextVal = mapping.get(nextChar);
                if(nextVal > currentVal)
                    currentVal = currentVal * (-1);
                sum = sum + currentVal;
            }
            else
                sum = sum + currentVal;
        }
        return sum;
    }
}
