import java.util.*;

public class KClosestPointsToOrigin {



    public static int[][] kClosest(int[][] points, int k) {
        if(points.length == 1 && k == 1){
            return points;
        }

        TreeMap<Double, List<Points>> distanceMap = new TreeMap<>();
        List<Points> coordinate;

        for (int[] point : points) {
            double sqrt = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));

            if (!distanceMap.containsKey(sqrt)) {
                coordinate = new ArrayList<>();
                coordinate.add(new Points(point[0], point[1]));
                distanceMap.put(sqrt, coordinate);
            } else {
                coordinate = distanceMap.get(sqrt);
                coordinate.add(new Points(point[0], point[1]));
            }
        }

        int[][] closestPoints = new int[k][2];
        int i = 0;
        for(Map.Entry<Double, List<Points>> entry: distanceMap.entrySet()){
            List<Points> list = entry.getValue();
            for(Points point: list){
                closestPoints[i][0] = point.x;
                closestPoints[i][1] = point.y;
                i++;

                if(i == k){
                    return closestPoints;
                }
            }



        }


        return null;

    }


    public static void main(String[] args){
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{3,3}, {5,-1}, {2,-4}}, 2)));

    }
}


class Points{
    int x;
    int y;
    Points(int x, int y){
        this.x = x; this.y = y;
    }
}
