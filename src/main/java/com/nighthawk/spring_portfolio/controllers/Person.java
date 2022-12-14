package com.nighthawk.spring_portfolio.controllers;

public class Person {
   private String name;
   private String birthday;
   private int age;

   public Person(String name, String birthday, int age) {
      this.name = name;
      this.birthday = birthday;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public static void main(String[] args) {
      Person Bob = new Person("Bob", "Jan 1,2000", 22);
      Student Ted = Bob.new Student("Ted", "Jan 2, 2010", 12, 11, 4.0, 5);
      Teacher MsSmith = Bob.new Teacher("Ms. Smith", "Jan 5, 1999", 23, 4, "Computer Science");
      System.out.println(Ted);
      System.out.println(MsSmith);
   }

   public class Student extends Person {
      private int grade;
      private double gpa;
      private int numFriends;

      public Student(String name, String birthday, int age, int grade, double gpa, int numFriends) {
         super(name, birthday, age);
         this.grade = grade;
         this.gpa = gpa;
         this.numFriends = numFriends;
      }

      public int getGrade() {
         return grade;
      }

      public int getNumFriends() {
         return numFriends;
      }

      @Override
      public String toString() {
         return name + ": {" + "gpa: " + gpa + " grade: " + grade + "}";
      }
   }

   public class Teacher extends Person {
      private int classes;
      private String subject;

    public Teacher (String name, String birthday, int age, int classes, String subject) {
       super(name, birthday, age);
       this.classes = classes;
       this.subject = subject;
    }

      public int getNumClasses() {
         return classes;
      }

      public String getSubject() {
         return subject;
      }

      @Override
      public String toString() {
         return name + ": {" + "number of classes: " + classes + " subject: " + subject + "}";
      }
   }
}