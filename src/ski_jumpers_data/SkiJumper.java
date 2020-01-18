package ski_jumpers_data;

import java.time.LocalDate;

public class SkiJumper {
	// model class

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
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public RepresentedCountry getCountry() {
		return country;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", reprezentujący: " + country
				+ ", urodzony: " + dateOfBirth + ", wzrost[cm]: " + height + ", waga[kg]: " + weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkiJumper other = (SkiJumper) obj;
		if (country != other.country)
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}