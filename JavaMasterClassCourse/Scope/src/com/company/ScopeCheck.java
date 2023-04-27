package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck create, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        int VarTwo = 2; // if did not exist. Would use the classes private int privateVar value instead.
        for(int i = 0; i < 10; i ++) {
            System.out.println(i + " times two is " + i * VarTwo);  // multiples variable in the scope as it's local and inside the scope. If it did not exist. would use the one at the top. this is most local scope.
        }
    }
    // Way it works is it checks the code block that has the variable inside. If it is not there, It will go to the next code block hold that one.
    //EG
    // timeTwo() - privateVar in the print line looks for variable creation. So it starts in the first code block holding it. the for loops
    // If it was not there, it now looks in the next one the timeTwo(). and if it wasn't there
    // Would then go to class ScopeCheck and check in there because that is the next code block hold timesTwo()
    //EG 2
    // i is only inside for loop. If you tried using it outside the loop. It would error. It was created in the for loop so only is available in the for loop code block.

    public void userInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from out class: " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass create, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo() {    // Uses the public in privateVar = 3; in the InnerClass before the one in class ScopeCheck
            System.out.println("varOne is still available here " + varOne);
            for(int i = 0; i < 10; i ++) {
                // ScopeCheck.this.timesTwo(); // This would use the timesTwo() in ScopeCheck.
                System.out.println(i + " times two is " + i * varThree); // Then uses this.privateVar in ScopeCheck
            }
        }
    }
}
