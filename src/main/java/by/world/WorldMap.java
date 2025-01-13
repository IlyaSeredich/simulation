package by.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {

    private int[][] size;
    private List<Entity> entities = new ArrayList<>();
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
        entities.add(entity);
    }

    public void render() {

        int x = size.length;
        int y = size[0].length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(isPositionFree(j+1, i+1)) {
                    System.out.print(".");
                } else {
                    System.out.print(entityMark);
                }
            }
            System.out.println();
        }


    }

    public boolean isPositionFree(int x, int y) {
        Position position = new Position(x, y);

        for (Entity entity : entities) {
            if(entity.getPosition().equals(position)) {
                if(entity.getEntityType() == EntityType.GOAL) {
                    entityMark = "G";
                    return false;
                } else {
                    entityMark = "S";
                    return false;
                }
            }
        }
        return true;
    }

}
