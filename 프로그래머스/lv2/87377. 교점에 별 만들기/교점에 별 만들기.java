import java.util.*;

class Solution {
    
    static List<int[]> list = new ArrayList<>();
    static int rowX = Integer.MAX_VALUE;
    static int rowY = Integer.MAX_VALUE;
    static int topX = Integer.MIN_VALUE;
    static int topY = Integer.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        
        int size = line.length;
        for(int i = 0;i<size-1;i++){
            for(int j = i+1;j<size;j++){
                addCross(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
            }
        }
        
        
        
     
        boolean[][] map = new boolean[topX-rowX+1][topY-rowY+1];
        for(int[] a : list){
            map[a[0]-rowX][a[1]-rowY] = true;
        }
        
        String[] answer = new String[topX-rowX+1];
        StringBuilder sb ;
            
        for(int i = 0;i<map.length;i++){
            sb = new StringBuilder();
            for(int j = 0;j<map[0].length;j++){
                if(map[map.length-1-i][j]){
                    sb.append("*");
                }else{
                    sb.append(".");
                }
            }
            answer[i] = sb.toString();
        }
        
        
        
        return answer;
    }
    
    public void addCross(long a1, long b1, long c1, long a2, long b2, long c2){
        
        //분모가 0이면 안함
        if((a2*b1)-(a1*b2) == 0 ||(b2*a1)-(b1*a2) == 0){
            return;
        }
        
        //정수 아니면 안함
        if(((a1*c2)-(a2*c1))%((a2*b1)-(a1*b2)) == 0 &&  ((b1*c2)-(b2*c1))%((b2*a1)-(b1*a2)) == 0){
            int x = (int)(((a1*c2)-(a2*c1))/((a2*b1)-(a1*b2)));
            int y = (int)(((b1*c2)-(b2*c1))/((b2*a1)-(b1*a2)));
            rowX = Math.min(x,rowX);
            rowY = Math.min(y,rowY);

            topX = Math.max(x,topX);
            topY = Math.max(y,topY);

            // 정수값만 담아야 하기 때문
            list.add(new int[]{x,y});
        }
        

    }
}