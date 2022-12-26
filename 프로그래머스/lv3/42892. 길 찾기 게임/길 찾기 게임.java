import java.util.*;
    
class Node implements Comparable<Node> {
        int r;
        int c;
        int N;

        Node front = null;
        Node back = null;

        public Node(int N, int c, int r) {
            this.N = N;
            this.c = c;
            this.r = r;
        }



        public void insert(Node n) {
            if (n.c > this.c) {
                if (back == null) {
                    back = n;
                } else {
                    back.insert(n);
                }
            }

            else if (n.c < this.c) {
                if (front == null) {
                    front = n;
                } else {
                    front.insert(n);
                }
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", N=" + N +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(o.r == this.r){
                return this.c - o.c;
            }else{
                return o.r - this.r;
            }
        }
    }

    class Solution {
        static int[][] answer;
        static int pre = 0;
        static int post = 0;

        public void pre(Node n) {
            if (n == null) return;

            

            answer[0][pre++] = n.N;
            pre(n.front);
            pre(n.back);

        }

        public void post(Node n) {
            if (n == null) return;

            post(n.front);
            post(n.back);
            answer[1][post++] = n.N;

        }

        public int[][] solution(int[][] nodeinfo) {

            answer = new int[2][nodeinfo.length];
            List<Node> list = new ArrayList<>();

            int cnt = 1;
            for (int[] n : nodeinfo) {
                list.add(new Node(cnt++, n[0], n[1])); // 알아서 정렬됨
            }

            Collections.sort(list);

            // for(Node n : list){
            //     System.out.println(n);
            // }

            Node root = list.get(0);

            for(int i = 1; i<list.size();i++){
                Node curr = list.get(i);
                root.insert(curr);
            }


            pre(root);
            post(root);

            return answer;
        }
    }

