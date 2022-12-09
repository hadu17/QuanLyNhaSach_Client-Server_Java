package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import entity.NhaXuatBan;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;
import iRemote.INhaXuatBan;
import iRemote.ISach;
import iRemote.ITacGia;
import iRemote.ITheLoai;

public class NhapSach extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JTextField txtTenSach;
	private ISach sachDao;
	private ITheLoai theLoaiDao;
	private List<TheLoai> dsLoaiSach;
	private JComboBox cboTheLoai;
	private JComboBox cboNam;
	private JComboBox cboNhaXuatBan;
	private INhaXuatBan nhaXuatBanDao;
	private List<NhaXuatBan> dsNXB;
	private ITacGia tacGiaDao;
	private List<TacGia> dsTacGia;
	private JComboBox cboTacGia;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NhapSach dialog = new NhapSach();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NhapSach() {
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		setModal(true);
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
		try {
			sachDao = (ISach) Naming.lookup("rmi://192.168.1.11:2910/iSach");
			theLoaiDao = (ITheLoai) Naming.lookup("rmi://192.168.1.11:2910/iTheLoai");
			nhaXuatBanDao = (INhaXuatBan) Naming.lookup("rmi://192.168.1.11:2910/iNhaXuatBan");
			tacGiaDao = (ITacGia) Naming.lookup("rmi://192.168.1.11:2910/iTacGia");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		} catch (NotBoundException e2) {
			e2.printStackTrace();
		}
		setLocationRelativeTo(null);
		setBounds(100, 100, 810, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 794, 54);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u00E1ch");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLUE));
		panel_1.setBounds(0, 54, 794, 197);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn s\u00E1ch");
		lblNewLabel_1.setBounds(20, 36, 70, 27);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("N\u0103m xu\u1EA5t b\u1EA3n");
		lblNewLabel_2.setBounds(20, 90, 70, 27);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nhà xuất bản");
		lblNewLabel_3.setBounds(20, 137, 70, 27);
		panel_1.add(lblNewLabel_3);

		txtTenSach = new JTextField();
		txtTenSach.setBounds(101, 36, 281, 30);
		panel_1.add(txtTenSach);
		txtTenSach.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Th\u1EC3 lo\u1EA1i");
		lblNewLabel_6.setBounds(429, 36, 55, 27);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Tác giả");
		lblNewLabel_7.setBounds(429, 90, 55, 27);
		panel_1.add(lblNewLabel_7);

		cboTheLoai = new JComboBox();
		cboTheLoai.setAutoscrolls(true);
		cboTheLoai.setBounds(494, 36, 281, 31);
		panel_1.add(cboTheLoai);

		cboTacGia = new JComboBox();
		cboTacGia.setAutoscrolls(true);
		cboTacGia.setBounds(494, 89, 240, 29);
		panel_1.add(cboTacGia);

		cboNam = new JComboBox();
		cboNam.setAutoscrolls(true);
		cboNam.setBounds(100, 86, 282, 29);
		panel_1.add(cboNam);

		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(341, 135, 41, 30);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(734, 88, 41, 30);
		panel_1.add(btnNewButton_1);

		cboNhaXuatBan = new JComboBox();
		cboNhaXuatBan.setAutoscrolls(true);
		cboNhaXuatBan.setBounds(100, 135, 240, 29);
		panel_1.add(cboNhaXuatBan);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		loadCboLoaiSach();
		loadCboNam();
		loadCboNXB();
		loadCboTacGia();
		btnOk.addActionListener(e -> {
			System.out.println(getSachFromForm());
			Sach sach = getSachFromForm();
			try {
				if (sachDao.themSach(sach))
					JOptionPane.showMessageDialog(this, "Nhập sách thành công");
				else System.out.println(sachDao.themSach(sach));
				this.dispose();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		});

	}

	public void loadCboLoaiSach() {
		dsLoaiSach = new ArrayList<TheLoai>();
		try {
			dsLoaiSach = theLoaiDao.getAllTheLoai();
			for (int i = 0; i < dsLoaiSach.size(); i++) {
				cboTheLoai.addItem(dsLoaiSach.get(i).getTenTheLoai());
			}
			cboTheLoai.setSelectedIndex(0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void loadCboNXB() {
		dsNXB = new ArrayList<NhaXuatBan>();
		try {
			dsNXB = nhaXuatBanDao.getAllNXB();
			for (int i = 0; i < dsNXB.size(); i++) {
				cboNhaXuatBan.addItem(dsNXB.get(i).getTenNhaXuatBan());
			}
			cboTheLoai.setSelectedIndex(0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void loadCboTacGia() {
		dsTacGia = new ArrayList<TacGia>();
		try {
			dsTacGia = tacGiaDao.getAllTacGia();
			for (int i = 0; i < dsTacGia.size(); i++) {
				cboTacGia.addItem(dsTacGia.get(i).getTenTacGia());
			}
			cboTheLoai.setSelectedIndex(0);
			System.out.println(dsTacGia.size());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void loadCboNam() {

		for (int i = LocalDate.now().getYear(); i >= 1920; i--) {
			cboNam.addItem(i);
		}
	}

	public Sach getSachFromForm() {
		String ten = txtTenSach.getText().trim();
		Sach sach = new Sach(ten, (int) cboNam.getSelectedItem(), true);
		sach.setTacGia(dsTacGia.get(cboTacGia.getSelectedIndex()));
		sach.setNhaXuatBan(dsNXB.get(cboNhaXuatBan.getSelectedIndex()));
		sach.setTheLoai(dsLoaiSach.get(cboTheLoai.getSelectedIndex()));
		return sach;
	}
}
