/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author adamt
 */
public class LibraryGUI extends JFrame{
    
    JTable libraryList;
    LibraryTableModel listModel;
    ArrayList<LibraryItem> list;
    
    public LibraryGUI(ArrayList<LibraryItem> list){
        this.list=list;
        listModel= new LibraryTableModel(list);
        libraryList= new JTable(listModel);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes/stops running the application when user has clicked on the x button
            setBounds(40, 40, 700, 400);//(int x, int y, int width, int height) x,y is the coordinate of the componets, the width is the components width and height is the height of the component.
            libraryList.setAutoCreateRowSorter(true);//Automatically creates a RowSorter.
            
            libraryList.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer(){//Used to change the color of the cell where red is item that is currently being borrowed and green for currently free items.
                Color originalColor = null;

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean SelectedItem, boolean lookAt, int row, int column) {//Component is the Modifier and this method returns the conponent which is used to drawing cells. .
            
                Component renderer =  super.getTableCellRendererComponent(table, value, SelectedItem, lookAt, row, column);

            if (value == "Currently borrowed") {
                renderer.setBackground(Color.RED);//Change colour of the cell to red if it value string =="Currently borrowed".
            } else {
                renderer.setBackground(Color.GREEN);//If the string isn't Currently borrowed then make the cell colour green.
            }

           
            return renderer;
            }
                
        });
                
                JTextField jimFilt= new JTextField();//creates a textfield for searching items
                
            
                JScrollPane scrollPane = new JScrollPane(libraryList); //Add the information to the container with the dimension below
                scrollPane.setPreferredSize(new Dimension(600,300)); 
        
                JPanel panel = new JPanel();// Panel contains the all the different components and organizes the components.
                
                JPanel searchpanel= new JPanel(new BorderLayout());//Search area panel.
                
                searchpanel.add(new JLabel("Search a specific item by title: "),BorderLayout.WEST);//Moves string to the left
                searchpanel.add(jimFilt, BorderLayout.CENTER);//Moves the textfield to the middle
                add(searchpanel, BorderLayout.SOUTH);//Moves the textfield to the bottom
                                
                panel.add(scrollPane); //adding libraryList to the panel.
                add(panel,BorderLayout.CENTER); 
    }

}
