package db.behavioral.observer;


//This interface handles adding, deleting and updating
//all observers

public interface ISubject {
	public void registerObserver(IObserver observer);
	public void unregisterObserver(IObserver observer);
	public void notifyObserver();
}
