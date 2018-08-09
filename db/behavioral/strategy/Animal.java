package db.behavioral.strategy;

public class Animal {
	private String name;
	private double height;
	private int weight;
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double newHeight) {
		this.height = newHeight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int newWeight) {
		if(newWeight > 0)
			this.weight = newWeight;
		else
			System.out.println("Weight must be bigger than 0");
	}
	
	
}
