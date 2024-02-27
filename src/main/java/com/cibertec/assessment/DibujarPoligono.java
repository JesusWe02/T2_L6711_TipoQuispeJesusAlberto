package com.cibertec.assessment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DibujarPoligono extends JPanel {
	// Coordenadas de los vértices del polígono
//    Double xpoint3[] = {10.0, 205.0, 305.0, 405.0, 500.0};
//    Double ypoint3[] = {10.0, 501.0, 506.0, 107.0, 30.0};
	// "[10, 205, 80, 401, 600]"
	// "[10, 501, 30, 107, 30]"
	

	Double xpoint3[] = {100.0, 605.0, 305.0, 405.0, 500.0};
	Double ypoint3[] = {100.0, 601.0, 506.0, 337.0, 300.0};
	// "[100, 605, 305, 405, 500]"
	// "[100, 601, 506, 337, 300]"
    
	//Square
	Double[] xpoint1 = {150.0, 250.0, 250.0, 150.0};
	Double[] ypoint1 = {100.0, 100.0, 200.0, 200.0};
	// "[150, 250, 250, 150]"
	// "[100, 100, 200, 200]"
	
    Double[] xpoint2 = {150.0, 250.0, 350.0, 300.0, 200.0};
    Double[] ypoint2 = {100.0, 0.0, 100.0, 200.0, 200.0};
    // "[150, 250, 350, 300, 200]"
 	// "[100, 0, 100, 200, 200]"
      
    //Double[] xpoint3 = {150.0, 250.0, 350.0, 350.0, 250.0, 150.0};
    //Double[] ypoint3 = {100.0, 50.0, 100.0, 200.0, 250.0, 200.0};
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar el polígono 
        g2d.setColor(Color.RED);
        g2d.drawPolygon(toIntArray(xpoint2), toIntArray(ypoint2), xpoint2.length);
        
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(toIntArray(xpoint3), toIntArray(ypoint3), xpoint3.length);
        
        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(toIntArray(xpoint1), toIntArray(ypoint1), xpoint1.length);
        
    }

    // Método para convertir Double[] a int[]
    private int[] toIntArray(Double[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i].intValue();
        }
        return intArray;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dibujar Polígono");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DibujarPoligono());
            frame.setSize(300, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
