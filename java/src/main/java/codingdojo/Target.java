package codingdojo;

public abstract class Target {

    public int getSoak(int totalDamage) {
        int soak = 0;
        if (this instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (this instanceof SimpleEnemy simpleEnemy) {
            soak = simpleEnemy.getSimpleSoak();
        }
        return soak;
    }
}
