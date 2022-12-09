package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
public class Sach implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7322072960303571686L;
	@Id
	@GeneratedValue(generator = "sinhMaTuDong")
	@GenericGenerator(name = "sinhMaTuDong",
						parameters = @Parameter(name="prefix", value = "SA"),
						strategy = "generator.SinhMaTuDong")
	private String maSach;
	private String tenSach;
	
	@ManyToOne
	@JoinColumn(name = "maTacGia")
	private TacGia tacGia;
	@ManyToOne
	@JoinColumn(name = "maTheLoai")
	private TheLoai theLoai;
	@ManyToOne
	@JoinColumn(name = "maNhaXuatBan")
	private NhaXuatBan nhaXuatBan;
	private int namXuatBan; 
	private boolean trangThai;
	
	@OneToMany(mappedBy ="sach")
	private List<ChiTietPhieuMuon> dsChiTietPhieuMuon;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		return true;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public Sach() {
		super();
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public List<ChiTietPhieuMuon> getDsChiTietPhieuMuon() {
		return dsChiTietPhieuMuon;
	}

	public void setDsChiTietPhieuMuon(List<ChiTietPhieuMuon> dsChiTietPhieuMuon) {
		this.dsChiTietPhieuMuon = dsChiTietPhieuMuon;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", namXuatBan=" + namXuatBan + ", trangThai="
				+ trangThai + "]";
	}

	public Sach(String tenSach, int namXuatBan, boolean trangThai) {
		super();
		this.tenSach = tenSach;
		this.namXuatBan = namXuatBan;
		this.trangThai = trangThai;
	}
	
}
