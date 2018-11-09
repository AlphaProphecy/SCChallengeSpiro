import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.math.*;

public class Spirograph extends Canvas{
	private int points;
	private double x;
	private int ix;
	private double y;
	private int iy;
	private double R;
	private double r;
	private double O;
	private int startX;
	private int startY;
	
	
	public static void main(String[] args) {
		//System.out.println(Math.cos(Math.PI));
		Spirograph s = new Spirograph(500,500,500f,300f,200f,300);
		JFrame f = new JFrame();

		f.add(s);
		f.setSize(1000,1000);
		f.setVisible(true);
		
	}
	
	public Spirograph(int startX, int startY, double R, double r, double O, int points) {
		this.startX = startX;
		this.startY = startY;
		this.R = R;
		this.r = r;
		this.O = O;
		this.points = points;
	}
	
	public void paint(Graphics g) {
		float inc = (float) (2*Math.PI/points);
		setForeground(Color.RED);
		mathFunc(inc);
		int px = ix;
		int py = iy;
		
		for (int f = 1; f < points*lcm(R,r); f++) {
			//System.out.println(f*inc);
			mathFunc(f * inc);
			g.drawLine(px, py, ix, iy);
			px = ix;
			py = iy;
		}
		System.out.println("Done");
	}
	
	
	private void mathFunc (double d) {
		x = (R-r)*Math.cos(d) + O*Math.cos(((R-r)/r)*d) + startX;
		y = (R-r)*Math.sin(d) - O*Math.sin(((R-r)/r)*d) + startY;
		//System.out.println(x);
		//System.out.println(y);
		ix = (int) Math.round(x);
		iy = (int) Math.round(y);
	}
	
	
	double gcd(double a, double b) {  
	    // Everything divides 0  
	    if (a == 0 || b == 0)
	        return 0;  
	   
	    // Base case     
	    if (a == b)
	        return a;  
	   
	    // a is greater  
	    if (a > b)  
	        return gcd(a-b, b);  
	    return gcd(a, b-a);  
	 } 
	 
	   
	// Function to return LCM of two numbers  
	  double lcm(double a, double b) {  
	    return (a*b)/gcd(a, b);  
	 }
}
