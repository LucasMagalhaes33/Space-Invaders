
package spaceinvaders;

import javax.swing.JFrame;

public class Painel extends JFrame {
    
    public Painel(){
        add(new Fase());
        setTitle("Space Invaders");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
