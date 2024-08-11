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
            
            case "back": //up
                entityTopRow = (entityTopWorldY - entity.speed)/gp.TileSize;
                tileNum1 = gp.tileMan.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileMan.mapTileNum[entityRightCol][entityTopRow];

                if(gp.tileMan.tile[tileNum1].collision == true || gp.tileMan.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;

            case "front": //down
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

    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for(int i = 0; i < gp.obj.length; i++) {
            if(gp.obj[i] != null) {

                // Get entity's hitbox posn
                entity.hitBox.x += entity.worldX;
                entity.hitBox.y += entity.worldY;

                // Get object's solid area position
                gp.obj[i].hitBox.x += gp.obj[i].worldX;
                gp.obj[i].hitBox.y += gp.obj[i].worldY;

                
                switch(entity.direction) {
                    
                    case "back": //up
                        entity.hitBox.y -= entity.speed; 
                        if(entity.hitBox.intersects(gp.obj[i].hitBox)) { // Check if hitBox's are intersecting using intersects methd
                            
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "front": //down
                        entity.hitBox.y += entity.speed;
                        if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.hitBox.x -= entity.speed;
                        if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;

                    case "right": 
                        entity.hitBox.x += entity.speed;
                        if(entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if(gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if(player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;

                gp.obj[i].hitBox.x = gp.obj[i].hitBoxDefaultX;
                gp.obj[i].hitBox.y = gp.obj[i].hitBoxDefaultY;
            }
        }

        return index;
    }
}
