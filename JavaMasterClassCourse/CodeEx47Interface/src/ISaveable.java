import java.util.List;

public interface ISaveable {        // Another good thing about this is since you are making sure the methods are overwritten. they will never go back to the super class (this one) if you missed the method.
    List<String> write();
    void read(List<String> savedValues);
}
