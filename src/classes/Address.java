package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * classe formata da 4 oggetti di classe "Ottetto"
 * essa forma un indirizzo completo
 * @author Lorenzo Tafuro
 * @version 1.04
 */
public class Address {
	private Ottetto primoOttetto,secondoOttetto,terzoOttetto,quartoOttetto;
	
	public Address(Ottetto primoOttetto, Ottetto secondoOttetto, Ottetto terzoOttetto, Ottetto quartoOttetto) {
		this.setPrimoOttetto(primoOttetto);
		this.setSecondoOttetto(secondoOttetto);
		this.setTerzoOttetto(terzoOttetto);
		this.setQuartoOttetto(quartoOttetto);
	}
	
	/**
	 * restituisce il primo ottetto
	 * @return
	 */
	public Ottetto getPrimoOttetto() {
			return primoOttetto;
	}
	
	/**
	 * setta il primo ottetto
	 * @param primoOttetto
	 */
	public void setPrimoOttetto(Ottetto primoOttetto) {
		this.primoOttetto = primoOttetto;
	}
	
	/**
	 * restituisce il secondo ottetto
	 * @return
	 */
	public Ottetto getSecondoOttetto() {
		return secondoOttetto;
	}
	/**
	 * setta il secondo ottetto
	 * @param secondoOttetto
	 */
	public void setSecondoOttetto(Ottetto secondoOttetto) {
		this.secondoOttetto = secondoOttetto;
	}
	
	/**
	 * restituisce il terzo ottetto
	 * @return
	 */
	public Ottetto getTerzoOttetto() {
		return terzoOttetto;
	}

	/**
	 * setta il terzo ottetto
	 * @param terzoOttetto
	 */
	public void setTerzoOttetto(Ottetto terzoOttetto) {
		this.terzoOttetto = terzoOttetto;
	}

	/**
	 * restituisce il quarto ottetto
	 * @return
	 */
	public Ottetto getQuartoOttetto() {
		return quartoOttetto;
	}

	/**
	 * setta il quarto ottetto
	 * @param quartoOttetto
	 */
	public void setQuartoOttetto(Ottetto quartoOttetto) {
		this.quartoOttetto = quartoOttetto;
	}
	
	/**
	 * converte un indirizzo di classe Address in binario
	 * @param ad
	 * @return
	 */
	public String toStingBinary() {
		String s = this.getPrimoOttetto().toBinary() + "."
				+ this.getSecondoOttetto().toBinary() + "."
				+ this.getTerzoOttetto().toBinary() + "."
				+ this.getQuartoOttetto().toBinary();
		return s;
	}
	
	/**
	 * converte un indirizzo di classe Address in una stringa in binario
	 * @return
	 */
	public String toStingBinaryString() {
		String s = this.getPrimoOttetto().toBinary()
				+ this.getSecondoOttetto().toBinary()
				+ this.getTerzoOttetto().toBinary()
				+ this.getQuartoOttetto().toBinary();
		return s;
	}
	
	/**
	 * prende un indirizzo sottoforma di stringa, inclusi i punti, e la converte in un indirizzo
	 * @param address
	 * @return
	 */
	public static Address stringtoAddressRemDot(String address) throws Exception{
		List<String> tokens = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(address, ".");
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		String Sot1 = tokens.get(0);
		String Sot2 = tokens.get(1);
		String Sot3 = tokens.get(2);
		String Sot4 = tokens.get(3);
		
		Ottetto ot1 = new Ottetto(Integer.valueOf(Sot1));
		Ottetto ot2 = new Ottetto(Integer.valueOf(Sot2));
		Ottetto ot3 = new Ottetto(Integer.valueOf(Sot3));
		Ottetto ot4 = new Ottetto(Integer.valueOf(Sot4));
		
		Address ad = new Address(ot1, ot2, ot3, ot4);
		
		return ad;
	}
	
	
	/**
	 * restituisce l'indirizzo sotto forma di stringa
	 * @Override
	 */
	public String toString() {
		String s = String.valueOf(this.getPrimoOttetto().getOttetto()) + "."
				+ String.valueOf(this.getSecondoOttetto().getOttetto()) + "."
				+ String.valueOf(this.getTerzoOttetto().getOttetto()) + "."
				+ String.valueOf(this.getQuartoOttetto().getOttetto());
		return s;
	}

	/**
	 * converte una stringa binaria in un indirizzo
	 * @param s
	 * @return
	 */
	public static Address stringToAddress(String s) {
		String sOt1 = "";
		String sOt2 = "";
		String sOt3 = "";
		String sOt4 = "";
		
		for (int i = 0; i < 8; i++) {
			sOt1 = sOt1 + s.charAt(i);
		}
		for (int i = 8; i < 16; i++) {
			sOt2 = sOt2 + s.charAt(i);
		}
		for (int i = 16; i < 24; i++) {
			sOt3 = sOt3 + s.charAt(i);
		}
		for (int i = 24; i < 32; i++) {
			sOt4 = sOt4 + s.charAt(i);
		}
			
		Ottetto Ot1 = new Ottetto(Integer.valueOf(sOt1));
		Ottetto Ot2 = new Ottetto(Integer.valueOf(sOt2));
		Ottetto Ot3 = new Ottetto(Integer.valueOf(sOt3));
		Ottetto Ot4 = new Ottetto(Integer.valueOf(sOt4));
		
		Ot1.setOttetto(Ot1.toDecimal());
		Ot2.setOttetto(Ot2.toDecimal());
		Ot3.setOttetto(Ot3.toDecimal());
		Ot4.setOttetto(Ot4.toDecimal());
			
		Address ad = new Address(Ot1, Ot2, Ot3, Ot4);	
		
		return ad;
	}
}
