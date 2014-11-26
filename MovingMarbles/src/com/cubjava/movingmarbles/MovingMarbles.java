package com.cubjava.movingmarbles;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class MovingMarbles extends Applet implements Runnable
{
	public static int appletXSize = 600;
	public static int appletYSize = 400;
	
	private Marble blueMarble;
	private Marble redMarble;
	private Marble greenMarble;
	private URL base;
	private Image canvas;
	private Graphics graphics;

	@Override
	public void run()
	{
		System.out.println("run");
		
		while(true)
		{
			// do something
			blueMarble.move();
			redMarble.move();
			greenMarble.move();
			repaint();
			System.out.println("repaint");
			try
			{
				//FPS - frame per second
				Thread.sleep(16);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init");
		try
		{
			base = getDocumentBase();
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		blueMarble = new Marble(20, 100 ,20, 1, 2, getImage(base, "imgs/blue40.png"));
		redMarble = new Marble(20, 20, 20, 1, -1, getImage(base, "imgs/red40.png"));
		greenMarble = new Marble(20, 150, 200, 2, 2, getImage(base, "imgs/green40.png"));
		
		setBackground(Color.white);
		setSize(appletXSize, appletYSize);
	}

	@Override
	public void start()
	{
		// TODO Auto-generated method stub
		super.start();
		System.out.println("start");
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void stop()
	{
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("stop");
	}

	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paint(g);
		System.out.println("paint");
		g.drawImage(blueMarble.getImage(), 
				blueMarble.getxPosition() - blueMarble.getRadius(), 
				blueMarble.getyPosition() - blueMarble.getRadius(), this);
		g.drawImage(redMarble.getImage(), 
				redMarble.getxPosition() - redMarble.getRadius(), 
				redMarble.getyPosition() - redMarble.getRadius(), this);
		g.drawImage(greenMarble.getImage(), 
				greenMarble.getxPosition() - greenMarble.getRadius(), 
				greenMarble.getyPosition() - greenMarble.getRadius(), this);
	}

	@Override
	public void update(Graphics g)
	{
		//super.update(g); flickers if left
		System.out.println("update");
		if (canvas == null) {
			canvas = createImage(this.getWidth(), this.getHeight());
			graphics = canvas.getGraphics();
		}

		graphics.setColor(getBackground());
		graphics.fillRect(0, 0, getWidth(), getHeight());
		graphics.setColor(getForeground());
		paint(graphics);

		g.drawImage(canvas, 0, 0, this);
	}
}
