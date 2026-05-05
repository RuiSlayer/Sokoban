package Active_Objs;

import AbstractObjs.AbstractObjs;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class ActiveObjs extends AbstractObjs {
	
	public ActiveObjs(String fileName, Point2D pos, int layer, boolean transposabel) {
		super(fileName, pos, layer, transposabel);
	}
	
	public Point2D getPosition() {
		return pos;
	}

	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {}
}
