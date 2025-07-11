package difficulty.A295;

import java.util.PriorityQueue;

public class 数据流的中位数 {
}
class MedianFinder {


    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>((a , b) -> b - a);// 大根堆
        this.max = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(min.isEmpty()){
            min.add(num);
        }else{
             if(min.size() == max.size()){
                 if(num <= max.peek()) min.add(num);
                 else {
                     min.add(max.poll());
                     max.add(num);
                 }
             }else{
                 if(num >= min.peek()) max.add(num);
                 else {
                     max.add(min.poll());
                     min.add(num);
                 }
             }
        }
    }

    public double findMedian() {
        if(min.size() == max.size()) return (double)(min.peek() + max.peek()) / 2;
        return min.peek();
    }
}

