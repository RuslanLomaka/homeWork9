public class MyArrayList {

    private Object[] L = new Object[1];

    public void add(Object obj) {
        if (L[L.length - 1] == null) {
            L[L.length - 1] = obj;
        } else {
            Object[] L1 = new Object[L.length + 1];
            for (int i = 0; i < L.length; i++) {
                L1[i] = L[i];
            }
            L1[L1.length - 1] = obj;
            L = L1;
        }
    }

    @Override
    public String toString() {
        StringBuilder myArray = new StringBuilder();
        for (int i = 0; i < L.length; i++) {
            myArray.append(L[i]).append(" ");
        }
        return myArray.toString();
    }

}

class SansBox {
    public static void main(String[] args) {
        MyArrayList mAL = new MyArrayList();
        String myName = "Ruslan";
        String myFriendsName = "Kevin";
        Integer myAge = 33;
        Integer myFriendsAge = 37;

        mAL.add(myName);
        mAL.add(myAge);
        mAL.add(myFriendsName);
        mAL.add(myAge);


        System.out.println(mAL);


    }
}