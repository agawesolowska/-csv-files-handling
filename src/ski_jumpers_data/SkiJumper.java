package ski_jumpers_data;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Model class of ski jumpers.
 * 
 * @author Aga
 *
 */
@Getter
@EqualsAndHashCode
public class SkiJumper {

	private String firstName, lastName;
	private RepresentedCountry country;
	private LocalDate dateOfBirth;
	private Integer height, weight;

	public SkiJumper() {

	}

	public SkiJumper(String firstName, String lastName, RepresentedCountry country, LocalDate dateOfBirth,
			Integer height, Integer weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", reprezentujący: " + country + ", urodzony: " + dateOfBirth
				+ ", wzrost[cm]: " + height + ", waga[kg]: " + weight;
	}

}