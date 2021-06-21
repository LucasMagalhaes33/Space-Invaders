
package spaceinvaders;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Nave {
    private int x, y;
    private int somaX, somaY;
    private int largura, altura;
    private boolean isVisivel;
    private Image imagem;
    private List<Missil> misseis;
    
    public Nave(){
        misseis = new ArrayList<Missil>();
        ImageIcon referencia = new ImageIcon("imagens\\nave.gif");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura =  imagem.getWidth(null);
       
        this.x = 200;
        this.y = 300;
    }
    
    public void movimentar(){
        //System.out.println(x + ", " + y);
        x += this.somaX; // -12 e 442
        y += this.somaY; // 0 e 324
        
        if(this.x < -12){
            x = -12;
        }
        
        if(this.x > 442){
            x = 442;
        }
        
        if(this.y < 0){
            y = 0;
        }
        
        if(this.y > 324){
            y = 324;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSomaX() {
        return somaX;
    }

    public void setSomaX(int somaX) {
        this.somaX = somaX;
    }

    public int getSomaY() {
        return somaY;
    }

    public void setSomaY(int somaY) {
        this.somaY = somaY;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public List<Missil> getMisseis() {
        return misseis;
    }

    public void setMisseis(List<Missil> misseis) {
        this.misseis = misseis;
    }
    
    public void atirar(){
        this.misseis.add(new Missil((int) (x + ( (double) largura/2.7)), y + altura/4));
        Musicas.playMusic("src\\\\musica\\\\missel.wav");
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public void keyPressed(KeyEvent tecla){
        
        int codigo = tecla.getKeyCode();
        
        
        if(codigo == KeyEvent.VK_UP){
            somaY = -1;
        }
        
        if(codigo == KeyEvent.VK_DOWN){
            somaY = 1;
        }
        
        if(codigo == KeyEvent.VK_LEFT){
            somaX = -1;
        }
        
        if(codigo == KeyEvent.VK_RIGHT){
            somaX = 1;
        }
        if(codigo == KeyEvent.VK_SPACE){
            atirar();
        }
    }
    
    public void keyReleased (KeyEvent tecla){
        
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_UP){
            somaY = 0;
        }
        
        if (codigo == KeyEvent.VK_DOWN){
            somaY = 0;
        }
        
        if(codigo == KeyEvent.VK_LEFT){
            somaX = 0;
        }
        
        if(codigo == KeyEvent.VK_RIGHT){
            somaX = 0;
        }
    }
    
}
