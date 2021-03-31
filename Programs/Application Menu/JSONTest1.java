import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.util.Map;
import java.util.Iterator;

import java.io.FileReader;

public class JSONTest1 {

	public static void main(String[] args) throws Exception {
		//Paring file "sample.json"
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\lizar\\Desktop\\leoLinuxApps.json"));
		
		//Typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;
		
		//Mapping/Getting All Section Information 
		Map infoGather = ((Map)jo.get("Information_Gathering"));
		Map digitalForensics = ((Map)jo.get("Digital_Forensics"));
		Map passwordCrack = ((Map)jo.get("Password_Cracking"));
		Map vulAnalysis = ((Map)jo.get("Vulnerability_Analysis"));
		Map wirelessAttack = ((Map)jo.get("Wireless_Attacks"));
		Map other = ((Map)jo.get("OTHER"));
		
		String Keys[] = new String[12];
		String Values[] = new String[36];
		
		int Kcounter = 0;
		int Vcounter = 0;
		
		// Information Gathering Section
		Iterator<Map.Entry>itr1 = infoGather.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
			
			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}
						
		}

		// Digital Forensics Section
		Iterator<Map.Entry>itr2 = digitalForensics.entrySet().iterator();
		while (itr2.hasNext()) {
			Map.Entry pair = itr2.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());

			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}
		}
		
		// Password Cracking Section
		Iterator<Map.Entry>itr3 = passwordCrack.entrySet().iterator();
		while (itr3.hasNext()) {
			Map.Entry pair = itr3.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());

			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}
		}
		
		// Vulnerability Analysis Section
		Iterator<Map.Entry>itr4 = vulAnalysis.entrySet().iterator();
		while (itr4.hasNext()) {
			Map.Entry pair =itr4.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());

			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}
		}
		
		// Wireless Attacks Section
		Iterator<Map.Entry>itr5 = wirelessAttack.entrySet().iterator();
		while (itr5.hasNext()) {
			Map.Entry pair = itr5.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());

			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}
		}
		
		// Other Section
		Iterator<Map.Entry>itr6 = other.entrySet().iterator();
		while (itr6.hasNext()) {
			Map.Entry pair = itr6.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());

			String key = pair.getKey().toString();
			String values[] = new String[3];
			values = pair.getValue().toString().split(",");
			if(Keys[Kcounter] == null) {
				Keys[Kcounter] = key;
				for(int e = 0; e < values.length; e++) {
					Values[Vcounter] = values[e];
					Vcounter++;
				}
				Kcounter++;
			}			
		}
		
		//Keys Array:
		System.out.println("");
		for(int e = 0; e < Keys.length; e++) {
			System.out.println(Keys[e]);
		}
		
		//Values Array:
		System.out.println("");
		for(int e = 0; e < Values.length; e++) {
			System.out.println(Values[e]);
		}
		
	}

}
