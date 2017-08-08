package com.tatianenko.nikolai.java.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NickPaint {

    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;
    Canvas canvas;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            // @todo unify.
            if (e.getSource() == clearBtn) {
                canvas.clear();
            } else if (e.getSource() == blackBtn) {
                canvas.black();
            } else if (e.getSource() == blueBtn) {
                canvas.blue();
            } else if (e.getSource() == greenBtn) {
                canvas.green();
            } else if (e.getSource() == redBtn) {
                canvas.red();
            } else if (e.getSource() == magentaBtn) {
                canvas.magenta();
            }
        }
    };

    public static void main(String[] args) {
        new NickPaint().show();
    }

    public void show() {

        JFrame frame = new JFrame("Nick Paint");
        Container content = frame.getContentPane();

        // Set layout on content pane.
        content.setLayout(new BorderLayout());

        // Create draw area.
        canvas = new Canvas();

        // Add to content pane.
        content.add(canvas, BorderLayout.CENTER);

        // Create controls to apply colors and call clear feature.
        JPanel controls = new JPanel();

        clearBtn = this.prepareColorButton("clear", controls);
        blackBtn = this.prepareColorButton("black", controls);
        blueBtn = this.prepareColorButton("blue", controls);
        greenBtn = this.prepareColorButton("green", controls);
        redBtn = this.prepareColorButton("red", controls);
        magentaBtn = this.prepareColorButton("magenta", controls);

        // Add controls to panel.
        content.add(controls, BorderLayout.NORTH);

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton prepareColorButton(String buttonName, JPanel controls) {
        JButton button = new JButton(buttonName);
        button.addActionListener(actionListener);
        controls.add(button);
        return button;
    }
}
