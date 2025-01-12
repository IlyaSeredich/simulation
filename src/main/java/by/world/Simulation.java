package by.world;

import java.util.Map;

public class Simulation {

    private WorldMap worldMap;
    private Creature creature;
    private Goal goal;
    private int stepsCounter;
    boolean isPlaying;


    public Simulation(WorldMap worldMap, Creature creature, Goal goal) {
        this.worldMap = worldMap;
        this.creature = creature;
        this.goal = goal;
        isPlaying = true;
    }

    public void initialize() {
        worldMap.addEntity(creature);
        worldMap.addEntity(goal);
    }

    public void startSimulation() {
        initialize();
        int i = 0;
        while (isPlaying) {
            if(creature.getPosition().equals(goal.getPosition())) {
                pauseSimulation();
                System.out.println("Вы выйграли за " + stepsCounter + " шагов");
            }
            worldMap.render();
            creature.makeMove(goal.getPosition());
            System.out.println("\n \n \n");
            stepsCounter++;

        }
    }

    public void pauseSimulation() {
        isPlaying = false;
    }
}
