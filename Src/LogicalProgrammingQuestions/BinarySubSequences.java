package LogicalProgrammingQuestions;

//Java program to Check a binary string
//contains all permutations of length k.

import java.util.*;
public class BinarySubSequences {

 // to check all Permutation in given String
 public static boolean tocheck(String s, int k)
 {
     List<String> list = BinarySubsets(k);

     // to check binary sequences are available 
     // in string or not
     for (String b : list) 
         if (s.indexOf(b) == -1)
             return false;        

     return true;
 }

 // to generate all binary subsets of given length k
 public static List<String> BinarySubsets(int k)
 {
     // Decalre the list as String
     List<String> list = new ArrayList<>();

     // to define the format of binary of 
     // given length k
     String format = "%0" + k + "d";

     // returns the string representation of the
     // unsigned integer value represented by
     // the argument in binary (base 2)  using
     // Integer.toBinaryString and convert it
     // into integer using Integer.valueOf.
     // Loop for 2<sup>k</sup> elements
     for (int i = 0; i < Math.pow(2, k); i++) 
     {
         // To add in the list all possible 
         // binary sequence of given length
    	 //System.out.println(Integer.toBinaryString(i));
         list.add(String.format(format,
             Integer.valueOf(Integer.toBinaryString(i))));

         // To Show all binary sequence of given 
           // length k 
         System.out.println(String.format(format,
         Integer.valueOf(Integer.toBinaryString(i))));
     }
     return list;
 }

 // drive main
 public static void main(String[] args)
 {
     String str = "11001";
     int num = 4;
     if (tocheck(str, num))
         System.out.println("Yes");
     else
         System.out.println("No");
 }
}

