public class Main {

    public static void main(String[] args) {
        /*
        test_queue_dequeue();
        test_queue_peek();
        test_stack_peek();
        test_stack_pop();
		test_dfs();
		*/

        //test_dfs_pathFinder();

        //test_bfs();

        //test_bfs_pathFinder();

        //test_dfs_connected_components();

        //test_dfs_bipartite();

        //test_dfs_cycleDetection();

        // test_dfs_topologicalSort();

        //test_prio_queue();

       //test_quicksort();
       // test_quicksort3();

        //test_mergesort();

        //test_heapsort();

        //test_quickselect();

        //test_insertionSort();
        test_bst();
        //test_redblack();

    }
    private static void test_redblack()
    {
        RedBlackTree<Integer, Integer> redBlack = new RedBlackTree<>();
        redBlack.insert(1,1);
        redBlack.insert(2,2);
        redBlack.insert(3,3);
        redBlack.printTree(redBlack.getRoot(), "");
    }
    private static void test_bst()
    {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        bst.insert(1, 1);
        bst.insert(2, 2);

        bst.insert(0, 0);
        bst.insert(4, 4);
        bst.insert(3, 3);
        bst.insert(1, 1);
        bst.print();
        //bst.delete(0);
        //bst.getParentOf(0);
       // System.out.println(bst.getParentOf(3).getKey());
    }
    private static void test_insertionSort()
    {
        InsertionSort sort = new InsertionSort();
        int[] nums = new int[]{100,5,0,9,52,4,2,85,45,6,0,7,1,2,3};
        /*
        sort.sort(nums);
        for (int j : nums) {
            System.out.print(j);
            System.out.print(" ");
        }
*/
        sort.sortSection(nums,0 , nums.length-1);
        for (int j : nums) {
            System.out.print(j);
            System.out.print(" ");
        }
    }

    private static void test_quickselect()
    {
        Quickselect select = new Quickselect();
        int res = select.findKthLargest(new int[] {3,3,3}, 1);
        System.out.println(res);
    }

    private static void test_heapsort()
    {
        HeapSort sort = new HeapSort();
        int[] res = sort.sortArray(new int[] {5,2,3,1,7,7,0,3,4});
        System.out.print("----------");
        for (int j : res) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
    private static void test_mergesort()
    {
        MergeSort mSort = new MergeSort();
        int[] arr = {100,5,0,9,52,4,2,85,45,6,0,7,1,2,3};
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println("");
        mSort.sort(arr);
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
    }

    private static void test_quicksort3()
    {
        Quicksort qSort = new Quicksort();
        int[] arr = {5,2,3,1,7,7,0,3,4,100,52,1,2,9,45};
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println("");
        qSort.quickSort3Way(arr, 0, arr.length -1);
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
    private static void test_quicksort()
    {
        Quicksort qSort = new Quicksort();
        int[] arr = {5,2,3,1,7,7,0,3,4,100,52,1,2,9,45};
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
        System.out.println("");
        qSort.sort(arr);
        for (int j : arr) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
    private static void test_prio_queue()
    {
        PriorityQueueMax prioQ = new PriorityQueueMax(100);
        prioQ.insert(9);
        prioQ.insert(2);
        prioQ.insert(6);
        prioQ.insert(1);
        prioQ.insert(8);
        prioQ.deleteMax();
        int max = prioQ.getMax();
        System.out.println(max);
        if(max ==8)
            System.out.println("correct");
        else
            System.out.println("orac");
    }
    private static void test_dfs_topologicalSort()
    {
        Graph graph = new Graph(8, new GraphEdge[]{
                new GraphEdge(0, 1),
                new GraphEdge(1, 4),
                new GraphEdge(2, 1),
                new GraphEdge(2, 3),
                new GraphEdge(4, 5),
                new GraphEdge(5, 6),
                new GraphEdge(6, 7)
        }, true);

        GraphDepthFirstOrder order = new GraphDepthFirstOrder(graph);
        order.Execute();
        Iterable<Integer> orderedItems = order.getOrderedItems();
        for (int vertex : orderedItems) {
            System.out.print(vertex + " ");
        }
    }
    private static void test_dfs_cycleDetection()
    {
        Graph graph = new Graph(8, new GraphEdge[]{
                new GraphEdge(0, 1),
                new GraphEdge(1, 4),
                new GraphEdge(4, 2),
                new GraphEdge(2, 1),
                new GraphEdge(2, 3),
                new GraphEdge(4, 5),
                new GraphEdge(5, 6),
                new GraphEdge(6, 7)
        }, true);
        GraphCycleDetector cycleDetector = new GraphCycleDetector(graph);
        cycleDetector.Execute();
        boolean hasCycle = cycleDetector.hasCycle();
        if(!hasCycle)
            System.out.println("Incorrect "+ hasCycle);
        else
            System.out.println("Correct "+ hasCycle);
        Iterable<Integer> cycle = cycleDetector.getCycle();
        for (int vertex : cycle) {
            System.out.print(vertex + " ");
        }
    }
    private static void test_dfs_bipartite()
    {
        Graph graph = new Graph(4, new GraphEdge[]{
                new GraphEdge(0, 1),
                new GraphEdge(0, 2),
                new GraphEdge(0, 3),
                new GraphEdge(2, 3),
                new GraphEdge(1, 3)
        }, false);
        GraphIsBipartiteDfs finder = new GraphIsBipartiteDfs(graph);
        boolean isBip = finder.IsBipartite();
        if(!isBip)
            System.out.println("Correct: is bipartite = "+ isBip);
        else
            System.out.println("Error: is bipartite should be false");

        Graph graph2 = new Graph(4, new GraphEdge[]{
                new GraphEdge(0, 1),
                new GraphEdge(0, 2),
                new GraphEdge(2, 3),
                new GraphEdge(1, 3)
        }, false);
        GraphIsBipartiteDfs finder2 = new GraphIsBipartiteDfs(graph2);
        boolean isBip2 = finder2.IsBipartite();
        if(isBip2)
            System.out.println("Correct: is bipartite = "+ isBip2);
        else
            System.out.println("Error: is bipartite should be true");
    }
    private static void test_dfs_connected_components()
    {
        Graph graph = new Graph(6, new GraphEdge[]{
                new GraphEdge(0, 2),
                new GraphEdge(0, 1),
                new GraphEdge(2, 4)

        }, false);
        GraphConnectedComponentsDfs finder = new GraphConnectedComponentsDfs(graph);
        int[] match = finder.Execute();
        for(int i =0;i<match.length ;i++)
        {
            System.out.println("vertex "+i+" is in component "+match[i]);
        }
    }
    private static void test_bfs()
    {
        Graph graph = new Graph(6, new GraphEdge[]{
                new GraphEdge(0, 2),
                new GraphEdge(0, 1),
                new GraphEdge(0, 5),
                new GraphEdge(2, 4),
                new GraphEdge(2, 3),
                new GraphEdge(3, 4),
                new GraphEdge(3, 5),
        }, false);
        GraphBreadthFirstSearch search = new GraphBreadthFirstSearch(graph, 0);
        search.Execute();

    }

    private static void test_bfs_pathFinder()
    {
        Graph graph = new Graph(6, new GraphEdge[]{
                new GraphEdge(0, 2),
                new GraphEdge(0, 1),
                new GraphEdge(0, 5),
                new GraphEdge(2, 4),
                new GraphEdge(2, 3),
                new GraphEdge(3, 4),
                new GraphEdge(3, 5),
        }, false);
        GraphPathFinderBfs finder = new GraphPathFinderBfs(graph, 0);
        finder.Execute();
        for (int i=0;i<=5 ;i++ ) {
            System.out.println("path to "+ i);
            Iterable<Integer> path = finder.findPath(i);
            ((Stack_LinkedList<Integer>)path).display();
        }
        graph.display();
    }

    private static void test_dfs_pathFinder()
    {
        Graph graph = new Graph(6, new GraphEdge[]{
                new GraphEdge(0, 2),
                new GraphEdge(0, 1),
                new GraphEdge(0, 5),
                new GraphEdge(2, 4),
                new GraphEdge(2, 3),
                new GraphEdge(3, 4),
                new GraphEdge(3, 5),
        }, false);
        GraphPathFinderDfs finder = new GraphPathFinderDfs(graph, 0);
        finder.Execute();
        for (int i=0;i<=5 ;i++ ) {
            System.out.println("path to "+ i);
            Iterable<Integer> path = finder.findPath(i);
            ((Stack_LinkedList<Integer>)path).display();
        }
        graph.display();
    }
    private static void test_dfs() {
        Graph graph = new Graph(6, new GraphEdge[]{
                new GraphEdge(0, 2),
                new GraphEdge(0, 1),
                new GraphEdge(0, 5),
                new GraphEdge(2, 4),
                new GraphEdge(2, 3),
                new GraphEdge(3, 4),
                new GraphEdge(3, 5),
        }, false);
        GraphDepthFirstSearch search = new GraphDepthFirstSearch(graph, 0);
        search.Execute();
    }

    private static void test_stack_pop() {
        Stack_LinkedList<Integer> stack = new Stack_LinkedList<Integer>();
        stack.push(5);
        stack.push(7);
        stack.push(8);
        stack.display();
        Integer pop_result = stack.pop();
        if (pop_result != 8)
            System.out.println("Stack - pop is not good");
        else
            System.out.println("Stack - pop is good - popped 8");
    }

    private static void test_stack_peek() {
        Stack_LinkedList<Integer> stack = new Stack_LinkedList<Integer>();
        stack.push(5);
        stack.push(7);
        stack.push(8);
        stack.pop();
        stack.display();
        Integer peek_result = stack.peek();
        if (peek_result != 7)
            System.out.println("Stack - peek is not good");
        else
            System.out.println("Stack - peek is good - peeked 7");
    }

    private static void test_queue_dequeue() {
        Queue_LinkedList<Integer> queue = new Queue_LinkedList<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.display();
        Integer deqResult = queue.dequeue();

        if (deqResult != 1)
            System.out.println("Queue - dequeue is not good");
        else
            System.out.println("Queue - dequeue is good - dequeued 1");
    }

    private static void test_queue_peek() {
        Queue_LinkedList<Integer> queue = new Queue_LinkedList<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        Integer deqResult = queue.dequeue();
        queue.display();
        Integer result = queue.peek();

        if (result != 2)
            System.out.println("Queue - peek is not good");
        else
            System.out.println("Queue - peek is good - peeked 2");
    }
}
