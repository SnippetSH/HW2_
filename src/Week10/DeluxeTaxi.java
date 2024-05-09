package Week10;

public class DeluxeTaxi extends Taxi{
    double farePerKilometer;
    double baseDistance;
    double baseFee;
    public DeluxeTaxi(int carNum, double farePerKilo) {
        super(carNum);
        this.farePerKilometer = farePerKilo;
        baseFee = 5;
        baseDistance = 3;
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
