package SlidingWindow;

import java.util.HashMap;

public class LoggerRateLimiter
{
    HashMap<String, Integer> logTimeMap;
    public LoggerRateLimiter()
    {
        logTimeMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message)
    {
        Integer messageTime = logTimeMap.get(message);
        if(messageTime==null)
        {
            logTimeMap.put(message,timestamp);
            return true;
        }

        if(timestamp - messageTime>=10)
        {
            logTimeMap.put(message,timestamp);
            return true;
        }
        else
        {
            return false;
        }
    }
}
