
/**
 * CourseDBStructure Implements the CourseDBStructureInterface
 * @author Equara Khan
 **/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * 
 * @author Equara Khan
 *
 */
 class CourseDBStructure implements CourseDBStructureInterface {

	private int size;
	LinkedList<CourseDBElement>[] hashTable;
	/**
	 * Default Constructor
	 */
	public CourseDBStructure() {
		size=15;
		hashTable = new LinkedList[size]; 
	}
	/**
	 * Constructor
	 * @param name
	 * @param size
	 */
	public CourseDBStructure(String name, int size) {
		this.size=size;
		hashTable = new LinkedList[size];
	}

	public CourseDBStructure(int size) {
		this.size=size;
		hashTable = new LinkedList[size];
	}
	
	/**
	 * @param element -  a CDE
	 */
	@Override
	public void add(CourseDBElement element) {
		int whatever = element.hashCode()%this.getTableSize();
		if (hashTable[whatever] == null) {
			hashTable[whatever] = new LinkedList<CourseDBElement>();
			hashTable[whatever].add(element);
		}
		else{
			Iterator<CourseDBElement> ptr = hashTable[whatever].iterator();
			while(ptr.hasNext()){
				CourseDBElement current = ptr.next();
				if (current.getCRN() == element.getCRN()){
						hashTable[whatever].remove(current);
						break;
				}

			}
			hashTable[whatever].add(element);
		}
		
	}
	/**
	 * @param crn
	 * @return CourseDBElement
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		CourseDBElement temp = new CourseDBElement();
		temp.setCRN(crn);
		
		
			if (hashTable[temp.hashCode()%this.getTableSize()]==null)
				throw new IOException();
			else {
				for (int i=0;i<hashTable[temp.hashCode()%this.getTableSize()].size();i++) {
					if (hashTable[temp.hashCode()%this.getTableSize()].get(i).getCRN()==crn)
						return hashTable[temp.hashCode()%this.getTableSize()].get(i);
					
				}
			}
		
		return null;
	}

	/**
	 *@return TableSize
	 */
	@Override
	public int getTableSize() {
		return this.size;
		
	}
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		//return null;
		ArrayList<String> anything = new ArrayList<>();
		for (int i=0; i < hashTable.length; i++) {
			if (hashTable[i] == null) {
				continue;
			}
			LinkedList <CourseDBElement> collection = hashTable[i];
			
			Iterator<CourseDBElement> something = collection.iterator();
			
			while (something.hasNext () ) {
				CourseDBElement Matter = something.next(); 		
				
				String organize = "Course:" + Matter.getID() +
								  " CRN:"   + Integer.toString (Matter.getCRN()) +
								  " Credits:"+ Integer.toString(Matter.getCredits()) +
								  " Room:"   + Matter.getRoomNum () +
								  " Instructor:" + Matter.getInstructor ();

								  anything.add(organize);
				}
			}
		return anything;
	}

}