

```markdown
							           		# Infinity Champions Program



# Java Data Structures and Algorithms Practice

This repository contains solutions to various DSA problems, organized by day.

## Directory Structure
# Daily Algorithm Practice

This repository contains solutions to various algorithmic problems, organized by day.

| Day | File Name | Topic/Problem | Technique |
| :---: | :--- | :--- | :--- |
| **Day 1** |
| |`first_and_last_position_of_element_sorted_array.java` | Find First and Last Position of Element in Sorted Array | Binary Search |
| | `mini_no_of_arrows_to_burst_balloons.java` | Minimum Number of Arrows to Burst Balloons | Greedy |
| | `sliding_window_maximum.java` | Sliding Window Maximum | Priority Queue (Heap) |
| **Day 2**
| | `kth_largest_element.java` | Kth Largest Element in an Array | Min-Heap (Priority Queue) |
| | `merge_sorted_array.java` | Merge Sorted Array | Sorting / Two Pointers |
| | `valid_perfect_square.java` | Valid Perfect Square | Binary Search |
| **Day 3**
| | `search_in_2D_array.java` | Search a 2D Matrix | Binary Search |
| | `spiral_order.java` | Spiral Matrix | Layer-by-Layer Traversal |
| **Day 4** 
| | `find_all_anagrams.java` | Find All Anagrams in a String | Sliding Window (Frequency Map) |
| | `longest_repeating_character_replacement.java` | Longest Repeating Character Replacement | Sliding Window |
| | `longest_substring_without_repeating_characters.java` | Longest Substring Without Repeating Characters | Sliding Window (Hash Map) |
| | `permutation_in_sring.java` | Permutation in String | Sliding Window (Frequency Check) |
| **Day 5** 
| | `boats_to_save_people.java` | Boats to Save People | Greedy / Two Pointers |
| | `lemonade_change.java` | Lemonade Change | Greedy |
| | `minimum_no_of_arrows.java` | Minimum Number of Arrows to Burst Balloons | Greedy (Duplicate of Day 1) |
| | `non_overlapping_intervals.java` | Non-overlapping Intervals | Greedy (Sort by End Time) |
| **Day 6** 
| | `combination_sums_II.java` | Combination Sum II | Backtracking |
| | `combinations.java` | Combinations | Backtracking |

```

```
├── Day_1
|   ├── first_and_last_position_of_element_sorted_array.java (Binary Search)
|   ├── mini_no_of_arrows_to_burst_balloons.java (Greedy)
|   └── sliding_window_maximum.java (Priority Queue)
|
├── Day_2
|   ├── kth_largest_element.java (Min-Heap)
|   ├── merge_sorted_array.java (Sorting)
|   └── valid_perfect_square.java (Binary Search)
|
├── Day_3
|   ├── search_in_2D_array.java (Binary Search)
|   └── spiral_order.java (Traversal)
|
├── Day_4 (Sliding Window Focus)
|   ├── find_all_anagrams.java
|   ├── longest_repeating_character_replacement.java
|   ├── longest_substring_without_repeating_characters.java
|   └── permutation_in_sring.java
|
├── Day_5 (Greedy/Intervals)
|   ├── boats_to_save_people.java (Two Pointers)
|   ├── lemonade_change.java (Greedy)
|   ├── minimum_no_of_arrows.java (Greedy)
|   └── non_overlapping_intervals.java (Greedy)
|
├── Day_6 (Backtracking)
|   ├── combination_sums_II.java
|   └── combinations.java
|
└── README.md
```

````

---

## Day 1: Code Solutions

### `first_and_last_position_of_element_sorted_array.java`

Finds the starting and ending position of a given target value in a sorted array using Binary Search (O($\log n$)).

```java
package Day_1;

public class first_and_last_position_of_element_sorted_array {
    public static void main(String[] args) {
        int[] nums= {5,7,7,8,8,10};
        int target= 8;
        // using the two pass -> time complexity O(n)
        //... (commented out code for O(n) approach)

        // Using Binary Search

        int[] arr= {-1,-1};
        int left= binarySearch(nums,target,true);
        int right= binarySearch(nums,target,false);
        arr[0]=left;
        arr[1]=right;
        //... (return arr)
    }
    public static int binarySearch(int[] nums,int target,boolean isLeft){
        int lo=0,hi=nums.length-1;
        int idx=-1;
        while(lo<=hi){
            int mid= lo+ (hi-lo)/2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                idx = mid;
                if (isLeft) {
                    hi = mid - 1; // Search for first occurrence in the left half
                } else {
                    lo = mid + 1; // Search for last occurrence in the right half
                }
            }
        }
        return idx;
    }
}
````

-----

### `mini_no_of_arrows_to_burst_balloons.java`

Calculates the minimum number of arrows required to burst all balloons. This uses a **Greedy** approach by sorting based on the balloon's end point.

```java
package Day_1;

import java.util.Arrays;

public class mini_no_of_arrows_to_burst_balloons {
    public static void main(String[] args) {

        int[][] points= {{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(points,(a, b) -> Integer.compare(a[1],b[1]));
        int count=1;
        int re= points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>re){
                count++;
                re=points[i][1];
            }
        }
        // return count;
        System.out.println(count);
    }
}
```

-----

### `sliding_window_maximum.java`

Finds the maximum element in every sliding window of size `t` using a **Priority Queue** (Max Heap) to track the largest element efficiently.

```java
package Day_1;

import java.util.PriorityQueue; // Import missing in the original, added here for completeness

public class sliding_window_maximum {
    public static void main(String[] args) {
        int[] nums= {1,3,-1,-3,5,3,6,7};
        int k=3; // Used 'k' in the main logic, changed 't' to 'k' here for consistency
        int [] arr= new int[nums.length-k+1];

        //... (commented out code for Brute force approach)

        // using priority queue heap
        int n = nums.length;
        boolean[] invalid = new boolean[n]; // Tracks indices that have fallen out of the window
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]); // Max heap storing indices

        // add first k elements
        for (int i = 0; i < k; i++) {
            pq.add(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[pq.peek()];

        for (int i = k; i < n; i++) {
            invalid[i - k] = true;     // Mark the index leaving the window as invalid
            pq.add(i);               // Add the new element's index

            while (!pq.isEmpty() && invalid[pq.peek()]) {
                pq.poll(); // Remove indices that are outside the current window
            }
            ans[i - k + 1] = nums[pq.peek()]; // The peek is the max in the current window
        }

        // return ans;
    }
}
```

-----

## Day 2: Code Solutions

### `kth_largest_element.java`

Finds the **k-th largest element** in an array using a **Min-Heap** (Priority Queue). The heap size is maintained at `k`.

```java
package Day_2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kth_largest_element {
    public static void main(String[] args) {
        int[] nums= {3,2,1,5,6,4};
        int k=4;
        // Approach 1: sort the array and return the kth element from the last (O(n log n))
        //... (commented out code)

        // Approach 2: Min-Heap (O(n log k))
        // take the priority queue and add k element in it
        // from k to array last check if the current element is greater than priority queue peek
        // if yes replace the element and at the last return the pq.peek element
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        // return pq.peek();
        System.out.println(pq.peek());
    }
}
```

-----

### `merge_sorted_array.java`

Merges `nums2` into `nums1` in a non-decreasing order.

```java
package Day_2;

import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
        // Approach 1: insert arr2 in arr1 through index m+i and return the sorted array arr1
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n = 3;
        int[] nums2 = {2,5,6};
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1); // O((m+n) log (m+n))

        // Approach 2: (Two-pointer from the end for O(m+n) is preferred)
    }
}
```

-----

### `valid_perfect_square.java`

Checks if a given number is a perfect square using **Binary Search**.

```java
package Day_2;

public class valid_perfect_square {
    public static void main(String[] args) {
        // Best Approach using binary search keeping hi=n/2 because square root will always be less than n/2 for n > 1
        int n= 808201;
        boolean c=false;
        if(n==1) c= true;
        long lo=0;
        long hi=n/2;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(mid*mid==(long)n){
                // return true;
                c=true;
                break; // Added break for clean exit
            }
            else if(mid*mid<(long)n){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        System.out.println(c);
        // return c;
    }
}
```

-----

## Day 3: Code Solutions

### `search_in_2D_array.java`

Searches for a target value in an $m \times n$ matrix where each row is sorted, and the first element of each row is greater than the last element of the previous row. The approach first finds the correct row and then uses **Binary Search** within that row.

```java
package Day_3;

public class search_in_2D_array {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        // First Approach-using two loops traversal (O(n*m))
        
        // Second and best approach: Finding the row in which element is present and applying binary search in it (O(log(n) + log(m)))
        int row=matrix.length;
        int col= matrix[0].length;
        int r=0; // The row index
        for(int i=0;i<row;i++){
            if(target<=matrix[i][col-1]){
                r=i;
                break;
            }
        }
        int lo=0;
        int hi=col-1;
        boolean found = false; // Added to simulate return logic
        while(lo<=hi){
            int mid=(lo+hi)/2;;
            if(matrix[r][mid]>target){
                hi=mid-1;
            }
            else if(matrix[r][mid]==target){
                // return true;
                found = true;
                break;
            }
            else{
                lo=mid+1;
            }
        }
        // return false;
    }
}
```

-----

### `spiral_order.java`

Traverses a 2D matrix in a **spiral order** (right, down, left, up) using four boundary variables (`minr`, `maxr`, `minc`, `maxc`).

```java
package Day_3;

import java.util.ArrayList;
import java.util.List;

public class spiral_order {
    public static void main(String[] args) {
        // Simple and best approach:- Using 4 pass , we take 4 variables namely minrow, maxrow, mincol and maxcol
        // these four variables used to keep track order in direction right->bottom -> left -> up

        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        int minr=0;
        int maxr=matrix.length-1;
        int minc=0;
        int maxc=matrix[0].length-1;
        int tot=matrix.length*matrix[0].length;
        int c=0;
        List<Integer> list = new ArrayList<>();
        while(c<tot){
            // Right
            for(int i=minc;i<=maxc && c<tot;i++){
                list.add(matrix[minr][i]);
                c++;
            }
            minr++;

            // Down
            for(int i=minr;i<=maxr && c<tot;i++){
                list.add(matrix[i][maxc]);
                c++;
            }
            maxc--;

            // Left
            for(int i=maxc;i>=minc && c<tot;i--){
                list.add(matrix[maxr][i]);
                c++;
            }
            maxr--;

            // Up
            for(int i=maxr;i>=minr && c<tot;i--){
                list.add(matrix[i][minc]);
                c++;
            }
            minc++;
        }
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}
```

-----

## Day 4: Code Solutions (Sliding Window/String)

### `find_all_anagrams.java`

Finds all the starting indices of $p$'s anagrams in $s$ using a fixed-size **Sliding Window** and a helper function to generate a unique key (sorted frequency string) for comparison. A more efficient approach would use frequency arrays directly to avoid repeated string manipulation.

```java
package Day_4;

import java.util.*;

public class find_all_anagrams {
    public static void main(String[] args) {
        String s="bcadcbseabc";
        String p="bca";
        HashMap<String,List<Integer>> map= new HashMap<>();
        List<Integer> ll= new  ArrayList<>();
        p=Getkey(p); // Pre-sort the key string
        int l=0, r=p.length()-1;
        while(r<s.length()){
            if(Getkey(s.substring(l,r+1)).equals(p)){
                ll.add(l);
            }
            l++;
            r++;
        }
        // return ll;

    }

    public static String Getkey(String s){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i];j++){
                sb.append((char)(i+97));
            }
        }
        return sb.toString();
    }
}
```

-----

### `longest_repeating_character_replacement.java`

Finds the length of the longest substring containing the same letter after performing at most `k` replacements. This uses a **Sliding Window** where the window size is restricted by the rule: `window_length - max_freq <= k`.

```java
package Day_4;

public class longest_repeating_character_replacement {
    public static void main(String[] args) {

        String s= "ABAB";
        int k=2;

        int left = 0, n = s.length(), maxLen = 0, maxCount = 0;
        int[] freq = new int[26];
        for(int right = 0; right < n; right++){
            freq[s.charAt(right) - 'A']++;
            // Update maxCount, which is the frequency of the most frequent character in the current window
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            
            // If the number of characters to change (window length - max_freq) exceeds k, shrink the window
            if(right - left + 1 - maxCount > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            // The maxLen is the length of the valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        // return maxLen;
        System.out.println(maxLen);
    }
}
```

-----

### `longest_substring_without_repeating_characters.java`

Finds the length of the longest substring without repeating characters using a **Sliding Window** and a frequency map.

```java
package Day_4;

import java.util.*;

public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {

        String s="abcabcbb";

        int maxLength = 0;
        int l = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);

            // Shrink the window if the current character is a repeat
            while (count.get(c) > 1) {
                char leftChar = s.charAt(l);
                count.put(leftChar, count.get(leftChar) - 1);
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        // return maxLength;
        System.out.println(maxLength);
    }
}
```

-----

### `permutation_in_sring.java`

Checks if string $s1$ is a permutation of a substring in string $s2$ using a fixed-size **Sliding Window** and a frequency comparison key.

```java
package Day_4;

public class permutation_in_sring {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";

        int lo=0,hi=s1.length()-1;
        s1=getKey(s1);
        while(hi<s2.length()){
            if(getKey(s2.substring(lo,hi+1)).equals(s1)){
                // return true;
            }
            lo++;
            hi++;
        }
        // return false;
    }
    public static String getKey(String s){
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i];j++){
                sb.append((char)(i+97));
            }
        }
        return sb.toString();
    }
}
```

-----

## Day 5: Code Solutions (Greedy/Two Pointers)

### `boats_to_save_people.java`

Finds the minimum number of boats required to carry all people, with each boat having a weight limit. This uses a **Two-Pointer** and **Greedy** approach after sorting.

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Simple two pointer approach: decrease right and increase count if sum exceeds limit; 
        // otherwise, increase left and decrease right if sum <= limit.
      
        int Count = 0;
        Arrays.sort(people); // Important: Sort first

        int left = 0; // Lightest person
        int right = people.length - 1; // Heaviest person
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                Count++;
                left++; // Lightest and heaviest travel together
                right--;
            }
            else{
                Count++;
                right--; // Heaviest travels alone
            }
        }
        return Count;
    }
}
```

-----

### `lemonade_change.java`

Determines if a vendor can provide the correct change for all bills given, using a **Greedy** approach.

```java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Maintaining two variables for 5 and 10 dollar change. If change is insufficient, return false.
        
        int countfive = 0, countten = 0;
        for(int i = 0; i < bills.length; ++i){
            if(bills[i] == 5){
                countfive += 1;
            } else if(bills[i] == 10){
                if(countfive == 0) return false;
                countfive -= 1;
                countten += 1;
            } else { // bills[i] == 20
                // Greedy choice: prefer to use $10+$5 change over $5+$5+$5
                if(countten > 0 && countfive > 0){ 
                    countfive -= 1;
                    countten -= 1;
                } else if(countfive >= 3){
                    countfive -= 3;
                } else {
                     return false; // Insufficient change
                }
            }
        }
        return true;
    }
}
```

-----

### `minimum_no_of_arrows.java`

This is the same problem as `mini_no_of_arrows_to_burst_balloons.java` from Day 1. It finds the minimum number of arrows required using the **Greedy** approach of sorting by end-coordinates.

```java
class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sorting the array based on X-end and checking if the X-start of the next element is 
        // greater than the X-end of the current one. If it is, a new arrow is needed.
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int count=1;
        int prev=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>prev){
                count++;
                prev=points[i][1];
            }
        }
        return count;
        
    }
}
```

-----

### `non_overlapping_intervals.java`

Finds the minimum number of intervals to remove to make the rest of the intervals non-overlapping. A **Greedy** approach based on sorting by end-time is used to find the maximum number of non-overlapping intervals, and the result is `n - max_non_overlapping`.

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // Sort intervals by their end coordinate (Greedy choice)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0; // Index of the last non-overlapping interval found
        int count = 1; // Count of non-overlapping intervals (starts at 1 with the first interval)

        for (int i = 1; i < n; i++) {
            // If the current interval starts after or at the same time the previous non-overlapping one ends, it's non-overlapping
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        // Result is total intervals minus the maximum number of non-overlapping intervals
        return n - count; 
    }
}
```

-----

## Day 6: Code Solutions (Backtracking/Recursion)

### `combination_sums_II.java`

Finds all unique combinations in `candidates` where the numbers sum to `target`. Each number in `candidates` may only be used once in the combination. This uses **Backtracking** and careful handling of duplicates via sorting.

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates); // Sort to easily handle duplicates
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
    static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates: if the current element is the same as the previous one AND it's not the first element in the current recursive call
            if (i > ind && arr[i] == arr[i - 1]) continue; 
            if (arr[i] > target) break; // Optimization

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds); // Use i + 1 as elements can be used only once
            ds.remove(ds.size() - 1);
        }
    }
}
```

-----

### `combinations.java`

Returns all possible combinations of size $k$ from $n$ distinct numbers (1 to $n$). This is a classic **Backtracking** problem.

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> l1= new ArrayList<>();
        comb(ans,l1,k,n,1); // Start search from number 1
        return ans;
    }
    static void comb(List<List<Integer>> ans,List<Integer> l1,int k,int n,int idx){
        if(l1.size()==k){
            ans.add(new ArrayList<>(l1));
            return;
        }
        // The loop starts from 'idx' to ensure combinations are unique and numbers are increasing
        for(int i=idx;i<n+1;i++){
            l1.add(i);
            // The key mistake in the original code is '++idx'. This increments 'idx' immediately 
            // and incorrectly for subsequent recursive calls and the current loop iteration.
            // It should be 'i + 1' to only consider numbers greater than the current one.
            comb(ans,l1,k,n,i+1); // Correct recursive call: start search from i + 1
            l1.remove(l1.size()-1);
        }
    }
}
```

-----
