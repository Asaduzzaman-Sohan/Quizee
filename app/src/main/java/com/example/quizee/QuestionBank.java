package com.example.quizee;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {


    private static List<QuestionList> javaQuestions(){

        final List<QuestionList> questionLists = new ArrayList<>();

        // Create object of QuestionList class and pass questions along with options and answer
        final QuestionList question1 = new QuestionList("Java is designed by", "Dennis Ritchie", "James Gosling", "Charles Babbage", "Guido van Rossum", "James Gosling", "");
        final QuestionList question2 = new QuestionList("Java first appeared in", "May 23, 1995", "23 July, 1994", "18 August, 2001", "13 September, 1983", "May 23, 1995", "");
        final QuestionList question3 = new QuestionList("Java influenced by", "C++", "Objective-C", "Ada", "All the above", "All the above", "");
        final QuestionList question4 = new QuestionList("Java influenced", "Kotlin", "PHP and C#", "Python and JavaScript", "All the above", "All the above", "");
        final QuestionList question5 = new QuestionList("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK", "");


        // add all questions to List<QuestionList
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);


        return questionLists;
    }


    private static List<QuestionList> javaScriptQuestions(){

        final List<QuestionList> questionLists = new ArrayList<>();

        // Create object of QuestionList class and pass questions along with options and answer
        final QuestionList question1 = new QuestionList("Javascript is an _______ language?", "low-level", "Scripting", "human", "Mark-up", "Scripting", "");
        final QuestionList question2 = new QuestionList("Which of the following is a valid type of function javascript supports?", "named function", "anonymous function", "Both of the above.", "None of the above", "Both of the above.", "");
        final QuestionList question3 = new QuestionList("Which built-in method calls a function for each element in the array?", "while()", "loop()", "forEach()", "None of the above.", "forEach()", "");
        final QuestionList question4 = new QuestionList("Which of the following function of Number object returns the number's value?", "toString()", "valueOf()", "toLocaleString()", "toPrecision()", "valueOf()", "");
        final QuestionList question5 = new QuestionList("Javascript is a language of - ", "Browsers", "Machine", "Programmer", "Robot", "Browsers", "");

        // add all questions to List<QuestionList
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);


        return questionLists;
    }

    private static List<QuestionList> cQuestions(){

        final List<QuestionList> questionLists = new ArrayList<>();

        // Create object of QuestionList class and pass questions along with options and answer
        final QuestionList question1 = new QuestionList("If the two strings are identical, then strcmp() function returns", "-1", "1", "0", "yes", "0", "");
        final QuestionList question2 = new QuestionList("Which of the following correctly shows the hierarchy of arithmetic operations in C?" ,"/ * + -", "/ + * -", "* - / +", "+ - / *", "/ * + -", "");
        final QuestionList question3 = new QuestionList("What are the different types of real data type in C ?", "float, double", "short int, double, long int", "double, long int, float", "float, double, long double", "float, double, long double", "");
        final QuestionList question4 = new QuestionList("What is (void*)0?", "Representation of NULL pointer", "Representation of void pointer", "Error", "None of above", "Representation of NULL pointer", "");
        final QuestionList question5 = new QuestionList("In which header file is the NULL macro defined?", "stdio.h", "stddef.h", "stdio.h and stddef.h", "math.h", "stdio.h and stddef.h", "");

        // add all questions to List<QuestionList
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);


        return questionLists;
    }

    private static List<QuestionList> pythonQuestions(){

        final List<QuestionList> questionLists = new ArrayList<>();

        // Create object of QuestionList class and pass questions along with options and answer
        final QuestionList question1 = new QuestionList("Who developed Python Programming Language?", "Wick van Rossum", "Rasmus Lerdorf", "Guido van Rossum", "Niene Stom", "Guido van Rossum", "");
        final QuestionList question2 = new QuestionList("Is Python case sensitive when dealing with identifiers?", "no", "yes", "machine dependent", "none of the mentioned", "no", "");
        final QuestionList question3 = new QuestionList("Which of the following is the correct extension of the Python file?", ".python", ".pl", ".py", ".p", ".py", "");
        final QuestionList question4 = new QuestionList("4 + 3 % 5", "7", "2", "4", "1", "7", "");
        final QuestionList question5 = new QuestionList("Which keyword is used for function in Python language?", "Function", "Def", "Fun", "Define", "Def", "");

        // add all questions to List<QuestionList
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);


        return questionLists;


    }


    public static List<QuestionList> getQuestions(String selectedTopicName){

        switch (selectedTopicName){
            case "java":
                return javaQuestions();

            case "javaScript":
                return javaScriptQuestions();

            case "c":
                return cQuestions();

            case "python":
                return pythonQuestions();
        }

    return getQuestions(selectedTopicName);
    }

}
