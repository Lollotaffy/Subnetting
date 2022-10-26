package classes;
/**
 * classe che converte un intero in un ottetto
 * @author Lorenzo Tafuro
 * @version 1.04
 */
public class Ottetto {
	private int ottetto;
	
	public Ottetto(int ottetto) {
		this.setOttetto(ottetto);
	}

	
	/**
	 * restituisce l'ottetto
	 * @return
	 */
	public int getOttetto() {
		return ottetto;
	}

	/**
	 * setta l'ottetto
	 * @param ottetto
	 */
	public void setOttetto(int ottetto) {
		this.ottetto = ottetto;
	}
	
	/**
	 * controlla che i bit non superino gli 8
	 */
	public void chkOttetto(){
		if(this.ottetto > 255) {
			System.out.println("Impossibile aggiungere un numero superiore a 255");
			this.setOttetto(0);
			return;
		}
	}
	
	/**
	 * metodo che trasforma un ottetto da decimale a binario
	 * @return
	 */
	public String toBinary() {
		int bin = this.ottetto;
		String res = "";
		while (bin != 0) {
			Integer module = bin % 2;
			res = res + module.toString();
			bin = bin/2;
		}
		StringBuilder sb = new StringBuilder(res);
		sb.reverse();
		
		if(res.length()<8) {
			sb.reverse();
			res = sb.toString();
			for (int i = 0; i < 8-res.length(); i++) {
				sb.append(0);
			}
			sb.reverse();
		}
		res = sb.toString();
		return res;
	}
	
	/**
	 * metodo che trasforma un ottetto da binario a decimale
	 * @return
	 */
	public  int toDecimal() {
		int dec = this.ottetto;
		String res = String.valueOf(dec);
		int conv = Integer.parseInt(res, 2);
		return conv;
	}
	
	/**
	 * metodo statico che converte un qualsiasi intero in una stringa binaria
	 * @param i
	 * @return
	 */
	public static String intToBinary(int i) {
		String res = "";
		while (i != 0) {
			Integer module = i % 2;
			res = res + module.toString();
			i = i/2;
		}
		StringBuilder sb = new StringBuilder(res);
		sb.reverse();
		res = sb.toString();
		return res;
	}
}
