import java.util.ArrayList;
import java.util.List;

public class AssociationTest {
	public static void main(String[] args) {
		Cloth cloth1 = new Cloth("Jean","Blue","Casual",34,400);
		Cloth cloth2 = new Cloth("Shirt","Red","Formal",42,200);
		Cloth cloth3 = new Cloth("T-Shirt","Green","Casual",40,150);
		Cloth cloth4 = new Cloth("Kurtha","White","Traditional",40,350);
		Cloth cloth5 = new Cloth("Dhoti","White","Traditional",40,100);
		Cloth cloth6 = new Cloth("Jean","Blue","Casual",34,400);
		Cloth cloth7 = new Cloth("Shirt","Red","Formal",42,200);
		Cloth cloth8 = new Cloth("T-Shirt","Green","Casual",40,150);
		Cloth cloth9 = new Cloth("Kurtha","White","Traditional",40,350);
		Cloth cloth10 = new Cloth("Dhoti","White","Traditional",40,100);
		
		List<Cloth> fuzzyWash = new ArrayList<Cloth>();
		fuzzyWash.add(cloth1);
		fuzzyWash.add(cloth2);
		fuzzyWash.add(cloth3);
		fuzzyWash.add(cloth4);
		fuzzyWash.add(cloth5);
		fuzzyWash.add(cloth6);
		fuzzyWash.add(cloth7);
		fuzzyWash.add(cloth8);
		fuzzyWash.add(cloth9);
		
		
		WashingPowder washPowder = new WashingPowder("Ghadi","FrontLoad", 0.05f, 300.0f);
		Water water = new Water("SoftWater",60);
		Electricity electricity  = new Electricity("SEB", 6.2f, 3, 220);
		
		WashingMachine washingMachine= new WashingMachine();
		Laundry laundry = washingMachine.wash(washPowder,water,fuzzyWash,electricity);
		System.out.println("Laundry bill : "+laundry.getTotalBill());
		
	}
}

/*
 * 					Association
 * 						|
 * 				----------------------
 * 				|	|			|	|
 * 				isA	hasA	 usesA producesA
 * 			structural			operational/functional/behavioral	
 * 
*/
class Machine { }

class WashingMachine extends Machine {//isA   - Aggregation 
	
	WashingTub washingTub = new WashingTub(); //hasA - composition

								//uses		uses			uses		uses
	Laundry wash(WashingPowder washPowder, Water water, List<Cloth> clothArrayList, Electricity electricity) {
		System.out.println("-- Hi Washing Program started --");
		System.out.println("-- Calculating the load --");
		float totalWeight = 0;
		for (Cloth cloth : clothArrayList) {
			totalWeight += cloth.getWeight();
		}
		System.out.println("-- Total Weight of cloths -- "+totalWeight);
		System.out.println("Washing powder used : "+washPowder.getBrand()+ " brand, quantity used "+washPowder.getQuantity()+ " for "+washPowder.getWashType());
		System.out.println("Electricity used    : "+electricity.getType());
		System.out.println("Water used          : "+water.getQuantity());
		Laundry laundry = new Laundry();

		laundry.setElectricityBill(electricity.costPerUnit * electricity.getTotalUnitsUsed());
		laundry.setWaterBill(water.getQuantity() * 0.25f); //60*0.25
		laundry.setWashingPowederBill(washPowder.getPricePerKg() * washPowder.getQuantity());
		laundry.setServiceCharges(clothArrayList.size()*10);
		
		float total = laundry.getElectricityBill() + laundry.getServiceCharges() +
		laundry.getWashingPowederBill() + laundry.getWaterBill();
		laundry.setTotalBill(total);
		return laundry;
	}
	
	void rinse() {
		
	}
	void spin() {
		
	}
	
}
class Laundry {
	//electricity + water + washing powder + ironing + man power + service +
	float electricityBill;
	float waterBill;
	float washingPowederBill;
	float serviceCharges;
	float totalBill ;
	
	public float getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(float electricityBill) {
		this.electricityBill = electricityBill;
	}

	public float getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(float waterBill) {
		this.waterBill = waterBill;
	}

	public float getWashingPowederBill() {
		return washingPowederBill;
	}

	public void setWashingPowederBill(float washingPowederBill) {
		this.washingPowederBill = washingPowederBill;
	}

	public float getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(float serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	void printLaundryBill() {
		
	}
}

class Water { 
	String waterType; //hard/soft
	int quantity;
	public Water(String waterType, int quantity) {
		super();
		this.waterType = waterType;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Water [waterType=" + waterType + ", quantity=" + quantity + "]";
	}
	public String getWaterType() {
		return waterType;
	}
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
	
	
}

class Cloth { 
	String type; // cotton
	String color;
	String style; //bedsheet, tshirt, shirt, saree
	int size;
	float weight;
	boolean clean; //false
	
	public Cloth(String type, String color, String style, int size, float weight) {
		super();
		this.type = type;
		this.color = color;
		this.style = style;
		this.size = size;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Cloth [type=" + type + ", color=" + color + ", style=" + style + ", size=" + size + ", weight=" + weight
				+ "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
	
}

class Electricity {
	String type; 
	float costPerUnit;
	float totalUnitsUsed;
	float voltage;
	public Electricity(String type, float costPerUnit, float totalUnitsUsed, float voltage) {
		super();
		this.type = type;
		this.costPerUnit = costPerUnit;
		this.totalUnitsUsed = totalUnitsUsed;
		this.voltage = voltage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(float costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public float getTotalUnitsUsed() {
		return totalUnitsUsed;
	}
	public void setTotalUnitsUsed(float totalUnitsUsed) {
		this.totalUnitsUsed = totalUnitsUsed;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	@Override
	public String toString() {
		return "Electricity [type=" + type + ", costPerUnit=" + costPerUnit + ", totalUnitsUsed=" + totalUnitsUsed
				+ ", voltage=" + voltage + "]";
	}
	
	
	
}
class Tub { }
class WashingTub extends Tub { //isA
	
}
class Powder { }
class WashingPowder extends Powder {
	String brand; // ghadi/nirma/jadugar/././.
	String washType; // front/top/bucket 
	float quantity;
	float pricePerKg;
	public WashingPowder(String brand, String washType, float quantity, float pricePerKg) {
		super();
		this.brand = brand;
		this.washType = washType;
		this.quantity = quantity;
		this.pricePerKg = pricePerKg;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getWashType() {
		return washType;
	}
	public void setWashType(String washType) {
		this.washType = washType;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(float pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	@Override
	public String toString() {
		return "WashingPowder [brand=" + brand + ", washType=" + washType + ", quantity=" + quantity + ", pricePerKg="
				+ pricePerKg + "]";
	} 
	
	
}














class BathTub extends Tub { }

class Room { }
class BathRoom extends Room {
	BathTub bathTub = new BathTub();
	
}



