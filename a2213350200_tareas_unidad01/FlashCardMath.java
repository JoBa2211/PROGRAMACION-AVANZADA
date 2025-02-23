package flashcardmath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.*;

public class FlashCardMath extends JFrame {

    JLabel triedLabel = new JLabel();
    JTextField triedTextField = new JTextField();
    JLabel correctLabel = new JLabel();
    JTextField correctTextField = new JTextField();
    JLabel problemLabel = new JLabel();
    JLabel dividerLabel = new JLabel();
    JPanel typePanel = new JPanel();
    JCheckBox[] typeCheckBox = new JCheckBox[4];
    JPanel factorPanel = new JPanel();
    ButtonGroup factorButtonGroup = new ButtonGroup();
    JRadioButton[] factorRadioButton = new JRadioButton[11];
    JPanel timerPanel = new JPanel();
    ButtonGroup timerButtonGroup = new ButtonGroup();
    JRadioButton[] timerRadioButton = new JRadioButton[3];
    JTextField timerTextField = new JTextField();
    JScrollBar timerScrollBar = new JScrollBar();
    JButton startButton = new JButton();
    JButton exitButton = new JButton();
    Timer problemsTimer;
    Font myFont = new Font("Arial", Font.PLAIN, 18);
    Color lightBlue = new Color(192, 192, 255);
    Random myRandom = new Random();
    int numberTried, numberCorrect;
    int correctAnswer, numberDigits;
    String problem;
    String yourAnswer;
    int digitNumber;
    int problemTime;

    public static void main(String args[]) {
        // create frame
        new FlashCardMath().show();
    }

    public FlashCardMath() {
        // frame constructor
        setTitle("Flash Card Math");
        getContentPane().setBackground(new Color(255, 255, 192));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;

        // Tried Label
        triedLabel.setText("Tried:");
        triedLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(triedLabel, gridConstraints);

        triedTextField.setText("0");
        triedTextField.setPreferredSize(new Dimension(90, 30));
        triedTextField.setEditable(false);
        triedTextField.setBackground(Color.RED);
        triedTextField.setForeground(Color.YELLOW);
        triedTextField.setHorizontalAlignment(SwingConstants.CENTER);
        triedTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(triedTextField, gridConstraints);

        // Correct Label
        correctLabel.setText("Correct:");
        correctLabel.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(correctLabel, gridConstraints);

        correctTextField.setText("0");
        correctTextField.setPreferredSize(new Dimension(90, 30));
        correctTextField.setEditable(false);
        correctTextField.setBackground(Color.RED);
        correctTextField.setForeground(Color.YELLOW);
        correctTextField.setHorizontalAlignment(SwingConstants.CENTER);
        correctTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(correctTextField, gridConstraints);

        // Problem Label
        problemLabel.setText("");
        problemLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        problemLabel.setPreferredSize(new Dimension(450, 100));
        problemLabel.setBackground(Color.WHITE);
        problemLabel.setOpaque(true);
        problemLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        problemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(problemLabel, gridConstraints);

        problemLabel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                problemLabelKeyPressed(e);
            }
        });

        // Divider Label
        dividerLabel.setPreferredSize(new Dimension(450, 10));
        dividerLabel.setBackground(Color.RED);
        dividerLabel.setOpaque(true);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 5;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(dividerLabel, gridConstraints);

        // Type Panel
        UIManager.put("TitledBorder.font", new Font("Arial", Font.BOLD, 14));
        typePanel.setPreferredSize(new Dimension(130, 130));
        typePanel.setBorder(BorderFactory.createTitledBorder("Type:"));
        typePanel.setBackground(lightBlue);
        typePanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(typePanel, gridConstraints);

        for (int i = 0; i < 4; i++) {
            typeCheckBox[i] = new JCheckBox();
            typeCheckBox[i].setBackground(lightBlue);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = i;
            gridConstraints.anchor = GridBagConstraints.WEST;
            typePanel.add(typeCheckBox[i], gridConstraints);
            typeCheckBox[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    typeCheckBoxActionPerformed(e);
                }
            });
        }

        typeCheckBox[0].setText("Addition");
        typeCheckBox[1].setText("Subtraction");
        typeCheckBox[2].setText("Multiplication");
        typeCheckBox[3].setText("Division");
        typeCheckBox[0].setSelected(true);

        // Factor Panel
        factorPanel.setPreferredSize(new Dimension(130, 130));
        factorPanel.setBorder(BorderFactory.createTitledBorder("Factor:"));
        factorPanel.setBackground(lightBlue);
        factorPanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(factorPanel, gridConstraints);

        int x = 2;
        int y = 0;

        for (int i = 0; i < 11; i++) {
            factorRadioButton[i] = new JRadioButton();
            factorRadioButton[i].setText(String.valueOf(i));
            factorRadioButton[i].setBackground(lightBlue);
            factorButtonGroup.add(factorRadioButton[i]);
            gridConstraints = new GridBagConstraints();

            if (i < 10) {
                gridConstraints.gridx = x;
                gridConstraints.gridy = y;
            } else {
                gridConstraints.gridx = 0;
                gridConstraints.gridy = 0;
                gridConstraints.gridwidth = 2;
            }

            gridConstraints.anchor = GridBagConstraints.WEST;
            factorPanel.add(factorRadioButton[i], gridConstraints);
            factorRadioButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    factorRadioButtonActionPerformed(e);
                }
            });
            x++;

            if (x > 2) {
                x = 0;
                y++;
            }
        }

        factorRadioButton[10].setText("Random");
        factorRadioButton[10].setSelected(true);

        // Timer Panel
        timerPanel.setPreferredSize(new Dimension(130, 130));
        timerPanel.setBorder(BorderFactory.createTitledBorder("Timer:"));
        timerPanel.setBackground(lightBlue);
        timerPanel.setLayout(new GridBagLayout());
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 4;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(0, 0, 0, 10);
        gridConstraints.anchor = GridBagConstraints.NORTH;
        getContentPane().add(timerPanel, gridConstraints);

        for (int i = 0; i < 3; i++) {
            timerRadioButton[i] = new JRadioButton();
            timerRadioButton[i].setBackground(lightBlue);
            timerButtonGroup.add(timerRadioButton[i]);
            gridConstraints = new GridBagConstraints();
            gridConstraints.gridx = 0;
            gridConstraints.gridy = i;
            gridConstraints.gridwidth = 2;
            gridConstraints.anchor = GridBagConstraints.WEST;
            timerPanel.add(timerRadioButton[i], gridConstraints);
            timerRadioButton[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    timerRadioButtonActionPerformed(e);
                }
            });
        }

        timerRadioButton[0].setText("Off");
        timerRadioButton[1].setText("On-Count Up");
        timerRadioButton[2].setText("On-Count Down");
        timerRadioButton[0].setSelected(true);

        timerTextField.setText("Off");
        timerTextField.setPreferredSize(new Dimension(90, 25));
        timerTextField.setEditable(false);
        timerTextField.setBackground(Color.WHITE);
        timerTextField.setForeground(Color.RED);
        timerTextField.setHorizontalAlignment(SwingConstants.CENTER);
        timerTextField.setFont(myFont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(5, 0, 0, 0);
        timerPanel.add(timerTextField, gridConstraints);

        timerScrollBar.setOrientation(Scrollbar.HORIZONTAL);
        timerScrollBar.setPreferredSize(new Dimension(120, 20));
        timerScrollBar.setMaximum(300);
        timerScrollBar.setMinimum(0);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        timerPanel.add(timerScrollBar, gridConstraints);
        timerScrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                timerScrollBarAdjustmentValueChanged(e);
            }
        });

        // Start Button
        startButton.setText("Start");
        startButton.setFont(myFont);
        startButton.setBackground(new Color(0, 255, 0));
        startButton.setPreferredSize(new Dimension(150, 40));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(startButton, gridConstraints);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed(e);
            }
        });

        // Exit Button
        exitButton.setText("Exit");
        exitButton.setFont(myFont);
        exitButton.setBackground(new Color(255, 0, 0));
        exitButton.setPreferredSize(new Dimension(150, 40));
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });

        pack();
        setVisible(true);
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    private void startButtonActionPerformed(ActionEvent e) {
        // Implement start button action here
    }

    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void typeCheckBoxActionPerformed(ActionEvent e) {
        // Implement type checkbox action here
    }

    private void factorRadioButtonActionPerformed(ActionEvent e) {
        // Implement factor radio button action here
    }

    private void timerRadioButtonActionPerformed(ActionEvent e) {
        // Implement timer radio button action here
    }

    private void timerScrollBarAdjustmentValueChanged(AdjustmentEvent e) {
        // Implement timer scroll bar adjustment action here
    }

    private void problemLabelKeyPressed(KeyEvent e) {
        // Implement problem label key press action here
    }
}
