/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public class SailBoat extends Boat {
    
    void raiseSail()
    {
        state = true;
    }
    
    void lowerSail()
    {
        state = false;
    }
    
    @Override
    public void goFaster()
    {
        if (power)
        {
            speed += 1;
            raiseSail();
        }
        else
        {
            powerOffMessage();
        }
    }
    
    @Override
    public void goSlower()
    {
        if (power)
        {
            speed -= 1;
            if (speed < 0)
            {
                speed = 0;                
            }
            lowerSail();
        }
        else
        {
            powerOffMessage();
        }
    }
    
    @ Override
    public String whatIsBoatState()
    {
        String sail;
        if (state == true)
        {
            sail = "Sail Up";
        }
        else
        {
            sail = "Sail Down";
        }
        return sail;
    }
    
    @Override
    public void turnRight()
    {
        if (power)
        {
            angle += 5;
        }
        else
        {
            powerOffMessage();
        }
    }
    
    @Override
    public void turnLeft()
    {
        if (power)
        {
            angle -= 5;
        }
        else
        {
            powerOffMessage();
        }
    }
    
    @Override
    public void powerOn()
    {
        power = true;
    }
    
    @Override
    public void powerOff()
    {
        power = false;
    }
    
    @Override
    public String toString()
    {
        if(power)
        {
            return name + " (" + id + ") is a Sail Boat at the speed of " + speed
                + " mph (" + whatIsBoatState() + ") moving in " + direction()
                + "(" + angle + " deg)";
        }
        else
        {
            return name + " is powered off";
        }
    }        
}
