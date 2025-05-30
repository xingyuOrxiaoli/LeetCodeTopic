package medium.A2359;

import utils.ArrayUtils;

import java.util.*;

public class 找到离给定两个节点最近的节点 {
    public static void main(String[] args) {
        int[] edges = ArrayUtils.createArrayOne("[2,2,3,-1]");
        int i = new 找到离给定两个节点最近的节点().closestMeetingNode(edges, 0, 1);
        System.out.println(i);
    }


    // 暴力所有边
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length , res = -1;
        int[] path1 = build(edges,node1) , path2 = build(edges,node2);

        for(int i = 0 ; i < n ; i++){
            if(path1[i] != 0 && path2[i] != 0){
                if(res == -1 || Math.max(path1[res],path2[res]) > Math.max(path1[i],path2[i])) res = i;
            }
        }
        return res;
    }

    private int[] build(int[] edges, int node) {
        int n = edges.length , level = 1;
        int[] res = new int[n];
        while(node != -1 && res[node] == 0){
            res[node] = level ++;
            node = edges[node];
        }
        return res;
    }

}
