import java.util.*;

class Solution {
    static int keySize;
    static int lockSize;
    
    //key를 돌리는 함수 
    public int[][] rotate(int[][] key){
        
        
        int[][] temp = new int[keySize][keySize];
        
        for(int i = 0;i<keySize;i++){
            for(int j = 0;j<keySize;j++){
                temp[i][j] = key[i][j];
            }
        }
        
        //시계방향으로 90도 회전 
        for(int i = 0;i<keySize;i++){
            for(int j = 0;j<keySize;j++){
                temp[j][keySize-1-i] = key[i][j];
            }
        }
        
        return temp;
    }
    
    
    
    //돌린 키로 훑어보는 함수 
    public boolean correct(int[][] key, int[][]map){
        
        int length = keySize + lockSize;
       
        for( int i = 0;i<length;i++){
            for( int j = 0;j<length;j++){
                
                int sum = 0;
                for(int q = keySize;q<length;q++){
                    for(int k = keySize;k<length;k++){
                        
                        int val = 0;
                        if(q-i >= 0 && q-i < keySize && k-j >=0 && k-j < keySize){
                            val = key[q-i][k-j];
                        }
                        if(val + map[q][k] == 1){
                            sum++;
                        }
                    }
                }
                
                if(sum == lockSize*lockSize) return true;
                
            }
        } 
        
        return false;
    }
    

    
    
    public boolean solution(int[][] key, int[][] lock) {
        
        keySize = key.length;
        lockSize = lock.length;
        int[][] map = new int[keySize*2+lockSize][keySize*2+lockSize];
        
        for(int i = 0;i<lockSize;i++){
            for(int j = 0;j<lockSize;j++){
                map[keySize+i][keySize+j] = lock[i][j];
            }
        }
        
        for(int i = 0;i<4;i++){
            if(correct(key, map)){
                return true;
            }
            key = rotate(key);
            
        }
        return false;
    }
    
}