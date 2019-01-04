package las;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.File;
import javax.swing.JOptionPane;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {

    Music(){
        super();
    }

    public static void playMusic(){
        InputStream music;

        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;

        try {
            BGM = new AudioStream(new FileInputStream("PayDay.mp3"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }

        MGP.start(loop);
    }
}
