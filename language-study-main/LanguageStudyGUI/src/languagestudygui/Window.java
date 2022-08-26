package languagestudygui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.util.ArrayList;
/**
 * @author Hunter Kelley
 */

public class Window extends JFrame implements ActionListener {
    private ArrayList<Word> wordList = new ArrayList<Word>();
    private Word word;
    private JPanel titlePanel;
    private JLabel wordLabel;
    private JLabel topField;
    private JTextField translateField;
    private final Random r = new Random();
    private int randomInt;
    private boolean randomBoolean;
    private Timer timer = new Timer(5000, this);
    private Timer timer2 = new Timer(3000, new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        resetTranslationFields();
      }});
    
    /**
     * Creates GUI elements with correct layout, assigning ActionListener for TextField, JButton, and 5 second timer 
     * 
     * @param wordList list of all translation words
     */
    public Window(ArrayList<Word> wordList) {
        this.wordList = wordList;
        randomInt = r.nextInt(8);
        randomBoolean = r.nextBoolean();
        word = wordList.get(randomInt);
        
        GridBagConstraints layoutConstr = null;
        titlePanel = new JPanel(new GridBagLayout());
        
        setTitle("LanguageGUI");
        setPreferredSize(new Dimension(450,150));
        setLayout(new GridBagLayout());
        
        topField = new JLabel("Type the translation into the field below.");
        layoutConstr = new GridBagConstraints();
        layoutConstr.gridx = 2;
        layoutConstr.gridy = 0;
        layoutConstr.insets = new Insets(10,10,10,10);
        add(topField, layoutConstr);
        
        if(randomBoolean){
        wordLabel = new JLabel(word.getEnglish());
        } else {
        wordLabel = new JLabel(word.getSpanish());
        }
        
        layoutConstr = new GridBagConstraints();
        layoutConstr.gridx = 1;
        layoutConstr.gridy = 1;
        layoutConstr.insets = new Insets(10,10,10,10);
        add(wordLabel, layoutConstr);
        
        translateField = new JTextField(15);
        translateField.setEditable(true);
        translateField.addActionListener(this);
        
        layoutConstr = new GridBagConstraints();
        layoutConstr.gridx = 2;
        layoutConstr.gridy = 1;
        layoutConstr.insets = new Insets(10,10,10,10);
        add(translateField, layoutConstr);
        
        JButton button = new JButton("OK");
        button.addActionListener(this);
        
        layoutConstr = new GridBagConstraints();
        layoutConstr.gridx = 3;
        layoutConstr.gridy = 1;
        layoutConstr.insets = new Insets(10,10,10,10);
        add(button, layoutConstr);
        
        timer.setRepeats(false);
        timer.start();
    }
    /**
     * Chooses next random word and language, resetting the GUI elements and starting a 5 second timer
     */
    public void resetTranslationFields() {
        randomInt = r.nextInt(8);
        randomBoolean = r.nextBoolean();
        word = wordList.get(randomInt);
        
        if(randomBoolean){
        wordLabel.setText(word.getEnglish());
        } else {
        wordLabel.setText(word.getSpanish());
        }
        
        topField.setText("Type the translation into the field below.");
        translateField.setText(null);
        translateField.setEditable(true);
        
        timer.setRepeats(false);
        timer.start();
    }
    
    @Override
    /**
     * Starts 3 second timer and changes display to show correct or incorrect answer based on button click, enter, or 5 second delay
     * Calls resetTranslationFields after 3 seconds
     */
    public void actionPerformed(ActionEvent e) {
        timer2.setRepeats(false);
        timer2.start();
        
        translateField.setEditable(false);     
        String userWord = translateField.getText();
        
        if(randomBoolean){
            if(userWord.equalsIgnoreCase(word.getSpanish())){
                topField.setText("Correct!");
            } else {
                topField.setText("Incorrect! Answer: " + word.getSpanish());
            }       
        } else {
            if(userWord.equalsIgnoreCase(word.getEnglish())){
                topField.setText("Correct!");
            } else {
                topField.setText("Incorrect! Answer: " + word.getEnglish());
            }    
        }   
    }
}

