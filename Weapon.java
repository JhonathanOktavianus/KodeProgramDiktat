/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public interface Weapon {
    void attack(GameCharacter attacker, GameCharacter enemy);

    int getDamage();
}
