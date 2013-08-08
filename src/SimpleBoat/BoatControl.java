/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public interface BoatControl {

    int left = 0;
    int right = 1;
    int off = 0;
    int on = 1;
    void powerOn();
    void powerOff();
    void turnRight();
    void turnLeft();
    void goFaster();
    void goSlower();
    String whatIsBoatState();       
}
