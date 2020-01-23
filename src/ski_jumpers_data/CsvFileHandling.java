package ski_jumpers_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class for CSV file handling.
 * 
 * @author Aga
 *
 */
public class CsvFileHandling {

	/**
	 * This method loads data from CSV file and adds ski jumpers to a list.
	 */
	public static List<SkiJumper> loadData(File file) {
		List<SkiJumper> skiJumpersList = new ArrayList<>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] chunks = line.split(";", 6);
				RepresentedCountry country = RepresentedCountry.valueOf(chunks[2]);
				LocalDate dateOfBirth = LocalDate.parse(chunks[3]);
				Integer height = Integer.parseInt(chunks[4]);
				Integer weight = Integer.parseInt(chunks[5]);

				SkiJumper skiJumper = new SkiJumper(chunks[0], chunks[1], country, dateOfBirth, height, weight);
				skiJumpersList.add(skiJumper);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return skiJumpersList;
	}

	public static Optional<SkiJumper> getOldest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().min(Comparator.comparing(SkiJumper::getDateOfBirth));
	}

	public static Optional<SkiJumper> getYoungest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().max(Comparator.comparing(SkiJumper::getDateOfBirth));
	}

	public static SkiJumper getHighest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().max((j1, j2) -> j1.getHeight() - j2.getHeight()).get();
	}

	public static SkiJumper getLowest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().min((j1, j2) -> j1.getHeight() - j2.getHeight()).get();
	}

	public static SkiJumper getHeaviest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().max((j1, j2) -> j1.getWeight() - j2.getWeight()).get();
	}

	public static SkiJumper getLightest(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().min((j1, j2) -> j1.getWeight() - j2.getWeight()).get();
	}

	public static int totalWeightOfRepresentatives(List<SkiJumper> skiJumpersList, RepresentedCountry country) {
		int totalWeight = 0;
		for (SkiJumper skiJumper : skiJumpersList) {
			if (country.equals(skiJumper.getCountry())) {
				totalWeight += skiJumper.getWeight();
			}
		}
		return totalWeight;
	}

	public static Map<RepresentedCountry, Long> howManyRepresentatives(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream().collect(Collectors.groupingBy(SkiJumper::getCountry, Collectors.counting()));
	}

	public static Map<RepresentedCountry, Double> averageHeightOfRepresentatives(List<SkiJumper> skiJumpersList) {
		return skiJumpersList.stream()
				.collect(Collectors.groupingBy(SkiJumper::getCountry, Collectors.averagingInt(SkiJumper::getHeight)));
	}
}
