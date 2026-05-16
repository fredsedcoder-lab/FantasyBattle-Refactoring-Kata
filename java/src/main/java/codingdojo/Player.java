package codingdojo;


class Player extends Target {
    private Inventory inventory;
    private Stats stats;



    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }


    Damage calculateDamage(Target other) {
        int totalDamage = inventory.getTotalDamage(stats.getStrength() * 0.1f);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }


    int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy simpleEnemy) {
            soak = simpleEnemy.getSoak();
        }
        return soak;
    }

}
