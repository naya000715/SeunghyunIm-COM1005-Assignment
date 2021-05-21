public class RunRamblersAstart {
	public static void main(String[] arg) {

	    TerrainMap map1 = new TerrainMap("C:\\\\Users\\\\Sean\\\\eclipse-workspace\\\\COM1005_Assignment_2021_v2\\\\COM1005_Assignment_2021\\\\code\\\\search3/diablo.pgm");
	    // System.out.println(map1.toString());
	    // System.out.println(map1.getLinks("Start"));

	    //goal (x,y)
	    
	    RamblersSearch searcher = new RamblersSearch(map1, new Coords(9,9));
	    //start (x,y)
	    Coords c = new Coords(13,12);
	    SearchState initState = (SearchState) new RamblersState(c,0,0);
	    

	    // change from search1 - specify strategy
	    // String res_df = searcher.runSearch(initState, "breadthFirst");
	    // System.out.println(res_df);
	    // String res_bf = searcher.runSearch(initState, "depthFirst");
	    // System.out.println(res_bf);

	    String res_bb = searcher.runSearch(initState, "Astar");
	    System.out.println(res_bb);
	  }
}
