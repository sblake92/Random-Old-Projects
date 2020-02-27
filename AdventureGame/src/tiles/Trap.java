//Scott Blake
//CS 143
//
//This code writes the default actions for the Trap tile type

package tiles;

import game.*;
import players.*;

public class Trap extends BasicTile {

	public Trap() {
		super(TileType.TRAP);
	}

	@Override
	public void visitTile(Game game) {
		Player temp = new Princess();
		if(game.getPlayer().getClass() != temp.getClass()) {
			game.getPlayer().setCurrent(game.getPlayer().getCurrent() + 2);
			game.movePlayer(-1);
		}
		game.getPlayer().stepsOnTrap();
	}

}
