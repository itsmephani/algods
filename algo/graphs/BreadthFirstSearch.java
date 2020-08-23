package algo.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

  static void BFS(Graph graph, int startVertex) {
    boolean visited[] = new boolean[graph.vertices];

    Queue<Integer> queue = new LinkedList();
    visited[startVertex] = true;
    queue.add(startVertex);

    while (!queue.isEmpty()) {
      Integer vertex = queue.poll();
      System.out.println(vertex);

      Iterator<Integer> i = graph.adj[vertex].listIterator();

      while (i.hasNext()) {
        Integer v = i.next();
        if (!visited[v]) {
          visited[v] = true;
          queue.add(v);
        }
      }
    }
  }

  public static void main(String args[]) {

    Graph graph = new Graph(4);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    BFS(graph, 2);
  }
}
