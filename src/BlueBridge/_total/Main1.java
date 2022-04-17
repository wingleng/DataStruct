package BlueBridge._total;

import java.math.BigDecimal;

/**
 *  ±º‰œ‘ æ
 * @author WONG
 *
 */
public class Main1 {
	public static void main(String[] args) {
		Long seconds = 1618707600000l;
		Long senonds2 = 1618708103123l;
		getTime(senonds2);
	}
	public static void getTime(Long timestr) {
		Long seconds = timestr/1000;
		Long minute = seconds/60;
		Long hour = minute/60;
		System.out.printf("%02d:%02d:%02d", hour%24,minute%60,seconds%60);
	}

}
