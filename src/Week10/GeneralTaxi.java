package Week10;

public class GeneralTaxi extends Taxi{
    double farePerKilometer;
    double baseDistance;
    double baseFee;
    public GeneralTaxi(int carNum, double farePerKilo) {
        super(carNum);
        this.farePerKilometer = farePerKilo;
        baseFee = baseDistance = 3;
    }

    @Override
    public String toString() {
        return "General Taxi - " + super.toString();
    }

    @Override
    public double getPaid(double dis) {
        double dist = dis-baseDistance;
        if(dist <= 0) {
            return baseFee;
        } else {
            return baseFee + dist*farePerKilometer;
        }
    }


}
