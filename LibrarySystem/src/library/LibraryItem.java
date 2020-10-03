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
public abstract class LibraryItem implements Comparable<LibraryItem>{
    
    private int ISBN;
    private String title;
    private String sector;
    
    private DateTime publicationDate;
    private DateTime borrowTime;
    private DateTime borrowDate;
    
    private Reader reader;

    //Created a constructor for the abstract LibraryItem class.
    public LibraryItem (int ISBN, String title, String sector, int pubDay, int pubMonth, int pubYear){
        this.publicationDate = new DateTime(pubDay, pubMonth, pubYear);
    
        this.ISBN=ISBN;
        this.title=title;
        this.sector=sector;
        this.publicationDate.setDay(pubDay);
        this.publicationDate.setMonth(pubMonth);
        this.publicationDate.setYear(pubYear);
        
    }
    //Below are the setters and getters for each object and primitives in this class
    public int getISBN() {

        return ISBN;
    }
        
    public String getTitle() {

        return title;
    }
    
    public String getSector() {

        return sector;
    }
        
    public DateTime getPublicationDate() {

        return publicationDate;
    }
    
    public DateTime getBorrowTime() {

        return borrowTime;
    }
    
    public DateTime getBorrowDate() {

        return borrowDate;
    }
    
    public Reader getReader() {

        return reader;
    }
    
    public void setISBM(int ISBN) {
        
        this.ISBN = ISBN;

    }
    
    public void setTitle(String title) {
        
        this.title = title;

    }
    
    public void setSector(String sector) {
        
        this.sector = sector;

    }
    
    public void setPublicationDate(DateTime publicationDate) {
        this.publicationDate=publicationDate;

    }
    
    public void setBorrowTime(DateTime borrowTime) {
        
        this.borrowTime=borrowTime;

    }
    
    public void setBorrowDate(DateTime borrowDate) {
        
        this.borrowDate=borrowDate;

    }
    
    public void setReader(Reader reader) {
        this.reader=reader;
    }
    
    public abstract String getItemType();//Used to retreive the type of item.
    
    @Override
    public int compareTo(LibraryItem o) {//Comparing two objects of the list item but, I haven't compared anything here.
        return 0;
        
    }
}
