package db.behavioral.observer;

//Represents each Observer that is monitoring changes in the subject

public class StockObserver implements IObserver {
	
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	private static int observerIDTracker = 0;
	
	private int observerID;
	
	private ISubject stockGrabber;
	
	public StockObserver(ISubject stockGrabber) {
		this.stockGrabber = stockGrabber;
		this.observerID = ++observerIDTracker;
		System.out.println("New observer " + this.observerID);
		stockGrabber.registerObserver(this);
	}		
	
	
	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		printThePrices();
	}


	private void printThePrices() {
		System.out.println("StockObserver " + observerID + "\n ibmPrice=" + ibmPrice + "\n aaplPrice=" + aaplPrice + "\n googPrice=" + googPrice + "\n");
	}

}
