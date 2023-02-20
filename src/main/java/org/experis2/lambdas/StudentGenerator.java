package org.experis2.lambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Generator for a list of random students 
 */
public class StudentGenerator {
	private String[] firstNames = {
		"Leonardo", "Sofia", "Alessandro", "Aurora", "Tommaso", 
		"Giulia", "Francesco", "Ginevra", "Lorenzo", "Beatrice",
		"Edoardo", "Alice", "Mattia", "Vittoria", "Riccardo", 
		"Emma", "Gabriele", "Ludovica", "Andrea", "Matilde",
		"Diego", "Giorgia", "Matteo", "Camilla", "Nicolo'",
		"Chiara", "Giuseppe", "Anna", "Antonio", "Bianca",
		"Federico", "Nicole", "Pietro", "Gaia", "Samuele",
		"Martina", "Giovanni", "Greta"
	};
	
	private String[] lastNames = {
		"Rossi",  "Russo", "Ferrari", "Esposito", "Bianchi",
		"Romano", "Colombo", "Ricci", "Marino", "Greco",
		"Bruno", "Gallo", "Conti", "De Luca", "Mancini",
		"Costa", "Giordano", "Rizzo", "Lombardi", "Moretti"
	};
	
	private String[] nationalities = {
		"Italiana", "Francese", "Spagnola", "Tedesca", "Americana",
		"Cinese", "Portoghese", "Inglese", "Danese", "Polacca",
		"Ceca", "Russa", "Thailandese", "Armena", "Georgiana",
		"Giapponese", "Slovacca", "Albanese", "Greca", "Bulgara"
	};
	
	private String[] cities = {
		"Roma", "Parigi", "Milano", "Saragoza", "Barcellona", "Berlino",
		"Praga", "New York", "Lisbona", "Londra", "Copenaghen", "Varsavia",
		"Cracovia", "Boston", "Mosca", "Detroit", "Tokyo", "Bangkok", "Tbilisi",
		"Tirana", "Atene", "Sofia", "Napoli", "Perugia", "Palermo", "Venezia",
		"Lione", "Madrid", "Hong Kong"
	};

	private Random random;
	
	/**
	 * Initializes a student generator without providing a seed
	 */
	public StudentGenerator() {
		random = new Random();
	}
	
	/**
	 * Initializes a student generator with the given seed to allow
	 * deterministic results.
	 * @param seed	the seed for the Random object
	 */
	public StudentGenerator(long seed) {
		random = new Random(seed);
	}
	
	/**
	 * Generate a list of random students
	 * @param num	the numbers of students to generate
	 * @return	a list with randomly generated students
	 */
	public List<Student> generate(int num) {
		List<Student> result = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Student s = new Student();
			s.setId(random.nextInt(999999999));
			s.setFirstName(sample(firstNames, 1).get(0));
			s.setLastName(
				String.join(" ", sample(lastNames, random.nextFloat() < 0.2 ? 2 : 1))
			);
			s.setDateOfBirth(
				LocalDate.of(1982 + random.nextInt(20), 1 + random.nextInt(12), 1 + random.nextInt(28))
			);
			s.setCityOfBirth(sample(cities, 1).get(0));
			
			s.setNationalities(new HashSet<>(sample(nationalities, random.nextFloat() < 0.2 ? 2 : 1)));
			
			s.setNumExams(random.nextInt(16));
			s.setAverageScore(18 + random.nextFloat() * 10);
			result.add(s);
		}
		
		return result;
	}
	
	private List<String> sample(String[] arr, int n) {
		List<String> l = Arrays.asList(arr);
		Collections.shuffle(l, random);
		return new ArrayList<>(l.subList(0, n));
	}
	
	
}
