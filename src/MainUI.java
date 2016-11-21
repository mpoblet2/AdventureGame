import controlP5.Button;
import controlP5.ControlFont;
import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * File: MainUI
 * Author: Ben Kinder
 * Date Created: 11/20/16
 * Email: brkinder1@gmail.com
 * Description
 **/
public class MainUI  extends PApplet{
    private ControlP5 cp5;
    private float widthUnit;
    private float heightUnit;
    private int buttonHeight;
    private int buttonWidth;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Textfield question;
    private PFont font;

    public static void main(String[] args) {
        PApplet.main("MainUI");
    }

    public void settings() {
        size(1024, 768);
    }

    public void setup() {
        font = createFont("Arial", 20);
        heightUnit = height / 7;
        widthUnit = width / 9;
        buttonWidth = parseInt(widthUnit);
        buttonHeight = 25;

        cp5 = new ControlP5(this);

        question1();
    }

    private void question1() {
        question = cp5.addTextfield("question");
        question.setPosition(widthUnit, heightUnit);
        question.setSize(parseInt(7 * widthUnit), parseInt(2 * heightUnit));
        question.setText("Do you wish to cast a vote?");
        question.setFont(font);
        question.setLabel("");

        buttonOne = cp5.addButton("buttonOne");
        buttonOne.setPosition(widthUnit, 5 * heightUnit);
        buttonOne.setSize(buttonWidth, buttonHeight);
        buttonOne.setLabel("Yes");

        buttonTwo = cp5.addButton("buttonTwo");
        buttonTwo.setPosition(3 * widthUnit, 5 * heightUnit);
        buttonTwo.setSize(buttonWidth, buttonHeight);
        buttonTwo.setLabel("No");
    }

    public void draw() {

    }
}
