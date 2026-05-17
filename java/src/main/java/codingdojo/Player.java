package codingdojo;


public class Player extends Target {
    private final Inventory inventory;
    private final Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    public Damage calculateDamage(Target other) {
        int baseDamage = inventory.getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = other.getSoak(totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    float getDamageModifier() {
        return stats.getStrengthModifier() + inventory.getDamageModifier();
    }

    @Override
    public int getSoak(int totalDamage) {
        return totalDamage/2;
    }
}
