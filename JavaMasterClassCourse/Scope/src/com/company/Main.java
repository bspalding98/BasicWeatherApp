package com.company;

public class Main {
    // private, only inside that class/
    // public, anywhere
    // protected only in the class and all subclasses?

    //Object visibility is governed by access modifiers and is connected with scope.

    public static void main(String[] args) {
        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.userInner();
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        System.out.println("varThree is not accessible here " + innerClass.varThree);
//        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
//        System.out.println(varFour);
//        // CODE ABOVE
//        // Since varFour is private in ScopeCheck. The variable created in the main is differ even though same name as is not available in the scope.
//
//        scopeInstance.timesTwo();
//        System.out.println("***********");
//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        innerClass.timesTwo();
    }
}
