import java.util.Iterator;

public class MyHashMap<K, V> implements Iterable<K> {
    private Node last;
    private Node first;

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            Node n = first;

            @Override
            public boolean hasNext() {
                return n != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public K next() {
                K key;

                key = (K) n.key;
                n = n.next;
                return key;
            }
        };
    }

    private static class Node {
        Object key;
        Object value;
        int keyHash;
        Node next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node n = first;
        while (n != null) {
            sb.append("[")
                    .append(n.key)
                    .append(" , ")
                    .append(n.value)
                    .append("] ");
            n = n.next;
        }

        return sb.toString().trim() + "]";

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

    public void put(K key, V value) { // додає пару ключ + значення
        Node n = first;

        while (n != null) {
            if (key.equals(n.key)) {
                n.value = value;
                return;
            }
            n = n.next;
        }
        n = new Node();
        n.key = key;
        n.value = value;
        n.keyHash = key.hashCode();
        if (last == null) {
            first = n;
        } else {
            last.next = n;
        }
        last = n;
    }

    public Object get(Object key) {
        Object value = "";

        Node n = first;
        while (n != null) {
            if (key.equals(n.key)) {
                value = n.value;
            }

            n = n.next;

        }
        return value;
    }

    public void remove(Object key) {
        if (first.key.equals(key)) {
            first = first.next;
            return;
        }

        Node n = first.next;
        Node m = first;//another pointer that helps us to keep in touch with previous element, always one node behind n
        while (n != null) {
            if (n.key.equals(key)) {
                m.next = n.next;
            }
            m = m.next;
            n = n.next;
        }
    }
}

class MyHashMapSandbox {
    public static void main(String[] args) {
        System.out.println("Let's make a collection of the most famous character for each video game platform.");
        MyHashMap<String, String> myMap = new MyHashMap<>();
        System.out.println("Let's add some elements using put() method.");
        myMap.put("Play Station", "Crash Bandicoot");
        myMap.put("Nintendo", "Mario");
        myMap.put("Sega", "Sonic");
        myMap.put("X-Box", "Master Chief");
        myMap.put("Arcade", "Pac-Man");
        System.out.println("Let's see the whole collection using toString() method: ");
        System.out.println(myMap);
        String key = "Sega";
        System.out.println("Let's see what will we get using [" + key + "] key in method myMap.get(key): " + myMap.get(key));
        System.out.println("Let's see what is the size of our collection: " + myMap.size());
        key = "Play Station";
        System.out.println("Let's remove element by key [" + key + "] using method myMap.remove(key): ");
        myMap.remove(key);
        System.out.println("Let's see the whole collection using toString() method: ");
        System.out.println(myMap);
        key = "Nintendo";
        System.out.println("Let's try to put new element, but with a key [" + key + "] that is already in use:");
        myMap.put(key, "Zelda");
        System.out.println("Let's see the whole collection using toString() method: ");
        System.out.println(myMap);
        System.out.println("Let's see what the for each loop will provide us: ");
        for (String k : myMap) {
            System.out.println(k);
        }
        System.out.println("Let's clear()");
        myMap.clear();
        System.out.println("Let's see the whole collection using toString() method: ");
        System.out.println(myMap);
    }
}