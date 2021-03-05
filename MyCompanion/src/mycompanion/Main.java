/* Due to the physical limitations, this demonstration is using a webcam to detect motion instead of a PIR sensor */
/*Licensed files from https://github.com/sarxos  
under license - 
https://raw.githubusercontent.com/sarxos/webcam-capture/master/LICENSE.txt
*/
package mycompanion;
//Licensed Imports
import com.github.sarxos.webcam.Webcam;
// Class import
import Classes.Motion;


/**
 *
 * @author sukhm
 */
public class Main {

   
    public static void main(String[] args) {
        // TODO code application logic here
        new Motion(Webcam.getDefault()); // default webcam feed is passed to the Motion class's constructor.
      
    }
    
}
