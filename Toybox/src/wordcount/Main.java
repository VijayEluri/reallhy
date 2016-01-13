package wordcount;

import java.util.Scanner;

public class Main {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        char[] line = scanner.nextLine().trim().toCharArray();
        int words = 0;
        char previous;
        for(int i = 0; i < line.length - 2; i++){
            previous = line[i];
            if(line[i + 1] == ' ' && previous != ' ') words++;
        }
        if(words > 0) words++;
        System.out.println(words);
    }
}
