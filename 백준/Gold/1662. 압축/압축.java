
import java.util.*;

public class Main {

    static Stack<Integer> stack;
    static Stack<Character> chstack; //문자열만 넣어줌
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 전체 문자열
        int arr[] = new int [str.length()]; // 문자배열을 숫자로 전부 치환함

        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '('){
                arr[i] = -1;
            }else if(str.charAt(i) == ')'){
                arr[i] = -2;
            }else{
                arr[i] = 1;
            }
        }




        stack = new Stack<>(); // 여기서 () 관리해 줄거임
        chstack = new Stack<>();
        for(int i = 0;i<arr.length;i++){


            //6 6 ( 5


            if(arr[i] == -2){
                int strLength = 0; // () 안에 들어가 있는 문자열의 길이
                while(true){

                    int curr = stack.pop(); // 현제 뽑은 수
                    chstack.pop();
                    if(curr == -1){ // ( 즉 -1을 발견했다면
                        stack.pop();// 하나 더꺼내서 곱할 값 꺼내버린다.

                        //(str.charAt()-'0'을 통해 원래 곱하려던 값을 찾아 가져온다. -> 이거 어케함..
                        strLength = strLength*(chstack.pop()-'0');
                        stack.push(strLength);
                        chstack.push('s');
                        break;
                    }else{
                        strLength += curr;
                    }
                }
            }else{
                stack.add(arr[i]);
                chstack.add(str.charAt((i)));
            }
        }

//

        int result = 0;
        for(int i : stack){
            result += i;
        }
        System.out.println(result);


    }
}
