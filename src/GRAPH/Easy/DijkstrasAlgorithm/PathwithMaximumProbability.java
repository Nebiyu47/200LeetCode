package GRAPH.Easy.DijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {

    class Pair{
        int node;
        double prob ;
        public Pair(int node ,double prob ){
            this.node =node;
            this.prob=prob;
        }
    }

    public  double maxProbability(int [][] edges , double [] succprob , int start , int end){

        int n = edges.length;
        List<List<Pair>> graph = new ArrayList<>();

        for (int i=0;i<edges.length;i++){

            graph.add(new ArrayList<>());
        }

        for (int i=0;i<n;i++){

            int u = edges[i][0];
            int v=edges[i][1];
            double prop=succprob[i];
            graph.get(u).add(new Pair(v,prop));
            graph.get(v).add(new Pair(u,prop));
        }

        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        pq.offer(new Pair(start,1.0));

        double[] maxProp= new double[n];
        maxProp[start]=1.0;
        while (!pq.isEmpty()){

            Pair current = pq.poll();
            int node =current.node;
            double prob = current.prob;

            if(node==end)return prob;
            for(Pair neigbor : graph.get(node)){

                double newprob= prob*neigbor.prob;

                if(newprob>maxProp[neigbor.node]){
                    maxProp[neigbor.node]=newprob;
                    pq.offer(new Pair(neigbor.node,newprob));
                }
            }
        }
        return -1.0;

    }

}
