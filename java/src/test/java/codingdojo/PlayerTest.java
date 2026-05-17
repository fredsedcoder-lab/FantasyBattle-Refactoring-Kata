package codingdojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  Inventory inventory;
  Stats stats;

  @BeforeEach
  void setup() {
    inventory =
        new Inventory(
            new Equipment(
                new BasicItem("leftHand", 1, 2),
                new BasicItem("rightHand", 3, 4),
                new BasicItem("head", 5, 6),
                new BasicItem("feet", 7, 8),
                new BasicItem("chest", 9, 10),
                new BasicItem("ring", 10, 11)));
    stats = new Stats(10, 10);
  }

  @Test
  void damageCalculations() {
    SimpleEnemy target = new SimpleEnemy(new SimpleArmor(10), List.of());

    Damage damage = new Player(inventory, stats).calculateDamage(target);

    assertEquals(1478, damage.getAmount());
  }

  @Test
  void damageCalculationsWithPlayer() {
    Player target = new Player(inventory, stats);

    Damage damage = new Player(inventory, stats).calculateDamage(target);

    assertEquals(744, damage.getAmount());
  }

  static class UnkownTarget extends Target {
    @Override
    public int getSoak(int totalDamage) {
      return 0;
    }
  }

  @Test
  void damageCalculationWithUnknownTarget() {
    UnkownTarget target = new UnkownTarget();

    Damage damage = new Player(inventory, stats).calculateDamage(target);

    assertEquals(1488, damage.getAmount());
  }
}
