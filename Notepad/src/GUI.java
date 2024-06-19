import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI implements ActionListener{
    
	JFrame window;
	
	//TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	
	//Edit Menu
	JMenuItem iUndo, iRedo;
	
	//FILE MENU
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; 
	
	//FORMAT MENU
	JMenuItem iwrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	JMenuItem iCol1, iCol2, iCol3;
	
	
	Function_File file = new Function_File(this); 
	Function_Format format = new Function_Format(this);
	Function_Color col = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	KeyHandler kHandler = new KeyHandler(this);
	
	
    UndoManager um = new UndoManager();
	

	
	
	public static void main(String[] args) {
		
		new GUI();

	}
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColourMenu();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		col.changeColour("White");
		window.setVisible(true);
	}
	

	
	public void createWindow() {
	
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void createTextArea() {
		
		textArea = new JTextArea();
		textArea.setFont(format.arial);
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
				@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						// TODO Auto-generated method stub
						um.addEdit(e.getEdit());
					}
				});
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		
		//window.add(textArea);
}
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		 menuColor = new JMenu("Colour");
		menuBar.add(menuColor);
}
	public void createFileMenu() {
	   
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void createEditMenu() {
	
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	
	public void createFormatMenu() {
		
		iwrap = new JMenuItem("Word wrap: off");
		iwrap.addActionListener(this);
		iwrap.setActionCommand("Word Wrap");
		menuFormat.add(iwrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Snas MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
}
	public void createColourMenu() {
		
		iCol1 = new JMenuItem("White");
		iCol1.addActionListener(this);
	    iCol1.setActionCommand("White");
	    menuColor.add(iCol1);
	    
	    iCol2 = new JMenuItem("Black");
		iCol2.addActionListener(this);
	    iCol2.setActionCommand("Black");
	    menuColor.add(iCol2);
	    
	    iCol3 = new JMenuItem("Blue");
		iCol3.addActionListener(this);
	    iCol3.setActionCommand("Blue");
	    menuColor.add(iCol3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "Save": file.save(); break;
		case "SaveAs": file.saveAs(); break;
		case "Exit": file.exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "Word Wrap": format.wordWrap(); break;
		case "Arial": format.setFont(command); break;
		case "Comic Sans MS": format.setFont(command); break;
		case "Times New Roman": format.setFont(command); break;
		case "size8": format.createFont(8); break;
		case "size12": format.createFont(12); break;
		case "size16": format.createFont(16); break;
		case "size20": format.createFont(20); break;
		case "size24": format.createFont(24); break;
		case "size28": format.createFont(28); break;
		case "White" : col.changeColour(command); break;
		case "Black" : col.changeColour(command); break;
		case "Blue" : col.changeColour(command); break;
		
		
		}
		
	}
	

}
