package by.world;

public class Creature extends Entity {

    public Creature(Position position) {
        super(position, EntityType.CREATURE);
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    public void makeMove(Position goal) {
        int directionX = this.getPosition().getX() - goal.getX();
        int directionY = this.getPosition().getY() - goal.getY();

        if (Math.abs(directionX) >= Math.abs(directionY)) {
            if(directionX > 0) {
                this.getPosition().setX(this.getPosition().getX() - 1);
            } else if (directionX < 0) {
                this.getPosition().setX(this.getPosition().getX() + 1);
            }
        } else {
            if(directionY > 0) {
                this.getPosition().setY(this.getPosition().getY() - 1);
            } else {
                this.getPosition().setY(this.getPosition().getY() + 1);
            }
        }
    }
}
