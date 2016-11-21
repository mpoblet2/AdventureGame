import controlP5.*;
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
    private Textarea question;
    private PFont font;
    private int questionNum = 1;
    private boolean choiceA = false;
    private boolean choiceB = false;
    private boolean choiceC = false;
    private boolean choiceD = false;

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

        question = cp5.addTextarea("question");
        question.setPosition(widthUnit, heightUnit);
        question.setSize(parseInt(7 * widthUnit), parseInt(2 * heightUnit));
        question.setFont(font);
        question.setLabel("");

        buttonOne = cp5.addButton("buttonOne");
        buttonOne.setPosition(widthUnit, 5 * heightUnit);
        buttonOne.setSize(buttonWidth, buttonHeight);

        buttonTwo = cp5.addButton("buttonTwo");
        buttonTwo.setPosition(3 * widthUnit, 5 * heightUnit);
        buttonTwo.setSize(buttonWidth, buttonHeight);

        buttonThree = cp5.addButton("buttonThree");
        buttonThree.setPosition(5 * widthUnit, 5 * heightUnit);
        buttonThree.setSize(buttonWidth, buttonHeight);

        buttonFour = cp5.addButton("buttonFour");
        buttonFour.setPosition(7 * widthUnit, 5 * heightUnit);
        buttonFour.setSize(buttonWidth, buttonHeight);

        question1();
    }

    private void question1() {
        question.setText("Would you like to cast a vote?");

        buttonOne.setLabel("Yes");
        buttonTwo.setLabel("No");
        buttonThree.setVisible(false);
        buttonFour.setVisible(false);
    }

    private void question2() {
        question.setText("What is your socioeconomic class?");

        buttonOne.setLabel("Upper");
        buttonTwo.setLabel("Middle");
        buttonThree.setVisible(true);
        buttonThree.setLabel("Lower");
    }

    public void draw() {
        background(0);
    }

    public void buttonOne() {
        if (questionNum == 1){
            questionNum++;
            question2();
        }
    }

    public void buttonTwo() {
        if (questionNum == 1) {
            question.setText("You did not vote.");
        }
    }

    public void buttonThree() {
    }

    public void buttonFour() {
    }
}
