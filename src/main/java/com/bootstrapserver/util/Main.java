package com.bootstrapserver.util;

import com.bootstrapserver.controller.ReceiverController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        int port = 2222;
        if (args.length>1){
            port = Integer.parseInt(args[1]);
        }
        ReceiverController receiverController = new ReceiverController(port);

        Thread t = new Thread(receiverController);
        t.start();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
