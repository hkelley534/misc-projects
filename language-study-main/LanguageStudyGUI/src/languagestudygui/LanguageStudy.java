package languagestudygui;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 * @author Hunter Kelley
 */
public class LanguageStudy{
    private final ArrayList<Word> wordList = new ArrayList<Word>();

    /**
     * Generates wordList from words and creates myGUI object
     */
    public LanguageStudy() {
        createNewWords();
        
        Window myGUI = new Window(wordList);
        myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUI.pack();
        myGUI.setVisible(true);
    }
   
    /**
    * Scans two files, creating words from the text and adding them to wordList
    */
    private void createNewWords() {
        try {
            Scanner sc = new Scanner(new File("english.txt"));
            Scanner sc2 = new Scanner(new File("spanish.txt"));
            for(int i=0;i<8;i++)
            {
                wordList.add(new Word(sc.nextLine(),sc2.nextLine()));
            }
        }catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }   
    }
}
