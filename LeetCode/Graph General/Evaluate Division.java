import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++){
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            
            graph.get(A).put(B, val);
            graph.get(B).put(A, 1.0 / val);
        }

        double[] result = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++){
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            
            if(!graph.containsKey(C) || !graph.containsKey(D)){
                result[i] = -1.0;
            }
            else if(C.equals(D)){
                result[i] = 1.0;
            }
            else{
                HashSet<String> visited = new HashSet<>();
                result[i] = dfs(graph, C, D, 1.0, visited);
            }
        }
        return result;
    }
    public double dfs(HashMap<String, HashMap<String, Double>> graph,
                      String curr, String target,
                      double product, HashSet<String> visited){
        
        if(curr.equals(target)) return product;
        visited.add(curr);
        
        for(String neighbor : graph.get(curr).keySet()){
            if(!visited.contains(neighbor)){
                
                double weight = graph.get(curr).get(neighbor);
                double result = dfs(graph, neighbor, target, product * weight, visited);
                
                if(result != -1.0){
                    return result;
                }
            }
        }
        return -1.0;
    }
}