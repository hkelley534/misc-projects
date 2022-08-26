
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 * A class to generate randomized TextPost objects
 * @author *Your name*
 * @version 1.0
 */
public class PostGenerator {
    private final ArrayList<User> users;
    private final Random rng;
    
    private File[] images;
    private String[] captions;
    private String[] texts;
    
    /**
     * Constructor for PostGenerator class
     * @param users An ArrayList of User objects 
     */
    public PostGenerator(ArrayList<User> users)
    {
        // Assign users field
        this.users = users; 
        
        // Instantiate the Random object
        rng = new Random();
        
        
        /*
         * Get the images, image captions, and texts
         */
        
        // Get the images
        File imageDirectory = new File("resources/images/");
        images = imageDirectory.listFiles();
        
        // Strip off the 1st file because that's the caption file
        images = Arrays.copyOfRange(images, 1, images.length);
        
        // Get the captions
        captions = new String[images.length];
        try {
            Scanner scan = new Scanner(new File("resources/images/captions.txt"));
            for(int i=0;i<captions.length;i++)
            {
                captions[i] = scan.nextLine();
            }
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        
        // Get the texts
        try {
            Scanner scan = new Scanner(new File("resources/text_posts.txt"));
            int count=0;
            while(scan.hasNextLine())
            {
                count++;
                scan.nextLine();
            }
            texts = new String[count];
            scan = new Scanner(new File("resources/text_posts.txt"));
            for(int i=0;i<count;i++)
            {
                texts[i] = scan.nextLine();
            }       
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Getter method for images field
     * @return A file array that holds all the image files
     */
    public File[] getImages() {return images;}
    
    /**
     * Setter method for images field
     * @param images a File array that holds image files
     */
    public void setImages(File[] images) {this.images = images;}

    /**
     * Getter method for captions field
     * @return String array that holds the caption for each image
     */
    public String[] getCaptions() {return captions;}
    
    /**
     * Setter method for captions field
     * @param captions String array that has a caption for each image
     */
    public void setCaptions(String[] captions) {this.captions = captions;}
    
    /**
     * Getter method for texts field
     * @return String array hold the text to use for TextPost objects
     */
    public String[] getTexts() {return texts;}
    
    /**
     * Setter method for text field
     * @param texts String array with the text for TextPost objects
     */
    public void setTexts(String[] texts) {this.texts = texts;}

    
    // *** generateTextPost ***
    /**
     * Returns a TextPost object with the given date and time whose text is chosen at random from the texts field
     * @param user The user for the post
     * @param date The date for the post
     * @param time The time for the post
     * @return TextPost object
     */
    
    
    // *** generateImagePost ***
    /**
     * Returns an ImagePost object with the given date and time whose image is chosen at random from the images field
     * @param user The user for the post
     * @param date The date for the post
     * @param time The time for the post
     * @return ImagePost object
     */
    
    
    // *** getMonthStr ***
    /** 
     * Returns a String representing a month of the year, e.g., "Jan" when month = 0, "Feb" when month = 1, etc.
     * @param month an int in range [0,12]
     * @return String returning the month
     */   
    
    
    
    
    /**
     * This method should generate one Post object that has its fields randomized based on the collection of texts and images in the PostGenerators fields.
     * @return Post object with randomized fields
     */
    public Post generateSinglePost()
    {
        
    }
    
    /**
     * This method should return an array of randomized Post objects. Hint: The method should utilize the generateSinglePost method.
     * @param num number of Post objects to generate
     * @return An array of Post objects with length equal to num
     */
    public Post[] generatePosts(int num)
    {
    
    }
    
}
