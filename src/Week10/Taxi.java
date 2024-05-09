package Week10;

public abstract class Taxi {
    int carNum;
    double distance;
    double income;
    public Taxi(int carNum) {
        this.carNum = carNum;
        this.distance = 0;
        this.income = 0;
    }

    @Override
    public String toString() {
        return "Taxi Number: " + carNum + ", Total Distance: " + distance + ", Total Income: " + income;
    }
    public abstract double getPaid(double distance);
    public void doDrive(double dis) {
        distance += dis;
        income += getPaid(dis);
    }
    public boolean earnMore(Taxi t) {
        return this.income > t.income;
    }
}
