package application;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


public class CourseDBStructure implements CourseDBStructureInterface {
	LinkedList[] hashTable;
	private int hashSize;

	public CourseDBStructure(int hashSize)
	{
		
		this.hashSize = hashSize;
		hashTable = new LinkedList[hashSize];
		
	}

	public CourseDBStructure(String testing, int hashSize) {
		
		this.hashSize = hashSize;
		hashTable = new LinkedList[hashSize];
		
	}

	@Override
	public void add(CourseDBElement element) {
	
		 int index = Math.abs(element.hashCode()) % hashSize;
		 
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<CourseDBElement>();}
		hashTable[index].add(element);
	
		}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement itDBE2 = null;
		int crnHashcode = Integer.toString(crn).hashCode();
		int indexCrn = Math.abs(crnHashcode) % hashSize;
		Iterator it = hashTable[indexCrn].iterator();
		if(hashTable[indexCrn] == null )
			throw new IOException();
		else 
			while(it.hasNext()) {
				CourseDBElement itDBE = (CourseDBElement) it.next();
				if (itDBE.getCRN() == crn) {
					itDBE2 = itDBE;
				}
				
			}
		return itDBE2;
	}

	@Override
	public int getTableSize() {
	
		return hashSize;
	}
	
	
	

}
