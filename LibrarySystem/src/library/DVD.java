/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author adamt
 */
public class DVD extends LibraryItem {

    protected String producer;
    protected String languages;
    protected String subtitles;
    protected String actors;

    public DVD(String languages, String subtitles, String producer, String actors, int ISBN, String title, String sector, int pubDay, int pubMonth, int pubYear) {
        super(ISBN, title, sector, pubDay, pubMonth, pubYear);//adding the values from the parameter of the book constructor and putting it into the LibraryItem constructor or superclass.
        this.languages = languages;
        this.subtitles = subtitles;
        this.producer = producer;
        this.actors = actors;
    }
    //below are setters and getters which either sets values to the strings or retrieves the values of the strings.
    public String getLanguages() {

        return languages;
    }

    public String getSubtitles() {

        return subtitles;
    }

    public String getProducer() {

        return producer;
    }

    public String getActors() {

        return actors;
    }

    public void setLanguages(String languages) {

        this.languages = languages;

    }

    public void setSubtitles(String subtitles) {

        this.subtitles = subtitles;

    }

    public void setProducer(String producer) {

        this.producer = producer;

    }

    public void setActors(String actors) {

        this.actors = actors;

    }

    @Override
    public String getItemType() {
        return "DVD";//returns dvd to differentiate between book class.
    }
    
    
    public String toString() {//toString represents a string to the object DVD.

        return "Languages available: " + languages + ", Subtitles available: " + subtitles + ", Producer: " + producer + ", Actors: " + actors;

    }

    

    
}
