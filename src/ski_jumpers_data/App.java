package ski_jumpers_data;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO 
		
		File file = new File("zawodnicy.csv");
		List<SkiJumper> skiJumperList = CsvFileHandling.loadData(file);
		
		System.out.println("Najstarszy skoczek to: " + CsvFileHandling.getOldest(skiJumperList));
		System.out.println("Najmłodszy skoczek to: " + CsvFileHandling.getYoungest(skiJumperList));
		System.out.println("Najwyższy skoczek to: " + CsvFileHandling.getHighest(skiJumperList));
		System.out.println("Najniższy skoczek to: " + CsvFileHandling.getLowest(skiJumperList));
		System.out.println("Najcieższy skoczek to: " + CsvFileHandling.getHeaviest(skiJumperList));
		System.out.println("Najlżejszy skoczek to: " + CsvFileHandling.getLightest(skiJumperList));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nSprawdzmy łączną wage reprezentantów wybranego przez Ciebie kraju.");
		System.out.println("Wpisz do konsoli skrót z poniższej listy:");
		System.out.println("AUT - Austria , FIN - Finlandia, GER - Niemcy, NOR - Norwegia, POL - Polska, USA - Stany Zjednoczone");
		
		RepresentedCountry country = RepresentedCountry.valueOf(sc.nextLine());
		System.out.println("Skoczkowie ważą łącznie: " + CsvFileHandling.totalWeightOfRepresentatives(skiJumperList, country) + " kg.\n");
		
		System.out.println("");
		System.out.println(CsvFileHandling.howManyRepresentatives(skiJumperList));
		
		
		sc.close();
	}

}
