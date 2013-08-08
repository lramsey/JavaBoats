/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public class Fleet {
    Boat[] ships;
    String[] names;
    Fleet (String[] bnames) throws NoBoatsExistException
    {
        names = bnames;
        sortBoats();
        Boat[] ships = new Boat[bnames.length]; 
        for (int i = 0; i < bnames.length; i++)
         {
            if (bnames[i].charAt(0) == 'B' || bnames[i].charAt(0) == 'b' 
                    || bnames[i].charAt(0) == 'C' || bnames[i].charAt(0) == 'c' 
                    || bnames[i].charAt(0) == 'N' || bnames[i].charAt(0) == 'n')
            {
                ships[i] = new RaceBoat();
                ships[i].name = bnames[i];
            }
            else
            {
                ships[i] = new SailBoat();
                ships[i].name = bnames[i];
            }
          }
        this.ships = ships;
        setID();
        if (bnames.length == 0)
        {
            throw new NoBoatsExistException();
        }
     }
    
    void setID()
    {
        for (int i = 0; i < ships.length; i++)
        {
            int id = (int)(Math.random() * 89999 + 10000);
            for (int j = 0; j < i + 1; j++)
            {
                if (id == ships[j].id)
                {
                    id = (int)(Math.random() * 89999 + 10000);
                    j = 0;
                }
            }
            ships[i].id = id;
        }       
    }
    
    void displayBoatNames()
    {   
        System.out.println("Race Boats:");
        for(int i = 0; i < ships.length; i++)
        {
            if (ships[i].getClass() == RaceBoat.class)
            {
                if (ships[i].power)
                {
                    System.out.println(ships[i].toString() + "\n");
                }
                else
                {
                    ships[i].powerOffMessage();
                    System.out.println();
                }
            }
        }
        System.out.println("Sail Boats:");
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].getClass() == SailBoat.class)
            {
                if (ships[i].power)
                {
                    System.out.println(ships[i].toString() + "\n");
                }
                else
                {
                    ships[i].powerOffMessage();
                    System.out.println();
                }
            } 
        } 
    }
     
    void findBoatID(String bname)
    {
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].name.equals(bname))
            {
                System.out.println(bname + " Boat ID is " + ships[i].id + ".");
                return;
            }
            if (i == ships.length - 1)
                {
                    System.out.println(bname + " does not exist "
                            + "in the boat list.");
                }
            
        }
    }
    
    void setSpeed(String bname, int bspeed)
    {   
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].name.equals(bname))
            {
                if (ships[i].power)
                {
                    if (ships[i].speed < bspeed)
                    {
                        while (ships[i].speed < bspeed)
                        {
                        ships[i].goFaster();
                        }
                        if (ships[i].speed > bspeed)
                        {
                            System.out.println(bspeed + " mph is not a valid " 
                                    + "boat speed for " + bname + ". Current "  
                                    + "boat speed is " + ships[i].speed + 
                                    " mph.");
                        }
                    }
                    else if (ships[i].speed > bspeed)
                    {
                        while (ships[i].speed > bspeed)
                        {
                             ships[i].goSlower();
                        }
                        if (ships[i].speed < bspeed)
                        {
                            System.out.println(bspeed + " mph is not a valid "
                                    + "boat speed for " + bname + ". Current "
                                    + "boat speed is " + ships[i].speed + 
                                    " mph.");
                        }
                    }
                    return;
                }
                else
                {
                    ships[i].powerOffMessage();
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println(bname + " does not exist in the boat list.");
    }
    
    void setAngle(String bname, int bangle) 
    {       
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].name.equals(bname))
            {
                if (ships[i].power)
                {
                    if (ships[i].angle < bangle)
                    {
                        while (ships[i].angle < bangle)
                        {
                        ships[i].turnRight();
                        }
                        if (ships[i].angle > bangle)
                        {
                            System.out.println(bangle + " deg is not a valid "
                                    + "boat angle for " + bname + ". Current "
                                    + "boat angle is " + ships[i].angle + 
                                    " deg.");
                        }
                        return;
                    }
                    else if (ships[i].angle > bangle)
                    {
                        while (ships[i].angle > bangle)
                        {
                             ships[i].turnLeft();
                        }
                        if (ships[i].angle < bangle)
                        {
                            System.out.println(bangle + " deg is not a valid "
                                    + "boat angle for " + bname + ". Current "
                                    + "boat angle is " + ships[i].angle + 
                                    " deg.");
                        }
                        return;
                    }
                }
                else
                {
                    ships[i].powerOffMessage();
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println(bname + " does not exist in the boat list.");
    }
    
    void sortBoats()
    {
        java.util.Arrays.sort(names);
    }
    
    void turn(String bname, int direction) throws ArrayIndexOutOfBoundsException
    {
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].name.equals(bname))
            {
                if (ships[i].power)
                {
                    if (direction == 0)
                    {
                        ships[i].turnLeft();
                        return;
                    }
                    else if (direction == 1)
                    {
                        ships[i].turnRight();
                        return;
                    }
                    else
                    {
                        System.out.println("Invalid input. Enter "
                                + "BoatControl.left to turn left or "
                                + "BoatControl.right to turn right.");
                        return;
                    }
                }
                else
                {
                    ships[i].powerOffMessage();
                    System.out.println();
                    return;
                }
            }
            else if (i == ships.length - 1)
            {
                System.out.println(bname + " does not exist in the boat list.");
            }
        }
    }
    
    void powerOnOff(String bname, int powerState)
    {
        for (int i = 0; i < ships.length; i++)
        {
            if (ships[i].name.equals(bname))
            {
                if (powerState == 0)
                {
                    ships[i].powerOff();
                    return;
                }
                else if (powerState == 1)
                {
                    ships[i].powerOn();
                    return;
                }
                else
                {
                    System.out.println("Invalid input.  Enter BoatControl.off "
                            + "to power off or BoatControl.on to power on.");
                    return;
                }
            }
            else if (i == ships.length - 1)
            {
                System.out.println(bname + " does not exist in the boat list.");
            }
        }
    }    
}
