import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import client.HttpSimpleCrudClient;
import entity.Item;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
      
      ////////////   buttons event - setings functions for buttons 
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
                 // loading data into the table
                 loadDataIntoTable();
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
                  loadDataIntoTable();
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
              // loading data into the table
                loadDataIntoTable();
                  this.repaint();this.validate();
            }
            if(e.getSource()==back){
                  for(JTextField field :filedList){
                        if(field.getText()!=null || !field.getText().isEmpty()){
                              field.setText("");
                        }
                  }
                 // loading data into the table
                loadDataIntoTable();
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
                    int resultOption= JOptionPane.showConfirmDialog(null,
                                                "Item is created \n"+item.toString()
                                                +"\nAre you sure you want to create an object?");
                    if(resultOption== JOptionPane.YES_OPTION){
                          try {
                                HttpSimpleCrudClient.addObject(new URL("http://localhost:8080/item"), item);
                               // loading data into the table
                               loadDataIntoTable();
                                // cleare fields text 
                                for(JTextField f :filedList){
                                    f.setText("");
                                    } 
                              } catch (MalformedURLException e1) {                            
                                    e1.printStackTrace();
                                    JOptionPane.showMessageDialog(null, e);  
                              }
                    }if(resultOption==JOptionPane.NO_OPTION || resultOption==JOptionPane.CANCEL_OPTION){
                        for(JTextField f :filedList){
                              f.setText("");
                        }
                       // loading data into the table
                       loadDataIntoTable();
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
      
      /**
       * @param items List Items from sql 
       */
      public void updateTable(List<Item> items) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("name");
            model.addColumn("avalilable");
            model.addColumn("description");
            model.addColumn("created_at");
            model.setRowCount(0); // Vyčistí tabulku
            // set defaultTable model
            for (Item item : items) {
                model.addRow(new Object[] { item.getId(),
                item.getName(),item.getAvailable(),item.getDescription() });
            }
            table.setModel(model);
        }
        
      //   table connect whot rest 
      /**
       * 
       */
      public void  loadDataIntoTable(){
            try {
                  // call getObject()
                  List<Item> items = getObjects(new URL("http://localhost:8080/item"));
                  updateTable(items);
                  
            } catch (Exception e) {
                  System.err.println(e);
            }
      }
      /**
       * @param newUrl
       * @return
       */
      private List<Item> getObjects(URL newUrl) {
            URL url;
            List<Item> items = new ArrayList<>();
            try {
                  // Create a URL object with the target URL
                  url= new URL(newUrl.toString());
                  // Open a connection to the URL
                 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                  connection.setRequestMethod("GET");
                  int responseCode = connection.getResponseCode();
                  System.out.println("Response Code: " + responseCode);

                  if (responseCode == HttpURLConnection.HTTP_OK) {
                        // Read the response from the server
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line;
                        StringBuffer response = new StringBuffer();
                        while ((line = reader.readLine()) != null) {
                              response.append(line);
                        }
                        Gson gson = new Gson();
                        items = gson.fromJson(response.toString(), new TypeToken<List<Item>>(){}.getType());
                        reader.close();
                        // Print the response
                        System.out.println("Response Body:");
                        System.out.println(response.toString());
                    } else {
                        System.out.println("GET request failed.");
                    }
                       connection.disconnect();  
            } catch (IOException e) {
                  System.err.println(e+" connection is faul");
            }
            return items;
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