package codingdojo;

public class Inventory {
    private final Equipment equipment;

    Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    Equipment getEquipment() {
        return equipment;
    }

    public int getTotalDamage(float strengthModifier) {
        return getEquipment().calculateTotalDamage(strengthModifier);
    }
}
