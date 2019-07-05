package ex1ArrayListSimulation;

import java.util.Arrays;

public class MyIntArrayList {
	
	private int[] array;
	private int size;
	
	MyIntArrayList() {
		this.array = new int[10];
	}
	
	MyIntArrayList(MyIntArrayList c) {
		this.size = c.size;
		this.array = new int[c.size];
		for(int i = 0; i < c.size; i++) {
			this.array[i] = c.get(i);
		}
	}
	
	MyIntArrayList(int capacity) {
		this.array = new int[capacity];
	}
	
	public void printing() {
		System.out.print("[");
		for(int i = 0; i < this.size; i++) {	
			System.out.print(this.array[i] + " ");
		}
		System.out.println("]");
	}
	
	private void isEnoughCapacity() {
		if(this.size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
	}
	
	public void add(int index, int element) {
		this.isEnoughCapacity();
		
		for(int i = this.size; i >= index; i--) {
			this.array[i + 1] = this.array[i];
		}
		this.array[index] = element;
		this.size++;
	}
	
	public boolean add(int e) {
		this.isEnoughCapacity();
		this.array[this.size] = e;
		this.size++;
		return true;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean contains(int e) {
		for(int i = 0; i < this.size; i++) {
			if(this.array[i] == e) {
				return true;
			}
		}
		return false;
	}
	
	public int get(int index) {
		return this.array[index];
	}
	
	public int indexOf(int e) {
		for(int i = 0; i < this.size; i++) {
			if(this.array[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(int e) {
		for(int i = this.size - 1; i >= 0; i--) {
			if(this.array[i] == e) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(int e) {
		boolean isHappening = false;
		int aux = 0;
		for(int i = 0; i < this.size; i++) {
			if(this.array[i] == e) {
				aux = i;
				isHappening = true;
				this.array[i] = this.array[i + 1];
				break;
			}
		}
		if(isHappening) {
			for(int i = aux + 1; i < this.size; i++) {
				this.array[i] = this.array[i + 1];
			}
			this.size--;
		}
		return isHappening;
	}
	
	public int removeElementAtIndex(int index) {
		this.isEnoughCapacity();
		int toReturn = this.array[index];
		for(int i = index; i < this.size; i++) {
			this.array[i] = this.array[i + 1];
		}
		this.size--;
		return toReturn;
	}
	
	public void clear() {
		this.size = 0;
	}
	
	public int set(int index, int e) {
		int toReturn = this.array[index];
		this.array[index] = e;
		return toReturn;
	}
	
	public boolean addAll(MyIntArrayList c) {
		int[] newArray = new int[this.size + c.size];
		int counterForThisArray = 0;
		int counterForC = 0;
		for(int i = 0; i < newArray.length; i++) {
			if(counterForThisArray < this.size) {
				newArray[i] = this.array[counterForThisArray];
				counterForThisArray++;
			} else {
				newArray[i] = c.get(counterForC);
				counterForC++;
				if(counterForC == c.size) {
					break;
				}
			}
		}
		this.array = newArray;
		this.size=newArray.length;
		return true;
	}
	
	public boolean addAll(int index, MyIntArrayList c) {
		int[] newArray = new int[this.size + c.size];
		int counterForC = 0;
		int counterFromIndex = index;
		for(int i = 0; i < index; i++) {
			newArray[i] = this.array[i];
		}
		for(int i = index; i < newArray.length; i++) {
			if(counterForC < c.size) {
				newArray[i] = c.get(counterForC);
				counterForC++;
			} else {
				newArray[i] = this.array[counterFromIndex];
				counterFromIndex++;
			}
		}
		this.array = Arrays.copyOf(newArray, this.size + c.size);
		this.size = this.size + c.size;
		return true;
	}
	
	public int[] toArray() {
		int[] array = Arrays.copyOf(this.array, this.size);
		return array;
	}
	
	public void ensureCapacity(int minCapacity) {
		this.array = Arrays.copyOf(this.array, minCapacity);
	}
	
	public void trimToSize() {
		this.array = Arrays.copyOf(this.array, this.size);
		if(this.array.length == 0) {
			this.array = Arrays.copyOf(this.array, 1);
		}
	}
	
	
	
	public static void main(String[] args) {
		MyIntArrayList array1 = new MyIntArrayList(2);
		
		array1.add(0);
		array1.add(1);
		array1.add(2);
		array1.add(3);
		array1.add(0, 10);
		array1.add(9);
		
		array1.printing();
		
		MyIntArrayList array2 = new MyIntArrayList(array1);
		
		array2.set(3, 20);
		
		array2.printing();
		
		array1.addAll(3, array2);
		
		array1.printing();
		
	}

}
