import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase
        int testsCount = Integer.parseInt(br.readLine());
        int s, startIndex, i;
        while (testsCount-- > 0) {
            String input = br.readLine();
            // n : size of array 
            int n = Integer.parseInt(input.split(" ")[0]); 
            int sum = Integer.parseInt(input.split(" ")[1]);
  
            // Declaring array 
            int arr[] = new int[n]; 
            s = 0;
            startIndex = 0;
            i = 0;
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            String o = "-1";
            // array elements input 
            while (i < n || s > sum) {
                if (s > sum) {
                    s -= arr[startIndex];
                    startIndex++;
                } else if (s < sum ) {
                    arr[i] = Integer.parseInt(strs[i]);
                    s += arr[i];
                    i++;
                }
            
                if (sum == s) {
                    o = startIndex + 1 + " " + i;
                    break;
                }
            }
            
            System.out.println(o);
  
            // Call function to perform action.
        }

        br.close(); 
    }
}



// Problem https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0/

// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

// Output:
// For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 107
// 1 <= Ai <= 1010

// Example:
// Input:
// 2
// 5 12
// 1 2 3 7 5
// 10 15
// 1 2 3 4 5 6 7 8 9 10
// Output:
// 2 4
// 1 5

// Explanation : 
// Testcase1: sum of elements from 2nd position to 4th position is 12
// Testcase2: sum of elements from 1st position to 5th position is 15
