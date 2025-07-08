package medium.A284;

import java.util.Iterator;

public class 窥视迭代器 {
}
class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
    private Integer nextVal ;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.nextVal = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.nextVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = this.nextVal;
        this.nextVal = iterator.hasNext() ? iterator.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return this.nextVal != null;
    }
}