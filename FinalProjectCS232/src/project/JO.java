package project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Use Gson to serialize data to Json (processing objects to strings to save them in text files)
//can't save an object to a text file, need to convert objects to strings to save them - so used Json to be able to read data

public class JO {

	private static Gson getGson() { //Gson is an external component 
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); // used to create the Gson object (which does the conversion to Json) 
																				// not including anything without the @Expose marker
	}

	public static String toJson(Object o) { // converting object to a string in Json format
		return getGson().toJson(o); // return the string representation of the object
	}

	public static <T extends Object> T fromJson(String s, Class<T> targetClass) { //generic methods - converting string to an object, but you have to tell it what type of object 
																				//you want to convert it to without knowing what the object is
																				//<T extends Object> returning any type where that type is an object
		return getGson().fromJson(s, targetClass); 	
	}
}
