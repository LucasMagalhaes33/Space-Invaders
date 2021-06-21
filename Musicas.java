/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author romul
 */
public class Musicas {
    public static void playMusic(String arquivo){
        InputStream musica;
        try{
            musica = new FileInputStream(new File(arquivo));
            AudioStream audio = new AudioStream(musica);
            AudioPlayer.player.start(audio);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
}
