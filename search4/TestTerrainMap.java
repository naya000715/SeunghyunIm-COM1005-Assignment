
/**
  * TestTerrainMap.java
  *
  * Phil Green 2013 version
  * Heidi Christensen 2021 version
  * 
  * Example of how you load a terrain map
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestTerrainMap {

  /**
   * constructor, given a PGM image Reads a PGM file. The maximum greyscale value
   * is rescaled to be between 0 and 255.
   * 
   * @param filename
   * @return
   * @throws FileNotFoundException
   */

  public static void main(String[] arg) {

    TerrainMap tm = new TerrainMap("C:\\Users\\Sean\\eclipse-workspace\\COM1005_Assignment_2021_v2\\COM1005_Assignment_2021\\code\\search3/tmc.pgm");
    
    System.out.println(tm.getDepth());
    System.out.println(tm.getTmap()[10][15]);

    for(int i=0; i<tm.getTmap().length;i++)
    {
    	for(int j=0; j<tm.getTmap().length;j++)
    	{
    	System.out.print(tm.getTmap()[i][j]+ " ");
        }
    	System.out.println();
    }
  }
}
