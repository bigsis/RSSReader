package View;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

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

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RssReaderView extends JFrame{
	private JTextField txtUrl;
	private JTextField textFieldUrl;
	private RssControl rssCon;
	private JList<Item> itemList;

	
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
		

		goBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					rssCon.setUrl("http://feeds.bbci.co.uk/news/rss.xml?edition=int");
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
						String txtLabel = "<html>"+"<div>"+
						"<h1><b>"+i.getTitle()+"<b></h1></br>"+
						"<h2>"+i.getDescription()+"</h2>"+
								"</div>"+ "</html>";
						scLabel.setText(txtLabel);
						
					}
				});
				scrollPaneTitle.add(itemList);
				getContentPane().add(scrollPaneTitle);
			}
		});
		

		setVisible(true);
	}
}
