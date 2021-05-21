import java.util.ArrayList;
public class RamblersState extends SearchState {
	/**
	 *	State in a map search
	 *	Version for A*
	 *	changes indicated by //A*
	 * Phil Green	2013 version
	 * Heidi Christensen (heidi.christensen@sheffield.ac.uk) 2021 version
	*/

	
	 // coordinate for this state
	  private Coords x; // max x dimension
	  // constructor
	  

	  public RamblersState(Coords coordx, int lc, int est) {
	    x = coordx;
	    localCost = lc;
	    estRemCost = est;
	    //localCost = lc;
	   
	  }
	  

	  // accessor  		  
	  public Coords getX() {
		  return x;
		  
	  };
	  
	  // goalPredicate
	  public boolean goalPredicate(Search searcher) {
		    RamblersSearch rsearcher = (RamblersSearch) searcher;
		    Coords tarx = rsearcher.getX();
		    return (x.getx() == tarx.getx() && x.gety()==tarx.gety());
		  }

	  // getSuccessors
	  public ArrayList<SearchState> getSuccessors(Search searcher) {
		  RamblersSearch msearcher = (RamblersSearch) searcher;
		    TerrainMap map = msearcher.getMap();
		    localCost = 0;
		    ArrayList<SearchState> succs = new ArrayList<SearchState>();
		    //Y
		    Coords c = new Coords(x.gety(),x.getx());
		    int currentStateY = c.gety(); 
		    int currentStateX= c.getx();
		    int arrC = map.getTmap()[currentStateY][currentStateX];
		    
		    //Y
		    //Up
		    if(currentStateY != 0)
		    {
		    	currentStateY = currentStateY - 1;
		    	currentStateX = c.getx();
		    	estRemCost = Math.abs(currentStateX-currentStateY)+Math.abs(msearcher.getX().getx()-msearcher.getX().gety());
			    int arrN = map.getTmap()[currentStateY][currentStateX];
		    	if(arrN<=arrC)
			    {
		    		localCost = 1;
				}
		    	else
		    	{
		    		localCost = 1+(arrN - arrC);
		    		
			    }
		    	succs.add((SearchState) new RamblersState(new Coords(currentStateY,currentStateX),localCost,estRemCost));
		    }
		    //Down
		    if(currentStateY <  map.getDepth()-1 )
		    {
		    	currentStateY = currentStateY + 1;
		    	currentStateX = c.getx();
		    	estRemCost = Math.abs(currentStateX-currentStateY)+Math.abs(msearcher.getX().getx()-msearcher.getX().gety());
			    int arrN = map.getTmap()[currentStateY][currentStateX];
		    	if(arrN<=arrC)
			    {
		    		localCost = 1;
		    		}
		    	else
		    	{
		    		localCost = 1+(arrN - arrC);
		    		}
		    	succs.add((SearchState) new RamblersState(new Coords(currentStateY,currentStateX),localCost,estRemCost));
				
		    }
		     //X
		    //Left
		    if(currentStateX !=0)
		    {
		    	currentStateX = currentStateX - 1;
		    	currentStateY = c.gety();
		    	estRemCost = Math.abs(currentStateX-currentStateY)+Math.abs(msearcher.getX().getx()-msearcher.getX().gety());
			    int arrN = map.getTmap()[currentStateY][currentStateX];
		    	if(arrN<=arrC) 
		    	{
		    		localCost = 1;
		    	    }
		    	else
		    	{
		    		localCost = 1+(arrN - arrC);
	    		    }
		    	succs.add((SearchState) new RamblersState(new Coords(currentStateY,currentStateX),localCost,estRemCost));
		    	
		    }
		    //Right
		    if(currentStateX < map.getWidth()-1)
		    {
		    	currentStateX = currentStateX + 1;
		    	currentStateY = c.gety(); 
		    	estRemCost = Math.abs(currentStateX-currentStateY)+Math.abs(msearcher.getX().getx()-msearcher.getX().gety());
			    int arrN = map.getTmap()[currentStateY][currentStateX];
		    	if(arrN<=arrC) 
		    	{
		    		localCost = 1;
		    	    }
		    	else
		    	{
		    		localCost = 1+(arrN - arrC);
	    		    }
		    	succs.add((SearchState) new RamblersState(new Coords(currentStateY,currentStateX),localCost,estRemCost));
		    	
		    }
		    return succs;
		  }

	  // sameState

	  public boolean sameState(SearchState s2) {
		    RamblersState ms2 = (RamblersState) s2;
		    Coords c1 = ms2.getX();
		    return (c1.getx()==x.getx() && c1.gety() == x.gety());
		  }

	  // toString
	  public String toString() {
	    return ("Map State: " + x.getx()+", "+x.gety());
	  }
}
