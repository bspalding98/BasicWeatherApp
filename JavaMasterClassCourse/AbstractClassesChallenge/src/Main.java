public class Main {
    public static void main(String[] args) {


//        MyLinkedList list = new MyLinkedList(null); // null means it is empty
//        list.traverse(list.getRoot());
//        // Create a string data array to acoid typing loads of addItem instructions
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
//
//        String[] data = stringData.split(" ");
//        for(String s : data) {
//            // create new item with value set to the string s
//            list.addItem(new Node(s));
//        }
//
//        list.traverse(list.getRoot());


//        MyLinkedList list = new MyLinkedList(null); // null means it is empty
//        list.traverse(list.getRoot());
//        // Create a string data array to acoid typing loads of addItem instructions
//        String stringData = "5 7 3 9 8 2 1 0 4 6";
//
//        String[] data = stringData.split(" ");
//        for(String s : data) {
//            // create new item with value set to the string s
//            list.addItem(new Node(s));
//        }
//
//        list.traverse(list.getRoot());

        
        
        
//        RECURSIVE METHOD - searchTree
        
        
        SearchTree tree = new SearchTree(null); // null means it is empty
        tree.traverse(tree.getRoot());
        // Create a string data array to acoid typing loads of addItem instructions
        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for(String s : data) {
            // create new item with value set to the string s
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());

        
    }
}
