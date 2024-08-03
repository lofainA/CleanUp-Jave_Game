package main;

import object.Obj_Key;

public class AssetPlacer {

    GamePanel gp;

    public AssetPlacer(GamePanel gp) {
        this.gp = gp;
    }

    public void placeObject() {

        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 27 * gp.TileSize;
        gp.obj[0].worldY = 43 * gp.TileSize;

        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 37 * gp.TileSize;
        gp.obj[1].worldY = 10 * gp.TileSize;
    }
}
