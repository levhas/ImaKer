package com.wadaaaa.matri.matrix;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    public TextField lup, up, rup, lmid, mid, rmid, ldown, down;
    public javafx.scene.control.Button updateBtn;
    public Button imageSelect;
    public TextField rdown;
    public ImageView modifiedImage;
    public CheckBox normalized;

    ImageModifier imageModifier;
    FileChooser fileChooser = new FileChooser();


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File("index.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imageModifier = new ImageModifier(img);
        imageModifier.setKernel(new Kernel(new float[]{0, 0, 0, 0, 1, 0, 0, 0, 0}));

        ArrayList<Integer> colors = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            colors.add(1);
        }
    }


    public void onUpdateBtnClick() {

        var values = getCurrentValues();
        imageModifier.getKernel().setValues(values);
        imageModifier.modify();
        var img = imageModifier.getModifierImage();


        modifiedImage.setImage(imageModifier.getModifierImage());

    }

    public void normalizedChange(ActionEvent actionEvent) {
        var values = getCurrentValues();
        imageModifier.getKernel().setValues(values);
        imageModifier.getKernel().setNormalization(normalized.isSelected());
    }
    float[] getCurrentValues(){
        float[] test = new float[9];
        test[0] = Float.parseFloat(lup.getText());
        test[1] = Float.parseFloat(up.getText());
        test[2] = Float.parseFloat(rup.getText());
        test[3] = Float.parseFloat(lmid.getText());
        test[4] = Float.parseFloat(mid.getText());
        test[5] = Float.parseFloat(rmid.getText());
        test[6] = Float.parseFloat(ldown.getText());
        test[7] = Float.parseFloat(down.getText());
        test[8] = Float.parseFloat(rdown.getText());
        return test;
    }

    public void imageSelectClicked(ActionEvent actionEvent) {
        File selectedFile = fileChooser.showOpenDialog(imageSelect.getScene().getWindow());
        try {
            var image = ImageIO.read(selectedFile);
            imageModifier.setImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}