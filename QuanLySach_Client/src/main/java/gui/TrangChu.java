package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import entity.TaiKhoan;

public class TrangChu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3267576735935490358L;
	private JPanel contentPane;
	private JButton btnSach;
	private JButton btnMuonTra;
	private JButton btnNhanVien;
	private JPopupMenu popupDocGia;
	private JButton btnDocGia;
	private JLabel lblThoat;
	private JPanel pnThayDoi;
	
	private JPanel guiDocGia= new QLDocGia();
	private GuiSach guiSach= new GuiSach();
	private JPanel guiMuonTraSach= new MuonTraSach();
	private JPanel guiNhanVien= new DSNhanVien();
	private JLabel lblNguoiDung;
	private JLabel lblChucVu;
	private TaiKhoan taiKhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrangChu() {
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1920, 108);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\img\\logo.jpg"));
		lblNewLabel.setBounds(0, 0, 128, 108);
		panel.add(lblNewLabel);

		lblNguoiDung = new JLabel("Chinh");
		lblNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNguoiDung.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNguoiDung.setIcon(
				new ImageIcon("src\\main\\resources\\img\\profile-user.png"));
		lblNguoiDung.setBounds(1712, 0, 196, 32);
		lblNguoiDung.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(lblNguoiDung);

		lblChucVu = new JLabel("Th\u1EE7 th\u01B0");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChucVu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblChucVu.setBounds(1813, 40, 97, 32);
		panel.add(lblChucVu);
		
		lblThoat = new JLabel("Thoát");
		lblThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThoat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThoat.setBounds(1800, 77, 110, 31);
		panel.add(lblThoat);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_1.setBorder(new MatteBorder(0, 0, 5, 0, (Color) new Color(4,135,217)));
		panel_1.setBounds(0, 108, 1920, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		btnSach = new JButton("S\u00E1ch");
		btnSach.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnSach.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSach.setRequestFocusEnabled(false);
		btnSach.setBorder(new LineBorder(new Color(4,135,217)));
		btnSach.setPreferredSize(new Dimension(150, 56));
		btnSach.setForeground(Color.WHITE);
		btnSach.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSach.setBackground(new Color(4,135,217));
		btnSach.setBounds(0, -1, 150, 54);
		panel_1.add(btnSach);

		btnMuonTra = new JButton("M\u01B0\u1EE3n tr\u1EA3");
		btnMuonTra.setRequestFocusEnabled(false);
		btnMuonTra.setBorder(new LineBorder(new Color(4,135,217)));
		btnMuonTra.setPreferredSize(new Dimension(150, 56));
		btnMuonTra.setForeground(Color.WHITE);
		btnMuonTra.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMuonTra.setBackground(new Color(4,135,217));
		btnMuonTra.setBounds(150, -1, 150, 54);
		panel_1.add(btnMuonTra);

		btnDocGia = new JButton("\u0110\u1ECDc gi\u1EA3");
		btnDocGia.setRequestFocusEnabled(false);
		btnDocGia.setBorder(new LineBorder(new Color(4,135,217)));
		btnDocGia.setPreferredSize(new Dimension(150, 56));
		btnDocGia.setForeground(Color.WHITE);
		btnDocGia.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDocGia.setBackground(new Color(4,135,217));
		btnDocGia.setBounds(300, -1, 150, 54);
		panel_1.add(btnDocGia);

		btnNhanVien = new JButton("Nh\u00E2n vi\u00EAn");
		btnNhanVien.setRequestFocusEnabled(false);
		btnNhanVien.setBorder(new LineBorder(new Color(4,135,217)));
		btnNhanVien.setPreferredSize(new Dimension(150, 56));
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNhanVien.setBackground(new Color(4,135,217));
		btnNhanVien.setBounds(450, -1, 150, 54);
		panel_1.add(btnNhanVien);

		
		pnThayDoi=guiSach;
		pnThayDoi.setBounds(0, 162, 1920, 907);
		pnThayDoi.setLayout(new BorderLayout());
		getContentPane().add(pnThayDoi);

		popupDocGia = new JPopupMenu();
		addPopup(btnDocGia, popupDocGia);
		popupDocGia.setBorder(new LineBorder(new Color(0, 0, 0)));
		popupDocGia.setAlignmentX(0.5f);

		JMenuItem pop = new JMenuItem("\u0110\u1ECDc gi\u1EA3");
		pop.setPreferredSize(new Dimension(147, 36));
		pop.setForeground(Color.BLACK);
		pop.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pop.setBackground(Color.GRAY);
		popupDocGia.add(pop);
		btnSach.setBackground(new Color(4,178,217));
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Th\u1EBB \u0111\u1ECDc s\u00E1ch");
		mntmNewMenuItem_1_2.setPreferredSize(new Dimension(145, 36));
		mntmNewMenuItem_1_2.setForeground(Color.BLACK);
		mntmNewMenuItem_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_1_2.setBackground(Color.GRAY);
		popupDocGia.add(mntmNewMenuItem_1_2);

		lblThoat.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				int temp=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát","Xác nhận",JOptionPane.YES_NO_OPTION);
				if(temp==JOptionPane.YES_OPTION) {
					dispose();
					DangNhap.getGuiDangNhap().setVisible(true);
					
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblThoat.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblThoat.setForeground(Color.GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		suKienChuotButton(btnMuonTra, null);
		suKienChuotButton(btnNhanVien, null);
		suKienChuotButton(btnSach, null);
		suKienChuotButton(btnDocGia, null);
		
		btnMuonTra.addActionListener(e->{
			setPnThayDoi(guiMuonTraSach);
			
		});
		btnSach.addActionListener(e->{
			setPnThayDoi(guiSach);
		});
		btnDocGia.addActionListener(e->{
			setPnThayDoi(guiDocGia);
			
		});
		btnNhanVien.addActionListener(e->{
			setPnThayDoi(guiNhanVien);
			
		});
		lblNguoiDung.addMouseListener(new MouseListener() {
			

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				XemThongTinNhanVien thongTinNhanVien= new XemThongTinNhanVien();
				thongTinNhanVien.setTaiKhoan(taiKhoan);
				thongTinNhanVien.setVisible(true);				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblNguoiDung.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNguoiDung.setForeground(Color.GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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

	public void suKienChuotButton(JButton button, JPopupMenu popupMenu) {
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				resetColorMenu();
				button.setBackground(new Color(4,178,217));
				
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
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * đưa tất cả menu về màu gốc
	 * 
	 */
	public void resetColorMenu() {
		btnMuonTra.setBackground(new Color(4,135,217));
		btnNhanVien.setBackground(new Color(4,135,217));
		btnSach.setBackground(new Color(4,135,217));
		btnDocGia.setBackground(new Color(4,135,217));
	}
	/**
	 * Thay đổi các pannel
	 * @param panel
	 */
	public void setPnThayDoi(JPanel panel) {
		SwingUtilities.invokeLater(()->{
			getContentPane().remove(pnThayDoi);
			pnThayDoi=panel;
			pnThayDoi.setBounds(0, 162, 1920, 907);
			this.revalidate();
			this.repaint();
			getContentPane().add(pnThayDoi);
		});
		
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		lblNguoiDung.setText(taiKhoan.getNhanVien().getTenNhanVien());
		lblChucVu.setText(taiKhoan.getNhanVien().isChucVu()?"Quan lý":"Thủ thư");
		this.taiKhoan=taiKhoan;
		this.guiSach.setNhanVien(taiKhoan.getNhanVien());
		System.out.println(this.taiKhoan);
		if(!taiKhoan.getNhanVien().isChucVu()) {
			btnNhanVien.setVisible(false);
		}
	}
}
