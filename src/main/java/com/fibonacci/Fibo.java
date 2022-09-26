package com.fibonacci;

import javax.swing.plaf.synth.SynthStyle;

public abstract class Fibo {//Creating super class Fibo
    int nth = 0; //integer that will define how many times to print

    public Fibo(int nth) {//constructor of super class, will be called later on
        //defining variables
        this.nth = nth;
        this.init();
    }

    
//init of super class, leave as protected and as abstract
    protected abstract void init();

//main method in super class, calling different for, while recursion methods with different values to print
    public static void main(String[] args) {
    Fibo ff1= new FiboFor(10);
    Fibo ff2= new FiboFor(23);
    Fibo fw1= new FiboWhile(3);
    Fibo fw2= new FiboWhile(6);
    Fibo fr1= new FiboRecursion(18);
    Fibo fr2= new FiboRecursion(8);
    
    }
    
}

class FiboFor extends Fibo{//For loop fibonacci

    public FiboFor(int nth){
        //Constructor of sub class that makes call to super class
        super(nth);
    }

    protected void init(){
        //this is the init method of the subclass, which houses the actual code for the for loop
        int firstNum = 0;
        int secondNum = 1;
        System.out.println("\n\nPrinting Using For Loops:\n");
        for (int i = 1; i <= nth; i++) {
            System.out.print(firstNum + ", ");
            int nextNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }
}

class FiboWhile extends Fibo{//While loop fibonacci

    public FiboWhile(int nth){
         //Constructor of sub class that makes call to super class
        super(nth);
    }

    protected void init(){
        //this is the init method of the subclass, which houses the actual code for the while loop
        int start = 1;
        int firstNum = 0;
        int secondNum = 1;
System.out.println("\n\nPrinting Using While Loops:\n");
    while (start <= nth) {
      System.out.print(firstNum + ", ");
      int nextNum = firstNum + secondNum;
      firstNum = secondNum;
      secondNum = nextNum;
      start++;
    }
    }
}

class FiboRecursion extends Fibo{//Recursion fibonacci

    public FiboRecursion(int nth){
         //Constructor of sub class that makes call to super class
        super(nth);
    }

    public static int fibRecursion(int n){
        if(n == 0){
            //deals with case if initial input was 0
            return 0;
        }
        if(n == 1 || n == 2){
            //deals with case if initial input was 1 or 2, which will return 1
            return 1; 
        }
        //keeps making calls to itself, until number of calls left is 0, which is how recursion works
        return fibRecursion(n-2) + fibRecursion(n-1);
    }
    protected void init(){
        //this is the init method of the subclass, which houses the actual code for the recursion
        System.out.println("\n\nPrinting Using Recursion:\n");
        for(int i = 0; i < nth; i++){
            System.out.print(fibRecursion(i) +", ");
        }
    }
}