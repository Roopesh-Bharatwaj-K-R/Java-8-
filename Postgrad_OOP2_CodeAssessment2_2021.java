// Name:
package postgrad.oop2.code2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Scanner;

import java.time.MonthDay;


public class Postgrad_OOP2_CodeAssessment2_2021 {

    // no threads used here so no Phaser needed to coordinate between the main thread
    // and the other created threads
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        final int LOCALISATION=1, DATES_TIMES = 2, STREAMS = 3, EXIT = 4;  
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
     
            switch (userChoice()) {
                case DATES_TIMES:
                    datesAndTimes();
                    break;
                case STREAMS:
                    streams();
                    break;
                case LOCALISATION:
                    localisation();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    userContinue = "n";
                    break;
                default:
                    System.out.println("Unknown entry : ");
                    break;
            }
        }
    }
    
    public static void localisation() {
        /* Write a localisation() method that avails of the given properties files:
            - using the default locale load the ResourceBundle named "CountingBundle"
            - prompt the user "Output the counting in which language?\n(G)erman, (F)rench or English (any other key)"
                - if they say "F/f", set the locale for France and load the corresponding CountingBundle file
                - if they say "G/g", set the locale for Germany and load the corresponding CountingBundle file
            - output the 4 numbers in the correct language: 
                -   note that the Strings "one is ", "two is ", "three is " and 
                    "four is " are all hardcoded
         */

        /* Output
                g
                one is eins
                two is zwei
                three is drei
                four is vier

                f
                one is une
                two is deux
                three is trois
                four is quatre

                h
                one is one
                two is two
                three is three
                four is four
        */
        
        // ****************
        // INSERT CODE HERE 
    	Locale currentLocale= Locale.getDefault();
    	System.out.println(currentLocale);
    	ResourceBundle numbers = ResourceBundle.getBundle("postgrad.oop2.code2.CountingBundle", currentLocale);
    	
    	System.out.println("OUTPUT OF THE Numbers in WHICH LANGUAGE ? \\ n(G)erman, (F)rench or English (any keys) : ");
    	String num =sc.next();
    	if (num.equalsIgnoreCase("F")) {
    		currentLocale =Locale.FRANCE;
    		numbers =ResourceBundle.getBundle("postgrad.oop2.code2.CountingBundle",currentLocale);
    	}
    	else if(num.equalsIgnoreCase("G")) {
    		currentLocale =Locale.GERMANY;
    		numbers =ResourceBundle.getBundle("postgrad.oop2.code2.CountingBundle",currentLocale);
    	}
    	
    	System.out.println("ONE IS : "+numbers.getString("one"));
    	System.out.println("TWO IS : "+numbers.getString("two"));
    	System.out.println("THREE IS :"+numbers.getString("three"));
    	System.out.println("FOUR IS :"+numbers.getString("four"));
    	
        // ****************
        
    }
    public static void datesAndTimes(){
/*
    The Java 8 Time/Date:
        - using the Java 8 Date/Time API to see who qualifies for the pension:
            - as of January 1st, 2021 you must be 66 years of age to get the pension. 
              Calculate the date that you must be born before in order to qualify to get the penion.
            - Joe Bloggs was born on the 3rd January, 1960. Declare a reference 'joeBloggsBirthday'
              which represents this.
            - Mary Bloggs was born on the 13th August, 1950. Declare a reference 'joeBloggsBirthday'
              which represents this.
            - determine if either of them can get the pension.
        
    Output
            No. Joe is too young to get the pension.
            Yes. Mary can get the pension.
*/
        
    	
    	// joe age 60, 11 months <66 years
    	// mary  70 years >66
        // ****************
        // INSERT CODE HERE 
    	
    	//LocalDate pensionCalculationStartDate =LocalDate.of(year, month, dayOfMonth)
    	//MonthDay monthday =MonthDay.of
    	LocalDateTime joeBloggsBirthday = LocalDateTime.of(1960, Month.JANUARY, 3, 0,0);
    	LocalDateTime MaryBloggsBirthday = LocalDateTime.of(1950, Month.AUGUST, 13,0,0);
    	LocalDateTime DateForPension =LocalDateTime.of(2021, Month.JANUARY, 1,0,0);
    	LocalDateTime YearForPension =LocalDateTime.of(2021, Month.JANUARY, 1,0,0).minusYears(66);
    	
    	if(joeBloggsBirthday.isBefore(YearForPension)) {
    		System.out.println("Yes. JOE can get the pension");
    	}
    	else{
    		System.out.println("NO. JOE is too young to get the pension");
    	}
    	
    	if(MaryBloggsBirthday.isBefore(YearForPension)) {
    		System.out.println("Yes. MARY can get the pension");
    	}
    	else{
    		System.out.println("NO. MARY is too young to get the pension");
    	}
        // ****************

    }
    public static void streams() {
        // This code is given. 
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Male", 20_000.0));
        employees.add(new Employee("Paul", "Male", 30_000.0));
        employees.add(new Employee("Peter", "Male", 40_000.0));
        employees.add(new Employee("Patricia", "Female", 25_000.0));
        employees.add(new Employee("Pauline", "Female", 40_000.0));
        employees.add(new Employee("Zoe", "Female", 45_000.0));
        
        /*  You are given the Employee class and the employees List above. Using streams,
            figure out the Male with the maximum salary. 
            Hint: This problem can be solved by streaming employees twice; for example:
                a) find the largest male salary
                b) find and output the male with that salary

            Output is:
                Employee{name=Peter, gender=Male, salary=40000.0}
        
        */
        // ****************
        // INSERT CODE HERE 
       System.out.println("MAX OF MALE EMPLOYEE"); 
       List<Employee> EmployeeIsMale = employees.stream().filter(E -> E.getGender() == "Male").collect(Collectors.toList());
       Optional<Employee> EMPLO =EmployeeIsMale.stream().collect(Collectors.maxBy(Comparator.comparing(Employee :: getSalary )));
       System.out.println(EMPLO);
       
       System.out.println("MIN OF FEMALE EMPLOYEE"); 
       List<Employee> EmployeeIsFemale = employees.stream().filter(E -> E.getGender() == "Female").collect(Collectors.toList());
       Optional<Employee> EMPLO1 =EmployeeIsFemale.stream().collect(Collectors.minBy(Comparator.comparing(Employee :: getSalary )));
       System.out.println(EMPLO1);
       
      // Map<Gender, List<Employee>> genderMap = people.stream()
       
       
        // ****************

    }

    public static int userChoice() {
        System.out.println("\nWhat do you want to do ?");
        System.out.println("1. Localisation");  
        System.out.println("2. Dates/Times"); 
        System.out.println("3. Streams"); 
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}