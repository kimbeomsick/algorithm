
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    static int N,result = 0;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }


//        int[][] Nmap = arrow(map, "left");
//        for(int[] m : Nmap){
//            System.out.println(Arrays.toString(m));
//        }

        dfs(map, 0);
        System.out.println(result);
    }

    static void dfs(int[][] map, int depth){
        if(depth == 5 ){
            for(int i = 0;i <N;i++){
                for(int j = 0;j<N;j++){
                    result = Math.max(map[i][j],result);
                }
            }
            return;
        }

        dfs(arrow(map,"up"),depth+1);
        dfs(arrow(map,"right"),depth+1);
        dfs(arrow(map,"left"),depth+1);
        dfs(arrow(map,"down"),depth+1);


    }


    static int[][] arrow(int[][] map, String option) {
        int[][] Nmap = new int[N][N];
        Stack<Integer> stack = new Stack<>();

        //map 복사하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Nmap[i][j] = map[i][j];
            }
        }


        switch (option) {
            case "up":

                //위로 옮기기
                for (int c = 0; c < N; c++) {
                    boolean check = true;
                    for (int r = 0; r < N; r++) {
                        if (Nmap[r][c] == 0) continue;

                        if (stack.isEmpty()) { //비어 있으면 일단 넣음
                            stack.add(Nmap[r][c]);
                        } else if (stack.peek() == Nmap[r][c] && check) {
                            stack.pop();
                            stack.add(Nmap[r][c] * 2);
                            check = false;
                        } else {
                            stack.add(Nmap[r][c]);
                            check = true;
                        }

                        Nmap[r][c] = 0;
                    }

                    int r = 0;
                    for (int num : stack) {
                        Nmap[r++][c] = num;
                    }
                    stack.clear(); // 스택 비우기

                }
                break;
            case "right":
                //오른쪽으로 옮기기
                for (int r = 0; r < N; r++) {
                    boolean check = true;
                    for (int c = N - 1; c >= 0; c--) {

                        if (Nmap[r][c] == 0) continue;

                        if (stack.isEmpty()) { //비어 있으면 일단 넣음
                            stack.add(Nmap[r][c]);
                        } else if (stack.peek() == Nmap[r][c] && check) {
                            stack.pop();
                            stack.add(Nmap[r][c] * 2);
                            check = false;
                        } else {
                            stack.add(Nmap[r][c]);
                            check = true;
                        }

                        // 뺀 공간은 0 으로 처리
                        Nmap[r][c] = 0;
                    }

                    int c = N - 1;



                    for (int num : stack) {
                        Nmap[r][c--] = num;
                    }
                    stack.clear(); // 스택 비우기

                }
                break;
            case "left":
                //왼쪽으로 옮기기
                for (int r = 0; r < N; r++) {
                    boolean check = true;
                    for (int c = 0; c < N; c++) {

                        if (Nmap[r][c] == 0) continue;

                        if (stack.isEmpty()) { //비어 있으면 일단 넣음
                            stack.add(Nmap[r][c]);
                        } else if (stack.peek() == Nmap[r][c] && check) {
                            stack.pop();
                            stack.add(Nmap[r][c] * 2);
                            check = false;
                        } else {
                            stack.add(Nmap[r][c]);
                            check = true;
                        }

                        // 뺀 공간은 0 으로 처리
                        Nmap[r][c] = 0;
                    }

                    int c = 0;
                    for (int num : stack) {
                        Nmap[r][c++] = num;
                    }
                    stack.clear(); // 스택 비우기
                }
                break;
            case "down":
                //아래로 옮기기
                for (int c = 0; c < N; c++) {
                    boolean check = true;
                    for (int r = N - 1; r >= 0; r--) {
                        if (Nmap[r][c] == 0) continue;

                        if (stack.isEmpty()) { //비어 있으면 일단 넣음
                            stack.add(Nmap[r][c]);
                        } else if (stack.peek() == Nmap[r][c] && check) {
                            stack.pop();
                            stack.add(Nmap[r][c] * 2);
                            check= false;
                        } else {
                            stack.add(Nmap[r][c]);
                            check = true;
                        }

                        Nmap[r][c] = 0;
                    }

                    int r = N-1;
                    for (int num : stack) {
                        Nmap[r--][c] = num;
                    }
                    stack.clear(); // 스택 비우기
                }
                break;
        }


        return Nmap;
    }
}


