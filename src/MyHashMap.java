public class MyHashMap {
private Node last;
private Node first;
    private  class Node{
        Object key;
        Object value;
        Node next;
    }



   public void  put(Object key, Object value){ // додає пару ключ + значення
        Node n = new Node();
        n.key=key;
        n.value=value;



   }




//    remove(Object key) видаляє пару за ключем
//    clear() очищає колекцію
//    size() повертає розмір колекції
//    get(Object key) повертає значення (Object value) за ключем






}
class MyHashMapSandbox{
    public static void main(String[] args) {
        MyHashMap myMap=new MyHashMap();





    }
}
