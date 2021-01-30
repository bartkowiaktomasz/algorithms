class Graph{

    class Edge{
        int src, dest, weight;

        Edge(){
            src = dest = weight = 0;
        }
    };

    int noVertices, noEdges;
    Edge edge[];

    Graph(int _noVertices, int _noEdges){
        noVertices = _noVertices;
        noEdges = _noEdges;

        edge = new Edge[noEdges];
        for(int i = 0; i < noEdges; i++){
            edge[i] = new Edge();
        }
    }

    // A utility function used to print the solution
    void printArr(int dist[], int noVertices)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < noVertices; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }

    void relax(Graph graph, Edge edge, int dist[]){
        int noEdges = graph.noEdges;
        int u, v, weight;
        for(int i = 0; i < noEdges; i++){
            u = graph.edge[i].src;
            v = graph.edge[i].dest;
            weight = graph.edge[i].weight;
            if( dist[u] != Integer.MAX_VALUE &&
                dist[v] > dist[u] + weight){
                    dist[v] = dist[u] + weight;
                }
        }
    }

    void bellmanFord(Graph graph, int src){
        int noVertices = graph.noVertices;
        int noEdges = graph.noEdges;

        // Create distance array
        int dist[] = new int[noVertices];

        // Initialise distances
        for(int i = 0; i < noVertices; i++){
            dist[i] = Integer.MAX_VALUE;  // Distance = infinity
        }
        dist[src] = 0;

        // Relax all edges |V| - 1 times
        for(int i = 0; i < noVertices - 1; i++){
            relax(graph, edge[i], dist);
        }

        // Check for negative cycles
        // Copy distance array
        int distCopy[] = new int[noVertices];
        for(int i = 0; i < noVertices; i++){
            distCopy[i] = dist[i];
        }

        // Try relaxing edges again
        for(int i = 0; i < noEdges; i++){
            relax(graph, edge[i], distCopy);
        }

        // If something changed in the dist array => negative cycles
        for(int i = 0; i < noVertices; i++){
            if(dist[i] != distCopy[i]){
                System.out.printf("Negative cycle detected!\n");
            }
        }

        printArr(dist, noVertices);
    }

    public static void main(String args[]){

        /* Graph from geeksforgeeks.org */
        int noVertices = 5;  // Number of vertices in graph
        int noEdges = 8;  // Number of edges in graph

        Graph graph = new Graph(noVertices, noEdges);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        graph.bellmanFord(graph, 0);
    }
}
