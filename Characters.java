
public class Characters {
    private int id;
    private String characterName;
    private int health;
    private int damage;
    private int money;

    public Characters(int id, String characterName, int health, int damage, int money){ ////encapsulation uygulanacak. disaridan erisilmesin
    //digerlerini kullanıcıya sectireceigimiz icin constructora yazmiyoruz
        this.id = id;
        this.characterName = characterName;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCharacterName(){
        return characterName;
    }

    public void setCharacterName(String characterName){
        this.characterName = characterName;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money = money;
    }

    //public void selectChar()








}