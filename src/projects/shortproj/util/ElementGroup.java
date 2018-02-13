package projects.shortproj.util;

import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class ElementGroup {
	private Group group;
	private String groupName;
	private Paint[] colors;
	private DropShadow highlight;
	
	public void setGroup(Group g) {
		group = g;
	}
	
	public ElementGroup(Group g, String s) {
		group = g;
		groupName = s;
		
		highlight = new DropShadow();
		Color color = Color.rgb(255, 233, 0);
		highlight.setColor(color);
		highlight.setOffsetX(0f);
		highlight.setOffsetY(0f);
		highlight.setHeight(50);
	}
	
	public void setGroupName(String s) {
		groupName = s;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	// Overrides the toString method to return the name of the group
	public String toString() {
		return groupName;
	}

	public void highlight() {
		for (Node node : group.getChildren()) {
			node.setEffect(highlight);
		}
	}
	
	public void unHighlight() {
		for (Node node : group.getChildren()) {
			node.setEffect(null);
		}
	}
}
