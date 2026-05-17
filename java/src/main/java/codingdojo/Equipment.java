package codingdojo;


import java.util.List;

public class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Item leftHand;
    private final Item rightHand;
    private final Item head;
    private final Item feet;
    private final Item chest;
    private final Item ring;


    public Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest, Item ring) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
        this.ring = ring;
    }

    List<Item> allItems(){
        return List.of(leftHand, rightHand, head, feet, chest, ring);
    }

    public int getBaseDamage() {
        return allItems().stream().mapToInt(Item::getBaseDamage).sum();
    }
    public float getDamageModifier() {
        return (float) allItems().stream().mapToDouble(Item::getDamageModifier).sum();
    }
}
