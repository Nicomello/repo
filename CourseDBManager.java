package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure courseDBS = new CourseDBStructure(7);

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement courseManage = new CourseDBElement(id, crn, credits, roomNum, instructor);
		courseDBS.add(courseManage);
		
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
		
			return courseDBS.get(crn);
		
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner sc = new Scanner(input);
		String insert;
		
		String[] courses;
		while(sc.hasNextLine()) {
			insert = sc.nextLine();
			courses = insert.split(" ", 5);
			int parseCrn = Integer.parseInt(courses[1]);
			int parseCredit = Integer.parseInt(courses[2]);
			add(courses[0], parseCrn, parseCredit, courses[3], courses[4]);
			
			
		}
			
		
		
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i < courseDBS.hashTable.length; i++ ) {
			while(courseDBS.hashTable[i] != null) {
				
			
			for(int e =0; e < courseDBS.hashTable[i].size(); e++) {
				array.add(courseDBS.hashTable[i].get(e).toString());
			}
			break;
			}
		}
			
		return array;
	}

}
