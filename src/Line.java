
public class Line implements Visitable {
	
	private static Line instance = null;
	private int xstart;
	private int ystart;
	private int xfinal;
	private int yfinal;
	private int culoare;
	
	public Line(int xstart, int ystart, int xfinal, int yfinal, int culoare){
		this.xstart = xstart;
		this.ystart = ystart;
		this.xfinal = xfinal;
		this.yfinal = yfinal;
		this.culoare = culoare;
	}
	
	public static Line getInstance(int xstart, int ystart, int xfinal, int yfinal, int culoare){
		  instance = new Line(xstart, ystart, xfinal, yfinal, culoare);
	      return instance;
    }
	
	public int getxstart(){
		   return xstart;
	}
	
	public int getystart(){
		   return ystart;
	}
	
	public int getxfinal(){
		   return xfinal;
	}
	
	public int getyfinal(){
		   return yfinal;
	}
	
	public int getcolor(){
		   return culoare;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}