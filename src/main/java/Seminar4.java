public class Seminar4 {
    public static void main(String[] args) {
        BinTree myTree = new BinTree();

        myTree.add(5);
        myTree.add(1);
        myTree.add(9);
        myTree.add(7);
        myTree.add(6);
        myTree.add(2);
        myTree.add(0);

        System.out.println(myTree.contain(5));
        System.out.println(myTree.contain(3));
    }
}
