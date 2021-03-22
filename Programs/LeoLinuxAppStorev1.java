/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chasefranse.main;

// MAKE INSTALLER SHELL SCRIPTS SETUID
// Only Readable & Writeable by ROOT
// AUTOPSY, BURPSUITE, X == Open Web Browser to Download Page for Linux

/* Imports to make it all work */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
    import java.io.FileNotFoundException;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

/**
 *
 * @author chaseFranse
 */

public class LeoLinuxAppStorev1 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void init() {
        System.out.println("Initialization");
        
    }
    
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Initialize new BorderPane
        BorderPane bPane = new BorderPane();
        bPane.setPrefSize(900, 600);
        
        //Create Background Image for Startup Page
        Image leoLinux3 = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\Leo34.png"));
        BackgroundSize backSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true);
        Background LeoLinux3Back = new Background(new BackgroundImage(leoLinux3,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            backSize));
        
        /**************** IMAGES FOR EACH SOFTWARE INDIVIDUALLY ****************/
        //Create Image for DNSMAP Logo
        Image DNSMAP = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\dnsmap.png"));
        ImageView view1 = new ImageView(DNSMAP);
        //Create Image for NMAP Logo
        Image NMAP = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\nmap.png"));
        ImageView view2 = new ImageView(NMAP);
        
        //Create Image for AUTOPSY Logo
        Image AUTOPSY = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\autopsy.png"));
        ImageView view3 = new ImageView(AUTOPSY);
        
        //Create Image for RKHUNTER Logo
        Image RKHUNTER = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\rkhunter.png"));
        ImageView view11 = new ImageView(RKHUNTER);
        
        //Create Image for HASHCAT Logo
        Image HASHCAT = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\hashcat.png"));
        ImageView view4 = new ImageView(HASHCAT);
        
        //Create Image for JOHN Logo
        Image JOHN = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\john.png"));
        ImageView view5 = new ImageView(JOHN);
        
        //Create Image for SQLMAP Logo
        Image SQLMAP = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\sqlmap.png"));
        ImageView view6 = new ImageView(SQLMAP);
        
        //Create Image for WIRESHARK Logo
        Image WIRESHARK = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\wireshark.png"));
        ImageView view7 = new ImageView(WIRESHARK);
        
        //Create Image for AIRCRACK Logo
        Image AIRCRACK = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\aircrack.png"));
        ImageView view8 = new ImageView(AIRCRACK);
        
        //Create Image for BURPSUITE Logo
        Image BURPSUITE = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\burp.png"));
        ImageView view9 = new ImageView(BURPSUITE);
        
        //Create Image for BRACKETCHECKER Logo
        Image BRACKET = new Image(new FileInputStream("C:\\Users\\lizar\\Documents\\NetBeansProjects\\ChaseProjects\\build\\classes\\com\\chasefranse\\main\\bracket.png"));
        ImageView view10 = new ImageView(BRACKET);
        
        
        
        /**************** Left v2 ****************/
        VBox left = new VBox(3);
        left.setPadding(new Insets(5, 105, 5, 5));
        left.setStyle("-fx-background-color: #b8b8b8");
        
        
        /**************** Center v1 ****************/
        BorderPane center = new BorderPane();
            /***** Center-Bottom *****/
            Button install = new Button("Install");
            install.setPrefWidth(500);
            center.setAlignment(install, Pos.CENTER);
        //center.setCenter(new TextField("Center"));
        center.setBackground(LeoLinux3Back);
        
        
        /**************** Top v1 ****************/
        HBox top = new HBox(5);
        top.setPadding(new Insets(10, 12, 10, 12)); 
        top.setSpacing(5);
        top.setStyle("-fx-background-color: #b8b8b8");
        final int THEIGHT = 40;
        final int TWIDTH = 140;
        
        /******* Info Gathering *******/
        Button infogath = new Button("Information Gathering");
        infogath.setPrefHeight(THEIGHT);
        infogath.setPrefWidth(TWIDTH);
        infogath.setDefaultButton(true);
        
        infogath.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                left.getChildren().clear();
                center.setBackground(null);
                center.setTop(null);
                center.setBottom(null);
                center.setLeft(null);
                
                left.setPadding(new Insets(5, 5, 5, 5));
                final int LHEIGHT = 50;
                final int LWIDTH = 100;

                Button dnsmap = new Button("DNSMAP");
                dnsmap.setPrefHeight(LHEIGHT);
                dnsmap.setPrefWidth(LWIDTH);
                dnsmap.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("DNSMAP");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view1.setFitHeight(100);
                       view1.setPreserveRatio(true);
                       Label dnsMap = new Label();
                       dnsMap.setGraphic(view1);
                       dnsmap.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(dnsMap);
                       
                   }
                });

                Button nmap = new Button("NMAP");
                nmap.setPrefHeight(LHEIGHT);
                nmap.setPrefWidth(LWIDTH);
                nmap.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("NMAP");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view2.setFitHeight(100);
                       view2.setPreserveRatio(true);
                       Label nmap = new Label();
                       nmap.setGraphic(view2);
                       nmap.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(nmap);
                   }
                });

                left.getChildren().addAll(dnsmap, nmap);
            }
        });
        
        /******* Digital Forensics *******/
        Button dforen = new Button("Digital Forensics");
        dforen.setPrefHeight(THEIGHT);
        dforen.setPrefWidth(TWIDTH);
        
        dforen.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               left.getChildren().clear();
               center.setBackground(null);
               center.setTop(null);
               center.setBottom(null);
               center.setLeft(null);
               center.setLeft(null);
               
               left.setPadding(new Insets(5, 5, 5, 5));
               final int LHEIGHT = 50;
               final int LWIDTH = 100;
               
               Button autopsy = new Button("Autopsy");
               autopsy.setPrefHeight(LHEIGHT);
               autopsy.setPrefWidth(LWIDTH);
               autopsy.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("AUTOPSY");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view3.setFitHeight(100);
                       view3.setPreserveRatio(true);
                       Label autoPsy = new Label();
                       autoPsy.setGraphic(view3);
                       autoPsy.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(autoPsy);
                   }
                });
               
               Button rkhunter = new Button("RKHunter");
               rkhunter.setPrefHeight(LHEIGHT);
               rkhunter.setPrefWidth(LWIDTH);
               rkhunter.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("RKHUNTER");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view3.setFitHeight(100);
                       view3.setPreserveRatio(true);
                       Label rkHunter = new Label();
                       rkHunter.setGraphic(view11);
                       rkHunter.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(rkHunter);
                   }
                });
               
               left.getChildren().addAll(autopsy, rkhunter);
           }
        });
        
        /******* Password Cracking *******/
        Button passcrack = new Button("Password Cracking");
        passcrack.setPrefHeight(THEIGHT);
        passcrack.setPrefWidth(TWIDTH);
        
        passcrack.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               left.getChildren().clear();
               center.setBackground(null);
               center.setTop(null);
               center.setBottom(null);
               center.setLeft(null);
               
               left.setPadding(new Insets(5, 5, 5, 5));
               final int LHEIGHT = 50;
               final int LWIDTH = 100;
               
               Button hashcat = new Button("Hashcat");
               hashcat.setPrefHeight(LHEIGHT);
               hashcat.setPrefWidth(LWIDTH);
               hashcat.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("HASHCAT");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view4.setFitHeight(100);
                       view4.setPreserveRatio(true);
                       Label hashCat = new Label();
                       hashCat.setGraphic(view4);
                       hashCat.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(hashCat);
                   }
                });
               
               Button john = new Button("John the Ripper");
               john.setPrefHeight(LHEIGHT);
               john.setPrefWidth(LWIDTH);
               john.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("JOHN THE RIPPER");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view5.setFitHeight(100);
                       view5.setPreserveRatio(true);
                       Label john = new Label();
                       john.setGraphic(view5);
                       john.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(john);
                   }
                });
               
               left.getChildren().addAll(hashcat, john);
           }
        });
        
        /******* Vulnerability Analysis *******/
        Button vulanalysis = new Button("Vulnerability Analysis");
        vulanalysis.setPrefHeight(THEIGHT);
        vulanalysis.setPrefWidth(TWIDTH);
        
        vulanalysis.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               left.getChildren().clear();
               center.setBackground(null);
               center.setTop(null);
               center.setBottom(null);
               center.setLeft(null);
               
               left.setPadding(new Insets(5, 5, 5, 5));
               final int LHEIGHT = 50;
               final int LWIDTH = 100;
               
               Button sqlmap = new Button("SQLmap");
               sqlmap.setPrefHeight(LHEIGHT);
               sqlmap.setPrefWidth(LWIDTH);
               sqlmap.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("SQLMAP");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view6.setFitHeight(100);
                       view6.setPreserveRatio(true);
                       Label sqlMap = new Label();
                       sqlMap.setGraphic(view6);
                       sqlMap.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(sqlMap);
                   }
                });
               
               Button wireshark = new Button("Wireshark");
               wireshark.setPrefHeight(LHEIGHT);
               wireshark.setPrefWidth(LWIDTH);
               wireshark.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("WIRESHARK");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view7.setFitHeight(100);
                       view7.setPreserveRatio(true);
                       Label wireShark = new Label();
                       wireShark.setGraphic(view7);
                       wireShark.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(wireShark);
                   }
                });
               
               left.getChildren().addAll(sqlmap, wireshark);
           }
        });
        
        /******* Wireless Attacks *******/
        Button wireless = new Button("Wireless Attacks");
        wireless.setPrefHeight(THEIGHT);
        wireless.setPrefWidth(TWIDTH);
        
        wireless.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               left.getChildren().clear();
               center.setBackground(null);
               center.setTop(null);
               center.setBottom(null);
               center.setLeft(null);
               
               left.setPadding(new Insets(5, 5, 5, 5));
               final int LHEIGHT = 50;
               final int LWIDTH = 100;
               
               Button aircrack = new Button("Aircrack-ng");
               aircrack.setPrefHeight(LHEIGHT);
               aircrack.setPrefWidth(LWIDTH);
               aircrack.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("AIRCRACK-NG");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view8.setFitHeight(100);
                       view8.setPreserveRatio(true);
                       Label airCrack = new Label();
                       airCrack.setGraphic(view8);
                       airCrack.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(airCrack);
                   }
                });
               
               Button burp = new Button("Burpsuite");
               burp.setPrefHeight(LHEIGHT);
               burp.setPrefWidth(LWIDTH);
               burp.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("BURPSUITE (COMMUNITY)");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view9.setFitHeight(100);
                       view9.setPreserveRatio(true);
                       Label burpSuite = new Label();
                       burpSuite.setGraphic(view9);
                       burpSuite.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(burpSuite);
                   }
                });
               
               left.getChildren().addAll(aircrack, burp);
           }
        });
        
        /******* Other *******/
        Button other = new Button ("Other");
        other.setPrefHeight(THEIGHT);
        other.setPrefWidth(TWIDTH);
        
        other.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               left.getChildren().clear();
               center.setBackground(null);
               center.setTop(null);
               center.setBottom(null);
               center.setLeft(null);
               
               left.setPadding(new Insets(5, 5, 5, 5));
               final int LHEIGHT = 50;
               final int LWIDTH = 100;
               
               Button bracket = new Button("Bracket Checker v5.7");
               bracket.setPrefHeight(LHEIGHT);
               bracket.setPrefWidth(LWIDTH);
               bracket.setOnAction(new EventHandler<ActionEvent>(){
                   @Override
                   public void handle(ActionEvent event){
                       Label name = new Label("BRACKET CHECKER");
                       //Set application name in "center->TOP"
                       center.setTop(name);
                       center.setAlignment(name, Pos.CENTER);
                       
                       //Generate "Install" button in "center->BOTTOM"
                       center.setBottom(install);
                       
                       //Set applicaiton logo image
                       view10.setFitHeight(100);
                       view10.setPreserveRatio(true);
                       Label bracketChecker = new Label();
                       bracketChecker.setGraphic(view10);
                       bracketChecker.setPadding(new Insets(5, 5, 5, 5));
                       center.setLeft(bracketChecker);
                   }
                });
               
               left.getChildren().addAll(bracket);
           }
        });
        
        top.getChildren().setAll(infogath, dforen, passcrack, vulanalysis, wireless, other);
        
        
        
        /**************** Set Main BorderPane Pieces ****************/
        bPane.setTop(top);
        bPane.setLeft(left);
        //bPane.setRight(right);
        bPane.setCenter(center);
        
        //Create new Scene
        Scene scene = new Scene(bPane);
        stage.setTitle("Leo Linux App Store");
        
        //Add scene to stage
        stage.setScene(scene);
        
        //Display Stage
        stage.show();
    }
}
