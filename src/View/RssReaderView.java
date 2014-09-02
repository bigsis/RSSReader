package View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTML;
import javax.xml.bind.JAXBException;

import Controller.RssControl;
import Model.Item;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Color;
import java.beans.PropertyChangeListener;

import javax.swing.SwingConstants;

/**
 * This is class for view of the RSSReader
 * @author Sarit Suriyasangpetch 5510546191
 * 
 *
 */
public class RssReaderView extends JFrame{
	private JTextField txtUrl;
	private JTextField textFieldUrl;
	private RssControl rssCon;
	private JList<Item> itemList;
	private URI uri;

	
	public RssReaderView( RssControl rssCon ) throws MalformedURLException, JAXBException{
		super("RssReader");
		this.rssCon = rssCon;
		
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setBounds(256, 40, 547, 22);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
		
		JLabel urlLabel = new JLabel("Please Enter your URL:");
		urlLabel.setBounds(113, 43, 131, 16);
		getContentPane().add(urlLabel);
		
		JButton goBtn = new JButton("GO!");
		goBtn.setBounds(815, 39, 97, 25);
		getContentPane().add(goBtn);
		
		ScrollPane scrollPane = new ScrollPane();
		JLabel scLabel = new JLabel();
		JButton linkBtn = new JButton("LINK");
		linkBtn.addActionListener(linkListener());
		linkBtn.setBounds(520, 710, 97, 30);
		scLabel.setVerticalAlignment(SwingConstants.TOP);
		scLabel.setPreferredSize(new Dimension(420, 560));
		scrollPane.add(scLabel);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBounds(511, 115, 427, 591);
		getContentPane().add(scrollPane);
		
		ScrollPane scrollPaneTitle = new ScrollPane();
		scrollPaneTitle.setBackground(Color.WHITE);
		scrollPaneTitle.setBounds(37, 115, 427, 591);
		getContentPane().add(scrollPaneTitle);
		getContentPane().add(linkBtn);
		

		goBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					rssCon.setUrl(textFieldUrl.getText());
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Item[] x = new Item[rssCon.getRss().getChannel().getItem().size()];
				itemList = new JList<Item>(rssCon.getRss().getChannel().getItem().toArray(x));
				itemList.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						Item i = itemList.getSelectedValue();
						System.out.println(i.getLink());
						String txtLabel = 
						"<html>"+"<div>"+
						"<h1><b>"+i.getTitle()+"<b></h1></br>"+
						"<h2>"+i.getDescription()+"</h2>"+
						"</div>"+ "</html>";
						scLabel.setText(txtLabel);	
						
						try {
							uri = new URI(i.getLink());
						} catch (URISyntaxException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}
					
				});
				scrollPaneTitle.add(itemList);
				getContentPane().add(scrollPaneTitle);
			}
		});
		

		setVisible(true);
	}
	
	/**
	 * mothod to assign link to linkBtn
	 * @return ActionListener
	 */
	public ActionListener linkListener(){
		return new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				        try {
							Desktop.getDesktop().browse(uri);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				
			}
		};
	}
	
}
