import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        // taking input of number of testcase 
        int testsCount = Integer.parseInt(br.readLine()); 
  
        while (testsCount-- > 0) { 
            // n : size of array 
            int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    int maxEle = arr[n-1];
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    for(int i=n-1; i>=0; i--) {
		        if(arr[i] >= maxEle){
		            maxEle = arr[i];
		            res.add(maxEle);
		        }
		    }
		    for(int i=res.size()-1; i>=0; i--){
		        str.append(res.get(i)+" ");
		    }
		    System.out.println(str);
            // Call function to perform action.
        }

        br.close(); 
    }
}

// Solution
//  Assume max number as right most and Loop from right to left if the element is equal or greater than 
// the max element it is a leader as it is greater or equal than its right max element, update max number
// and continue.

// Problem https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0/

// Given an array of positive integers. Your task is to find the leaders in the array.
// Note: An element of array is leader if it is greater than or equal to 
// all the elements to its right side. Also, the rightmost element is always a leader. 

// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
// The first line of each test case contains a single integer N denoting the size of array.
// The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

// Output:
// Print all the leaders.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 107
// 0 <= Ai <= 107

// Example:
// Input:
// 3
// 6
// 16 17 4 3 5 2
// 5
// 1 2 3 4 0
// 5
// 7 4 5 7 3
// Output:
// 17 5 2
// 4 0
// 7 7 3

// Explanation:
// Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.