import java.io.*;
import java.util.*;

public class Anagram {
    public static void main(String... args) throws Exception {
        //System.setIn(Anagram.class.getResourceAsStream("anagram.txt"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t ; i++){            
            if(isAnagram(scanner.next(), scanner.next())){
                System.out.println("Yes");
            } else System.out.println("No.");
        }
    }
    
    static boolean isAnagram(String str1, String str2){
        if(str1.equals(str2)) return false;
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < chr2.length; i++){
            if(map.get(chr2[i]) == null){
                map.put(chr2[i], 1);
            } else {
                map.put(chr2[i], map.get(chr2[i]) + 1);                
            }
        }
        //System.out.println(map);

        for(int j = 0; j < chr1.length; j++){
            if(map.get(chr1[j]) == null) return false;
            if(map.get(chr1[j]) == 1) map.remove(chr1[j]);
            else {
                map.put(chr1[j], map.get(chr1[j]) - 1);
            }
        }
        if(map.isEmpty()) return true;
        else return false;
    }
}
