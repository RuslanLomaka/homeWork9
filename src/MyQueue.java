import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    class Node {
        T thing;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            Node n = first;

            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            public T next() {
               T thing = n.thing;
                n = n.next;
                return thing;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = first;
        while (n != null) {
            sb.append(n.thing).append(" ");
            n = n.next;
        }
        return sb.toString().trim();
    }

    public void add(T thing) {
        Node newNode = new Node();
        newNode.thing = thing;
        if (first == null) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public int size() {
        int i = 0;

        Node n = first;
        while (n != null) {
            i++;
            n = n.next;
        }
        return i;
    }

    public Object peek() {
        return first.thing;
    }

    public T poll() {
        T thing = first.thing;
        first = first.next;
        return  thing;
    }

}

class MyQueueSandBox {
    public static void main(String[] args) {
        System.out.println();
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("FIRST");
        myQueue.add("SECOND");
        myQueue.add("THIRD");

        System.out.println("added 3 elements, lets see what are they:");
        System.out.println(myQueue);
        System.out.println();

        myQueue.add("FOURTH");
        myQueue.add("FIFTH");
        myQueue.add("SIXTH");


        System.out.println("Lets use poll() method: "+ myQueue.poll());
        System.out.println("Lets use poll() method: "+ myQueue.poll());

        System.out.println("Printing using for each");
        for (Object a : myQueue) {
            System.out.print(a.toString() + ", ");
        }
        System.out.println();

        System.out.println("once again lets see what are the elements using toString() method: ");
        System.out.println(myQueue);
        System.out.println();

        System.out.println("Lets peek: " + myQueue.peek());

        System.out.println("lets see the size using size() method: " + myQueue.size());

        System.out.println();

        System.out.println("Deleting all elements using clear() method");
        myQueue.clear();
        System.out.println("Lets see what elements are there now:");
        System.out.println(myQueue);

    }
}