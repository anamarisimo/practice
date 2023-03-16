package SlidingWindow;

public class MaximumLengthRepeatedSubarray {
        public int findLength(int[] m, int[] n)
        {
            int max = 0;
            int seqL = 0;
            for(int i=1; i<=m.length; i++)
            {
                seqL = 0;
                int mRunner = m.length-i;
                int nRunner = 0;
                for(;mRunner < m.length && nRunner < n.length;  mRunner++, nRunner++)
                {
                    if(n[nRunner] == m[mRunner])
                    {
                        seqL++;
                        if(seqL > max)
                            max = seqL;
                    }
                    else
                        seqL = 0;
                }
            }

            for(int i=1; i<n.length; i++)
            {
                seqL = 0;
                int mRunner = 0;
                int nRunner = i;
                for(;mRunner < m.length && nRunner < n.length;  mRunner++, nRunner++)
                {
                    if(n[nRunner] == m[mRunner])
                    {
                        seqL++;
                        if(seqL > max)
                            max = seqL;
                    }
                    else
                        seqL = 0;
                }
            }

            return max;
        }
}
