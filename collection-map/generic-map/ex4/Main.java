import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String arr[]= {"gfg",  "code",    "quiz",   "program", 
                "code", "website", "quiz",   "gfg", 
                "java", "gfg",     "program" }; 

		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])){
				int count = map.get(arr[i]);
				map.put(arr[i],count+1);
			}
			else {
				map.put(arr[i],i);
			}
		}
		System.out.println(map.get("gfg"));
		System.out.println(map.get("code"));
	}
}

