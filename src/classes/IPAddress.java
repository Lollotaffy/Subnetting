package classes;

import java.util.ArrayList;

/**
 * classe formata da un oggetto di classe Address e una Subnet Mask
 * consente di trovare la posizione di un indirizzo o di calcolare le subnet
 * @author Lorenzo Tafuro
 * @version 1.5
 */
public class IPAddress {
	private Address address;
	private SubnetMask subnetMask;
	
	public IPAddress(Address address, SubnetMask subnetMask) {
		this.setAddress(address);
		this.setSubnetMask(subnetMask);
	}
	
	
	/**
	 * individua la posizione di un indirizzo e la rispettiva subnet
	 * @param ipAddress
	 */
	public static void findSubnetByIP(IPAddress ipAddress) {
		String IPClass = "";
		String separe = "\n=================================================================\n";
		int primoOttetto = ipAddress.getAddress().getPrimoOttetto().getOttetto();
		SubnetMask classMask = new SubnetMask(0);
		if(0 <= primoOttetto && primoOttetto <= 127) {
			IPClass = "A";
			classMask.setSlashNotation(8);
		} else if(128 <= primoOttetto && primoOttetto <= 191) {
			IPClass = "B";
			classMask.setSlashNotation(16);
		} else if (192 <= primoOttetto && primoOttetto <= 223) {
			classMask.setSlashNotation(24);
			IPClass = "C";
		}
		System.out.println("\n" + separe + "\nIndirizzo: " + ipAddress.toString());
		System.out.println("\nL'indirizzo è di classe " + IPClass);
		System.out.println("Subnet Mask: " + SubnetMask.toDecimal(ipAddress.subnetMask.getAddress()));
		System.out.println("Subnet Mask di classe: " + SubnetMask.toDecimal(classMask.getAddress()) + " (/" + classMask.getSlashNotation() + ")");
		
		String binAddress = ipAddress.getAddress().toStingBinaryString();
		String noNet = "";
		
		for(int i = classMask.getSlashNotation(); i < 32; i++) {
			noNet = noNet + binAddress.charAt(i);
		}
		
		String subnetPart = "";
		String hostPart = "";
		int count = 0;
		
		for (int i = 0; i < ipAddress.subnetMask.getSlashNotation() - classMask.getSlashNotation(); i++) {		
			subnetPart = subnetPart + noNet.charAt(count);
			count++;
		}
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < binAddress.length(); i++) {
			hostPart = hostPart + noNet.charAt(count);
			count++;
		}
		
		int subnetPartInt = Integer.parseInt(subnetPart, 2) + 1;
		int hostPartInt = Integer.parseInt(hostPart, 2);
		
		String subAddress = "";
		for(int i = 0; i < ipAddress.subnetMask.getSlashNotation(); i++) {
			subAddress = subAddress + binAddress.charAt(i);
		}
		String completeNetAddress = subAddress;
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			subAddress = subAddress + "0" ;
		}
		
		
		System.out.println("\nIndirizzo di subnet: " + Address.stringToAddress(subAddress) + " /" + ipAddress.subnetMask.getSlashNotation());
		boolean chkBroad = true;
		
		subAddress = "";
		for(int i = 0; i < ipAddress.subnetMask.getSlashNotation(); i++) {
			subAddress = subAddress + binAddress.charAt(i);
		}
		completeNetAddress = subAddress;
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			subAddress = subAddress + "1" ;
		}
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			completeNetAddress = completeNetAddress + "0" ;
		}
		
		System.out.println("Indirizzo di broadcast della subnet: " + Address.stringToAddress(subAddress) + " /" + ipAddress.subnetMask.getSlashNotation() + "\n");
		System.out.println(Address.stringToAddress(classMask.toString()).toStingBinary() + " Subnet Mask di classe binaria (" + classMask.getSlashNotation() + ")");
		System.out.println(Address.stringToAddress(ipAddress.getSubnetMask().toString()).toStingBinary() + " Subnet Mask binaria (" + ipAddress.subnetMask.getSlashNotation() + ")");
		System.out.println(Address.stringToAddress(completeNetAddress).toStingBinary() + " Indirizzo di subnet binario");
		System.out.println(Address.stringToAddress(binAddress).toStingBinary() + " Indirizzo Binario\n");
		
		for (int i = 0; i < hostPart.length(); i++) {
			if (hostPart.charAt(i) == '0') chkBroad = false;
		}
		System.out.println("Subnet numero: " + subnetPartInt);
		if (chkBroad) System.out.println("Indirizzo di Broadcast" + " (" + hostPartInt + ")");
		else System.out.println("Host numero: " + hostPartInt);
		System.out.println(separe + "\n");
	}
	
	/**
	 * calcola le subnet con maschera fissa in base al numero richiesto
	 * @param subnet
	 * @throws InterruptedException
	 */
	public void doSubnettingByNSubnet(int subnet) throws InterruptedException {
		String separe = "\n=================================================================\n";
		System.out.println(separe + "\nIndirizzo di rete: " + this.toString());
		System.out.println("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + " (/" + this.subnetMask.getSlashNotation() + ")");
		System.out.println("Numero di Subnet da creare: " + subnet + "\n");
		double chkNSub = 0;
		double pwr = 0;
		String binAddress = this.address.toStingBinaryString();
		String netPart = "";
		for (int i = 0; i < this.subnetMask.getSlashNotation(); i++) {
			netPart = netPart + binAddress.charAt(i);
		}
		
		while(chkNSub < subnet) {
			pwr++;
			chkNSub = Math.pow(2, pwr);
		}
		this.subnetMask.setSlashNotation(this.subnetMask.getSlashNotation() + (int)pwr);
		
		System.out.println("Numero di Subnet: " + String.format("%,.0f", chkNSub));
		System.out.println("Bit allocati alle subnet: " + String.format("%,.0f", pwr));
		System.out.println("Indirizzi host utili per subnet: " + String.format("%,.0f", (Math.pow(2, ((32-this.getSubnetMask().getSlashNotation())))-2)));
		System.out.println("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + "(" + this.subnetMask.getSlashNotation() + ")\n\n");
		
		doSubnetting(chkNSub, pwr, binAddress, netPart);
		System.out.println(separe);
	}
	
	/**
	 * calcola le subnet con maschera fissa in base alla Subnet Mask
	 * @throws InterruptedException
	 */
	public void doSubnettingBySubnetMask() throws InterruptedException {
		String separe = "\n=================================================================\n";
		int subnet = 0;
		int classMask = 0;
		int primoOttetto = this.getAddress().getPrimoOttetto().getOttetto();
		
		if(0 <= primoOttetto && primoOttetto <= 127) {
			classMask = 8;
		} else if(128 <= primoOttetto && primoOttetto <= 191) {
			classMask = 16;
		} else if (192 <= primoOttetto && primoOttetto <= 223) {
			classMask = 24;
		}
		
		System.out.println(separe + "\nIndirizzo di rete: " + this.getAddress().toString() + " /" + classMask);
		System.out.println("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + " (/" + this.subnetMask.getSlashNotation() + ")");
		
		subnet = Integer.valueOf(String.format("%,.0f", Math.pow(2, this.getSubnetMask().getSlashNotation() - classMask)));
		System.out.println("Numero di Subnet da creare: " + subnet + "\n");
		double chkNSub = 0;
		double pwr = 0;
		String binAddress = this.address.toStingBinaryString();
		String netPart = "";
		for (int i = 0; i < classMask; i++) {
			netPart = netPart + binAddress.charAt(i);
		}
		
		while(chkNSub < subnet) {
			pwr++;
			chkNSub = Math.pow(2, pwr);
		}
		
		System.out.println("Numero di Subnet: " + String.format("%,.0f", chkNSub));
		System.out.println("Bit allocati alle subnet: " + String.format("%,.0f", pwr));
		System.out.println("Indirizzi host utili per subnet: " + String.format("%,.0f", (Math.pow(2, ((32-this.getSubnetMask().getSlashNotation())))-2)) + "\n\n");
		
		doSubnetting(chkNSub, pwr, binAddress, netPart);
		System.out.println(separe);
	}

	/**
	 * calcola le subnetting in base ai parametri degli altri metodi
	 * @param chkNSub
	 * @param pwr
	 * @param binAddress
	 * @param netPart
	 * @throws InterruptedException
	 */
	private void doSubnetting(double chkNSub, double pwr, String binAddress, String netPart) throws InterruptedException {
		String subnetPart;
		String hostPart;
		for(int i = 0; i < (int)chkNSub; i++) {
			System.out.println((i+1) + "° Subnet: ");
			subnetPart = Ottetto.intToBinary(i);
			StringBuilder sb = new StringBuilder(subnetPart);
			sb.reverse();
			for(int j = 0; j < pwr - subnetPart.length(); j++) {
				sb.append("0");
			}
			sb.reverse();
			subnetPart = sb.toString();
			String subAddress = netPart + subnetPart;
			StringBuilder sbr = new StringBuilder(subAddress);
			for (int j = 0; j < binAddress.length() - subAddress.length(); j++) {
				sbr.append("0");
			}
			String newSubAddress = sbr.toString();
			System.out.println("\tIndirizzo di Subnet: " + Address.stringToAddress(newSubAddress).toString() + " /" + this.subnetMask.getSlashNotation() + "\n");
			
			for(int j = 1; j <= Math.pow(2, 32 - this.subnetMask.getSlashNotation())-2; j++) {
				hostPart = Ottetto.intToBinary(j);
				StringBuilder sb2 = new StringBuilder(hostPart);
				sb2.reverse();
				for(int k = 0; k < binAddress.length() - ((netPart.length() + subnetPart.length()) + hostPart.length()); k++){
					sb2.append(0);
				}
				sb2.reverse();
				hostPart = sb2.toString();
				String newBinAddress = netPart + subnetPart+ hostPart;
				if(this.getAddress().getPrimoOttetto().getOttetto() > 191) {
					System.out.println("\t\t" + Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation());	
					Thread.sleep(20);
				}else if (j == 1) {
					System.out.print("\t\tRange: " + Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation() + " % ");
				}else if (j == Math.pow(2, 32 - this.subnetMask.getSlashNotation())-2) {
					System.out.println(Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation());
					Thread.sleep(10);
				}
			}
			StringBuilder sbb = new StringBuilder(subAddress);
			for (int j = 0; j < binAddress.length() - subAddress.length(); j++) {
				sbb.append("1");
			}
			String subBroadcast = sbb.toString();
			System.out.println("\n\tBroadcast: " + Address.stringToAddress(subBroadcast)+ " /" + this.subnetMask.getSlashNotation() + "\n\n");
		}
	}

	/**
	 * corrispettivo del metodo "findSubnetByIP" che restituisce un Array di stringhe per la stampa o il salvataggio file
	 * @param ipAddress
	 */
	public static String[] stringFindSubnetByIP(IPAddress ipAddress) throws Exception{
		ArrayList<String> arrayString = new ArrayList<String>();
		String IPClass = "";
		String separe = "\n=================================================================\n";
		int primoOttetto = ipAddress.getAddress().getPrimoOttetto().getOttetto();
		SubnetMask classMask = new SubnetMask(0);
		if(0 <= primoOttetto && primoOttetto <= 127) {
			IPClass = "A";
			classMask.setSlashNotation(8);
		} else if(128 <= primoOttetto && primoOttetto <= 191) {
			IPClass = "B";
			classMask.setSlashNotation(16);
		} else if (192 <= primoOttetto && primoOttetto <= 223) {
			classMask.setSlashNotation(24);
			IPClass = "C";
		}
		arrayString.add("\n" + separe + "\nIndirizzo: " + ipAddress.toString() + "\n");
		arrayString.add("\nL'indirizzo è di classe " + IPClass + "\n");
		arrayString.add("Subnet Mask: " + SubnetMask.toDecimal(ipAddress.subnetMask.getAddress()) + "\n");
		arrayString.add("Subnet Mask di classe: " + SubnetMask.toDecimal(classMask.getAddress()) + " (/" + classMask.getSlashNotation() + ")\n");
		
		String binAddress = ipAddress.getAddress().toStingBinaryString();
		String noNet = "";
		
		for(int i = classMask.getSlashNotation(); i < 32; i++) {
			noNet = noNet + binAddress.charAt(i);
		}
		
		String subnetPart = "";
		String hostPart = "";
		int count = 0;
		
		for (int i = 0; i < ipAddress.subnetMask.getSlashNotation() - classMask.getSlashNotation(); i++) {		
			subnetPart = subnetPart + noNet.charAt(count);
			count++;
		}
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < binAddress.length(); i++) {
			hostPart = hostPart + noNet.charAt(count);
			count++;
		}
		
		int subnetPartInt = Integer.parseInt(subnetPart, 2) + 1;
		int hostPartInt = Integer.parseInt(hostPart, 2);
		
		String subAddress = "";
		for(int i = 0; i < ipAddress.subnetMask.getSlashNotation(); i++) {
			subAddress = subAddress + binAddress.charAt(i);
		}
		String completeNetAddress = subAddress;
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			subAddress = subAddress + "0" ;
		}
		
		
		arrayString.add("\nIndirizzo di subnet: " + Address.stringToAddress(subAddress) + " /" + ipAddress.subnetMask.getSlashNotation()+"\n");
		boolean chkBroad = true;
		
		subAddress = "";
		for(int i = 0; i < ipAddress.subnetMask.getSlashNotation(); i++) {
			subAddress = subAddress + binAddress.charAt(i);
		}
		completeNetAddress = subAddress;
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			subAddress = subAddress + "1" ;
		}
		for (int i = ipAddress.subnetMask.getSlashNotation(); i < 32; i++) {
			completeNetAddress = completeNetAddress + "0" ;
		}
		
		arrayString.add("Indirizzo di broadcast della subnet: " + Address.stringToAddress(subAddress) + " /" + ipAddress.subnetMask.getSlashNotation() + "\n\n");
		arrayString.add(Address.stringToAddress(classMask.toString()).toStingBinary() + " Subnet Mask di classe binaria (" + classMask.getSlashNotation() + ")\n");
		arrayString.add(Address.stringToAddress(ipAddress.getSubnetMask().toString()).toStingBinary() + " Subnet Mask binaria (" + ipAddress.subnetMask.getSlashNotation() + ")\n");
		arrayString.add(Address.stringToAddress(completeNetAddress).toStingBinary() + " Indirizzo di subnet binario\n");
		arrayString.add(Address.stringToAddress(binAddress).toStingBinary() + " Indirizzo Binario\n\n");
		
		for (int i = 0; i < hostPart.length(); i++) {
			if (hostPart.charAt(i) == '0') chkBroad = false;
		}
		arrayString.add("Subnet numero: " + subnetPartInt + "\n");
		if (chkBroad) arrayString.add("Indirizzo di Broadcast" + " (" + hostPartInt + ")\n");
		else arrayString.add("Host numero: " + hostPartInt + "\n");
		arrayString.add(separe + "\n\n");
		
		String[] convertedArray = arrayString.toArray(new String[0]);
		return convertedArray;
	}
	
	/**
	 * corrispettivo del metodo "doSubnettingByNSubnet" che restituisce un Array di stringhe per la stampa o il salvataggio file
	 * @param subnet
	 */
	public String[] stringDoSubnettingByNSubnet(int subnet){
		ArrayList<String> arrayString = new ArrayList<String>();
		String separe = "\n=================================================================\n";
		arrayString.add(separe + "\nIndirizzo di rete: " + this.toString()+ "\n");
		arrayString.add("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + " (/" + this.subnetMask.getSlashNotation() + ")\n");
		arrayString.add("Numero di Subnet da creare: " + subnet + "\n\n");
		double chkNSub = 0;
		double pwr = 0;
		String binAddress = this.address.toStingBinaryString();
		String netPart = "";
		for (int i = 0; i < this.subnetMask.getSlashNotation(); i++) {
			netPart = netPart + binAddress.charAt(i);
		}
		
		while(chkNSub < subnet) {
			pwr++;
			chkNSub = Math.pow(2, pwr);
		}
		this.subnetMask.setSlashNotation(this.subnetMask.getSlashNotation() + (int)pwr);
		
		arrayString.add("Numero di Subnet: " + String.format("%,.0f", chkNSub) + "\n");
		arrayString.add("Bit allocati alle subnet: " + String.format("%,.0f", pwr) + "\n");
		arrayString.add("Indirizzi host utili per subnet: " + String.format("%,.0f", (Math.pow(2, ((32-this.getSubnetMask().getSlashNotation())))-2)) + "\n");
		arrayString.add("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + "(" + this.subnetMask.getSlashNotation() + ")\n\n\n");
		
		String[] subArray = stringDoSubnetting(chkNSub, pwr, binAddress, netPart);
		for (int i = 0; i < subArray.length; i++) {
			arrayString.add(subArray[i]);
		}
		arrayString.add(separe);
		
		String[] convertedArray = arrayString.toArray(new String[0]);
		return convertedArray;
	}
	
	/**
	 * corrispettivo del metodo "doSubnettingBySubnetMask" che restituisce un Array di stringhe per la stampa o il salvataggio file
	 * @throws InterruptedException
	 */
	public String[] stringDoSubnettingBySubnetMask(){
		ArrayList<String> arrayString = new ArrayList<String>();
		String separe = "\n=================================================================\n";
		int subnet = 0;
		int classMask = 0;
		int primoOttetto = this.getAddress().getPrimoOttetto().getOttetto();
		
		if(0 <= primoOttetto && primoOttetto <= 127) {
			classMask = 8;
		} else if(128 <= primoOttetto && primoOttetto <= 191) {
			classMask = 16;
		} else if (192 <= primoOttetto && primoOttetto <= 223) {
			classMask = 24;
		}
		
		arrayString.add(separe + "\nIndirizzo di rete: " + this.getAddress().toString() + " /" + classMask + "\n");
		arrayString.add("Subnet Mask: " + SubnetMask.toDecimal(this.subnetMask.getAddress()) + " (/" + this.subnetMask.getSlashNotation() + ")\n");
		
		subnet = Integer.valueOf(String.format("%,.0f", Math.pow(2, this.getSubnetMask().getSlashNotation() - classMask)));
		arrayString.add("Numero di Subnet da creare: " + subnet + "\n\n");
		double chkNSub = 0;
		double pwr = 0;
		String binAddress = this.address.toStingBinaryString();
		String netPart = "";
		for (int i = 0; i < classMask; i++) {
			netPart = netPart + binAddress.charAt(i);
		}
		
		while(chkNSub < subnet) {
			pwr++;
			chkNSub = Math.pow(2, pwr);
		}
		
		arrayString.add("Numero di Subnet: " + String.format("%,.0f", chkNSub)+"\n");
		arrayString.add("Bit allocati alle subnet: " + String.format("%,.0f", pwr)+"\n");
		arrayString.add("Indirizzi host utili per subnet: " + String.format("%,.0f", (Math.pow(2, ((32-this.getSubnetMask().getSlashNotation())))-2)) + "\n\n\n");
		
		String[] subArray = stringDoSubnetting(chkNSub, pwr, binAddress, netPart);
		for (int i = 0; i < subArray.length; i++) {
			arrayString.add(subArray[i]);
		}
		arrayString.add(separe);
		
		String[] convertedArray = arrayString.toArray(new String[0]);
		return convertedArray;
	}

	/**
	 * corrispettivo del metodo "doSubnetting" che restituisce un Array di stringhe per la stampa o il salvataggio file
	 * @param chkNSub
	 * @param pwr
	 * @param binAddress
	 * @param netPart
	 * @throws InterruptedException
	 */
	private String[] stringDoSubnetting(double chkNSub, double pwr, String binAddress, String netPart){
		ArrayList<String> arrayString = new ArrayList<String>();
		String subnetPart;
		String hostPart;
		for(int i = 0; i < (int)chkNSub; i++) {
			arrayString.add((i+1) + "° Subnet: "+ "\n");
			subnetPart = Ottetto.intToBinary(i);
			StringBuilder sb = new StringBuilder(subnetPart);
			sb.reverse();
			for(int j = 0; j < pwr - subnetPart.length(); j++) {
				sb.append("0");
			}
			sb.reverse();
			subnetPart = sb.toString();
			String subAddress = netPart + subnetPart;
			StringBuilder sbr = new StringBuilder(subAddress);
			for (int j = 0; j < binAddress.length() - subAddress.length(); j++) {
				sbr.append("0");
			}
			String newSubAddress = sbr.toString();
			arrayString.add("\tIndirizzo di Subnet: " + Address.stringToAddress(newSubAddress).toString() + " /" + this.subnetMask.getSlashNotation() + "\n\n");
			
			for(int j = 1; j <= Math.pow(2, 32 - this.subnetMask.getSlashNotation())-2; j++) {
				hostPart = Ottetto.intToBinary(j);
				StringBuilder sb2 = new StringBuilder(hostPart);
				sb2.reverse();
				for(int k = 0; k < binAddress.length() - ((netPart.length() + subnetPart.length()) + hostPart.length()); k++){
					sb2.append(0);
				}
				sb2.reverse();
				hostPart = sb2.toString();
				String newBinAddress = netPart + subnetPart+ hostPart;
				if(this.getAddress().getPrimoOttetto().getOttetto() > 191) {
					arrayString.add("\t\t" + Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation() + "\n");
				}else if (j == 1) {
					arrayString.add("\t\tRange: " + Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation() + " % ");
				}else if (j == Math.pow(2, 32 - this.subnetMask.getSlashNotation())-2) {
					arrayString.add(Address.stringToAddress(newBinAddress) + " /" + this.subnetMask.getSlashNotation() + "\n");
				}
			}
			StringBuilder sbb = new StringBuilder(subAddress);
			for (int j = 0; j < binAddress.length() - subAddress.length(); j++) {
				sbb.append("1");
			}
			String subBroadcast = sbb.toString();
			arrayString.add("\n\tBroadcast: " + Address.stringToAddress(subBroadcast)+ " /" + this.subnetMask.getSlashNotation() + "\n\n\n");
		}
		
		String[] convertedArray = arrayString.toArray(new String[0]);
		return convertedArray;
	}
	
	
	
	/**
	 * restituisce l'indirizzo
	 * @return
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * setta l'indirizzo
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * restituisce la Subnet Mask
	 * @return
	 */
	public SubnetMask getSubnetMask() {
		return subnetMask;
	}

	/**
	 * setta la subnet mask
	 * @param subnetMask
	 */
	public void setSubnetMask(SubnetMask subnetMask) {
		this.subnetMask = subnetMask;
	}

	/**
	 * restituisce la subnet mask sotto forma di stringa
	 * @Override
	 */
	public String toString() {
		String s = this.address.toString() + " /" + this.subnetMask.getSlashNotation();
		return s;
	}
}