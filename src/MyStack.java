import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

    private Node top;

    private static class Node {
        Object thing;
        Node lower;
        Node upper;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node n = top;
            @Override
            public boolean hasNext() {
                return n != null;
            }
            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                T thing = (T)n.thing;
                try {
                    n = n.lower;
                } catch (NullPointerException E) {
                    return thing;
                }
                return thing;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = top;

        while (n != null) {
            sb.append(n.thing).append(" ");
            n = n.lower;
        }
        return sb.toString().trim();
    }


    public void push(T thing) {
        Node newNode = new Node();
        newNode.thing = thing;
        if (top != null) {
            top.upper = newNode;
            newNode.lower = top;
        }
        top = newNode;

    }

    public int size() {
        int i = 0;
        Node n = top;
        while (n != null) {
            i++;
            n = n.lower;
        }
        return i;
    }

    public Object peek() {
        return top.thing;
    }

    public Object pop() {

        Object thing = top.thing;
        top = top.lower;
        return thing;
    }

    public void remove(int index){
        if(index==0){
            top.lower.upper=null;
            top=top.lower;
            return;
        }
        int i = 1;
        Node n = top;
        while(iterator().hasNext()){

            if(i==index){
               n.upper.lower=n.lower;
               n.lower.upper=n.upper;
           }
            if(n.lower==null){
                return;
            }
            n=n.lower ;
            i++;
        }
    }

}

class MyStackSandBox {

    public static void main(String[] args) {

        System.out.println("Lets create a stack of some released GTA series video games");
        MyStack<String> myStack = new MyStack<>();
        myStack.push("0:GTA London 1961");
        myStack.push("1:GTA London 1969");
        myStack.push("2:GTA III");
        myStack.push("3:GTA Vice City");
        myStack.push("4:GTA San Andreas");
        myStack.push("5:GTA IV");
        myStack.push("6:GTA V");

        System.out.println("Lets print them all using for each");
        for (Object d:myStack){
            System.out.println(d);
        }
        System.out.println();
        System.out.println("Printing my stack using toString() method: " + myStack);
        System.out.println("Lets use the size() to check the size: " + myStack.size());

        System.out.println("Lets peek(): " + myStack.peek());
        System.out.println("Lets pop(): " + myStack.pop());
        System.out.println("Lets pop(): " + myStack.pop());
        System.out.println("Lets use the size() to check the size: " + myStack.size());

        System.out.println("Printing my stack using toString() method to see what has left: " + myStack);

        int i =0;
        System.out.println("Removing element["+i+"] ");
        myStack.remove(i);
        System.out.println("Printing my stack using toString() method to see what has left: " + myStack);
    }

}