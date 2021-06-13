/**
 * @author 1972046 JHONATHAN OKTAVIANUS
 */
public class Sword extends Item implements Weapon{
    private Boolean Monster() {
        return true;
    }

    public Sword() {
        setName("Sword");
    }

    @Override
    public void attack(GameCharacter attacker, GameCharacter enemy) {

        if (((Monster)enemy).isFlyingUnit()) {
            System.out.println("Enemy out of range");
        } else{
            int damage = (int) Math.random()*attacker.getCurrentStrength();
            enemy.setCurrentHealth(enemy.getCurrentHealth()-damage);
            System.out.println("Hero do "+ damage +" damage to enemy");
        }
    }

    @Override
    public int getDamage() {
        return 9;
    }

    public String toString(){
        return String.format(getName(), getDamage());
    }
}
