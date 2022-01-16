

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;


public class Drew extends JComponent{
	
	private static final long serialVersionUID = 1L;
	Image image;
	Graphics2D graphics2D;
	String fonts;
	int x2, y2, x1, y1,w,h,xx1,yy1,i=0,size=8;
	MouseMotionAdapter mouse;
	MouseAdapter mouseA;
	
	public Drew(){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();

			}
		};

		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=(i/2);c++){
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);

	}
	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}


		public void pen(){
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		};

		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=(i/2);c++){
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);

	}

	
		public void line(){
			removeMouseListener(mouseA);
			removeMouseMotionListener(mouse);
			mouseA=new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					x1 = e.getX();
					y1 = e.getY();
				}
				public void mouseReleased(MouseEvent e){
					x2 = e.getX();
					y2 = e.getY();
					if(graphics2D != null)
						for(int c=0;c<=(i/2);c++){
							graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
							graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
						}
					repaint();
					x1 = x2;
					y1 = y2;
				}

			};
			addMouseListener(mouseA);

		}

		public void erase(){
			graphics2D.setPaint(Color.white);
			removeMouseListener(mouseA);
			removeMouseMotionListener(mouse);
			mouseA=new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					x1 = e.getX();
					y1 = e.getY();

				}
			};

			mouse=new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent e){
					x2 = e.getX();
					y2 = e.getY();
					if(graphics2D != null)
						for(int c=0;c<=12;c++){
							graphics2D.setPaint(Color.white);
							graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
							graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
							graphics2D.setPaint(Color.black);
						}
					repaint();
					x1 = x2;
					y1 = y2;
				}

			};
			addMouseMotionListener(mouse);
			addMouseListener(mouseA);

			i=0;
		}



	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}



}

