import java.util.*;


class Solution {
    Set<Character> set = new HashSet<>();
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0;i<skill.length();i++){
            set.add(skill.charAt(i)); //모든 스킬 넣기 
        }
        
        
        for(int i = 0;i<skill_trees.length;i++){
            String str = skill_trees[i];
            int idx = 0;
            boolean flag = true;
            System.out.print(str+"  ");
            for(int j = 0;j<str.length();j++){
                char ch = str.charAt(j);
                if(set.contains(ch)){ //skill tree에 포함되어 있는 스킬이다. 
                    if(skill.charAt(idx) == ch){ //다음 순서의 스킬이 맞는지 확인
                        idx++;
                    }else{
                        flag = false;
                        break; //반복문 스탑잇
                    }
                }
            }
            
            if(flag){
                System.out.println("가능");
                answer++;
            }else{
                System.out.println("불가능");
            }
            
            
        }
        
        
        return answer;
    }
}