import java.util.Random;

public class Seminar3 {
    public static void main(String[] args) {
        linkedList myList = new linkedList();
        generateList(myList, 10);
        System.out.println(myList);

        myList.reverse();
        System.out.println(myList);

//        myList.reverseSinglyConnected();
//        System.out.println(myList);

        System.out.println(myList.get(9));

        myList.del(myList.get(3));
        System.out.println(myList);

        myList.delAt(4);
        System.out.println(myList);

        myList.insert(333, myList.get(3));
        System.out.println(myList);

        myList.quickSort();
        System.out.println(myList);

        myList.clear();
        System.out.println(myList);
    }

    public static void generateList(linkedList list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(100));
        }
    }
}
