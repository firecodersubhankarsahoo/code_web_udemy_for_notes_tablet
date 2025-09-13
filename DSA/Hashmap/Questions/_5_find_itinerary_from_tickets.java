package Questions;

import java.util.*;

public class _5_find_itinerary_from_tickets {
    public static String findStartingPoint(HashMap<String,String>map){
        HashMap<String,String>rmap=new HashMap<>();
        for(String x: map.keySet()){
            rmap.put(map.get(x),x);
        }
        for(String key:map.keySet()){
            if(!rmap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

//--------------or-----------or---------------or----------------or------------or---------
//    public static String findStartingPoint(HashMap<String, String> map) {
//        HashSet<String> destinations = new HashSet<>(map.values());
//        for (String city : map.keySet()) {
//            if (!destinations.contains(city)) {
//                return city;
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String ,String> ticket=new HashMap<>();
        ticket.put("Chennai","Banglore");
        ticket.put("Bombay","Delhi");
        ticket.put("Goa","Chennai");
        ticket.put("Delhi","Goa");

        String start=findStartingPoint(ticket);
        System.out.print(start+"--->>>");
        for(String key:ticket.keySet()){
            System.out.print(ticket.get(start)+"--->>>");
            start=ticket.get(start);
        }
    }
}
