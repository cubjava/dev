package com.cubjava.movingmarbles;

import java.awt.Image;

public class Marble
{
	//comment for unitTest branch
	private int radius;
	private int xPosition;
	private int yPosition;
	private int xSpeed;
	private int ySpeed;
	private int xDirection = 1;
	private int yDirection = 1;
	private Image image;
	
	private double milisec = 16;
	
	public Marble(int radius, int xPos, int yPos, int xSpeed, int ySpeed, Image image)
	{
		this.radius = radius;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.image = image;
	}
	
	public void move()
	{
		
		if((xPosition + radius) > MovingMarbles.appletXSize || (xPosition - radius) < 0)
		{
			xDirection = -1 * xDirection;
		}
		
		if((yPosition + radius) > MovingMarbles.appletYSize || (yPosition - radius) < 0)
		{
			yDirection = -1 * yDirection;
		}
		
		setxPosition(xPosition + (xSpeed * xDirection));
		setyPosition(yPosition + (ySpeed * yDirection));
		//System.out.println((xPosition + (xSpeed * xDirection)) + ", " + (yPosition + (ySpeed * yDirection)));
	}
	
	public int getRadius()
	{
		return radius;
	}
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	public int getxPosition()
	{
		return xPosition;
	}
	public void setxPosition(int xPosition)
	{
		this.xPosition = xPosition;
	}
	public int getyPosition()
	{
		return yPosition;
	}
	public void setyPosition(int yPosition)
	{
		this.yPosition = yPosition;
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}

	public int getxSpeed()
	{
		return xSpeed;
	}

	public void setxSpeed(int xSpeed)
	{
		this.xSpeed = xSpeed;
	}

	public int getySpeed()
	{
		return ySpeed;
	}

	public void setySpeed(int ySpeed)
	{
		this.ySpeed = ySpeed;
	}

	public int getxDirection()
	{
		return xDirection;
	}

	public void setxDirection(int xDirection)
	{
		this.xDirection = xDirection;
	}

	public int getyDirection()
	{
		return yDirection;
	}

	public void setyDirection(int yDirection)
	{
		this.yDirection = yDirection;
	}
}
