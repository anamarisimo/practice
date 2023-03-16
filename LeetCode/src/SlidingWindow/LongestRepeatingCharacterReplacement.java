package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k)
    {
        int left = 0;
        int right = 0;
        int[] charCount = new int[26];
        int windowSize = 1;
        int result = 0;

        while(left <s.length() && right < s.length())
        {
            if(s.length() - left + 1 < result)
                break;
            charCount[s.charAt(right)-'A']++;

            int nrNeededReplacements = windowSize - findMaxOccurrence(charCount);
            if(nrNeededReplacements <= k)
            {
                if(result < windowSize)
                    result = windowSize;
                windowSize++;
                right++;
            }
            else
            {
                charCount[s.charAt(left)-'A']--;
                left++;
                windowSize--;
                if(left<s.length())
                {
                    charCount[s.charAt(right)-'A']--;
                }
            }
        }
        return result;
    }

    private int findMaxOccurrence(int[] charCount)
    {
        int count = 0;
        for(int i =0; i<26; i++)
        {
            if(charCount[i] > count)
                count = charCount[i];
        }
        return count;
    }
}
