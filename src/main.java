
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Gladiators.*;
import Json.*;

public class main {
	static Genetic gen = new Genetic();
	static void funcionPost() throws IOException {
		//Si se necesita enviar un string se usa:
		String s= gen.getPopuJson().toString();
		
		
		System.out.println(s);
	}
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
	    long start = System.currentTimeMillis();
		System.out.println("Server On!");
		gen.run(100);
	    long end = System.currentTimeMillis();
	    float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
	    funcionPost();

	}


}

