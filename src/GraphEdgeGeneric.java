public class GraphEdgeGeneric<T> {
    private T startVertexMap;
    private T endVertexMap;
    public GraphEdgeGeneric(T startVertexMap, T endVertexMap)
    {
        this.startVertexMap = startVertexMap;
        this.endVertexMap = endVertexMap;
    }

    public T getStartVertex() {
        return startVertexMap;
    }

    public T getEndVertex(){
        return endVertexMap;
    }
}
