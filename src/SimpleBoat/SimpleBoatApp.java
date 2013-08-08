/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Luke
 */
public class SimpleBoatApp {
    public static void main (String[] args) {
       File boatsFile = new File 
               ("C:/Users/Luke/Documents/NetBeansProjects/BoatProject"
               + "/SimpleBoat/boatdir", "boats.txt");
       String[] boatNames = null;
       try
       {
           FileReader read = new FileReader(boatsFile);
           BufferedReader superRead = new BufferedReader(read);
           String line = null;
           int i = 0;
           while((line = superRead.readLine()) != null)
           {
               i++;
               if (i == 100)
               {
                   break;
               }
           }
           boatNames = new String [i];
           read = new FileReader(boatsFile);
           superRead = new BufferedReader(read);
           i = 0;
           String bname = null;
           while ((bname = superRead.readLine()) != null)
           {
               boatNames[i] = bname;
               i++;
           }
       }
       catch(IOException e)
       {
           e.printStackTrace(System.out);
       }
       
       Fleet armada = null;
       try
       {
           if (args.length != 0)
           {
               armada = new Fleet(args);
           }
           else
           {
               armada = new Fleet(boatNames);
           }
       }
       catch (NoBoatsExistException nope) 
       {
           System.out.println(nope.getMessage());
           System.exit(0);
       }
       System.out.println("Enter boat commands(or enter done to exit):");
       
       Scanner userPrompt = new Scanner(System.in).useDelimiter("\n");
       
       Outer:
       while(!userPrompt.hasNext("done"))
       {
           Inner:
           for (int i = 0; i < armada.ships.length; i++)
           {
               if (userPrompt.hasNext(armada.names[i] + ", power on"))
               {
                   armada.ships[i].powerOn();
                   System.out.println(armada.ships[i]);
                   break Inner;
               }
               else if (userPrompt.hasNext(armada.names[i] + ", power off"))
               {
                   armada.ships[i].powerOff();
                   System.out.println(armada.ships[i]);
                   break Inner;
               }
               else if (userPrompt.hasNext(armada.names[i] + ", speed up"))
               {
                   armada.ships[i].goFaster();
                   if (armada.ships[i].power)
                   {
                       System.out.println(armada.ships[i]);
                   }
                   break Inner;
               }
               else if (userPrompt.hasNext(armada.names[i] + ", slow down"))
               {
                   armada.ships[i].goSlower();
                   if (armada.ships[i].power)
                   {
                       System.out.println(armada.ships[i]);
                   }
                   break Inner;
               }
               else if (userPrompt.hasNext(armada.names[i] + ", turn left"))
               {
                   armada.ships[i].turnLeft();
                   if (armada.ships[i].power)
                   {
                       System.out.println(armada.ships[i]);
                   }
                   break Inner;
               }
               else if (userPrompt.hasNext(armada.names[i] + ", turn right"))
               {
                   armada.ships[i].turnRight();
                   if (armada.ships[i].power)
                   {
                       System.out.println(armada.ships[i]);
                   }
                   break Inner;
               }
           }
           String response = userPrompt.next();
       }
   }
}
