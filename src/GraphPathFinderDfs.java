public class GraphPathFinderDfs extends GraphDepthFirstSearch
{
    private int[] edgeTo;
    public GraphPathFinderDfs(Graph graph, int src) {
        super(graph, src);
        edgeTo= new int[graph.getNrVertices()];

    }

    public void analyzeVertex(int v, int w)
    {
        System.out.println("Building path " + w + "-" + v);
        edgeTo[w] = v;
    }

    public Iterable<Integer> findPath(int w)
    {
        edgeTo[source] = source;
        Stack_LinkedList<Integer> path = new Stack_LinkedList<>();
        path.push(w);
        boolean found = w == source;
        int currentVertex = w;
        while(!found)
        {
            path.push(edgeTo[currentVertex]);
            currentVertex = edgeTo[currentVertex];
            found = currentVertex == this.source;
        }
        return path;
    }

}
