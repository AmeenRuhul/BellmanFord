/**
 * Date 11/11/2017
 * @author Mohd.Ruhul Ameen
 * ID : 1610676102
 * Lab Assignment : CSE2222 : Design and Analysis of Algorithm Lab
 * CSE,University of Rajshahi
 * Bellman Ford Algorithm
 */

import java.util.*;
import java.lang.*;
import java.io.*;


public class Graph
{
    int numberOfVertices, numberofEdges;

    Graph(int vertices, int edges)
    {
         int i ;

        numberOfVertices = vertices;
        numberofEdges = edges;

        edge = new Edge[edges];

        for (i=0; i<edges; i++)

            edge[i] = new Edge();
    }


    class Edge
    {
        private int source;
        private int destination;
        private int weight;

        Edge()
        {
            source = 0;
            destination = 0;
            weight = 0;
        }
    };



    Edge[] edge = new Edge[0];


    void bellmanFord(Graph graph,int source)
    {
        int vertex = graph.numberOfVertices;
        int edges = graph.numberofEdges;
        int distance[] = new int[numberOfVertices];


        for (int i=0; i<numberOfVertices; i++)
            distance[i] = Integer.MAX_VALUE; // taking it as infinite
        distance[source] = 0;


        for (int i=1; i<numberOfVertices; i++)
        {
            for (int j=0; j<numberofEdges; j++)
            {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;

                if ( distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v] )

                    distance[v] = distance[u] + weight;

            }
        }


        for (int j=0; j < numberofEdges; j++)
        {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u]+weight < distance[v])

                System.out.println("There is negative weight cycle in graph");
        }
        print(distance, numberOfVertices);
    }


    void print(int dist[], int V)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t"+dist[i]);
    }



        public static void main(String [] args)
        {


            int V = 5;
            int E = 8;

            Graph graph = new Graph(V, E);


            graph.edge[0].source = 0;
            graph.edge[0].destination = 1;
            graph.edge[0].weight = -1;


            graph.edge[1].source = 0;
            graph.edge[1].destination = 2;
            graph.edge[1].weight = 4;


            graph.edge[2].source = 1;
            graph.edge[2].destination = 2;
            graph.edge[2].weight = 3;


            graph.edge[3].source = 1;
            graph.edge[3].destination = 3;
            graph.edge[3].weight = 2;


            graph.edge[4].source = 1;
            graph.edge[4].destination = 4;
            graph.edge[4].weight = 2;


            graph.edge[5].source = 3;
            graph.edge[5].destination = 2;
            graph.edge[5].weight = 5;


            graph.edge[6].source = 3;
            graph.edge[6].destination = 1;
            graph.edge[6].weight = 1;


            graph.edge[7].source = 4;
            graph.edge[7].destination = 3;
            graph.edge[7].weight = -3;

            graph.bellmanFord(graph,0);
        }



}
