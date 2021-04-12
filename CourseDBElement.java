package application;

public class CourseDBElement implements Comparable {

	private String courseID;
	private int crn;
	private int credit;
	private String roomNumber;
	private String instructorName;
	public CourseDBElement(String courseID, int crn, int credit, String roomNumber, String instructorName) {
		super();
		this.courseID = courseID;
		this.crn = crn;
		this.credit = credit;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}
	public CourseDBElement() {
		courseID = " ";
		roomNumber = " ";
		instructorName = " ";
		crn = 0;
		credit = 0;
		
	}
	public int hashCode() {
		return Integer.toString(crn).hashCode();
				
	}
	@Override
	public String toString() {
		return "courseID=" + courseID + ", crn=" + crn + ", credit=" + credit + ", roomNumber="
				+ roomNumber + ", instructorName=" + instructorName + "\n";
	}
	@Override
	public int compareTo(Object o) {
		CourseDBElement objectCrn;
		objectCrn = (CourseDBElement) o;
		return crn - objectCrn.crn ;
		
	}
	public int getCRN() {
		return crn;
	}
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	
}
