package main;
import classes.*;
import utilities.Utility;

/**
 * main di test della classe
 * @author Lorenzo Tafuro
 * @version 1.5
 */
public class Main {

	public static void main(String[] args) throws Exception {
		int opz = 1;
		
		do {
			
			
			System.out.println("\nSCEGLIERE UN OPZIONE");
			System.out.println("\t1-Calcolare le la subnet da un numero specifico");
			System.out.println("\t2-Calcolare le la subnet dalla Subnet Mask");
			System.out.println("\t3-Trovare una subnet");
			System.out.println("\t0-esci");
			opz = Utility.leggiInt();
			
			switch(opz) {
			case 1:
				System.out.print("Inserisci l'indirizzo IP: ");
				String sAd = Utility.leggiString();
				System.out.print("Inserisci la Subnet Mask o Slash Notation: ");
				String subnet = Utility.leggiString();	
				System.out.print("Inserisci il numero di subnet: ");
				int nSub = Utility.leggiInt();
				
				Address ad = null;
				try {
					ad = Address.stringtoAddressRemDot(sAd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SubnetMask sm;
				
				if(subnet.length() <= 2) {
					sm = new SubnetMask(Integer.valueOf(subnet));
				}else {
					Address sub = Address.stringtoAddressRemDot(subnet);
					sm = new SubnetMask(SubnetMask.toSlashNotation(sub));
				}
				
				IPAddress ipAddress = new IPAddress(ad, sm);
				ipAddress.doSubnettingByNSubnet(nSub);
				break;
				
			case 2:
				System.out.print("Inserisci l'indirizzo IP: ");
				String sAd1 = Utility.leggiString();
				System.out.print("Inserisci la Subnet Mask o Slash Notation: ");
				String subnet1 = Utility.leggiString();	
				
				Address ad1 = Address.stringtoAddressRemDot(sAd1);
				SubnetMask sm1;
				
				if(subnet1.length() <= 2) {
					sm1 = new SubnetMask(Integer.valueOf(subnet1));
				}else {
					Address sub1 = Address.stringtoAddressRemDot(subnet1);
					sm1 = new SubnetMask(SubnetMask.toSlashNotation(sub1));
				}
				
				IPAddress ipAddress1 = new IPAddress(ad1, sm1);
				ipAddress1.doSubnettingBySubnetMask();
				break;
			case 3:
				System.out.print("Inserisci l'indirizzo IP: ");
				String sAd2 = Utility.leggiString();
				System.out.print("Inserisci la Subnet Mask o Slash Notation: ");
				String subnet2 = Utility.leggiString();	
				
				Address ad2 = Address.stringtoAddressRemDot(sAd2);
				SubnetMask sm2;
				
				if(subnet2.length() <= 2) {
					sm2 = new SubnetMask(Integer.valueOf(subnet2));
				}else {
					Address sub2 = Address.stringtoAddressRemDot(subnet2);
					sm2 = new SubnetMask(SubnetMask.toSlashNotation(sub2));
				}
				
				IPAddress ipAddress2 = new IPAddress(ad2, sm2);
				IPAddress.findSubnetByIP(ipAddress2);
			}
			
		}while(opz != 0);
		System.out.println("\nCiao!");
	}

}
