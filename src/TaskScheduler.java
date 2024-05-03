import java.util.*;

public class TaskScheduler {



    public static  int leastInterval(char[] tasks, int n) {

        if(tasks.length == 1 && n == 1){
            return 1;
        }

        int minTime = 0;

//        TreeMap<Character, Task> taskMap = new TreeMap<>(new Comparator< Task>() {
//
//
//
//            @Override
//            public int compare(Task o1, Task o2) {
//                return 0;
//            }
//
//        });
        Map<Character, Task> taskMap = new HashMap<>();
        Task curr = null;
        for(char task: tasks){
            if(!taskMap.containsKey(task)){
                curr = new Task(1);
            }else{
                curr = taskMap.get(task);
                curr.frequency = curr.frequency +1;

            }
            taskMap.put(task, curr);
        }

        int currentTime = 0;



        while(taskMap.size() > 0){
            Set<Character> keys = taskMap.keySet();
            List<Character> taskList = new ArrayList<>();
            taskList.addAll(keys);

            int i = 0;

            while(i < taskList.size()){
                char c = taskList.get(i);
                int lastExecutedTime = taskMap.get(c).lastExecutedTime;
                if(lastExecutedTime == - 1 || currentTime - lastExecutedTime > n ){
                    Task task = taskMap.get(c);
                    task.frequency = task.frequency -1;
                    task.lastExecutedTime = currentTime;


                    if(task.frequency == 0){
                        taskMap.remove(c);
                    }else{
                        taskMap.put(c, task);
                    }
                    i++;

                }

                currentTime++;
            }

        }

        return currentTime;
    }

    public static void main(String[] args){
//        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
//        System.out.println(leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
//        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
        System.out.println(leastInterval(new char[]{'A','A','A',
                'A','A','A','B','C','D', 'E', 'F', 'G'}, 1));

    }
}


class Task{

    int frequency;

    int lastExecutedTime;



    public Task(int frequency){
        this.frequency = frequency;
        this.lastExecutedTime = -1;

    }
}
