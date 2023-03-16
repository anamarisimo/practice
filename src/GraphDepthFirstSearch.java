public class GraphDepthFirstSearch
{
    private boolean[] visitedVertices;
    protected final int source;
    private Graph graph;

    public GraphDepthFirstSearch(Graph graph, int src){
        source = src;
        this.graph = graph;
        visitedVertices = new boolean[graph.getNrVertices()];
    }

    public void analyzeVertex(int v, int w){
        System.out.println("analyzing " + w);
    }

    public void beforeAdjacentVerticesIteration(int v){

    }

    public void Execute()
    {
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v)
    {
        visitedVertices[v] = true;
        beforeAdjacentVerticesIteration(v);
        for(int w : graph.adjacentVertexes(v)) {
            System.out.print("src is " + v + " ");
            System.out.println("adj is " + w);
            if(!visitedVertices[w]) {
                analyzeVertex(v, w);
                dfs(graph, w);
            }
        }
    }
}
