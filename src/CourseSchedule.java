import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        findOrder(4, new int[][]{{1,0}, {2,0}, {3,1}, {3,2}});
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        //initializeGraph(incLinkCounts, adjs, prerequisites);
        Map<Integer, ArrayList<Integer>> diagraph = initializeGraph(numCourses, prerequisites);
        //return new int[1]; //dfs(adjs);
        return bfs(diagraph);
    }

    private static int[] bfs(Map<Integer, ArrayList<Integer>> diagraph) {
        Map<Integer, Integer> indegrees = new HashMap<>();

        for (Integer node : diagraph.keySet()) {
            indegrees.put(node, 0);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : diagraph.entrySet()) {
            for (Integer neighbour : entry.getValue()) {
                indegrees.put(neighbour, indegrees.get(neighbour) + 1);
            }
        }

        Queue<Integer> tovisitQueue = new ArrayDeque<>();

        for (Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                tovisitQueue.add(entry.getKey());
            }
        }

        List<Integer> order = new ArrayList<>();

        while (! tovisitQueue.isEmpty()) {
            Integer fromNode = tovisitQueue.poll();
            order.add(fromNode);

            for (Integer toNode : diagraph.get(fromNode)) {
                indegrees.put(toNode, indegrees.get(toNode) - 1);
                if (indegrees.get(toNode) == 0) {
                    tovisitQueue.offer(toNode);
                }
            }
        }

        if (order.size() != diagraph.size()) {
            return new int[0];
        }

        return order.stream().mapToInt(i -> i).toArray();
    }

    private static Map<Integer, ArrayList<Integer>> initializeGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> diagraph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            diagraph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            diagraph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return diagraph;
    }

    /*private static void initializeGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
        int n  = incLinkCounts.length;

        while (n > 0) {
            adjs.add(new ArrayList<>());
            n--;
        }

        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }*/

}
