package sample;

import java.io.File;
import java.io.IOException;
import java.io.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.awt.*;

public class Design {
    Integer s;
    Button close = new Button("X");
    Button startGame = new Button("Game");
    Button back = new Button("Назад");
    Button further = new Button("Далее");

    Scene mai(Double x, Double y){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        AtTheMoment=-1;
        close.setPrefHeight(0.03 * dim.getHeight());
        close.setPrefWidth(0.03 * dim.getWidth());
        startGame.setPrefWidth(0.16 * dim.getWidth());
        startGame.setPrefHeight(0.06 * dim.getHeight());
        close.setLayoutX(dim.getWidth()  - close.getPrefWidth());
        close.setLayoutY(0);
        startGame.setLayoutX((dim.getWidth() - startGame.getPrefWidth())/2);
        startGame.setLayoutY(dim.getHeight()/2 + startGame.getPrefHeight());
        startGame.setId("Ngame");
        Pane root = new Pane(close,startGame);
        root.setId("pane");
        Scene scene = new Scene(root,x,y);
        scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
        return scene;
    }
    RadioButton play2 = new RadioButton("2 Игрока");
    RadioButton play3 = new RadioButton("3 Игрока");
    RadioButton play4 = new RadioButton("4 Игрока");
    TextField nickname1 = new TextField();
    TextField nickname2 = new TextField();
    TextField nickname3 = new TextField();
    TextField nickname4 = new TextField();
    TextField proposa = new TextField();
    TextField[] nickname = new  TextField[]{nickname1,nickname2,nickname3,nickname4,proposa};
    String[] nickP = new String[]{"Player1","Player2","Player3","Player4"};
    RadioButton[] players = new RadioButton[]{play2,play3,play4};


    Scene players(Stage stage, Double x,Double y){

        back.setPrefWidth(x*0.3);
        back.setPrefHeight(y*0.1);
        back.setLayoutX(0);
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i<3;i++ ){
         players[i].setToggleGroup(group);
         players[i].setId("radiobutton");
         players[i].setPrefWidth(x*0.2);
         players[i].setLayoutY(y/4);
        }
        play2.setLayoutX(x/4 - play2.getPrefWidth()/2);
        play3.setLayoutX(x/2 - play2.getPrefWidth()/2);
        play4.setLayoutX((3*x)/4 - play2.getPrefWidth()/2);
        back.setLayoutY(y-back.getPrefHeight());
        further.setPrefWidth(x*0.3);
        further.setPrefHeight(y*0.1);
        further.setLayoutX(x-further.getPrefWidth());
        further.setLayoutY(y-further.getPrefHeight());
        further.setId("Ngame");
        back.setId("Ngame");
        for (int i = 0; i<4;i++ ){
            nickname[i].setPrefHeight(y*0.04);
            nickname[i].setPrefWidth(x*0.1);
            nickname[i].setText(nickP[i]);
            if (i>=2){
                nickname[i].setVisible(false);
            }
        }
        nickname1.setLayoutX(x/4 - nickname1.getPrefWidth()/2);
        nickname1.setLayoutY(y*0.75-nickname1.getPrefHeight());
        nickname2.setLayoutX(x/4 - nickname2.getPrefWidth()/2);
        nickname2.setLayoutY(y*0.75+nickname2.getPrefHeight());
        nickname3.setLayoutX(x*0.75 - nickname3.getPrefWidth()/2);
        nickname3.setLayoutY(y*0.75-nickname3.getPrefHeight());
        nickname4.setLayoutX(x*0.75 - nickname4.getPrefWidth()/2);
        nickname4.setLayoutY(y*0.75+nickname4.getPrefHeight());
        further.setVisible(false);
        Pane root = new Pane(back,further,play2,play3,play4,nickname1,nickname2,nickname3,nickname4);

        root.setId("pane");
        Scene scene = new Scene(root,x,y);
        scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
        return scene;
    }

    Label gamer1 = new Label(nickname1.getText());
    Label gamer2 = new Label(nickname2.getText());
    Label gamer3 = new Label(nickname3.getText());
    Label gamer4 = new Label(nickname4.getText());
    Label[] gamers = new Label[]{gamer1,gamer2,gamer3,gamer4};
    Integer AtTheMoment;
    Button next = new Button();
    Button d = new Button();


    Scene game(double x,double y, javafx.scene.canvas.Canvas canvas){
        AtTheMoment++;
        proposa.setPrefWidth(x/2);
        proposa.setLayoutX(x/2 - proposa.getPrefWidth()/2);
        proposa.setLayoutY(20);
        proposa.setVisible(true);
        proposa.setText(fras[AtTheMoment]);
        serch.setVisible(true);

        d.setLayoutX(further.getLayoutX());
        d.setLayoutY(further.getLayoutY());
        d.setPrefWidth(further.getPrefWidth());
        d.setPrefHeight(further.getPrefHeight());
        d.setVisible(false);
        Pane root1 = new Pane(canvas);
        root1.setId("paint");
        root1.setLayoutX((x/2- canvas.getWidth()/2));
        root1.setLayoutY((y/2- canvas.getHeight()/2));
        Pane root = new Pane(root1,next,futh,serch,d,proposa);
        root.setId("pane");
        Scene scene = new Scene(root,x,y);
        scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
        return scene;
    }

    Button futh = new Button("Далее");
    Button serch = new Button("Trebee");
    String[] str1 = new String[5];
    String[] str = new String[]{"src/sample/graphic/player1/img.png","src/sample/graphic/player2/img.png",
            "src/sample/graphic/player3/img.png","src/sample/graphic/player4/img.png","src/sample/graphic/player4/img.png"};
    String[] txt1 = new String[5];
    String[] txt = new String[]{"src/sample/graphic/player1/e.txt","src/sample/graphic/player2/e.txt",
            "src/sample/graphic/player3/e.txt","src/sample/graphic/player4/e.txt","src/sample/graphic/player4/e.txt"};

    int[] pictures = new int[4];
    int[] words = new int[4];
    Scene  proposal(Double x, Double y,Integer play){
        ret(play);
        if (play ==2){
            for (int i = 0; i<play;i++){
                txt1[i]=txt[words[i]];
                str1[i]=str[pictures[i]];
            }
        }else {
            for (int i = 0; i<play;i++){
                txt1[i]=txt[words[i]-1];
                str1[i]=str[pictures[i]-1];
            }
        }


        next.setVisible(false);
        serch.setVisible(false);
        AtTheMoment++;
        proposa.setText("");
        next.setLayoutX(further.getLayoutX());
        next.setLayoutY(further.getLayoutY());
        next.setPrefWidth(further.getPrefWidth());
        next.setPrefHeight(further.getPrefHeight());

        serch.setLayoutX(further.getLayoutX());
        serch.setLayoutY(further.getLayoutY());
        serch.setPrefWidth(further.getPrefWidth());
        serch.setPrefHeight(further.getPrefHeight());
        futh.setLayoutX(further.getLayoutX());
        futh.setLayoutY(further.getLayoutY());
        futh.setPrefWidth(further.getPrefWidth());
        futh.setPrefHeight(further.getPrefHeight());
        serch.setId("Ngame");
        next.setId("Ngame");
        futh.setId("Ngame");
        proposa.setPrefWidth(x/2);
        proposa.setLayoutX(x/2 - proposa.getPrefWidth()/2);
        proposa.setLayoutY(y*0.75);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(y/2);
        imageView.setFitWidth(x/2);
        imageView.setLayoutX(x/2-imageView.getFitWidth()/2);
        imageView.setLayoutY(20);
        try {
            Image image = new Image(str[AtTheMoment]);
            imageView.setImage(image);
        } catch (IllegalArgumentException ignored){}


        Pane root = new Pane(imageView,futh,proposa,next,serch,d);
        root.setId("pane");
        Scene scene = new Scene(root,x,y);
        scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
        return scene;
    }
TextField[] returnTextField(){
        return nickname;
}
    RadioButton[] returnRadioButton(){
        return players;
    }

    Button[] returnButton(){
        Button[] bt = new Button[]{close,startGame,back,further,futh,next,serch,d,end,skip,ending,harvest};
        return bt;
    }
String[] fras = new String[5];
    void saveProp(int x){
        fras[x] = proposa.getText();
    }
    Button end = new Button();
void ret(int r){
    switch (r){
        case 2:
            pictures[0]=1;
            pictures[1]=0;
            words[0]=0;
            words[1]=1;
            break;
        case 3:
            pictures = new int[]{3, 1, 2, -1};
            words=new  int[]{2, 3, 1, -1};
            break;
        case 4:
            pictures = new int[]{2, 4, 1, 3};
            words=new  int[]{4, 3, 1, 2};
            break;
    }
}
String[] der = new String[4];

Scene saves(Double x, Double y, int play){


    AtTheMoment++;
    proposa.setText("");
    d.setVisible(false);
    skip.setLayoutX(further.getLayoutX());
    skip.setLayoutY(further.getLayoutY());
    skip.setPrefWidth(further.getPrefWidth());
    skip.setPrefHeight(further.getPrefHeight());
    skip.setVisible(false);
   skip.setId("Ngame");

    end.setLayoutX(further.getLayoutX());
    end.setLayoutY(further.getLayoutY());
    end.setPrefWidth(further.getPrefWidth());
    end.setPrefHeight(further.getPrefHeight());

    end.setId("Ngame");
    proposa.setPrefWidth(x/2);
    proposa.setLayoutX(x/2 - proposa.getPrefWidth()/2);
    proposa.setLayoutY(y*0.75);
    ImageView imageView = new ImageView();
    imageView.setFitHeight(y/2);
    imageView.setFitWidth(x/2);
    imageView.setLayoutX(x/2-imageView.getFitWidth()/2);
    imageView.setLayoutY(20);
    File file = new File(str1[AtTheMoment]);
    try {
        InputStream io = new FileInputStream(file);
        Image img = new Image(io);

        imageView.setImage(img);
    } catch (IllegalArgumentException | FileNotFoundException ignored){}


    Pane root = new Pane(imageView,futh,proposa,d,end,skip);
    root.setId("pane");
    Scene scene = new Scene(root,x,y);
    scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
    return scene;
}
Button skip = new Button("Далее");
Button ending= new Button("Выход");
TextField child = new TextField();
    TextField chile = new TextField();
Button harvest = new Button();
Scene end(Double x, Double y){
    AtTheMoment++;
    ImageView imageView = new ImageView();
    imageView.setFitHeight(y/2);
    imageView.setFitWidth(x/2);
    imageView.setLayoutX(x/2-imageView.getFitWidth()/2);
    imageView.setLayoutY(y*0.25);
    imageView.setVisible(true);
    File file = new File(str1[AtTheMoment]);
    try {
        InputStream io = new FileInputStream(file);
        Image img = new Image(io);

        imageView.setImage(img);
    } catch (IllegalArgumentException | FileNotFoundException ignored){}
    harvest.setLayoutX(further.getLayoutX());
    harvest.setLayoutY(further.getLayoutY());
    harvest.setPrefWidth(further.getPrefWidth());
    harvest.setPrefHeight(further.getPrefHeight());
    harvest.setVisible(false);
    harvest.setId("Ngame");
    ending.setLayoutX(further.getLayoutX());
    ending.setLayoutY(further.getLayoutY());
    ending.setPrefWidth(further.getPrefWidth());
    ending.setPrefHeight(further.getPrefHeight());
    ending.setVisible(false);
    ending.setId("Ngame");
    child.setPrefWidth(x/2);
    child.setLayoutX(x/2 - child.getPrefWidth()/2);
    child.setLayoutY(20);
    child.setText(der[AtTheMoment]);
    chile.setPrefWidth(x/2);
    chile.setLayoutX(x/2 - child.getPrefWidth()/2);
    chile.setLayoutY(y*0.9);
    chile.setText(fras[AtTheMoment]);
    Pane root = new Pane(imageView,child,chile,skip,ending,harvest);
    root.setId("pane");
    Scene scene = new Scene(root,x,y);
    scene.getStylesheets().addAll(this.getClass().getResource("graphic/style.css").toExternalForm());
    return scene;
}
    Button exitPlayers(){
        return close;
    }
}
