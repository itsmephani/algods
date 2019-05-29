class Program
{
    /*You are required to complete this method*/ 
    int maxLen(int[] arr) 
    {
        Map<Integer, Integer> sumIdx = new HashMap();
        int sum = 0;
        int maxLen = 0;
        int i = 0;
        sumIdx.put(sum, -1);
        for(int x : arr){
            sum += (x == 0) ? -1 : 1;
            // 1 0 1 0 -> 1,0 0,1 1
            if(sumIdx.containsKey(sum)){
                int prevIdx = sumIdx.get(sum);
                maxLen = Math.max(maxLen, i - prevIdx);
            }else{
                sumIdx.put(sum, i);
            }
            i++;
        }
        return maxLen;
    }
}

// Solution
// 1. Convert all 0 to -1 so that we need to find and largest subarray with sum 0 (as equal 1 and -1 would sum to 0).
// 2. Maintain a map with sum first occured and index at that sum. intialise map with sum 0 at -1 index
// 3. Start with max sub array length as 0 and loop through array.
// Eg 1 1 0 1 0 0 -> 1 1 -1 1 -1 -1
// Store 1 -> 0, 2 -> 1
//   at index 2 sum will be 1 again.
//   1 is already present update max length as current index(2) - sum 1 occurred for first time(0)
//   .i.e  1 -1 is the max sub array till now and continue looping.
// 1 -> 0, 2 -> 1, 
//   at index 3 sum will be 2 again.
//   2 is already present update max length as current index(3) - sum 2 occurred for first time(1)
//   as max length is not more than earlier max length keep looping
// 1 -> 0, 2 -> 1, 
//   at index 4 sum will be 1 again.
//   1 is already present update max length as current index(4) - sum 1 occurred for first time(0)
//   .i.e  1 -1 1 -1 is the max sub array till now and continue looping.
// 1 -> 0, 2 -> 1, 
//   at index 5 sum will be 0.
//   0 is already present update max length as current index(5) - sum 0 occurred i.e -1
//   .i.e  1 1 -1 1 -1 -1 is the max sub array till now .

// return maxLength


// Problem https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/

// Given an array of 0's and 1's your task is to complete the function maxLen which returns size of the largest sub array with equal number of 0's and 1's. The function maxLen takes 2 arguments. The first argument is the array A[] and second argument is the size 'N' of the array A[].

// Input:
// The first line of the input is T denoting the number of test cases. Then T test cases follow . Each test case contains two lines. The first line of each test case is a number N denoting the size of the array and in the next line are N space separated values of A [].

// Output:
// For each test case output in a new line the max length of the subarray.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 100
// 0 <= A[] <= 1

// Example:
// Input 
// 2
// 4
// 0 1 0 1
// 5
// 0 0 1 0 0

// Output
// 4
// 2

// Explanation:
// Testacase 1: The array from index [0...3] contains equal number of 0's and 1's. Thus maximum length of subarray having equal number of 0's and 1's is 4. 
