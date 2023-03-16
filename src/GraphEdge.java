public class GraphEdge {
    private Integer startVertex;
    private Integer endVertex;
    private double weight;
    public GraphEdge(Integer startV, Integer endV)
    {
        startVertex = startV;
        endVertex = endV;
        weight = 0;
    }

    public GraphEdge(Integer startV, Integer endV, double weight)
    {
        startVertex = startV;
        endVertex = endV;
        this.weight = weight;
    }

    public Integer getStartVertex() {
        return startVertex;
    }

    public Integer getEndVertex(){
        return endVertex;
    }
}
