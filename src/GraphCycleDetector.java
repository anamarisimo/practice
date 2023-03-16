public class GraphCycleDetector
{
    private boolean[] visitedVertices;
    private boolean[] stackedVertices;
    private Stack_LinkedList<Integer> cycle;
    private int[] edgeTo;
    private Graph graph;

    public GraphCycleDetector(Graph graph)
    {
        stackedVertices = new boolean[graph.getNrVertices()];
        edgeTo = new int[graph.getNrVertices()];
        visitedVertices= new boolean[graph.getNrVertices()];
        this.graph = graph;
    }

    public void Execute()
    {
        for(int i =0;i<graph.getNrVertices();i++)
        {
            if(!visitedVertices[i])
                dfs(graph,i);
        }
    }

    public void dfs(Graph g, int v)
    {
        visitedVertices[v] = true;
        stackedVertices[v] = true;
        if(g.adjacentVertexes(v) == null)
            return;
        for (int adjVertex : g.adjacentVertexes(v))
        {
            if(hasCycle()) return;
            else if(!stackedVertices[adjVertex])
            {
                if(!visitedVertices[adjVertex])
                {
                    edgeTo[adjVertex] = v;
                    dfs(g, adjVertex);
                }
            }
            else
                traverseCycle(v,adjVertex);
        }
        stackedVertices[v] = false;
    }

    public void traverseCycle(int v, int w){
        if(stackedVertices[w])
        {
            cycle = new Stack_LinkedList<>();
            for(int x = v; x != w; x = edgeTo[x])
                cycle.push(x);
            cycle.push(w);
            cycle.push(v);
        }
    }

    public boolean hasCycle()
    {
        return cycle !=null;
    }

    public Iterable<Integer> getCycle()
    {
        return cycle;
    }
}
