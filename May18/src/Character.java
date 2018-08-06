public class Character {
    private int health;
    private int attack;
    private int defense;
    private int rarity;
    private String name;
    public final static int MAX_MOVES = 4;
    public Character(String n ,int h, int a, int d, int r){
        name = n;
        health = h;
        attack = a;
        defense = d;
        rarity = r;
    }
    public Character (String n, int h, int a, int d){
        name = n;
        health = h;
        attack = a;
        defense = d;
        rarity = 1;
    }
    public Character(){
        name = "";
        health = 1;
        attack = 1;
        defense = 1;
        rarity = 1;
    }
    public void setHealth(int h){
        health=h;
    }
    public void setAttack(int a){
        attack=a;
    }
    public void setDefense(int d){
        defense=d;
    }
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public String getName(){
        return name;
    }
    public void att(Character other){
        other.setHealth(other.getHealth()-this.attack+other.getDefense());
    }
    public void heal(int h){
        health+=h;
    }
    public void bAtt(int ba){
        attack+=ba;
    }
    public void bDef(int bd){
        defense+=bd;
    }
    public String toString(){
        return name + "\nHealth: " + health + "\nAttack: " + attack + "\nDefense: " + defense + "\nRarity: "+rarity;
    }
}
