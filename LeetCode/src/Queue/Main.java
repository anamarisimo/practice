package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testInterleavingFlattener();
    }

    private static void testInterleavingFlattener()
    {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5));
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(6, 7, 8, 9));

        Iterator<Integer> a = arr1.iterator();
        Iterator<Integer> b = arr2.iterator();
        Iterator<Integer> c = arr3.iterator();
        ArrayList<Iterator<Integer>> iterlist = new ArrayList<>(Arrays.asList(a,b,c));

        InterleavingFlattener flaty = new InterleavingFlattener(iterlist);
        while(flaty.hasNext())
        {
            System.out.println(flaty.next());
        }
    }
}

