package Json;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import Gladiators.Gladiator;
import Gladiators.Population;

import org.json.simple.parser.JSONParser;

public class Json_editor {

	public JSONObject createJson(Population popu) throws IOException {
		Population pop = popu;		
		JSONObject obj = new JSONObject();
		JSONObject obj2 = new JSONObject();

		int[] array = {1,2,3,4,5,6,0};
		Gladiator glad;
		JSONArray asds = new JSONArray();

				
		for (int i = 0; i < pop.size(); i++) {
			JSONArray asd = new JSONArray();
			asd.clear();
			for (int j = 0; j < 8; j++) {
				asd.add(pop.get(i).getCromosome(j));

			}
			obj.put("ID"+i,asd);

		}
	      StringWriter out = new StringWriter();
	      obj.writeJSONString(out);
	      
	    String jsonText = out.toString();
		PrintWriter out2 = new PrintWriter("Population.json");
		out2.println(jsonText);
		out2.close(); 
	    return obj;

		
	}	
	public void readJson(JSONObject o) throws ParseException, IOException {
	      StringWriter out = new StringWriter();
	      o.writeJSONString(out);
	      String jsonText = out.toString();
		int[] arr= {0,0,0,0,0,0,0,0,0};
		JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonText);
        for (int i = 0; i < o.size(); i++) {
            JSONArray array = (JSONArray) o.get("ID"+i);
            for (int j = 0; j < array.size(); j++) {
            	arr[j]=(int)array.get(j);
            	System.out.println(array.get(j));
    		}
		}
        

	         

}

}