public class Character {
    public String name;
    public int attack,defense,health;
    public boolean allyAction=false;

    public Character(String name,int attack, int defense, int health){
        this.attack=attack;
        this.defense=defense;
        this.health=health;
        this.name=name;
    }


}
