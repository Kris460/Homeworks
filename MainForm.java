

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MainForm extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 560;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    private MainForm mainForm;
    private Settings Settings;

    MainForm() {
        setTitle("TIC TAC TOE");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);

        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainGameField gameField = MainGameField.getInstance();
        JPanel buttonPanel = new JPanel(new GridLayout());
        add(gameField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Start new game");
        JButton btnEnd = new JButton("Exit");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);

        setBackground(Color.blue);

        setVisible(true);

        Settings = new Settings(this);

        btnEnd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start new game");
                Settings.setVisible(true);
            }
        });
    }
}