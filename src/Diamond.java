
public class Diamond implements Visitable {
	
	private static Diamond instance = null;
	private int x;
	private int y;
	private int orizontala;
	private int verticala;
	private int culoare1;
	private int culoare2;
	
	public Diamond(int x, int y, int orizontala, int verticala, int culoare1, int culoare2){
		this.x = x;
		this.y = y;
		this.orizontala = orizontala;
		this.verticala = verticala;
		this.culoare1 = culoare1;
		this.culoare2 = culoare2;
	}
	
	public static Diamond getInstance(int x, int y, int orizontala, int verticala, int culoare1, int culoare2){
		  instance = new Diamond(x, y, orizontala, verticala, culoare1, culoare2);
	      return instance;
  }
	
	public int getx(){
		   return x;
	}
	
	public int gety(){
		   return y;
	}
	
	public int getorizontala(){
		   return orizontala;
	}
	
	public int getverticala(){
		   return verticala;
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