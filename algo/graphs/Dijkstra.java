package algo.graphs;

import java.util.Arrays;

public class Dijkstra {

  static void processVertex(int[][] graph, int[] distance, boolean[] visited, int selectedVertex) {
    visited[selectedVertex] = true;

    for (int j = 0; j < graph[selectedVertex].length; j++) {
      if (graph[selectedVertex][j] == 0) continue;

      if (distance[j] == Integer.MAX_VALUE || distance[selectedVertex] + graph[selectedVertex][j] < distance[j]) {
        distance[j] = distance[selectedVertex] + graph[selectedVertex][j];
      }
    }
  }

  static void shortestPath(int[][] graph, int startVertex) {
    int[] distance = new int[graph.length];
    boolean[] visited = new boolean[graph.length];

    for (int j = 0; j < graph.length; j++) {
      distance[j] = Integer.MAX_VALUE;
    }

    // Distance to itself is 0.
    distance[startVertex] = 0;
    int selectedVertex = startVertex;
    int minDistance;

    while (selectedVertex != -1) {
      processVertex(graph, distance, visited, selectedVertex);
      minDistance = Integer.MAX_VALUE;
      selectedVertex = -1;
      for (int i = 0; i < graph.length; i++) {
        if (!visited[i] && distance[i] < minDistance) {
          minDistance = distance[i];
          selectedVertex = i;
        }
      }
    }

    System.out.println(Arrays.toString(distance));
  }

  public static void main(String[] args) {
    int graph[][] = new int[][] {
          { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
          { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
          { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
          { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
          { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
          { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
          { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
          { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
          { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
      };

    shortestPath(graph, 0);
  }
}
