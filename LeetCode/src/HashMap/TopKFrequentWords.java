package HashMap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k)
    {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: words)
        {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> minPQ = new PriorityQueue<>(
                (a,b) ->
                {
                    if(map.get(a).equals(map.get(b)))
                        return b.compareTo(a);
                    else return map.get(a).compareTo(map.get(b));
                });

        for(String word: map.keySet())
        {
            minPQ.add(word);
            if (minPQ.size() > k)
                minPQ.poll();
        }

        List<String> res = new ArrayList<>();
        while (!minPQ.isEmpty())
            res.add(minPQ.poll());
        Collections.reverse(res);
        return res;

    }
}
