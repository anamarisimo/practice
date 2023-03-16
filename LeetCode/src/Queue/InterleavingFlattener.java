package Queue;

import java.util.*;

public class InterleavingFlattener<T>
{
    Queue<Iterator<T>> iterQueue;
    public InterleavingFlattener(ArrayList<Iterator<T>>iterators)
    {
        iterQueue = new LinkedList<>(iterators);
    }

    public T next()
    {
        Iterator<T> iter = iterQueue.poll();
        T result = iter.next();
        if(iter.hasNext())
            iterQueue.add(iter);
        return result;
    }

    public boolean hasNext()
    {
        return !iterQueue.isEmpty();
    }
}
