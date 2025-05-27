package GRAPH.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourse , int[][] prequusites){
        List<List<Integer>> graph = new ArrayList<>();
        for (int i =0;i<numCourse;i++) graph.add(new ArrayList<>());
        for (int [] pair : prequusites){
            int u= pair[0];
            int v=pair[1];
            graph.get(u).add(v);
        }
        boolean [] visted = new boolean[numCourse];
        boolean [] path = new boolean[numCourse];
        Stack<Integer>stack = new Stack<>();
        for (int i =0;i<numCourse;i++){
            if(!visted[i]&&!dfs(i,graph,visted,path,stack)){
                return new int[]{};
            }
        }
        int[] order = new int[numCourse];
        for (int i=0;i<numCourse;i++){
            order[i]=stack.pop();
        }
        return order;
    }
    public static boolean dfs(int course ,List<List<Integer>>graph , boolean[] visted , boolean[] path, Stack<Integer> stack){

        if(path[course])return false;
        if(visted[course])return true;
        visted[course]=true;
        path[course]=true;
        for (int next : graph.get(course)){
            if(!dfs(next,graph,visted,path,stack)){
                return false;
            }
        }
        path[course]=false;
        stack.push(course);
        return true;
    }
}
