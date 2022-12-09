package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import view.util.HeaderRenderer;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class NhanVien extends JPanel implements ActionListener{
	private DefaultTableModel modelSach;
	private JTextField textField;
	private JButton btnSua;
	private JButton btnDangKy;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public NhanVien() {
		setPreferredSize(new Dimension(1920, 918));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NhanVien.class.getResource("/img/employee (9).png")));
		lblNewLabel.setBounds(10, 11, 128, 137);
		add(lblNewLabel);
		
		JLabel lblDanhSchBn = new JLabel("   Danh Sách Nhân Viên");
		lblDanhSchBn.setOpaque(true);
		lblDanhSchBn.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSchBn.setForeground(new Color(204, 102, 51));
		lblDanhSchBn.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDanhSchBn.setBackground(Color.WHITE);
		lblDanhSchBn.setBounds(147, 55, 384, 54);
		add(lblDanhSchBn);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 147, 1902, 80);
		add(panel1);
		
		 btnDangKy = new JButton("Đăng ký");
		 btnDangKy.setIcon(new ImageIcon(NhanVien.class.getResource("/img/plus_24.png")));
		btnDangKy.setForeground(Color.BLACK);
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangKy.setBackground(Color.LIGHT_GRAY);
		
		 btnSua = new JButton("Sửa");
		 btnSua.setIcon(new ImageIcon(NhanVien.class.getResource("/img/cap_nhat.png")));
		btnSua.setForeground(Color.BLACK);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnSua.setBackground(Color.LIGHT_GRAY);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(NhanVien.class.getResource("/img/negative.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnXoa.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Tên:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon(NhanVien.class.getResource("/img/search (1).png")));
		btnTim.setHorizontalTextPosition(SwingConstants.CENTER);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1848, Short.MAX_VALUE)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 852, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(9))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 80, Short.MAX_VALUE)
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
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 1902, 625);
		add(scrollPane);
		table = new JTable();
		table.setRowHeight(30);
		modelSach=new DefaultTableModel(
				new String[] {"Mã nhân viên", "Họ tên", "Số điện thoại", "Ngày sinh","Giới tính","Địa chỉ","Chức vụ"},50) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
			
		};
		
//		table_1 = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(modelSach);
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerTable.setBackground(new Color(160,227,242));
		scrollPane.setViewportView(table);

		JTableHeader h = table.getTableHeader();
		h.setPreferredSize(new Dimension(35, 35));
		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer = new HeaderRenderer();
		// center
		JLabel headerLabel = (JLabel) renderer;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		// set color Header Table
		TableColumnModel columnmodel ;

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
			renderer.setBackgroundColor(Color.black);
			renderer.setForegroundColor(Color.white);
			renderer.setBorder(new LineBorder(Color.gray));
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(11, 851, 1902, 54);
		add(panel_2);
		
		JButton btnDau_1_1_1 = new JButton("");
		btnDau_1_1_1.setIcon(new ImageIcon(NhanVien.class.getResource("/img/previousEnd.png")));
		btnDau_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnDau_2_1 = new JButton("");
		btnDau_2_1.setIcon(new ImageIcon(NhanVien.class.getResource("/img/rewind-button.png")));
		btnDau_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel txtPage = new JLabel("1");
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel txtPage_1 = new JLabel("/");
		txtPage_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel txtPage_2 = new JLabel("1");
		txtPage_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnDau_1_1 = new JButton("");
		btnDau_1_1.setIcon(new ImageIcon(NhanVien.class.getResource("/img/nextbutton.png")));
		btnDau_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnDau_2 = new JButton("");
		btnDau_2.setIcon(new ImageIcon(NhanVien.class.getResource("/img/nextEnd.png")));
		btnDau_2.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1848, Short.MAX_VALUE)
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
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 54, Short.MAX_VALUE)
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
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(txtPage_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		panel_2.setLayout(gl_panel_2);
		
		ButtonGroup buttonGroup = new ButtonGroup();

		
		btnSua.addActionListener(this);
		btnDangKy.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1920,918);
		f.getContentPane().add(new NhanVien());
		f.setVisible(true);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(btnDangKy)) {
			new ThemNhanVien().setVisible(true);
		}
		else if(object.equals(btnSua)) {
			new SuaNhanVien("").setVisible(true);
		}
		
	}
}
