/**
 * Adjacency list for a graph 
 */

package ugraph;  

public class GraphAdjList{
	private final int V; // number of vertices (can't change once initialized)
    private int E; //number of edges 
    private Bag<Integer>[] adj;

    public GraphAdjList(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        this.E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
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

	public static void main(String[] args){
        int numVer = 5; 
        GraphAdjList graph = new GraphAdjList(numVer);
        
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);

        System.out.println(graph);
	}
}