import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        m = m.replace("A#","a").replace("G#","g").replace("C#","c").replace("D#","d").replace("F#","f");
        int len = musicinfos.length;
        String strArr[][] = new String[len][3];
        
        for(int i = 0;i<len;i++){
            String title = musicinfos[i].split(",")[2]; //제목
            String content = musicinfos[i].split(",")[3].replace("A#","a").replace("G#","g").replace("C#","c").replace("D#","d").replace("F#","f"); //곡 정ㅇ보
            int size = time(musicinfos[i]); // 음악이 흘러가는 시간
            
            StringBuilder st = new StringBuilder(); // 총음악정보 담기
            for(int j = 0;j< size;j++){
                char ch = content.charAt(j%content.length()); // 각자리수 꺼내서 담아두기
                st.append(ch);
            }
            strArr[i][0] = title;
            strArr[i][1] = st.toString();
            strArr[i][2] = Integer.toString(size);
        }
        
        // for(String[] s : strArr){
        //     System.out.println(Arrays.toString(s));
        // }
        
        Arrays.sort(strArr,(a,b)->{
            return Integer.parseInt(b[2])-Integer.parseInt(a[2]);
        });
        
        for(int i = 0;i<len;i++){
            if(strArr[i][1].contains(m)){
                answer = strArr[i][0];
                break;
            }
        }
        
        return answer;
    }
    
    //시간을 분으로 변경해주는 함수
    public static int time(String str){
        String []strArr = str.split(",");
        String start = strArr[0];
        String end = strArr[1];
        
        return calc(end)-calc(start);
    }
    
    public static int calc(String str){
        int h = Integer.parseInt(str.split(":")[0]);
        int m = Integer.parseInt(str.split(":")[1]);
        return h*60 + m;
    }
}