import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main {

    public static volatile int order = 1, battle = 1, gameState = 1;
    public static String replica = "";
    public static final Object o = new Object();
    public static boolean allyTurn = true;
    public static volatile boolean choseCharacters=false;
    public static Thread tFighter1, tFighter2;
    public static int characterOrder;
    public static Character myCharacter , enemyCharacter;
    public static Fighter1 fighter1;
    public static Fighter2 fighter2;
    public static GUI gui=new GUI();
    public static void main(String[] args) throws Exception {

        Scanner scanString = new Scanner(System.in);

        Character c1 = new Character("Levi", 10, 13, 100);
        Character c2 = new Character("Eren", 11, 12, 100);
        Character c3 = new Character("Armin", 14, 11, 100);
        Character c4 = new Character("Lady Dexdra", 15, 10, 110);
        CharacterList list = new CharacterList();
        list.addCharacter(c1);
        list.addCharacter(c2);
        list.addCharacter(c3);
        list.addCharacter(c4);
        gui.createCharacterButtons();
        gui.createFightButtons();
        GUI.setList();




        do {

                GUI.setPicture("bataiefundal.png");
                GUI.showList();
                GUI.viewCharacterButtons();
           // System.out.println("Alege unul dintre campioni: ");
            //list.showList();
            choseCharacters=false;
            characterOrder=1;
           // allyTurn = true;
            while(!choseCharacters){
               Thread.onSpinWait();
            }
            GUI.unshowList();
            GUI.unviewCharacterButtons();
            while(battle==1){
                Thread.onSpinWait();
            }
            while(!GUI.gameDecision){
                Thread.onSpinWait();
            }


               /* fighter1 = new Fighter1(myCharacter, enemyCharacter);
                fighter2 = new Fighter2(enemyCharacter, myCharacter);
                tFighter1 = new Thread(fighter1, "Ally");
                tFighter2 = new Thread(fighter2, "Enemy");
                battle = 1;

                tFighter1.start();
                tFighter2.start();
                try {
                    tFighter1.join();
                    tFighter2.join();
                } catch (Exception e) {
                }

                */

/*
                boolean ok = false;
                if (battle == 0) {
                    tFighter1.stop();
                    tFighter2.stop();
                    System.out.println("Mai vrei sa joci? ( Yes / No )");
                    while (!ok) {
                        replica = scanString.nextLine();
                        if (replica.equals("Yes")) {
                            ok = true;

                            try {
                                Thread.sleep(500);
                            } catch (Exception e) {
                            }
                        } else if (replica.equals("No")) {
                            gameState = 0;
                            ok = true;
                        } else {
                            System.out.println("Nu am inteles. Te ros sa scrii Yes / No");
                        }
                    }
                }

 */
        }while (gameState == 1) ;

    }

/*
        @Override
        public void actionPerformed (ActionEvent e){
            for (int i = 1; i <= CharacterList.count; i++) {
                if (e.getSource() == GUI.characterButtons[i]) {
                    GUI.textField.setText(CharacterList.getChampionName(i));
                    GUI.viewSelectButton();
                }
            }
            if(e.getSource()== GUI.selectButton){
                if(characterOrder==1){
                    for (int i = 1; i <= CharacterList.count; i++) {
                        if (CharacterList.list[i].name.equals(GUI.textField.getText())) {
                            myCharacter=CharacterList.list[i];
                        }
                    }
                    GUI.unviewSelectButton();
                    GUI.textField.setText("Acum alege-ti inamicul!");
                    characterOrder++;
                }
                else if(characterOrder==2){
                    for (int i = 1; i <= CharacterList.count; i++) {
                        if (CharacterList.list[i].name.equals(GUI.textField.getText())) {
                            enemyCharacter=CharacterList.list[i];
                        }
                    }
                    GUI.unviewCharacterButtons();
                    GUI.unviewSelectButton();
                    GUI.unshowList();
                    GUI.showTextArea();
                    GUI.showEnemyArea();
                    characterOrder++;
                    Main.choseCharacters=true;
                    battle=1;
                    fighter1=new Fighter1(myCharacter,enemyCharacter);
                    fighter2=new Fighter2(enemyCharacter,myCharacter);
                    tFighter1=new Thread(fighter1);
                    tFighter2=new Thread(fighter2);
                    GUI.setPicture("binitial.png");
                    GUI.textArea.setText("Ce vrei sa faci: Attack/ Defend/ Surrender?");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

 */


}
