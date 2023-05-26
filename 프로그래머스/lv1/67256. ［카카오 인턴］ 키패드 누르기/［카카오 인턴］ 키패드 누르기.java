    class Solution {
        public String solution(int[] numbers, String hand) {

            int[][] keypad = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
            int[] R = {3,2};
            int[] L = {3,0};
            StringBuilder sb = new StringBuilder();

            for(int i = 0;i<numbers.length;i++){
                
                int num = numbers[i];
                int[] position = new int[2];

                //번호의 위치
                if(num == 0){ //0번을 누를 때
                    position[0] = 3;
                    position[1] = 1;
                }else{
                    position[0] = (num-1)/3; //가로 위치
                    position[1] = (num-1)%3; //세로 위치
                }
                
                
                
                // //손위치 출력해보기
                // System.out.printf("번호 : %d, (%d,%d)\n",num,position[0],position[1]);
                // System.out.printf("왼손 : (%d,%d)   ",L[0],L[1]);
                // System.out.printf("오른손 : (%d,%d)\n\n",R[0],R[1]);
                

                //어느손으로 칠지 정하기
                if(position[1] == 0){ //무조건 왼손
                    L[0] = position[0];
                    L[1] = position[1];
                    sb.append("L");
                    continue;
                }else if(position[1] == 2){ //무조건 오른손
                    R[0] = position[0];
                    R[1] = position[1];
                    sb.append("R");
                    continue;
                }else{




                    if(dist(R,position) < dist(L,position)){ //오른손이 더 가까운경우
                        R[0] = position[0];
                        R[1] = position[1];
                        sb.append("R");
                        continue;
                    }else if(dist(R,position) > dist(L,position)){ //왼손이 더 가까운경우
                        L[0] = position[0];
                        L[1] = position[1];
                        sb.append("L");
                        continue;
                    }else{
                        if(hand.equals("right")){ //오른손
                            R[0] = position[0];
                            R[1] = position[1];
                            sb.append("R");
                            continue;
                        }else{ //왼손
                            L[0] = position[0];
                            L[1] = position[1];
                            sb.append("L");
                            continue;
                        }
                    }
                }
                
                
                
            }



            return sb.toString();
        }

        public static int dist(int[] a, int[] b){
            return Math.abs(a[0] - b[0]) + Math.abs(a[1]-b[1]);
        }
    }