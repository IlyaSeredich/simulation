package by.world;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      Simulation simulation = new Simulation(new WorldMap(10,5), new Creature(new Position(10,1)), new Goal(new Position(5,5)) );
      simulation.startSimulation();
    }
}
