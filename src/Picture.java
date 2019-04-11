
public class Picture implements Visitable {
	
	private static Picture instance = null;
	
	public static Picture getInstance(){
		  instance = new Picture();
	      return instance;
    }

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
