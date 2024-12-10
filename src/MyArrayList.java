import java.util.Iterator;//  NOT COLLECTION LIBRARY was taken only to practice with for each loop realisation

public class MyArrayList<T> implements Iterable<T> {

    private Object[] L = new Object[1];

    public Iterator<T> iterator() {
        return new Iterator<>() {
            int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < size();
            }

            @Override
            public T next() {
                Object element = L[currentPosition];
                currentPosition++;
                return (T) element;
            }
        };
    }

    public void add(T obj) {
        if (L[L.length - 1] == null) {
            L[L.length - 1] = obj;
        } else {
            Object[] L1 = new Object[L.length + 1];
            System.arraycopy(L, 0, L1, 0, L.length);
            L1[L1.length - 1] = obj;
            L = L1;
        }
    }

    @Override
    public String toString() {
        StringBuilder myArray = new StringBuilder();
        for( Object o : L) {
            myArray.append(o).append(" ");
        }
        return myArray.toString().trim();
    }

    public void remove(int index) {
        Object[] L1 = new Object[L.length - 1];

        if (index >= 0) {
            System.arraycopy(L, 0, L1, 0, index);
        }
        if (L.length - 1 - index >= 0) {
            System.arraycopy(L, index + 1, L1, index, L.length - 1 - index);
        }
        L = L1;
    }

    public int size() {
        return L.length;
    }

    public T get(int i) {
        return (T)L[i];
    }

    public void clear() {
        L = new Object[]{};
    }

}

class MyArrayListSansBox {
    public static void main(String[] args) {
        MyArrayList <Object> MyList  = new MyArrayList<>();
        System.out.println("Collection created, lets add some elements!");
        String myName = "Ruslan";
        String myFriendsName = "Kevin";
        Integer myAge = 33;
        Integer myFriendsAge = 37;
        String WTF = "RandomGuy";

        MyList.add(myName);
        MyList.add(myAge);
        MyList.add(WTF);
        MyList.add(myFriendsName);
        MyList.add(myFriendsAge);

        System.out.println("After adding elements the size of MyList is: " + MyList.size());
        System.out.println("Here are the elements: " + MyList);

        System.out.println("Lets check types of elements using FOR EACH cycle");
        for (Object o : MyList) {
            System.out.println(o.getClass());
        }

        MyList.remove(2);
        System.out.println("After removing elements the size of MyList is: " + MyList.size());
        System.out.println("Here are the elements: " + MyList);

        System.out.println("Lets check types of elements using FOR EACH cycle");

        for (Object o : MyList) {
            System.out.println(o.getClass());
        }

        System.out.println("Getting element by position index 2: " + MyList.get(2));

        MyList.clear();
        System.out.println("Checking the size after cleaning the collection: " + MyList.size());
        System.out.println("Printing collection right after it was cleaned: " + MyList);
    }
}