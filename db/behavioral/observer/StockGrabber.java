package db.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

//Uses the Subject interface to update all Observers

public class StockGrabber implements ISubject {
	private List<IObserver> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	
	
	public StockGrabber() {
		observers = new ArrayList<IObserver>();
	}

	@Override
	public void registerObserver(IObserver newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void unregisterObserver(IObserver deleteObserver) {
		int observerIndex = observers.indexOf(deleteObserver);
		System.out.println("Observer : " + (observerIndex + 1) + " deleted");
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		for(IObserver observer : observers) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
	}

	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}

	public void setAaplPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObserver();
	}

	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}
	
	

}
