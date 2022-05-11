public class SafeHouse extends SafeLoc {

    public SafeHouse(Player player){
        super(player, "Safe House");
    }

    @Override

    public boolean onLocation(){
        System.out.println("You are in SAFE HOUSE right now");
        System.out.println("You spirit is renew in this place");
        return true;
    }





}