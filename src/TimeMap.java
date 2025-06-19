import java.util.*;

class TimeMap {

    Map<String , Map<Integer, String>> timeBasedCache;
    ;

    public TimeMap() {
        timeBasedCache = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(timeBasedCache.containsKey(key)){
            Map<Integer, String>  timeCache = timeBasedCache.get(key);
            timeCache.put(timestamp, value);
            timeBasedCache.put(key, timeCache);
        }else{
            Map<Integer, String> timeCache = new TreeMap<>(Collections.reverseOrder());

            timeCache.put(timestamp,value);
            timeBasedCache.put(key, timeCache);
        }
    }

    public String get(String key, int timestamp) {
        if(timeBasedCache.containsKey(key)){
            Map<Integer, String> timeCache = timeBasedCache.get(key);
            if(timeCache.containsKey(timestamp)){
                return timeCache.get(timestamp);
            }else{
                int maxKey = -1 ;
                for(Map.Entry<Integer, String> entry: timeCache.entrySet()){
                    if(entry.getKey() <= timestamp ){
                        maxKey = Math.max(maxKey, entry.getKey());
                    }
                }
                return maxKey >= 0 ? timeCache.get(maxKey) : "";
            }
        }else{
            return "";
        }
    }
}

///**
// * Your TimeMap object will be instantiated and called as such:
// * TimeMap obj = new TimeMap();
// * obj.set(key,value,timestamp);
// * String param_2 = obj.get(key,timestamp);
// */

