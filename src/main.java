
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
		Json_editor JsonEditor = new Json_editor();

		System.out.println("Hello World!");
		
		gen.run(20);
//		Gladiator glad1 = new Gladiator(gen.createGen());
//		Gladiator glad2 = new Gladiator(gen.createGen());
//		Gladiator glad3 = new Gladiator(gen.createGen());
//
//
//		
//
//		Population<Gladiator> population = new Population<Gladiator>();
//		
//		for (int i = 0; i < 20; i++) {
//			Gladiator glad = new Gladiator(gen.createGen());
//			population.add(glad);
//			population.get(i).printCromosome();
//		}
//		
//		int count=0;
//		JSONObject json =JsonEditor.createJson(population);
//		//JsonEditor.readJson(json);
//
//		

		
		
		
	}
}

