
package mycompanion;

import Classes.Motion;
import com.github.sarxos.webcam.Webcam;

/**
 *
 * @author sukhm
 */
public class Main {

   
    public static void main(String[] args) {
        // TODO code application logic here
        new Motion(Webcam.getDefault());
      
    }
    
}
