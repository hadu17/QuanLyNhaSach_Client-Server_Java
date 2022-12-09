package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class DocGiaJPanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModle;
	private JScrollPane scrollPane;
	private JTextField texTimTen;
	private AbstractButton btnDangKy;
	private JButton btnSua;
	private AbstractButton btnXoa;
	private AbstractButton btnTim;
	private JTable listDocGia;
public static void main(String[] args) {
	JFrame frame= new JFrame();
	frame.setSize(1920,1080);
	frame.getContentPane().add(new DocGiaJPanel());
	frame.setVisible(true);
}
	/**
	 * Create the panel.
	 */
	public DocGiaJPanel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
//		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1920, 918);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDanhSchBn = new JLabel("   Danh SÃ¡ch Ä�á»™c Giáº£ ");
		lblDanhSchBn.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSchBn.setOpaque(true);
		lblDanhSchBn.setForeground(new Color(204, 102, 51));
		lblDanhSchBn.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDanhSchBn.setBackground(Color.WHITE);
		lblDanhSchBn.setBounds(178, 66, 384, 54);
		
		panel.add(lblDanhSchBn);
		
		 scrollPane = new JScrollPane();
		 scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(51, 236, 1848, 625);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setDragEnabled(true);
		table.setForeground(new Color(0, 0, 51));
		table.setSelectionBackground(new Color(51, 204, 255));
		scrollPane.setColumnHeaderView(table);
		
		listDocGia = new JTable();
		listDocGia.setRowHeight(24);
		tableModle=new DefaultTableModel(
				new String[] {"STT", "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n ", "N\u0103m xu\u1EA5t b\u1EA3n", "Trang thai"},50) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
			
		};
		
		table.setModel(tableModle);
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerTable.setBackground(new Color(160,227,242));
		scrollPane.setViewportView(listDocGia);
		
		
//		table.getColumnModel().getColumn(0).setPreferredWidth(50);
//		table.getColumnModel().getColumn(1).setPreferredWidth(300);
//		table.getColumnModel().getColumn(2).setPreferredWidth(100);
//		table.getColumnModel().getColumn(3).setPreferredWidth(50);
//		table.getColumnModel().getColumn(4).setPreferredWidth(300);
//		table.getColumnModel().getColumn(5).setPreferredWidth(50);
//	
		
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/reader (12).png")));
		lblNewLabel.setBounds(41, 22, 128, 137);
		panel.add(lblNewLabel);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(51, 158, 1848, 80);
		panel.add(panel1);
		
		 btnDangKy = new JButton("Ä�Äƒng kÃ½");
		btnDangKy.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/plus_24.png")));
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangKy.setForeground(Color.BLACK);
		btnDangKy.setBackground(Color.LIGHT_GRAY);
		
		 btnSua = new JButton("Sá»­a");
		btnSua.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/sua.png")));
		btnSua.setForeground(Color.BLACK);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnSua.setBackground(Color.LIGHT_GRAY);
		
		 btnXoa = new JButton("XÃ³a");
		btnXoa.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/xoa.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnXoa.setBackground(Color.LIGHT_GRAY);
		
		texTimTen = new JTextField();
		texTimTen.setColumns(10);
		texTimTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 btnTim = new JButton("");
		btnTim.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTim.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/search (1).png")));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("TÃªn:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 837, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(texTimTen, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(6)
							.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(texTimTen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(51, 862, 1848, 54);
		panel.add(panel_2);
		
		JLabel txtPage = new JLabel("1");
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnDau_1_1 = new JButton("");
		btnDau_1_1.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/forward-button.png")));
		btnDau_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnDau_2 = new JButton("");
		btnDau_2.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/next.png")));
		btnDau_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnDau_2_1 = new JButton("");
		btnDau_2_1.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/rewind-button.png")));
		btnDau_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnDau_1_1_1 = new JButton("");
		btnDau_1_1_1.setIcon(new ImageIcon(DocGiaJPanel.class.getResource("/img/previousEnd.png")));
		btnDau_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel txtPage_1 = new JLabel("/");
		txtPage_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel txtPage_2 = new JLabel("1");
		txtPage_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(676)
					.addComponent(btnDau_1_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(btnDau_2_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtPage)
					.addGap(13)
					.addComponent(txtPage_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(txtPage_2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnDau_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(btnDau_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(657, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDau_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(btnDau_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(1)
											.addComponent(btnDau_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
									.addComponent(btnDau_2_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(17)
							.addComponent(txtPage_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(16)
							.addComponent(txtPage)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(txtPage_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		panel_2.setLayout(gl_panel_2);
		
		
//		JTableHeader h = table.getTableHeader();
//		h.setPreferredSize(new Dimension(40, 40));
//		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
//
//		HeaderRenderer renderer = new HeaderRenderer();
//		// center
//		JLabel headerLabel = (JLabel) renderer;
//		headerLabel.setHorizontalAlignment(JLabel.CENTER);
//		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
//		// set color Header Table
//		TableColumnModel columnmodel ;
//
//		for (int i = 0; i < table.getColumnCount(); i++) {
//			table.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
//			renderer.setBackgroundColor(Color.white);
//			renderer.setForegroundColor(Color.black);
//			renderer.setBorder(new LineBorder(Color.gray));
//		}
		
//		btnDangKy.addActionListener(this);
//		btnSua.addActionListener(this);
	}

//	public void actionPerformed(ActionEvent e) {
//		Object object = e.getSource();
//		if(object.equals(btnDangKy)) {
//			new ThemDocGiaDialog().setVisible(true);
//		}
//		else if(object.equals(btnSua)) {
//			new SuaDocGiaDialog2().setVisible(true);
//		}
//		
//	}
}
