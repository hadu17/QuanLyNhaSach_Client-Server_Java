package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class NhanVien implements Serializable {
	@Id
	@GeneratedValue(generator = "sinhMaTuDong")
	@GenericGenerator(name = "sinhMaTuDong",
						parameters = @Parameter(name="prefix", value = "NV"),
						strategy = "generator.SinhMaTuDong")
	private String maNhanVien;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNhanVien;
	private Date ngaySinh;
	private String soDienThoai;
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;
	private boolean chucVu;
	private boolean gioiTinh;
	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isChucVu() {
		return chucVu;
	}

	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public List<PhieuMuon> getDsPhieuMuon() {
		return dsPhieuMuon;
	}

	public void setDsPhieuMuon(List<PhieuMuon> dsPhieuMuon) {
		this.dsPhieuMuon = dsPhieuMuon;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@OneToMany(mappedBy = "nhanVien")
	private List<PhieuMuon> dsPhieuMuon;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private TaiKhoan taiKhoan;

	public NhanVien( String tenNhanVien, Date ngaySinh, String soDienThoai, String diaChi,
			boolean chucVu) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
	}

	
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + "]";
	}

	public NhanVien() {
		
	}
	
}
