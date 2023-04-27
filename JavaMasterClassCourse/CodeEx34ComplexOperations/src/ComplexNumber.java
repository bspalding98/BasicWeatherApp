public class ComplexNumber {
//    fields
    private double real;
    private double imaginary;

//    constructor

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

//    Setters
    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber xy) {        // Probably should write "ComplexNumber ComplexNumber" for referencing purpose to make it easier to understand
//        this.real += xy.getReal();
//        this.imaginary += xy.getImaginary();
        add(xy.real, xy.imaginary);
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber xy) {        // Probably should write "ComplexNumber ComplexNumber" for referencing purpose to make it easier to understand
//        this.real -= xy.getReal();
//        this.imaginary -= xy.getImaginary();
        subtract(xy.real, xy.imaginary);        // Running method above and substituting real and imaginary for the new pair.
    }

//    getters
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}
