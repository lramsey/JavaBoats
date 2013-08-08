/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleBoat;

/**
 *
 * @author Luke
 */
public class NoBoatsExistException extends Exception {

    public NoBoatsExistException() 
    {
    }

    public NoBoatsExistException(String msg) {
        super(msg);
    }
    
        @Override
    public String getMessage()
    {
        return "No boat names are passed to the application";
    }
}
