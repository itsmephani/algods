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
  
            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
  
            // array elements input 
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]); 
            }
            
            MergeSort m = new MergeSort();
            m.sort(arr, 0, n-1);

            System.out.println(m.inversions);
            
            // Call function to perform action.
        }

        br.close(); 
    }
}

class MergeSort {
    public long inversions;
    public MergeSort() {
        this.inversions = 0;
    }

    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) { 
            L[i] = arr[l + i]; 
            // System.out.print(L[i]);
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j]; 
            // System.out.println(R[j]);
        }
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j];
                // System.out.print(arr[k] + " - ");

                // Solution
                // count of elements which are greater than element to be sorted from right array
                this.inversions += L.length - i; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
            // this.inversions += 1;
            // System.out.println(arr[k] + " - ");
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
        // System.out.println("inversions " + inversions);
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
}

// Problem  https://practice.geeksforgeeks.org/problems/inversion-of-array/0/

// Given an array of positive integers. The task is to find inversion count of array.

// Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains N elements.

// Output:
// Print the inversion count of array.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 107
// 1 ≤ C ≤ 1018

// Example:
// Input:
// 1
// 5
// 2 4 1 3 5

// Output:
// 3

// Explanation:
// Testcase 1: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

