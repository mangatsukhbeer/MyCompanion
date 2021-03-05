/*Licensed files from https://github.com/sarxos  
under license - 
https://raw.githubusercontent.com/sarxos/webcam-capture/master/LICENSE.txt
*/
package Classes;
//  Imports under license
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
//java imports
import java.io.BufferedInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *
 * @author sukhm
 */
public class Motion implements WebcamMotionListener{ //WebMotionListener detects the motion on webcam
    private int motionDetected = 0;
    private Webcam webcam; // Webcam object used to gather data from webcam
    private boolean audio = false; // boolean object audio will be used to determine whether system is playing audio or not
    
    public Motion(Webcam cam){ // constructor
        if(cam == null) throw new IllegalArgumentException("camera not available"); // in case if there is no webcam present 
        this.webcam = cam;
        this.init();
    }
    
    
    private void init(){
        webcam.setViewSize(WebcamResolution.VGA.getSize()); // get the video from webcam as VGa format and get its size
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setMirrored(false);
        panel.setImageSizeDisplayed(true);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        JFrame frame = new JFrame("Motion Detector");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        WebcamMotionDetector detector = new WebcamMotionDetector(webcam);
        detector.setInterval(100); // interval between motions - 100ms
        detector.setInertia(30); // Inertia of the motion
        detector.addMotionListener(this); // adding motion listener to this instance
        detector.start(); // detector started
    }
    public void motionDetected(WebcamMotionEvent wme) { // when a motion is detected
        System.out.println("Motion Detected"); // prints out motion detected
        playAudio(); // plays the audio file
        motionDetected++; // counts the motions detected
    }
    private void playAudio(){
        if(!audio){ //if the audio is not playing when the fucntion is called
            audio = true;
            new Thread("audio"){
                @Override
                public void run(){
                    try{
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/Content/Heartbeat.wav")))); // getting the file from content folder
                        Thread.sleep(clip.getMicrosecondLength()/1000);
                        audio = false;
                    }catch(LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e){
                        e.printStackTrace();
                    } 
                }
            }.start();// starts the thread
        }
    }
}
