package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph
{
    private int[][] graphEdges;

    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        if(n == 1 && edges.length == 0 || source == destination)
            return true;
        graphEdges = edges;
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> markedSeen = new HashSet<Integer>();
        queue.add(source);
        markedSeen.add(source);
        while(!queue.isEmpty())
        {
            int currentNode = queue.poll();
            addUnseenAdjNodesToQueueAndMarkSeen(currentNode, queue, markedSeen);
            if(queue.contains(destination))
                return true;

        }
        return false;

    }

    private void addUnseenAdjNodesToQueueAndMarkSeen(int source, Queue<Integer> queue, HashSet<Integer> markedSeen)
    {
        for(int i=0; i<graphEdges.length; i++)
        {
            if(graphEdges[i][0] == source && !markedSeen.contains(graphEdges[i][1]))
            {
                queue.add(graphEdges[i][1]);
                markedSeen.add(graphEdges[i][1]);
            }

            else if(graphEdges[i][1] == source && !markedSeen.contains(graphEdges[i][0]))
            {
                queue.add(graphEdges[i][0]);
                markedSeen.add(graphEdges[i][0]);
            }
        }
    }
}
