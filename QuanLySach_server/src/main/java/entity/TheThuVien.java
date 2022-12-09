package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TheThuVien implements Serializable{
	@Id
	private String soThe;
	private Date ngayBatDau;
	private Date ngayHetHan;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "soThe")
	private DocGia docGia;
	@OneToMany(mappedBy = "theThuVien")
	private List<PhieuMuon> dsPhieuMuon;
	public TheThuVien(String soThe, Date ngayBatDau, Date ngayHetHan) {
		super();
		this.soThe = soThe;
		this.ngayBatDau = ngayBatDau;
		this.ngayHetHan = ngayHetHan;
	}
	public TheThuVien() {
		super();
	}
	public String getSoThe() {
		return soThe;
	}
	public void setSoThe(String soThe) {
		this.soThe = soThe;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public DocGia getDocGia() {
		return docGia;
	}
	public void setDocGia(DocGia docGia) {
		this.docGia = docGia;
	}
	public List<PhieuMuon> getDsPhieuMuon() {
		return dsPhieuMuon;
	}
	public void setDsPhieuMuon(List<PhieuMuon> dsPhieuMuon) {
		this.dsPhieuMuon = dsPhieuMuon;
	}
	@Override
	public String toString() {
		return "TheThuVien [soThe=" + soThe + ", ngayBatDau=" + ngayBatDau + ", ngayHetHan=" + ngayHetHan + "]";
	}
	
}
