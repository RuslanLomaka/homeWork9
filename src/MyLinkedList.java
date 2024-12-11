import java.util.Iterator;

class MyLinkedList<T> implements Iterable<T> {
    Node current;
    Node first;

    @Override
    public Iterator<T> iterator() {
        current=first;

        return new Iterator<>() {
            @Override
            public boolean hasNext() {

               // System.out.println("Has next called");
               return current.next!=null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                Object thing = current.thing;
                current=current.next;

                return (T) thing;
            }
        };

    }

    private static class Node {
        Node next;
        Object thing;
        Node prev;
    }

    public void add(T thing) {
        Node newNode = new Node();

        if (current == null) {
            current = new Node();
            current.thing = thing;
            newNode.prev = current;
            current.next = newNode;
            first = current;

        } else {
            current.thing = thing;
            newNode.prev = current;
            current.next = newNode;

        }
        current = current.next;
    }

    public void remove(int i) {
        if (i == 0) {
            first = first.next;
        } else {
            current = first;
            for (int j = 1; j < i; j++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        T thing = null;

        current = first;
        int i = 0;
        while (current.next != null) {
            if (i == index)

                thing = (T) current.thing;
            i++;
            current = current.next;
        }


        return thing;
    }


    public int size() {
        if (current == null) {
            return 0;
        }
        int i = 0;
        current = first;
        while (current.next != null) {
            i++;
            current = current.next;
        }

        return i;
    }

    @Override
    public String toString() {
        if (current == null) {
            return "empty";
        }
        StringBuilder sb = new StringBuilder();

        current = first;
        while (current.next != null) {
            sb.append(current.thing);
            sb.append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public void clear() {
        current = null;
        first = null;
    }
}


class MyLinkedListSandBox {
    public static void main(String[] args) {

        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add("Zero");
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        System.out.println("Current list: " + myList);
        System.out.println("Size: " + myList.size());

        System.out.println("Lets print them using for each loop");

        for (String k :myList){
            System.out.println(k);
        }

        int i = 4;
        System.out.println("Trying to get element by number [" + i + "]: " + myList.get(i));

        System.out.println("removing element [" + i + "] from  myList: " + myList.get(i));

        myList.remove(i);

        System.out.println("Current list: " + myList);
        System.out.println("Clearing myList");
        myList.clear();
        System.out.println("Current list: " + myList);
        System.out.println("Size: " + myList.size());

    }
}