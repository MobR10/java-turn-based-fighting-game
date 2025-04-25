public class CharacterList {
    public static Character[] list;
    public static int count;

    public CharacterList(){
        list =new Character[11];
        count=0;
    }

    public void addCharacter(Character character){
        if(count<10){
            count++;
            list[count]=character;
        }
        else {
            System.out.println("Nu mai este loc in lista");
        }


    }
    public void showList() {
        for(int i=1;i<=count;i++)
            System.out.printf("Nume: %s; Attack: %d; Defense: %d; Health: %d.%n",this.list[i].name
                    ,list[i].attack,list[i].defense,list[i].health);
    }
    public static String getChampionName(int i) {
        return list[i].name;
    }

}
