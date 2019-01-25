package com.daniele.handsonj8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.daniele.handsonj8.utils.java7.Java7Approaches;

public class Java8Approaches extends Java7Approaches{
	
	public static void main(String args[]) {
		System.out.println("Using Java 7: ");
		// Count empty strings
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("List: " +strings);
		long count = getCountEmptyStringUsingJava7(strings);
		System.out.println("Empty Strings: " + count);
		  
		count = getCountLength3UsingJava7(strings);
		System.out.println("Strings of length 3: " + count);
	      
	    //Eliminate empty string
		List<String> filtered = deleteEmptyStringsUsingJava7(strings);
		System.out.println("Filtered list (with no empty spaces): " + filtered);
		
		//Eliminate empty string and join using comma.
		String mergedString = getMergedStringUsingJava7(strings, ", "); 
		System.out.println("Merged String: " + mergedString);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of square of distinct numbers
		List<Integer> squaresList = getSquares(numbers);
		System.out.println("Squared List: " + squaresList);
	      
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		System.out.println("List: " +integers);
        System.out.println("Highest number in List : " + getMax(integers));
        System.out.println("Lowest number in List : " + getMin(integers));
        System.out.println("Sum of all numbers : " + getSum(integers));
        System.out.println("Average of all numbers : " + getAverage(integers));
        System.out.println("Random Numbers: ");	   
		
        //print ten random numbers
        Random random = new Random();
  		
        for(int i = 0; i < 10; i++) {
           System.out.println(random.nextInt());
        }
		
		System.out.println("\nWhereas .. Using Java 8: ");
		System.out.println("List: " +strings);
		
		count = strings.stream().filter( string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);
		
		count = strings.stream().filter( string -> string.length()==3).count();
		System.out.println("Strings of length 3: " + count);
		
		filtered = strings.stream().filter( string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered list (with no empty spaces): " + filtered);
		
		mergedString = strings.stream().filter( string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		//get list of square of distinct numbers
		squaresList = numbers.stream().map( i-> i*i).distinct().collect(Collectors.toList());
		System.out.println("Squared List: " + squaresList);
		
		//print ten random numbers
		System.out.println("Ten random rumbers : ");
		random.ints().limit(10).forEach(System.out::println);
		
		//parallel processing
		count = strings.parallelStream().filter( string -> string.isEmpty()).count();
		System.out.println("Empty Strings (parallel process): " + count);
		
	}
	
	
	
	
	

}
