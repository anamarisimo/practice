public class GraphDepthFirstOrder
{
    private final Graph graph;
    private Stack_LinkedList<Integer> orderedItems;
    private boolean[] visited;
    private boolean allowCycles = false;
    private GraphCycleDetector cycleDetector;

    public GraphDepthFirstOrder(Graph g) {
        graph = g;
        visited = new boolean[g.getNrVertices()];
        orderedItems = new Stack_LinkedList<>();
    }

    public GraphDepthFirstOrder(Graph g, boolean allowCycles) {
        graph = g;
        visited = new boolean[g.getNrVertices()];
        orderedItems = new Stack_LinkedList<>();
        this.allowCycles = allowCycles;
    }

    public void Execute()
    {
        if(allowCycles)
        {
            for (int i = 0; i < graph.getNrVertices(); i++) {
                if (!visited[i])
                    dfs(i);
            }
        }
        else {
            cycleDetector = new GraphCycleDetector(graph);
            cycleDetector.Execute();
            if (!cycleDetector.hasCycle()) {
                for (int i = 0; i < graph.getNrVertices(); i++) {
                    if (!visited[i])
                        dfs(i);
                }
            } else
                System.out.println("cycle");
        }
    }

    public void dfs(int v)
    {
        visited[v] = true;
        if(graph.adjacentVertexes(v)!=null)
        {
            for (int adjVertex : graph.adjacentVertexes(v))
            {
                if(!visited[adjVertex])
                    dfs(adjVertex);
            }
        }
        orderedItems.push(v);
    }

    public Iterable<Integer> getOrderedItems()
    {
        return orderedItems;
    }

}
