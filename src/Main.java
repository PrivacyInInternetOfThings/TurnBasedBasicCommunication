import java.util.ArrayList;

public class Main {

	public static double proportionVehicleType = 0.3;
	public static double proportionEmergencyType = 0.45;
	public static double proportionMalfunctionType = 0.1;
	public static double proportionNumberPeople = 0.15;

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(VEHICLETYPE.ORDINARY, EMERGENCYTYPE.NOEMERGENCY, MALFUNCTIONTYPE.NOMALFUNCTION, 1);
		Vehicle v2 = new Vehicle(VEHICLETYPE.EMERGENCY, EMERGENCYTYPE.PATIENT, MALFUNCTIONTYPE.NOMALFUNCTION, 4);
		Vehicle v3 = new Vehicle(VEHICLETYPE.ORDINARY, EMERGENCYTYPE.NOEMERGENCY, MALFUNCTIONTYPE.WHEEL, 3);
		Vehicle v4 = new Vehicle(VEHICLETYPE.ORDINARY, EMERGENCYTYPE.LATEFORWORK, MALFUNCTIONTYPE.NOMALFUNCTION, 1);
		Vehicle v5 = new Vehicle(VEHICLETYPE.ORDINARY, EMERGENCYTYPE.LATEFORSCHOOL, MALFUNCTIONTYPE.NOMALFUNCTION, 14);

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(v1);
		vehicles.add(v2);
		vehicles.add(v3);
		vehicles.add(v4);
		vehicles.add(v5);
		for (int i = 0; i < vehicles.size(); i++) {
			for (int j = i + 1; j < vehicles.size(); j++) {
				System.out.println("v1 = Vehicle " + (i + 1) + " v2 = Vehicle " + (j + 1));
				int result = makeNegotiation(vehicles.get(i), vehicles.get(j));
				if (result == 1) {
					System.out.println("Vehicle " + (i + 1) + " gets priority");
				} else {
					System.out.println("Vehicle " + (j + 1) + " gets priority");
				}
				System.out.println("v1 lostPrivacy: " + vehicles.get(i).lostPrivacy + " v2 lostPrivacy: "
						+ vehicles.get(j).lostPrivacy);
				vehicles.get(i).clear();
				vehicles.get(j).clear();
				System.out.println();
			}
		}
	}

	public static int makeNegotiation(Vehicle v1, Vehicle v2) {
		// turn based negotiation
		double utility1 = 0, utility2 = 0;
		System.out.println("Vehicle " + 1);
		utility1 += v1.makeOffer();
		System.out.println("Vehicle " + 2);
		utility2 += v2.makeOffer();
		System.out.println(" V1: " + utility1 + " V2: " + utility2);
		if (utility1 > utility2) {
			return 1;
		} else if (utility1 < utility2) {
			return 2;
		}
		System.out.println("Vehicle " + 1);
		utility1 += v1.makeOffer();
		System.out.println("Vehicle " + 2);
		utility2 += v2.makeOffer();
		if (utility1 > utility2) {
			return 1;
		} else if (utility1 < utility2) {
			return 2;
		}
		System.out.println("Vehicle " + 1);
		utility1 += v1.makeOffer();
		System.out.println("Vehicle " + 2);
		utility2 += v2.makeOffer();
		if (utility1 > utility2) {
			return 1;
		} else if (utility1 < utility2) {
			return 2;
		}
		System.out.println("Vehicle " + 1);
		utility1 += v1.makeOffer();
		System.out.println("Vehicle " + 2);
		utility2 += v2.makeOffer();
		if (utility1 >= utility2) {
			return 1;
		} else {
			return 2;
		}

	}
}
