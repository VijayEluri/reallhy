import java.io.*;
import java.util.*;
public class DrawRect{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("2\n5 5\n5 7\n7 5\n30 20\n10 10\n10 20".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){			
			Coord c1 = new Coord(scanner.nextInt(), scanner.nextInt());
			Coord c2 = new Coord(scanner.nextInt(), scanner.nextInt());
			Coord c3 = new Coord(scanner.nextInt(), scanner.nextInt());
			
			Coord c4 = null;							
			Coord c4_1 = new Coord(c1.x - (c2.x - c3.x), c1.y - (c2.y - c3.y));
			if(distance(c4_1, c2) == distance(c1, c3)) c4 = c4_1;
			Coord c4_2 = new Coord(c2.x - (c3.x - c1.x), c2.y - (c3.y - c1.y));
			if(distance(c4_2, c3) == distance(c2, c1)) c4 = c4_2;
			Coord c4_3 = new Coord(c3.x - (c1.x - c2.x), c3.y - (c1.y - c2.y));
			if(distance(c4_3, c1) == distance(c3, c2)) c4 = c4_3;
			
			System.out.printf("%d %d\n", c4.x, c4.y);			
		}
	}
	static int distance(Coord from, Coord to){
		return (from.x - to.x) * (from.x - to.x) + (from.y - to.y) * (from.y - to.y);
	}
	static class Coord{
		int x;
		int y;
		Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}