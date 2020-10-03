/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.*;
import java.util.ArrayList;
//import org.joda.time;
/**
 *
 * @author adamt
 */
public class InstituteLibraryManager implements LibraryManager {

    ArrayList<LibraryItem> list;//create an arraylist of type LibraryItem
    private int bookCounter=0;
    private int dvdCounter=0;
    private int numBook = 100;
    private int numDVD = 50;
    private int totalItems = numBook + numDVD;
    

    public InstituteLibraryManager(int bookLength, int dvdLength, int totalLength) {
        this.numBook = bookLength;
        this.numDVD = dvdLength;
        this.totalItems = totalLength;
        list = new ArrayList<LibraryItem>();
        
    }

    @Override
    public void addLibraryItem(LibraryItem library) {
        String bookStr = "Book";
        String dvdStr = "DVD";
                
        if (bookStr.equals(library.getItemType())) {//if the user types in the string book and it equals the return type string which is a book then do the below.
            if(list.size()>=totalItems){//checks if the amount of spaces is below or equal to 150
                    System.out.println("The item list is full");
                }
                else if(bookCounter <= numBook){//checks if the amount of spaces for books is below or equal to 50.
                         list.add(library);
                         bookCounter++;//increment the counter which stores the number of books.
                    
                }
                else if(bookCounter >= numBook){//if the list is full
                    System.out.println("The Book list is full");
                    }
        
        }
        else if (dvdStr.equals(library.getItemType())) {
                if(list.size()>=totalItems){
                    System.out.println("The item list is full");
                }
                else if(dvdCounter < numDVD){
                         list.add(library);
                         dvdCounter++;
                    
                }
                else if(dvdCounter >= numDVD){
                    System.out.println("The DVD list is full");
                    }
        }
        else{System.out.println("You can only add either a book or DVD.");}//If string entered doesn't match to book or dvd.
        freeSpaces();

    }

    @Override
    public void printItems() {//scans the list of each object in the array.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemType().equals("Book")) {//If the item in the array list has the string Book in the getItemType method in the class book, then display the information about it.
                System.out.println("ISBN: " + list.get(i).getISBN() + ", Type: Book" + ", Title: " + list.get(i).getTitle());
            }
            if (list.get(i).getItemType().equals("DVD")) {
                System.out.println("ISBN: " + list.get(i).getISBN() + ", Type: DVD," + " Title: " + list.get(i).getTitle());
            }
        }
    }

    @Override
    public void deleteItem(int isbno) {
         for (int i = 0; i < list.size(); i++) {//scans the list of each object in the array.
             
             if(list.get(i).getReader() != null){//if the item has is being borrowed then you cannot delete the item.
                 System.out.println("Item cannot be deleted as it is being borrowed");
             }
             else if(list.get(i).getISBN()==isbno){
                 
                 if (list.get(i).getItemType().equals("Book")){//if the item type is a book then increase the amount of spaces for books. Same thing for dvd.
                     bookCounter--;
                     System.out.println("Item type:"+list.get(i).getItemType() + " has been removed");
                 }
                 else if (list.get(i).getItemType().equals("DVD")) {
                     dvdCounter--;
                     System.out.println("Item type:" + list.get(i).getItemType() + " has been removed");
                 }
                 list.remove(i);//removes the item from the list.
             }
             
             else{//Any other number where the system cannot match the isbn number entered.
                 System.out.println("You entered an isbn number not from the list, please try again");
             }
             freeSpaces();//Output the amount of spaces of items in the system.
         
         }
    }
    
    @Override
    public void borrowItem(int isbno) {

        for(int i=0; i <list.size(); i++){//Scans the list
            
            if(list.get(i).getISBN()==isbno){//If the isbn of the object matches the isbn entered by the user then do the following code within the if statement.
                if(list.get(i).getReader() == null){//If there is no data about a reader then start the process of adding a reader within the if statement.
                    System.out.println("Item is available to be borrowed, please follow the steps below to borrow the item\n");
                    Scanner s = new Scanner(System.in);
                    System.out.println("Enter the ID of the borrower: ");
                    int borrowerID= s.nextInt();
                    s.nextLine();
                    System.out.println("Enter the name of the borrower: ");
                    String borrowerName= s.nextLine();
                    
                    System.out.println("Enter the mobile number of the borrower: ");
                    int borrowerMn=s.nextInt();
                    s.nextLine();
                    System.out.println("Enter the email address of the borrower: ");
                    String borrowerEl= s.nextLine();
                    
                    System.out.println("Enter the borrowed day: ");
                    int borrowDay=s.nextInt();
                    
                    System.out.println("Enter the borrowed month: ");
                    int borrowMonth=s.nextInt();
                    
                    System.out.println("Enter the borrowed year: ");
                    int borrowYear=s.nextInt();
                    
                    System.out.println("Enter the borrowed hour: ");
                    int borrowHour=s.nextInt();
                    
                    System.out.println("Enter the borrowed minute: ");
                    int borrowMinute=s.nextInt();
                    
                    Reader r= new Reader(borrowerID, borrowerName, borrowerMn, borrowerEl);//Created a reader object which stores the values entered by the user for a reader.
                    list.get(i).setReader(r);//set the information entered in the reader object into that list object i. Same thing applied for the borrDate object and borrowTime object.
                    
                    DateTime borrowDate= new DateTime(borrowDay, borrowMonth, borrowYear);
                    list.get(i).setBorrowDate(borrowDate);
                    
                    DateTime borrowTime= new DateTime(borrowHour, borrowMinute);
                    list.get(i).setBorrowTime(borrowTime);
                    
                    
                }
                else if(list.get(i).getReader() != null){//If the item has data inside it (is currently being borrowed) then, display the date it will be available.
                    if(list.get(i).getItemType().equals("Book")){
                        
                        int addCurrentBookDays=list.get(i).getBorrowDate().getDay()+7;//Variable stores the day borrowed and adds 7 to it. This is only for the item type book.
                        String borrowBkDueDayString = String.format("%02d/", addCurrentBookDays);//Convert the int value to a string so it can be formatted as a date. Same thing with the month.
                        
                        int addCurrentBookMonth=list.get(i).getBorrowDate().getMonth();
                        String borrowDueMonthString = String.format("%02d/", addCurrentBookMonth);
                        
                        System.out.println("Item isn't available to borrow and is available to borrow on: "+ borrowBkDueDayString + borrowDueMonthString + list.get(i).getBorrowDate().getYear()+ ", At: "+ list.get(i).getBorrowTime().getHour()+":"+list.get(i).getBorrowTime().getMinutes());
                    }
                    else if(list.get(i).getItemType().equals("DVD")){//If the item type is a dvd.
                        int addCurrentDVDDays=list.get(i).getBorrowDate().getDay()+3;//Adds three days to the item type dvd only
                        
                        String borrowDVDDueDayString = String.format("%02d/", addCurrentDVDDays);//format the int value to a date format.
                        
                        int addCurrentDVDMonth=list.get(i).getBorrowDate().getMonth();
                        String borrowDVDDueMonthString = String.format("%02d/", addCurrentDVDMonth);
                        
                        System.out.println("Item isn't available to borrow and is available to borrow on: "+ borrowDVDDueDayString + borrowDVDDueMonthString + list.get(i).getBorrowDate().getYear() + ", At: "+ list.get(i).getBorrowTime().getHour()+":"+list.get(i).getBorrowTime().getMinutes());
                    }
                }
            }
            else if(list.get(i).getISBN()!=isbno){//If the isbn entered doesn't match.
                System.out.println("You've entered an ISBN number of an item that doesn't exist in our system, please try again");
            }
            
            
        
            }
            
            
    }
    
    @Override
    public void returnItem(int isbno){
    
        for(int i=0; i <list.size(); i++){//Scans the list
            if(list.get(i).getISBN()==isbno){
                
                 if(list.get(i).getReader() == null){//if the item is is available to borrow.
                    System.out.println("You've entered an item that isn't currently borrowed");
                }
                
                 else if(list.get(i).getReader() != null){
                     //Commented code is an attempt to add a fee but I encountered to many problems.
//                    Scanner s = new Scanner(System.in);
//                    
//                    System.out.println("Please enter the current day: ");
//                    int returnDay=s.nextInt();
//                    
//                    System.out.println("Enter enter the current month: ");
//                    int returnMonth=s.nextInt();
//                    
//                    System.out.println("Enter enter the current year: ");
//                    int returnYear=s.nextInt();
//                    
//                    System.out.println("Enter enter the current hour: ");
//                    int returnHour=s.nextInt();
//                    
//                    System.out.println("Enter enter the current minute: ");
//                    int returnMinute=s.nextInt();
//                    
//                    
////                        int addCurrentBookDays=list.get(i).getBorrowDate().getDay()+7;
////                        int addCurrentBookHour=list.get(i).getBorrowDate().getHour();
////                        int addCurrentBookMin=list.get(i).getBorrowDate().getMinutes();
////                        borrowDay
//        
//
//                            SimpleDateFormat returnDateConvert= new SimpleDateFormat("dd-MM-YYYY HH:mm");
//                            String dateReturnStr= Integer.toString(returnDay + returnMonth + returnYear + returnHour + returnMinute);
//                            
//                            String borrowedDateStr= Integer.toString(list.get(i).getBorrowDate().getDay()+list.get(i).getBorrowDate().getMonth()+list.get(i).getBorrowDate().getYear()+ list.get(i).getBorrowDate().getHour()+list.get(i).getBorrowDate().getMinutes());
//                            
//                            int addReturnByDay=list.get(i).getBorrowDate().getDay()+3;
//                            String borrowedDueDateOverThee=Integer.toString(addReturnByDay+list.get(i).getBorrowDate().getMonth()+list.get(i).getBorrowDate().getYear()+ list.get(i).getBorrowDate().getHour()+list.get(i).getBorrowDate().getMinutes());
//                            
//                            
//                            
//                        try {
//                            Date dateRn = returnDateConvert.parse(dateReturnStr);
//                            Date dateBr = returnDateConvert.parse(borrowedDateStr);
//                            Date dateDueDateOverThree = returnDateConvert.parse(borrowedDueDateOverThee);
//                            
//                            if(dateRn.before(dateDueDateOverThree)){
//                            double days=72*0.02;
//                            
//                            //counter to add days put into the for loop?
//                            //for loop to check if borrowdate==returndate entered maybe?
//                            for( )
//                                    {
//                                list.get(i).getBorrowDate().setDay(list.get(i).getBorrowDate().getDay()+1);//incre
//                                
//                                //24*counter
//                                //time
//                                //new time- old time. difference. If the difference is -
//                                //new variable that holds the time time differnce. Add the time counter * 0.2
//                            }
//                                
//                            }
//                            
//                            else if(dateRn.after(dateDueDateOverThree)){
//                            //int feeBfThree=72*0.03;
//                            } 
//                        } catch (ParseException ex) {
//                            System.out.println("Date entered is invalid.");
//                        }
//                                               
//                             
//                    
//                    //if(list.get(i).getBorrowDate())
//                  //  {
//                    
//                   // }
                    
                    
                    list.get(i).setReader(null);//Sets the data for a reader to null (makes the item available to borrow).
                    System.out.println("Item is available to borrow again");
                }
                
            }           
            
        }
    
    }
    
    @Override
     public void startGUI(){
         LibraryGUI myFrame= new LibraryGUI(list);//Calls the gui class and puts the arraylist list data into the table
         myFrame.setVisible(true);//Makes the frame visiable. Needed to open the GUI.
         
     }
    
    @Override
    public void freeSpaces(){
    int freeSpaces=totalItems-(bookCounter+ dvdCounter);//total free sapes =100+50
        int bookSpaces= numBook-bookCounter;//100- the amount of books. The difference.Same thing for the variable dvdSpaces.
        int dvdSpaces=numDVD-dvdCounter;
        
        System.out.println("Number of free spaces in total: " + freeSpaces);//Outputs the amount of free spaces.
                System.out.println("Number of free spaces for books: " + bookSpaces);//Outputs the amount of free book spaces.
                System.out.println("Number of free spaces for DVDs: " + dvdSpaces);//Outputs the amount of free DVD spaces.
    
    }
    
    @Override
    public boolean runMenu() {
         
        
        boolean exit = false;

        System.out.println("To add a new Item press 1");
        System.out.println("To print the list of the items press 2");
        System.out.println("To display the number of free spaces press 3");
        System.out.println("To delete an item press 4");
        System.out.println("To borrow an item press 5");
        System.out.println("To return an item press 6");
        System.out.println("To use the GUI press 7");
        System.out.println("To exit press 8");

        Scanner s = new Scanner(System.in);
        int option = s.nextInt();//Allows the user to enter an integer.

        switch (option) {//Looks through the number entered by the user 
            case 1:
                System.out.println("What type of item would you like to add: ");
                //System.out.println("Press 2 if you want to add a DVD");
                String option2 = s.next();
               
                
                switch (option2) {
                    
                    case "book"://case for if the user added a string of book with no uppercase b.
                    case "Book":
                        //if it's a Book
                        System.out.println("Insert the author/authors of the book: ");
                        String author = s.nextLine();
                        s.nextLine();
                        System.out.println("Insert the publisher: ");
                        String publisher= s.nextLine();
                        
                        System.out.println("Enter the total number of pages: ");
                        int noPages= s.nextInt();
                        
                        System.out.println("Enter the ISBN: ");
                        int isbn= s.nextInt();
                        s.nextLine();
                        
                        System.out.println("Enter title of the book: ");
                        String title= s.nextLine();
                        
                        System.out.println("Enter the sector: ");
                        String sector= s.nextLine();
                        
                        System.out.println("Enter the publication day: ");
                        int pubday= s.nextInt();
                        
                        System.out.println("Enter the publication month: ");
                        int pubMonth=s.nextInt();
                        
                        System.out.println("Enter the publication year: ");
                        int pubYear= s.nextInt();
                        Book book =new Book(author, publisher, noPages, isbn, title, sector, pubday, pubMonth, pubYear);//Stores what all the user has entered to the book object.
                        this.addLibraryItem(book);//The book object is put into a parameter of the addLibrary method. The addLibrary parameter is a list object. This also applies for the dvd case.
                        break;        
                        
                    case "dvd":
                    case "DVD": 
                    //if it is a DVD
                        System.out.println("Insert the available languages: ");
                        String languages = s.nextLine();
                        s.nextLine();
                        System.out.println("Insert the available subtitles: ");
                        String subtitles = s.nextLine();
                        
                        System.out.println("Insert the name of the producers: ");
                        String producer = s.nextLine();
                        
                        System.out.println("Insert the name of the actors: ");
                        String actors = s.nextLine();
                        
                        System.out.println("Insert the ISBN number: ");
                        int isbnDVD = s.nextInt();
                        s.nextLine();
                        
                        System.out.println("Insert the title of the DVD: ");
                        String titleDVD = s.nextLine();
                        
                        System.out.println("Insert the sector the DVD is at: ");
                        String sectorDVD = s.nextLine();
                        
                        System.out.println("Enter the publication day: ");
                        int pubdayDVD= s.nextInt();
                        
                        System.out.println("Enter the publication month: ");
                        int pubMonthDVD=s.nextInt();
                        
                        System.out.println("Enter the publication year: ");
                        int pubYearDVD= s.nextInt();
                        
                        DVD dvd =new DVD(languages, subtitles, producer, actors, isbnDVD, titleDVD, sectorDVD, pubdayDVD, pubMonthDVD, pubYearDVD);
                        this.addLibraryItem(dvd);
                        
                        break; 
                }
                break;
            case 2:
                this.printItems();//printItem function is called which prints iformation of each item in the system.
                break;
                
            case 3:
                
                freeSpaces();
                break;
                
            case 4:
                System.out.println("Please enter the ISBN of the item that you would like to remove: ");
                int isbnDelete= s.nextInt();           
                this.deleteItem(isbnDelete);//Puts what the user has entered into the parameter of the delete function.
                break;
            
            case 5:
                System.out.println("Enter the ISBN number of the item to be borrowed: ");
                try{//Error handling for values that are not type int
                    int isbnborrow= s.nextInt();
                    this.borrowItem(isbnborrow);
                }
               catch(InputMismatchException str){//Catches the error type and stores it into an object.
                    System.out.println("You haven't entered a number, please try again");
                    }
                break;
            
            case 6:
                System.out.println("Enter the ISBN number of the item to be returned: ");
                try{
                int isbnreturn= s.nextInt();
                this.returnItem(isbnreturn);
                }
               catch(InputMismatchException str){
                    System.out.println("You haven't entered a number, please try again");//This is outputted if the error occurs.
                    }
                break;
                
            case 7:
                startGUI();//Calls the GUI method which opens the GUI and calls the GUI class.
            break; 
                
            case 8:
                exit = true;//Closes the program when 8 is entered.
                break;    

        }
        return exit;
    }
    public static void main(String[] args) {

        LibraryManager system = new InstituteLibraryManager(100, 50, 150);//Sets the limited number of free spaces for the system.

        boolean exit = false;
        while (!exit) {//while exit is false, keep on running the appliaction.
            exit = system.runMenu();
        }
    }

    

    

}
