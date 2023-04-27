// So this class holds an item that can be stored in a list. So each item is given a next and previous so you can traverse through it without it being an actualy list
// Why though??
// Making a LinkList without using one to showcase it better ???
// Yes but still whyyyy?????

public abstract class ListItem {
//Fields -> protected to access from our concrete subclass. If we left it off(would auto represent package-private), subclasses of same package could access but not other packages. so made it protected.
    protected ListItem rightLink = null;
    protected ListItem leftLink = null; // These two essentially mean with each ListItem created we can hold the next and previous ListItem as well.

    protected Object value;

//Constructor
    public ListItem(Object value) {     // Any concrete class will need a constructor as well so be smart to put it here.
        this.value = value;
    }

//Abstract methods -> What must be implemented in any concrete class implementing ListItem
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);  // =0: equal of value, >0: sort before object as it's less, <0: Sort after object as it's greater?

//Getters & Setters
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
