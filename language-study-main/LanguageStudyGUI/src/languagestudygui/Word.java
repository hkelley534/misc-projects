package languagestudygui;

/**
 * @author Hunter Kelley
 */
public class Word {
 
    private String english;
    private String spanish;
   
    public Word(String english, String spanish) {
        this.english = english;
        this.spanish = spanish;
    }
    
    /**
     * Get the value of spanish
     *
     * @return the value of spanish
     */
    public String getSpanish() {
        return spanish;
    }

    /**
     * Set the value of spanish
     *
     * @param spanish new value of spanish
     */
    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    /**
     * Get the value of english
     *
     * @return the value of english
     */
    public String getEnglish() {
        return english;
    }

    /**
     * Set the value of english
     *
     * @param english new value of english
     */
    public void setEnglish(String english) {
        this.english = english;
    }

}
