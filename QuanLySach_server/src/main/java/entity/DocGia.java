package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class DocGia implements Serializable{
	@Id
	@GeneratedValue(generator = "sinhMaTuDong")
	@GenericGenerator(name = "sinhMaTuDong",
						parameters = @Parameter(name="prefix", value = "DG"),
						strategy = "generator.SinhMaTuDong")
	private String maDocGia;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenDocGia;
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;
	private String soDienThoai;
	private boolean gioiTinh;
	@OneToOne
	@PrimaryKeyJoinColumn
	private TheThuVien theThuVien;
	public String getMaDocGia() {
		return maDocGia;
	}
	public void setMaDocGia(String maDocGia) {
		this.maDocGia = maDocGia;
	}
	public String getTenDocGia() {
		return tenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public TheThuVien getTheThuVien() {
		return theThuVien;
	}
	public void setTheThuVien(TheThuVien theThuVien) {
		this.theThuVien = theThuVien;
	}
	public DocGia(String maDocGia, String tenDocGia, String diaChi, String soDienThoai, boolean gioiTinh) {
		super();
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
	}
	public DocGia() {
		super();
	}
	@Override
	public String toString() {
		return "DocGia [maDocGia=" + maDocGia + ", tenDocGia=" + tenDocGia + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", gioiTinh=" + gioiTinh + "]";
	}
	
	
}
