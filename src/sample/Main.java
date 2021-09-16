package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

import java.awt.*;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Design stag = new Design();
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        Scene start = stag.mai(stage.getWidth(),stage.getHeight());
        stage.setScene(start);
        stage.show();
        final Integer[] u = new Integer[1];
        javafx.scene.control.Button[] button = stag.returnButton();
        javafx.scene.control.RadioButton[] radioButton = stag.returnRadioButton();
        javafx.scene.control.TextField[] textFields = stag.returnTextField();
        button[0].setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              stage.close();
       }
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        button[1].setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Scene scene = stag.players(stage,stage.getWidth(),stage.getHeight());
                stage.setScene(scene);
            }
        });
        button[2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               Scene scene = stag.mai(stage.getWidth(),stage.getHeight());
                stage.setScene(scene);
            }
        });
        for (int i=0;i<3;i++){
            int finalI = i;
            radioButton[i].selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    button[3].setVisible(true);
                    switch (finalI){
                        case 0:
                            textFields[3].setVisible(false);
                            textFields[2].setVisible(false);
                            u[0]=2;
                            break;
                        case 1:
                            textFields[3].setVisible(false);
                            textFields[2].setVisible(true);
                            u[0]=3;
                            break;
                        case 2:
                            textFields[3].setVisible(true);
                            textFields[2].setVisible(true);
                            u[0]=4;
                            break;
                    }
                }
            });
        }
        button[3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene = stag.proposal(stage.getWidth(),stage.getHeight(),u[0]);
                stage.setScene(scene);

            }
        });
        button[4].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stag.saveProp(stag.AtTheMoment);
                Scene scene = stag.proposal(stage.getWidth(),stage.getHeight(),u[0]);
                System.out.println(stag.AtTheMoment);
                if (stag.AtTheMoment >= u[0]) {
                    stag.AtTheMoment=-1;
                    button[5].setVisible(true);
                    button[4].setVisible(false);
                    textFields[4].setVisible(false);
                    button[5].setText("Далее");
                }

                stage.setScene(scene);


            }
        });
        Paint paint = new Paint();
        javafx.scene.canvas.Canvas canvas = paint.canv(stage.getWidth(), stage.getHeight());
        button[5].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                Scene scene = stag.game(stage.getWidth(),stage.getHeight(),canvas);
                stage.setScene(scene);
                button[5].setVisible(false);
            }
        });

        button[6].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                paint.save(canvas,(int)stage.getWidth(),(int)stage.getHeight(), stag.str[stag.AtTheMoment]);
                final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
                graphicsContext.clearRect(0, 0, stage.getWidth(), stage.getHeight());
                Scene scene = stag.game(stage.getWidth(),stage.getHeight(),canvas);
                if (stag.AtTheMoment == u[0]) {
                    stag.AtTheMoment = -1;
                    button[6].setVisible(false);
                    button[7].setVisible(true);
                }
                stage.setScene(scene);//2

            }
        });
        button[7].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Scene scene = stag.saves(stage.getWidth(),stage.getHeight(), u[0]);
                stage.setScene(scene);
                button[7].setVisible(false);
                button[8].setVisible(true);
            }
        });
        button[8].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stag.der[stag.AtTheMoment] = stag.proposa.getText();
                Scene scene = stag.saves(stage.getWidth(),stage.getHeight(), u[0]);
                stage.setScene(scene);

                if (stag.AtTheMoment == u[0]-1) {
                    stag.der[stag.AtTheMoment] = stag.proposa.getText();
                    button[8].setVisible(false);
                    stag.AtTheMoment=-1;
                    button[9].setVisible(true);
                }

            }
        });
        button[9].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Scene scene = stag.end(stage.getWidth(),stage.getHeight());
                stage.setScene(scene);
                if (stag.AtTheMoment == u[0]-1) {
                    stag.der[stag.AtTheMoment] = stag.proposa.getText();
                    button[9].setVisible(false);
                    stag.AtTheMoment=-1;
                    button[10].setVisible(true);
                }
            }
        });
        button[10].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
          stage.close();
            }
        });
    }
}