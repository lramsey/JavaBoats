/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public class RaceBoat extends Boat {
    
    void throttleForward()
    {
        if (power)
        {
            state = true;
        }
        else
        {
            powerOffMessage();
        }
    }
    void throttleBack()
    {
        if (power)
        {
            state = false;
        }
        else
        {
            powerOffMessage();
        }
    }
    
    @Override
    public void goFaster()
    {
        throttleForward();
        if (power)
        {
            speed += 2;
        }
    }
    
    @Override
    public void goSlower()
    {
        throttleBack();
        if (power)
        {
            speed -= 2;
            if (speed < 0)
            {
                speed = 0;
            }
        }
    }
    
    @Override
    public String whatIsBoatState()
    {
        String throttle;
        if (state == true)
        {
            throttle = "Throttle Forward";
        }
        else
        {
            throttle = "Throttle Back";
        }
        return throttle;
    }
    
    @Override
    public void turnRight()
    {
        if (power)
        {
            angle += 10;
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
            angle -= 10;
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
        if (power)
        {
            return name + " (" + id + ") is a Race Boat at the speed of " + speed
                + " mph (" + whatIsBoatState() + ") moving in " + direction()
                + "(" + angle + " deg)";
        }
        else
        {
            return name + " is powered off";
        }
    }        
}
