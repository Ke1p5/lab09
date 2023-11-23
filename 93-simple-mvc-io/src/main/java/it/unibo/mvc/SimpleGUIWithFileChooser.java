package it.unibo.mvc;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java Graphical Interface";
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame(TITLE);
    private Controller control = new Controller();

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel border = new JPanel();
        border.setLayout(new BorderLayout());
        
        final JTextField record = new JTextField();
        record.setText(control.getPath());
        record.setEditable(false);
        border.add(record, BorderLayout.CENTER);
        
        final JButton browse = new JButton("Browse...");
        border.add(browse, BorderLayout.LINE_END);

        canvas.add(border, BorderLayout.NORTH);
        final JTextArea text = new JTextArea();
        canvas.add(text, BorderLayout.CENTER);

        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                control.write(text.getText());
            }
        });

        browse.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showSaveDialog(border);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        File selected = chooser.getSelectedFile();
                        record.setText(selected.getName());
                        control.setCurrentFile(selected);
                    case JFileChooser.CANCEL_OPTION:
                        return;
                    default:
                        JOptionPane.showMessageDialog(border, "Selection not applicable, an error has occurred!");
                }
            }
        });
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        
        frame.setLocationByPlatform(true);
        frame.pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
