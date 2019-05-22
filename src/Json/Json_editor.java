package Json;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import Gladiators.Gladiator;
import Gladiators.Population;

import org.json.simple.parser.JSONParser;

public class Json_editor {
/**
 * Obtiene un String a partir de un objeto Json.
 * @param obj
 * @return String Json
 * @throws IOException
 */
	public String getString_json(JSONObject obj) throws IOException {
		
	      StringWriter out = new StringWriter();
	      obj.writeJSONString(out);
	      String s = out.toString();
		return s;
	}
	/**
	 * Crea un archivo .json en Disco, puede usarse para tener 
	 * un respaldo.
	 * @param s
	 * @throws FileNotFoundException
	 */
	public void create_file(String s) throws FileNotFoundException {
	    
		PrintWriter out2 = new PrintWriter("Population.json");
		out2.println(s);
		out2.close(); 
	}
	public JSONObject createJson(Population popu) throws IOException {
		Population pop = popu;		
		JSONObject obj = new JSONObject();
		JSONObject obj2 = new JSONObject();

		Gladiator glad;
		JSONArray asds = new JSONArray();

				
		for (int i = 0; i < pop.size(); i++) {
			JSONArray asd = new JSONArray();
			asd.clear();
			for (int j = 0; j < 9; j++) {
				asd.add(pop.get(i).getCromosome(j));

			}
			obj.put("ID"+i,asd);

		}

	    String jsonText = getString_json(obj);
	    create_file(jsonText);
	    return obj;

		
	}	
	public void readJson(JSONObject o) throws ParseException, IOException {
	      StringWriter out = new StringWriter();
	      o.writeJSONString(out);
	      String jsonText = out.toString();
	      jsonText = o.toJSONString();
		int[] arr= {0,0,0,0,0,0,0,0,0};
		JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonText);
        for (int i = 0; i < o.size(); i++) {
            JSONArray array = (JSONArray) o.get("ID"+i);
            for (int j = 0; j < array.size(); j++) {
            	arr[j]=(int) array.get(j);
            	System.out.println(array.get(j));
    		}
		}

}
	public JSONObject string_toJson(String s) throws ParseException {
		JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(s);
		return obj;
	}

}