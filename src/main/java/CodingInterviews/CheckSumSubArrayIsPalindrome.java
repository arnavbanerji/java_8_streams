package CodingInterviews;

import java.util.*;

/*Check if sum of any subarray is Palindrome or not.
Input: arr[] = {10, 6, 7, 9, 13}
        Output: Yes
        Explanation:
        The subarray [6, 7, 9] with sum 22 is palindrome.*/
public class CheckSumSubArrayIsPalindrome {
    public static void main(String[] args) {
        //int arr[] = {10, 6, 7, 9, 12}; this is also acceptable way to declare array, this is more of C-style syntax
        int[] arr = {10, 6, 7, 9, 13};
        int[] indexes = logic(arr);
        if(indexes[0]!=-1) {
            for(int i=indexes[0] ; i<=indexes[1] ; i++) {
                System.out.print(arr[i]+" ");
                System.out.println();
            }
        } else {
            System.out.println("Not Found");
        }
    }

    public static int[] logic(int[] arr) {
        int[] indexes = {-1,-1}; //stores the starting and ending indexes of the verified array
        Set<Long> sums = new HashSet<>(); //for amortization (performance reason)
        for(int i=0 ; i<arr.length ; i++) {
            long sum = arr[i];
            for(int j=i+1 ; j<arr.length ; j++) {
                sum+=arr[j];
                if(!sums.contains(sum) && isPalindrome(sum)) {
                    indexes[0] = i;
                    indexes[1] = j;
                    break;
                }
                sums.add(sum);
            }
            if(indexes[0]!=-1) {
                break;
            }
        }
        return indexes;
    }

    public static boolean isPalindrome(long num) {
        int reverse = 0;
        long temp = num;
        while(temp>0) {
            long lastDigit = temp%10;
            reverse = (int) (reverse * 10 + lastDigit);
            temp/=10;
        }
        if(num == reverse) {
            return true;
        } else {
            return false;
        }
    }
}
