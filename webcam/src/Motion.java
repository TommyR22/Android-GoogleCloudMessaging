import java.io.IOException;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;

/**
 * Detect motion. This example demonstrates of how to use build-in motion
 * detector feature. We simply run separate thread
 * and check every 1000 milliseconds if there was a motion. In this example
 * motion once detected is valid for 2 seconds.
 * 
 * @author Tommaso Ruscica
 */

public class Motion implements WebcamMotionListener {

	public Motion(Webcam w) {
		final WebcamMotionDetector detector = new WebcamMotionDetector(w.getDefault());
		detector.setInterval(1000); // one check per 1000 ms
		detector.addMotionListener(this);
		detector.start();
		
		Thread t = new Thread("motion-printer") {
			
			@Override
			public void run() {
				do {
					System.out.println(detector.isMotion());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						break;
					}
				} while (true);
			}
		};
		t.setDaemon(true);
		t.start();
		
	}

	@Override
	public void motionDetected(WebcamMotionEvent wme) {
		System.out.println("Detected motion");
		
		//Send message to Device Android
		String apiKey = "Insert here Your API Key";
        Content content = createContent();

        POST2GCM.post(apiKey, content);
	}
	
	public static Content createContent(){

        Content c = new Content();

        //Id Device and text message 
        //You can add here your RegistrationID for GCM
        c.addRegId("Insert here your regID of device");
        c.createData("MESSAGE RECEIVED FROM SERVER", "Motion Detected!!!");

        return c;
    }

}