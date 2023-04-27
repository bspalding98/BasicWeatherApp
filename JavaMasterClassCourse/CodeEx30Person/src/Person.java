public class Person {

    private String firstName;
    private String lastName;
    private int age;

//    Setter
//    Assign firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
//    Assign lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
//    Assign age
    public void setAge(int age) {
        this.age = ((age >= 0 && age <= 100) ? age : 0);
    }


//    Getter
//    Returns firstName
    public String getFirstName() {
        return firstName;
    }
//    Returns lastName
    public String getLastName() {
        return lastName;
    }
//    Returns Age
    public int getAge() {
        return age;
    }
//    Returns if a teen or not
    public boolean isTeen() {
        return ((age > 12) && (age < 20));
    }
//    Returns full name
    public String getFullName() {
//        return (firstName.isEmpty() && lastName.isEmpty()) ? ""
//                : (firstName.isEmpty()) ? lastName
//                : (lastName.isEmpty()) ? firstName
//                : (firstName + " " + lastName);

//        OR
        firstName = (firstName == null) ? "" : firstName;
        lastName = (lastName == null) ? "" : lastName;
        return String.join(" ", firstName, lastName).trim();
    }
}
