import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        int connections;
        int rVertex;
        int graphVertices;
        int edgeCount;
        int vValue;
        int sValue;
        boolean displayVertexGeneration = true;

        ArrayList<Integer> valueList;
        Scanner vQ = new Scanner(System.in);
        Scanner dQ = new Scanner(System.in);
        String dVertexYN;

        System.out.println("IT 2660 Fall 2019: Chapter 6 - Graphs\n\n" +
                "Vertex Quantity: Please enter a number between 2 and 10000.");

        //User Selects Vertex Quantity
        graphVertices = vQ.nextInt();
        while (graphVertices > 10000 || graphVertices < 2) {
            System.out.println("Invalid entry. Please enter a number between 2 and 10000");
            graphVertices = vQ.nextInt();
        }

        //User Selects if Vertex Generation is displayed
        System.out.println("\nDisplay Vertex Generation? (y/n)");
        dVertexYN = dQ.nextLine();
        while (!(dVertexYN.equals("y") || dVertexYN.equals("n"))) {
            System.out.println("Invalid entry. Please enter 'y' or 'n'");
            dVertexYN = dQ.next();
        }
        if (dVertexYN.equals("n")) {
            displayVertexGeneration = false;
        }

        //Instantiate Directed Graph
        Graph graph = new Graph(graphVertices);

        //Generate Unique Vertex Values
        valueList = new ArrayList<>();
        for (int i = 1; i < (graphVertices + 1); i++) {
            valueList.add(i);
        }
        Collections.shuffle(valueList);

        //Instantiate Vertices
        for(int i = 0; i < graphVertices; i++) {
            vValue = valueList.get(i);
            graph.insertVertex(i, (new Vertex(vValue)));
        }

        edgeCount = 0;

        //Generate n edges for each vertex, where 0 < n <= 5
        for(int i = 0; i < graphVertices; i++) {
            connections = ThreadLocalRandom.current().nextInt(1, (5) + 1);
            edgeCount = connections + edgeCount;
            for (int j = 0; j < connections; j++) {
                rVertex = ThreadLocalRandom.current().nextInt(0, graphVertices);
                graph.insertEdge(i, rVertex);
            }
            if (displayVertexGeneration) {
                System.out.println("Vertex " + i);
                graph.showEdges(i);
                System.out.println("Value: " + graph.vertex[i].getValue() + "\n");
            }
        }

        System.out.println("\nGraph Generation completed.\n" +
                + graphVertices + " vertices\n" +
                + edgeCount + " edges\n");

        Scanner mM = new Scanner(System.in);
        Scanner sV = new Scanner(System.in);

        //Main Menu
        while (true) {
            System.out.println("Please choose from one of the following options:\n" +
                    "1) Breadth-First Traversal\n" +
                    "2) Depth-First Traversal\n" +
                    "3) Shortest Path Tree (Dijkstra's Algorithm)\n" +
                    "4) Exit");

            String option = mM.next();

            //Main Menu Options
            switch (option) {

                //Breadth-First Traversal
                case "1": {
                    System.out.println("Breadth-First Traversal: Search for a vertex by entering a numeric value.");

                    while (!sV.hasNextInt()){
                        System.out.println("Please enter an integer.");
                        sV.next();
                    }
                    sValue = sV.nextInt();
                    if (graph.BFT(0, graph, sValue)) {
                        System.out.println("Vertex found. Press Enter to return to Main Menu");
                    }
                    else {
                        System.out.println("Vertex not found. Press Enter to return to Main Menu.");
                    }
                    graph.resetAllSearched();
                    try {
                        System.in.read();
                    }
                    catch(Exception e) {
                    }
                    break;
                }

                //Depth-First Traversal
                case "2": {
                    System.out.println("Depth-First Traversal: Search for a vertex by entering a numeric value.");
                    while (!sV.hasNextInt()){
                        System.out.println("Please enter an integer.");
                        sV.next();
                    }
                    sValue = sV.nextInt();
                    if (graph.DFT(0, sValue)) {
                        System.out.println("Vertex found. Press Enter to return to Main Menu");
                    }
                    else {
                        System.out.println("Vertex not found. Press Enter to return to Main Menu.");
                    }
                    graph.resetAllPushed();
                    try {
                        System.in.read();
                    }
                    catch(Exception e) {
                    }
                    break;
                }

                //Dijkstra's Algorithm
                case "3": {
                    System.out.println("Shortest Path Tree (Dijkstra's Algorithm): Enter source vertex.");
                    while (!sV.hasNextInt()){
                        System.out.println("Please enter an integer.");
                        sV.next();
                    }
                    sValue = sV.nextInt();
                    while (sValue < 0 || sValue > (graphVertices - 1)) {
                        System.out.println("Invalid entry. Please enter a number between 0 and " + (graphVertices - 1) + ".");
                        sValue = sV.nextInt();
                    }
                    graph.SPT(sValue);
                    System.out.println("\nPress Enter to return to Main Menu.");
                    try {
                        System.in.read();
                    }
                    catch(Exception e) {
                    }
                    break;
                }

                //Program Exit
                case "4": {
                    System.out.println("Exiting program. Have a good day!");
                    vQ.close();
                    dQ.close();
                    mM.close();
                    sV.close();
                    System.exit(0);
                }

                //Main Menu Entry Error
                default: {
                    System.out.println("Entry error.\n");
                    break;
                }
            }
        }
    }
}
