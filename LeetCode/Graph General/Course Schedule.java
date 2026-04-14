import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(hasCycle(graph, state, i)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int[] state, int node){
        
        if(state[node] == 1) return true;   
        if(state[node] == 2) return false;  
        
        state[node] = 1;
        
        for(int neighbor : graph.get(node)){
            if(hasCycle(graph, state, neighbor)){
                return true;
            }
        }
        
        state[node] = 2;
        return false;
    }
}