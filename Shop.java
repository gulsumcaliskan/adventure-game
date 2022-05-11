public class Shop extends SafeLoc {

    public Shop(Player player){
        super(player, "Shop Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("---------Welcome to the Shop Center!!-----------");
        System.out.println("Welcome " + this.getPlayer().getName() + " ... I'm a shop assistant. How can I halp you? What would you like to purchase");
        System.out.println();
        boolean showMenu = true;
        while(showMenu){
            System.out.println("You can purchase a weapon or an armor");
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exist");
            System.out.print("Your choise: ");

            int selectCase = Location.input.nextInt();
            while(selectCase < 1 || selectCase > 3){
            System.out.println("Invalid value, " + this.getPlayer().getName() +  " Please try again to enter new value:  ");
            selectCase = input.nextInt();
            }

            switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("You can visit our store again");
                showMenu = false;
                break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----- WEAPONS--------");
        System.out.println();
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + 
            "<Money: " + w.getPrice() + ", Damage: " + w.getDamage() + ">");
        }
        System.out.print("0 --> Exist ");
    }

    public void buyWeapon(){
        System.out.print("Choose a weapon: ");

        int selectWeaponID = input.nextInt();

        while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.print("Invalid value, please try again to enter valid value!!");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if(selectedWeapon != null){

                if(selectedWeapon.getPrice() > this.getPlayer.getMoney()){
                System.out.println("Insufficient balance!!");
                } else {
                // satin alma isleminin gerceklestigi alan
                System.out.println("You bought " + selectedWeapon.getName() + " as a weapons");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Rest Money: " + this.getPlayer().getMoney()); 
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("----- ARMORS --------");
        System.out.println();
        for(Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + 
            "<Price: " + a.getPrice() + ", Blocked: " + a.getBlocked() + ">");
            System.out.print("0 --> Exist ");
        }
    }

    public void buyArmor(){
        System.out.print("Choose a armor: ");

        int selectArmorID = input.nextInt();

        while(selectArmorID < 1 || selectArmorID > Armor.armors().length){
            System.out.print("Invalid value, please try again to enter valid value!!");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0) { //selectedArmorId != 0 silinebilir
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer.getMoney()){
                System.out.println("Insufficient balance!!");
                } else {
                // satin alma isleminin gerceklestigi alan
                System.out.println("You bought " + selectedArmor.getName() + " as a weapons");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Rest Money: " + this.getPlayer().getMoney()); 
                this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }

}