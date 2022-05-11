public class SafeLoc extends Location {

    public SafeLoc(String name, Player player){
        super(name, player);
    }

    @Override

    public boolean onLocation(){
        return true; // safe loclarda olme ihtimalim olmadigi icin true donecek
    }





}