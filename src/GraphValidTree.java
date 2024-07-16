import java.util.*;

public class GraphValidTree {

    private static Set<Integer> visited;

    public static boolean validTree(int n, int[][] edges) {
        if(n== 1){
            return true;
        }
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        visited = new HashSet<>();
        for(int i = 0 ; i < edges.length ; i++){
            List<Integer> edgeList = edgeMap.getOrDefault(edges[i][0], new ArrayList<>());
            edgeList.add(edges[i][1]);
            edgeMap.put(edges[i][0], edgeList);

            edgeList = edgeMap.getOrDefault(edges[i][1], new ArrayList<>());
            edgeList.add(edges[i][0]);
            edgeMap.put(edges[i][1], edgeList);
        }

        if(dfs(0,-1,edgeMap) && visited.size() == n-1){
            return true;
        }
        return false;





    }

    private static boolean dfs(int currNode, int parentNode, Map<Integer, List<Integer>> map){
        boolean result = true;
        if(map.containsKey(currNode)){
            List<Integer> edgeList = map.get(currNode);
            for(int edge : edgeList){
                if(edge == parentNode){
                    continue;
                }

                if(visited.contains(edge)){
                    return false;
                }else{
                    visited.add(edge);
                }
                result = result && dfs(edge,currNode,map);
            }
        }
        return result;
    }


    public static void main(String[] args){
        System.out.println(validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
    }
}
