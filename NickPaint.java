package com.tatianenko.nikolai.java.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NickPaint {

}    ActionListener actionListener = new ActionListener() {
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
