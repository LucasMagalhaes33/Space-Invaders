
package spaceinvaders;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Inimigo {
    private int x, y;
    private int largura, altura;
    private Image imagem;
    private boolean isVisivel;
    
    private static final int COMPRIMENTO_TELA = 500;
    private static int VELOCIDADE = 1;
    
    public Inimigo(int x, int y){
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("imagens\\nave2.gif");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        isVisivel = true;
    }
    
    public void movimentar(){
        if(this.y > 324){
            this.y = 0;
        } else {
            this.y += VELOCIDADE;
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
}
