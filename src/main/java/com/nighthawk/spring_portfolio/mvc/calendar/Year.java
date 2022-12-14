// package com.nighthawk.spring_portfolio.mvc.calendar;

// /** Simple POJO 
//  * Used to Interface with APCalendar
//  * The toString method(s) prepares object for JSON serialization
//  * Note... this is NOT an entity, just an abstraction
//  */
// class Year {
//    private int year;
//    private boolean isLeapYear;
//    private int firstDayOfYear;
//    private int DayOfYear;
//    private int month;
//    private int day;

//    // zero argument constructor
//    public Year() {} 

//    /* year getter/setters */
//    public int getYear() {
//       return year;
//    }
//    public void setYear(int year) {
//       this.year = year;
//       this.setIsLeapYear(year);
//       this.setFirstDayOfYear(year);
//       this.setDayOfYear(day,month,year);
//    }

//    /* isLeapYear getter/setters */
//    public boolean getIsLeapYear(int year) {
//       return APCalendar.isLeapYear(year);
//    }
//    private void setIsLeapYear(int year) {  // this is private to avoid tampering
//       this.isLeapYear = APCalendar.isLeapYear(year);
//    }

//    /* isLeapYearToString formatted to be mapped to JSON */
//    public String isLeapYearToString(){
//       return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
//    }	

//    /* standard toString placeholder until class is extended */
//    public String toString() { 
//       return isLeapYearToString(); 
//    }

//    public int getFirstDayOfYear(int year) {
//       return APCalendar.firstDayOfYear(year);
//    }
//    private void setFirstDayOfYear(int year) {  // this is private to avoid tampering
//       this.firstDayOfYear = APCalendar.firstDayOfYear(year);
//    }

//    /* isLeapYearToString formatted to be mapped to JSON */
//    public String firstDayOfYearToString(){
//       return ( "{ \"year\": "  +this.year+  ", " + "\"firstDayOfYear\": "  +this.firstDayOfYear+ " }" );
//    }	

//    public int getDayOfYear(int year, int month, int day) {
//       return APCalendar.dayOfYear(day,month,year);
//    }
//    private void setDayOfYear(int day, int month, int year) {  // this is private to avoid tampering
//       this.dayOfYear = APCalendar.dayOfYear(day,month,year);
//    }

//    /* isLeapYearToString formatted to be mapped to JSON */
//    public String dayOfYearToString(){
//       return ( "{ \"year\": "  +this.year+  ", " + "\"dayOfYear\": "  +this.dayOfYear+ " }" );
//    }	



//    public static void main(String[] args) {
//       Year year = new Year();
//       year.setYear(2022);
//       System.out.println(year);
//    }
// }

package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private boolean isLeapYear;

   // zero argument constructor
   public Year() {}

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
   }

   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }
   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }

   /* standard toString placeholder until class is extended */
   public String toString() {
      return isLeapYearToString();
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      System.out.println(year);
   }
}