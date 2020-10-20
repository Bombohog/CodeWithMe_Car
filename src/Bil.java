/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 19-10-2020
 *
 * Description of program
 ********************************************/

public class Bil {

    private double acceleration;
    private int currentgear;
    private double odometer;
    private double currentRPM;
    private int maxRPM;
    private double currentSpeed;
    private double topSpeed;
    private boolean ignitionState;

    public Bil(double acceleration, int currentgear, double odometer, double currentRPM, int maxRPM, double currentSpeed, double topSpeed) {
        this.acceleration = acceleration;
        this.currentgear = currentgear;
        this.odometer = odometer;
        this.currentRPM = currentRPM;
        this.maxRPM = maxRPM;
        this.currentSpeed = currentSpeed;
        this.topSpeed = topSpeed;
        this.ignitionState = false;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getCurrentgear() {
        return currentgear;
    }

    public void setCurrentgear(int currentgear) {
        this.currentgear = currentgear;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getCurrentRPM() {
        return currentRPM;
    }

    public void setCurrentRPM(double currentRPM) {
        this.currentRPM = currentRPM;
    }

    public double getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public boolean isIgnitionState() {
        return ignitionState;
    }

    public void setIgnitionState(boolean ignitionState) {
        this.ignitionState = ignitionState;
    }

    public void changeGear() {

        if (currentSpeed < 0) {
            currentgear = -1;
        } else if (currentSpeed < 20) {
            currentgear = 1;
        } else if (currentSpeed < 50) {
            currentgear = 2;
        } else if (currentSpeed < 65) {
            currentgear = 3;
        } else if (currentSpeed < 80) {
            currentgear = 4;
        } else {
            currentgear = 5;
        }

    }

    public void turnOn() {
        this.ignitionState = true;
        this.acceleration = 0;
    }

    public void turnOff() {
        this.ignitionState = false;
        this.acceleration = 0;
    }

    public boolean startEngine() {
        turnOn();
        return true;
    }

    public boolean stopEngine() {
        turnOff();
        return false;
    }

    public void breakFoot() {
        this.currentSpeed = currentSpeed * 0.80;
        this.setAcceleration(0);
    }

    public void cluth() {
        this.setCurrentSpeed(0);
        this.setAcceleration(0);

    }

    public void accelerate() {
        this.currentSpeed += this.acceleration;
    }
}
