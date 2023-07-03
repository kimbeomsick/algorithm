import java.util.*;



class Solution {
    
    static int[] course_cnt;
    static Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        
        course_cnt = new int[11];
        Arrays.fill(course_cnt,-1); // 초기화 
        for(int i : course){
            course_cnt[i]++;
        }
        
        for(String order : orders){
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar); // abc cba 를 주문해도 abc가 두번 주문된것이기 때문에 모든 메뉴에 대해 정렬 필요
            makeMenu(0,0,"",orderChar);
        }
        
        
        ArrayList<String> list = new ArrayList<>();
        //하나씩 꺼내보기
        for(String key : map.keySet()){
            //해당 메뉴조합이 최고로 많이 불린 횟수 ans 2번이상 사용되어야함
            if(course_cnt[key.length()] == map.get(key)&& map.get(key)>1){ 
                list.add(key);    
            }
        }
        
        Collections.sort(list); //정렬
        
        
        String[] answer = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    public static void makeMenu(int idx, int depth, String key, char[] order){
        if(course_cnt[depth] != -1){
            map.put(key,map.getOrDefault(key,0)+1); //기존거 가져오기 or 0
            course_cnt[depth] = Math.max(course_cnt[depth], map.get(key)); // 단품조합( ex) 2,3,5 )이 중에 가장 많이 불린 횟수 저장 
        }
        
        for(int i = idx; i<order.length;i++){
            makeMenu(i+1,depth+1,key+order[i],order);
        }
    }
    
}