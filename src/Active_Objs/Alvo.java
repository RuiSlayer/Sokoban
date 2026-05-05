package Active_Objs;

import AbstractObjs.AbstractObjs;
import Movabel_Objs.Caixote;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Alvo extends ActiveObjs  {
	private boolean caixoteAbove = false;
	
	public Alvo(Point2D pos) {
		super("Alvo", pos , 1, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		for(AbstractObjs a : nivel.getObjcsOnPoint(pos)) {
			if(a instanceof Caixote) {
				caixoteAbove = true;
				return;
			}
		}
		caixoteAbove = false;
	}

	public boolean isCaixoteAbove() {
		return caixoteAbove;
	}

}
