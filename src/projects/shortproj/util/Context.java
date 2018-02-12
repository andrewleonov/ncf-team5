package projects.shortproj.util;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import projects.shortproj.gui.ColorBar;
import projects.shortproj.gui.DrawingSurface;
import projects.shortproj.gui.SideBar;
import projects.shortproj.gui.SideBarRight;
import projects.shortproj.gui.TopMenu;

public class Context {

	public Stage stage;
	
	// Main elements
	public ColorBar colorPicker;
	public SideBar menuBox;
	public SideBarRight sidebarRight;
	public DrawingSurface surface;
	public MenuBar menuBar;

	public double storedx;
	public double storedy;
	public boolean firstClick;
	public int clickCount;
	public Group storedGroup;
	public Node storedNode;
	public Transform transform;

	public Context(Stage primaryStage) {
		menuBox = new SideBar(this);
        sidebarRight = new SideBarRight(this);
        colorPicker = new ColorBar(this);
        surface = new DrawingSurface(this);
        menuBar = new TopMenu(this);
		
		storedx = 0;
		storedy = 0;
		
		stage = primaryStage;
		
		clickCount = 0;
		firstClick = true;
		storedGroup = null;
		storedNode = null;
		transform = null;
	}
	
	public void resetLastClick() {
		storedx = 0;
		storedy = 0;
		clickCount = 0;
		firstClick = true;
		storedGroup = null;
		storedNode = null;
		transform = null;
	}
}
