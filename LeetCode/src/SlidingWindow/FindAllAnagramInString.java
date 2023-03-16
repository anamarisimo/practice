package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramInString {
    public List<Integer> findAnagrams(String s, String p)
    {
        HashMap<Character, Integer> charFreqs = new HashMap<>();
        int pLength = p.length();
        List<Integer> positions = new ArrayList<>();
        for(int i=0;i<p.length();i++)
        {
            if(charFreqs.containsKey(p.charAt(i)))
                charFreqs.put(p.charAt(i),charFreqs.get(p.charAt(i))+1);
            else
                charFreqs.put(p.charAt(i),1);
        }

        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();

        int i = 0;

        while(i<s.length())
        {
            if(temp.containsKey(s.charAt(i)))
            {
                temp.put(s.charAt(i), temp.get(s.charAt(i))+1);
            }
            else
                temp.put(s.charAt(i), 1);

            if(i >= pLength)
            {
                char charAt = s.charAt(i - p.length());
                if(temp.containsKey(charAt))
                {
                    int val = temp.get(charAt);
                    if(val == 1)
                        temp.remove(charAt);
                    else
                        temp.put(charAt, val-1);

                }
            }
            if(temp.equals(charFreqs))
            {
                positions.add(i - p.length() + 1);
            }
            i++;
        }
        return positions;
    }
}
