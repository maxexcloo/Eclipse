package comp125;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentListTest {
	@Test
	// @Graded(description="test constructor", marks=2)
	public void testStudentList() {
		StudentList myList = new StudentList(3);
		Student student0 = new Student("Peterson", 66.0);
		Student student1 = new Student("Jones", 75.0);
		Student student2 = new Student("Adams", 71.5);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		assertTrue(myList.getAt(0).equals(student0));
		assertTrue(myList.getAt(1).equals(student1));
		assertTrue(myList.getAt(2).equals(student2));
	}
	
	@Test
	// @Graded(description="test average score", marks=2)
	public void testAverageScore() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("Morgan", 79.5);
		Student student1 = new Student("Peterson", 82.0);
		Student student2 = new Student("Adams", 45.0);
		Student student3 = new Student("Fenech", 35.5);
		Student student4 = new Student("Davidson", 65.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		assertEquals(61.4, myList.averageScore(), 0.01);
	}
	
	@Test
	// @Graded(description="test sort by name 1", marks=1)
	public void testSortByName1() {
		StudentList myList = new StudentList(3);
		Student student0 = new Student("Peterson", 66.0);
		Student student1 = new Student("Jones", 75.0);
		Student student2 = new Student("Adams", 72.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.sortByName();
		assertTrue(myList.getAt(0).equals(student2));
		assertTrue(myList.getAt(1).equals(student1));
		assertTrue(myList.getAt(2).equals(student0));
	}
	
	@Test
	// @Graded(description="test sort by name 2", marks=2)
	public void testSortByName2() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("Morgan", 79.5);
		Student student1 = new Student("Peterson", 82.0);
		Student student2 = new Student("Adams", 45.0);
		Student student3 = new Student("Dale", 35.5);
		Student student4 = new Student("Davidson", 65.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.sortByName();
		assertTrue(myList.getAt(0).equals(student2));
		assertTrue(myList.getAt(1).equals(student3));
		assertTrue(myList.getAt(2).equals(student4));
		assertTrue(myList.getAt(3).equals(student0));
		assertTrue(myList.getAt(4).equals(student1));
	}
	
	@Test
	// @Graded(description="test sort by name 3", marks=2)
	public void testSortByName3() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("MacDonald", 53.5);
		Student student1 = new Student("O'Sullivan", 39.0);
		Student student2 = new Student("Lane-Brown", 68.0);
		Student student3 = new Student("McMaster", 29.5);
		Student student4 = new Student("de Witt", 73.5);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.sortByName();
		assertTrue(myList.getAt(0).equals(student4));
		assertTrue(myList.getAt(1).equals(student2));
		assertTrue(myList.getAt(2).equals(student0));
		assertTrue(myList.getAt(3).equals(student3));
		assertTrue(myList.getAt(4).equals(student1));
	}
	
	@Test
	// @Graded(description="test retrieve score 1", marks=2)
	public void testRetrieveScore1() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("Adams", 45.0);
		Student student1 = new Student("Dale", 35.5);
		Student student2 = new Student("Davidson", 65.0);
		Student student3 = new Student("Morgan", 79.5);
		Student student4 = new Student("Peterson", 82.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		assertEquals(79.5, myList.retrieveScore("Morgan"), 0.01);
		assertEquals(82.0, myList.retrieveScore("Peterson"), 0.01);
		assertEquals(45.0, myList.retrieveScore("Adams"), 0.01);
		assertEquals(35.5, myList.retrieveScore("Dale"), 0.01);
		assertEquals(65.0, myList.retrieveScore("Davidson"), 0.01);
		assertEquals(-1.0, myList.retrieveScore("Fenech"), 0.01);
	}
	
	@Test
	// @Graded(description="test retrieve score 2", marks=2)
	public void testRetrieveScore2() {
		StudentList myList = new StudentList(6);
		Student student0 = new Student("de Witt", 73.5);
		Student student1 = new Student("Lane-Brown", 68.0);
		Student student2 = new Student("MacDonald", 53.5);
		Student student3 = new Student("McMaster", 29.5);
		Student student4 = new Student("O'Sullivan", 39.0);
		Student student5 = new Student("Zhou", 0.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.setAt(5, student5);
		assertEquals(53.5, myList.retrieveScore("MacDonald"), 0.01);
		assertEquals(39.0, myList.retrieveScore("O'Sullivan"), 0.01);
		assertEquals(68.0, myList.retrieveScore("Lane-Brown"), 0.01);
		assertEquals(29.5, myList.retrieveScore("McMaster"), 0.01);
		assertEquals(73.5, myList.retrieveScore("de Witt"), 0.01);
		assertEquals(0.0,  myList.retrieveScore("Zhou"), 0.01);
		assertEquals(-1.0, myList.retrieveScore("Fenech"), 0.01);
	}
	
	@Test
	// @Graded(description="test merit sort 1", marks=1)
	public void testMeritSort1() {
		StudentList myList = new StudentList(3);
		Student student0 = new Student("Peterson", 66.0);
		Student student1 = new Student("Jones", 75.0);
		Student student2 = new Student("Adams", 72.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.meritSort();
		assertTrue(myList.getAt(0).equals(student1));
		assertTrue(myList.getAt(1).equals(student2));
		assertTrue(myList.getAt(2).equals(student0));
	}
	@Test
	// @Graded(description="test merit sort 2", marks=2)
	public void testMeritSort2() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("Morgan", 79.5);
		Student student1 = new Student("Peterson", 82.0);
		Student student2 = new Student("Adams", 45.0);
		Student student3 = new Student("Dale", 35.5);
		Student student4 = new Student("Davidson", 65.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.meritSort();
		assertTrue(myList.getAt(0).equals(student1));
		assertTrue(myList.getAt(1).equals(student0));
		assertTrue(myList.getAt(2).equals(student4));
		assertTrue(myList.getAt(3).equals(student2));
		assertTrue(myList.getAt(4).equals(student3));
	}
	
	@Test
	// @Graded(description="test merit sort 3", marks=2)
	public void testMeritSort3() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("MacDonald", 63.5);
		Student student1 = new Student("O'Sullivan", 49.0);
		Student student2 = new Student("Lane-Brown", 68.0);
		Student student3 = new Student("McMaster", 96.5);
		Student student4 = new Student("de Witt", 73.5);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.meritSort();
		assertTrue(myList.getAt(0).equals(student3));
		assertTrue(myList.getAt(1).equals(student4));
		assertTrue(myList.getAt(2).equals(student2));
		assertTrue(myList.getAt(3).equals(student0));
		assertTrue(myList.getAt(4).equals(student1));
	}
	
	@Test
	// @Graded(description="test sort by name BIS 1", marks=1)
	public void testSortByNameBIS1() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("Morgan", 79.5);
		Student student1 = new Student("Peterson", 82.0);
		Student student2 = new Student("Adams", 45.0);
		Student student3 = new Student("Dale", 35.5);
		Student student4 = new Student("Davidson", 65.0);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.sortByNameBIS();
		assertTrue(myList.getAt(0).equals(student2));
		assertTrue(myList.getAt(1).equals(student3));
		assertTrue(myList.getAt(2).equals(student4));
		assertTrue(myList.getAt(3).equals(student0));
		assertTrue(myList.getAt(4).equals(student1));
	}
	
	@Test
	// @Graded(description="test sort by name BIS 2", marks=1)
	public void testSortByNameBIS2() {
		StudentList myList = new StudentList(5);
		Student student0 = new Student("MacDonald", 53.5);
		Student student1 = new Student("O'Sullivan", 39.0);
		Student student2 = new Student("Lane-Brown", 68.0);
		Student student3 = new Student("McMaster", 29.5);
		Student student4 = new Student("de Witt", 73.5);
		myList.setAt(0, student0);
		myList.setAt(1, student1);
		myList.setAt(2, student2);
		myList.setAt(3, student3);
		myList.setAt(4, student4);
		myList.sortByNameBIS();
		assertTrue(myList.getAt(0).equals(student4));
		assertTrue(myList.getAt(1).equals(student2));
		assertTrue(myList.getAt(2).equals(student0));
		assertTrue(myList.getAt(3).equals(student3));
		assertTrue(myList.getAt(4).equals(student1));
	}
}
