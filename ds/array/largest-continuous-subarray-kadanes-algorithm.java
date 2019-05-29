import java.io.*;

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
            // int arr[] = new int[n];
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            int sumSoFar = Integer.parseInt(strs[0]);
            int globalSum = sumSoFar;
            int a, b;
            // array elements input 
            for (int i = 1; i < n; i++) {
                a = Integer.parseInt(strs[i]); 
                b = (sumSoFar + a);
                if (a > b)  sumSoFar = a; 
                else sumSoFar = b;
                if (globalSum < sumSoFar) {
                    globalSum = sumSoFar;
                }
            }
  
            System.out.println(globalSum);
            // Call function to perform action.
        }

        br.close(); 
    }
}

// Solution  https://afshinm.name/2018/06/24/why-kadane-algorithm-works/

// Problem  https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

// Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

// Output:
// Print the maximum sum of the contiguous sub-array in a separate line for each test case.

// Constraints:
// 1 ≤ T ≤ 110
// 1 ≤ N ≤ 106
// -107 ≤ A[i] <= 107

// Example:
// Input
// 2
// 5
// 1 2 3 -2 5
// 4
// -1 -2 -3 -4
// Output
// 9
// -1

// Explanation:
// Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.