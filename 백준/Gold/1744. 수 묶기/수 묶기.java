import java.util.*;

class Main{
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for(int i = 0;i<N;i++){
            int num = sc.nextInt();
            if(num <= 0){
                minus.add(num);
            }else{
                plus.add(num);
            }
        }

        Collections.sort(plus,(a,b)->{
            return b-a;
        }); //내림차순
        Collections.sort(minus); // 오름차순

        int result = 0;
        //양수 처리하기
        for(int i = 0;i<plus.size();i++){
            if(i == plus.size()-1){
                result += plus.get(i); // 마지막 하나 남으면 그냥 더함
            }else{
                result += Math.max(plus.get(i)*plus.get(i+1),plus.get(i)+plus.get(i+1)); //더하는거랑 곱하는것중 더 큰거 넣음
                i++;
            }
        }

        //음수 처리하기
        for(int i = 0;i<minus.size();i++){
            if(i == minus.size()-1){
                result += minus.get(i); // 마지막 하나 남으면 그냥 더함
            }else{
                result += Math.max(minus.get(i)*minus.get(i+1),minus.get(i)+minus.get(i+1)); //더하는거랑 곱하는것중 더 큰거 넣음
                i++;
            }
        }


        System.out.println(result);

    }
}