/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.input.*;

/**
 *
 * @author jerem
 */
public class ShortProject extends Application {
    
    Boolean firstClick = true;
    double storedx = -1;
    double storedy = -1;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        MenuBar menuBar = createMenu();
        VBox menuBox = createSidebar();
        Pane surface = addSurface();
        
        // Set both panes' positions on main pane
        root.setTop(menuBar);
        root.setLeft(menuBox);
        root.setCenter(surface);
        
        Scene scene = new Scene(root, 800, 800);
                
        primaryStage.setTitle("Photopoop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public MenuBar createMenu() {
        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        
        // Create menus
        Menu newMenu = new Menu("New");
        Menu saveMenu = new Menu("Save");
        Menu loadMenu = new Menu("Load");
        Menu printMenu = new Menu("Print");
        Menu exitMenu = new Menu("Exit");
                     
        exitMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Platform.exit();
            }
        });
        
        // Add menuItems to the Menus
        //fileMenu.getItems().addAll(newItem, openFileItem, exitItem);
        
        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(newMenu, saveMenu, loadMenu, printMenu, exitMenu);
        
        return menuBar;
    }
    
    public static void onAction(Menu menu)
    {
        final MenuItem menuItem = new MenuItem();

        menu.getItems().add(menuItem);
        menu.addEventHandler(Menu.ON_SHOWN, event -> menu.hide());
        menu.addEventHandler(Menu.ON_SHOWING, event -> menu.fire());
    }
    
    public VBox createSidebar() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(5, 25, 15, 15));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");

        // Tool Group 1
        final ToggleGroup group1 = new ToggleGroup();

        Label toolsLabel1 = new Label("Brushes");
        toolsLabel1.setTextFill(Color.WHITE);
        
        ToggleButton tool1 = new ToggleButton("Brush 1");
        tool1.setToggleGroup(group1);
        tool1.setSelected(true);
        tool1.setPrefSize(60, 25);

        ToggleButton tool2 = new ToggleButton("Brush 2");
        tool2.setToggleGroup(group1);
        tool2.setPrefSize(60, 25);

        ToggleButton tool3 = new ToggleButton("Brush 3");
        tool3.setToggleGroup(group1);
        tool3.setPrefSize(60, 25);

        // Instrument Group 2        
        final ToggleGroup group2 = new ToggleGroup();

        Label toolsLabel2 = new Label("Shapes");
        toolsLabel2.setPadding(new Insets(10, 0, 0, 0));
        toolsLabel2.setTextFill(Color.WHITE);

        ToggleButton tool4 = new ToggleButton("Line");
        tool4.setToggleGroup(group2);
        tool4.setSelected(true);
        tool4.setPrefSize(60, 25);

        ToggleButton tool5 = new ToggleButton("Square");
        tool5.setToggleGroup(group2);
        tool5.setPrefSize(60, 25);

        ToggleButton tool6 = new ToggleButton("Circle");
        tool6.setToggleGroup(group2);
        tool6.setPrefSize(60, 25);

        
        // Add all elements to the toolbar
        vbox.getChildren().addAll(toolsLabel1, tool1, tool2, tool3, toolsLabel2, tool4, tool5, tool6);
        
        return vbox;
    }
    
    public Pane addSurface() {
        Pane surface = new Pane();
        
        // Add an event handler to the pane and make it draw lines for now.
        surface.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX() + ", " + event.getY());
                if (firstClick){
                    firstClick = false;
                    storedx = event.getX();
                    storedy = event.getY();
                }
                else {
                    firstClick = true;
                    // Make line
                    Line line = new Line();
                    line.setStartX(storedx);
                    line.setStartY(storedy);
                    line.setEndX(event.getX());
                    line.setEndY(event.getY());
                    
                    surface.getChildren().add(line);
                    
                    storedx = -1;
                    storedy = -1;
                }
            }
        });
        
        return surface;
    }    
}
