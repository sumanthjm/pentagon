package Receiver;

import Donner.Donating;
class Receivings extends Donating{

	void m() {
		try {
			Class.forName("Donner.Donating.classl");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class Receiving{
	public static void main(String[] args) {
		Receivings re=new Receivings();
		re.m();
		re.draw();
	}
}