package HashMap;

public class BullsCows {
    public String getHint(String secret, String guess)
    {
        int[] freq = new int[10];
        int bulls = 0;
        int cows = 0;

        for(int i=0; i< secret.length(); i++)
        {
            freq[Integer.parseInt(String.valueOf(secret.charAt(i)))]++;
        }

        for(int i=0; i< secret.length(); i++)
        {
            if(secret.charAt(i) == guess.charAt(i))
            {
                freq[Integer.parseInt(String.valueOf(secret.charAt(i)))]--;
                bulls++;
            }
        }

        for(int i=0; i< secret.length(); i++)
        {
            if(secret.charAt(i) != guess.charAt(i) && freq[Integer.parseInt(String.valueOf(guess.charAt(i)))] > 0)
            {
                cows++;
                freq[Integer.parseInt(String.valueOf(guess.charAt(i)))]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
