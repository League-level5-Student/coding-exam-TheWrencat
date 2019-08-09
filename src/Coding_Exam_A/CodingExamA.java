package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		int robotCount = Integer.parseInt(JOptionPane.showInputDialog("How many robots?"));
		String color = JOptionPane.showInputDialog("What color? (Red, Green, Blue)");
		int sideCount = Integer.parseInt(JOptionPane.showInputDialog("How many sides per shape?"));
		
		int rX = 10;
		int rY = 100;
		Thread t = new Thread();
		for(int i = 0; i < robotCount; i++) {
			//starting location
			rX += 100;
			if(i%10 == 0) {
				rY += 100;
			}
			//creating robot/setting color
			Robot r = new Robot(rX, rY);
			r.setSpeed(6);
			color.toLowerCase();
			if(color.equals("red")) {
				r.setPenColor(200, 0, 0);
			}
			if(color.equals("green")) {
				r.setPenColor(0, 200, 0);
			}
			if(color.equals("blue")) {
				r.setPenColor(0, 0, 200);
			}
			r.penDown();
			
			t = new Thread(()->{
				r.penDown();
				for(int j = 0; j< sideCount; j++) {
					r.move(300 / sideCount);
					r.turn(360/sideCount);
				}
				r.penUp();
				r.move(500);
			
			});
				t.start();
			
		}

		

	}
}
