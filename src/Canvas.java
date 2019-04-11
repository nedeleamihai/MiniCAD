
public class Canvas implements Visitable {
	
	private static Canvas instance = null;
	private int inaltime;
	private int latime;
	private int culoare;
	
	public Canvas(int inaltime, int latime, int culoare){
		this.inaltime = inaltime;
		this.latime = latime;
		this.culoare = culoare;
	}
	
	public static Canvas getInstance(int inaltime, int latime, int culoare){
		  instance = new Canvas(inaltime,latime,culoare);
	      return instance;
    }
	
	public int getinaltime(){
		   return inaltime;
	}
	
	public int getlatime(){
		   return latime;
	}
	
	public int getcolor(){
		   return culoare;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}