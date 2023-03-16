package DynamicProgramming;

import java.util.HashMap;

//nu e cea mai performanta solutie
//e alta mai performanta in cerinta
public class SoupServings
{
        private HashMap<Integer, Double> cache;
        public double soupServings(int n)
        {
            cache = new HashMap<>();
            double result = serveSoup(n,n);
            System.out.println(cache.size());

            return result;
        }

        private double serveSoup(int availableA, int availableB)
        {
            String key1 = 100 + "-" + 0 + "-" + availableA + "-" + availableB;
            String key2 = 75 + "-" + 25 + "-" + availableA + "-" + availableB;
            String key3 = 50 + "-" + 50 + "-" + availableA + "-" + availableB;
            String key4 = 25 + "-" + 75 + "-" + availableA + "-" + availableB;
            Double res1 = cache.get(key1.hashCode()) == null ? calculateProb(100, 0, availableA, availableB) : cache.get(key1.hashCode());
            Double res2 = cache.get(key2.hashCode()) == null ? calculateProb(75, 25, availableA, availableB) : cache.get(key2.hashCode());
            Double res3 = cache.get(key3.hashCode()) == null ? calculateProb(50, 50, availableA, availableB) : cache.get(key3.hashCode());
            Double res4 = cache.get(key4.hashCode()) == null ? calculateProb(25, 75, availableA, availableB) : cache.get(key4.hashCode());

            return 0.25 * (res1 + res2 + res3 + res4);
        }

        private double calculateProb(int shouldPourA, int shouldPourB, int availableA, int availableB)
        {
            String key = shouldPourA + "-" + shouldPourB + "-" + availableA + "-" + availableB;
            //System.out.println(key);
            if(cache.get(key.hashCode())!=null)
                return cache.get(key.hashCode());
            if(availableB - shouldPourB<= 0 && availableA-shouldPourA <=0)
            {
                return  0.5;
            }

            if(availableA-shouldPourA <=0)
            {
                return  1;
            }

            if(availableB-shouldPourB <= 0 )
            {
                return  0;
            }
            else
            {
                double result = serveSoup(availableA-shouldPourA, availableB-shouldPourB);
                System.out.println(key);
                cache.put(key.hashCode(), result);
                return result;
            }
        }
}
