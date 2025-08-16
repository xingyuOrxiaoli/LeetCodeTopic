package simple.A面试题03_06;

import java.util.LinkedList;
import java.util.Queue;

public class 动物收容所 {
}


class AnimalShelf {

    Queue<int[]> queue = new LinkedList<>() , dog = new LinkedList<>() , cat = new LinkedList<>() ;
    public AnimalShelf() {
    }

    public void enqueue(int[] animal) {
        queue.add(animal);
        if(animal[1] == 0) cat.offer(animal);
        else dog.offer(animal);
    }

    public int[] dequeueAny() {
        if(cat.isEmpty() && dog.isEmpty()) return new int[]{-1 , -1};
        while (cat.peek() != queue.peek() && dog.peek() != queue.peek()) queue.poll();

        if(cat.peek() == queue.peek()) cat.poll();
        else dog.poll();
        return queue.poll();
    }

    public int[] dequeueDog() {
        if(dog.isEmpty()) return new int[]{-1 , -1};
        return dog.poll();
    }

    public int[] dequeueCat() {
        if(cat.isEmpty()) return new int[]{-1 , -1};
        return cat.poll();
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */