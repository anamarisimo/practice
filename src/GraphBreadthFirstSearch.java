public class GraphBreadthFirstSearch {
    protected final int source;
    private final boolean[] visited;
    private final Graph graph;

    public GraphBreadthFirstSearch(Graph graph, int src) {
        source = src;
        this.graph = graph;
        visited = new boolean[graph.getNrVertices()];
    }

    public void analyzeVertex(int v, int w) {
        System.out.println("analyzing " + w);
    }

    public void Execute() {
        bfs(graph, source);
    }

    private void bfs(Graph graph, int v) {
        Queue_LinkedList<Integer> vertexQueue = new Queue_LinkedList<Integer>();
        vertexQueue.enqueue(v);
        visited[v] = true;
        while (vertexQueue.getSize() > 0)
        {
            int currentVertex = vertexQueue.dequeue();
            for (int vertex : graph.adjacentVertexes(currentVertex))
            {
                if (!visited[vertex]) {
                    vertexQueue.enqueue(vertex);
                    analyzeVertex(currentVertex, vertex);
                    visited[vertex] = true;
                }
            }
        }
    }
}
