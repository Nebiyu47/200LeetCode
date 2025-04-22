package GRAPH.Medium;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {

    }
    public static boolean canFinsh(int numCourse , int [][] prerequisites  ){

        // its a direct graph beacuse in order to take course 1 you must taken 0 0->1 no to 1 <-0

        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0;i<numCourse;i++){
            graph.add(new ArrayList<>());
        }
        for (int [] course : prerequisites){

            int u = course[1]; // prerequisites
            int v = course[0]; //course
            graph.get(u).add(v);
        }
          int[] vtisted= new int[numCourse];
        for (int i=0;i<numCourse;i++){
            if(isCyle(graph,vtisted,i)){
                return false;
            }
        }
return true;
    }
public static boolean isCyle(List<List<Integer>> grpah , int [] visted , int node){
        if(visted[node]==1) return true;
        if(visted[node]==2) return false;

        visted[node]=1;
        for (int negibor : grpah.get(node)){
            if(isCyle(grpah,visted,node)){
                return true;
            }
        }
        visted[node]=2;
        return false;
}
}
