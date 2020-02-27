//Scott Blake
//CS 143
//
//This code writes the default actions for the Mud tile type

package tiles;

import game.*;
import players.*;

public class Mud extends BasicTile {

	public Mud() {
		super(TileType.MUD);
	}

	public void visitTile(Game game) {
		Player temp = new Squire();
		if(game.getPlayer().getClass() != temp.getClass()) {
			game.getPlayer().setCurrent(game.getPlayer().getCurrent() + 2);
		}
		game.getPlayer().stepsInMud();
	}

}
