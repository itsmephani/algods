package algo.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch {

  static void DFSUtil(Graph graph, int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.println(vertex);

    Iterator<Integer> i = graph.adj[vertex].listIterator();

    while (i.hasNext()) {
      Integer v = i.next();
      if (!visited[v]) {
        visited[v] = true;
        DFSUtil(graph, v, visited);
      }
    }
  }

  static void DFS(Graph graph, int startVertex) {
    boolean visited[] = new boolean[graph.vertices];

    DFSUtil(graph, startVertex, visited);
  }

  public static void main(String args[]) {

    Graph graph = new Graph(4);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    DFS(graph, 1);
  }
}
