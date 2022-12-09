package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ChiTietMuonPK.class)
public class ChiTietPhieuMuon implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name="maPhieuMuon")
	private PhieuMuon phieuMuon;
	@Id
	@ManyToOne
	@JoinColumn(name="maSach")
	private Sach sach;
	private boolean trangThaiTra;
	private LocalDate ngayTra;
	@Override
	public String toString() {
		return "ChiTietPhieuMuon [phieuMuon=" + phieuMuon + ", sach=" + sach + ", trangThaiTra=" + trangThaiTra
				+ ", ngayTra=" + ngayTra + "]";
	}
	public ChiTietPhieuMuon(PhieuMuon phieuMuon, Sach sach, boolean trangThaiTra, LocalDate ngayTra) {
		super();
		this.phieuMuon = phieuMuon;
		this.sach = sach;
		this.trangThaiTra = trangThaiTra;
		this.ngayTra = ngayTra;
	}
	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}
	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}
	public Sach getSach() {
		return sach;
	}
	public void setSach(Sach sach) {
		this.sach = sach;
	}
	public boolean isTrangThaiTra() {
		return trangThaiTra;
	}
	public void setTrangThaiTra(boolean trangThaiTra) {
		this.trangThaiTra = trangThaiTra;
	}
	public LocalDate getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}
	public ChiTietPhieuMuon() {
		super();
	}
	public ChiTietPhieuMuon(boolean trangThaiTra, LocalDate ngayTra) {
		super();
		this.trangThaiTra = trangThaiTra;
		this.ngayTra = ngayTra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phieuMuon == null) ? 0 : phieuMuon.hashCode());
		result = prime * result + ((sach == null) ? 0 : sach.hashCode());
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
		ChiTietPhieuMuon other = (ChiTietPhieuMuon) obj;
		if (phieuMuon == null) {
			if (other.phieuMuon != null)
				return false;
		} else if (!phieuMuon.equals(other.phieuMuon))
			return false;
		if (sach == null) {
			if (other.sach != null)
				return false;
		} else if (!sach.equals(other.sach))
			return false;
		return true;
	}
}
