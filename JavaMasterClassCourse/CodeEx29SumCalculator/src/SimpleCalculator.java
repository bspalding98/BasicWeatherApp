public class SimpleCalculator {

    private double firstNumber;
    private double secondNumber;

//    Setter
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;                         // Assigning the parameter to the field or else the parameter value cannot be used outside this scope (method)
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;                       // Same as above
    }


//    Getter
    public double getFirstNumber() {
        return firstNumber;                                // Return the number To use
    }

    public double getSecondNumber() {
        return secondNumber;                               // Same as above
    }

    public double getAdditionResult() {
        return firstNumber + secondNumber;                      // Sum of the two numbers
    }

    public double getSubtractionResult() {
        return firstNumber - secondNumber;                      // Getting subtraction
    }

    public double getMultiplicationResult() {
        return firstNumber * secondNumber;                      // Getting multiplication
    }

    public double getDivisionResult() {
        return (secondNumber == 0) ? 0 : (firstNumber / secondNumber);  // Getting Division unless divisor is 0 then getting 0.
    }

}
