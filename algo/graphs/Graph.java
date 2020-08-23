package algo.graphs;

import java.util.LinkedList;

public class Graph {

  public int vertices;   // No. of vertices
  public LinkedList<Integer> adj[]; //Adjacency Lists

  Graph(int vertices) {
    this.vertices = vertices;
    adj = new LinkedList[vertices];

    for (int i = 0; i < vertices; i++) {
      adj[i] = new LinkedList();
    }
  }

  void addEdge(int vertex, int connectedVertex) {
    adj[vertex].add(connectedVertex);
  }
}
