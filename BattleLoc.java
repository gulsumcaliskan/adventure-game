
public class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Monster monster, Player player, String name, String award, int maxMonster){
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override

    public boolean onLocation(){
        
    }





}
