import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String argv[]){
		ShapeFactory shapefactory = new ShapeFactory();
		Visitor desen = null;
		   
		   try{
			   BufferedReader br = new BufferedReader(new FileReader("BobaFett.in"));  	   
			   String[] Strings = br.readLine().split(" ");
               int n = Integer.parseInt(Strings[0]);            
               
               for(int i = 0; i < n; i++){
            	   Strings = br.readLine().split(" ");    	  
            	   Visitable shape = shapefactory.getShape(Strings);
            	   
            	   if(Strings[0].startsWith("CANVAS")){
            		 desen = new Desen(Integer.parseInt(Strings[1]), Integer.parseInt(Strings[2]));
            	   }
            	   
            	   shape.accept(desen);
               }
               
               Picture.getInstance().accept(desen);  
			   br.close();
			   
		   }catch (IOException e) {
               e.printStackTrace();
           }
		   
	}
}