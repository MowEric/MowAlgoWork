package homework;

import edu.princeton.cs.algs4.*;

public class DegreeArray {

    public static Graph readG(String filename) {
        In file = new In(filename);
        int vertices = file.readInt();
        int edges = file.readInt();
        Graph g = new Graph(vertices);
        while (!file.isEmpty()) {
            int v = file.readInt();
            int u = file.readInt();
            g.addEdge(v-1, u-1);
        }
        return g;
    }

    public static Digraph readDig(String filename) {
        In file = new In(filename);
        int vertices = file.readInt();
        int edges = file.readInt();
        Digraph g = new Digraph(vertices);
        while (!file.isEmpty()) {
            int v = file.readInt();
            int u = file.readInt();
            g.addEdge(v-1, u-1);
        }
        return g;
    }

    public static EdgeWeightedDigraph readEdDig(String filename) {
        In file = new In(filename);
        int vertices = file.readInt();
        int edges = file.readInt();
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(vertices, edges);
        while (!file.isEmpty()) {
            int v = file.readInt();
            int u = file.readInt();
            int w = file.readInt();
            DirectedEdge e = new DirectedEdge(v-1, u-1, w);
            g.addEdge(e);
        }
        return g;
    }

    /**
     *
     * @param g - The Graph
     * @param current - The element that starts
     * @return
     */
    public static int[] bfs(Graph g, int current) {
        Queue Q = new Queue<>();
        Q.enqueue(current);
        boolean visited[] = new boolean[g.V()];
        int answer[] = new int[g.V()];
        for(int i = 0; i < g.V(); i++) {
            visited[i] = false;
        }
        visited[current] = true;
        answer[current] = 0;
        int moves = 0;
        while(Q.size() != 0) {
            int v = (int) Q.dequeue();
            moves++;
            for(int i : g.adj(v)) {
                if(visited[i] == false) {
                    Q.enqueue(i);
                    visited[i] = true;
                    answer[i] = moves;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        // Problem 2
        /*
        Graph g = readG("resources/bfs.txt");
        for(int i = 0; i < g.V(); i++) {
            int c = 0;
            for(int j : g.adj(i)) {
                c += g.degree(j);
            }
            StdOut.println(c);
        }
        */

        // problem 4
        /*
        Digraph d = readDig("resources/rosalind_bfs.txt");
        BreadthFirstDirectedPaths answer = new BreadthFirstDirectedPaths(d, 0);
        for(int i = 0; i < d.V(); i++) {
            int dist = answer.distTo(i);
            if (dist < 2147483647) StdOut.println(dist);
            else StdOut.println(-1);
        }
         */

        // problem 5
        EdgeWeightedDigraph e = readEdDig("resources/Dijkstra.txt");
        DijkstraSP answer = new DijkstraSP(e, 0);
        for(int i = 0; i < e.V(); i++) {
            int dist = (int) answer.distTo(i);
            if (dist < 2147483647) StdOut.println(dist);
            else StdOut.println(-1);
        }
    }
}
