package Day_4;

import java.util.*;

public class find_all_anagrams {
    public static void main(String[] args) {
        String s="bcadcbseabc";
        String p="bca";
        HashMap<String,List<Integer>> map= new HashMap<>();
        List<Integer> ll= new  ArrayList<>();
        p=Getkey(p);
        int l=0, r=p.length()-1;
        while(r<s.length()){
            if(Getkey(s.substring(l,r+1)).equals(p)){
                ll.add(l);
            }
            l++;
            r++;
        }
//        return ll;

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


