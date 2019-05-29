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
            int arr[] = new int[n];
            // int a, prev;
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            String o = "";
            
            int minIndex = 0;
            arr[0] = Integer.parseInt(strs[0]);

            // array elements input 
            for (int i = 1; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]);
                
                if (arr[i] < arr[i-1]) {
                    if (minIndex != i-1) {
                        o += "(" + minIndex + " " + (i - 1) + ") ";
                    }
                    minIndex = i;
                    continue;
                }
                
                if (i == n - 1 && arr[minIndex] < arr[i]) {
                    o += "(" + minIndex + " " + i + ") ";
                }
            }
            
            System.out.println(o.length() > 0 ? o : "No Profit");
  
            // Call function to perform action.
        }

        br.close(); 
    }
}

// Solution

// Assign first value in array as min value and loop through array from 1 to n - 1
// We need and element which is highest than the min
//   If the next element is less than min then the max till that will be previous element to it
//     store the min and previous element as max porift pair and update min value and continue looping.

// Problem https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0/

// The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

// Input: 
// First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days. 

// Output:
// For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

// Constraints:
// 1 <= T <= 100
// 2 <= N <= 103
// 0 <= Ai <= 104

// Example
// Input:
// 2
// 7
// 100 180 260 310 40 535 695
// 10
// 23 13 25 29 33 19 34 45 65 67

// Output:
// (0 3) (4 6)
// (1 4) (5 9)

// Explanation:
// Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.