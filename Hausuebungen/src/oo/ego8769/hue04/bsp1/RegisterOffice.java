package oo.ego8769.hue04.bsp1;

import java.util.ArrayList;

public class RegisterOffice {

	private ArrayList<MarriedCouples> _marriedCouples = new ArrayList<>();

	public RegisterOffice() {
		_marriedCouples = new ArrayList<>();
	}
	
	public RegisterOffice(MarriedCouples mc) {
		_marriedCouples= new ArrayList<>();
		_marriedCouples.add(mc);
	}
	

	public boolean marry(Person wife, Person husband, Person witnessWife, Person witnessHusband) {
		if (canMarri(wife, husband) && isLegalAge(witnessWife) && isLegalAge(witnessHusband)) {
			MarriedCouples marriedCouple = new MarriedCouples(wife, husband, witnessWife, witnessHusband);
			wife.set_marriedCouple(marriedCouple);
			husband.set_marriedCouple(marriedCouple);
			wife.changeSurName(husband);
			_marriedCouples.add(marriedCouple);
			return true;
		}
		return false;
	}

	/*public boolean divorce(Person wife, Person husband, String reson) {
		if (canDivorce(wife, husband, reson) ) {
			wife.set_marriedCouple(null);
			husband.set_marriedCouple(null);
			wife.changeBackToUnmarriedName();
			
			return true;
		}
		return false;
	}*/

	public boolean divorce(Person wife, Person husband, String reson) {// TODO finish me
		if (canDivorce(wife, husband,reson)) {
			wife.set_marriedCouple(null);
			wife.changeBackToUnmarriedName();
			return true;
		}return false;
	}
	public boolean canDivorce(Person wife, Person husband, String reason) {
		if (!reason.isEmpty() && !wife.isUnMarried() && !husband.isUnMarried()
				&& husband.equals(wife.getMarriedCouple().get_husband()))// && _marriedCouples.contains(wife) && _marriedCouples.contains(husband)
				 {
			return true;
		}
		return false;
	}
	

	public boolean canMarri(Person wife, Person husband) {
		if (isLegalAge(wife) && isLegalAge(husband) && wife.isUnMarried() && husband.isUnMarried() && wife.isFemale()
				&& !husband.isFemale()) {
			return true;
		}
		System.out.println("can�t marry");
		return false;
	}

	public boolean isLegalAge(Person person) {
		if (person.getAge() >= 18) {
			System.out.println("person legal age");
			return true;
		} else {
			System.out.println("person under age");
			return false;

		}
	}

}
