/* ID: 204424543
 * NAME: Pinhas Tevelev
 */

public class DogHouse {
	private String name;
	private Cage[] allCages;
	final int MAX_DOGS = 80;
	int nextId;

	public DogHouse(String name) {
		this.name = name;
		allCages = new Cage[20];
	}

	public int getDogsCount() {
		int count = 0;
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] != null) {
				count += allCages[i].getNumOfDogsInCage();
			}
		}
		return count;
	}

	public int getCagesCount() {
		int count = 0;
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] != null) {
				count++;
			}
		}
		return count;
	}

	public void makePriceStatment(Dog dog, int days) {
		double totalPrice = 0;
		double pricePerDay = (0.8 * dog.getWeight());
		if (pricePerDay > 30) {
			totalPrice = (pricePerDay) * days;

		} else {
			pricePerDay = 30;
			totalPrice = (pricePerDay * days);

		}
		System.out.println(dog.toString());
		System.out.println("need to pay " + totalPrice + "IS");
	}

	public boolean addDog(Dog dog) {
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] == null) {
				allCages[i] = new Cage();
				if (allCages[i].addDogToCage(dog)) {
					return true;
				}
			} else {
				if (allCages[i].addDogToCage(dog)) {
					return true;
				}
			}
		}
		return false;
	}

	public int outDog(int id, MyDate outDate) {
		int diff = 0;
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] != null) {
				for (int j = 0; j < 4; j++) {
					if (allCages[i].getDogs()[j] != null) {
						if (allCages[i].getDogs()[j].getId() == id) {
							diff = allCages[i].getDogs()[j].getDate().daysCount(outDate);
							allCages[i].getDogs()[j] = null;
							if (allCages[i].getNumOfDogsInCage() == 0) {
								allCages[i] = null;
							}
							return diff;
						}
					}
				}
			}
		}
		return -1;
	}

	public int getCage(Dog dog) {
		int check = 0;
		for (int i = 0; i < allCages.length; i++) {

			if (allCages[i].checkIfInCage(dog)) {
				check = allCages[i].getCageId();
				return check;
			}
		}
		return -1;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("In house " + name + " there are " + getDogsCount() + " dogs \n");
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] != null) {
				for (int j = 0; j < allCages[i].getNumOfDogsInCage(); j++) {
					if (allCages[i].getDogs()[j] != null) {
						sb.append(allCages[i].getDogs()[j].toString() + " is in cage number " + allCages[i].getCageId()
								+ "\n");
					}
				}
			}
		}
		sb.append("There are " + getCagesCount() + " cages\n");
		for (int i = 0; i < allCages.length; i++) {
			if (allCages[i] != null)
				sb.append(allCages[i].toString() + "\n");
		}
		return sb.toString();
	}

}
