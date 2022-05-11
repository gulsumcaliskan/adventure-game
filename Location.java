//bir sey uretilmesini istemedigim icin abstract tanimladik

import java.util.Scanner;

public abstract class Location {

    private String name;
    private Player player;

    private Scanner input = new Scanner(System.in); // alt sınıflara arismek icin protected kullandık

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation(); // tum alt sınıflarda bu metotu yazsin
    
    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
