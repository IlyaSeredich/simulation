package by.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {

    private int[][] size;
    private Map<Position, Entity> entities = new HashMap<>();
    private String entityMark;

    public WorldMap(int x, int y) {
        size = new int[x][y];
    }

    public void addEntity(Entity entity) {
        if(entity.getPosition().getX() > size.length || entity.getPosition().getX() < 0) {
            throw new IllegalArgumentException("wrong position x in " + entity.getEntityType());
        } else if (entity.getPosition().getY() > size[0].length || entity.getPosition().getY() < 0) {
            throw new IllegalArgumentException("wrong position y in " + entity.getEntityType());
        }
        entities.put(entity.getPosition(), entity);
    }

    public void render() {

        int x = size.length;
        int y = size[0].length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(isPositionFree(j, i)) {
                    System.out.print(".");
                } else {
                    System.out.print(entityMark);
                }
            }
            System.out.println();
        }


    }

    public boolean isPositionFree(int x, int y) {
        Position position = new Position(x+1, y+1);
        Entity entity = entities.get(position);

        if(entity == null) {
            return true;
        } else {
            if(entity.getEntityType() == EntityType.GOAL) {
                entityMark = "G";
                return false;
            } else {
                entityMark = "S";
                return false;
            }
        }
    }

}
