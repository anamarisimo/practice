package Strings;

public class LongestCommonPrefix
{
    public String longestCommonPrefix(String[] strs)
    {
        String commonPrefix = "";


        commonPrefix=strs[0];

        for(int i=1;i<strs.length;i++)
        {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }
    private String getCommonPrefix(String a, String b)
    {
        if(a.length() < b.length())
        {
            while(a.length() > 0)
            {
                if(b.startsWith(a))
                    return a;
                else
                    a = a.substring(0, a.length()-1);
            }

        }
        else
        {
            while(b.length() > 0)
            {
                if(a.startsWith(b))
                    return b;
                else
                    b = b.substring(0, b.length()-1);
            }

        }
        return "";
    }
}
