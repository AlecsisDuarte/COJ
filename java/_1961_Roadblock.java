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
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class _1961_Roadblock {

  private static class Path {
    ArrayList<Integer> path;
    int distance;

    Path() {
      this.path = new ArrayList<>();
      this.distance = 0;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] values = in.readLine().split(" ");
    short n = Short.parseShort(values[0]);
    short m = Short.parseShort(values[1]);

    int[][] edges = new int[n][n];
    for (int i = 0; i < m; i++) {
      values = in.readLine().split(" ");

      // Set fields id from 0,..N-1
      int a = Integer.parseInt(values[0]) - 1,
          b = Integer.parseInt(values[1]) - 1, d = Integer.parseInt(values[2]);
      edges[a][b] = d;
      edges[b][a] = d;
    }

    out.write(String.format("%d\n", getMaxPathBlockedDifference(edges, n)));

    out.close();
    in.close();
  }

  private static int getMaxPathBlockedDifference(int[][] edges, short n) {

    Path shortestPath = getPath(edges, n);
    int maxDiff = 0;

    for (int i = 1; i < shortestPath.path.size(); i++) {
      int from = shortestPath.path.get(i);
      int to = shortestPath.path.get(i - 1);

      int originalDistance = edges[from][to];

      // Double longest path
      edges[from][to] = edges[to][from] = originalDistance * 2;
      
      Path newPath = getPath(edges, n);
      
      //Restore distance
      edges[from][to] = edges[to][from] = originalDistance;

      int diff = newPath.distance - shortestPath.distance;
      if (diff > maxDiff) {
          maxDiff = diff;
      }
    }

    return maxDiff;
  }

  private static Path getPath(int[][] edges, short n) {
    int[] dist = new int[n];
    int[] parent = new int[n];

    Arrays.fill(dist, Integer.MAX_VALUE);
    boolean[] sptSet = new boolean[n];

    dist[0] = 0;

    for (int count = 0; count < n - 1; count++) {
      int u = minDistance(dist, sptSet, n);
      sptSet[u] = true;

      for (int i = 0; i < n; i++) {
        if (!sptSet[i] && edges[u][i] > 0 && dist[u] != Integer.MAX_VALUE &&
            dist[u] + edges[u][i] < dist[i]) {
          dist[i] = dist[u] + edges[u][i];
          parent[i] = u;
        }
      }
    }

    return getPath(edges, parent, n);
  }

  private static int minDistance(int[] dist, boolean[] sptSet, short n) {
    int min = Integer.MAX_VALUE, index = 0;

    for (int i = 0; i < n; i++) {
      if (!sptSet[i] && dist[i] <= min) {
        min = dist[i];
        index = i;
      }
    }

    return index;
  }

  private static Path getPath(int[][] edges, int[] parent, short n) {
    Path p = new Path();

    int from = n - 1, to = parent[from];
    p.path.add(from);

    while (from > 0) {
      p.path.add(to);
      int distance = edges[from][to];
      p.distance += distance;

      from = to;
      to = parent[from];
    }

    return p;
  }
}