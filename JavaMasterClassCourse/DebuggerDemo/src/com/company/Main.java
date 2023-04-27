package com.company;


// -	Have to have source code to see what’s happening when debugging
//-	So third party library, no access to source code
//o	Best can be done is examine what values are passed into the method and what is returned
//-	TO use the debugger with the class. The compiled class files must have debug information. 3rd party libraries don’t normally have it.
//-	Applications run slower when using the debugger
//o	Using a debugger to find threading issues can sometime be a problem
//	Timer of application isn’t the same when running debug mode



// Need to tell the debugger where to suspend so we can look at the state of the code
    // Known as a breakpoint - Can set more than 1
    // Way to toggle on breakpoint click the right of the line number and it should be a red circle
    // It suspends before the line of code being executed. Depending on the context - breakpoint?

// Frame section is the execution stack trace. Each time a method is called. a frame or stack trace is placed
// Above stack trace shows all the threads that are executing and their trace - Good for multiple threaded application

// Not always good to just exit debugger if have a network connection or database or some cleanup, better to run the whole application by resuming

// Watch variable will change blue when the last statement executed changes its value

// field watch point is a type of breakpoint
// if a variable is changing in an unsuspected way. We can put a field watch point breakpoint on it to track what changes the code.
    // When the value of the variable is updated or accessed it will suspend






public class Main {

    public static void main(String[] args) {

        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}

























