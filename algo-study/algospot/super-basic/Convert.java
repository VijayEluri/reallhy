import java.io.*;
import java.util.*;
public class Convert{
	public static void main(String... args){
		// InputStream is = System.in;
		InputStream is = new ByteArrayInputStream("5\n1 kg\n2 l\n7 lb\n3.5 g\n0 l".getBytes());
		Scanner scanner = new Scanner(is);
		int n = scanner.nextInt();
		for(int i = 0; i < n; i++){
			double k = scanner.nextDouble();
			String unit = scanner.next();
			String res = convert(k, unit);
			System.out.printf("%d %s\n", i + 1, res);
		}
	}
	static String convert(double k, String unit){
		double converted = 0;
		String convertedUnit = null;
		switch(unit){
			case "kg": converted = k * 2.2046; convertedUnit = "lb"; break;
			case "g": converted = k * 3.7854; convertedUnit = "l"; break;
			case "lb": converted = k * 0.4536; convertedUnit = "kg"; break;
			case "l": converted = k * 0.2642; convertedUnit = "g"; break;
		}
		return String.format("%.4f ", converted) + convertedUnit;
	}
}