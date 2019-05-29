class Trap {
  static int trappingWater(int arr[], int n) {
      // int n = arr.length;
      int a;
      int mid = n/2;
      int leftMaxj = next(arr, 0, mid - 1);
      int rightMaxj = next(arr, mid + 1, n - 1);
      int leftMaxi = leftMaxj;
      int rightMaxi = rightMaxj;
      
      int capacity = Math.min(leftMaxi, rightMaxi) - arr[mid];
      capacity = capacity < 0 ? 0 : capacity;
      int i = mid - 1, j = mid + 1;
      // System.out.println(capacity);
      while (i > -1 && j < n) {
        leftMaxi = arr[i] == leftMaxi ? next(arr, 0, i - 1) : leftMaxi;
        rightMaxi = arr[i + 1] > rightMaxi ? arr[i + 1] : rightMaxi;
        a = Math.min(leftMaxi, rightMaxi);
        if (a > -1 && a > arr[i]) capacity += a - arr[i];
      
        leftMaxj = Math.max(arr[j - 1], leftMaxj);
        rightMaxj = arr[j] == rightMaxj ? next(arr, j + 1, n - 1) : rightMaxj;
        a = Math.min(leftMaxj, rightMaxj);
        
        if (a > -1 && a > arr[j]) capacity += a - arr[j];

        i--;
        j++;
      }

      return capacity;
  } 
  
  private static int next(int[] arr, int start, int end)  { 
    int max = -1; 
    for (int i = start; i <= end; i++) {
      if (arr[i] > max) max = arr[i];
    }

    return max;  
  }
}

// Solution

// We need to find the max block on left and right to the element at current index and get min of them.
// Then that min - element value will give the capacity that can be stored at that index.

// Problem https://practice.geeksforgeeks.org/problems/trapping-rain-water/1/?track=md-arrays
