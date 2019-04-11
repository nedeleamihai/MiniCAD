
public class Paint implements Visitable {
	
	private static Paint instance = null;
	private int x;
	private int y;
	private int culoare;
	
	public Paint(int x, int y, int culoare){
		this.x = x;
		this.y = y;
		this.culoare = culoare;
	}
	
	public static Paint getInstance(int x, int y, int culoare){
		  instance = new Paint(x, y, culoare);
	      return instance;
  }
	
	public int getx(){
		   return x;
	}
	
	public int gety(){
		   return y;
	}
	
	public int getcolor(){
		   return culoare;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);  
	}
}
