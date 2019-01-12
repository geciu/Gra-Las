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

public class Muzyka {

    Muzyka(){
        super();
    }

    public static void playMusic(String filepath){
        InputStream music;


        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
}
