class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);
            for(int neighbour : graph.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        if(result.size() == numCourses){
            int[] arr = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                arr[i] = result.get(i);
            }
            return arr;
        }
        else{
            return new int[0];
        }
    }
}