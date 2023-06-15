import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        
        HashSet<Integer>[] set = new HashSet[9];
        for(int i = 0;i<9;i++){
            set[i] = new HashSet<>();
        }
        set[1].add(N); //하나만 사용하기 때문에 N밖에 못들어감
        
        for(int i = 1;i<=8;i++){
            for(int j = 1;j<i;j++){
                for(int a : set[j]){
                    for(int b : set[i-j]){
                        set[i].add(a+b);
                        set[i].add(a*b);
                        set[i].add(a-b);
                        if(b != 0 && a != 0) set[i].add(a/b);
                        set[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
                    }
                }
            }
            if(set[i].contains(number)) return i;
        }
        
        return -1;
    }
}