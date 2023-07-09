import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        
        Arrays.sort(arrayA); //여기서 제일 적은 수가 나눠저야 하는 거잖아 
        Arrays.sort(arrayB); //여기는 아마 제일 큰 수가 나눠지면 안되는 그런거겠지 
        
        
        
        return Math.max(func(arrayA, arrayB),func(arrayB, arrayA));
        
        
        
       
    }
    
    
    //여기서는 arrayA의 값이 더 적을 때를 가정한다. 
    public static int func(int[] arrayA, int[] arrayB){
        int answer = 0;

        
        ArrayList<Integer> list = new ArrayList<>(); // 나눌 수 있는 숫자 담아두기 
        
        //a의 시작이 큰지 b의 시작이 큰지 알아야한다. 
        // 만약 a의 시작이 크다면 a의 값들로 절대로 b를 전부다 나눌 수 없다. 
        
        //제일 작은 수가 가질 수 있는 모든 약수 
        for(int i = 1;i*i<=arrayA[0];i++){
            int num = arrayA[0];
            if(num%i == 0){
                if(i*i == num){
                    list.add(i);
                }else{
                    list.add(i);
                    list.add(num/i);    
                }
            }
        }
        
        Collections.sort(list); // 약수 정렬
        
        //arrayA를 모두 나눌 수 있는 제일 큰 약수 찾기 
        for(int i = list.size()-1;i>0;i--){
            boolean flag = true;
            int num = list.get(i);
            // System.out.println("num : "+num);
            
            for(int A : arrayA){ //해당약수로 나눌 수 없을때
                if(A%num != 0){
                    flag = false; 
                    break;
                }
            }
            
            if(!flag) continue; // 다음 약수 찾기 
            
            for(int B : arrayB){
                if(B%num == 0){
                    flag = false; // 해당 약수로 나눠진다면 
                }
            }
            
            if(!flag) continue; // 다음 약수 찾기 
            
            return num;
        }
        
        
        return answer;
    }
}

