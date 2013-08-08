/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public abstract class Boat implements BoatControl {
    String name = "Unknown";
    Boolean state = false;
    int id = 0;
    int speed = 0;
    Boolean power = false;
    int angle = 0;
    
    @Override
    abstract public void goFaster();
   
    @Override
    abstract public void goSlower();
    
    @Override
    abstract public String whatIsBoatState();
    
    @Override
    abstract public void turnRight();
    
    @Override
    abstract public void turnLeft();
    
    @Override
    abstract public String toString();
    
    @Override
    abstract public void powerOn();
    
    @Override
    abstract public void powerOff();

    void powerOffMessage()
    {
        if (!power)
        {
            System.out.println(name + " is powered off");
        }
        
    }
    
    String direction()
    {
        String direction;
        int normalAngle = angle;
        while (normalAngle > 360) 
        {
            normalAngle -= 360;
        }
        while (normalAngle < 0)
        {
            normalAngle += 360;
        }
        if (normalAngle >= 350 || normalAngle < 10)
        {
            direction = "NORTH";
        }
        else if (normalAngle >= 10 && normalAngle < 80)
        {
            direction = "NORTH EAST";
        }
        else if (normalAngle >= 80 && normalAngle < 100)
        {
            direction = "EAST";
        }
        else if (normalAngle >= 100 && normalAngle < 170)
        {
            direction = "SOUTH EAST";
        }
        else if (normalAngle >= 170 && normalAngle < 190)
        {
            direction = "SOUTH";
        }
        else if (normalAngle >= 190 && normalAngle < 260)
        {
            direction = "SOUTH WEST";
        }
        else if (normalAngle >= 260 && normalAngle < 280){
            direction = "WEST";
        }
        else
        {
            direction = "NORTH WEST";
        }
        angle = normalAngle;
        return direction;
    } 
}
