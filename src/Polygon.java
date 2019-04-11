import java.util.List;

public class Polygon implements Visitable {
	
	private static Polygon instance = null;
	private List<Integer> x;
	private List<Integer> y;
	private int n;
	private int culoare1;
	private int culoare2;
	
	public Polygon(List<Integer> x, List<Integer> y, int n, int culoare1, int culoare2){
		this.x = x;
		this.y = y;
		this.n = n;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Polygon getInstance(List<Integer> x, List<Integer> y, int n, int culoare, int culoare2){
		  instance = new Polygon(x, y, n, culoare, culoare2);
	      return instance;
  }
	
	public List<Integer> getx(){
		   return x;
	}
	
	public List<Integer> gety(){
		   return y;
	}
	
	public int getn(){
		   return n;
	}
	
	public int getcolor1(){
		   return culoare1;
	}
	
	public int getcolor2(){
		   return culoare2;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);  
	}
}