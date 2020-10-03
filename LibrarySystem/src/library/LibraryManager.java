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
public interface LibraryManager {//interface class which only instanciate the methods which are implemented in the WestminsterLibraryManager class
     
    public abstract void addLibraryItem(LibraryItem library);
    public abstract void printItems();
    public abstract void deleteItem(int isbno);
    public abstract void borrowItem(int isbno);
    public abstract void returnItem(int isbno);
    public abstract void freeSpaces();
    public abstract boolean runMenu();
    public abstract void startGUI();
}
