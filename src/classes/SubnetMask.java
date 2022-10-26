package classes;
/**
 * classe formata da un intero che funge da Slash Notation
 * consente di calcolare le subnet mask
 * @author Lorenzo Tafuro
 * @version 1.04
 */
public class SubnetMask {
	private int slashNotation;
	
	public SubnetMask(int slashNotation) {
		this.setSlashNotation(slashNotation);
	}

	/**
	 * restituisce la slash notation
	 * @return
	 */
	public int getSlashNotation() {
		return slashNotation;
	}

	/**
	 * setta la slash notation
	 * @param slashNotation
	 */
	public void setSlashNotation(int slashNotation) {
		this.slashNotation = slashNotation;
	}

	/**
	 * calcola la subnet mask dalla Slash Notation
	 * @return
	 */
	public Address getAddress() {
		String ad = "";
		for (int i = 0; i < this.slashNotation; i++) {
			ad = ad + "1";
		}
		//ad = String.valueOf(ad.length());
		if (ad.length() < 32) {
			StringBuilder sb = new StringBuilder(ad);
			
			for(int i = 0; i < 32-ad.length(); i++) {
				sb.append(0);
			}
			ad = sb.toString();
		}
		String sOt1 = "";
		String sOt2 = "";
		String sOt3 = "";
		String sOt4 = "";
		
		for (int i = 0; i < 8; i++) {
			sOt1 = sOt1 + ad.charAt(i);
		}
		for (int i = 8; i < 16; i++) {
			sOt2 = sOt2 + ad.charAt(i);
		}
		for (int i = 16; i < 24; i++) {
			sOt3 = sOt3 + ad.charAt(i);
		}
		for (int i = 24; i < 32; i++) {
			sOt4 = sOt4 + ad.charAt(i);
		}
		
		Ottetto ot1 = new Ottetto(Integer.valueOf(sOt1).intValue());
		Ottetto ot2 = new Ottetto(Integer.valueOf(sOt2).intValue());
		Ottetto ot3 = new Ottetto(Integer.valueOf(sOt3).intValue());
		Ottetto ot4 = new Ottetto(Integer.valueOf(sOt4).intValue());
		
		Address address = new Address(ot1, ot2, ot3, ot4);
		return address;
	}
	
	/**
	 * restituisce la slash notation in base alla Subnet Mask sotto forma di indirizzo
	 * @param address
	 * @return
	 */
	public static int toSlashNotation(Address address) {
		String s = address.toStingBinary();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') count++;
		}
		return count;
	}
	
	/**
	 * metodo che trasforma una subnet mask binaria in decimale
	 * @param ad
	 * @return
	 */
	public static Address toDecimal(Address ad) {
		Ottetto ot1 = new Ottetto(ad.getPrimoOttetto().toDecimal());
		Ottetto ot2 = new Ottetto(ad.getSecondoOttetto().toDecimal());
		Ottetto ot3 = new Ottetto(ad.getTerzoOttetto().toDecimal());
		Ottetto ot4 = new Ottetto(ad.getQuartoOttetto().toDecimal());
		
		ad = new Address(ot1, ot2, ot3,ot4);
		return ad;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < this.getSlashNotation(); i++) {
			s += "1";
		}
		for(int i = 0; i < 32-this.getSlashNotation(); i++) {
			s += "0";
		}
		return s;
	}
	
}
