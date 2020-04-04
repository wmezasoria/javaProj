package test.audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.tritonus.share.sampled.convert.TAudioInputStream;

public class Duracion {

	public static void main(String[] args) {
		try{
		File file = new File("C:/Temp/primera.mp3");
		getDurationWithMp3Spi(file);
//		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
//		AudioFormat format = audioInputStream.getFormat();
//		long frames = audioInputStream.getFrameLength();
//		double durationInSeconds = (frames+0.0) / format.getFrameRate();  
//		System.out.println("Duracion " + durationInSeconds + " seg");
		} catch (IOException e) {
			e.printStackTrace();
		
		} catch (UnsupportedAudioFileException w) {
			w.printStackTrace();
		}
		
		
	}
	
	
//	private static void getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {
//	    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
//	    if (fileFormat instanceof TAudioFileFormat) {//Tritonuss
//	        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
//	        String key = "duration";
//	        Long microseconds = (Long) properties.get(key);
//	        System.out.println(microseconds);
//	        String hms = String.format("%02d:%02d:%02d", TimeUnit.MICROSECONDS.toHours(microseconds),
//	                TimeUnit.MICROSECONDS.toMinutes(microseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MICROSECONDS.toHours(microseconds)),
//	                TimeUnit.MICROSECONDS.toSeconds(microseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MICROSECONDS.toMinutes(microseconds)));
//	        System.out.println(hms);
//	        
//	    } else {
//	        throw new UnsupportedAudioFileException();
//	    }
//
//	}

	
	private static void getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {
		InputStream iStream = new FileInputStream(file);
	    AudioInputStream fileFormat = AudioSystem.getAudioInputStream(iStream);
//	    AudioFileFormat fileFormat2 = AudioSystem.getAudioFileFormat(iStream);
//	    if (fileFormat instanceof TAudioInputStream) {//Tritonuss
	        Map<?, ?> properties = ((TAudioInputStream) fileFormat).properties();
	        String key = "duration";
	        Long microseconds = (Long) properties.get(key);
	        System.out.println(microseconds);
//	        int mili = (int) (microseconds / 1000);
//	        int sec = (mili / 1000) % 60;
//	        int min = (mili / 1000) % 60;
//	        int hor = ((mili / 1000) / 60)/60;
//	        System.out.println("time = "+hor+" : " + min + ":" + sec);
	        String hms = String.format("%02d:%02d:%02d", TimeUnit.MICROSECONDS.toHours(microseconds),
	                TimeUnit.MICROSECONDS.toMinutes(microseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MICROSECONDS.toHours(microseconds)),
	                TimeUnit.MICROSECONDS.toSeconds(microseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MICROSECONDS.toMinutes(microseconds)));
	        System.out.println(hms);
	        
//	    } else {
//	        throw new UnsupportedAudioFileException();
//	    }

	}
}
