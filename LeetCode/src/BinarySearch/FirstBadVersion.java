package BinarySearch;

public class FirstBadVersion {
    private boolean isBadVersion(int nr)
    {
        //dummy implementation here
        return true;
    }
    public int firstBadVersion(int n)
    {
        int left = 0;
        int right = n;
        int currentBad = -1;
        while(left<=right)
        {
            //int overflow!!!
            long sum = (long)left + (long)right;
            long midLong = sum / 2;
            int mid = (int) midLong;
            boolean isBad = isBadVersion(mid);
            if(isBad)
            {
                currentBad = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return currentBad;
    }
}
