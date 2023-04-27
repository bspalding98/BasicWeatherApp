// Binary searchTree as oppose to a LinkedList
// LInkList is going from node to node until you get a null reference
// Using previous or next till you get null and means you are at the end and start. (Like in MylinkedList) traverse()

// searchTree - Involves visiting every node to the left. Then the root, then every node to the right.
// Pretty much goes to most left, then goes to the right. (IMAGE IS SAVED IN DOCS UNDER UDEMY COURSE STUFF)
// Root can have left and right tree and no children.

// RECURSIVE
// Any definition that includes an object in it's own definition
// Objects defined recursively can be process recursively


public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    // Is it because you go from left to right? so once you go to the right and when it's smaller
    // and you need to go back to left it's null because you cannot go that way anymore??? End of the path?
    public boolean addItem(ListItem newItem) {
        if(this.root ==  null) {
            // the tree was empty, so our item becomes the head of the tree
            this.root = newItem;        // This will always be the starting number, not the start fot he new ListItem I think. So binary searchTre works.
            return true;
        }

        // otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if(comparison < 0) {
                // newItem is greater, move right if possible
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there's no node to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if(comparison > 0) {
                // newItem is less, move left if possible
                if(currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    // there's no node to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // equal, so don't add
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
        // we can't actually get here, but Java complains if there's not return
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {      // just determining the item to be removed.
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while(currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if(comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // equal: we've found the item, so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    // Deleting record in binary searchTrees are really complex as seen before
    // Are not normally deleted straight away. They are normally flagged which makes them skip over pretty much (ignored)
    // Then are deleted maybe during maintenance after hours or re-compacting or reindex the database
    // If there are hundreds of thousands. It will take forever to process. Hence why not do it all the time.
    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if(item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if(parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if(parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if(item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if(parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if(parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while(current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // NOw put the smallest value into our node to be delete
            item.setValue(current.getValue());
            // and delete the smallet
            if(leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must be deleted).
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {       // There is an image saved in Udemy Course Stuff folder explaining
        //recursive method
        if(root != null) {  // Becuase root starts at first number added.
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
