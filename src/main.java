
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Gladiators.*;
import Json.*;

public class main {
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Genetic gen = new Genetic();
		Json_editor json = new Json_editor();

		System.out.println("Server On!");
		
		gen.run(45);	

		
	}
}

