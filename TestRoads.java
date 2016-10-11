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


public class TestRoads {
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

       List<String> locs = new ArrayList<String>();
       locs.add("StartLoc");
       locs.add("EndLoc");

       Mockito.when(mockRndInt.nextInt(locs.size())).thenReturn(0);
   }

   //Tests to show that the starting location can be retrieved
   @Test
   public void testGetValidStartLocation() {
       assertEquals(mockRoads.getStartLocation(), "StartLoc");
   }

   //Tests to show that the end location can be retrieved
   @Test
   public void testGetValidEndLocation() {
       assertEquals(mockRoads.getEndLocation(), "EndLoc");
   } 

   //Tests to show that the current street can be retrieved
   @Test
   public void testGetValidStreetName() {
       assertEquals(mockRoads.getStreet(), "Street");
   }                  
}