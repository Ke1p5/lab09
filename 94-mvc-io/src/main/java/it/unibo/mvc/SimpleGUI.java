package it.unibo.mvc;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "SimpleGUI";
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame(TITLE);
    private SimpleController controller = new SimpleController();

    public SimpleGUI() {

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        canvas.add(buttons, BorderLayout.SOUTH);
        JTextField field = new JTextField();
        canvas.add(field, BorderLayout.NORTH);
        JTextArea area = new JTextArea();
        canvas.add(area, BorderLayout.CENTER);
        JButton print = new JButton("Print");
        JButton show = new JButton("Show History");
        buttons.add(show, BorderLayout.NORTH);
        buttons.add(print, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String line = field.getText();
                System.out.println(line);
                controller.addPrintedStringToHistory(line);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                for (String line: controller.getStringHistory()) {
                    area.append(line + "\n");
                }
            }
        });

    }

    private void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenHeight = (int) screen.getHeight();
        final int screenWidth = (int) screen.getWidth();
        frame.setSize(screenWidth/PROPORTION, screenHeight/PROPORTION);
    
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
