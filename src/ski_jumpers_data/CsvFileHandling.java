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

public class CsvFileHandling {
	// utility class

	public static List<SkiJumper> loadData(File file) {
		List<SkiJumper> skiJumperList = new ArrayList<>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] chunks = line.split(";", 6);
				RepresentedCountry country = RepresentedCountry.valueOf(chunks[2]);
				LocalDate dateOfBirth = LocalDate.parse(chunks[3]);
				Integer height = Integer.parseInt(chunks[4]);
				Integer weight = Integer.parseInt(chunks[5]);

				SkiJumper skiJumper = new SkiJumper(chunks[0], chunks[1], country, dateOfBirth, height, weight);
				skiJumperList.add(skiJumper);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return skiJumperList;
	}

	public static Optional<SkiJumper> getOldest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.min(Comparator.comparing(SkiJumper::getDateOfBirth));
	}

	public static Optional<SkiJumper> getYoungest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.max(Comparator.comparing(SkiJumper::getDateOfBirth));
	}

	public static SkiJumper getHighest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.max((j1, j2) -> j1.getHeight() - j2.getHeight()).get();
	}

	public static SkiJumper getLowest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.min((j1, j2) -> j1.getHeight() - j2.getHeight()).get();
	}

	public static SkiJumper getHeaviest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.max((j1, j2) -> j1.getWeight() - j2.getWeight()).get();
	}

	public static SkiJumper getLightest(List<SkiJumper> skiJumperList) {
		return skiJumperList.stream()
				.min((j1, j2) -> j1.getWeight() - j2.getWeight()).get();
	}
	
	public static int totalWeightOfRepresentatives(List<SkiJumper> skiJumperList, RepresentedCountry country) {
		int totalWeight = 0;
		for (SkiJumper skiJumper : skiJumperList) {
			if (country.equals(skiJumper.getCountry())) {
				totalWeight += skiJumper.getWeight();
			}
		}
		return totalWeight;
	}
	
	public static Map<RepresentedCountry, Long> howManyRepresentatives(List<SkiJumper> skiJumperList){
		return skiJumperList.stream()
				.collect(Collectors.groupingBy(SkiJumper::getCountry,
						Collectors.counting()));
	}
	
}
