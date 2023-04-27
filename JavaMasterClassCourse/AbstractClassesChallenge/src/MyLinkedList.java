// Creating our own LinkedList class.

public class MyLinkedList implements NodeList {
    private ListItem root = null;   // null means it is originally empty

    public MyLinkedList(ListItem root) {        // Root is the head of the list.
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    //EVERYTIME we set a new item. We were setting next and previous item unless there was no next or previous then just one. Since Node class
    // setNext() and setPrevious() setting them and also return the reference as well (item). so can shortcut
    // commented out code is old code
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            // The list was empty, so this item becomes the head of the list.
            this.root  = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {    // Will iterate through the list and if it is null that essentially means there are no more entries to go through the list.
            int comparison = (currentItem.compareTo(newItem));  // REMEMBER return a negative, 0 or positive number depending on the comparison.
            if(comparison < 0) {
                // newItem is greater, move right if possible
                if(currentItem.next() != null) currentItem = currentItem.next();   // checking if there is an item next to even go to. So it doesn't throw an error if not.
                else {
                    // there is no next, so insert at end of list
//                    currentItem.setNext(newItem);
//                    newItem.setPrevious(currentItem);   // I think to link them so newItem.previous can go back to something which in this instance would be currentItem???
                    currentItem.setNext(newItem).setPrevious(currentItem);  // Making currentItem newItem so then setting previous to currentItem which is now newItem. because of NodeClass
                    return true;
                }
            } else if(comparison > 0) {
                // new item is less, insert before.
                if(currentItem.previous() != null) {    // currentitem is 3. newItem is 2 and previousItem is 1
//                    currentItem.previous().setNext(newItem);    // going ot the previous position and inserting newItem 2 before 3 now.
//                    newItem.setPrevious(currentItem.previous());    // Now setting newItem previous to old currentItem previous which is 1. so it 1 2 3
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
//                    newItem.setNext(currentItem);               // setting newItem to current so 3. so now 1 2 3 and it is all linked in memory
//                    currentItem.setPrevious(newItem);           // setting 3 to have 2 as previous now. so it is all fixed and next and preivous will work.
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node with a previous is the root.
//                    newItem.setNext(this.root); // making this current root the next one to newitem as it it about to become the root
//                    this.root.setPrevious(newItem); // Making old root to point back to new root (above one) so setting a previous link coz now needs one.
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;    // Setting head to become this item.
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added");  // We do no want duplicates.
                return false;   // Need this or it might iterate through still.
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) System.out.println("Deleting item " + item.getValue());
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // found the item to delete
                if(currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next()); // EG if this was 2nd item. this line runs because it wasnt root. so now 1st item (root) haas set the next item to the 3rd one because 2nd will be remove.
                    if(currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if(comparison < 0) {
                currentItem = currentItem.next();
            } else { // comparison > 0;
                // we are at an item greater than the one to be deleted
                // So the item is not in the list
                return false;
            }
        }
        // we have reached the end of the list
        // without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) System.out.println("The list is empty");
        else {
            while(root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

//        // USING RECURSIVE ON LINKEDLIST
//        if(root != null) {  // Because root starts at first number??? not first one added???
//            System.out.println(root.getValue());
//            traverse(root.next());
//            // THIS IS NOT GOOD FOR LINKEDLIST
//            // 9tril nodes max. would take 9tril?????
//            // Where binary only have a depth of 63
//        }
    }
}
