package bacon;

import java.util.*; 

public class GraphAdjList{
	private final int V; // number of vertices (can't change once initialized)
    private int E; //number of edges 
    private Bag<Integer>[] adj;

    // Instance variables for BFS 
    private boolean[] marked; 
    private int[] distTo; 
    private Queue<Integer> q;  
    private final int INFINITY = Integer.MAX_VALUE; //Gets the max value for an integer

    public GraphAdjList(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }

        // Initialize instance variables for BFS 
        marked = new boolean[V];
        distTo = new int[V];
        q = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        this.E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Returns the degree of vertex
     */
    public int degree(int v) {
        return adj[v].size();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder(); //StringBuilder allows us to allows changes to the 
                                               // strings without creating new objects each time=
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // Shortest path distance from source vertex s to every other vertex 
    public int[] bfs(int s) {
        for (int v = 0; v < this.V; v++){
            distTo[v] = INFINITY; 
        }
        distTo[s] = 0;
        marked[s] = true;
        q.add(s); // Note! Different syntax for queues from java.util.Queue 

        while (!q.isEmpty()) {
            int v = q.remove();
            for (int w : this.adj(v)) {
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return distTo; 
    }

	public static void main(String[] args){
        int numVer = 5; 
        GraphAdjList graph = new GraphAdjList(numVer);
        
        // Same as our in-class example 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);

        System.out.println(graph);

        System.out.println(Arrays.toString(graph.bfs(0)));   
	}
}