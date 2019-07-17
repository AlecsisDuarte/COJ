/**
 * Problem: 1961 - Roadblock
 *
 * Description:
 *  Every morning, FJ wakes up and walks across the farm from his house to the
 *  barn. The farm is a collection of N fields (1 <= N <= 100) connected by M
 *  bidirectional pathways (1 <= M <= 10,000), each with an associated length.
 * FJ's house is in field 1, and the barn is in field N. No pair of fields is
 * joined by multiple redundant pathways, and it is possible to travel between
 * any pair of fields in the farm by walking along an appropriate sequence of
 * pathways. When traveling from one field to another, FJ always selects a route
 * consisting of a sequence of pathways having minimum total length.
 *
 *  Farmer John's cows, up to no good as always, have decided to interfere with
 * FJ's morning routine. They plan to build a pile of hay bales on exactly one
 * of the M pathways on the farm, doubling its length. The cows wish to select a
 * pathway to block so that they maximize the increase in FJ's distance from the
 * house to the barn. Please help the cows determine by how much they can
 * lengthen FJ's route.
 *
 * Input specification:
 *  - Line 1: Two space-separated integers, N (1 <= N <= 100) and M (1 <= M <=
 *  10,000).
 *  - Lines 2..1+M: Line j+1 describes the jth bidirectional pathway in terms of
 *  three space-separated integers: A_j B_j L_j, where A_j and B_j are indices
 * in the range 1..N indicating the fields joined by the pathway, and L_j is the
 *  length of the pathway (in the range 1...1,000,000).
 *
 * Output specification:
 *  - Line 1: The maximum possible increase in the total length of FJ's shortest
 *  route made possible by doubling the length of a single pathway.
 *
 * Sample input:
 *  5 7
 *  2 1 5
 *  1 3 1
 *  3 2 8
 *  3 5 7
 *  3 4 3
 *  2 4 7
 *  4 5 2
 *
 * Sample output:
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1961
 * REF:
 * https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1961_RoadBlock_BinaryHeap {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] values = in.readLine().split(" ");
    short n = Short.parseShort(values[0]);
    short m = Short.parseShort(values[1]);

    Graph graph = new Graph(n);
    for (int i = 0; i < m; i++) {
      values = in.readLine().split(" ");

      // Set fields id from 0,..N-1
      int a = Integer.parseInt(values[0]) - 1,
          b = Integer.parseInt(values[1]) - 1, d = Integer.parseInt(values[2]);

      graph.addEdge(a, b, d);
    }

    out.write(String.format("%d\n", maxPathBlockedDifference(graph, n)));

    out.close();
    in.close();
  }

  private static int maxPathBlockedDifference(Graph graph, int v) {
    Path shortestPath = dijkstra(graph);
    int maxDiff = 0;

    for (int i = 1; i < shortestPath.path.size(); i++) {
      int from = shortestPath.path.get(i);
      int to = shortestPath.path.get(i - 1);

      AdjListNode fromTo = graph.searchEdge(from, to),
                  toFrom = graph.searchEdge(to, from);

      int originalDistance = fromTo.weight;

      // Increase path weight
      fromTo.weight = toFrom.weight = originalDistance * 2;

      Path newPath = dijkstra(graph);

      // Restore path weight
      fromTo.weight = toFrom.weight = originalDistance;

      int diff = newPath.distance - shortestPath.distance;
      if (diff > maxDiff) {
        maxDiff = diff;
      }
    }
    return maxDiff;
  }

  static Path dijkstra(Graph graph) {
    int v = graph.v;
    int[] dist = new int[v];
    int[] parent = new int[v];
    MinHeap minHeap = new MinHeap(v);

    for (int i = 0; i < v; ++i) {
      minHeap.array[i] = new MinHeapNode(i, dist[i] = Integer.MAX_VALUE);
      minHeap.pos[i] = i;
    }

    minHeap.array[0] = new MinHeapNode(0, dist[0]);
    minHeap.pos[0] = 0;
    minHeap.decraseKey(0, dist[0] = 0);

    minHeap.size = v;

    while (!minHeap.isEmpty()) {
      MinHeapNode minHeapNode = minHeap.extractMin();
      int u = minHeapNode.v;

      AdjListNode pCrawl = graph.array[u];
      while (pCrawl != null) {
        int dest = pCrawl.dest;

        if (minHeap.isInMinHeap(dest) && dist[u] != Integer.MAX_VALUE &&
            pCrawl.weight + dist[u] < dist[dest]) {
          dist[dest] = dist[u] + pCrawl.weight;
          minHeap.decraseKey(dest, dist[dest]);
          parent[dest] = u;
        }

        pCrawl = pCrawl.next;
      }
    }
    return Path.getPath(graph, parent, v);
  }
}

/**
 * Class to store information about graph path
 */
class Path {
  ArrayList<Integer> path;
  int distance;

  Path() {
    this.path = new ArrayList<>();
    this.distance = 0;
  }

  static Path getPath(Graph graph, int[] parent, int v) {
    Path p = new Path();

    int from = v - 1, to = parent[from];
    p.path.add(from);

    while (from > 0) {
      p.path.add(to);

      AdjListNode edge = graph.searchEdge(from, to);
      int distance = edge.weight;
      p.distance += distance;

      from = to;
      to = parent[from];
    }
    return p;
  }
}

class Graph {
  int v;
  AdjListNode[] array;

  Graph(int v) {
    this.v = v;
    array = new AdjListNode[v];
  }

  void addEdge(int src, int dest, int weight) {
    AdjListNode node = new AdjListNode(dest, weight);
    node.next = array[src];
    array[src] = node;

    node = new AdjListNode(src, weight);
    node.next = array[dest];
    array[dest] = node;
  }

  AdjListNode searchEdge(int from, int to) {
    AdjListNode edge = array[from];
    while (edge.dest != to) {
      edge = edge.next;
    }
    return edge;
  }
}

class AdjListNode {
  int dest, weight;

  AdjListNode next;

  AdjListNode(int dest, int weight) {
    this.dest = dest;
    this.weight = weight;
    next = null;
  }
}

/**
 * Class to represent a min heap node
 */
class MinHeapNode {
  int v, dist;

  MinHeapNode(int v, int dist) {
    this.v = v;
    this.dist = dist;
  }
}

/**
 * Class to represent a min heap
 */
class MinHeap {
  int size, capacity;
  int[] pos;
  MinHeapNode[] array;

  MinHeap(int capacity) {
    this.capacity = capacity;
    this.pos = new int[capacity];
    this.size = 0;
    this.array = new MinHeapNode[capacity];
  }

  void minHeapify(int idx) {
    int smallest, left, right;
    smallest = idx;
    left = 2 * idx + 1;
    right = 2 * idx + 2;

    if (left < size && array[left].dist < array[smallest].dist) {
      smallest = left;
    }

    if (right < size && array[right].dist < array[smallest].dist) {
      smallest = right;
    }

    if (smallest != idx) {
      MinHeapNode smallestNode = array[smallest];
      MinHeapNode idxNode = array[idx];

      pos[smallestNode.v] = idx;
      pos[idxNode.v] = smallest;

      swap(smallest, idx);

      minHeapify(smallest);
    }
  }

  boolean isEmpty() { return size == 0; }

  /**
   * Extract minimum node from heap
   * @return minimum node
   */
  MinHeapNode extractMin() {
    if (isEmpty()) {
      return null;
    }

    MinHeapNode root = array[0];
    MinHeapNode last = array[size - 1];
    array[0] = last;

    pos[root.v] = size - 1;
    pos[last.v] = 0;

    --size;
    minHeapify(0);
    return root;
  }

  void decraseKey(int v, int dist) {
    int i = pos[v];
    array[i].dist = dist;

    while (i > 0 && array[i].dist < array[(i - 1) / 2].dist) {
      int parent = (i - 1) / 2;
      pos[array[i].v] = parent;
      pos[array[parent].v] = i;

      swap(i, parent);

      i = parent;
    }
  }

  void swap(int indexA, int indexB) {
    MinHeapNode tmp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = tmp;
  }

  boolean isInMinHeap(int v) { return pos[v] < size; }
}