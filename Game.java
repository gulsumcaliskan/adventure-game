import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in); // sadece bu sÄ±nÄ±f iÃ§inde kullanmak iÃ§in private tanÄ±mladÄ±k. public ile de tanÄ±mlanabilir


    public void start(){
        System.out.println("************ WELCOME TO THE ADVENTURE GAME ************");
        System.out.print("Please enter a player name: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName); //player nesnesi uretelim
        System.out.println("Welcome " + player.getName() + " to the darnest island in this galaxy");
        System.out.println("Please before the game, select any character... ");
        System.out.println("--------------------------------------");
        player.selectChar();

        Location location = null;
        
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("************ REGIONS ************");
            System.out.println();
            System.out.println("1- Safe House --> This place is a safe area for you");
            System.out.println("2- Shop --> You can buy weapon or armor");
            System.out.println("3- Cave --> Enter a cave. Be careful. You can encounter with a Zombie!! AWARD <FOOD>");
            System.out.println("4- Forest --> Enter a forest. Be careful. You can encounter with a Vampire! AWARD <FIREWOOD>");
            System.out.println("5- River --> Enter a river. Be careful. You can encounter with a Bear! AWARD <WATER>");
            System.out.println("0- Exist --> Oyunu sonlandır.");
            System.out.print("Please select area that you want to go:");
            
            int selectLoc = input.nextInt();

            switch (selectLoc) {

                // case 0 is used for exit
                case 0:
                    location = null;
                    System.out.println("You are leaving the game..\tHope to see you soon again");
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Please enter a valid number");
    //                break;
            }

//            System.out.println(location.getName());


            if(location == null){
                System.out.println("The game is over!! Please come in here again");
                break;
            }


            if(!location.onLocation()){
                System.out.println("GAME OVER!!!!!!");
                break;
            }
            
        }
    }

    


}