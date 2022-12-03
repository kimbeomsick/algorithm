
import java.util.*;

public class Main {

    static Stack<Integer> list;
    static int R, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //배열의 크기
        R = sc.nextInt(); //지워야하는 숫자의 개수
        String str = sc.next(); //숫자를 문자열로 받기
        list = new Stack<>(); //문자열로 받은 숫자를 하나씩  꺼내쓰기위한 리스트


        int size = N-R;
        for(int i = 0; i < N;i++){

            //만약 list가 비어있지 않다면
            //지금 넣을 수보다 list의 맨 마지막 수가 더 작다면 꺼낼거임
            //몇개를 뽑을지 결정한다.
            while(!list.isEmpty()){
                if(R == 0) break; //더이상 지울게 없으면 탈출
                if(list.peek() < str.charAt(i)-'0'){
                    list.pop(); //들어오는 수보다 작다면 의미가 없다! 삭제
                    R--; //지울수 있는 개수 하나 줄어듬
                }else{
                    break;
                }
            }

            //list의 사이즈가 우리가 구하고자하는 수의 자리수와 맞으면 탈출
            if(list.size() == size) break;

            //모든 조건을 통과하고 수를 삽입함
            list.push(str.charAt(i)-'0');

            
        }

        //순서대로 출력
        for(int i : list){
            System.out.print(i);
        }
//        for(int i = 0;i<list.size()-R;i++){
//            System.out.print(list.get(i));
//        }
    }
}

// 그리디 알고리즘 이라는걸 알고 있었지만 생각나는게 dfs 밖에 없었음
// 이건 내가 생각지도 못한방법으로 풀어서 당황스러움
// 메모리와 시간을 보고 