import java.util.*;

public class AncestorsOfNodeInDAG {

    static Map<Integer, Set<Integer>> ancestors;
    static Set<Integer> visited;

    public static  List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyMatrix = new HashMap();
        ancestors = new HashMap<>();
        for(int[] edge: edges){
            List<Integer> edgeList = adjacencyMatrix.getOrDefault(edge[0], new ArrayList<>());
            edgeList.add(edge[1]);
            adjacencyMatrix.put(edge[0], edgeList);
        }

        visited  = new HashSet<>();
        for(int i = 0 ; i < n ;i++){
                if(!visited.contains(i)){
                    dfs(i, adjacencyMatrix, new ArrayList<>());
                }
        }


        List<List<Integer>> ancestorList = new ArrayList<>();


        for(int i = 0 ; i < n ;i++){
            if(ancestors.containsKey(i)){
                ancestorList.add(new ArrayList<>(ancestors.get(i)));
            }else{
                ancestorList.add(new ArrayList<>());
            }
        }
        return ancestorList;
    }


    private static void dfs(int startNode, Map<Integer, List<Integer>> adjacencyMatrix, List<Integer> path){
       Set<Integer> ancestorList = ancestors.getOrDefault(startNode, new HashSet<>());
       if(path.size() > 0){
           ancestorList.addAll(path);
       }

       ancestors.put(startNode, ancestorList);
       List<Integer> pathList = new ArrayList<>(path);
       pathList.add(startNode);
       if(adjacencyMatrix.containsKey(startNode)){
           for(Integer node: adjacencyMatrix.get(startNode)){
               dfs(node, adjacencyMatrix, pathList);
           }
       }

    }

        public static void main(String[] args) {
            System.out.println(getAncestors(8,
                    new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }

}
