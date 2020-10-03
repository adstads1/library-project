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
public class Book extends LibraryItem {

    protected String author;
    protected String publisher;
    protected int totalNoPages;

    public Book(String author, String publisher, int totalNoPages, int ISBN, String title, String sector, int pubDay, int pubMonth, int pubYear) {
        super(ISBN, title, sector, pubDay, pubMonth, pubYear);//adding the values from the parameter of the book constructor and putting it into the LibraryItem constructor or superclass.
        this.author = author;
        this.publisher=publisher;
        this.totalNoPages = totalNoPages;
        
    }

    public String getAuthor() {

        return author;
    }

    public String getPublisher() {

        return publisher;
    }

    public int getTotalNoPages() {

        return totalNoPages;
    }

    public void setAuthor(String author) {
        
        this.author = author;

    }
    
    public void setPublisher(String publisher) {
        
        this.publisher = publisher;

    }
    
    public void setTotalNoPages(int totalNoPages) {
        
        this.totalNoPages = totalNoPages;

    }
    
    @Override
    public String getItemType() {//Used to differentiate from dvd.
        return "Book";
    }   
    
    public String toString() {//toString represents a string to the object Book.
        
        return "Authors: " + author + ", Publisher: " + publisher + ", Total number of pages" + totalNoPages;

    }

}
