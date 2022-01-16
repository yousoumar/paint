
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Main{
	
	public static void main(String[] args){

		
		JFrame frame = new JFrame("Paint");
		
		
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
	
	
		final Drew draw = new Drew();
		
		content.add(draw, BorderLayout.CENTER);
		
		
		JPanel pannel = new JPanel();
		pannel.setPreferredSize(new Dimension(100, 120));
		pannel.setMinimumSize(new Dimension(100, 120));
		pannel.setMaximumSize(new Dimension(100, 120));
		
		
		
		JButton penButton = new JButton(new ImageIcon("icons/" + "pen.png"));
		penButton.setPreferredSize(new Dimension(170,60));
		penButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			draw.pen();
			}

		});
		pannel.add(penButton);
		
		
		JButton lineButton = new JButton(new ImageIcon("icons/" + "line.png"));
		lineButton.setPreferredSize(new Dimension(170,60));
		lineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.line();
			}
		});
		pannel.add(lineButton);
		

		

		JButton rubberButtton = new JButton( new ImageIcon("icons/" + "rubber.png"));
		rubberButtton.setPreferredSize(new Dimension(170, 60));
		rubberButtton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.erase();
			}

		});
		pannel.add(rubberButtton);
		
		JButton clearButton = new JButton(new ImageIcon("icons/" + "broom.png"));
		clearButton.setPreferredSize(new Dimension(170, 60));
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				draw.clear();
			}
		});
		pannel.add(clearButton);
		


		content.add(pannel, BorderLayout.WEST);
		content.add(pannel, BorderLayout.SOUTH);
		
		
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

