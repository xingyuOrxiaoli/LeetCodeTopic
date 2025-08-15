package simple.A面试题_03_01;

public class 三合一 {
}


class TripleInOne {

    private int[][] arr ;
    private int[]   index = new int[3];
    private int     size;

    public TripleInOne(int stackSize) {
        this.arr  = new int[3][stackSize];
        this.size = stackSize;
    }

    public void push(int stackNum, int value) {
        if(index[stackNum] < this.size) arr[stackNum][index[stackNum] ++] = value;
    }

    public int pop(int stackNum) {
        if(index[stackNum] == 0)  return -1;
        return arr[stackNum][--index[stackNum]];
    }

    public int peek(int stackNum) {
        if(index[stackNum] == 0)  return -1;
        return arr[stackNum][index[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return index[stackNum] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */