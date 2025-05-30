package GRAPH.Medium;

import java.util.*;

class  findItinerary {
   private static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private static LinkedList<String>result = new LinkedList<>();
    public static List<String> findItineray (List<List<String>> tickets){
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        LinkedList<String>result = new LinkedList<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to =ticket.get(1);
            graph.putIfAbsent(from,new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        for (Map.Entry<String, PriorityQueue<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        return result;
    }
    public static void dfs(String airport){
        PriorityQueue<String> nextAirport = graph.get(airport);
        while (nextAirport!=null&&!nextAirport.isEmpty()){
            String next= nextAirport.poll();
            dfs(next);
        }
        result.addFirst(airport);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(findItineray(tickets));
    }
}
