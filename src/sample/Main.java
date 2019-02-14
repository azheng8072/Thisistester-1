package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Main extends Application {

    Scene scene1, scenebtwn, scene2, scene3, scene4, scene5;

    //add the police song message in a bottle or one of the instrumentals or both?
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Message In A Bottle");
        Label desc = new Label();

//Scene 1
        Pane layout1 = new Pane();
        Label opening = new Label("Message In A Bottle");
        Button start = new Button("Start");
        opening.relocate(300, 300);
        start.relocate(450, 550);
        start.setOnAction(event -> primaryStage.setScene(scenebtwn));
        layout1.getChildren().addAll(opening, start);
        opening.setId("op");
        start.setId("st");
        scene1 = new Scene(layout1, 1200, 800);
        layout1.setId("s1");

        Pane layoutbtwn = new Pane();
        Label instructions = new Label("You and your friend are looking for treasure! \n Click the next bottle to read its message rules. \n Send messages according to the rules and \n figure out the location of the treasure!");
        Button setoff = new Button("Set off!");
        instructions.relocate(250, 200);
        setoff.relocate(450, 550);
        setoff.setOnAction(event -> primaryStage.setScene(scene2));
        layoutbtwn.getChildren().addAll(instructions, setoff);
        scenebtwn = new Scene(layoutbtwn, 1200, 800);
        setoff.setId("stoff");
        instructions.setId("in");
        layoutbtwn.setId("sbtwn");
//Scene 2
        Label label2 = new Label("This is the second scene");
        Button button2 = new Button("Go to scene 3");
        button2.setOnAction(event -> primaryStage.setScene(scene3));

        //MAINGAMESETUP
        Button bot1 = new Button("BOTTLE1");
        Button bot2 = new Button("BOTTLE2");
        Button bot3 = new Button("BOTTLE3");
        Button bot4 = new Button("BOTTLE4");
        Button bot5 = new Button("BOTTLE5");
        Button bot6 = new Button("BOTTLE6");
        Button yourship = new Button("");
        Button theirship = new Button("");
        Button treasureisland = new Button("");
        Button bottleinst = new Button("                    \n                     \n                     \n                     \n");

        bot1.setId("b1");
        bot2.setId("b2");
        bot3.setId("b3");
        bot4.setId("b4");
        bot5.setId("b5");
        bot6.setId("b6");

        yourship.setId("yours");
        theirship.setId("theirs");
        treasureisland.setId("treasure");
        bottleinst.setId("btlemain");
        yourship.relocate(50.0, 400.0);
        theirship.relocate(300.0, 100.0);
        treasureisland.relocate(850, 500);
        bottleinst.relocate(10, 700);
        //bottleinst.resize(1000,100);
        //ENDOFMAINGAMESETUP


        Pane layout2 = new Pane();
        layout2.getChildren().addAll(label2, button2, bot1, bot2, bot3, bot4, bot5, bot6, yourship, theirship, treasureisland, desc, bottleinst);

        bot1.relocate(215.0, 215.0);
        bot1.resize(70.0, 70.0);
        bot2.relocate(327, 365);
        bot2.resize(70.0, 70.0);
        bot3.relocate(510.0, 145.0);
        bot3.resize(70.0, 70.0);
        bot4.relocate(613.0, 338.0);
        bot4.resize(70.0, 70.0);
        bot5.relocate(792.0, 215.0);
        bot5.resize(70.0, 70.0);
        bot6.relocate(933.0, 390.0);
        bot6.resize(70.0, 70.0);
        layout2.setId("s2");

        desc.resize(1000, 200);
        desc.relocate(100, 700);
        desc.setText("Time to start your voyage! Click on the first bottle.");
        desc.setId("dsc");

        Label criteria = new Label("Bottle Rules \n");

        scene2 = new Scene(layout2, 1200, 800);


        bot1.setOnAction(event -> Controller.clickedButton(desc, 1, primaryStage, scene3, bot1, criteria));
        bot2.setOnAction(event -> Controller.clickedButton(desc, 2, primaryStage, scene3, bot2, criteria));
        bot3.setOnAction(event -> Controller.clickedButton(desc, 3, primaryStage, scene3, bot3, criteria));
        bot4.setOnAction(event -> Controller.clickedButton(desc, 4, primaryStage, scene3, bot4, criteria));
        bot5.setOnAction(event -> Controller.clickedButton(desc, 5, primaryStage, scene3, bot5, criteria));
        bot6.setOnAction(event -> Controller.clickedButton(desc, 6, primaryStage, scene3, bot6, criteria));
        yourship.setOnAction(event -> Controller.clickedYourShip(desc));
        theirship.setOnAction(event -> Controller.clickedTheirShip(desc));
        treasureisland.setOnAction(event -> Controller.clickedIsland(desc));
        bottleinst.setOnAction(event -> Controller.clickedmain(desc));
//Scene 3
        Label label3 = new Label("This is the third scene");
        Button button3 = new Button("Go to scene 4");
        button3.setOnAction(event -> primaryStage.setScene(scene4));
        Pane layout3 = new Pane();


        TextArea userbox = new TextArea("Start writing!");
        //Label criteria = new Label("Bottle Rules \n");
        userbox.setId("usebx");
        criteria.setId("crit");
        userbox.setWrapText(true);
        userbox.relocate(10, 50);
        criteria.relocate(670, 50);
        criteria.resize(300, 1100);

        Button submitMessage = new Button("Send Message");
        submitMessage.setId("submsg");
        submitMessage.setOnAction(event -> Controller.submitmsg(userbox, primaryStage, scene2));
        submitMessage.relocate(400, 550);

        layout3.getChildren().addAll(label3, button3, userbox, criteria, submitMessage);
        scene3 = new Scene(layout3, 1200, 800);
        layout3.setId("s3");


        //Scene 4
        Label label4 = new Label("This is the fourth scene");
        Button button4 = new Button("Go to scene 1");
        button4.setOnAction(event -> primaryStage.setScene(scene5));
        Pane layout4 = new Pane();
        layout4.getChildren().addAll(label4, button4);
        scene4 = new Scene(layout4, 1200, 800);
        layout4.setId("s4");

        Label label5 = new Label("This is the fifth scene");
        Button button5 = new Button("Go to scene 1");
        button5.setOnAction(event -> primaryStage.setScene(scene1));
        Pane layout5 = new Pane();
        Label endstory = new Label(readstory());
        layout5.getChildren().addAll(label5, button5, endstory);
        scene5 = new Scene(layout5, 1200, 800);
        layout5.setId("s5");

        layout1.getStylesheets().add("/sample/bottlestyle.css");
        layoutbtwn.getStylesheets().add("/sample/bottlestyle.css");
        layout2.getStylesheets().add("/sample/bottlestyle.css");
        layout3.getStylesheets().add("/sample/bottlestyle.css");
        layout4.getStylesheets().add("/sample/bottlestyle.css");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private String readstory() {
        List<Message> messages = CSVReader.readCSV("src/writtenmsg.txt");
        String fullstory = "";

        for (Message m : messages) {
            fullstory = fullstory + m.readStory();
        }
        return fullstory;
    }

}







    //NOTES
    //Label label1= new Label("This is the first scene"); This contains text. It can be text or an image. Here, a text box is placed and defined as label1 with the quote inside displayed.
    //Button button1= new Button("Go to scene 2"); This creates a button, the text inside is what will be on it
    //button1.setOnAction(e -> primaryStage.setScene(scene2)); This sets an action for the button to have. setScene is built in. We have to create new scenes.
    //VBox layout1 = new VBox(20); This reopens the virtual box, but it keeps it at the same size
    //layout1.getChildren().addAll(label1, button1); This function adds the label and button as children of the virtual box
    //scene1= new Scene(layout1, 300, 250); This initializes the first scene. The first scene is the layout with its children and the size is set up.
    //for the stylesheet to work you gotta add it to the layout and set ids for the things you make here
    //whatamidoingnow i should start with the third scene, the main game, and make buttons with images of bottles. The buttons will have to work.
    //plan - first scene title, second instructions, third main game, fourth bottle main game, fifth level results, sixth end game??
    //either way i can just work on the main game, THEN set it permanently to a scene. Scene for now will be scene #2.
    //now how in the world do i do this? first - make the buttons and place them second make them do something.
    //


