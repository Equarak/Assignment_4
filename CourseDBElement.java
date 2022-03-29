/**
 * This program creates a database of courses
 * It will read from a file of courses,
 * or allow the user to add a course
 * @author Equara Khan
 *
 * */

/**
 * CourseDBElement implements Comparable
 * @param <T>
 * @author Equara Khan
 * */
public class CourseDBElement implements Comparable {

	String cid="";
	public String getID() {
		return cid;
	}
	public void setID(String cid) {
		this.cid = cid;
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getRoomNum() {
		return roomNumber;
	}
	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	int crn;
	int credits;
	String roomNumber="";
	String instructor="";
	/**
	 * Constructor
	 * @param cid
	 * @param crn
	 * @param credits
	 * @param roomNumber
	 * @param instructor
	 */
	public CourseDBElement(String cid, int crn, int credits,String roomNumber, String instructor) {
		this.cid=cid;
		this.crn=crn;
		this.credits=credits;
		this.roomNumber=roomNumber;
		this.instructor=instructor;
	}
	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		this("",0,0,"","");
	}

	@Override
	public int compareTo(CourseDBElement element) {
	
		return this.crn-element.crn;
	}
	/**
	 * hashcode of crn
	 */
	@Override
	public int hashCode(){
		String tempString = Integer.toString(this.crn); // turns crn to string, 
		int hash = tempString.hashCode(); //takes hashcode of tempstring and 
		
		
		return hash;
	}
	/**sets crn
	 * 
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn=crn;	
	}
	/**
	 * 
	 * @return crn
	 */
	public int getCRN() {
		return this.crn;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Course:"+cid+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructor+" Room:"+roomNumber;
	}
	
	
 }