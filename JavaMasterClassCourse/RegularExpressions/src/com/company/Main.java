package com.company;

// IMPORTANT
    // If you hover ofer the regex symbol, a bulb should pop up near line number, click it, and you can do "check regex"
    // ALso is case-sensitive

// Reg expressions
    // Way to describe a string or a pattern

// Used to search strings for a particular pattern
// or to validate that user inputs matches a specific pattern


// simplest form of a reg expression is a string literal

// Can use replace all method()

// Character class
    // represents a set or class of characters
    // .character() matches any character - so entire string would be replaced with replacement parameter


// boundary matcher
    // looks for boundaries such as beginning, end or a word
    // carrot boundary matcher -(Shift + 6) - always found with a pattern.
        // when using regex must match the beginning of the string - only at the beginning - and replaces it
        // so don't need matching length from regex and replacement


// String.matches() - takes regex of parameter and returns true if there is a match
    // The string as a whole must match for it to be true

// $ boundary matcher - always proceeds the pattern
    // Matches the end of the string

// replace specific letters or part of string
 // Use square brackets
    // could also be used for finding capitalised words instead of convert the variable toUpperCase

// using square brackets and then carrot inside
    // carrot is treated as a character class inside the brackets
    // This replaces everything but what's in the boundaries

// character class - (meaning inside [])
    // represents the range - EG. a-f means from letter a through to f in the alphabet

// Can also turn off case sensitivity with (?i)
    // EG. .replaceAll("(?i)[a-f]", "X");   // replaces a through f lower and upper case


// quantifiers
// how often an element in regex can occur


// Pattern class
// Can be used to manipulate strings using regex
// Some java API want to work with patterns over a string that represents a regex
// use Pattern.compile() to compile an expression into a pattern
// This is often done when working with the matcher class

// matchers work with classes that implement the char sequence interface
// generally we use a matcher when we want to find multiple occurrences of a pattern
// or when we want to use the same pattern with multiply sequences
// ONLY GOING to use regex once to check one occurrence in a string, don't use matcher


// * is a greedy quantifier - will grab as much text as it can
    //EG. (<h2>.*</h2>) - this will start at first <h2> tag and then look for the very last</h2> not the first one and get everything inside
// ? is a lazy quantifier - 1 or zero
    // So can turn a greedy into a lazy, so will find the first match, and stop grabbing text as oppose to above
    // EG (<h2>.*?</h2>)


// logical operators in regex
// AND, OR, and NOT
    // and is auto implemented "abc" = "a" and "b" and "c" - means and followed by in this instance


import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes I am";
        System.out.println(string);

        // String.replaceALl()
        // choose the pattern to change and what the pattern is to be replaced to
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));


        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YY"));

        // String.matches()
        System.out.println(alphanumeric.matches("^Hello")); // false
        System.out.println(alphanumeric.matches("^abcDeee"));   // false
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));    // true

        // Matches from end liek carrot but opposite end
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));

        // Specific letter or strings,
            // This replaces each individual a, e, and i. not only the occurance where they are together
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));  // replaces each individual letter with replacement, even if replacement is a sentence

        // only perform replacement is any character a, e or i. Is followed by an F or j
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        // finding upper and lower case string
        System.out.println("Harry".replaceAll("[Hh]arry", "harry"));



        // To see when writing code --------------------
        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";


        // replace every letter expect e and j
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        // replace A - F inclusive and 3 - 8 (case-sensitive though)
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        // Can also do by turning off case sensitivity
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        // if unicode string (add the u in (?iu))
        System.out.println(newAlphanumeric.replaceAll("(?iu)[a-f3-8]", "X"));

        // replace all numbers in the string
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        // shortcut way
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));

        // replace all non digits shortcut
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));



        // new String
        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);


        // removing whitespaces in the string
        System.out.println(hasWhitespace.replaceAll("\\s", ""));

        // Can remove any of the whitespace identifiers, like tab, new line, etc.
        // Tab example
        System.out.println(hasWhitespace.replaceAll("\t", "X")); // can also use \\t

        // replace all non whitespace characters instead, so leave tab and newline, etc.
        System.out.println(hasWhitespace.replaceAll("\\S", ""));

        // replace (everything pretty much but whitespaces and symbols) a-z A-Z 0-9 and also _
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        // whitespace characters arent replace, only characters
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));

        //opposite to replace everything but a-z A-Z 0-9 and _
        System.out.println(hasWhitespace.replaceAll("\\W", ""));

        // matches word boundaries and replace. so each word is surrounded by replacement - start and end of each word
        System.out.println(hasWhitespace.replaceAll("\\b", "\""));



        // Quantifiers
        String thirdAlphanumericString = "abcDeeeF12Ghhiiijkl99z";
        System.out.println("abcDeeeF12Ghhiiiijkl99z");
        System.out.println(thirdAlphanumericString.replaceAll("^abcDeee", "YY"));

        // replace e with quantifier
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YY"));  // want to see three e's

        // want to replace as many e's that follow, not a certain amount - use +
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YY"));    // replaces all proceeding e's after D 1 or more e's needed

        // want to match and replace any string starting with abcD and followed by 0 or more e's, so anything?
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YY"));    // like above but even replaces if zero e's - optional

        // can specific min and max times a character can occur
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YY"));    // needs to have at least between 2 and 5 e's in a row

        // can also do this anywhere, middle, end, beginning, etc.
        // Replace all occurrences of H, followed by any numbers of I, followed by at least J
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "YY"));  // this means if there is no i, it's h followed by one j




        // Using matcher and patter
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        // find captials, etc.
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);   // pattern
        Pattern pattern = Pattern.compile(h2Pattern);   // pattern
        Matcher matcher = pattern.matcher(htmlText);    // text want to match against (compare)
        System.out.println(matcher.matches());  // prints out all matches
        // Above prints false because the matchers() method wants to match the string as a whole, just like the string.matches()
        // FIX
//        h2Pattern = ".*<h2>.*"; // will match every character before and after it and will have a match. . = everything, * is zero or more
        h2Pattern = "<h2>";
        pattern = Pattern.compile(h2Pattern);
        matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        // find() start() and end() methods to fix specific occurrences
        // start() and end() get the index of first and last element

        // Need to reset because used matcher above
        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.printf("Occurrence %d: %s to %s\n", count, matcher.start(), matcher.end());
        }

        // There is an easier way surround pattern in parentheses
        String h2GroupPattern = "(<h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(matcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1)); // 1 because we only have 1 group
        }

        // extract all the <h2> text and </h2>
        // below extracts bot h2 and both p tags and text because it goes from the 1st h2 to the last h2 in the string
        h2GroupPattern = "(<h2>.*</h2>)";   // from opening tag to closing tag. so opening, closing, and everything in between
        groupPattern = Pattern.compile(h2GroupPattern);
        groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(matcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1)); // 1 because we only have 1 group
        }

        // FIX
        h2GroupPattern = "(<h2>.*?</h2>)";  // if want ones with at least something in the tags, but swapping * to + because + is 1 or more, * is 0 or more
        groupPattern = Pattern.compile(h2GroupPattern);
        groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(matcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        // Get within the tags not including the tags
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2)); // corresponds to the 2nd group - starts at 1 not 0
        }





        // LOGICAL
        // using OR operator --->    |
        // [Hh]arry
        // or
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));

        //using NOT operator --->    ^ or !
        // [^abc]
        // or
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]"; // ^ consumes a character so pretty much just matching t - t
//        String tNotVRegExp = "t(?!v)";  // Want t that isn't followed by a v - does not consume - negative look ahead
        String tNotVRegExp = "t(?=v)";  // positive look ahead - find all matches of T followed by V, but did not want to include V in the match
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.printf("Occurrence %d: %s to %s\n", count, tNotVMatcher.start(), tNotVMatcher.end());
        }


        // US phone number
        // (800) 123-4567
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-][0-9]{4})$
        /**
         * ^ - Line has to start with the entire pattern
         * ([\(]{1} - expecting area code to be within parentheses, char literal and only can have 1 opening (
         * [0-9]{3} - expect the area code to be 0-9 inclusive and 3 long
         * [\)]{1} - expect only one closing parentheses
         * [ ]{1} - expect one blan (space) and only one blank
         * [0-9]{3} - expect another 3 numbers 0-9 inclusive
         * [\-] - followed by a dash
         * [0-9]{4})- expecting another 4 digits 0-9 inclusive
         * $ - lastly expect the string ot end with the entire pattern, if anything follows the number, nothing will match
         */
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-][0-9]{4})$
        String phone1 = "1234567890";       // Shouldn't match  - no parentheses, no space, no dash
        String phone2 = "(123) 456-7890";   // Should match
        String phone3 = "123 456-7890";     // shouldn't match - no parentheses
        String phone4 = "(123)456-7890";    // Shouldn't match - no space after right parentheses

        System.out.println("phone 1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone 2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone 3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));
        System.out.println("phone 4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-][0-9]{4})$"));


        // another is checking for a visa card
        //  ^4[0-9]{12}([0-9]{3})?$
        /**
         * ^ to ensure it starts like this
         * 4 because all visa cards start with a 4
         * at least 12 numbers
         * then optional 3 extra numbers with new cards
         * old cards have 0 occurrences of final 3 numbers, and newer has 1 occurrence so ? makes it optional for 0 to 3
         * $ boundary matcher to say if anything occurs after this, there is no match
         */
        //  ^4[0-9]{12}([0-9]{3})?$

        String visa1 = "4444444444444";    // Should match
        String visa2 = "5444444444444";   // Shouldn't match
        String visa3 = "4444444444444444";     // should match
        String visa4 = "4444";    // Shouldn't match

        System.out.println("visa 1 = " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa 2 = " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa 3 = " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa 4 = " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}
