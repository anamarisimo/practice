package SlidingWindow;

import java.util.HashSet;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s)
    {
        if(s.length() == 0)
            return s;
        HashSet<Character> chars = new HashSet<>();

        for(int i=0; i< s.length(); i++)
            chars.add(s.charAt(i));

        int i=0;
        for(; i< s.length(); i++)
        {

            if(chars.contains(Character.toLowerCase(s.charAt(i))) && chars.contains(Character.toUpperCase(s.charAt(i))))
                continue;
            else
                break;
        }
        if(i == s.length())
            return s;

        String right = longestNiceSubstring(s.substring(i+1));
        String left = longestNiceSubstring(s.substring(0, i));
        return right.length() > left.length() ? right : left;

    }
}
