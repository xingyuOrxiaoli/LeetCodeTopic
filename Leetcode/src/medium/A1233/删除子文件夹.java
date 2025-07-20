package medium.A1233;

import java.util.*;

public class 删除子文件夹 {

    public static void main(String[] args) {
        List<String> res = new 删除子文件夹().removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"});
        System.out.println(res);
    }
    class DictTree{
        boolean flag ;
        Map<String,DictTree> children;
        public DictTree(){
            this.flag = false;
            this.children = new HashMap<>();
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        // 目录深度  1 ~ 50 个
        // 2 <= folder[i].length <= 100
        DictTree root = new DictTree();
        for(String path : folder){
            List<String> paths = split(path);

            DictTree cur = root;
            for (String key : paths) {
                cur.children.putIfAbsent(key , new DictTree());
                cur = cur.children.get(key);
            }
            cur.flag = true;
        }
        List<String> res = new ArrayList<>();
        Queue<DictTree> queue = new LinkedList<>();
        Queue<String> keys = new LinkedList<>();
        queue.offer(root);
        keys.offer("");
        while(!queue.isEmpty()){
            DictTree cur = queue.poll();
            String key = keys.poll();
            if(cur.flag){
                res.add(key);
            }else{
                cur.children.forEach((k,v)->{
                    queue.offer(v);
                    keys.offer(k);
                });
            }
        }
        return res;
    }

    private List<String> split(String path) {
        int n = path.length();
        StringBuilder t_path = new StringBuilder();
        List<String> res = new ArrayList<>();
        t_path.append("/");
        for (int i = 1; i < n; i++) {
            if(path.charAt(i) == '/') res.add(t_path.toString());
            t_path.append(path.charAt(i));
        }
        res.add(t_path.toString());
        return res;
    }
}
