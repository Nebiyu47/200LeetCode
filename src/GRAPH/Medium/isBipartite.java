package GRAPH.Medium;

public class isBipartite {
    public static void main(String[] args) {

    }
    public static boolean isBipartite(int [][] graph ){
        int n = graph.length;
        int [] colors= new int[n];
        for (int i=0;i<n;i++){
          if(colors[i]==0&&!dfs(graph,colors,i,1)){
              return false;
          }
        }
        return true;
    }
    private static boolean dfs(int[][] graph , int [] colors , int node , int color){
        colors[node]=color;
        for(int neigbor : graph[node]){
            if(colors[neigbor]==0){
                if (!dfs(graph,colors,neigbor,-color))return false;
            }else if(colors[neigbor]==color){
                return false;
            }
        }
        return true;
    }
}
