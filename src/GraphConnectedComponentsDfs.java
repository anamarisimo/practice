public class GraphConnectedComponentsDfs
{
    private Graph graph;
    private int[] verticesConnectedComponents;
    private boolean[] visitedVertices;
    private int connectedComponentsCount;

    public GraphConnectedComponentsDfs(Graph graph)
    {
        this.graph = graph;
        verticesConnectedComponents = new int[graph.getNrVertices()];
        visitedVertices =  new boolean[graph.getNrVertices()];
    }

    public int[] Execute()
    {
        connectedComponentsCount=1;
        for(int i=0;i<verticesConnectedComponents.length;i++)
        {
            if(verticesConnectedComponents[i] == 0)
            {
                dfs(i, graph);
                connectedComponentsCount++;
            }
        }
        return verticesConnectedComponents;
    }

    public void dfs(int source, Graph graph)
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
