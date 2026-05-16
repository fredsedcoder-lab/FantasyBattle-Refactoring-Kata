package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerTest {
    Item flashySwordOfDanger = new BasicItem("flashy sword of danger", 10, 1);
    Item excalibur = new BasicItem("excalibur", 20, 1.5f);
    Item roundShield = new BasicItem("round shield", 0, 1.4f);
    Item tenLeagueBoots = new BasicItem("ten-league boots", 0, .1f);
    Item helmetOfSwiftness = new BasicItem("helmet of swiftness", 0, 1.2f);
    Item breastplateOfSteel = new BasicItem("breastplate of steel", 0, 1.4f);


    // choose this one if you are familiar with mocks
    @Test
    void damageCalculationsWhenTargetEnemy() {
        final int STRENGTH = 20;
        final float STRENGTH_MODIFIER = STRENGTH * .1f;
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy simpleEnemy = mock(SimpleEnemy.class);
        when(stats.getStrength()).thenReturn(STRENGTH);
        when(inventory.getTotalDamage( STRENGTH * .1f)).thenReturn(61);
        when(simpleEnemy.getSoak()).thenReturn(1);

        Damage damage = new Player(inventory, stats).calculateDamage(simpleEnemy);

        verify(inventory).getTotalDamage(STRENGTH_MODIFIER);
        verify(stats).getStrength();
        verify(simpleEnemy).getSoak();
        assertEquals(60, damage.getAmount());
    }
    @Test
    void damageCalculationsWhenTargetPlayer() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        Player player = mock(Player.class);
        when(stats.getStrength()).thenReturn(10);
        when(inventory.getTotalDamage(1)).thenReturn(61);

        Damage damage = new Player(inventory, stats).calculateDamage(player);

        assertEquals(0, damage.getAmount());
    }

    static class otherTarget extends Target {};
    @Test
    void damageCalculationsWhenOtherTarget() {
        final int STRENGTH = 20;
        final float STRENGTH_MODIFIER = STRENGTH * .1f;
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        PlayerTest.otherTarget otherTarget = mock(PlayerTest.otherTarget.class);
        when(stats.getStrength()).thenReturn(STRENGTH);
        when(inventory.getTotalDamage(STRENGTH_MODIFIER)).thenReturn(122);


        Damage damage = new Player(inventory, stats).calculateDamage(otherTarget);

        assertEquals(122, damage.getAmount());
    }
}