package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;
import iRemote.ITaiKhoan;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DangNhap extends JFrame {
	private JTextField txtngNhp;
	private JPasswordField txtPass;
	private JTextField txtTenTaiKhoan;
	private JButton btnDangNhap;
	private JButton btnThoat;
	private ITaiKhoan taiKhoanDao;
	private TrangChu trangChu= new TrangChu();
	private static DangNhap dangNhap= new DangNhap();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dangNhap= new DangNhap();
			dangNhap.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dangNhap.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private DangNhap() {

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
			taiKhoanDao = (ITaiKhoan) Naming.lookup("rmi://192.168.1.11:2910/iTaiKhoan");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		setIconImage(new ImageIcon("src/main/resources/img/logo.jpg").getImage());
		setBounds(100, 100, 670, 396);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(2, 2, 656, 355);
		getContentPane().add(contentPane);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnDangNhap.setForeground(new Color(64, 0, 64));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBackground(new Color(0,206,209));
		btnDangNhap.setBounds(454, 291, 143, 35);
		contentPane.add(btnDangNhap);

		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setForeground(new Color(64, 0, 64));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBackground(new Color(0,206,209));
		btnThoat.setBounds(28, 291, 107, 35);
		contentPane.add(btnThoat);

		txtngNhp = new JTextField();
		txtngNhp.setText("Đăng nhập");
		txtngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		txtngNhp.setForeground(Color.BLACK);
		txtngNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtngNhp.setEditable(false);
		txtngNhp.setColumns(10);
		txtngNhp.setBackground(new Color(0,206,209));
		txtngNhp.setBounds(-8, 1, 664, 65);
		contentPane.add(txtngNhp);

		JLabel lblMNhnVin = new JLabel("Tên Tài khoản:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMNhnVin.setBounds(86, 121, 131, 35);
		contentPane.add(lblMNhnVin);

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(86, 183, 131, 35);
		contentPane.add(lblMatKhau);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(236, 185, 322, 35);
		contentPane.add(txtPass);

		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenTaiKhoan.setColumns(10);
		txtTenTaiKhoan.setBounds(236, 123, 325, 35);
		contentPane.add(txtTenTaiKhoan);
		btnDangNhap.addActionListener(e -> {
			TaiKhoan taiKhoan = getTaiKhoanFromForm();
			try {
				TaiKhoan taiKhoan1 = taiKhoanDao.getTaiKhoan(taiKhoan.getTenTaiKhoan());
				if(taiKhoan1== null) {
					JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác");
				}
				else {
					if(taiKhoan.getMatKhau().equals(taiKhoan1.getMatKhau())) {
						trangChu.setTaiKhoan(taiKhoan1);
						trangChu.setVisible(true);
						this.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác");
					}
				}
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}

		});
		btnThoat.addActionListener(e->{
			int temp = JOptionPane.showConfirmDialog(this, "Chắc chắn thoát","Xác nhận thoát",JOptionPane.YES_NO_OPTION);
			if(temp==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});
	}

	public TaiKhoan getTaiKhoanFromForm() {
		String ten = txtTenTaiKhoan.getText().trim();
		String ma = txtPass.getText().trim();
		if (ten.equals("") || ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác");
		}

		return new TaiKhoan(ten, ma);
	}
	
	public static DangNhap getGuiDangNhap() {
		return dangNhap;
	}
}
