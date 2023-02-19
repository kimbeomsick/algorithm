
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    // 숫자를 변경해서 넣어준다.
    // 항상 A루트가
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Node>();
        }


        //입력 받기
        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");

            int data = val[0].charAt(0) - 'A';
            int left = val[1].charAt(0) - 'A';
            int right = val[2].charAt(0) - 'A';
            list[data].add(new Node(left, right));
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }

    static void preOrder(int start){
        for(Node n : list[start]){
         int left = n.left;
         int right = n.right;

            System.out.print((char)(start+(int)'A'));
            if(left != -19){
                preOrder(left);
            }
            if(right != -19){
                preOrder(right);
            }
        }
    }

    static void inOrder(int start){

        for(Node n : list[start]){
            int left = n.left;
            int right = n.right;

            if(left != -19){
                inOrder(left);
            }
            System.out.print((char)(start+(int)'A'));
            if(right != -19){
                inOrder(right);
            }
        }
    }

    static void postOrder(int start){

        for(Node n : list[start]){
            int left = n.left;
            int right = n.right;

            if(left != -19){
                postOrder(left);
            }
            if(right != -19){
                postOrder(right);
            }
            System.out.print((char)(start+(int)'A'));
        }
    }

}

