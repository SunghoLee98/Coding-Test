import java.util.*;

class Solution {
    int len;
    HashSet<String> hsh = new HashSet<String>();
    public boolean solution(String[] phone_book) {
        //Arrays.sort(phone_book, (o1, o2) -> {return o1.length() - o2.length();});
        
        for(String str: phone_book){
            for(int i = 1; i < str.length(); i++){
                //System.out.println(str.substring(0,i));
                hsh.add(str.substring(0,i)); 
            }    
        }
        
        for(String str: phone_book){
            if(hsh.contains(str))
                return false;
        }
    
        return true;
    }
}