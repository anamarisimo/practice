public class Graph {
    private Bag_LinkedList<Integer>[] adjacencyListsArray;
    private Bag_LinkedList<GraphEdge>[] adjListsEdges;
    private int NrVertices;
    private int NrEdges;
    private boolean IsDirected;
    private GraphEdge[] edges;

    public Graph(int nrVertices, GraphEdge[] edges, boolean isDirected)
    {
        NrVertices = nrVertices;
        adjacencyListsArray = (Bag_LinkedList<Integer>[]) new Bag_LinkedList[nrVertices];
        adjListsEdges = (Bag_LinkedList<GraphEdge>[]) new Bag_LinkedList[nrVertices];
        IsDirected = isDirected;
        this.edges = edges;
        for(GraphEdge edge:edges)
        {
            addEdge(edge.getStartVertex(),edge.getEndVertex());
            addEdgeInAdj(edge);
            IncrementEdges();
        }

    }

    private void addEdge(int startV, int endV)
    {
        if(adjacencyListsArray[startV] == null)
            adjacencyListsArray[startV] = new Bag_LinkedList<>();
        adjacencyListsArray[startV].add(endV);
        if(!IsDirected)
        {
        if(adjacencyListsArray[endV] == null)
            adjacencyListsArray[endV] = new Bag_LinkedList<>();
        adjacencyListsArray[endV].add(startV);
        }
    }

    private void addEdgeInAdj(GraphEdge edge)
    {
        int startV = edge.getStartVertex();
        int endV = edge.getEndVertex();
        if(adjListsEdges[startV] == null)
            adjListsEdges[startV] = new Bag_LinkedList<>();
        adjListsEdges[startV].add(edge);
        if(!IsDirected)
        {
            if(adjListsEdges[endV] == null)
                adjListsEdges[endV] = new Bag_LinkedList<>();
            adjListsEdges[endV].add(edge);
        }
    }

    private void IncrementEdges(){
        NrEdges++;
    }

    public void display(){
        System.out.println(" -------------------------- Display graph ");
        int counter = 0;
        for(Bag_LinkedList<Integer> vertexAdj: adjacencyListsArray)
        {
            System.out.print("(" + counter  + ")");
            for(int vertex: vertexAdj)
            {
                System.out.println(" ");
                System.out.print("    -> " + vertex  + "");
            }
            System.out.println(" ");
            counter++;
        }
    }

    public int degree(int v) {
        return adjacencyListsArray[v].size();
    }

    public Bag_LinkedList<Integer> adjacentVertexes(int v) {
        return adjacencyListsArray[v];
    }

    public int getNrVertices(){
        return NrVertices;
    }

    public Graph reverse(){
        if(!IsDirected)
            return null;
        GraphEdge[] reversedEdges = new GraphEdge[edges.length];
        for(int i=0; i>edges.length; i++)
        {
            reversedEdges[i] = new GraphEdge(edges[i].getEndVertex(), edges[i].getStartVertex());
        }
        Graph reversed = new Graph(NrVertices, reversedEdges, true);
        return reversed;
    }

}
