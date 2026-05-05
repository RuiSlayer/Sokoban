package Movabel_Objs;

import java.util.ArrayList;

import AbstractObjs.AbstractObjs;
import Active_Objs.ActiveObjs;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Point2D;
import pt.iul.ista.poo.utils.Vector2D;
import sokoban.starter.Map;

public abstract class Movabel extends AbstractObjs {

	public Movabel(String fileName, Point2D pos, int layer, boolean tranposabel) {
		super(fileName, pos, layer, tranposabel);
	}
	
	public Point2D getNovapos(int lastKeyPressed) {
		Vector2D dire = Direction.directionFor(lastKeyPressed).asVector();
		Point2D	novaPos = getPosition().plus(dire);
		return novaPos;
	}
	
	public void move(Map nivel, int lastKeyPressed) {
		Point2D novaPos = getNovapos(lastKeyPressed);
		ArrayList<AbstractObjs> objsNoPonto = nivel.getObjcsOnPoint(novaPos);
		
		if(canPass(objsNoPonto)) {
			setPosition(novaPos);
			ImageMatrixGUI.getInstance().update();
		}
		isActive(novaPos, nivel, lastKeyPressed);
	}
	 
	 public boolean canPass(ArrayList<AbstractObjs> objsNoPonto) {
		 for(AbstractObjs a : objsNoPonto) {
			 if(!a.isTranposabel()) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public void isActive(Point2D novaPos, Map nivel, int lastKeyPressed) {
		 ArrayList<AbstractObjs> objsNoPonto = nivel.getObjcsOnPoint(novaPos);
		 for(AbstractObjs a : objsNoPonto) {
			 if(a instanceof ActiveObjs) {
				((ActiveObjs)a).observarMovabel(this, nivel, lastKeyPressed);
				return;
			}
		}
	 }
}
