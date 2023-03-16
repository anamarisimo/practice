package Array;

public class LengthLastWord {
        public int lengthOfLastWord(String s)
        {
            int len = 0;
            int i = s.length()-1;
            char[] chars = s.toCharArray();
            while(i >=0 && chars[i] == ' ')
            {
                i--;
            }
            while(i >=0 && chars[i] != ' ')
            {
                len++;
                i--;
            }

            return len;
    }
}
