package difficulty.A1948;


import utils.ArrayUtils;

import java.util.*;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class 删除系统中的重复文件夹 {

    class Trie{
        Map<String, Trie> children;
        boolean deleted ;
        String name;
    }
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();
        for (List<String> path : paths) {
            Trie cur = root;
            for(String key : path){
                cur.children.putIfAbsent(key , new Trie());
                cur = cur.children.get(key);
                cur.name = key;
            }
        }
        Map<String, Trie> expressionMap = new HashMap<>();
        for (Trie value : root.children.values()) gainExpressionMap(value , expressionMap);




        return res;
    }

    private String gainExpressionMap(Trie node, Map<String, Trie> expressionMap) {
        if(node.children.isEmpty()) return node.name;
        return "";
    }


}
class Solution {
    private static class TrieNode {
        Map<String, TrieNode> son = new HashMap<>();
        String name; // 文件夹名称
        boolean deleted = false; // 删除标记
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            // 把 path 插到字典树中，见 208. 实现 Trie
            TrieNode cur = root;
            for (String s : path) {
                if (!cur.son.containsKey(s)) {
                    cur.son.put(s, new TrieNode());
                }
                cur = cur.son.get(s);
                cur.name = s;
            }
        }

        Map<String, TrieNode> exprToNode = new HashMap<>(); // 子树括号表达式 -> 子树根节点
        for (TrieNode son : root.son.values()) {
            genExpr(son, exprToNode);
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (TrieNode son : root.son.values()) {
            dfs(son, path, ans);
        }
        return ans;
    }

    private String genExpr(TrieNode node, Map<String, TrieNode> exprToNode) {
        if (node.son.isEmpty()) { // 叶子
            return node.name; // 表达式就是文件夹名
        }

        List<String> expr = new ArrayList<>();
        for (TrieNode son : node.son.values()) {
            // 每个子树的表达式外面套一层括号
            expr.add("(" + genExpr(son, exprToNode) + ")");
        }
        Collections.sort(expr);

        String subTreeExpr = String.join("", expr); // 按字典序拼接所有子树的表达式
        TrieNode n = exprToNode.get(subTreeExpr);
        if (n != null) { // 哈希表中有 subTreeExpr，说明有重复的文件夹
            n.deleted = true; // 哈希表中记录的节点标记为删除
            node.deleted = true; // 当前节点标记为删除
        } else {
            exprToNode.put(subTreeExpr, node);
        }

        return node.name + subTreeExpr;
    }

    // 在字典树上回溯，仅访问未被删除的节点，并将路径记录到答案中
    // 类似 257. 二叉树的所有路径
    private void dfs(TrieNode node, List<String> path, List<List<String>> ans) {
        if (node.deleted) {
            return;
        }
        path.add(node.name);
        ans.add(new ArrayList<>(path)); // 记录路径
        for (TrieNode son : node.son.values()) {
            dfs(son, path, ans);
        }
        path.remove(path.size() - 1); // 恢复现场
    }


}
