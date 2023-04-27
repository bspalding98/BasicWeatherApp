import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Boyd");

//        ArrayList<int> = intArrayList = new ArrayList<int>();       // Does not work as you need to save a class reference. int is a primitive type

//        Can do this: - Autoboxing is the solution to this
//        However you need to make a whole lot of code just for this like the IntClass class.
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

//        Autoboxing is the solution for this to not use a class an excessive code
//        Done by using a wrapper like the class. The int myValue is the variable that will contain the number and is wrapped up in a class in order to be used here.

        Integer integer = new Integer(54);      // Done like this
        Double doubleValue = 23.4;

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();     // This one now would work for above object integer
        for(int i = 0; i <= 10; i ++) {
            intArrayList.add(Integer.valueOf(i));       //Autboxing: Creating/converting a primitive type from wrapping.
        }

        for(int i = 0; i <= 10; i ++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue());   // Unboxing: Converting it from the object wrapper and converting it back to primitive type.
        }


//        EASIER WAY (SHORT WAY)
        Integer myIntValue = 56;        // Do not need new as they have it programmed to auto make it a new one at compile time. 56;= Integer.valueOf(56); - THink because it will always be an integer so they have it coded to auto do it.
        Double myDoubleValue = 34.0;

        int myInt = myIntValue; // myIntValue = myIntValue.intValue();      // Which only takes an int so it auto does it.


        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
//        for(double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
//            myDoubleValues.add(Double.valueOf(dbl));    // Wrapping
//        }
//
//        for(int i = 0; i < myDoubleValues.size(); i ++) {
//            double value = myDoubleValues.get(i).doubleValue(); // Unwrapping
//            System.out.println(i + " --> " + value);
//        }

//        Above can still be compressed even more from Java built in coding ----------

        for(double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);    // Wrapping
        }

        for(int i = 0; i < myDoubleValues.size(); i ++) {
            double value = myDoubleValues.get(i); // Unwrapping
            System.out.println(i + " --> " + value);
        }

//        One of these built in wrappers for each individual type.
    }
}
