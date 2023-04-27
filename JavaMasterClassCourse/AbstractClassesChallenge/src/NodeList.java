public interface NodeList {

    ListItem getRoot(); // Going to be actual ListItem itself - because every data structure we create must have a starting node which is a ListItem. Hence why we made this
    // Also known as HeadList in LinkedList
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);  // To go through the list from the root
}
