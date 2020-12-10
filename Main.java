import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Management m = new Management();
    ImportData data = new ImportData(m);

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Title");
        stage.setWidth(700);
        stage.setHeight(300);
        stage.setResizable(false);


        stage.setScene(loadMainScreen(stage));
        stage.show();


    }

    public Scene loadMainScreen(Stage stage) {

        HBox inter = new HBox();


        Button b1 = new Button("Management");
        Button b2 = new Button("Owner");
        Button b3 = new Button("Exit");

        b1.setMinSize(199, 199);
        b1.setMaxSize(200, 200);

        b2.setMinSize(199, 199);
        b2.setMaxSize(200, 200);

        b3.setMinSize(199, 199);
        b3.setMaxSize(200, 200);


        b1.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b2.setStyle("-fx-background-color: #313D53;" +
                "-fx-text-fill: white");
        b3.setStyle("-fx-background-color: #313D53;" +
                "-fx-text-fill: white");


        inter.setSpacing(10);
        inter.setAlignment(Pos.CENTER);


        inter.getChildren().addAll(b1, b2, b3);
        inter.setStyle("-fx-background-color: #242524");
        Scene scene = new Scene(inter);


        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadManagement(stage));
                stage.show();

            }

        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadOwner(stage));
                stage.show();

            }

        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });

        return scene;
    }

    public Scene loadManagement(Stage stage) {

        GridPane root = new GridPane();

        HBox inter = new HBox();
        inter.setSpacing(5);
        inter.setPadding(new Insets(10, 0, 0, 30));
        inter.setAlignment(Pos.CENTER);


        HBox face = new HBox();
        face.setSpacing(5);
        face.setPadding(new Insets(20, 0, 10, 90));
        face.setAlignment(Pos.CENTER);


        Button b1 = new Button("List Owners");
        Button b2 = new Button("List Properties");
        Button b3 = new Button(" Get Property\nPayment Data");
        Button b4 = new Button("  Get Owner\nPayment Data");
        Button b5 = new Button("List Overdue Tax");
        Button b6 = new Button("Get Property\nTax Statistics");
        Button b7 = new Button("Tweak Rate\n Or Levies");
        Button b8 = new Button("Switch to CLI");
        Button b9 = new Button("Back");

        b1.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b2.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b3.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b4.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b5.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b6.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b7.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b8.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        b9.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        b1.setMinSize(119, 119);
        b1.setMaxSize(120, 120);

        b2.setMinSize(119, 119);
        b2.setMaxSize(120, 120);

        b3.setMinSize(119, 119);
        b3.setMaxSize(120, 120);

        b4.setMinSize(119, 119);
        b4.setMaxSize(120, 120);

        b5.setMinSize(119, 119);
        b5.setMaxSize(120, 120);

        b6.setMinSize(119, 119);
        b6.setMaxSize(120, 120);

        b7.setMinSize(119, 119);
        b7.setMaxSize(120, 120);

        b8.setMinSize(119, 119);
        b8.setMaxSize(120, 120);

        b9.setMinSize(119, 119);
        b9.setMaxSize(120, 120);

        GridPane.setConstraints(inter, 0, 0);
        GridPane.setConstraints(face, 0, 1);

        GridPane.setColumnSpan(inter, 3);
        GridPane.setRowSpan(face, 2);

        root.getChildren().add(inter);
        root.getChildren().add(face);
        root.setStyle("-fx-background-color: #242524");

        inter.getChildren().addAll(b1, b2, b3, b4, b5);
        face.getChildren().addAll(b6, b7, b8, b9);
        //inter.setStyle("-fx-background-color: #242524");
        //inter.getChildren().add(face);
        Scene scene = new Scene(root);

        b9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadMainScreen(stage));
                stage.show();
            }
        });

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadListOwners(stage));
                stage.show();
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadListProperties(stage));
                stage.show();
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadPropertyPayData(stage));
                stage.show();
            }
        });

        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadOwnerPaymentData(stage));
                stage.show();
            }
        });

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadOverdueTax(stage));
                stage.show();
            }
        });



        return scene;

    }

    public Scene loadListOwners(Stage stage){

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        Text t = new Text();
        String s = "";
        for(int i = 0; i < m.getOwners().size(); i++){
            s = s + "\n" + m.getOwners().get(i).getName();
        }
        t.setText(s);

        scroll.setContent(t);

        root.setCenter(scroll);
        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);
        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets( 0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);



        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();





        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });


        return scene;

    }
    public Scene loadListProperties(Stage stage) {

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        Text t = new Text();
        String s = "";
        for(int i = 0; i < m.getOwners().size(); i++){
            s = s + "\n" + m.getOwners().get(i).viewProperties();
        }
        t.setText(s);
        scroll.setContent(t);


        root.setTop(scroll);


        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets(0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);


        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);


        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });


        return scene;
    }
    public Scene loadPropertyPayData(Stage stage) {

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        root.setCenter(scroll);


        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(10, 10, 20, 10));
        hb2.setAlignment(Pos.CENTER);

        Label l1 = new Label("Eircode");
        TextField t1 = new TextField();
        hb2.getChildren().add(l1);
        hb2.getChildren().add(t1);
        l1.setStyle(" -fx-text-fill: white");

        Button entr = new Button("Enter");
        entr.setMinSize(59, 29);
        entr.setMaxSize(60, 30);

        entr.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        hb2.getChildren().add(entr);

        root.setTop(hb2);

        Text t = new Text();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String eircode = t1.getText();
                String s = "";
                for(int i = 0; i < m.getOwners().size(); i++){
                    for(int j = 0; j < m.getOwners().get(i).getProperties().size(); j++){
                        if(m.getOwners().get(i).getProperties().get(j).getEircode().equals(eircode)){
                            s = s + "\n" + m.getOwners().get(i).balancingStatement(m.getOwners().get(i).getProperties().get(j));
                        }
                    }
                }
                t.setText(s);
            }
        };
        t1.setOnAction(event);
        scroll.setContent(t);

        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets(0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);

        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);

        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });

        entr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent e)
                {
                    String eircode = t1.getText();
                    String s = "";
                    for(int i = 0; i < m.getOwners().size(); i++){
                        for(int j = 0; j < m.getOwners().get(i).getProperties().size(); j++){
                            if(m.getOwners().get(i).getProperties().get(j).getEircode().equals(eircode)){
                                s = s + "\n" + m.getOwners().get(i).balancingStatement(m.getOwners().get(i).getProperties().get(j));
                            }
                        }
                    }
                    t.setText(s);
                }
        });


        return scene;
    }
    public Scene loadOwnerPaymentData(Stage stage) {

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        root.setCenter(scroll);


        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(10, 10, 20, 10));
        hb2.setAlignment(Pos.CENTER);

        Label l1 = new Label("Name");
        TextField t1 = new TextField();
        hb2.getChildren().add(l1);
        hb2.getChildren().add(t1);
        l1.setStyle(" -fx-text-fill: white");

        Button entr = new Button("Enter");
        entr.setMinSize(59, 29);
        entr.setMaxSize(60, 30);

        entr.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        hb2.getChildren().add(entr);

        root.setTop(hb2);

        Text t = new Text();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String name = t1.getText();
                String s = "";
                ArrayList<String> ss = m.getPropertyTaxFromOwner(name);
                for(int i = 0; i < ss.size(); i++) {
                    s = s + "\n" + ss.get(i);
                }
                t.setText(s);
            }
        };
        t1.setOnAction(event);
        scroll.setContent(t);

        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets(0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);

        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);

        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });

        entr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = t1.getText();
                String s = "";
                ArrayList<String> ss = m.getPropertyTaxFromOwner(name);
                for (int i = 0; i < ss.size(); i++) {
                    s = s + "\n" + ss.get(i);
                }
                t.setText(s);
            }
        });
        return scene;
    }
    public Scene loadOverdueTax(Stage stage) {

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        root.setCenter(scroll);


        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(10, 10, 20, 10));
        hb2.setAlignment(Pos.CENTER);

        Label l1 = new Label("Year");
        TextField t1 = new TextField();
        hb2.getChildren().add(l1);
        hb2.getChildren().add(t1);
        l1.setStyle(" -fx-text-fill: white");

        Button entr = new Button("Enter");
        entr.setMinSize(59, 29);
        entr.setMaxSize(60, 30);

        entr.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        hb2.getChildren().add(entr);

        root.setTop(hb2);

        Text t = new Text();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                int year = Integer.parseInt(t1.getText());
                String ss = "";
                for (int i = 0; i < m.getOwners().size(); i++) {
                    ss = ss + "\n" + (m.getOwners().get(i).viewOverdueTax(year));
                }

                t.setText(ss);

            }
        };

        t1.setOnAction(event);
        scroll.setContent(t);

        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets(0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);

        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);

        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });

        entr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                int year = Integer.parseInt(t1.getText());
                String ss = "";
                for (int i = 0; i < m.getOwners().size(); i++) {
                    ss = ss + "\n" + (m.getOwners().get(i).viewOverdueTax(year));
                }

                t.setText(ss);

            }
        });
        return scene;
    }
    public Scene load(Stage stage) {

        BorderPane root = new BorderPane();

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 200);
        root.setCenter(scroll);


        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(10, 10, 20, 10));
        hb2.setAlignment(Pos.CENTER);

        Label l1 = new Label("Name");
        TextField t1 = new TextField();
        hb2.getChildren().add(l1);
        hb2.getChildren().add(t1);
        l1.setStyle(" -fx-text-fill: white");

        Button entr = new Button("Enter");
        entr.setMinSize(59, 29);
        entr.setMaxSize(60, 30);

        entr.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        hb2.getChildren().add(entr);

        root.setTop(hb2);

        Text t = new Text();

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String name = t1.getText();
                ArrayList<String> ss = new ArrayList<>();
                for (int i = 0; i < m.getOwners().size(); i++) {
                    if (m.getOwners().get(i).getName().equals(name)) {
                        ss = m.getOwners().get(i).viewOverdueTax();
                    }

                }
                String sss = "";
                for (int i = 0; i < ss.size(); i++){
                    sss = sss + ss.get(i);
                }
                t.setText(sss);
            }
        };
        t1.setOnAction(event);
        scroll.setContent(t);

        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button bk = new Button("Back");
        Button exit = new Button("Exit");

        bk.setPadding(new Insets(0, 0, 0, 0));

        bk.setMinSize(59, 29);
        bk.setMaxSize(60, 30);

        exit.setMinSize(59, 29);
        exit.setMaxSize(60, 30);

        bk.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        exit.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");

        bb.getChildren().addAll(bk, exit);
        root.setStyle("-fx-background-color: #242524");

        Scene scene = new Scene(root);

        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadManagement(stage));
                stage.show();
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.close();
            }
        });

        entr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String name = t1.getText();
                ArrayList<String> ss = new ArrayList<>();
                for (int i = 0; i < m.getOwners().size(); i++) {
                    if (m.getOwners().get(i).getName().equals(name)) {
                        ss = m.getOwners().get(i).viewOverdueTax();
                    }
                }
                String sss = "";
                for (int i = 0; i < ss.size(); i++){
                    sss = sss + ss.get(i);
                }
                t.setText(sss);
            }
        });
        return scene;
    }








    public Scene loadOwner(Stage stage) {

        HBox inter = new HBox();


        Button reg = new Button("Register");
        Button sig = new Button("Sign In");
        Button bk = new Button("Back");

        reg.setMinSize(199, 199);
        reg.setMaxSize(200, 200);

        sig.setMinSize(199, 199);
        sig.setMaxSize(200, 200);

        bk.setMinSize(199, 199);
        bk.setMaxSize(200, 200);


        reg.setStyle("-fx-background-color: #313D53;" +
                " -fx-text-fill: white");
        sig.setStyle("-fx-background-color: #313D53;" +
                "-fx-text-fill: white");
        bk.setStyle("-fx-background-color: #313D53;" +
                "-fx-text-fill: white");


        inter.setSpacing(10);
        inter.setAlignment(Pos.CENTER);


        inter.getChildren().addAll(reg, sig, bk);
        inter.setStyle("-fx-background-color: #242524");
        Scene scene = new Scene(inter);

        reg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stage.setScene(new Scene(new Pane()));
                stage.setTitle("Title");
                stage.setWidth(700);
                stage.setHeight(310);


                stage.setScene(loadRegister(stage));
                stage.show();
            }
        });

        bk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadMainScreen(stage));
                stage.show();
            }
        });
        return scene;
    }
    public Scene loadRegister(Stage stage) {

        BorderPane root = new BorderPane();

        HBox bb = new HBox();
        bb.setSpacing(5);
        bb.setPadding(new Insets(10, 10, 20, 10));
        bb.setAlignment(Pos.CENTER);

        root.setBottom(bb);

        Button back = new Button("Back");
        Button reg = new Button("Register");

        back.setPadding(new Insets(0, 0, 0, 0));

        back.setMinSize(59, 29);
        back.setMaxSize(60, 30);

        reg.setMinSize(59, 29);
        reg.setMaxSize(60, 30);


        back.setStyle("-fx-background-color: #313D53;" +
                        " -fx-text-fill: white");
        reg.setStyle("-fx-background-color: #313D53;" +
                        " -fx-text-fill: white");

        bb.getChildren().addAll(back, reg);
        root.setStyle("-fx-background-color: #242524");

        TextField b = new TextField("username");
        Label l = new Label("no text");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                l.setText(b.getText());
            }
        };
        b.setOnAction(event);

        root.getChildren().add(b);
        root.getChildren().add(l);
        Scene scene = new Scene(root);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                stage.setScene(loadOwner(stage));
                stage.show();
            }
        });

        return scene;

    }
}



