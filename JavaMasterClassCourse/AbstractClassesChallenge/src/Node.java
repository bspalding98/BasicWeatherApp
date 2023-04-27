public class Node extends ListItem {
    public Node(Object value) { // Uses abstract class constructor to set the value of the object.
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        // Why do you do (String) again? Was not far back - because we are using strings, idk why though - USING STRINGS BECAUSE Strings class already has it's own compareTO().
        // If we did not use it. would have to make out own operator to find it.
        // also -1 as else because everything is greater than null if it's null
        return (item != null) ? ((String) super.getValue()).compareTo((String) item.getValue()) : -1;
    }
}
