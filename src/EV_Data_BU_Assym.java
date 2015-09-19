import java.text.DecimalFormat;
import java.text.NumberFormat;

import poker.Monte;
import poker.Range;


public class EV_Data_BU_Assym {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		EV_Data_BU_Assym.printBvB();
		
	}

	private static void printBvB() {
		for (int or = 20; or <61; or+=5) {
		
		System.out.println("Opening Range: " + or +"%");
		System.out.print ("ASR:,");
		
		for (int sr = 11; sr<40; sr+=2) {
			System.out.print(sr + "%,");
					
		}
		System.out.println("");
		for (int cr = 5; cr<29; cr+=2) {
			System.out.print(cr + "%,");
			for (int sr = 11; sr < 60; sr+=2){
				Range ror = new Range();
				ror.add("RP" + Integer.toString(or));
				Range rsr = new Range();
				rsr.add("RP" + Integer.toString(sr));
				Range rcr = new Range();
				rcr.add("RC" + Integer.toString(cr));
				System.out.print(evRaiserBuAsym(ror, rcr, rsr, 100000) + ",");
				
				
			}
			System.out.println("");	
		}
		System.out.println("");	
		System.out.println("");	
		}
		
		
	}
	
	private static String evRaiserSB(Range open, Range call, Range shove, int trials) {
		
		double rPercent = open.size()/1326.0;
		double fe = (1326 - shove.size())/1326.0;
		double fes = 1.0*call.size()/open.size();
		double ev = (rPercent)*((fe)*(1.5) + (1-fe)*( (fes)*((Monte.pfRangeEquity(call,shove,trials,true))*2*20-(20-0.5)) - (1-fes)*(2-0.5) ));
		int iev = (int) roundTwoDecimals(ev);
		return Integer.toString(iev);
	}
	
	private static String evRaiserBuAsym(Range open, Range call, Range avgShove, int trials) {
		
		double rPercent = open.size()/1326.0;
		
		Range hiShove = avgShove;
		hiShove.addCombos(53);
		Range loShove = avgShove;
		loShove.subtractCombos(53);
		
		double fe = ((1326 - hiShove.size())/1326.0)*((1326 - loShove.size())/1326.0);
		
		Range hiCall = call;
		hiCall.addCombos(25);
		Range loCall = call;
		loCall.subtractCombos(25);
		
		double fesLO = 1.0*loCall.size()/open.size();
		double fesHI = 1.0*hiCall.size()/open.size();
		
		double loRatio = loShove.size()/(loShove.size()+hiShove.size());
		double hiRatio = 1 - loRatio;
				
		double ev = (rPercent)*((fe)*(1.5) + (1-fe)*( loRatio*( fesLO*((Monte.pfRangeEquity(call,avgShove,trials,true))*2*20-(20)) - (1-fesLO)*2) + hiRatio*( fesHI*((Monte.pfRangeEquity(call,avgShove,trials,true))*2*20-(20)) - (1-fesHI)*2) ) );
		int iev = (int) roundTwoDecimals(ev);
		return Integer.toString(iev);
	}
	
	private static double roundTwoDecimals(double d) {
	return Math.round(d*100);
	}
	
}
