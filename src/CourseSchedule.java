import java.net.Inet4Address;
import java.util.*;

public class CourseSchedule {

    static  Set<Integer> finished;
    static  Set<Integer> processing;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses == 1 && prerequisites.length == 0){
            return true;
        }

        if(prerequisites != null){
            List<Integer> dependency;
            finished = new HashSet<>();
                processing = new HashSet<>();
            Map<Integer, List<Integer>> courseDependencyMap = new HashMap<>();

            for (int[] prerequisite : prerequisites) {
                if (!courseDependencyMap.containsKey(prerequisite[0])) {
                    dependency = new ArrayList<>();
                } else {
                    dependency = courseDependencyMap.get(prerequisite[0]);
                }
                dependency.add(prerequisite[1]);
                courseDependencyMap.put(prerequisite[0], dependency);
            }

            for(int i = 0 ; i < numCourses; i++){
                checkIfCourseCanBeFinished(courseDependencyMap, i);
            }






        }
        return finished.size() == numCourses;


    }

    private static  boolean checkIfCourseCanBeFinished(Map<Integer, List<Integer>>
                                                               courseDependencyMap,
                                                       int course){
        if(finished.contains(course)){
            return true;
        }

        if(!courseDependencyMap.containsKey(course)){
            finished.add(course);
            return true;
        }

        boolean completed = false;
        if(!processing.contains(course)){
            List<Integer> preReqs = courseDependencyMap.get(course);
            processing.add(course);
            for(int curr: preReqs){
                if(processing.contains(curr)){
                    return false;
                }else{
                    completed = checkIfCourseCanBeFinished(courseDependencyMap,curr);
                }

            }
            if(completed){
                finished.add(course);
                processing.remove(course);
                return true;
            }


        }
        return false;
    }



    public static void main(String[] args){
        System.out.println(canFinish(4,new int[][]{{0,1},{1,2},{0,3},{3,0}}));
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(canFinish(2, new int[][]{{1,0}}));
        System.out.println(canFinish(2, new int[][]{{0,1}}));


        System.out.println(canFinish(4,new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}}));
        System.out.println(canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));

        System.out.println(canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(canFinish(4, new int[][]{{1,0},{2,1},{3,2}}));
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));


    }
}
