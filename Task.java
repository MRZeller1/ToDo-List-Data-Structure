import java.util.*;
/**
 * This `Task` class represents a task with a description, due date, 
 * and completion status. 
 * Please implement the provided methods and add appropriate comments for each method.
 * Analysis:
 * the Task Object is a simple object with a description, dueDate, and decription, with getters, setters and a 
 * overrided toString method and compareTo method.
 * another piece of data we could add is priorty of the task so the task can be order by post imortant to least important and have
 * getters and setters to access and modifiy this aswell.
 */

class Task implements Comparable<String>{
	private String description;
	private String dueDate;
	private boolean completed;
    private String type;

    public Task() {
        this.description = "";
        this.dueDate = "";
        this.completed = false;
	}
	/* 
	 * Default constructor
	 */
	public Task(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
	}

	/* 
	 * Write appropriate comment:
     * returns the description of a given task
	 */	
    public String getDescription() {
        //Write your code here
        return this.description;
	}
	
	/* 
	 * Write appropriate comment:
     * Returns the Due date for a specific task
	 */
    public String getDueDate() {
        //Write your code here
        return this.dueDate;
	}

	/* 
	 * Write appropriate comment:
     * returns the class completion status
	 */
	public boolean isCompleted() {
        //Write your code here
        return this.completed;
	}

	/* 
	 * Write appropriate comment:
     * sets the the tasks completion status to true.
	 */
	public void markCompleted() {
                this.completed = true;
    }

	/*
	 * This method overrides the `equals` method from the `Object` class. 
	 * It checks if two tasks are equal by comparing their description, due date, and completion status.
	 */
    public int parseDueDate(){
        String[] dateArray = this.getDueDate().split("-");
        String year = dateArray[0];
        String month = dateArray[1];
        String day = dateArray[2];
        String date = year + month + day;
        return Integer.parseInt(date);
    }
	@Override
	public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else if(!(obj instanceof Task)){
            return false;
        }
        Task task = (Task) obj;
        if(task.getDueDate().equals(this.getDueDate())
           &&task.getDescription().equals(this.getDescription()) 
           &&task.isCompleted() == this.isCompleted()){
            return true;
        }else{
            return false;
        }
	}
    /*
    * This method overrides the 'compareTo' method from the 'Comparable' Interface and
    * compares a Task description to the description the caller passes as an argument
    */
    public int compareTo(String description){
        return this.getDescription().compareTo(description);
    }
    
    
//********************************************************* DO NOT CHANGE ***************************************************//
	/*
	 * This method overrides the `toString` method from the `Object` class. 
	 * It returns a string representation of the task, including its description, due date, and completion status.
     * 
	 */
	@Override
	public String toString() {
		return "Description: " + getDescription() + "\n" +
				"Due Date: " + getDueDate() + "\n" +
				"Status: " + (isCompleted() ? "Completed" : "Pending") + 
				"\n";
	}

}
/*
    Personal task: 
    
    Datafield:
    Inherits the data field from Task
    Has two new variables reminder date and Type
    
    Constructor:
    the constructor uses the super() constructor to utilize the superclass
    Task constructor. It also initalizes the two new instance variables
    
    Methods:
    Inherits all of the methods from Task
    Has getters and setters for shopping list and Type variables
    Overides the To String method, using the super() (Task toString method) and just
    appending the reminder date to that string.
    
*/

class PersonalTask extends Task{
    private String reminderDate = "";
    private String type = "";
	PersonalTask(String description, String dueDate, String reminderDate){
        super(description, dueDate);
        this.type = "Personal";
        this.setReminderDate(reminderDate);
    }
    public void setReminderDate(String reminderDate){
        this.reminderDate = reminderDate;
    }
    public String getType(){
        return this.type;
    }
    public String getReminderDate(){
        return this.reminderDate;
    }
     @Override
    public String toString(){
        return super.toString() + "Reminder Date: " + this.getReminderDate() + "\n" ;
    }
}
/*
    Work task: 
    
    Datafield:
    Inherits the data field from Task
    Has two new variables Priortiy Level and Type
    
    Constructor:
    the constructor uses the super() constructor to utilize the superclass
    Task constructor. It also initalizes the two new instance variables
    
    Methods:
    Inherits all of the methods from Task
    Has getters and setters for piority level and Type variables
    Overides the To String method, using the super() (Task toString method) and just
    appending the priority level to that string.
    
*/

class WorkTask extends Task{
    private int priorityLevel;
    private String type;

    WorkTask(String description, String dueDate, int priorityLevel){
    super(description, dueDate);
        this.type = "Work";
        this.setPriorityLevel(priorityLevel);
    }
    public void setPriorityLevel(int priorityLevel){
        this.priorityLevel = priorityLevel;
    }
    public String getType(){
        return this.type;
    }
    public int getPriorityLevel(){
        return this.priorityLevel;
    }
    @Override
    public String toString(){
        return super.toString() + "Priority Level: " + this.getPriorityLevel() + "\n" ;
    }
}
/*
    Shopping task: 
    
    Datafield:
    Inherits the data field from Task
    Has two new variables Shopping list and Type
    
    Constructor:
    the constructor uses the super() constructor to utilize the superclass
    Task constructor. It also initalizes the two new instance variables
    
    Methods:
    Inherits all of the methods from Task
    Has getters and setters for shopping list and Type variables
    Overides the To String method, using the super() (Task toString method) and just
    appending the shopping list to that string.
    
*/
class ShoppingTask extends Task{
    private String shoppingList;
    private String type;
    
    ShoppingTask(String description, String dueDate, String shoppingList){
    super(description, dueDate);
        this.type = "Shopping";
        this.setShoppingList(shoppingList);
    }
    public void setShoppingList(String shoppingList){
        this.shoppingList = shoppingList;
    }
    public String getShoppingList(){
        return this.shoppingList;
    }
    public String getType(){
        return this.type;
    }
     @Override
    public String toString(){
        return super.toString() + "Shopping List: " + this.getShoppingList() + "\n" ;
    }
}

