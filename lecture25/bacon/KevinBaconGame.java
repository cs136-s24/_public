package bacon;  

import java.io.*; 
import java.util.*; 

public class KevinBaconGame{

	public Hashtable<String, Integer> symbolTable; //string -> vertex index
	public String[] invertedIndex; // index -> string
	public GraphAdjList graph; //underyling graph that will store the edges 

    private int[] distTo; // Distance from each vertex in our graph to Kevin Bacon

	public KevinBaconGame(String filename){
        File file = new File(filename); 

        // Task 1: Create symbol table 
        this.symbolTable = new Hashtable<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] vertices = line.split("/");
                for (int i = 0; i < vertices.length; i++) { 
                    if (!symbolTable.containsKey(vertices[i]))
                        symbolTable.put(vertices[i], symbolTable.size());
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Task 2: Create inverted index to get string keys in an array
        invertedIndex = new String[symbolTable.size()];
        for (String name : symbolTable.keySet()) {
            invertedIndex[symbolTable.get(name)] = name;
        }

        // Task 3: Second pass through the file builds the graph by 
        // connecting first vertex on each line to all others
        this.graph = new GraphAdjList(symbolTable.size());

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] vertices = line.split("/");
                // New part: 
                int v = symbolTable.get(vertices[0]);
                for (int i=1; i< vertices.length; i++){
                    int w = symbolTable.get(vertices[i]); 
                    graph.addEdge(v, w); 
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("size="+this.invertedIndex.length); 
	}

    private void checkRunBFS(){
        if(this.distTo == null){
            int indexBacon = this.symbolTable.get("Bacon, Kevin");
            this.distTo = this.graph.bfs(indexBacon);
        }
    }

    public int baconNumber(String actor){
        checkRunBFS(); 
        if(this.symbolTable.containsKey(actor)){
            int indexActor = this.symbolTable.get(actor);
            return distTo[indexActor]/2; // b/c always connected by movies 
        }
        else{
            System.out.println(actor+" not in database!"); 
            return -1; 
        }       
    }

    public static void main(String[] args){
        //KevinBaconGame kb = new KevinBaconGame("bacon/toymovies.txt");
        KevinBaconGame kb = new KevinBaconGame("bacon/movies.txt"); 
        

        // System.out.println("\nKey-Value pairs:"); 
        // System.out.println(kb.symbolTable); 
        // System.out.println("\nInverted Index:");  
        // System.out.println(Arrays.toString(kb.invertedIndex));
        // System.out.println("\nGraph:");   
        // System.out.println(kb.graph);
        // System.out.println("---------");

        String actor = "Cruise, Tom"; 
        System.out.println("Bacon number for "+actor+" = "+kb.baconNumber(actor));  
    
        String actor2 = "Pitt, Brad"; // Sleepers together 
        System.out.println("Bacon number for "+actor2+" = "+kb.baconNumber(actor2));  
        
        String actor3 = "Temple, Shirley"; 
        System.out.println("Bacon number for "+actor3+" = "+kb.baconNumber(actor3));  
        
    }
}