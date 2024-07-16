import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatchUnit {



    public static  int getTripCount(List<Event> input, String start, String end){
        Map<Integer, String> locationMap = new HashMap<>();
        int tripCount = 0;
        for(Event event: input){
            if(locationMap.containsKey(event.unitId)){
                if(locationMap.get(event.unitId).equals(start) && event.location.equals(end)){
                    tripCount++;
                }
            }
            locationMap.put(event.unitId, event.location);
        }
        return tripCount;

    }

    public static void main(String[] args) {
        List<Event> input = new ArrayList<>();
        input.add(new Event(1, "Everett"));
        input.add(new Event(2, "Seattle"));
        input.add(new Event(1, "Bellevue"));
        input.add(new Event(3, "Everett"));
        input.add(new Event(2, "Silver Firs"));
        input.add(new Event(3, "Everett"));
        System.out.println(getTripCount(input, "Everett", "Bellevue"));
        System.out.println(getTripCount(input, "Seattle", "Silver Firs"));
    }
}


class Event{

    int unitId;
    String location;

    public Event(int unitId, String location){
        this.unitId = unitId;
        this.location = location;
    }
}
