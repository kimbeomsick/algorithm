import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        int size = phone_book.length;
        
        // //길이 순으로 나열하기
        // Arrays.sort(phone_book,(a,b)->{
        //     return b.length()-a.length();
        // });
        
        
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<size;i++){
            map.put(phone_book[i], i);
        }
        
        
        for(int i = 0 ;i<size;i++){
            for(int j = 0;j<phone_book[i].length();j++){
            //     if(phone_book[i].length() > phone_book[j].length()){
            //         if(map.containsKey(phone_book[i].substring(0,phone_book[j].length()))){
            //             return false;
            //         }
            //     }
                
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
                
            }
        }
        
        return true;
    }
}