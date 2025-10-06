
public class PolymorphismTest {
	public static void main(String[] args) {
	/*	Doctor doctor = new Doctor();
		if(doctor instanceof Doctor) System.out.println("Yes it is a doctor...");
		
		System.out.println("--------------");
		doctor = new Surgeon(); //EVERY SURGEON IS A DOCTOR
		if(doctor instanceof Doctor) System.out.println("Yes it is a doctor...");
		if(doctor instanceof Surgeon) System.out.println("Yes it is a surgeon...");
		System.out.println("--------------");

		doctor = new HeartSurgeon();
		if(doctor instanceof Doctor) System.out.println("Yes it is a doctor...");
		if(doctor instanceof Surgeon) System.out.println("Yes it is a surgeon...");
		if(doctor instanceof HeartSurgeon) System.out.println("Yes it is a heart surgeon...");

		doctor.diagnose();
		doctor.diagnose(70);
		doctor.diagnose("Ear,Nose and Throat");
		doctor.diagnose(80, 75.5f);
		doctor.diagnose(65.7f, 85);
		System.out.println("==================");
	*/	
		Surgeon surgeon = new Surgeon();
		surgeon.diagnose();
		surgeon.diagnose(88);
		surgeon.diagnose("Ear");
		surgeon.diagnose(83.4f, 81);
		surgeon.diagnose(90, 76.5f);
		
		
	}
}
class Doctor {
	void diagnose() {
		System.out.println("Doctor is diagnosing...");
	}
	void diagnose(String ent) {
		System.out.println("Doctor is diagnosing..by checking...."+ent);
	}
	void diagnose(int beats) {
		System.out.println("Doctor is diagnosing..by checking....heart beats..."+beats);
	}
	void diagnose(int beats, float weight) {
		System.out.println("Doctor is diagnosing..by checking....heart beats..."+beats+ " and the current weight..."+weight);
	}
	void diagnose(float weight,int beats) {
		System.out.println("Doctor is diagnosing..by checking.... the current weight..."+weight+ " and heart beats..."+beats);
	}
}
class Surgeon extends Doctor {
	void diagnose() { // redefining the super class method | overriding
		System.out.println("Surgeon is diagnosing...with CT Scan report...");
	}
}
class HeartSurgeon extends Surgeon
{
	
}
