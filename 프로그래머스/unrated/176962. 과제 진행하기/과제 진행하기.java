import java.util.*;

class Solution {
    
    static class Node{
        String name;
        int start;
        int time;
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        int size = plans.length;
        Node[] list = new Node[size];
        
        String[] str;
        for(int i = 0;i<size;i++){
            list[i] = new Node();
            list[i].name = plans[i][0];
            str = plans[i][1].split(":");
            list[i].start = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            list[i].time = Integer.parseInt(plans[i][2]);
        }
        
        Arrays.sort(list, (a,b)-> a.start - b.start);

        Stack<Node> stack = new Stack<>();
        Node now;
        int idx = 0;
        int result_idx = 0;
        
        while(idx < size || stack.size() > 0 ){ // 남아있으면 계속함
            
//             System.out.println("\n완료된 과목");
//             for(String a : answer){
//                 System.out.printf("%s ", a);
//             }
            
//             System.out.println("\n미룬 과목");
//             for(Node node : stack){
//                 System.out.printf("%s ", node.name);
//             }
            
            
            
            now = list[idx++];
            // System.out.println("\n현재 고른수업 : "+now.name);
            if(idx < size){ //정규 수업이 더 있을 때
                if(now.start+now.time == list[idx].start){ // 끝나는 시간과 딱 맞을 때
                    answer[result_idx++] = now.name; 
                }else if(now.start+now.time < list[idx].start){ // 수업이 끝나고 다음수업까지 시간이 좀 남을때
                    answer[result_idx++] = now.name; 
                    int term = list[idx].start - (now.start+now.time);
                    while(stack.size() > 0 && term != 0){ // 만약 미뤄둔 수업이 있다면 꺼내서 남은 시간으로 하나씩까버림
                        Node node = stack.pop();
                        // System.out.println("term"+term);
                        // System.out.println("\n남은 시간을 까기위해 나온 수업 : "+node.name+"남은시간 : "+node.time);
                        if(term - node.time >= 0){ //남은 시간으로 미뤘던 수업시간 까버리기 가능!
                            answer[result_idx++] = node.name;
                            term -= node.time;
                        }else{ 
                            node.time -= term; // 시간 까기
                            stack.push(node); // 다시 넣어둠
                            term = 0;
                        }
                    }
                }else{ //시간이 겹칠때.
                    
                    now.time = now.start+now.time - list[idx].start; // 진행한 시간만큼 감소
                    stack.push(now);
                }
            }else if(idx == size){ // 마지막 정규 수업이라면
                answer[result_idx++] = now.name;
                while(stack.size() > 0){
                    Node node = stack.pop();
                    answer[result_idx++] = node.name;
                    
                    
                    
                }
            }
        }
        
      
        return answer;
    }
}