import junit.framework.TestCase;

/********************************************
 * Project description
 *
 * Created by: Lasse J. Kongsdal
 * Date: 19-10-2020
 *
 * Description of program
 ********************************************/

public class BilTest extends TestCase {

    Bil bilTest;

    public void setup() {
        bilTest = new Bil(0,0,0, 0, 5000, 0, 164);
    }

    public void testStart() {
        setup();
        assertTrue(bilTest.startEngine());
    }

    public void testStop() {
        setup();
        assertFalse(bilTest.stopEngine());
    }

    public void testBreak() {
        setup();
        bilTest.setCurrentSpeed(100);
        bilTest.breakFoot();
        assertEquals((double) 80, bilTest.getCurrentSpeed());
        assertEquals((double) 0, bilTest.getAcceleration());
    }

    public void testClutch() {
        setup();
        bilTest.setCurrentSpeed(100);
        bilTest.setAcceleration(6);
        bilTest.cluth();
        assertEquals((double) 0, bilTest.getCurrentSpeed());
        assertEquals((double) 0, bilTest.getAcceleration());
    }

    public void testaccelerate(){
        setup();
        bilTest.setAcceleration(10);
        bilTest.accelerate();
        assertEquals((double) 10, bilTest.getCurrentSpeed());

        bilTest.accelerate();
        assertEquals((double) 20, bilTest.getCurrentSpeed());

        bilTest.accelerate();
        assertEquals((double) 30, bilTest.getCurrentSpeed());

        bilTest.accelerate();
        assertEquals((double) 40, bilTest.getCurrentSpeed());
    }

    public void testChangeGear() {
        setup();
        int lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(-5);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());

        lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(10);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());

        lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(45);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());

        lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(60);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());

        lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(70);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());

        lastGear = bilTest.getCurrentgear();
        bilTest.setCurrentSpeed(100);
        bilTest.changeGear();
        assertNotSame(lastGear, bilTest.getCurrentgear());
    }

    public void testTurnOn() {
        setup();
        bilTest.turnOn();
        assertTrue(bilTest.isIgnitionState());
        assertEquals((double) 0, bilTest.getAcceleration());
        assertEquals(0, bilTest.getCurrentgear());
        assertEquals((double) 0, bilTest.getCurrentRPM());
        assertEquals((double) 0, bilTest.getCurrentSpeed());
    }

    public void testTurnOff() {
        setup();
        bilTest.turnOff();
        assertFalse(bilTest.isIgnitionState());
        assertEquals((double) 0, bilTest.getAcceleration());
        assertEquals(0, bilTest.getCurrentgear());
        assertEquals((double) 0, bilTest.getCurrentRPM());
        assertEquals((double) 0, bilTest.getCurrentSpeed());
    }

}
