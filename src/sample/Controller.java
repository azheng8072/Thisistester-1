package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;

import java.io.*;


public class Controller {
    public static int[] openedbtles = {0,0,0,0,0,0,0};
    public static int btlenum = 1;


    public static void submitmsg(TextArea text, Stage stage, Scene scene) {
        String usermessage = text.getText();
        System.out.println(usermessage);

        //ifrulesaremet
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter("src/writtenmsg.txt",true));
            output.append("" + btlenum);
            output.append(",");
            output.append(usermessage);

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btlenum = btlenum + 1;
        System.out.println(btlenum);
        stage.setScene(scene);
    }

    public static void clickedYourShip(Label texter) {
        texter.setText("This is your ship.");
    }

    public static void clickedTheirShip(Label texter) {
        texter.setText("This is your friend's ship.");
    }

    public static void clickedmain(Label texter) {texter.setText("Click on the next bottle."); }

    public static void clickedIsland(Label texter) {
        texter.setText("Could the treasure be here?");
    }

    public static void clickedButton(Label texter, int bottle, Stage stage, Scene scene, Button button, Label rulelist) {

        if(openedbtles[bottle] == 0) {
            texter.setText("Let's open bottle " + bottle + "!");
            button.setOpacity(0.3);
            //setanimation
            //wait(2000);
            //setanimation
            openedbtles[bottle] = bottle;
            String[] botrles = Message.setRules(bottle+2,bottle);
            String rulestring = "Bottle Rules \n";
            for(int i = 0; i < botrles.length;i++) {
               rulestring = rulestring + botrles[i] + "\n";
            }
            rulelist.setText(rulestring);
            stage.setScene(scene);
        }
        else
        {
            texter.setText("Bottle " + bottle + " has already been sent off.");
        }
    }

}
