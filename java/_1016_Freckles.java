/**
 * Problem:1016 - Freckles
 *
 * Description:
 *  In an episode of the Dick Van Dyke show, little Richie connects the freckles
 *  on his Dad's back to form a picture of the Liberty Bell. Alas, one of the
 *  freckles turns out to be a scar, so his Ripley's engagement falls through.
 *  Consider Dick's back to be a plane with freckles at various (x,y) locations.
 *  Your job is to tell Richie how to connect the dots so as to minimise the
 *  amount of ink used. Richie connects the dots by drawing straight lines between
 *  pairs, possibly lifting the pen between lines. When Richie is done there must
 *  be a sequence of connected lines from any freckle to any other freckle.
 *
 * Input specification:
 *  The first line contains 0 < n <= 100, the number of freckles on Dick's back.
 *  For each freckle, a line follows; each following line contains two real
 *  numbers indicating the (x,y) coordinates of the freckle.
 *
 * Output specification:
 *  Your program prints a single real number to two decimal places: the minimum
 *  total length of ink lines that can connect all the freckles.
 *
 * Sample input:
 *  3
 *  1.0 1.0
 *  2.0 2.0
 *  2.0 4.0
 *
 * Sample output:
 *  3.41
 *
 * URL:
 * REF:
 * https://jariasf.wordpress.com/2012/04/19/arbol-de-expansion-minima-algoritmo-de-kruskal/
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1016_Freckles {
  private static class Point {
    private double x, y;

    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    private double distance(Point p) {
      double xDiff = Math.abs(this.x - p.x);
      double yDiff = Math.abs(this.y - p.y);
      return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }
  }

  // We use Kruskal Algorithm
  static class Kruskal {
    static class Edge implements Comparable<Edge> {
      int origin, end;
      double distance;

      Edge(int origin, int end, double distance) {
        this.origin = origin;
        this.end = end;
        this.distance = distance;
      }

      @Override
      public int compareTo(Edge o) {
        if (this.distance > o.distance) {
          return 1;
        } else if (this.distance < o.distance) {
          return -1;
        }
        return 0;
      }
    }

    //Kruskal dependent variables
    int[] father = null;
    Edge[] edges = null;

    // We calculate all the paths from each point (freckle)
    Kruskal(Point[] freckles) {
      int e = 0, f = freckles.length;
      while (--f > 0) {
        e += f;
      }

      edges = new Edge[e];
      father = new int[freckles.length];
      
      int index = 0;
      for (int i = 0; i < freckles.length; i++) {
        father[i] = i; //We set the freckles father

        //We look for all the posible edges from each freckle
        for (int j = i + 1; j < freckles.length; j++) {
          edges[index++] = new Edge(i, j, freckles[i].distance(freckles[j]));
        }
      }

      Arrays.sort(edges);
    }

    // We look for x node father
    int find(int x) {
      if (x == father[x]) {
        return x;
      }
      // we speed the father search process by setting the actual father while
      // searching
      return father[x] = find(father[x]);
    }
    // As Node x father is different from node y we unite them
    void union(int x, int y) {
      int xRoot = find(x);
      int yRoot = find(y);
      father[xRoot] = yRoot;
    }
    // We validate if x and y share the same father
    boolean sameComponent(int x, int y) { return find(x) == find(y); }

    // We search for the minimum distance paths from point to point
    double minimumSpanningTree() {
      double mst = 0;
      int freckles = 1;
      for (int i = 0; i < edges.length && freckles < edges.length; ++i) {
        if (!sameComponent(edges[i].origin, edges[i].end)) {
          union(edges[i].origin, edges[i].end);
          mst += edges[i].distance;
          freckles++;
        }
      }
      return mst;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(in.readLine());
    Point[] freckles = new Point[n];

    while (--n >= 0) {
      String[] values = in.readLine().split(" ");
      double x = Double.parseDouble(values[0]);
      double y = Double.parseDouble(values[1]);

      freckles[n] = new Point(x, y);
    }

    out.write(String.format("%.2f\n", minInkUsageKruskal(freckles)));
    out.close();
    in.close();
  }

  private static double minInkUsageKruskal(Point[] freckles) {
    Kruskal k = new Kruskal(freckles);
    return k.minimumSpanningTree();
  }
}