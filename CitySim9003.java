import java.util.*;
import java.text.*;

public class CitySim9003 {
    public static void main(String [] args) {               
        int randomSeed = 0;
        
        try {
            randomSeed = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.print("Please enter a valid integer seed");
            System.exit(1);
        }

        List<Roads> roads = new ArrayList<Roads>();

        roads.add(new Roads("Fourth Ave.", "Hotel", "Diner"));
        roads.add(new Roads("Fourth Ave.", "Diner", "Outside City"));
        roads.add(new Roads("Fifth Ave.", "Coffee", "Library"));
        roads.add(new Roads("Fifth Ave.", "Library", "Outside City"));
        roads.add(new Roads("Bill St.", "Library", "Hotel"));
        roads.add(new Roads("Bill St.", "Hotel", "Library"));
        roads.add(new Roads("Phil St.", "Coffee", "Diner"));
        roads.add(new Roads("Phil St.", "Diner", "Coffee"));

        List<String> locations = new ArrayList<String>();

        locations.add("Coffee");
        locations.add("Diner");
        locations.add("Hotel");
        locations.add("Library");
        locations.add("Outside City");        

        Random seed = new Random(randomSeed);    

        Roads roadReturned;

        for(int i = 1; i < 6; i++) {
            String startLocation = locations.get(seed.nextInt(locations.size()-1));  
            TraverseCity tc = new TraverseCity(startLocation, locations, roads, seed);

            do {
            roadReturned = tc.route();
            System.out.printf("Driver %d heading from %s to %s via %s\n", i, roadReturned.getStartLocation(), roadReturned.getEndLocation(), roadReturned.getStreet());
            } while(roadReturned.getEndLocation() != "Outside City");
            
            if(roadReturned.getStreet() == "Fourth Ave.") {
                System.out.printf("Driver %d went to Philedelphia!\n", i);
            }
            
            else {
                System.out.printf("Driver %d went to Cleveland!\n", i);
            }

            System.out.printf("Driver %d got %d cup(s) of coffee.\n", i, tc.getCupsOfCoffee());
            System.out.println("----------------");
        }
    }
}