package by.world;

public abstract class Entity {

    private Position position;
    private Enum entityType;

    public Entity(Position position, Enum entityType) {
        this.position = position;
        this.entityType = entityType;
    }


    public Position getPosition() {
        return position;
    }

    public Enum getEntityType() {
        return entityType;
    }
}
