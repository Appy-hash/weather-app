import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class NumberOfConnectedComponentsInGraph {

    static Set<Integer> visited;

    static  Set<Integer> visiting;
    public static int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> connectedNodes = new HashMap<>();
        visited = new HashSet<>();
        visiting = new HashSet<>();
        int connectedComponents = 0;
        List<Integer> connectedNodesList = null;
        for(int i = 0 ; i < edges.length; i++){


            if(!connectedNodes.containsKey(edges[i][0])){
                connectedNodesList = new ArrayList<>();
            }else{
                connectedNodesList = connectedNodes.get(edges[i][0]);
            }
            connectedNodesList.add(edges[i][1]);
            connectedNodes.put(edges[i][0], connectedNodesList);


            if(!connectedNodes.containsKey(edges[i][1])){
                connectedNodesList = new ArrayList<>();
            }else{
                connectedNodesList = connectedNodes.get(edges[i][1]);
            }
            connectedNodesList.add(edges[i][0]);
            connectedNodes.put(edges[i][1], connectedNodesList);



        }





        for(int i = 0 ; i < n ; i++){
            if(!visited.contains(i)){
               dfsInGraph(i, connectedNodes);
                   connectedComponents++;

            }

        }




        return connectedComponents;
    }


    private static void dfsInGraph(int currentNode, Map<Integer, List<Integer>> map){

        if(visited.contains(currentNode)){
            return;
        }
        if(!map.containsKey(currentNode)){
            visited.add(currentNode);
            return ;
        }
        List<Integer> connectedNodeList = map.get(currentNode);
        visited.add(currentNode);
        for (Integer node : connectedNodeList) {
            dfsInGraph(node, map);

        }


        }




    public static void main(String[] args){
        System.out.println(countComponents(3, new int[][]{{1,0}, {2,0}}));
        System.out.println(countComponents(3, new int[][]{{0,2}}));
        System.out.println(countComponents(2, new int[][]{{1,0}}));
        System.out.println(countComponents(5, new int[][]{{0,1},{1,2},
                {2,3},{3,4}}));
        System.out.println(countComponents(5, new int[][]{{0,1},{1,2},
                {3,4}}));
        System.out.println(countComponents(5, new int[][]{{0,1},{0,2},
                {2,3}, {3,4}}));
    }



}
