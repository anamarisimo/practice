public class GraphKosarajuConnectedComponents
{
    private Graph graph;
    private int[] verticesConnectedComponents;
    private boolean[] visitedVertices;
    private int connectedComponentsCount = 0;
    private GraphDepthFirstOrder orderDoer;

    public GraphKosarajuConnectedComponents(Graph graph)
    {
        this.graph = graph;
        verticesConnectedComponents = new int[graph.getNrVertices()];
        visitedVertices =  new boolean[graph.getNrVertices()];
    }

    public void Execute(){
        Graph reversedG = graph.reverse();
        orderDoer = new GraphDepthFirstOrder(reversedG, true);
        for (int vertex : orderDoer.getOrderedItems())
        {
            dfs(vertex, graph);
            connectedComponentsCount++;
        }

    }
    private void dfs(int source, Graph graph)
    {
        visitedVertices[source] = true;
        verticesConnectedComponents[source] = connectedComponentsCount;
        for (int adjacentVertex: graph.adjacentVertexes(source))
        {
            if(!visitedVertices[adjacentVertex])
                dfs(adjacentVertex, graph);
        }
    }

    public boolean arePartOfSameConnectedComponent(int vertex1, int vertex2)
    {
        return verticesConnectedComponents[vertex1] == verticesConnectedComponents[vertex2];
    }
    public int getNrOfConnectedComponents()
    {
        return connectedComponentsCount;
    }
}
