package medium.A133;

import sun.reflect.generics.tree.Tree;
import utils.Node;

import java.util.*;

public class 克隆图 {
    public static void main(String[] args) {

        List<Node> list = new ArrayList<>();
        for(int i = 0 ; i <= 4 ; i ++){
            list.add(new Node(i));
            list.get(i).neighbors = new ArrayList<>();
        }
        list.get(1).neighbors.add(list.get(2));
        list.get(1).neighbors.add(list.get(4));

        list.get(2).neighbors.add(list.get(1));
        list.get(2).neighbors.add(list.get(3));

        list.get(3).neighbors.add(list.get(2));
        list.get(3).neighbors.add(list.get(4));

        list.get(4).neighbors.add(list.get(1));
        list.get(4).neighbors.add(list.get(3));

        Node node1 = new 克隆图().cloneGraph(list.get(1));
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> dict = new ArrayList<>();
        TreeSet<Integer> visited = new TreeSet<>();
        Queue<Node> queue = new LinkedList<>();
        // 初始化
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(visited.contains(cur.val)) continue;
            for(int i = dict.size() ; i <= cur.val ; i++) {
                dict.add(new Node(i));
                dict.get(i).neighbors = new ArrayList<>();
            }
            cur.neighbors.forEach(n -> {
                for(int i = dict.size() ; i <= n.val ; i++) {
                    dict.add(new Node(i));
                    dict.get(i).neighbors = new ArrayList<>();
                }
                dict.get(cur.val).neighbors.add(dict.get(n.val));
                if(!visited.contains(n.val)) queue.add(n);
            });

            visited.add(cur.val);
        }
        return dict.get(1);
    }
}

