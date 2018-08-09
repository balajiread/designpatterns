package db.behavioral.observer;

public class GrabStocksObserverDemo {
	/**
	 * Def: 
	 * The Observer pattern is a software design pattern in which an object, called the subject, maintains a list of its
	 * dependents, called observers, and notifies them automatically of any state changes, 
	 * usually by calling one of their methods.
	 * 
	 * when you need many other objects to receive an update when another object changes
	 * Fog eg:-
	 * -->Stock market with thousands of stocks needs to send updates to objects representing individual stocks.
	 * The Subject(Publisher) sends many stocks to the observers
	 * The Observers(Subscribers) takes the ones they want and use them
	 * 
	 * Benefits:-
	 * Loose coupling is a benefit
	 * 	- The Subject(publisher) doesn't need to know anything about the Observers(subscribers).
	 * 
	 * Negatives:-
	 * 	- The Subject(publisher) may send updates that don't matter to the Observer(subscriber).
	 */

	public static void main(String[] args) {
		// Create the Subject object
		// It will handle updating all observers
		// as well as deleting and adding them
		StockGrabber  stockGrabber = new StockGrabber();

		// Create an Observer that will be sent updates from Subject
		IObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setIbmPrice(160.00);
		stockGrabber.setAaplPrice(170.00);
		stockGrabber.setGoogPrice(175.00);
		
		IObserver observer2 = new StockObserver(stockGrabber);
		
		stockGrabber.setIbmPrice(150.00);
		stockGrabber.setAaplPrice(155.00);
		stockGrabber.setGoogPrice(165.00);
		
		 // Delete one of the observers
		stockGrabber.unregisterObserver(observer2);
		
		stockGrabber.setIbmPrice(140.00);
		stockGrabber.setAaplPrice(145.00);
		stockGrabber.setGoogPrice(150.00);
		
		
		// Create 3 threads using the Runnable interface
		// GetTheStock implements Runnable, so it doesn't waste
		// its one extendable class option

		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 187.00);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 177.00);
		
		// Call for the code in run to execute
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();
		
	}

}
