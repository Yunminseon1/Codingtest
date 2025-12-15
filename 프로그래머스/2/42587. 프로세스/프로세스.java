import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<int[]> queue = new LinkedList<>();

        // (중요도, 원래 위치)
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean isHigh = false;

            // 더 높은 중요도 있는지 검사
            for (int[] q : queue) {
                if (q[0] > cur[0]) {
                    isHigh = true;
                    break;
                }
            }

            if (isHigh) {
                queue.add(cur);
            } else {
                order++;
                if (cur[1] == location) {
                    return order;
                }
            }
        }

        return 0;
    }
}
