
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
	static Json_editor js = new Json_editor();
	
	static void funcionPost() throws IOException {
		//Si se necesita enviar un string se usa:
		String s= gen.getPopuJson().toString();
		
		
		System.out.println(s);
	}
	void populations() throws IOException, ParseException {
		gen.run(100);
	}
	
	static String return_glad() throws IOException {
		JSONObject jobj = js.createJson(gen.popu);
		String json = js.getString_json(jobj);
		System.out.println(json);
		return json;
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
	    long start = System.currentTimeMillis();
		System.out.println("Server On!");
		gen.run(100);
	    long end = System.currentTimeMillis();
	    float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
	    //funcionPost();
	    js.create_file(return_glad());

	}


}

