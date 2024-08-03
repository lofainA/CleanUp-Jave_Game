package main;

import Entity.Entity;

public class CollisionDetector {

    GamePanel gp;

    public CollisionDetector(GamePanel gpan) {
        this.gp = gpan;
    }

    public void detectTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftWorldX/gp.TileSize;
        int entityRightCol = entityRightWorldX/gp.TileSize;
        int entityTopRow = entityTopWorldY/gp.TileSize;
        int entityBottomRow = entityBottomWorldY/gp.TileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "back":
                entityTopRow = (entityTopWorldY - entity.speed)/gp.TileSize;
                tileNum1 = gp.tileMan.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileMan.mapTileNum[entityRightCol][entityTopRow];

                if(gp.tileMan.tile[tileNum1].collision == true || gp.tileMan.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "front":
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.TileSize;
                tileNum1 = gp.tileMan.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileMan.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileMan.tile[tileNum1].collision == true || gp.tileMan.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                    
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.TileSize;
                tileNum1 = gp.tileMan.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileMan.mapTileNum[entityLeftCol][entityBottomRow];

                if(gp.tileMan.tile[tileNum1].collision == true || gp.tileMan.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                    
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed)/gp.TileSize;
                tileNum1 = gp.tileMan.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileMan.mapTileNum[entityRightCol][entityBottomRow];

                if(gp.tileMan.tile[tileNum1].collision == true || gp.tileMan.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
