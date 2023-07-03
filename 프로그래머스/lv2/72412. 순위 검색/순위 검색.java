import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
 
class Solution {
       static HashMap<String, List<Integer>> map;

    static public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, List<Integer>>();

        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key)); //이분탐색을 위한 정렬
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", ""); // and를 모두없앤다.
            String p[] = query[i].split(" "); // 문자, 숫자 로 분리
            answer[i] = map.containsKey(p[0]) ? binarySearch(map.get(p[0]), Integer.parseInt(p[1])) : 0;
        }
        

        return answer;
    }

    static int binarySearch(List<Integer> list, int num) {
        int start = 0, end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < num)
                start = mid + 1;
            else
                end = mid;
        }

        return list.size() - start;



    }

    static void makeSentence(String[] p, String str, int idx) {
        if (idx == 4) {
            if (map.containsKey(str)) {
                map.get(str).add(Integer.parseInt(p[idx]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(p[idx]));
                map.put(str, list);
            }
            return;
        }
        makeSentence(p, str + "-", idx + 1);
        makeSentence(p, str + p[idx], idx + 1);
    }
}