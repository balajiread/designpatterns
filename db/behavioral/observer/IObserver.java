package db.behavioral.observer;

//The Observers update method is called when the Subject changes

public interface IObserver {
	public void update(double ibmPrice, double aaplPrice, double googPrice);
}
