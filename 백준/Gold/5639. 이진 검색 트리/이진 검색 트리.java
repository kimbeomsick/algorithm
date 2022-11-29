

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        public void insert(int num){
            if(value > num){
                if(this.left == null){
                    this.left = new Node(num);
                }else{
                    this.left.insert(num);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(num);
                }else{
                    this.right.insert(num);
                }
            }
        }

        @Override
        public String toString() {
            return this.value+"\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node rootNode = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            rootNode.insert(Integer.parseInt(input));
        }

        postorder(rootNode);
    }

    static void postorder(Node node){

        if(node.left != null) postorder(node.left);
        if(node.right != null) postorder((node.right));
        System.out.print(node);
    }
}