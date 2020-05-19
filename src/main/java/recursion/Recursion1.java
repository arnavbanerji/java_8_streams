package recursion;

import java.util.*;

// Maximum length of concatenated string with unique characters
//Example input: ["un","iq","ue"]
//Answer: 4 -> uniq or ique (unue not possible because u is coming twice)
public class Recursion1 {

     public static void main(String []args){
        List<String> arr = new ArrayList<String>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        //System.out.println(arr.get(0));
        int res = maxLength(arr);
        System.out.println(res);
     }
     
     public static int maxLength(List<String> arr) {
         int[] result = new int[1];
         maxUnique(arr, 0, "", result);
         return result[0];
     }
     
     public static void maxUnique(List<String> arr, int index, String current, int[] result) {
         if(index == arr.size() && uniqueCharCount(current) > result[0]) {
			 result[0] = current.length();
			 return;
		 }
		 if(index == arr.size()) {
			 return;
		 }
		 
		 maxUnique(arr, index+1, current, result);
		 maxUnique(arr, index+1, current + arr.get(index), result);
     }
	 
	 public static int uniqueCharCount(String s) {
		 int[] counts = new int[26];
		 for(char c : s.toCharArray()) {
			 if(counts[c - 'a']++ > 0) {
				 return -1;
			 }
		 }
		 return s.length();
	 }
}