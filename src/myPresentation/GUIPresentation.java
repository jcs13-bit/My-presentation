package myPresentation;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIPresentation extends JFrame {
    private Listener listener;
    public GUIPresentation() {
        initGUI();
        this.setTitle("My presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        listener = new Listener();
        title = new Title("Jose's presentation", Color.gray);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("My hobby");
        myExpectations = new JButton("My expectations");
        myExpectations.setFocusable(false);
        containerButtons = new JPanel();
        containerButtons.addKeyListener(listener);
        containerButtons.setFocusable(true);
        containerIMages = new JPanel();
        containerIMages.addKeyListener(listener);
        containerIMages.setFocusable(true);
        imageLabel = new JLabel();
        expectativesText = new JTextArea(12, 12);
        containerIMages.setBorder(BorderFactory.createTitledBorder(null, "About me",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.MONOSPACED, Font.PLAIN, 20), Color.BLACK));


        containerIMages.add(imageLabel);
        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);

        containerButtons.add(myExpectations);
        myHobby.addMouseListener(listener);
        myHobby.setFocusable(false);
        myPhoto.addMouseListener(listener);
        myPhoto.setFocusable(false);



        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerIMages, BorderLayout.CENTER);
    }

    private JButton myPhoto, myHobby, myExpectations;
    private Title title;
    private JPanel containerButtons, containerIMages;


    private JLabel imageLabel;

    private JTextArea expectativesText;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIPresentation myGui = new GUIPresentation();
            }
        });
    }

    private class Listener implements MouseListener, MouseMotionListener, KeyListener {

        private ImageIcon image;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                imageLabel.setIcon(null);
                expectativesText.setText("My expectations from the course are to learn a little more about Java \n" +
                        " and tips that will help me in the programming industry.");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.black);
                containerIMages.add(expectativesText);
                revalidate();
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 && e.getSource() == myHobby) {
                this.image = new ImageIcon(getClass().getResource("/resources/hobby.jpg"));
                imageLabel.setIcon(this.image);
            } else if (e.getSource() == myPhoto) {
                this.image = new ImageIcon(getClass().getResource("/resources/me.jpg"));
                imageLabel.setIcon(this.image);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {


        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {


        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }
}
