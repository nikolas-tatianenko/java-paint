package com.tatianenko.nikolai.java.paint;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;


public class Canvas extends JComponent {

    // Image in which we're going to draw.
    private Image image;
    // Graphics2D object used to draw on.
    private Graphics2D g2;
    // Mouse coordinates.
    private int currentX, currentY, oldX, oldY;

    public Canvas() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Dragging mouse.
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    // Draw Line in case of g2 is not null.
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    // Refresh draw area to repaint.
                    repaint();
                    // Store current coords x,y as olds x,y.
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    // Paint Components.
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // Image to draw null ==> we create.
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // Enable antialiasing.
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Clear draw area.
            clear();
        }

        g.drawImage(image, 0, 0, null);
    }

    // Clear.
    public void clear() {
        g2.setPaint(Color.white);
        // Draw white on entire draw area to clear.
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    // @todo unify.
    // Set color.
    public void red() {
        // Apply red color on g2 context.
        g2.setPaint(Color.red);
    }

    public void black() {
        g2.setPaint(Color.black);
    }

    public void magenta() {
        g2.setPaint(Color.magenta);
    }

    public void green() {
        g2.setPaint(Color.green);
    }

    public void blue() {
        g2.setPaint(Color.blue);
    }
}
