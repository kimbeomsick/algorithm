class Solution {
    public String solution(String new_id) {
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        new_id = new_id.replaceAll("[^a-z0-9A-Z-_.]","");
        
        //3 단계
        while(true){
            new_id = new_id.replace("..",".");
            if(!new_id.contains("..")){ //더이상 없으면 탈출
                break;
            }
        }
        
        //4단계
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }
        
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        //5단계
        if(new_id.length() == 0){
            new_id = "a";
        }
        
        //6단계
        if(new_id.length() > 15){
        new_id = new_id.substring(0,15); // 15이전까지 자르는거임     
        }
        
        
        // 4단계 한번더 
        if(new_id.startsWith(".")){
            new_id = new_id.substring(1);
        }
        
        if(new_id.endsWith(".")){
            new_id = new_id.substring(0,new_id.length()-1);
        }
        
        //7단계
        while(new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length()-1);
        }
        
        
        
        return new_id;
    }
}