package Array;

import java.util.Arrays;

public class AllCharactersUniqueInString {
    //assuming ASCII code
    private final boolean[] charList = new boolean[128];
    public boolean hasAllCharsUnique(String text)
    {
        if(hasExpectedSize(text))
        {
            return allCharsValidatedAsUnique(text);
        }
        return false;
    }

    private boolean allCharsValidatedAsUnique(String text)
    {
        for(int i=0; i<text.length(); i++)
        {
            if(isCharSeen(text.charAt(i)))
            {
                return false;
            }
            else
                markCharAsSeen(text.charAt(i));
        }
        return true;
    }


    private void markCharAsSeen(char chr)
    {
        charList[chr] = true;
    }

    private boolean isCharSeen(char chr) {
        return charList[chr];
    }

    private boolean hasExpectedSize(String text) {
        return text.length() < charList.length;
    }
}
