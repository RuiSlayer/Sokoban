package sokoban.starter;

import java.util.ArrayList;

import AbstractObjs.AbstractObjs;
import AbstractObjs.Chao;
import AbstractObjs.Parede;
import Active_Objs.Alvo;
import Active_Objs.Bateria;
import Active_Objs.Buraco;
import Active_Objs.Gelo;
import Active_Objs.Martelo;
import Active_Objs.Parede_Partida;
import Active_Objs.Portal_Azul;
import Movabel_Objs.BigStone;
import Movabel_Objs.Caixote;
import Movabel_Objs.Empilhadora;
import Movabel_Objs.SmallStone;
import pt.iul.ista.poo.utils.Point2D;

	public class Map {
		
		ArrayList<AbstractObjs>nivel;
		
		public Map() {
			nivel = new ArrayList<AbstractObjs>();
		}
		
		public void loadAux(Point2D pos, char key) {
			switch (key) {
			case 't':
				nivel.add(new Portal_Azul(pos)); break;
			case 'g':
				nivel.add(new Gelo(pos)); break;
			case '%':
				nivel.add(new Parede_Partida(pos));
				nivel.add(new Chao(pos)); break;
			case 'M':
				nivel.add(new Martelo(pos));
				nivel.add(new Chao(pos)); break;
			case 'p':
				nivel.add(new SmallStone(pos));
				nivel.add(new Chao(pos)); break;
			case 'P':
				nivel.add(new BigStone(pos));
				nivel.add(new Chao(pos)); break;
			case 'X':
				nivel.add(new Alvo(pos)); break;
			case 'b':
				nivel.add(new Bateria(pos));
				nivel.add(new Chao(pos)); break;
			case 'O':
				nivel.add(new Buraco(pos)); break;
			case 'C':
				nivel.add(new Caixote(pos));
				nivel.add(new Chao(pos)); break;
			case ' ':
				nivel.add(new Chao(pos)); break;
			case 'E':
				nivel.add(new Empilhadora(pos));
				nivel.add(new Chao(pos)); break;
			case '#':
				nivel.add(new Parede(pos)); break;
			default:
				break;
			}
		}
	
		public ArrayList<AbstractObjs> getNivel() {
			return nivel;
		}
		
		public boolean pointIsEqual(AbstractObjs a, Point2D pos) {
			if(a.getPosition().equals(pos))
				return true;
			return false;
		}
		
		public ArrayList<AbstractObjs> getObjcsOnPoint(Point2D pos){
			ArrayList<AbstractObjs> objectos = new ArrayList<AbstractObjs>();
			for(AbstractObjs abst : nivel) {
				if(pointIsEqual(abst, pos))
					objectos.add(abst);
			}
			return objectos;
		}
		
		public Point2D getPortal_Azul_Pos(Point2D pos){
			Point2D posPortal = null;
			
			for(AbstractObjs abst : nivel) {
				if(abst instanceof Portal_Azul && !(pointIsEqual(abst, pos)))
					return abst.pos;
			}
			return posPortal;
		}
		
		public ArrayList<Alvo> getAlvos() {
			ArrayList<Alvo>alvos = new ArrayList<Alvo>();
			for(AbstractObjs abst : nivel) {
				if(abst instanceof Alvo)
					alvos.add((Alvo)abst);
			}
			return alvos;
		}
		
		public ArrayList<Caixote> getCaixotes() {
			ArrayList<Caixote> caixotes = new ArrayList<Caixote>();
			for(AbstractObjs abst : nivel) {
				if(abst instanceof Caixote)
					caixotes.add((Caixote)abst);
			}
			return caixotes;
		}
		
		public BigStone getBigStone() {
			BigStone bigStone = null;
			for(AbstractObjs abst : nivel) {
				if(abst instanceof BigStone)
					bigStone = (BigStone)abst;
			}
			return bigStone;
		}
		
		public Empilhadora getEmpilhadora() {
			Empilhadora empi = null;
			for(AbstractObjs abst : nivel) {
				if(abst instanceof Empilhadora)
					empi = (Empilhadora)abst;
			}
			return empi;
		}
}
