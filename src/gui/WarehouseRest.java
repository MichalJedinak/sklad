import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import client.HttpSimpleCrudClient;
import entity.Item;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * MigLayout in GUI 
 * 
 * table panel = panel left 
 * pane panel left 
 * table panel left
 * icon img panel left 
 * --------------------------
 * update and delete panel
 * field 1 id panel right 1
 * field 2 name panel right 1
 * field 3 available panel 1
 * field 6 descriotion panel right 1
 * buttons delete update back panel right 1
 * ______________________-__________
 * create panel 
 * field 4 name panel right 2
 * field 5 availabe panel right 2
 * field 7 description panel right 2
 * button create panel 2
 */
public class WarehouseRest  extends JFrame implements ActionListener{ 
    
      public Item item;
      JMenuBar bar = new JMenuBar();
      JMenu menu = new JMenu("<html><Selecting> &#x2630;</h1> </html>");
      JMenuItem item_1 = new JMenuItem("Modification ");
      JMenuItem item_2 = new JMenuItem("Adding");

      JLabel label = new JLabel("Selecting data from the database");
      JPanel left= new JPanel();
      static JTable table ;
      JScrollPane pane = new JScrollPane(table);
      JButton button = new JButton("Select data");
      JPanel right= new JPanel();
      JLabel info = new JLabel(" Create new Item!");
      JLabel label_1 = new JLabel("ID ");
      JTextField field_1 = new JTextField(15);
      JLabel label_2 = new JLabel("Name ");
      JTextField field_2 = new JTextField(15);
      JLabel label_6 = new JLabel("Desription ");
      JTextField field_6 = new JTextField(15);
       JLabel label_7 = new JLabel("Desription ");
      JTextField field_7 = new JTextField(15);
      JLabel label_3 = new JLabel("Available ");
      JTextField field_3 = new JTextField(15);
      JButton update= new JButton("Edit item");
      JButton back = new JButton("Back");
      JButton delete = new JButton("Delete item");
      ArrayList<JTextField> filedList= new ArrayList<>();
      ArrayList<JButton> buttonList = new ArrayList<>();
      ArrayList<JLabel> labelList = new ArrayList<>();
      ImageIcon icon = new ImageIcon("src\\main\\resources\\img\\frame_icon.png");
      Image image ;
      JLabel imgLabel  = new JLabel(icon);

      JPanel right_2 = new JPanel();     
      JLabel label_4 = new JLabel("Name ");
      JTextField field_4 = new JTextField(15);
      JLabel label_5 = new JLabel("Avalilable ");
      JTextField field_5 = new JTextField(5);
      JButton create = new JButton("Create item");


      String url  = "jdbc:mysql://localhost:3306/sklad";
      String user = "root";
      private String password = "show_pussy8squirrel~hairy";
      
      public WarehouseRest(){

            pane.setPreferredSize(new Dimension(400, 250));
            pane.setLayout(new ScrollPaneLayout());
            image= icon.getImage();
            imgLabel.setPreferredSize(new Dimension(400, 250));
            Image scaleImage= image.getScaledInstance(400,250,Image.SCALE_SMOOTH);
            ImageIcon scaleIcon = new ImageIcon(scaleImage);
            pane.add(imgLabel);
            pane.setViewportView(imgLabel);
            imgLabel.setIcon(scaleIcon);
           // p.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            table= new JTable();
            table.setFont(new Font("Roboto", Font.BOLD, 15));
            table.setForeground(Color.red);
            table.setVisible(true);
           
            left.setLayout(new MigLayout());
            left.add(label,"center,wrap");
            left.add(pane,"gap left 25 ,wrap");
            left.add(button,"gap top 20,center");
            
            field_1.setEditable(false);
            right.setLayout(new MigLayout());
            right.add(label_1,"span 2");
            right.add(field_1,"gap left 25,span 2,wrap");
            right.add(label_2,"span 2");
            right.add(field_2,"gap left 25, wrap");
            right.add(label_3,"span 2");
            right.add(field_3,"gap left 25 ,wrap");
            right.add(label_6,"span 2");
            right.add(field_6,"gap left 25 , wrap");
            right.add(delete,"span 2,gap top 50");
            right.add(update,"gap left 100 ,gap top 50,wrap");
            right.add(back,"center, gap top 40");
            back.addActionListener(this);

            right_2.setLayout(new MigLayout());
            right_2.add(info,"wrap,gap bottom 20");
            right_2.add(label_4);
            right_2.add(field_4,"align left,wrap");
            right_2.add(label_5);
            right_2.add(field_5,"wrap,span 2");
            right_2.add(label_7);
            right_2.add(field_7," wrap");
            right_2.add(create,"center, gap top 25");
            
            bar.add(menu);
            bar.setPreferredSize(new Dimension(900, 40));
            menu.setFont(new Font("Roboto", Font.BOLD, 23));
            menu.add(item_1);
            menu.add(item_2);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);this.setBackground(Color.black);
            this.setIconImage(icon.getImage());
            this.setLayout(new MigLayout());
            this.setTitle("   ADD OR EDIT DATA");
            this.setJMenuBar(bar);
            this.add(left,"gap right 30");
            this.add(right,"wrap,gap top 20");
            this.setSize(900, 420);          
            this.setVisible(true);
            this.repaint();
            ////  pridanie do array listov 
            labelList.add(label);labelList.add(info);labelList.add(label_1);
            labelList.add(label_2);labelList.add(label_3);labelList.add(label_4);labelList.add(label_5);
            labelList.add(label_6);labelList.add(label_7);
            filedList.add(field_1);filedList.add(field_2);filedList.add(field_3);filedList.add(field_4);
            filedList.add(field_5);filedList.add(field_6);filedList.add(field_7);
            buttonList.add(button);buttonList.add(update);buttonList.add(delete);buttonList.add(create);
            // jednotné nastavenie pre elementy v array listoch
            for(JLabel label :labelList){
                  label.setForeground(Color.darkGray);
                  label.setFont(new Font("Consolas", Font.HANGING_BASELINE, 19));
            }
            for(JTextField field : filedList){
                  if(field!=field_1){
                        field.addMouseListener(new MouseAdapter() {                       
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                    field.setText("");
                              }
                        });
                  }
                  field.setFont(new Font("Consolas", Font.ITALIC, 22));
                  field.setPreferredSize(new Dimension(120, 40));
                  field.setBackground(new Color(176, 196 ,222));
                  field.setForeground(Color.white);
            }
            for(JButton button : buttonList){
                  button.addActionListener(this);
                  button.setPreferredSize(new Dimension(100, 45));
                  button.setFont(new Font("Roboto", Font.BOLD, 17));
                  if(button== delete){
                        button.setBackground(new Color(220,20,60));
                  }
                  if(button==update){
                        button.setBackground(new Color(154, 205,50));
                  }
            }

            ArrayList<JMenuItem> itemList = new ArrayList<>();
            itemList.add(item_1);itemList.add(item_2);
            for(JMenuItem item : itemList){
                  item.addActionListener(this);
            }
      }
      ///  funkcia pre zobrazenie údajov z databázovej tabulky do JFramu pre ďaľšiu prácu s údajmi
      public void showDataFromDatabaseTable(){
           
            Connection connection = null;
            try {
                  connection = DriverManager.getConnection(url, user,password);
                  Statement statement = connection.createStatement();
                  ResultSet resulset = statement.executeQuery("SELECT * FROM item;");
               
                  DefaultTableModel defaultModel = new DefaultTableModel();
                  /*  nastavíme pre defaul model údaje do stĺpcov ( table columns )
                   * pomocou ResulsetMetaData getMetaTada to nam umožní načítať stĺpce s tabulky aj s názvami
                  */
                  java.sql.ResultSetMetaData rsmd = resulset.getMetaData();
                  // potrebujeme zistiť kolko je stĺpcou v tabulke 
                  int cols = rsmd.getColumnCount(); //  do premennej cols si uložíme počet stlpcov
                  System.out.println(cols);
                  // teraz si vytvoríme pole Stringov v ktorom si zobrazíme mená 
                  //pre jednotlivé stĺpce cez for cyklus
                  String[] colName = new String[cols];
                  for(int i = 0; i<cols;i++)
                  colName[i]=rsmd.getColumnName(i+1);// použijeme get column Name s resulset meta data
                  defaultModel.setColumnIdentifiers(colName);//  default modelu nastavíme identifikované stĺpce
                 /*   cez while cyklus si z resulsetu vyberieme hodnoty do pola Stringov 
                  ktoré použijeme na nastavenie riadkov v defout modely */
                  while(resulset.next()){
                        /*Vytvoríme si premenné podľa toho čo berieme z tabulky  int string etc.. */
                        int id=resulset.getInt(1);
                        String idString = String.valueOf(id);
                        String item_name=    resulset.getString(2);
                        int l = resulset.getInt(3);
                        String item_count= String.valueOf(l);
                   
                        if(resulset.getString("name")==null){
                              item_name=" ";
                        }
                        if(resulset.getInt("available")==0){
                              item_count=" ";
                        }
                       String descr = resulset.getString(4);
                       String createdAt = resulset.getString(5);
                        String[] dataLists= {idString,item_name,item_count,descr,createdAt};// pole Stringov
                        defaultModel.addRow(dataLists);// pridanie row do default modelu
                        
                  }
                  table.setModel(defaultModel);// tabulke nastavíme model
                 /*A uzavrieme spojenie a čo treba */
                  connection.close();
                  statement.close();
                  resulset.close();
            } catch (Exception e) {
                  /* Uppozornenie pri zlyhaní načítania údajov s sql tabulky do JTabulky */
                  JOptionPane.showMessageDialog(null, e, "CHYBA", JOptionPane.ERROR_MESSAGE);
                  e.printStackTrace();
            }
      }

      ////////////   buttons event nastavenie jednotlivých funkcií pre buttons 
      @Override
      public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==item_1){
                  for(JTextField field :filedList){
                        field.setText("");                    
                  } 
                  pane.setViewportView(imgLabel); 
                  this.remove(right_2);
                  this.add(right,"wrap,gap top 20");this.repaint();this.revalidate();
            }
             if(e.getSource()==item_2){
                  for(JTextField field :filedList){
                        field.setText("");                    
                  } 
                  pane.setViewportView(imgLabel); 
                  this.remove(right);
                  this.add(right_2);                  
                  this.repaint();this.revalidate();
            }
            // buttobutton show table 
            if(e.getSource()==button){
                   pane.add(table);
                 pane.setViewportView(table);
                  showDataFromDatabaseTable();
                  table.addMouseListener(new MouseAdapter() {
                           @Override
                           public void mouseClicked(MouseEvent e) {
                                    int listItems = table.getSelectedRow();
                                    table.getModel().getValueAt(listItems,2); 
                                    field_1.setText(table.getModel().getValueAt(listItems,0).toString());
                                    field_2.setText(table.getModel().getValueAt(listItems,1).toString());
                                    field_3.setText(table.getModel().getValueAt(listItems,2).toString());
                                    field_6.setText(table.getModel().getValueAt(listItems, 3).toString());
                                    this.repaint();                                  
                              }
                              private void repaint() {
                        }
                       
                        });
            }
            // button update send PUT / PATCH metod from HttpSimpleCrudClient;
            if(e.getSource()==update){
                  // create new oobject for update or delete
                  newObjectForUdateOrDelete();
                  System.out.println(item.getId());
                  // calling metod for update 
                  Integer id = item.getId();
                  System.out.println(id);
                  if(item.getId()!=null){
                        try {
                              HttpSimpleCrudClient.updateObject(new URL("http://localhost:8080/item/"),id, item);
                        } catch (MalformedURLException e1) {                            
                              e1.printStackTrace();
                        }
                  }else{
                        System.err.println("Item whit id:+"+id+" dont exist !!");
                  }

                  for(JTextField field :filedList){
                        field.setText("");                    
                  }     
                  showDataFromDatabaseTable();
                  this.repaint();this.validate();
            }
            // button delete send DELETE metod from HttpSimpleCrudClient;
            if(e.getSource()==delete){
                  newObjectForUdateOrDelete();
                  System.out.println(item.getId());
                  // calling metod for update 
                  Integer id = item.getId();
                  System.out.println(id);
                  if(item.getId()!=null){
                        try {
                              HttpSimpleCrudClient.deleteObject(new URL("http://localhost:8080/item/"), id);
                              System.out.println("Object Item whit id: "+id+" is deleted");
                        } catch (MalformedURLException e1) {                 
                              e1.printStackTrace();
                              System.out.println("SQL oe Other error");
                        }
                  }else{
                        System.err.println("Item whit id:+"+id+" dont exist !!");
                  }

                  for(JTextField field :filedList){
                        field.setText("");
                  }
                  showDataFromDatabaseTable();
                  this.repaint();this.validate();
            }
            if(e.getSource()==back){
                  for(JTextField field :filedList){
                        if(field.getText()!=null || !field.getText().isEmpty()){
                              field.setText("");
                        }
                  }
                  showDataFromDatabaseTable();  
                  this.repaint();   
            }
            // button create send POST metod from HttpSimpleCrudClient;
            if(e.getSource()==create){ 
                  Integer id = Integer.valueOf(field_5.getText()) ;  
                  item = new Item();
                  item.setName(field_4.getText());
                  item.setAvailable(id);
                  item.setDescription(field_7.getText());
                  System.out.println(item.toString());
                  if(item != null){
                        try {
                              HttpSimpleCrudClient.addObject(new URL("http://localhost:8080/item"), item);
                              JOptionPane.showConfirmDialog(null,"Item is created "+item.toString());
                        } catch (MalformedURLException e1) {                            
                              e1.printStackTrace();
                        }
                  }else{
                        System.err.println(" Object could not be created ");
                  }

            }

      }
      //  create new Item Object from fields data text
      public void newObjectForUdateOrDelete(){
            item = new Item();
            try {
                  String i = field_1.getText();
                  Integer id = Integer.parseInt(i);
                  String name = field_2.getText();
                  int available = Integer.parseInt(field_3.getText());
                  String description = field_6.getText();                  
                  item.setId(id);
                  item.setName(name);
                  item.setAvailable(available);
                  item.setDescription(description);
                  System.out.println(item.toString());
                  JOptionPane.showMessageDialog(null, "The Object exists, you can delete or edit it");
                  System.out.println("Vytvorenie Item prebehlo v poriadku.:)");
                               
            } catch (Exception e) {
                  System.err.println(e);
                  JOptionPane.showMessageDialog(null,e, "Upozornenie",JOptionPane.ERROR_MESSAGE);
            }
      }
}
/*
 * import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class MyGuiApp {
    private static final String BASE_URL = "http://localhost:8080"; // Your server URL

    public static void main(String[] args) {
        // Create a basic RestClient
        WebClient restClient = WebClient.create(BASE_URL);

        // Example: Fetch data from the server
        String articlesResponse = restClient.get()
                .uri("/articles")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Articles received: " + articlesResponse);

        // Example: Create a new article
        Article newArticle = new Article(1, "How to use RestClient");
        restClient.post()
                .uri("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newArticle)
                .retrieve()
                .toBodilessEntity()
                .block();

        System.out.println("Article created successfully!");
    }
}

*/