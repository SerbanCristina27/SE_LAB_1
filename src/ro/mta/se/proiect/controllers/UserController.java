package ro.mta.se.proiect.controllers;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import ro.mta.se.proiect.utils.Constants;
import ro.mta.se.proiect.views.*;
import ro.mta.se.proiect.models.*;


/**
 * Created by Cristina on 1/9/2017.
 */
public class UserController {

    MainView mainView;
    UserModel userModel;
    ClientController clientController;

    public UserController(UserModel userModel) {

        this.mainView = new MainView();
        this.userModel = userModel;

        new Thread(new ServerController()).start();
    }


    public void show(){
        mainView.show(userModel.getStage());
        addArrowEvent();
        addBattleFieldEvent();
    }

    private void addArrowEvent(){
        mainView.getArrowView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainView.getArrowView().setRotate(mainView.getArrowView().getRotate() + 90);
                mainView.getImageView().setRotate(mainView.getArrowView().getRotate() + 90);
                userModel.setPosition(userModel.getPosition().next());
            }
        });
    }

    private void addBattleFieldEvent(){

        int i;
        for(i = 0; i<userModel.getStaticSize() * userModel.getStaticSize();i++)
        {

            final int j = i;
                mainView.getBattlefield().getChildren().get(i).setOnDragOver(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {

                        System.out.println("onDragOver");

                        if (event.getGestureSource() != mainView.getBattlefield().getChildren().get(j) &&
                                event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }

                        event.consume();
                    }
                });


            mainView.getBattlefield().getChildren().get(i).setOnDragEntered(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                     /* the drag-and-drop gesture entered the target */
                        System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                        if (event.getGestureSource() != mainView.getBattlefield().getChildren().get(j) &&
                                event.getDragboard().hasString()) {
                        }

                        event.consume();
                    }
                });

            mainView.getBattlefield().getChildren().get(i).setOnDragExited(new EventHandler<DragEvent>() {
                    public void handle(DragEvent event) {
                     /* mouse moved away, remove the graphical cues */
                        event.consume();
                    }
                });

            mainView.getBattlefield().getChildren().get(i).setOnDragDropped(new EventHandler <DragEvent>() {
                public void handle(DragEvent event) {
                /* data dropped */
                    /* data dropped */
                    System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasString()) {
                        String confirm = new String(db.getString());
                        if (confirm.equals("OK")) {

                            Integer rowIndex = GridPane.getRowIndex(mainView.getBattlefield().getChildren().get(j));
                            Integer columnIndex = GridPane.getColumnIndex(mainView.getBattlefield().getChildren().get(j));

                            updateUserBattlefield(rowIndex, columnIndex);
                            success = true;

                            event.setDropCompleted(success);
                            event.consume();

                        }
                    }
                }
            });
        }
    }

    public boolean connectToFriend(String ip, Integer port){

        //clientController = new ClientController(ip,port);


        return false;
    }

    public void updateUserBattlefield(Integer columnIndex,Integer rowIndex){
        mainView.updateUserBattlefield(columnIndex,rowIndex,userModel.getPosition());
    }


    public static boolean updateBattlefieldMatrix(Integer rowIndex, Integer columnIndex)
    {

        if(!verifyPosition(UserModel.position,rowIndex,columnIndex)){
            return false;
        }

        if (UserModel.position.equals(Constants.PlanePosition.up)){

        if (rowIndex <= 15 - 4 && (2 <= columnIndex && columnIndex <= 15 - 3)){

            UserModel.userBattlefieldMatrix[rowIndex][columnIndex] = Constants.Battlefield.planeHead;
            UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 2][columnIndex] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 3][columnIndex] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex + 1] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex + 2] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 1] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 2] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 3][columnIndex + 1] = Constants.Battlefield.planeBody;
            UserModel.userBattlefieldMatrix[rowIndex + 3][columnIndex - 1] = Constants.Battlefield.planeBody;


                return true;
            }
            return false;
        }
        else if(UserModel.position.equals(Constants.PlanePosition.right)){
            if (columnIndex >= 3 && (2 <= rowIndex && rowIndex <= 15 - 3)){

                UserModel.userBattlefieldMatrix[rowIndex][columnIndex] = Constants.Battlefield.planeHead;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 2] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 3] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 3] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex - 3] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 2] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 3][columnIndex + 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 3][columnIndex - 1] = Constants.Battlefield.planeBody;


                return true;
            }
            return false;
        }
        else if(UserModel.position.equals(Constants.PlanePosition.down)){
            if (rowIndex >= 3 && (2 <= columnIndex && columnIndex <= 15 - 3)){

                UserModel.userBattlefieldMatrix[rowIndex][columnIndex] = Constants.Battlefield.planeHead;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 2][columnIndex] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 3][columnIndex] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex + 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex + 2] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex - 2] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 3][columnIndex + 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 3][columnIndex - 1] = Constants.Battlefield.planeBody;


                return true;
            }
            return false;
        }
        else if(UserModel.position.equals(Constants.PlanePosition.left)){
            if (rowIndex <= 15 - 3 && (2 <= columnIndex && columnIndex <= 15 - 3)){

                UserModel.userBattlefieldMatrix[rowIndex][columnIndex] = Constants.Battlefield.planeHead;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 2] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex][columnIndex - 3] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 2][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 2][columnIndex - 1] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex - 1][columnIndex - 3] = Constants.Battlefield.planeBody;
                UserModel.userBattlefieldMatrix[rowIndex + 1][columnIndex - 3] = Constants.Battlefield.planeBody;


                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }


    private static boolean verifyPosition(Constants.PlanePosition position, Integer row, Integer colum){

        if(UserModel.getPositionValue(row,colum).equals(Constants.Battlefield.planeHead)){
            return false;
        }


        if(position.equals(Constants.PlanePosition.up)|| position.equals(Constants.PlanePosition.down)){


            if(position.equals(Constants.PlanePosition.up)){

                for (int i = row + 1; i <= row + 3; i++){
                    if (UserModel.getPositionValue(i,colum).equals(Constants.Battlefield.planeBody))
                        return false;
                }

                for (int j = colum - 2; j <= colum + 2; j++) {
                    if (UserModel.getPositionValue(row + 1, j).equals(Constants.Battlefield.planeBody))
                        return false;
                }

                if (UserModel.getPositionValue(row + 3, colum - 1).equals(Constants.Battlefield.planeBody))
                    return false;
                if (UserModel.getPositionValue(row + 3, colum + 1).equals(Constants.Battlefield.planeBody))
                    return false;
            }
            else{

                for (int i = row - 1; i <= row - 3; i--){
                    if (UserModel.getPositionValue(i,colum).equals(Constants.Battlefield.planeBody))
                        return false;
                }

                for (int j = colum - 2; j <= colum + 2; j++) {
                    if (UserModel.getPositionValue(row - 1, j).equals(Constants.Battlefield.planeBody))
                        return false;
                }
                if (UserModel.getPositionValue(row - 3, colum - 1).equals(Constants.Battlefield.planeBody))
                    return false;
                if (UserModel.getPositionValue(row -3 , colum + 1).equals(Constants.Battlefield.planeBody))
                    return false;
            }

        } else if (position.equals(Constants.PlanePosition.right) || position.equals(Constants.PlanePosition.left)){

            if(position.equals(Constants.PlanePosition.right)){

                for(int j = colum - 1; j <= colum - 3; j--)
                {
                    if(UserModel.getPositionValue(row,j).equals(Constants.Battlefield.planeBody))
                        return false;
                }

                for (int i = row - 2; i <= row + 2; i++) {
                    if (UserModel.getPositionValue(i , colum - 1).equals(Constants.Battlefield.planeBody))
                        return false;
                }
                if (UserModel.getPositionValue(row - 1, colum - 3).equals(Constants.Battlefield.planeBody))
                    return false;
                if (UserModel.getPositionValue(row + 1, colum - 3).equals(Constants.Battlefield.planeBody))
                    return false;
            }
            else{
                for(int j = colum + 1; j <= colum + 3; j++)
                {
                    if(UserModel.getPositionValue(row,j).equals(Constants.Battlefield.planeBody))
                        return false;
                }
                for (int i = row - 2; i <= row + 2; i++) {
                    if (UserModel.getPositionValue(i, colum + 1).equals(Constants.Battlefield.planeBody))
                        return false;
                }
                if (UserModel.getPositionValue(row + 1, colum + 3).equals(Constants.Battlefield.planeBody))
                    return false;
                if (UserModel.getPositionValue(row - 1 , colum + 3).equals(Constants.Battlefield.planeBody))
                    return false;
            }

        }


        return true;
    }



}
