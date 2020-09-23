/* ID: 204424543
 * NAME: Pinhas Tevelev
 */

public class Dog {

	private String name;
	private int id;
	private int weight;
	private String kind;
	private boolean isMale;
	private MyDate date;
	public static int startId = 100;

	public Dog(int weight, boolean isMale, MyDate date, String name, String kind) {
		this.isMale = isMale;
		this.kind = kind;
		this.name = name;
		this.date = date;
		this.id = startId;
		if (weight < 5) {
			this.weight = 5;
		} else {
			this.weight = weight;
		}
		startId++;
	}

	public String getName() {
		return this.name;
	}

	public MyDate getDate() {
		return this.date;
	}

	public int getId() {
		return this.id;
	}

	public boolean isMale() {
		if (this.isMale) {
			return true;
		} else {
			return false;
		}
	}

	public int getWeight() {
		return this.weight;
	}

	public String toString() {
		if (this.isMale) {
			return "Dog id " + id + " " + name + " of type " + kind + " weights " + weight + " male "
					+ "enter to dog house on " + date.toString();
		} else {
			return "Dog id " + id + " " + name + " of type " + kind + " weights " + weight + " female "
					+ "enter to dog house on " + date.toString();
		}
	}

}
