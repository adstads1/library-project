/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adamt
 */
public class LibraryTableModel extends AbstractTableModel{

    private String[] columnNames= {"ISBN","Item title","Publication date", "Is it currently borrowed" };
    ArrayList<LibraryItem> list;
    
    public LibraryTableModel(ArrayList<LibraryItem> item) {
    list=item;
    
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp=null;//used to set the columns, but before the below code is run all the cells are empty/null.
        
        if(columnIndex==0){
            temp= list.get(rowIndex).getISBN();//Add the ISBN in the first colunm.
        }
        else if(columnIndex==1){
            temp=list.get(rowIndex).getTitle();//Add the title in the second column and so on
        }
        else if(columnIndex==2){
            temp=list.get(rowIndex).getPublicationDate().getDate();
        }
        else if(columnIndex==3){
            
            if(list.get(rowIndex).getReader() == null){//if there is no reader, which means there is no borrower.
            temp="Not currently borrowed";
            }
            else{
            temp="Currently borrowed";
            }
        }
        return temp;
    }
    
    public String getColumnName(int columnIndex){//Creates the headers for the columns.
        return columnNames[columnIndex];//returns the column name which is type String for the titles.
    }

    
    
}
