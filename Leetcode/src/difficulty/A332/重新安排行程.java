package difficulty.A332;

import java.util.*;

public class 重新安排行程 {

    List<String> res = new ArrayList<>();
    HashMap<String , PriorityQueue<String>> graph = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0) , new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String node) {
        PriorityQueue<String> queue = graph.get(node);
        while (queue != null && !queue.isEmpty()) {
            String next = queue.poll();
            dfs(next);
        }
        res.add(0 , node);
    }
}
