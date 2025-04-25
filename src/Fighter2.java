import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fighter2 implements Runnable{
    public Character myCharacter,myEnemy;
    public  int enemyBehaviour;
    public  int allyAttack;
    public  int allyDefense;
    public  int allyHealth;
    public  int enemyAttack;
    public int enemyDefense;
    public  int enemyHealth;
    public  String allyName,enemyName;
    //public static Object o=new Object();
    public Fighter2(Character myCharacter,Character myEnemy) {
        /* this.allyAttack = myCharacter.attack;
        this.allyDefense = myCharacter.defense;
        this.allyHealth = myCharacter.health;
        this.enemyAttack = myEnemy.attack;
        this.enemyDefense = myEnemy.defense;
        this.enemyHealth = myEnemy.health;
        this.allyName = myCharacter.name;
        this.enemyName = myEnemy.name;
        */
        this.myCharacter=myCharacter;
        this.myEnemy=myEnemy;
    }

    @Override
    public void run() {
        // while(this.myCharacter.didAction){
        //    try{
        //      wait();
        //    }catch (Exception e) {}
        // }
        synchronized (Main.o){
            while(Main.battle==1){

                while(Main.allyTurn){
                    try {
                        Main.o.wait();
                    } catch (InterruptedException e) {}
                }
                if(Main.battle==0){
                    Main.tFighter2.stop();
                }
                enemyBehaviour=Rambo.randInt(1,100);
                if(enemyBehaviour%2==1){
                    attack();
                    Main.order++;
                    if(enemyHealth==0){
                        System.out.println("Ai pierdut");
                        Main.battle=0;
                    }
                }else{
                    defend();
                    Main.order++;
                }
                Main.allyTurn=true;
                Main.o.notify();


            }
        }





    }

    public void attack() {
        int dealt = (int) (this.myCharacter.attack -(((float) this.myEnemy.defense / 100) * this.myCharacter.attack));
        this.myEnemy.health-=dealt;
        this.myCharacter.attack+=Rambo.randInt(1,5);
        if(this.myEnemy.health<0)
            this.myEnemy.health=0;
        GUI.textArea.append("\n"+this.myCharacter.name+" ti-a dat "+dealt+" DMG. Ai ramas cu "+this.myEnemy.health
                +" HP\n===================");
        //System.out.printf("%s Attacked %s with %d Damage %n %s Has %d Health left %n"
        //         ,allyName,enemyName,allyAttack,enemyName,enemyHealth);
        // System.out.println("=====================");

    }
    public void defend() {
        int defPlus=Rambo.randInt(1,9);
        if(this.myCharacter.defense+defPlus<50){
            this.myCharacter.defense+=defPlus;
            GUI.textArea.append("\n"+this.myCharacter.name+" si-a crescut defensiva cu "+defPlus
                    +".\nAcum are "+this.myCharacter.defense+" DEF\n===================");
        }else {
            this.myCharacter.defense=50;
            GUI.textArea.append("\n"+this.myCharacter.name+" a ajuns la nivelul maxim de Defense!" +
                    this.myCharacter.name+" are "+this.myCharacter.defense+" DEF\n===================");
        }

        //System.out.printf("%s Increased The Defense with : %d %n New Defense : %d %n"
        //       ,allyName,defPlus,allyDefense);

    }
    /*
public void attack() {
        int dealt = (int) (this.allyAttack -(((float) this.enemyDefense / 100) * this.allyAttack));
        this.enemyHealth-=dealt;
        if(this.enemyHealth<0)
            this.enemyHealth=0;
        GUI.textArea.append("\n"+this.allyName+" ti-a dat "+dealt+" DMG. Ai ramas cu "+this.enemyHealth
        +" HP\n===================");
        //System.out.printf("%s Attacked %s with %d Damage %n %s Has %d Health left %n"
       //         ,allyName,enemyName,allyAttack,enemyName,enemyHealth);
       // System.out.println("=====================");

    }


    public void defend() {
        int defPlus=Rambo.randInt(1,5);
        this.allyDefense+=defPlus;
        GUI.textArea.append("\n"+this.allyName+" si-a crescut defensiva cu "+defPlus
                +".\nAcum are "+this.allyDefense+" DEF\n===================");
        //System.out.printf("%s Increased The Defense with : %d %n New Defense : %d %n"
         //       ,allyName,defPlus,allyDefense);

    }
 */





}
