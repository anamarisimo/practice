import java.util.HashMap;

public class GraphGeneric<T> {
    /*
    private HashMap<T, Integer> vertexMap;
    private Graph graph;
    private boolean IsDirected;

    public GraphGeneric(int nrVertices, GraphEdgeGeneric<T>[] edges, boolean isDirected)
    {
        graph = new Graph(nrVertices, );
        NrVertices = nrVertices;
        adjacencyListsArray = new HashMap<T, Bag_LinkedList<T>>();
        for(GraphEdgeGeneric<T> edge:edges)
        {
            addEdge(edge.getStartVertex(),edge.getEndVertex());
        }
        IsDirected = isDirected;
    }

    public Integer[] mapEdges

    private void addEdge(T startV, T endV)
    {
        if(adjacencyListsArray.get(startV) == null)
            adjacencyListsArray.put(startV,new Bag_LinkedList<>());
        adjacencyListsArray.get(startV).add(endV);
        if(!IsDirected)
        {
            if(adjacencyListsArray.get(endV) == null)
                adjacencyListsArray.put(endV,new Bag_LinkedList<>());
            adjacencyListsArray.get(endV).add(startV);
        }
        NrEdges++;
    }

    public void display(){
        System.out.println(" -------------------------- Display graph ");
        int counter = 0;
        for(T vertexKey: adjacencyListsArray.keySet())
        {
            System.out.print("(" + counter  + ")");
            for(T vertexAdj: adjacencyListsArray.get(vertexKey))
            {
                System.out.println(" ");
                System.out.print("    -> " + vertexAdj  + "");
            }
            System.out.println(" ");
            counter++;
        }
    }

    public int degree(int v) {
        return adjacencyListsArray.get(v).size();
    }

    public Bag_LinkedList<T> adjacentVertexes(T v) {
        return adjacencyListsArray.get(v);
    }

    public int getNrVertices(){
        return NrVertices;
    }
*/
}
