class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int size = name.length();
        
        int idx;
        int move = size - 1;
        
        for(int i = 0;i<name.length();i++){
            answer+= Math.min(name.charAt(i) - 'A', 'Z'- name.charAt(i)+1);
            idx = i+1;
            while(idx < size && name.charAt(idx) == 'A'){
                idx++;
            }
            
            move = Math.min(move, i*2 +size-idx);
            move = Math.min(move,(size-idx)*2+i);
                
        }
        
        return answer+move;
    }
}