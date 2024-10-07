import java.util.*;

/**
 * @author mehra
 * This class represents a ToDoList and provides methods to perform 
 * various operations on the list. 
 * Please implement the provided methods and add appropriate comments for each method.
 * Analysis: 
 * The ToDoList class needs to be able take the Task Object we created and make it where we can sort the task in the list,
 * addTask, mark them as complete, print each task, print them by completetion, and search for task. The linked-list is a good
 * data structure for this because we dont access any of the task by index so we just use a counter to see how much task we have.
 * With Linked list adding elements is O(1), searching, printing, marking complete, are all O(n) time comlexity which is reasonable
 * but marking task and finding specfic task could be easier in other data structures.
 * Some changes I would make is I'd make a method to delete task. I think another idea would be is using a priority Heap because than
 * the most important task `    acan be easily accesible, but this would likley require us to use more than one data structure for completed
 * once a user completes one of the higher priority task it can remove that task than place it into another data structure for completed'
 * task. A min-heap would be best for this so we could place the highest priority as number one and than do the order based of that.
 * This can also be efficent for school task, because we can use method to determine priortiy by due date and classes.
 */
class ToDoList {
	private Node head;
    private Node tail;
	private int taskCount = 0;
    
    
	/* 
     * @author mehra
     * The class has a private inner class named Node, which represents 
	 * a node in the linked list. 
	 * Each node contains a Task object and a reference to the next 
	 * node in the list.
	 */
	private class Node {
		private Task task;
		private Node next;

		public Node(Task task) {
			this.task = task;
			this.next = null;
		}
        public Task getTask(){
            return this.task;
        }
        public void setNext(Node node){
            next = node;
        }
        public Node getNext(){
            return this.next;
        }
        
	}
    
	/* 
	 * The add Task method appends a task to the end of the linked list and also increases the Task count
	 */	
	public void addTask(Task task) {
        Node node = new Node(task);
        if(this.isEmpty()){
            head = node;
            tail = node;
        }
        tail.setNext(node);
        tail = node;
        this.taskCount++;
        

	}
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }else{
            return false;
        }
    }
	/*
     * This method is responsible for displaying all tasks within the list. 
     * If the list is empty, it will print "No tasks found".
	 * Note: You must use the provided toString() method of the Task class to format the task details correctly.
     * 
     * Write appropriate comment:
     * The show all task method prints each task, simply by iterating through the linked list, starting from the head
     * and using the two string method for each task.
     * 
	 */
	public void showAllTasks() {
        Node current = this.head;
        if (this.isEmpty()){
            System.out.println("No tasks found");
        }else{
            
            for (int i = 0; i < taskCount; i++){
                if(i!=0){
                    System.out.println();
                }
                System.out.print(current.getTask().toString());
                
                current = current.next;
            }
            
        }

	}
	/*
	 * This method marks a task as completed based on its description. 
     * If a match is not found it will print "Task not found", otherwise "Task marked as completed"
	 * Note: You must use the overriden equals() method of the Task class to search the task, to get the full credit.
     * 
     * Write appropriate comment:
     *
	 */
	public void markTaskAsCompleted(String description) {
        boolean taskFound = false;
        if(!this.isEmpty()){
        Node current = this.head;
        
            for(int i = 0; i < taskCount; i++){
                if(current.getTask().compareTo(description) == 0){
                    taskFound = true;
                    current.getTask().markCompleted();
                    System.out.println("Task marked as completed");
                    break;
                }
                current = current.next;
            }
        }
        if(!taskFound){
            System.out.println("Task not found");
        }
	}
	/*
	 * This method filters the tasks based on their completion status. 
     * If a match is not found it will print "No tasks found". 
	 * Note: You must use the provided toString() method of the Task class to format the task details correctly.
     * 
     * Write appropriate comment:
     * This method starts by checking if the user wants to see the completed task or pending task, than using an if else,
     * iterates through each task and prints each task that is either (complete/pending) depending on what the user wants to
     * see starting from the head of the list.
     */
	public void filterTasksByStatus(boolean completed) {
        Node current = head;
        boolean taskFound = false;
            while(current!=null){
                if(current.getTask().isCompleted() == completed){
                    System.out.println(current.getTask().toString());
                    taskFound = true;
                        
                }current = current.next;
        }if(!taskFound){
            System.out.println("No tasks found");
        }
	}

	/*
	 * This method checks if a given task is present in the list. 
	 * Note: You must use the overriden equals() method of the Task class to search the task, to get the full credit.
     * 
     * Write appropriate comment:
     * This method first checks if the list is empty, than iterates through each element using our overrided equals() method
     * from the task class.
     *
	 */
	public Boolean containsTask(Task task1) {
        if(!this.isEmpty()){
            Node current = head;
            for(int i = 0; i < taskCount; i++){
                    if(current.getTask().equals(task1)){
                        return true;
                        }
                    }
                }
        
        return false;
	}
    
	/*
     * Write appropriate comment:
     * This method returns the taskCount, which is incrimented with each added element.
	 */
	public Integer getTasksCount() {
        //Write your code here
        return this.taskCount;
    }
    
    /*
     * Write appropriate comment:
     * This method sorts the task by the users choice of either description or due date
     * .equalsIgnoreCase() method is used for this because it being case sensitive doesnt 
     * matter. I used the Merge Sort algorithm, because I wanted to challege myself and 
     * because Merge Sort is a good algoritm for linked list due to the fact that you dont have
     * to index, other than getting the size of the linked list and the middle. This sortTask method
     * is comprised of 3 different helper methods, first mergeSort takes the start of the linked list
     * and a boolean value for if it is being sorted by description or not. Than using recurison
     * the base case checks if the list passed is either of size one or empty. This is important 
     * because what the recrusive method is doing is splitting the list into smaller sub list.
     * Than in the else case, it is finding the middle of the given list by using a helper method get
     * middle, which has two runners, a fast runner that goes through the list 2 nodes at a time
     * and a slow runner that goes one node at the time. This finds the middle because by the time the
     * fast node reaches the end of the list, the slow node will be at the middle because it is iterating
     * twice as slow. Then the first list is split by setting the right list = to the node right of the middle
     * and the than we set that node in the original list equal to null efectivly splitting the list into two
     * left and right sublist. Than we call the mergeSort() method again but this time for the first half(left) 
     * and second half(right) of the linked list. Than after these are iterated through the merge method is than used
     * to merge the smalles sublist of size 1, than the next sublist size 2, all the way up until size n when
     * their is just one list left, our sorted list. I used the overrided compareTo() to sort the descitpion 
     * and I made a method that converts the date to an integer to sort by date from soonest date to furthest.
	 */
	public void sortTasks(String sortBy) {
        if(sortBy.equalsIgnoreCase("description")){
            head = mergeSort(this.head, true);
        }else if(sortBy.equalsIgnoreCase("duedate")){
            head = mergeSort(this.head, false);

        }
    }
    
    
    
    private Node merge(Node left, Node right, boolean byDescription){
        Node result = new Node(null);
        if (left == null){
            return right;
        }
        if(right == null){
            return left;
        
        }
        if(byDescription){
            if(left.getTask().compareTo(right.getTask().getDescription()) <= 0){
                    result = left;
                    result.next = merge(left.next, right, byDescription);
                }else{
                    result = right;
                    result.next = merge(left, right.next, byDescription);
                }
            }else{
                if(left.getTask().parseDueDate() <= right.getTask().parseDueDate()){
                    result = left;
                    result.next = merge(left.next, right, byDescription);
                    
                }else{
                    result = right;
                    result.next = merge(left, right.next, byDescription);
                }
        }
        return result;
    }
    
    private Node getMiddleNode(Node head){
        if(head == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private Node mergeSort(Node head, boolean byDescription){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = getMiddleNode(head);
        Node right = middle.next;
        Node left = head;
        middle.next = null;
        
        
        
        left = mergeSort(left, byDescription);
        right = mergeSort(right, byDescription);
        return merge(left, right, byDescription);
        
        }
    
}
