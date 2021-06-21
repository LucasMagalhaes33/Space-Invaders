
package spaceinvaders;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Missil {
    private int x, y;
    private int largura, altura;
    private Image imagem;
    private boolean isVisivel;
    
    private static final int COMPRIMENTO_TELA = 400;
    private static final int VELOCIDADE = 2;
    
    public Missil(int x, int y){
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("imagens\\missil.png");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        this.isVisivel = true;
    }
    
    public void movimentar(){
        this.y -= VELOCIDADE;
        if(this.y > COMPRIMENTO_TELA){
            this.isVisivel = false;
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
