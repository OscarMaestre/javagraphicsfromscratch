package io.github.oscarmaestre.graphicsfromscratch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MotorRender extends JPanel{

    
    private BufferedImage imagen;
    int ancho, alto;
    int mitadAncho, mitadAlto;
    public MotorRender(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        
        this.mitadAncho=this.ancho/2;
        this.mitadAlto =this.alto/2;
        imagen=new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        this.dibujarEscena();
    }
    
    public int getXVentana(int x){
        return this.mitadAncho+x;
    }
    public int getYVentana(int y){
        return this.mitadAlto-y;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imagen, null, null);
    }
    
    private void dibujarEscena(){
        
        int anchura = imagen.getWidth();
        int altura  = imagen.getHeight();
        for (int cx = 0; cx < anchura; cx++) {
            for (int cy = 0; cy < altura; cy++) {
                this.imagen.setRGB(cx, cy, Color.BLACK.getRGB());
            }
        }
        
        for (int x=0; x<100; x++){
            int xVentana=this.getXVentana(x);
            int yVentana=this.getYVentana(x);
            this.imagen.setRGB(xVentana, yVentana, Color.RED.getRGB());
        }
    }
}
