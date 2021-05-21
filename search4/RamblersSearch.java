public class RamblersSearch extends Search{
	 private TerrainMap tMap;
	 private Coords x;

	 public TerrainMap getMap() {
		 return tMap;
	 }
	 
	 public Coords getX() {
		 return x;
	 }
	 
	 public RamblersSearch(TerrainMap t, Coords xc) {
		 tMap = t;
		 x = xc;
	 }
}
