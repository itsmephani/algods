
public class Program {
  public static void main(String[] args) throws IOException {
      // Using BufferedReader class to take input 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

      // taking input of number of testcase 
      int testsCount = Integer.parseInt(br.readLine()); 

      while (testsCount-- > 0) { 
          // n : size of array 
          int n = Integer.parseInt(br.readLine()); 

          // Declaring array 
          int arr[] = new int[n]; 

          // to read multiple integers line 
          String line = br.readLine(); 
          String[] strs = line.trim().split("\\s+"); 

          
          // array elements input
          int i = 0, j = strs.length - 1, left, right;
          int leftSum = Integer.parseInt(strs[i]);
          int rightSum = Integer.parseInt(strs[j]);
          int o = -1;
          if (n == 1) {
              o = 1;
          }
          while(i < j) {
              if (leftSum <= rightSum) {
                  i++;
                  leftSum += Integer.parseInt(strs[i]);
              } else if (leftSum > rightSum) {
                  j--;
                  rightSum += Integer.parseInt(strs[j]);
              }
              
              if (j - i == 2 && leftSum == rightSum) {
                  o = i + 1 + 1;
                  break;
              }
          }
          
          System.out.println(o);
          // Call function to perform action.
      }

      br.close(); 
  }
}


// Solution
// sum from left and right and check for index where left sum == right sum
// increase left sum if it is less than right
// increase right sum if is less than left 

// Problem https://practice.geeksforgeeks.org/problems/equilibrium-point/0/

// Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

// Input:
// The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Then in the next line are N space separated values of the array A.

// Output:
// For each test case in a new  line print the position at which the elements are at equilibrium if no equilibrium point exists print -1.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 106
// 1 <= Ai <= 108

// Example:
// Input:
// 2
// 1
// 1
// 5
// 1 3 5 2 2

// Output:
// 1
// 3

// Explanation:
// Testcase 1: Since its the only element hence its the only equilibrium point.
// Testcase 2: For second test case equilibrium point is at position 3 as elements below it (1+3) = elements after it (2+2).
 