/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal og Fredrik Bille
 * Date: 19-10-2020
 *
 * Description of program
 ********************************************/

public class Bil {

    private double acceleration;
    private Gear currentgear;
    private double odometer;
    private double currentRPM;
    private int maxRPM;
    private double currentSpeed;
    private double topSpeed;
    private Clutch clutchState;
    private Ignition ignitionState;
    enum Gear {
        REVERSE (-1),
        ZERO (0),
        ONE (1),
        TWO (2),
        THREE (3),
        FOUR (4),
        FIVE (5);

        Gear(int i) {
        }
    }
    enum Ignition {
        ON (true),
        OFF (false);

        Ignition(boolean b) {
        }

        boolean getState(Ignition thisIgnition) {
            if (thisIgnition.name().equals("ON")) {return true;}
            else {return false;}
        }
    }
    enum Clutch {
        DOWN (false),
        UP (true);

        Clutch(boolean b) {
        }

        boolean clutchBreak(Clutch currentState) {
            if (currentState.name().equals("UP")) {return true;}
            else {return false;}
        }
    }

    public Bil(double acceleration, double odometer, double currentRPM, int maxRPM, double currentSpeed, double topSpeed, Gear gear) {
        this.acceleration = acceleration;
        this.odometer = odometer;
        this.currentRPM = currentRPM;
        this.maxRPM = maxRPM;
        this.currentSpeed = currentSpeed;
        this.topSpeed = topSpeed;
        this.ignitionState = Ignition.OFF;
        this.clutchState = Clutch.UP;
        this.currentgear = gear;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getCurrentgear() {
        return currentgear.compareTo(Gear.ZERO);
    }

    public void setCurrentgear(Gear currentgear) {
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
        return ignitionState.getState(ignitionState);
    }

    public void setIgnitionState(Ignition ignitionState) {
        this.ignitionState = ignitionState;
    }

    public void setClutchState(Clutch clutchState) {
        this.clutchState = clutchState;
    }

    public void changeGear() {

        if (currentSpeed < 0) {
            currentgear = Gear.REVERSE;
        } else if (currentSpeed < 20) {
            currentgear = Gear.ONE;
        } else if (currentSpeed < 50) {
            currentgear = Gear.TWO;
        } else if (currentSpeed < 65) {
            currentgear = Gear.THREE;
        } else if (currentSpeed < 80) {
            currentgear = Gear.FOUR;
        } else {
            currentgear = Gear.FIVE;
        }

    }

    public void turnOn() {
        this.ignitionState = Ignition.ON;
        this.acceleration = 0;
    }

    public void turnOff() {
        this.ignitionState = Ignition.OFF;
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
        if (!(clutchState.clutchBreak(clutchState)) && ignitionState.getState(ignitionState)) {
            this.currentSpeed += this.acceleration;
        }
    }

}
