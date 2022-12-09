package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import entity.TaiKhoan;
import iRemote.ITaiKhoan;

public class XemThongTinNhanVien extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ITaiKhoan taiKhoanDao;
	private TaiKhoan taiKhoan;
	private JButton btnDoiPass;
	private JLabel lblMa;
	private JLabel lblDiaChi;
	private JLabel lblGioiTinh;
	private JLabel lblNgaySinh;
	private JLabel lblSdt;
	private JLabel lblTen;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ThemDocGiaDialog dialog = new ThemDocGiaDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
////
	/**
	 * Create the dialog.
	 */
	public XemThongTinNhanVien() {
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
			taiKhoanDao=(ITaiKhoan) Naming.lookup("rmi://192.168.1.11:2910/iTaiKhoan");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 737, 715);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblThmcGi = new JLabel("Thông Tin Nhân Viên");
			lblThmcGi.setOpaque(true);
			lblThmcGi.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmcGi.setForeground(new Color(0, 0, 0));
			lblThmcGi.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblThmcGi.setBackground(new Color(255, 255, 255));
			lblThmcGi.setBounds(0, 4, 721, 38);
			contentPanel.add(lblThmcGi);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(XemThongTinNhanVien.class.getResource("/img/user (5).png")));
		lblNewLabel.setBounds(130, 55, 440, 219);
		contentPanel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192), 0, true));
		panel_1.setBounds(0, 310, 721, 368);
		contentPanel.add(panel_1);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblTngDoanhThu = new JLabel("Mã số:");
		lblTngDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDoanhThu_2 = new JLabel("Họ tên");
		lblDoanhThu_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSHan = new JLabel("Số điện thoại:");
		lblSHan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTngSGi = new JLabel("Ngày sinh:");
		lblTngSGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTngTinPhng = new JLabel("Giới tính:");
		lblTngTinPhng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblMa = new JLabel("NV0001");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblTen = new JLabel("Trần Hạ Dũ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblSdt = new JLabel("0795817259");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNgaySinh = new JLabel("5/7/2001");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblGioiTinh = new JLabel("Nam");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblDiaChi = new JLabel("TP Hồ Chí MInh");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTngTinPhng_1 = new JLabel("Địa chỉ:");
		lblTngTinPhng_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(100, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTngDoanhThu, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addComponent(lblDoanhThu_2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSHan, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTngSGi, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTngTinPhng_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTngTinPhng, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
							.addGap(30)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(1)
									.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
							.addGap(160))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(15)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTngDoanhThu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblDoanhThu_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblSHan, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTngSGi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTngTinPhng, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTngTinPhng_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(lblSdt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblXemChiTit = new JLabel("Xem chi tiết");
		lblXemChiTit.setHorizontalAlignment(SwingConstants.CENTER);
		lblXemChiTit.setForeground(new Color(51, 0, 255));
		lblXemChiTit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblXemChiTit.setBounds(5, 277, 713, 30);
		contentPanel.add(lblXemChiTit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 48, 721, 2);
		contentPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 49, 721, 1);
		contentPanel.add(separator_2);
		
		btnDoiPass = new JButton("Đổi mật khẩu");
		btnDoiPass.setBounds(590, 60, 121, 23);
		contentPanel.add(btnDoiPass);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		btnDoiPass.addActionListener(e->{
			ThayDoiThongTinDangNhap doiThongTinDangNhap= new ThayDoiThongTinDangNhap();
			doiThongTinDangNhap.setTaiKhoan(taiKhoan);
			doiThongTinDangNhap.setVisible(true);
		});
	}
	
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/mm/yyyy");
		
		lblMa.setText(taiKhoan.getTenTaiKhoan());
		lblTen.setText(taiKhoan.getNhanVien().getTenNhanVien());
		lblGioiTinh.setText(taiKhoan.getNhanVien().isGioiTinh()?"Nam":"Nữ");
		
		LocalDate date = taiKhoan.getNhanVien().getNgaySinh().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		lblNgaySinh.setText(""+date);
		lblDiaChi.setText(taiKhoan.getNhanVien().getDiaChi());
		lblSdt.setText(taiKhoan.getNhanVien().getSoDienThoai());
		this.taiKhoan=taiKhoan;
	}
}
