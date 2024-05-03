import java.util.*;

public class Amazon {

    public static void main(String args[]){
        Integer arr[] = {3, 2, 2, 2, 3, 4};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(amz(list, 2));
    }

    public static List<Integer> amz(List<Integer> days, int k){

        List<Integer> res = new ArrayList<>();
        Map<Integer, Boolean> leftDays = new HashMap<>();
        Map<Integer, Boolean> rightDays = new HashMap<>();
        int count =0;
        for(int i=0 ;i < days.size(); i++){

            if(k ==1){
                if(i - 1 >= 0){
                    if(days.get(i-1) >= days.get(i)){
                        leftDays.put(i, true);
                    }
                }
            }else {
                if (count == k) {
                    leftDays.put(i, true);
                    count--;
                }

                if (i == 0) {
                    count++;
                    continue;
                }
                if (i - 1 >= 0) {
                    if (days.get(i - 1) >= days.get(i)) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
            }
        }


        count = 0;
        for(int i = days.size()-1; i>= 0;i--){
            if(k ==1){
                if(i - 1 >= 0){
                    if(days.get(i-1) >= days.get(i)){
                       rightDays.put(i, true);
                    }
                }
            }else {
                if (count == k) {
                    rightDays.put(i, true);
                    count--;
                }
                if (i == days.size() - 1) {
                    count++;
                    continue;
                }
                if (i + 1 <= days.size() - 1) {
                    if (days.get(i + 1) >= days.get(i)) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
            }
        }

        for(Map.Entry<Integer, Boolean> entry: rightDays.entrySet()){
            if(leftDays.containsKey(entry.getKey()) && leftDays.get(entry.getKey()) && entry.getValue()){
                res.add(entry.getKey());
            }
        }

        Collections.sort(res);
        return res;
    }
}
