package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import chucNangChung.ChucNangChoTable;
import entity.ChiTietPhieuMuon;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;
import entity.TheThuVien;
import iRemote.IChiTiet;
import iRemote.INhaXuatBan;
import iRemote.IPhieuMuon;
import iRemote.ISach;
import iRemote.ITacGia;
import iRemote.ITheLoai;
import iRemote.ITheThuVien;

public class GuiMuonSach extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ISach sachDao;
	private ITheLoai theLoaiDao;
	private List<TheLoai> dsLoaiSach;
	private INhaXuatBan nhaXuatBanDao;
	private List<NhaXuatBan> dsNXB;
	private ITacGia tacGiaDao;
	private List<TacGia> dsTacGia;
	private JComboBox cboThe;
	private JButton btnOk;
	private JButton btnCancel;
	private ITheThuVien theThuVienDao;
	private TheThuVien theThuVien;
	private NhanVien nhanVien;
	private JTable tblSach;
	private List<Sach> dsSach;
	private DefaultTableModel modelSach;
	private JMenuItem mnXoa;
	private IPhieuMuon phieuMuonDao;
	private IChiTiet chiTietDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiMuonSach dialog = new GuiMuonSach();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiMuonSach() {
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
			theThuVienDao = (ITheThuVien) Naming.lookup("rmi://192.168.1.11:2910/iTheThuVien");
			phieuMuonDao = (IPhieuMuon) Naming.lookup("rmi://192.168.1.11:2910/iPhieuMuon");
			chiTietDao = (IChiTiet) Naming.lookup("rmi://192.168.1.11:2910/iChiTiet");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		} catch (NotBoundException e2) {
			e2.printStackTrace();
		}
		setLocationRelativeTo(null);
		setBounds(100, 100, 810, 450);
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
		panel_1.setBounds(0, 54, 794, 324);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Mã thẻ");
		lblNewLabel_7.setBounds(10, 285, 55, 27);
		panel_1.add(lblNewLabel_7);

		cboThe = new JComboBox();
		cboThe.setAutoscrolls(true);
		cboThe.setBounds(75, 284, 281, 29);
		panel_1.add(cboThe);

		cboThe.setEditable(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 774, 262);
		panel_1.add(scrollPane);

		modelSach = new DefaultTableModel(new String[] { "STT", "M\u00E3 s\u00E1ch", "T\u00EAn sach" }, 20);

		tblSach = new JTable();

		tblSach.setModel(modelSach);
		scrollPane.setViewportView(tblSach);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tblSach, popupMenu);

		mnXoa = new JMenuItem("Xóa ra khỏi giỏ hàng");
		popupMenu.add(mnXoa);
		JTextField txtThe = (JTextField) cboThe.getEditor().getEditorComponent();
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

		txtThe.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {

					String soThe = txtThe.getText().trim();
					try {
						if (cboThe.getItemAt(0) != null) {
							return;
						}
						theThuVien = theThuVienDao.getTheThuVien(soThe);

						if (theThuVien != null) {
							cboThe.removeAllItems();
							System.out.println(theThuVien);
							cboThe.addItem(theThuVien.getSoThe() + ": " + theThuVien.getDocGia().getTenDocGia());
							cboThe.showPopup();

						} else {
							JOptionPane.showMessageDialog(null, "Không tìm thấy thẻ này");
						}

					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		mnXoa.addActionListener(e -> {
			int index = tblSach.getSelectedRow();
			if (tblSach.getValueAt(index, 0) == null)
				return;
			if (index != -1) {
				dsSach.remove(index);
				modelSach.removeRow(index);
			}
		});
		btnOk.addActionListener(e -> {
			System.out.println(dsSach.size());
			if (theThuVien == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thẻ thư viện");
				return;
			}
			PhieuMuon phieuMuon = new PhieuMuon(LocalDate.now(), theThuVien, nhanVien);
			List<ChiTietPhieuMuon> tempList = new ArrayList<ChiTietPhieuMuon>();
			try {
				for (Sach sach : dsSach) {
					ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon(phieuMuon, sach, false, null);
					chiTietDao.themChiTiet(chiTietPhieuMuon);
				}
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				this.dispose();
			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(null, "thêm thất bại");
				e1.printStackTrace();
			}
		});

	}

	public void setSach(List<Sach> dsSach, NhanVien nhanVien) {
		ChucNangChoTable.XoaDongTable(modelSach);
		for (int i = 0; i < dsSach.size(); i++) {
			Object[] row = { i + 1, dsSach.get(i).getMaSach(), dsSach.get(i).getTenSach() };
			modelSach.addRow(row);
		}
		ChucNangChoTable.addNullDataTable(modelSach);
		this.dsSach = dsSach;
		this.nhanVien = nhanVien;
//		System.out.println(this.dsSach.size());
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
