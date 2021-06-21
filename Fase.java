package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Nave nave;
    private Timer timer;
    private boolean emJogo;
    private List<Inimigo> inimigos;
    private int[][] coordenadas = 
    {{50, -100}, {150, -100}, {200, -100}, {250, -100}, {50, -100},
    {100, -70}, {150, -70}, {200, -70}, {150, -70}, {209, -70},
    {45, -40}, {70, -40}, {159, -40}, {80, -40}, {60, -40},
    {59, -10}, {30, -10}, {200, -10}, {259, -10}, {50, -10},
    {90, 20}, {220, 20}, {20, 20}, {180, 20}, {128, 20},
    {170, 50}, {30, 50}, {300, 50}, {328, 50}, {320, 50}};

    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        ImageIcon referencia = new ImageIcon("imagens\\fundo.png");
        fundo = referencia.getImage();
        nave = new Nave();
        emJogo = true;
        inicializaInimigos();
        Musicas.playMusic("src\\\\musica\\\\tema.wav");
        timer = new Timer(5, this);
        timer.start();
    }

    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < coordenadas.length; i++) {
            inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (emJogo) {
            List<Missil> misseis = nave.getMisseis();
            
            for (int i = 0; i < misseis.size(); i++) {
                Missil m = (Missil) misseis.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }
            for (int i = 0; i < inimigos.size(); i++) {
                Inimigo in = inimigos.get(i);
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }
            graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
            graficos.setColor(Color.WHITE);
            graficos.drawString("INIMIGOS: " + inimigos.size(), 5, 22);
        } else {
            ImageIcon fimJogo = new ImageIcon("imagens\\gameover.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0 , null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inimigos.size() == 0) {
            emJogo = false;
        }

        List<Missil> misseis = nave.getMisseis();

        for (int i = 0; i < misseis.size(); i++) {
            Missil m = (Missil) misseis.get(i);
            if (m.isIsVisivel()) {
                m.movimentar();
            } else {
                misseis.remove(i);
            }
        }

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo in = inimigos.get(i);
            if (in.isIsVisivel()) {
                in.movimentar();
            } else {
                inimigos.remove(i);
            }
        }

        nave.movimentar();
        checarColisoes();
        repaint();
    }

    public void checarColisoes() {
        Rectangle formaNave = nave.getBounds();
        Rectangle formaInimigo;
        Rectangle formaMissil;

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo tempInimigo = inimigos.get(i);
            formaInimigo = tempInimigo.getBounds();

            if (formaNave.intersects(formaInimigo)) {
                Musicas.playMusic("src\\\\musica\\\\colisaoInimigoMissel.wav");
                nave.setIsVisivel(false);
                tempInimigo.setIsVisivel(false);
                emJogo = false;
            }
        }

        List<Missil> misseis = nave.getMisseis();

        for (int i = 0; i < misseis.size(); i++) {
            Missil tempMissil = misseis.get(i);
            formaMissil = tempMissil.getBounds();

            for (int j = 0; j < inimigos.size(); j++) {
                Inimigo tempInimigo = inimigos.get(j);
                formaInimigo = tempInimigo.getBounds();

                if (formaMissil.intersects(formaInimigo)) {
                    Musicas.playMusic("src\\\\musica\\\\colisaoNaveMissel.wav");
                    tempMissil.setIsVisivel(false);
                    tempInimigo.setIsVisivel(false);
                }
            }
        }

    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                emJogo = true;
                nave = new Nave();
                inicializaInimigos();
                
            }
            nave.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            nave.keyReleased(e);
            
        }

    }
}
