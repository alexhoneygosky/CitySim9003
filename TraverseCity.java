import java.util.*;
import java.text.*;

public class TraverseCity {
    String startLoc;
    int cupsOfCoffee;
    List<String> _locations;
    List<Roads> allRoads;
    Random _seed;

    public TraverseCity(String start, List<String> locations, List<Roads> roads, Random seed) {
        startLoc = start;
        _locations = locations;
        allRoads = roads;
        _seed = seed;
    }

    public String getStartLocation() {
        int loc = _seed.nextInt(_locations.size());

        return _locations.get(loc);
    }

    public int getNumberOfLocations() {
        return _locations.size();
    }

    public int getNumberOfRoads() {
        return allRoads.size();
    }

    public int getCupsOfCoffee() {
        return cupsOfCoffee;
    }

    public List<Roads> getPossibleNextDestinations(String location) {
        List<Roads> possibleRoutes = new ArrayList<Roads>();

        for(Roads r : allRoads) {
            if(r.getStartLocation() == location) {
                possibleRoutes.add(r);
            }
        }

        return possibleRoutes;
    }

    public Roads route() {
        List<Roads> possibleRoutes = getPossibleNextDestinations(startLoc);

        if(startLoc == "Coffee") {
            cupsOfCoffee++;
        }

        int nextRoadInd = _seed.nextInt(possibleRoutes.size());
        Roads roadChosen = possibleRoutes.get(nextRoadInd);
        startLoc = roadChosen.getEndLocation();
        
        return roadChosen;
    }
}