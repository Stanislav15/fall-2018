package day49_inheritrance03;

public class Etsy extends SearchEngine{
	@Override
	public void search(String item) {
		System.out.println("Navigate to etsy.com and search for " + item);
	}
}
