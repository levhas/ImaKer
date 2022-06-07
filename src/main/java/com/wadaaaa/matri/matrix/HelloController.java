package com.wadaaaa.matri.matrix;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

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
    public TextField rdown;
    public ImageView modifiedImage;
    public CheckBox normalized;
    @FXML
    private Label welcomeText;
    File imgfile;
    javafx.scene.image.Image image;

    ImageModifier imageModifier;



    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

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

        img.getRGB(1,1);
        var blur = new float[]{0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f, 0.0625f, 0.125f, 0.0625f};
        var edge = new float[]{-1, 0, 1, -2, 0, 2, -1, 0, 1};
        var edge2 = new float[]{-2, -1, 0, -1, 0, 1, 0, 1, 2};
        var edge3 = new float[]{0, 1, 2,
                -1, 0, 1,
                -2, -1, 0};

        var sharp = new float[]{0, -1, 0,
                -1, 5, -1,
                0, -1, 0};
        Kernel kernel = new Kernel(edge2);
        // var test = kernel.kernelify(new double[]{1,1,1,1,1,1,1,1,1});
        //= new int[9];
        int index = 0;

        var color = img.getRGB(1,1);;




        ArrayList<Integer> colors = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            colors.add(1);
        }

        var testKernel = new float[][]{{0f, 1f, 2},
                {-1, 0, 1},
                {-2, -1, 0}};





        float result;

        int[] subColor = new int[9];

        int lup, up ,rup;
        int lmid, mid, rmid;
        int ldown, down, rdown;









        InputStream stream = null;
        try {
            stream = new FileInputStream("screenshot.png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        image = new Image(stream);

        //Creating the image view

        //Setting image to the image view

        //Setting the image view parameters

        //Setting the Scene object
    }


    public void onUpdateBtnClick() {

        var values = getCurrentValues();
        imageModifier.getKernel().setValues(values);
        imageModifier.modify();
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
}