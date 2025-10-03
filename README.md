├── Day_1
    ├── first_and_last_position_of_element_sorted_array.java
    ├── mini_no_of_arrows_to_burst_balloons.java
    └── sliding_window_maximum.java
├── Day_2
    ├── kth_largest_element.java
    ├── merge_sorted_array.java
    └── valid_perfect_square.java
├── Day_3
    ├── search_in_2D_array.java
    └── spiral_order.java
├── Day_4
    ├── find_all_anagrams.java
    ├── longest_repeating_character_replacement.java
    ├── longest_substring_without_repeating_characters.java
    └── permutation_in_sring.java
├── Day_5
    ├── boats_to_save_people.java
    ├── lemonade_change.java
    ├── minimum_no_of_arrows.java
    └── non_overlapping_intervals.java
├── Day_6
    ├── combination_sums_II.java
    └── combinations.java
└── README.md


/Day_1/first_and_last_position_of_element_sorted_array.java:
--------------------------------------------------------------------------------
 1 | package Day_1;
 2 | 
 3 | public class first_and_last_position_of_element_sorted_array {
 4 |     public static void main(String[] args) {
 5 |         int[] nums= {5,7,7,8,8,10};
 6 |         int target= 8;
 7 |         // using the two pass -> time complexity O(n)
 8 | //        int[] arr= {-1,-1};
 9 |         //loop for finding first position of element
10 | //        for(int i=0;i<nums.length;i++){
11 | //            if(nums[i]==target){
12 | //                arr[0]=i;
13 | //                break;
14 | //            }
15 | //        }
16 | //        if(arr[0]==-1){
17 | //            return arr;
18 | //        }
19 |         //loop for finding last position of element
20 | //        for(int i=arr[0];i<nums.length;i++){
21 | //            if(nums[i]==target){
22 | //                arr[1]=i;
23 | //            }
24 | //        }
25 | //        return arr;
26 | 
27 |         // Using Binary Search
28 | 
29 | 
30 |         int[] arr= {-1,-1};
31 |         int left= binarySearch(nums,target,true);
32 |         int right= binarySearch(nums,target,false);
33 |         arr[0]=left;
34 |         arr[1]=right;
35 | //        return arr;
36 | 
37 | 
38 |     }
39 |     public static int binarySearch(int[] nums,int target,boolean isLeft){
40 |         int lo=0,hi=nums.length-1;
41 |         int idx=-1;
42 |         while(lo<=hi){
43 |             int mid= lo+ (hi-lo)/2;
44 |             if (nums[mid] > target) {
45 |                 hi = mid - 1;
46 |             } else if (nums[mid] < target) {
47 |                 lo = mid + 1;
48 |             } else {
49 |                 idx = mid;
50 |                 if (isLeft) {
51 |                     hi = mid - 1;
52 |                 } else {
53 |                     lo = mid + 1;
54 |                 }
55 |             }
56 |         }
57 |         return idx;
58 |     }
59 | }
60 | 


--------------------------------------------------------------------------------
/Day_1/mini_no_of_arrows_to_burst_balloons.java:
--------------------------------------------------------------------------------
 1 | package Day_1;
 2 | 
 3 | import java.util.Arrays;
 4 | 
 5 | public class mini_no_of_arrows_to_burst_balloons {
 6 |     public static void main(String[] args) {
 7 | 
 8 |         int[][] points= {{10,16},{2,8},{1,6},{7,12}};
 9 |         Arrays.sort(points,(a, b) -> Integer.compare(a[1],b[1]));
10 |         int count=1;
11 |         int re= points[0][1];
12 |         for(int i=1;i<points.length;i++){
13 |             if(points[i][0]>re){
14 |                 count++;
15 |                 re=points[i][1];
16 |             }
17 |         }
18 | //        return count;
19 |         System.out.println(count);
20 |     }
21 | }
22 | 


--------------------------------------------------------------------------------
/Day_1/sliding_window_maximum.java:
--------------------------------------------------------------------------------
 1 | package Day_1;
 2 | 
 3 | public class sliding_window_maximum {
 4 |     public static void main(String[] args) {
 5 |         int[] nums= {1,3,-1,-3,5,3,6,7};
 6 |         int t=3;
 7 |         int [] arr= new int[nums.length-t+1];
 8 | 
 9 | //        Brute force approach 
10 | 
11 |         // int idx=0;
12 |         // int lo=0, hi=t-1;
13 |         // int max= Integer.MIN_VALUE;
14 |         // for(int k=lo;k<=hi;k++){
15 |         //     if(arr[k]>max){
16 |         //         max=arr[k];
17 |         //     }
18 |         // }
19 |         // arr[idx]=max;
20 |         // idx++;
21 |         // lo++;
22 |         // hi++;
23 |         // while(hi<=nums.length-1){
24 |         //     if(nums[hi]>max){
25 |         //         arr[idx]= nums[hi];
26 |         //         max= nums[hi];
27 |         //     }
28 |         //     else{
29 |         //         arr[idx]=max;
30 |         //     }
31 |         //     lo++;
32 |         //     hi++;
33 |         //     idx++;
34 | 
35 |         // }
36 | //        return arr;
37 | 
38 |     // }
39 |     // public int Max(int[] arr, int i, int j){
40 |     //     int max= Integer.MIN_VALUE;
41 |     //     for(int k=i;k<=j;k++){
42 |     //         if(arr[k]>max){
43 |     //             max=arr[k];
44 |     //         }
45 |     //     }
46 |     //     return max;
47 |     // }
48 | 
49 | 
50 |         // using priority queue heap
51 |         int n = nums.length;
52 |         boolean[] invalid = new boolean[n];
53 |         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
54 | 
55 |         // add first k elements
56 |         for (int i = 0; i < k; i++) {
57 |             pq.add(i);
58 |         }
59 | 
60 |         int[] ans = new int[n - k + 1];
61 |         ans[0] = nums[pq.peek()];
62 | 
63 |         for (int i = k; i < n; i++) {
64 |             invalid[i - k] = true;     
65 |             pq.add(i);               
66 | 
67 |             while (!pq.isEmpty() && invalid[pq.peek()]) {
68 |                 pq.poll();
69 |             }
70 |             ans[i - k + 1] = nums[pq.peek()];
71 |         }
72 | 
73 |         return ans;
74 |     }
75 | }
76 | 
77 | 


--------------------------------------------------------------------------------
/Day_2/kth_largest_element.java:
--------------------------------------------------------------------------------
 1 | package Day_2;
 2 | 
 3 | import java.util.Arrays;
 4 | import java.util.PriorityQueue;
 5 | 
 6 | public class kth_largest_element {
 7 |     public static void main(String[] args) {
 8 |         int[] nums= {3,2,1,5,6,4};
 9 |         int k=4;
10 |         // Approach 1: sort the array and return the kth element from the last
11 | //        Arrays.sort(nums);
12 | //        System.out.println(nums[nums.length-k]);
13 | 
14 | //        Approach 2: take the priority queue and add k element in it
15 | //        from k to array last check if the current element is greater than priority queue element
16 | //        if yes replace the element and at the last return the pq.peek element
17 |         PriorityQueue<Integer> pq= new PriorityQueue<>();
18 |         for(int i=0;i<k;i++){
19 |             pq.add(nums[i]);
20 |         }
21 |         for(int i=k;i<nums.length;i++){
22 |             if(nums[i]>pq.peek()){
23 |                 pq.poll();
24 |                 pq.add(nums[i]);
25 |             }
26 |         }
27 | //        return pq.peek();
28 |         System.out.println(pq.peek());
29 | 
30 |     }
31 | }
32 | 


--------------------------------------------------------------------------------
/Day_2/merge_sorted_array.java:
--------------------------------------------------------------------------------
 1 | package Day_2;
 2 | 
 3 | import java.util.Arrays;
 4 | 
 5 | public class merge_sorted_array {
 6 |     public static void main(String[] args) {
 7 | //        Approach 1: insert arr2 in arr1 through index m+i and return the sorted array arr1
 8 |         int[] nums1 = {1,2,3,0,0,0};
 9 |         int m = 3, n = 3;
10 |         int[] nums2 = {2,5,6};
11 |         for(int i=0;i<n;i++){
12 |             nums1[m+i]=nums2[i];
13 |         }
14 |         Arrays.sort(nums1);
15 | 
16 | //        Approach 2: 
17 |     }
18 | }
19 | 


--------------------------------------------------------------------------------
/Day_2/valid_perfect_square.java:
--------------------------------------------------------------------------------
 1 | package Day_2;
 2 | 
 3 | public class valid_perfect_square {
 4 |     public static void main(String[] args) {
 5 |         // Best Approach using binary search kepping hi=n/2 because square will always be less than n/2 of te number
 6 |         int n= 808201;
 7 |         boolean c=false;
 8 |         if(n==1) c= true;
 9 |         long lo=0;
10 |         long hi=n/2;
11 |         while(lo<=hi){
12 |             long mid=lo+(hi-lo)/2;
13 |             if(mid*mid==(long)n){
14 | //                return true;
15 |                 c=true;
16 |             }
17 |             else if(mid*mid<(long)n){
18 |                 lo=mid+1;
19 |             }
20 |             else{
21 |                 hi=mid-1;
22 |             }
23 |         }
24 |         System.out.println(c);
25 | //        return c;
26 |     }
27 | }
28 | 


--------------------------------------------------------------------------------
/Day_3/search_in_2D_array.java:
--------------------------------------------------------------------------------
 1 | package Day_3;
 2 | 
 3 | public class search_in_2D_array {
 4 |     public static void main(String[] args) {
 5 |         int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
 6 |         int target = 3;
 7 | //        First Approach-using two loops traversal of each element of matrix and return true if element in found
 8 | //        Time -complexity- O(n*m)
 9 | 
10 | //        Second and best approach Finding the row in which element is present and applying binary search in it
11 |         int row=matrix.length;
12 |         int col= matrix[0].length;
13 |         int r=0;
14 |         for(int i=0;i<row;i++){
15 |             if(target<=matrix[i][col-1]){
16 |                 r=i;
17 |                 break;
18 |             }
19 |         }
20 |         int lo=0;
21 |         int hi=col-1;
22 |         while(lo<=hi){
23 |             int mid=(lo+hi)/2;;
24 |             if(matrix[r][mid]>target){
25 |                 hi=mid-1;
26 |             }
27 |             else if(matrix[r][mid]==target){
28 | //                return true;
29 | 
30 |             }
31 | 
32 | 
33 |             else{
34 |                 lo=mid+1;
35 |             }
36 |         }
37 | //        return false;
38 |     }
39 | 
40 | }
41 | 


--------------------------------------------------------------------------------
/Day_3/spiral_order.java:
--------------------------------------------------------------------------------
 1 | package Day_3;
 2 | 
 3 | import java.util.ArrayList;
 4 | import java.util.List;
 5 | 
 6 | public class spiral_order {
 7 |     public static void main(String[] args) {
 8 | //        Simple and best approach:- Using 4 pass , we take 4variables namely minrow, maxrow,mincol and maxcol
 9 | //        these four variables used to keep track order in direction right->bottom -> left -> up
10 | 
11 |         int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
12 |         int minr=0;
13 |         int maxr=matrix.length-1;
14 |         int minc=0;
15 |         int maxc=matrix[0].length-1;
16 |         int tot=matrix.length*matrix[0].length;
17 |         int c=0;
18 |         List<Integer> list = new ArrayList<>();
19 |         while(c<tot){
20 |             for(int i=minc;i<=maxc && c<tot;i++){
21 |                 list.add(matrix[minr][i]);
22 |                 c++;
23 |             }
24 |             minr++;
25 | 
26 |             for(int i=minr;i<=maxr && c<tot;i++){
27 |                 list.add(matrix[i][maxc]);
28 |                 c++;
29 |             }
30 |             maxc--;
31 | 
32 |             for(int i=maxc;i>=minc && c<tot;i--){
33 |                 list.add(matrix[maxr][i]);
34 |                 c++;
35 |             }
36 |             maxr--;
37 | 
38 |             for(int i=maxr;i>=minr && c<tot;i--){
39 |                 list.add(matrix[i][minc]);
40 |                 c++;
41 |             }
42 |             minc++;
43 |         }
44 |         for(int i:list){
45 |             System.out.print(i+" ");
46 |         }
47 |     }
48 | }
49 | 
50 | 


--------------------------------------------------------------------------------
/Day_4/find_all_anagrams.java:
--------------------------------------------------------------------------------
 1 | package Day_4;
 2 | 
 3 | import java.util.*;
 4 | 
 5 | public class find_all_anagrams {
 6 |     public static void main(String[] args) {
 7 |         String s="bcadcbseabc";
 8 |         String p="bca";
 9 |         HashMap<String,List<Integer>> map= new HashMap<>();
10 |         List<Integer> ll= new  ArrayList<>();
11 |         p=Getkey(p);
12 |         int l=0, r=p.length()-1;
13 |         while(r<s.length()){
14 |             if(Getkey(s.substring(l,r+1)).equals(p)){
15 |                 ll.add(l);
16 |             }
17 |             l++;
18 |             r++;
19 |         }
20 | //        return ll;
21 | 
22 |     }
23 | 
24 | 
25 | 
26 |     public static String Getkey(String s){
27 |         int[] freq=new int[26];
28 |         for(int i=0;i<s.length();i++){
29 |             freq[s.charAt(i)-'a']++;
30 |         }
31 |         StringBuilder sb= new StringBuilder();
32 |         for(int i=0;i<26;i++){
33 |             for(int j=0;j<freq[i];j++){
34 |                 sb.append((char)(i+97));
35 | 
36 |             }
37 |         }
38 |         return sb.toString();
39 | 
40 |     }
41 | }
42 | 
43 | 
44 | 


--------------------------------------------------------------------------------
/Day_4/longest_repeating_character_replacement.java:
--------------------------------------------------------------------------------
 1 | package Day_4;
 2 | 
 3 | public class longest_repeating_character_replacement {
 4 |     public static void main(String[] args) {
 5 | 
 6 |         String s= "ABAB";
 7 |         int k=2;
 8 | 
 9 | 
10 |         int left = 0, n = s.length(), maxLen = 0, maxCount = 0;
11 |         int[] freq = new int[26];
12 |         for(int right = 0; right < n; right++){
13 |             freq[s.charAt(right) - 'A']++;
14 |             maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
15 |             if(right - left + 1 - maxCount > k){
16 |                 freq[s.charAt(left) - 'A']--;
17 |                 left++;
18 |             }
19 |             maxLen = Math.max(maxLen, right - left + 1);
20 |         }
21 | //        return maxLen;
22 |         System.out.println(maxLen);
23 |     }
24 | 
25 | }
26 | 
27 | 


--------------------------------------------------------------------------------
/Day_4/longest_substring_without_repeating_characters.java:
--------------------------------------------------------------------------------
 1 | package Day_4;
 2 | 
 3 | import java.util.*;
 4 | 
 5 | public class longest_substring_without_repeating_characters {
 6 |     public static void main(String[] args) {
 7 | 
 8 |         String s="abcabcbb";
 9 | 
10 |         int maxLength = 0;
11 |         int l = 0;
12 |         Map<Character, Integer> count = new HashMap<>();
13 | 
14 |         for (int r = 0; r < s.length(); r++) {
15 |             char c = s.charAt(r);
16 |             count.put(c, count.getOrDefault(c, 0) + 1);
17 | 
18 |             while (count.get(c) > 1) {
19 |                 char leftChar = s.charAt(l);
20 |                 count.put(leftChar, count.get(leftChar) - 1);
21 |                 l++;
22 |             }
23 | 
24 |             maxLength = Math.max(maxLength, r - l + 1);
25 |         }
26 | 
27 | //        return maxLength;
28 |         System.out.println(maxLength);
29 |     }
30 | }
31 | 


--------------------------------------------------------------------------------
/Day_4/permutation_in_sring.java:
--------------------------------------------------------------------------------
 1 | package Day_4;
 2 | 
 3 | public class permutation_in_sring {
 4 |     public static void main(String[] args) {
 5 |         String s1="ab";
 6 |         String s2="eidbaooo";
 7 | 
 8 |         int lo=0,hi=s1.length()-1;
 9 |         s1=getKey(s1);
10 |         while(hi<s2.length()){
11 |             if(getKey(s2.substring(lo,hi+1)).equals(s1)){
12 | //                return true;
13 |             }
14 |             lo++;
15 |             hi++;
16 |         }
17 | //        return false;
18 | 
19 | 
20 |     }
21 |     public static String getKey(String s){
22 |         int[] freq=new int[26];
23 |         for(int i=0;i<s.length();i++){
24 |             freq[s.charAt(i)-'a']++;
25 |         }
26 |         StringBuilder sb= new StringBuilder();
27 |         for(int i=0;i<26;i++){
28 |             for(int j=0;j<freq[i];j++){
29 |                 sb.append((char)(i+97));
30 | 
31 |             }
32 |         }
33 |         return sb.toString();
34 |     }
35 | }
36 | 


--------------------------------------------------------------------------------
/Day_5/boats_to_save_people.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public int numRescueBoats(int[] people, int limit) {
 3 | // simple two pointer approach decreasing right an icreasing count  if sum exceeds limits else increasing left, right pointer if sum <= limit
 4 |       
 5 |         int Count = 0;
 6 |         Arrays.sort(people);
 7 |         
 8 |         int left = 0;
 9 |         int right = people.length - 1;
10 |         
11 |         while(left <= right){
12 |             int sum = people[left] + people[right];
13 |             if(sum <= limit){
14 |                 Count++;
15 |                 left++;
16 |                 right--;
17 |             }
18 |             else{
19 |                 Count++;
20 |                 right--;
21 |             }
22 |         }
23 |         return Count;
24 |     }
25 | }
26 | 


--------------------------------------------------------------------------------
/Day_5/lemonade_change.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public boolean lemonadeChange(int[] bills) {
 3 | //  maintaining two variable for 5 and teo rupees change and i any of them at any time goes less than zero returning false and else true
 4 |       
 5 |         int countfive = 0, countten = 0;
 6 |         for(int i = 0; i < bills.length; ++i){
 7 |             if(bills[i] == 5){
 8 |                 countfive += 1;
 9 |             } else if(bills[i] == 10){
10 |                 if(countfive == 0) return false;
11 |                 countfive -= 1;
12 |                 countten += 1;
13 |             } else {
14 |                 if(!(countfive > 2) && !(countfive > 0 && countten > 0)){
15 |                      return false;
16 |                 }
17 | 
18 |                 if(countfive > 0 && countten > 0){
19 |                     countfive -= 1;
20 |                     countten -= 1;
21 |                 } else{
22 |                     countfive -= 3;
23 |                 }
24 |             }
25 |         }
26 |         return true;
27 |     }
28 | }
29 | 


--------------------------------------------------------------------------------
/Day_5/minimum_no_of_arrows.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public int findMinArrowShots(int[][] points) {
 3 | // sorting the array on basis of Xend and check if xstart of next element is less than equal to Xend of current the it will be shot by one arrow and 
 4 | //if not we need another arrow so increase the value by one
 5 |         Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
 6 |         int count=1;
 7 |         int prev=points[0][1];
 8 |         for(int i=1;i<points.length;i++){
 9 |             if(points[i][0]>prev){
10 |                 count++;
11 |                 prev=points[i][1];
12 |             }
13 |         }
14 |         return count;
15 |         
16 |     }
17 | }
18 | 


--------------------------------------------------------------------------------
/Day_5/non_overlapping_intervals.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public int eraseOverlapIntervals(int[][] intervals) {
 3 |         int n = intervals.length;
 4 | 
 5 |       
 6 |         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
 7 | 
 8 |         int prev = 0;
 9 |         int count = 1;
10 | 
11 |         for (int i = 1; i < n; i++) {
12 |             if (intervals[i][0] >= intervals[prev][1]) {
13 |                 prev = i;
14 |                 count++;
15 |             }
16 |         }
17 |         return n - count;
18 |     }
19 | }
20 | 


--------------------------------------------------------------------------------
/Day_6/combination_sums_II.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 3 |         List < List < Integer >> ans = new ArrayList < > ();
 4 |         Arrays.sort(candidates);
 5 |         findCombinations(0, candidates, target, ans, new ArrayList < > ());
 6 |         return ans;
 7 |     }
 8 |     static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
 9 |         if (target == 0) {
10 |             ans.add(new ArrayList < > (ds));
11 |             return;
12 |         }
13 | 
14 |         for (int i = ind; i < arr.length; i++) {
15 |             if (i > ind && arr[i] == arr[i - 1]) continue;
16 |             if (arr[i] > target) break;
17 | 
18 |             ds.add(arr[i]);
19 |             findCombinations(i + 1, arr, target - arr[i], ans, ds);
20 |             ds.remove(ds.size() - 1);
21 |         }
22 |     }
23 | }
24 | 


--------------------------------------------------------------------------------
/Day_6/combinations.java:
--------------------------------------------------------------------------------
 1 | class Solution {
 2 |     public List<List<Integer>> combine(int n, int k) {
 3 |         List<List<Integer>> ans= new ArrayList<>();
 4 |         List<Integer> l1= new ArrayList<>();
 5 |         comb(ans,l1,k,n,1);
 6 |         return ans;
 7 | 
 8 |     }
 9 |     static void comb(List<List<Integer>> ans,List<Integer> l1,int k,int n,int idx){
10 |         if(l1.size()==k){
11 |             ans.add(new ArrayList<>(l1));
12 |             return;
13 |         }
14 |         for(int i=idx;i<n+1;i++){
15 |             l1.add(i);
16 |             comb(ans,l1,k,n,++idx);
17 |             l1.remove(l1.size()-1);
18 |         }
19 | 
20 |     }
21 | }
22 | 


--------------------------------------------------------------------------------
/README.md:
--------------------------------------------------------------------------------
1 | "# ICP" 
2 | "# ICP" 
3 | 


--------------------------------------------------------------------------------
