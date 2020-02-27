//Scott Blake
//CS 143
//
//This code writes the default actions for the Grass tile type

package tiles;

import game.*;
import players.*;

public class Grass extends BasicTile {
	
	public Grass() {
		super(TileType.GRASS);
	}

	@Override
	public void visitTile(Game game) {
		game.getPlayer().setCurrent(game.getPlayer().getCurrent() + 1);
		game.getPlayer().stepsOnGrass();
	}

}
