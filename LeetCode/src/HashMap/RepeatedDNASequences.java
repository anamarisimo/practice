package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    private final int sequenceLength = 10;
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> sequenceMap = new HashMap<>();

        int lastPossibleSequenceStart = s.length() - sequenceLength;
        int currentCharNumber = 0;

        if(s.length() < sequenceLength)
            return result;

        StringBuilder currentWord = new StringBuilder(s.substring(0,10));

        while(canBeStartOfSequence(currentCharNumber, lastPossibleSequenceStart))
        {
            String currentWordStr = currentWord.toString();
            Integer currentWordMapOccurences =  sequenceMap.get(currentWordStr);
            boolean isInMap = currentWordMapOccurences!=null;
            if(!isInMap)
            {
                sequenceMap.put(currentWordStr,1);
            }
            else if(isInMap && currentWordMapOccurences == 1)
            {
                result.add(currentWordStr);
                sequenceMap.put(currentWordStr,2);
            }

            currentCharNumber++;
            currentWord = getNextWord(currentCharNumber, lastPossibleSequenceStart, currentWord, s);
        }

        return result;
    }

    private boolean canBeStartOfSequence(int charNumber, int lastPossibleSequenceStart)
    {
        if(charNumber <= lastPossibleSequenceStart)
            return true;
        else
            return false;
    }

    private StringBuilder getNextWord(int currentChrNo, int lastPossibleSequenceStart, StringBuilder current, String s)
    {
        char lastChr = ' ';
        if(canBeStartOfSequence(currentChrNo, lastPossibleSequenceStart))
        {
            lastChr = s.charAt(currentChrNo + sequenceLength-1);
        }
        StringBuilder result = current.deleteCharAt(0).append(lastChr);
        return result;
    }
}
