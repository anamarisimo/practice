package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score)
    {
        String[] result = new String[score.length];
        int[] copyScore = new int[score.length];
        HashMap<Integer, Integer> athleteScore = new HashMap<Integer,Integer>();

        for(int i=0; i<score.length; i++)
        {
            athleteScore.put(score[i], i);
            copyScore[i] = score[i];
        }
        Arrays.sort(copyScore);
        int counter=0;

        for(int i=copyScore.length-1; i>=0; i--)
        {
            int scoreInOrder = copyScore[i];
            int position = athleteScore.get(scoreInOrder);
            String rank;
            if(i==copyScore.length-1)
                rank = "Gold Medal";
            else if(i==copyScore.length-2)
                rank = "Silver Medal";
            else if(i==copyScore.length-3)
                rank = "Bronze Medal";
            else
                rank = Integer.toString(copyScore.length-i);
            result[position] = rank;
            counter++;
        }

        return result;
    }
}
