package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

import com.toedter.calendar.JDateChooser;

import chucNangChung.ChucNangChoTable;
import entity.ChiTietPhieuMuon;
import entity.PhieuMuon;
import entity.Sach;
import iRemote.IChiTiet;
import iRemote.IPhieuMuon;
import iRemote.ISach;
import iRemote.ITheLoai;
import view.util.HeaderRenderer;

public class MuonTraSach extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6386126485141484521L;
	private JTable tblSach;
	private JTextField txtTrang;
	private JPopupMenu popupTable;
	private JMenuItem mnPrint;
	private JButton btnBack;
	private JButton btnNext;
	private JLabel lblTongTrang;
	private DefaultTableModel modelSach;
	private JTable tblChiTiet;
	private JPopupMenu popupChiTiet;
	private JMenuItem mnTra;
	private JTextField txtTimKiem;
	private JTextField txtNgy;
	private DefaultTableModel modelChiTiet;
	private JDateChooser dayChoose;
	private ISach sachDao;
	private ITheLoai theLoaiDao;
	private IPhieuMuon phieuMuonDao;
	private List<PhieuMuon> dsPhieuMuon;
	private IChiTiet chiTietDao;
	private List<ChiTietPhieuMuon> dsChiTiet;
	private JRadioButton rdnTheTv;
	private JRadioButton rdnSdt;
	private JRadioButton rdnMaPhieuMuon;
	private JButton btnTimKiem;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public MuonTraSach() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		try {
			sachDao = (ISach) Naming.lookup("rmi://192.168.1.11:2910/iSach");
			theLoaiDao = (ITheLoai) Naming.lookup("rmi://192.168.1.11:2910/iTheLoai");
			phieuMuonDao = (IPhieuMuon) Naming.lookup("rmi://192.168.1.11:2910/iPhieuMuon");
			chiTietDao = (IChiTiet) Naming.lookup("rmi://192.168.1.11:2910/iChiTiet");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		} catch (NotBoundException e2) {
			e2.printStackTrace();
		}
		setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 139, 1920, 420);
		add(scrollPane_1);

		tblSach = new JTable();
		tblSach.setRowHeight(24);
		modelSach = new DefaultTableModel(
				new String[] { "STT", "Số phiếu", "Mã nhân viên", "Mã thẻ", "Tên đọc giả", "Ngày mượn", "Trang thai" },
				50) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		JTableHeader h1 = tblSach.getTableHeader();
		h1.setPreferredSize(new Dimension(35, 35));
		((DefaultTableCellRenderer) h1.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer1 = new HeaderRenderer();
		// center
		JLabel headerLabel11 = (JLabel) renderer1;
		headerLabel11.setHorizontalAlignment(JLabel.CENTER);
		headerLabel11.setFont(new Font("Tahoma", Font.BOLD, 14));
		// set color Header Table
		TableColumnModel columnmodel;

		for (int i = 0; i < tblSach.getColumnCount(); i++) {
			tblSach.getColumnModel().getColumn(i).setHeaderRenderer(renderer1);
			renderer1.setBackgroundColor(Color.black);
			renderer1.setForegroundColor(Color.white);
			renderer1.setBorder(new LineBorder(Color.gray));
		}

		tblSach.setModel(modelSach);
//		JTableHeader headerTable = tblSach.getTableHeader();
//		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		headerTable.setBackground(new Color(160,227,242));
		scrollPane_1.setViewportView(tblSach);

		popupTable = new JPopupMenu();
		addPopup(tblSach, popupTable);

		mnPrint = new JMenuItem("In phi\u1EBFu m\u01B0\u1EE3n");
		mnPrint.setToolTipText("In phi\u1EBFu");
		popupTable.add(mnPrint);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(160, 227, 242));
		panel_1.setBounds(0, 557, 1920, 38);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnBack = new JButton("<<");
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setToolTipText("Trang tr\u01B0\u1EDBc");
		panel_1.add(btnBack);

		JLabel lblNewLabel_2 = new JLabel("Trang");
		panel_1.add(lblNewLabel_2);

		txtTrang = new JTextField();
		txtTrang.setToolTipText("Trang hi\u1EC7n t\u1EA1i");
		txtTrang.setText("01");
		panel_1.add(txtTrang);
		txtTrang.setColumns(10);

		lblTongTrang = new JLabel("Tổng trang");
		lblTongTrang.setToolTipText("Tổng số trang");
		panel_1.add(lblTongTrang);

		btnNext = new JButton(">>");
		btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNext.setToolTipText("Trang ti\u1EBFp theo");
		panel_1.add(btnNext);

		JLabel lblNewLabel_1 = new JLabel("Phieu  mượn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel_1.setBounds(0, 108, 1918, 31);
		add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 626, 1920, 292);
		add(scrollPane);

		modelChiTiet = new DefaultTableModel(
				new String[] { "STT", "Mã sách", "Tên sách", "Tác giả", "Ngày trả", "Tình trạng" }, 20) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblChiTiet = new JTable();
		tblChiTiet.setRowHeight(24);
		tblChiTiet.setModel(modelChiTiet);
		scrollPane.setViewportView(tblChiTiet);

		JTableHeader h = tblChiTiet.getTableHeader();
		h.setPreferredSize(new Dimension(35, 35));
		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer = new HeaderRenderer();
		// center
		JLabel headerLabel = (JLabel) renderer;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		// set color Header Table
		TableColumnModel columnmodel1;

		for (int i = 0; i < tblChiTiet.getColumnCount(); i++) {
			tblChiTiet.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
			renderer.setBackgroundColor(Color.black);
			renderer.setForegroundColor(Color.white);
			renderer.setBorder(new LineBorder(Color.gray));
		}

		popupChiTiet = new JPopupMenu();
		addPopup(tblChiTiet, popupChiTiet);

		mnTra = new JMenuItem("Tr\u1EA3 s\u00E1ch");
		popupChiTiet.add(mnTra);

		JLabel lblNewLabel_1_1 = new JLabel("Chi ti\u1EBFt phi\u1EBFu m\u01B0\u1EE3n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNewLabel_1_1.setBounds(0, 595, 1918, 31);
		add(lblNewLabel_1_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1920, 108);
		add(panel);

		txtTimKiem = new JTextField();
		txtTimKiem.setToolTipText("Văn bản muốn tìm");
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(1465, 11, 301, 30);
		panel.add(txtTimKiem);

		btnTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimKiem.setToolTipText("Thực hiện tìm kiếm");
		btnTimKiem.setBounds(1763, 11, 101, 30);
		panel.add(btnTimKiem);

		rdnTheTv = new JRadioButton("Số thẻ");
		rdnTheTv.setToolTipText("Tìm bằng số thẻ thư viện");
		rdnTheTv.setBounds(1465, 61, 92, 23);
		panel.add(rdnTheTv);

		rdnSdt = new JRadioButton("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i \u0111\u1ED9c gi\u1EA3");
		rdnSdt.setToolTipText("Tìm bằng số điện thoại");
		rdnSdt.setBounds(1569, 61, 164, 23);
		panel.add(rdnSdt);

		rdnMaPhieuMuon = new JRadioButton("M\u00E3 phi\u1EBFu m\u01B0\u1EE3n");
		rdnMaPhieuMuon.setToolTipText("Tìm bằng mã phiếu mượn");
		rdnMaPhieuMuon.setBounds(1755, 61, 109, 23);
		panel.add(rdnMaPhieuMuon);

		dayChoose = new JDateChooser(new Date());
		dayChoose.getCalendarButton().setToolTipText("Chọn ngày");

		dayChoose.setBounds(10, 41, 212, 30);
		panel.add(dayChoose);
		ButtonGroup group= new ButtonGroup();
		group.add(rdnMaPhieuMuon);
		group.add(rdnTheTv);
		group.add(rdnSdt);
		txtTrang.setEditable(false);
		rdnTheTv.setSelected(true);
		dsPhieuMuon = new ArrayList<PhieuMuon>();

		goToPage(1);
		setLableTongSoTrang();
		
		tblSach.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

				int y = e.getY() / 24;
				tblSach.getMousePosition();
				popupTable.show(tblSach, e.getX(), y * 24 + 24);
				int index = tblSach.getSelectedRow();
				String maPhieu = (String) tblSach.getValueAt(index, 1);
				if (maPhieu != null) {
					loadTableChiTiet(maPhieu);
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		dayChoose.addPropertyChangeListener(e -> {

		});
		btnNext.addActionListener(e -> {
			int page = Integer.parseInt(txtTrang.getText().trim());
			int tong = 1;
			try {
				tong = phieuMuonDao.tongSoDong() / 50;
				System.out.println(tong);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			if (page > tong) {
			} else {
				page++;
				goToPage(page);
			}

			txtTrang.setText("0" + page);

		});
		btnBack.addActionListener(e -> {
			int page = Integer.parseInt(txtTrang.getText().trim());
			if (page < 2) {
			} else {
				page--;
				goToPage(page);
			}

			txtTrang.setText("0" + page);
		});
		mnTra.addActionListener(e->{
			if(tblChiTiet.getValueAt(tblChiTiet.getSelectedRow(), 0)==null || tblChiTiet.getSelectedRow()==-1) {
				return;
			}
			ChiTietPhieuMuon chiTietPhieuMuon=getChiTietPhieuMuonDangChon();
			if(chiTietPhieuMuon.isTrangThaiTra()) {
				JOptionPane.showMessageDialog(this, "Sách này đã được trả vào ngày "+chiTietPhieuMuon.getNgayTra());
				return;
			}
			chiTietPhieuMuon.setNgayTra(LocalDate.now());
			chiTietPhieuMuon.setTrangThaiTra(true);
			boolean b = false;
			try {
				b = chiTietDao.suaChiTiet(chiTietPhieuMuon);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			if(b) {
				JOptionPane.showMessageDialog(this, "Trả sách thành công");
			}
			else JOptionPane.showMessageDialog(this, "Trả sách thất bại");
			
			
		});
		dayChoose.addPropertyChangeListener(e->{
			Date inputDate = dayChoose.getDate();
			LocalDate date = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			dsPhieuMuon=layDanhSachPhieuMuonTheoNgay(date);
			if(dsPhieuMuon!= null) {
				loadPhieuMuonFromList(dsPhieuMuon);
			}
		});
		btnTimKiem.addActionListener(e->{
			String text = txtTimKiem.getText().trim();
			if(rdnMaPhieuMuon.isSelected()) {
				dsPhieuMuon=timKiemBangMaPhieuMuon(text);
				loadPhieuMuonFromList(dsPhieuMuon);
			}
			else if(rdnTheTv.isSelected()) {
				dsPhieuMuon=timTheoMaDocGia(text);
				loadPhieuMuonFromList(dsPhieuMuon);
			}
			else if(rdnSdt.isSelected()) {
				dsPhieuMuon=timBangSdtDocGia(text);
				loadPhieuMuonFromList(dsPhieuMuon);
			}
			txtTimKiem.requestFocus();
			txtTimKiem.selectAll();
		});
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1920, 918);
		f.getContentPane().add(new MuonTraSach());
		f.setVisible(true);
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

	public void goToPage(int page) {
		loadTablePhieuMuon(page * 50 - 50, page * 50, page * 50 - 50);
	}

	public void setLableTongSoTrang() {
		int soDong = 0;
		int soTrang = 0;
		try {
			soDong = phieuMuonDao.tongSoDong();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (soDong == 0) {
			soTrang = 1;
		} else {
			soTrang = soDong / 50 + ((soDong % 50 == 0) ? 0 : 1);
			lblTongTrang.setText("Trên " + soTrang);
		}
	}

	public void loadTablePhieuMuon(int from, int to, int stt) {
		stt++;
		try {
			dsPhieuMuon = phieuMuonDao.getSoLuongFrom(from, to);
			System.out.println(dsPhieuMuon);
			ChucNangChoTable.XoaDongTable(modelSach);
			for (int i = 0; i < dsPhieuMuon.size(); i++) {
				
				Object[] row = { stt++, dsPhieuMuon.get(i).getMaPhieuMuon(),
						dsPhieuMuon.get(i).getNhanVien().getMaNhanVien(), dsPhieuMuon.get(i).getTheThuVien().getSoThe(),
						dsPhieuMuon.get(i).getTheThuVien().getDocGia().getTenDocGia(), dsPhieuMuon.get(i).getNgayMuon()
						,kiemTraTrangThaiPhieuMuon(dsPhieuMuon.get(i))?"Hoàn thành":"Chưa hoàn thành"};
				modelSach.addRow(row);
			}
			ChucNangChoTable.addNullDataTable(modelSach);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void loadTableChiTiet(String maPhieuMuon) {
		try {
			dsChiTiet = chiTietDao.getChiTietByMaPhieuMuon(maPhieuMuon);
			int i = 1;
			if (dsChiTiet != null) {
				ChucNangChoTable.XoaDongTable(modelChiTiet);
				for (ChiTietPhieuMuon chiTiet : dsChiTiet) {
					Object[] row = { i++, chiTiet.getSach().getMaSach(), chiTiet.getSach().getTenSach(),
							chiTiet.getSach().getTacGia().getTenTacGia(),
							chiTiet.isTrangThaiTra() ? chiTiet.getNgayTra() : "",
							chiTiet.isTrangThaiTra() ? "Đã trả" : "Chưa trả" };
					modelChiTiet.addRow(row);
				}
				ChucNangChoTable.addNullDataTable(modelChiTiet);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public boolean kiemTraTrangThaiPhieuMuon(PhieuMuon phieuMuon) {
		 try {
			List<ChiTietPhieuMuon> chitiet = chiTietDao.getChiTietByMaPhieuMuon(phieuMuon.getMaPhieuMuon());
			if(chitiet!=null) {
				for (ChiTietPhieuMuon chiTietPhieuMuon : chitiet) {
					if(!chiTietPhieuMuon.isTrangThaiTra()) {
						return false;
					}
				}
				return true;
			}
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ChiTietPhieuMuon getChiTietPhieuMuonDangChon() {
		int row=tblSach.getSelectedRow();
		int row1=tblChiTiet.getSelectedRow();
		
		String maPhieu=(String) tblSach.getValueAt(row, 1);
		String maSach=(String) tblChiTiet.getValueAt(row1, 1);
		
		try {
			ChiTietPhieuMuon chiTietPhieuMuon= chiTietDao.getChiTietByMa(maPhieu,maSach);
			return chiTietPhieuMuon;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<PhieuMuon> layDanhSachPhieuMuonTheoNgay(LocalDate ngay) {
		try {
			List<PhieuMuon> dspm = phieuMuonDao.getPhieuMuonByDate(ngay);
			return dspm;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void loadPhieuMuonFromList(List<PhieuMuon> ds) {
		if(ds==null)
			return;
		ChucNangChoTable.XoaDongTable(modelSach);
		int stt = 1;
		for (int i = 0; i < ds.size(); i++) {
			Object[] row = { stt++, ds.get(i).getMaPhieuMuon(),
					ds.get(i).getNhanVien().getMaNhanVien(), ds.get(i).getTheThuVien().getSoThe(),
					ds.get(i).getTheThuVien().getDocGia().getTenDocGia(), ds.get(i).getNgayMuon()
					,kiemTraTrangThaiPhieuMuon(ds.get(i))?"Hoàn thành":"Chưa hoàn thành"};
			modelSach.addRow(row);
		}
		ChucNangChoTable.addNullDataTable(modelSach);
	}
	public List<PhieuMuon> timTheoMaDocGia(String maDocGia) {
		try {
			return phieuMuonDao.timPhieuMuonBangTheThuVien(maDocGia);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<PhieuMuon> timKiemBangMaPhieuMuon(String maPhieu) {
		try {
			PhieuMuon pm = phieuMuonDao.getPhieuMuon(maPhieu);
			if(pm!=null) {
				return Arrays.asList(pm);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<PhieuMuon> timBangSdtDocGia(String sdt) {
		try {
			return phieuMuonDao.timPhieuMuonBangSdtDocGia(sdt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
