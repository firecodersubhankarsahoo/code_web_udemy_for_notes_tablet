package Questions;

import java.util.*;


public class _5_find_itinerary_from_tickets {

    // Function to find the starting city of the itinerary
    public static String findStartingPoint(HashMap<String, String> map) {
        // Collect all destination cities into a HashSet
        HashSet<String> destinations = new HashSet<>(map.values());

        // The starting city will be the one that is present as a source (key)
        // but is not present as a destination
        for (String city : map.keySet()) {
            if (!destinations.contains(city)) {
                return city;  // return the starting point
            }
        }
        return null; // if not found (edge case)
    }

    public static void main(String[] args) {
        // Tickets are stored as: source → destination
        HashMap<String, String> ticket = new HashMap<>();
        ticket.put("Chennai", "Banglore");
        ticket.put("Bombay", "Delhi");
        ticket.put("Goa", "Chennai");
        ticket.put("Delhi", "Goa");

        // Find starting point of the journey
        String start = findStartingPoint(ticket);

        // Traverse the itinerary step by step until no next city is found
        while (start != null) {
            System.out.print(start); // print current city

            if (ticket.containsKey(start)) {
                // If there is a next city, print arrow and move forward
                System.out.print(" ---> ");
                start = ticket.get(start);
            } else {
                // No next city (end of journey)
                start = null;
            }
        }
    }
}

// ans----            Bombay ---> Delhi ---> Goa ---> Chennai ---> Banglore




//   or-------------------or-------------------------or---------------------------or------------------------or--------------------or-----------------or



/*


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


 */