import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] income = new int[enroll.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<enroll.length;i++){
            map.put(enroll[i],i);
        }
        
        for(int i = 0;i<seller.length;i++){
            String name = seller[i];
            int price = amount[i]*100;
            income[map.get(name)] += price - (price/10); // 무조건 10% 때고 시작함 
            // System.out.printf("수입을 얻은 놈 %s(%d) => ", name,price-(price/10));
            price /= 10;
            
            
            while(true){
                String ref = referral[map.get(name)]; // 부모 가져오기 
                // System.out.printf(" %s(%d) -> ",ref,price-(price/10));
                if(ref.equals("-")) break; // 부모가 없으면 탈출 
                
                //부모에게 돈 주기 
                income[map.get(ref)]+=price - price/10; //  무조건 10% 때고 시작함 
                price /= 10;
                
                if(price == 0)break; // 위로 올려줄 돈 없으면 탈출
                name = ref;
            }
            System.out.println();
        }
        
        
        return income;
    }
}


// ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
// ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
// ["young", "john", "tod", "emily", "mary"]
// [12, 4, 2, 5, 10]
// [360, 958, 108, 0, 450, 18, 180, 1080]