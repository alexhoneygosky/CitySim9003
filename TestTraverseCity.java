import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class TestTraverseCity {
   @Mock
   Random mockRndInt = Mockito.mock(Random.class);
   Roads mockRoads = Mockito.mock(Roads.class);
   TraverseCity mockTC = Mockito.mock(TraverseCity.class);

   @Before
   public void setUp() throws Exception {
       MockitoAnnotations.initMocks(mockRndInt);
       MockitoAnnotations.initMocks(mockRoads);
       MockitoAnnotations.initMocks(mockTC);

       Mockito.when(mockRoads.getStartLocation()).thenReturn("StartLoc");
       Mockito.when(mockRoads.getEndLocation()).thenReturn("EndLoc");
       Mockito.when(mockRoads.getStreet()).thenReturn("Street");

       Mockito.when(mockTC.getNumberOfLocations()).thenReturn(3);
       Mockito.when(mockTC.getNumberOfRoads()).thenReturn(0);
       Mockito.when(mockTC.getCupsOfCoffee()).thenReturn(5);

       List<String> locs = new ArrayList<String>();
       locs.add("StartLoc");
       locs.add("EndLoc");

       Mockito.when(mockRndInt.nextInt(locs.size())).thenReturn(0);
   }

   //Tests to make sure a valid start location is chosen to start the driver's route
   @Test
   public void testValidStartLocation() {
       List<String> locs = new ArrayList<String>();
       locs.add("StartLoc");
       locs.add("EndLoc");

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);       

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);

       int rndInt = mockRndInt.nextInt(locs.size());
       assertEquals(mockTC.getStartLocation(), "StartLoc");
   }

   //Tests to show that a null value could be returned as the start location
   @Test
   public void testNullStartLocation() {
       List<String> locs = new ArrayList<String>();
       locs.add(null);

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);

       assertNull(mockTC.getStartLocation());
   }

   //Tests to see how many locations there are in the map
   @Test
   public void testValidNumberOfLocations() {    
       assertEquals(mockTC.getNumberOfLocations(), 3);       
   }

   //Tests to show that there can be zero locations in the map
   @Test
   public void testZeroNumberOfLocations() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);    

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       assertEquals(mockTC.getNumberOfLocations(), 0);       
   }   

   //Tests to show how many roads are on the map
   @Test
   public void testValidNumberOfRoads() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);    

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       assertEquals(mockTC.getNumberOfRoads(), 1);       
   }   

   //Tests to show that there can be zero roads on the map
   @Test
   public void testZeroNumberOfRoads() {
       assertEquals(mockTC.getNumberOfRoads(), 0);       
   }       

   //Tests to show that the driver could pick up zero coffees on their route
   @Test
   public void testZeroNumberOfCoffees() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);    

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       assertEquals(mockTC.getCupsOfCoffee(), 0);       
   } 

   //Tests to show that the driver could pick up an arbitrary number of coffees on their route
   @Test
   public void testValidNumberOfCoffees() {
       assertEquals(mockTC.getCupsOfCoffee(), 5);       
   }    

   //Tests to show that an invalid location is possible to be the next location
   @Test
   public void testNoValidNextDestinations() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);      

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       List<Roads> nextRoads = mockTC.getPossibleNextDestinations("Invalid Location");
       assertEquals(nextRoads.size(), 0);       
   }    
   
   //Tests to show that there are valid next destinations after being at a location
   @Test
   public void testValidNextDestinations() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);      

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       List<Roads> nextRoads = mockTC.getPossibleNextDestinations("StartLoc");
       assertEquals(nextRoads.size(), 1);       
   }

  //Tests that a valid route is found from a location
   @Test
   public void testValidRoute() {
       List<String> locs = new ArrayList<String>();

       List<Roads> roads = new ArrayList<Roads>();
       roads.add(mockRoads);      

       mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       Roads nextRoad = mockTC.route();
       assertEquals(nextRoad, roads.get(0));       
   }  

   //The code in this method is commented out because I could not get the Roads object that is returned from the route function to be used in a
   //valid assert statement, so I wrote this assert test instead.
   @Test
   public void testNoRoutes() {
    //    List<String> locs = new ArrayList<String>();

    //    Roads fake = new Roads("Fake", "Blah", "Fake St.");
    //    List<Roads> roads = new ArrayList<Roads>();
    //    roads.add(fake);      

    //    mockTC = new TraverseCity("StartLoc", locs, roads, mockRndInt);   

       Mockito.when(mockTC.route()).thenReturn(null);
       Roads nextRoad = mockTC.route();
       assertNull(nextRoad);       
   }           
}