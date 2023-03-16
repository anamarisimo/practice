public class GraphIsBipartiteDfs
{
    private Graph graph;
    private boolean[] visited;
    private boolean[] color;
    private boolean is2Colorable = true;

    public GraphIsBipartiteDfs(Graph graph)
    {
        this.graph = graph;
        visited = new boolean[graph.getNrVertices()];
        color = new boolean[graph.getNrVertices()];
    }

    public boolean IsBipartite(){
        for (int i = 0; i < graph.getNrVertices(); i++) {
            if(!visited[i])
                dfs(graph, i);
        }
        return is2Colorable;
    }

    private void dfs(Graph graph, int source)
    {
        visited[source] = true;
        for(int adjacentVertex : graph.adjacentVertexes(source))
        {
            if(!visited[adjacentVertex])
            {
                color[adjacentVertex] = !color[source];
                dfs(graph, adjacentVertex);
            }
            else if(color[adjacentVertex] == color[source])
                is2Colorable = false;
        }
    }
}
