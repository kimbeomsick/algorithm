import java.util.*;

class Solution {
    public int maxSheepCount;
    public ArrayList<Integer>[] childs;

    public int solution(int[] info, int[][] edges) {
        // childs: 각 노드의 자식 노드 번호들을 저장
        // childs[x] 에는 x 노드의 자식 노드들이 ArrayList에 저장되어 있다.
        childs = new ArrayList[info.length];

        for (int[] link : edges) {
            int parent = link[0];
            int child = link[1];

            // child가 parent의 첫 자식 노드이면 childs[parent]의 값이 null이다
            if (childs[parent] == null) {
                childs[parent] = new ArrayList<>();
            }

            childs[parent].add(child);
        }

        // dfs가 진행되면서 각 depth마다 다음에 방문할 노드들은 새로운 List를 만들어 넣어 주어야 한다.
        // 이렇게 하지 않으면 모든 depth에서 같은 nextNodes를 공유하게 된다.
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        getAnimal(0, 0, 0, nextNodes, info);

        return maxSheepCount;
    }

    // sheepCount: 양의 수, wolfCount: 늑대의 수, node: 현재 노드, nextNodes: 다음에 갈 수 있는 노드들
    public void getAnimal(int sheepCount, int wolfCount, int node, List nextNodes, int[] info) {
        // XOR 연산으로 info[node]가 0일 때는 sheepCount에 1이 더하고,
        // info[node]가 1일 때는 wolfCount에 1을 더한다.
        sheepCount += info[node] ^ 1;
        wolfCount += info[node];
        maxSheepCount = Math.max(maxSheepCount, sheepCount);

        if (sheepCount <= wolfCount) {
            return;
        }

        List<Integer> copied = new ArrayList<>();
        copied.addAll(nextNodes);
      
        if(childs[node] != null){
            copied.addAll(childs[node]);
        }
        
        //현재 방문한 노드를 다음에 방문할 목록에서 삭제한다. 
        copied.remove(Integer.valueOf(node));
        
        for(int nextNode : copied){
            getAnimal(sheepCount,wolfCount, nextNode, copied, info);
        }
    }
}