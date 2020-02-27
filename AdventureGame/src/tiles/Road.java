//Scott Blake
//CS 143
//
//This code writes the default actions for the Road tile type

package tiles;

import game.*;
import players.*;

public class Road extends BasicTile {

	public Road() {
		super(TileType.ROAD);
	}

	@Override
	public void visitTile(Game game) {
		Player temp = new Squire();
		if(game.getPlayer().getClass() == temp.getClass()) {
			game.getPlayer().setCurrent(game.getPlayer().getCurrent() + 1);
		}
		game.getPlayer().stepsOnRoad();
	}

}
