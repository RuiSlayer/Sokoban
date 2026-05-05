package Active_Objs;


import AbstractObjs.AbstractObjs;
import Movabel_Objs.Empilhadora;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Gelo extends ActiveObjs{

	public Gelo(Point2D pos) {
		super("Gelo" , pos, 2, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		Point2D novaPos = m.getNovapos(lastKeyPressed);
		
		for(AbstractObjs a : nivel.getObjcsOnPoint(novaPos)) {
			if(!(a.tranposabel))
				return;
			if(a instanceof Bateria)
				return;
		}
		m.move(nivel, lastKeyPressed);
		
		if(m instanceof Empilhadora) {
			((Empilhadora)m).setBateria(1);
			((Empilhadora)m).setScore(-1);
		}
	}
}
