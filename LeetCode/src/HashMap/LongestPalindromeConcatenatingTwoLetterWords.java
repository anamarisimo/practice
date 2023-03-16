package HashMap;

import java.util.HashMap;

public class LongestPalindromeConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words)
    {
        HashMap<String, Integer> analyzedStrings = new HashMap<>();

        int result = 0;

        for(int i = 0; i< words.length; i++)
        {

            String reversed = getReversed(words[i]);
            if(analyzedStrings.containsKey(reversed))
            {
                if(analyzedStrings.get(reversed) == 1)
                    analyzedStrings.remove(reversed);
                else
                    analyzedStrings.put(reversed, analyzedStrings.get(reversed)-1);

                result = result + 4;
            }
            else
            {
                if(analyzedStrings.containsKey(words[i]))
                    analyzedStrings.put(words[i],analyzedStrings.get(words[i])+1);
                else
                    analyzedStrings.put(words[i],1);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=97; i<=122; i++)
        {
            sb.append(((char)i));
            sb.append(((char)i));

            if(analyzedStrings.containsKey(sb.toString()))
            {
                result = result+2;
                break;
            }
            sb.setLength(0);
        }

        return result;
    }

    private boolean isDuplicateLetter(String word)
    {
        if(word.charAt(0) == word.charAt(1))
            return true;
        else
            return false;
    }

    private String getReversed(String word)
    {
        return word.charAt(1) + word.substring(0,1);
    }
}
