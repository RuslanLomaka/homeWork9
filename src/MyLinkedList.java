class MyLinkedList {
    Node current;
    Node first;

    private class Node {
        Node next;
        Object thing;
    }

    public void add(Object thing) {
        Node newNode = new Node();

        if (current == null) {
            current = new Node();
            current.thing = thing;
            current.next = newNode;
            first = current;

        } else {
            current.thing = thing;
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

    public Object get(int index) {
        Object thing = null;

        current = first;
        int i = 0;
        while (current.next != null) {
            if (i == index)
                thing = current.thing;
            i++;
            current = current.next;
        }


        return thing;
    }


    public int size() {
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

        MyLinkedList myList = new MyLinkedList();
        myList.add("Zero");
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        System.out.println("Current list: "+myList);
        System.out.println("Trying to get element by number " + myList.get(6));

        System.out.println("Current list: "+myList);
        System.out.println("Size: " + myList.size());

        myList.remove(0);
        System.out.println("Current list: "+myList);
        System.out.println("Clearing myList");
        myList.clear();
        System.out.println("Current list: "+myList);

    }
}