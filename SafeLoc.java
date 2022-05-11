public class SafeLoc extends Location {

    public SafeLoc(Player player, String name){
        super(player, name);
    }

    @Override

    public boolean onLocation(){
        return true; // safe loclarda olme ihtimalim olmadigi icin true donecek
    }





}
