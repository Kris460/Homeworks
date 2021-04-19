import javafx.scene.layout.Background;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends JFrame {

    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 250;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 9;

    private static final String FIELD_SIZE_PREFIX = "The field size is: ";
    private static final String WIN_LENGTH_PREFIX = "The win length is: ";

    private JRadioButton radioButtonModeTwoPlayers;
    private JRadioButton radioButtonModeAgainstAI;
    private JSlider jSlider;
    private JSlider slFieldSize;
    private JSlider slWinLength;

    private MainForm mainForm;
    private MainGameField gameField;

    Settings gameSettingsForm = this;

    public Settings(MainForm mainForm) {
        this.mainForm = mainForm;
        setTitle("New game settings");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle mainFormBounds = this.mainForm.getBounds();
        int positionX = (int) mainFormBounds.getCenterX() - WINDOW_WIDTH / 2;
        int positionY = (int) mainFormBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(positionX, positionY);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(12, 1));

        addGameModeControls();
        addAILevel();
        addFieldSize();
        startGame();
    }

    private void addGameModeControls() {
        add(new JLabel("Choose the game mode: "));

        radioButtonModeTwoPlayers = new JRadioButton("Player vs Player");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        radioButtonModeAgainstAI = new JRadioButton("Player vs Computer");
        add(radioButtonModeAgainstAI);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);

        radioButtonModeAgainstAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeAgainstAI.isSelected()) {
                    jSlider.setVisible(true);
                }
            }
        });

        radioButtonModeTwoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeTwoPlayers.isSelected()) {
                    jSlider.setVisible(false);
                }
            }
        });

    }


    private void addAILevel() {
        add(new JLabel("Choose the level of AI:"));
        jSlider = new JSlider(0, 2, 0);
        add(jSlider);
        jSlider.setAlignmentX(CENTER_ALIGNMENT);
        jSlider.setVisible(false);

    }

    private void addFieldSize() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);

        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slWinLength.setMaximum(currentValue);
            }
        });

        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slWinLength.getValue());
            }
        });

        add(new JLabel("Choose the Field Size"));
        add(lbFieldSize);
        add(slFieldSize);

        add(new JLabel("Choose the winning length"));
        add(lbWinLength);
        add(slWinLength);

    }

    private void startGame() {

        JButton jButtonSetSettings = new JButton("Start!");
        add(jButtonSetSettings);

        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SIZE = slFieldSize.getValue();
                int WINLength = slWinLength.getValue();
                gameField = MainGameField.getInstance();
                gameField.startNewGame(SIZE, WINLength);
                if (radioButtonModeAgainstAI.isSelected()) {
                    gameField.gameMode = 2;
                }
                gameField.aiLevel = jSlider.getValue();
                gameSettingsForm.setVisible(false);
            }
        });
    }
}