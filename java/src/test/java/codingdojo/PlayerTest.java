package codingdojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    Inventory inventory;
    Stats stats;

    @BeforeEach
    void  setup(){
        inventory = new Inventory(
                new Equipment(
                        new BasicItem("leftHand", 1, 2),
                        new BasicItem("rightHand", 3, 4),
                        new BasicItem("head", 5, 6),
                        new BasicItem("feet", 7, 8),
                        new BasicItem("chest", 9, 10)
                )
        );
        stats = new Stats(10);
    }


    @Test
    void damageCalculations() {
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(10) , List.of());

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(765, damage.getAmount());
    }
    @Test
    void damageCalculationsWithPlayer() {
        Player target = new Player(inventory, stats);

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(0, damage.getAmount());
    }

    static class UnkownTarget extends Target{
    }
    @Test
    void damageCalculationWithUnknownTarget(){
        UnkownTarget target = new UnkownTarget();

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(775, damage.getAmount());
    }

}
