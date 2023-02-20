package org.experis2.lambdas;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Comparator, Anonymous class
 * Functional interfaces
 * Function (map), Predicate (filter, anyMatch, allMatch), Consumer (forEach), Comparator (sorted)
 * Stream
 * Concurrency
 * 
 * https://www.digitalocean.com/community/tutorials/java-8-functional-interfaces
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * https://www.oracle.com/webfolder/technetwork/tutorials/moocjdk8/documents/week1/lesson-1-3.pdf
 */
public class StudentMain {
	private static final long SEED = 12345;
	
	public static void main(String[] args) {
		StudentGenerator gen = new StudentGenerator(SEED);
		
		List<Student> students = gen.generate(10);
		// Sorting con classe anonima
//		Collections.sort(students, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return Float.compare(o2.getAverageScore(), o1.getAverageScore());
//			}
//		});
		
		// Sorting equivalente con lambda
//		Collections.sort(students, (o1, o2) -> {
//			return Float.compare(o2.getAverageScore(), o1.getAverageScore());
//		});
		
		// Stream con filter: filtrare tutti gli studenti il cui
		// nome proprio inizia con la A
		// (argomenti) -> { corpo della funzione}
//		students.stream()
//				.filter(s -> s.getFirstName().startsWith("A"))
//				.forEach(s -> System.out.println(s));
		
		// Equivalente senza lambda
//		for (Student s : students) {
//			if (s.getFirstName().startsWith("A")) {
//				System.out.println(s);
//			}
//		}
		
		// Collect dei risultati in una lista
//		List<Student> studentiConA =
//			students.stream()
//				.filter(s -> s.getFirstName().startsWith("A"))
//				.collect(Collectors.toList());
//		studentiConA.forEach(s -> System.out.println(s));
		
		// anyMatch/allMatch
//		boolean isPresentAny = students.stream().anyMatch(s -> s.getAverageScore() > 25);
//		boolean isAll = students.stream().allMatch(s -> s.getAverageScore() > 25);
		
		// Equivalente anyMatch senza lambda
//		boolean isFound = false;
//		for (Student s : students) {
//			if (s.getAverageScore() > 25) {
//				isFound = true;
//			}
//		}

		// count studenti con media > 25
		long countConA = students.stream()
			.filter(s -> s.getAverageScore() > 25)
			.count();
		
		// map
//		List<String> collect = students.stream().map(s -> {
//			return s.getFirstName().toUpperCase() + " " + s.getCityOfBirth();
//		}).collect(Collectors.toList());
//		collect.add("ASD");
//		System.out.println(collect);
		
		
		List<Student> studentiOrdinati = students.stream().sorted((o1, o2) -> {
			return Float.compare(o2.getAverageScore(), o1.getAverageScore());
		}).collect(Collectors.toList());
		
		// Stampare gli studenti nati a Roma con la media minore di 20
		List<Student> risultato = students.stream().filter(s -> {
			return s.getAverageScore() < 25 && s.getCityOfBirth().equals("Bangkok");
		}).collect(Collectors.toList());
		
		
		Map<Integer, Student> studentsById = 
			students.stream().collect(Collectors.toMap(s -> s.getId(), s -> s));
		
		String collect = students.stream().map(s -> s.getFirstName() + " " + s.getLastName())
			.collect(Collectors.joining(", "));
//		System.out.println(collect);
		
		// Problema con modifica variabili all'interno delle lambda
		AtomicInteger i = new AtomicInteger(0);
		students.forEach(s -> {
			System.out.println(i + "\t" + s);
//			i.getAndIncrement()  // -> i++
//			i.incrementAndGet()  // -> ++i
			i.incrementAndGet();
		});
		
//		for (int i = 0; i < students.size(); i++) {
//			Student student = students.get(i);
//			System.out.println(i + "\t" + student);
//		}
	}
}
