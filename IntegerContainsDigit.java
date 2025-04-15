
// Wilson Chen (wilson.chen@quinnipiac.edu)
// I was working on some Discrete Math homework and I thought it'd be fun to make a program that returned the number of integers
// that contained a specific digit (0 to 9) given a range of integers.

/* Example input:
    If I was looking for the digit 9 in the integer values between the range of 1 to 1,000,000 (inclusive), I would get 468,599 
    integers that contain 9, and 531441 without. Between 1 to 1,000,000, there are a million integers.
 */

 import java.util.InputMismatchException;
 import java.util.Scanner;
 
 public class IntegerContainsDigit {
     public static void main(String[] args) {
     
         try (Scanner userInput = new Scanner(System.in)) {
 
            // TODO: MODIFY PROGRAM TO PROCESS AN EXCLUSIVE RANGE (this is really just a minor change in the for loop tbh)
            
            int numbersWithNumber = 0;
            int numbersWithoutNumber = 0;
            int lowerEndpoint = 0;
            int upperEndpoint = 0;
            int findDigit = 0;
            int totalIntegers = 0;
            int[] singleDigitIntegers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


            String rangeType = "";
 
            System.out.println("Welcome! This is a program to see how many integers include a specific digit" + 
                                 " within either an inclusive or exclusive specified range.");
 
            System.out.println("Please enter I for inclusive or E for exclusive.");
            rangeType = userInput.nextLine().toUpperCase();

            System.out.println("Please enter the lower endpoint.");
             
            lowerEndpoint = userInput.nextInt();
 
            System.out.println("Please enter the upper endpoint.");
 
            upperEndpoint = userInput.nextInt();
             
            System.out.println("What is the specific single digit you want to find in the integers contained in the range?");
            printArray(singleDigitIntegers);
 
            findDigit = userInput.nextInt();

            switch(rangeType) {
                case "I":
                totalIntegers = upperEndpoint - lowerEndpoint + 1;
                System.out.println(String.format("There are a total of %d integers within the inclusive range.", totalIntegers));
                for (int i = lowerEndpoint; i <= upperEndpoint; i++) {
                    if(containsSpecificNumber(i, findDigit)) {
                        numbersWithNumber++;
                    } else {
                        numbersWithoutNumber++;
                    }
                }
                System.out.println(String.format("Between %d and %d (inclusive), there are %d integers that contain the digit %d, and %d that don't."
                                        , lowerEndpoint, upperEndpoint, numbersWithNumber, findDigit, numbersWithoutNumber));
                    break;
                
                case "E":
                totalIntegers = upperEndpoint - lowerEndpoint - 1;
                System.out.println(String.format("There are a total of %d integers within the exclusive range.", totalIntegers));
                for (int i = lowerEndpoint + 1; i < upperEndpoint; i++) {
                    if(containsSpecificNumber(i, findDigit)) {
                        numbersWithNumber++;
                    } else {
                        numbersWithoutNumber++;
                    }
                }
                System.out.println(String.format("Between %d and %d (exclusive), there are %d integers that contain the digit %d, and %d that don't."
                                        , lowerEndpoint, upperEndpoint, numbersWithNumber, findDigit, numbersWithoutNumber));
                break;
                
                default:
                System.out.println("You put in neither I or E to indicate the type of range.");
            }
 
            //  for (int i = lowerEndpoint; i <= upperEndpoint; i++) {
            //      if(containsSpecificNumber(i, findDigit)) {
            //          numbersWithNumber++;
            //      } else {
            //          numbersWithoutNumber++;
            //      }
            //  }
 
         } catch (InputMismatchException e) {
             e.printStackTrace();
             System.out.println("Please input an integer value.");
         }
     }
 
     /*  from Brave AI; explanation on how it works:
         It takes two int arguments as parameters; the first is the number we are checking to see if it has the other integer
         The method converts both of the integers to Strings and then uses the .contains() method to see if the number we are 
         looking for is contained in the other number.
     */
     public static boolean containsSpecificNumber(int number, int specificNumber) {
         String numStr = Integer.toString(number);
         String specNumStr = Integer.toString(specificNumber);
         return numStr.contains(specNumStr);
     }
 
     public static void printArray(int[] array) {
         for (int i : array) {
             System.out.print("| " + i + " |");
         }
         System.out.println();
     }
}