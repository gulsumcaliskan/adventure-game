import java.util.Random;

public class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster){
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override

    public boolean onLocation(){
        System.out.println();
        int monsNumber = this.randomMonsterNumber();
        System.out.println("Now you are in <" + getName() +"> location.");
        System.out.println("Be careful, " + getMaxMonster() + " " + getMonster().getName() + " live in this neighboor");
        System.out.print("Fight(F) or Escape(E)?: ");
        String selectCase = input.nextLine().toUpperCase();
        
        if(selectCase.equals("F")){
            if(selectCase.equals("F") && combat(monsNumber)){
                System.out.println("You beated the all enemies in the " + this.getName());
                System.out.println();
                return true;
            }
            System.out.println("It will be process of the fight.");
        }

        if(this.getPlayer().getHealth() <= 0){
        	System.out.print("YOU DİED!!!!!");
        	return false;
        }
         
        return true;
    }

    public boolean combat(int monsNumber){
    	for(int i = 1; i <= monsNumber; i++){
    		this.getMonster().setHealth(this.getMonster().getOriginalHealth());
    		playerStats();
    		monsterStats(i);
    		while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
    			System.out.println("<H>it veya <E>scape: "); 
    			String selectCombat = input.nextLine().toUpperCase();
    			if(selectCombat.equals("H")){
    				System.out.println("You beat it!!");
    				this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
    				afterHit();
    				if(this.getMonster().getHealth() > 0){
    					System.out.println();
    					System.out.println("Monster beats you!");
    					int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlocked();
    					if(monsterDamage < 0){
    						monsterDamage = 0;
    					}
    					this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
    					afterHit();
    				}
    			}else{
    				return false;
    			}
    			
    		}
    		
    		if(this.getMonster().getHealth() < this.getPlayer(). getHealth()){
    			System.out.println("You beated the monster <" + this.getMonster().getName() + ">");
    			System.out.println("You earned " + this.getMonster().getAward() + " money");
    			this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
    			System.out.println("Your new balance is: " + this.getPlayer().getMoney());
    		}else {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public void afterHit(){
    	System.out.println("Your Health: " + this.getPlayer().getHealth());
    	System.out.println(this.getMonster().getName() + " Health: " + this.getMonster().getHealth());
    	System.out.println("----------");
    }
    
    public void playerStats(){
        System.out.println();
    	System.out.println("Player Values");
    	System.out.println("------------------------");
    	System.out.println("Health: " + this.getPlayer().getHealth());
    	System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
    	System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
    	System.out.println("Blocked: " + this.getPlayer().getInventory().getArmor().getBlocked());
    	System.out.println("Damage: " + this.getPlayer().getDamage());
    	System.out.println("Money: " + this.getPlayer().getMoney());
    	System.out.println();
    	
    }
    
    public void monsterStats(int i){
    	System.out.println(i + ". " + this.getMonster().getName() + "Values");
    	System.out.println("-------------------------");
    	System.out.println("Health: " + this.getMonster().getHealth());
    	System.out.println("Damage: " + this.getMonster().getDamage());
    	System.out.println("Award: " + this.getMonster().getAward());
    	System.out.println();	
    }

    public int randomMonsterNumber(){
        // 0, 1 + = 1, 2
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }


    public int getMaxMonster(){
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster){
        this.maxMonster = maxMonster;
    }

    public Monster getMonster(){
        return monster;
    }

    public void setMonster(Monster monster){
        this.monster = monster;
    }

    public String getAward(){
        return award;
    }
    
    public void setAward(String award){
        this.award = award;
    }    



}
