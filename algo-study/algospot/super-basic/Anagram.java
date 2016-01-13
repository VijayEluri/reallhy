import java.io.*;
import java.util.*;
public class Anagram{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("4\nweird weird\nweird wired\napple angle\napple elppa".getBytes());		
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			Map<Character, Integer> count = new HashMap<Character, Integer>();
			String first = scanner.next();
			String second = scanner.next();
			
			boolean matched = true;
			if(first.equals(second)) matched = false;
			else{
				for(char c : first.toCharArray()){
					if(count.get(c) == null){
						count.put(c, 1);
					} else{
						count.put(c, count.get(c) + 1);
					}
				}
				
				for(char c : second.toCharArray()){
					if(count.get(c) == null){
						matched = false;
						break;
					} else{
						count.put(c, count.get(c) - 1);
						if(count.get(c) == 0) count.remove(c);
					}
				}
				if(count.size() != 0) matched = false;
			}
			System.out.println(matched? "Yes" : "No.");
		}
	}
}