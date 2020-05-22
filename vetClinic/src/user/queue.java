package user;

import animals.Animal;

/* Queue function
 * Reference: Aponte, A., 2020. Queues. [online] Available at: <https://youtu.be/D4RHeZm2cK4> [Accessed 22 May 2020].
 * 
 * Animal getAnimal(int index) method was included to return element by index, in order to add them to a arrayList to be printed
 */


public class queue {
	
	private Animal[] data;
	private int size;
	private int front;
	private int rear;
	private int capacity;
	
	

	public queue(int capacity) {
		this.capacity = capacity;
		this.data = new Animal[capacity];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}

	public boolean Enqueue (Animal newElement) {
		
		if(rear >= capacity - 1) {
			return false;
		}
		
		if (front == -1) {
			front++;
		}		
		
		rear ++;
		data[rear] = newElement;
		size ++;		
		return true;		
	}
	
	public Animal Dequeue() {
		
		if(size == 0) {
			return null;
		}
		
		Animal toReturn = data[front];
		data[front] = null;
		front++;
		size--;
		return toReturn;
	}
	
	public Animal First() {
		
		if(size == 0) {
			return null;
		}
		return data[front];
	}
	
	public Animal Last() {
		
		if(size == 0) {
			return null;
		}
		return data[rear];
	}
	
	public int Size() {
		return size;
	}
	
	public boolean isEmpty() {
		
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String toReturn = "[ ";
		for(int i = front ; i <= rear ; i++) {
			toReturn += data[i] + " ";
		}
		toReturn += "]";
		return toReturn;
	}
	
	public Animal getAnimal(int index) {
		Animal animal = null;
		animal = data[index];
		return animal;
	}
	
	
}
