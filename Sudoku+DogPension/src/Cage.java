/* ID: 204424543
 * NAME: Pinhas Tevelev
 */

public class Cage {

	final int maxCellWeight = 100;
	private Dog[] dogs;
	public static int cageNumber = 0;
	int cageId;

	public Cage() {
		this.cageId = (++cageNumber);
		this.dogs = new Dog[4];
		this.cageId = cageNumber;
	}

	public int getNumOfDogsInCage() {
		int counter = 0;
		for (int i = 0; i < dogs.length; i++) {
			if (dogs[i] != null)
				counter++;
		}
		return counter;
	}

	private boolean checkIfMaleInCage() {
		for (int i = 0; i < 4; i++) {
			if (dogs[i] != null) {
				if (dogs[i].isMale())
					return true;
			}
		}
		return false;
	}

	public boolean checkIfInCage(Dog dog) {
		for (int i = 0; i < 4; i++) {
			if (dogs[i] != null) {
				if (dogs[i].getId() == dog.getId())
					return true;
			}
		}
		return false;
	}

	public int getCageWeight() {
		int weight = 0;
		for (int i = 0; i < 4; i++) {
			if (dogs[i] != null) {
				weight += dogs[i].getWeight();
			}
		}
		return weight;
	}

	public boolean addDogToCage(Dog newDog) {
		if (newDog.isMale()) {
			if (!checkIfMaleInCage() && (newDog.getWeight() + getCageWeight() < maxCellWeight)
					&& !(checkIfInCage(newDog))) { // there is no male dog in cage
				for (int i = 0; i < 4; i++) {
					if (dogs[i] == null) {
						dogs[i] = newDog;
						return true;
					}
				}
			}

		} else { // got dog female
			if ((newDog.getWeight() + getCageWeight() < maxCellWeight) && !(checkIfInCage(newDog))) {
				for (int i = 0; i < 4; i++) {
					if (dogs[i] == null) {
						dogs[i] = newDog;
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean removeDog(Dog dog) {
		for (int i = 0; i < 4; i++) {
			if (dogs[i].getId() == dog.getId()) {
				dogs[i] = null;
				return true;
			}
		}
		return false;
	}

	public Dog[] getDogs() {
		return dogs;
	}

	public void setDogs(Dog[] dogs) {
		this.dogs = dogs;
	}

	public int getCageId() {
		return this.cageId;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(
				"In Cage " + getCageId() + " there are " + getNumOfDogsInCage() + " dogs" + "\n");
		for (int i = 0; i < dogs.length; i++) {
			if (dogs[i] != null) {
				sb.append(dogs[i].toString() + " is in cage number " + getCageId() + "\n");
			}
		}
		return sb.toString();
	}

}
