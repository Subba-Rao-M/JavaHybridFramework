package oopsConcepts.dataabstracttion;

public class AustralianTrafic implements CentralTraffic,ContinentTraffic{
//By default implement the methods from interface
//Then add the new class spcific methods
	
	public static void main(String[] args) {
		CentralTraffic a= new AustralianTrafic();
		a.redStop();
		a.FlashYellow();
		a.greenGo();
		//Above object a cannot call AustralianTrafic class related methods, so create another object
		AustralianTrafic at=new AustralianTrafic();
		ContinentTraffic ct=new AustralianTrafic();
		at.walkonsymbol();
		ct.Trainsymbol();
		

		}

		@Override
		public void redStop() {
		// TODO Auto-generated method stub
		System.out.println(" redstop implementation");
		}
		public void walkonsymbol()
		{
		System.out.println("walking");
		}
		@Override
		public void FlashYellow() {
		// TODO Auto-generated method stub
		System.out.println(" flash yellow implementation");
		//code
		}

		@Override
		public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println(" Green go implementation");
		}

		@Override
		public void Trainsymbol() {
		// TODO Auto-generated method stub

		}

	

}
