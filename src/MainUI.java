import controlP5.*;
import processing.core.PApplet;
import processing.core.PFont;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * File: MainUI
 * Author: Ben Kinder and Mika Poblete
 * Date Created: 11/20/16
 * Email: brkinder1@gmail.com, mpoblete@friendsbalt.org
 * Description: A voting probability simulator.
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
    private float chanceOfFail = 0;
    private boolean isDRE = false;
    private boolean isOptical = false;
    private boolean isPunchCards = false;
    private boolean isLever = false;
    private boolean shouldWait = false;

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
        buttonThree.setLabel("");
        buttonFour.setLabel("");

    }

    private void question2() {
        question.setText("What voting method would you like to use?\n\n" +
                "A) Direct Recording Electronic\n" +
                "B) Optical Scan Ballot\n" +
                "C) Punch Cards\n" +
                "D) Lever Machine");

        buttonOne.setLabel("A");
        buttonTwo.setLabel("B");
        buttonThree.setLabel("C");
        buttonFour.setLabel("D");
    }

    private void question3() {
        question.setText("How well do you know English?");

        buttonOne.setLabel("Fluent");
        buttonTwo.setLabel("Moderate");
        buttonThree.setLabel("Poor");
        buttonFour.setLabel("No English");
    }

    public void question4() {
        question.setText("What is your age?");

        buttonOne.setLabel("Over 65");
        buttonTwo.setLabel("Under 65");
        buttonThree.setLabel("");
        buttonFour.setLabel("");
    }

    public void question5() {
        question.setText("Do you have a disability?");

        buttonOne.setLabel("Physical");
        buttonTwo.setLabel("Hearing");
        buttonThree.setLabel("Sight");
        buttonFour.setLabel("None");
    }

    public void end() {
        float chance = random(0, 1);
        if (chanceOfFail >= chance)
            question.setText("Your vote was not correctly cast\n\n" +
                    "The chance of your vote failing was:\n" +
                    chanceOfFail * 100 + " percent");
        else
            question.setText("Your vote was correctly cast!\n\n" +
                    "The chance of your vote failing was:\n" +
                    chanceOfFail * 100 + " percent");
        buttonOne.setLabel("");
        buttonTwo.setLabel("");
        buttonThree.setLabel("");
        buttonFour.setLabel("Replay?");
    }

    public void draw() {
        background(0);
    }

    public void buttonOne() {
        if (questionNum == 1) {
            questionNum++;
            question2();
            return;
        }
        if (questionNum == 2) {
            isDRE = true;
            questionNum++;
            question3();
            return;
        }
        if (questionNum == 3) {
            questionNum++;
            question4();
            return;
        }
        if (questionNum == 4) {
            if (isDRE)
                chanceOfFail += 0.15;
            if (isOptical)
                chanceOfFail += 0.15;
            if (isPunchCards)
                chanceOfFail += 0.20;
            questionNum++;
            question5();
            return;
        }
        if (questionNum == 5) {
            chanceOfFail += 0.05;
            questionNum++;
            end();
            return;
        }
    }

    public void buttonTwo() {
        if (questionNum == 1) {
            question.setText("You did not vote.");
            questionNum = 6;
            buttonOne.setLabel("");
            buttonTwo.setLabel("");
            buttonThree.setLabel("");
            buttonFour.setLabel("Replay?");
            return;
        }
        if (questionNum == 2) {
            isOptical = true;
            chanceOfFail += 0.02;
            questionNum++;
            question3();
            return;
        }
        if (questionNum == 3) {
            if (!isDRE)
                chanceOfFail += 0.02;
            questionNum++;
            question4();
            return;
        }
        if (questionNum == 4) {
            questionNum++;
            question5();
            return;
        }
        if (questionNum == 5) {
            chanceOfFail += 0.03;
            questionNum++;
            end();
            return;
        }
    }

    public void buttonThree() {
        if (questionNum == 2) {
            isPunchCards = true;
            chanceOfFail += 0.07;
            questionNum++;
            question3();
            return;
        }
        if (questionNum == 3) {
            if (!isDRE)
                chanceOfFail += 0.15;
            questionNum++;
            question4();
            return;
        }
        if (questionNum == 5) {
            chanceOfFail += 0.10;
            questionNum++;
            end();
            return;
        }
    }

    public void buttonFour() {
        if (questionNum == 2) {
            isLever = true;
            chanceOfFail += 0.01;
            questionNum++;
            question3();
            return;
        }
        if (questionNum == 3) {
            if (!isDRE)
                chanceOfFail += 0.50;
            questionNum++;
            question4();
            return;
        }
        if (questionNum == 5) {
            questionNum++;
            end();
            return;
        }
        if (questionNum == 6) {
            questionNum = 1;
            question1();
            return;
        }
    }
}
