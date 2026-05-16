package codingdojo;


class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private Item leftHand;
    private Item rightHand;
    private Item head;
    private Item feet;
    private Item chest;

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    Item getLeftHand() {
        return leftHand;
    }
    Item getRightHand() {
        return rightHand;
    }
    Item getHead() {
        return head;
    }
    Item getFeet() {
        return feet;
    }
    Item getChest() {
        return chest;
    }

    public int calculateTotalDamage(float strengthModifier) {
        int baseDamage = calculateBaseDamage();
        float damageModifier = calculateDamageModifier(strengthModifier);
        return Math.round(baseDamage * damageModifier);
    }

    int calculateBaseDamage() {
        return leftHand.getBaseDamage() +
                rightHand.getBaseDamage() +
                head.getBaseDamage() +
                feet.getBaseDamage() +
                chest.getBaseDamage();
    }

    float calculateDamageModifier(float strengthModifier) {
        return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier();
    }
}
