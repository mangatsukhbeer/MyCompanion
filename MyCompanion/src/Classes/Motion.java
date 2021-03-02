
package Classes;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
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
public class Motion implements WebcamMotionListener{
    private int motionDetected = 0;
    private Webcam webcam;
    private boolean audio = false;
    
    public Motion(Webcam cam){
        if(cam == null) throw new IllegalArgumentException("camera not available");
        this.webcam = cam;
        this.init();
    }
    
    
    private void init(){
        webcam.setViewSize(WebcamResolution.VGA.getSize());
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
        detector.setInterval(100);
        detector.setInertia(30);
        detector.addMotionListener(this);
        detector.start();
    }
    public void motionDetected(WebcamMotionEvent wme) {
        System.out.println("Motion Detected");
        playAudio();
        motionDetected++;
    }
    private void playAudio(){
        if(!audio){
            audio = true;
            new Thread("audio"){
                @Override
                public void run(){
                    try{
                        Clip clip = AudioSystem.getClip();
                        clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/Content/Heartbeat.wav"))));
                        Thread.sleep(clip.getMicrosecondLength()/1000);
                        audio = false;
                    }catch(LineUnavailableException | IOException | UnsupportedAudioFileException | InterruptedException e){
                        e.printStackTrace();
                    } 
                }
            }.start();
        }
    }
}
