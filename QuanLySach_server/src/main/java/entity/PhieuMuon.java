package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class PhieuMuon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "sinhMaTheoNgay")
	@GenericGenerator(name = "sinhMaTheoNgay",
						parameters = @Parameter(name="prefix", value = "PM"),
						strategy = "generator.SinhMaTheoNgay")
	private String maPhieuMuon;
	private LocalDate ngayMuon;
	public PhieuMuon(LocalDate ngayMuon, TheThuVien theThuVien, NhanVien nhanVien) {
		super();
		this.ngayMuon = ngayMuon;
		this.theThuVien = theThuVien;
		this.nhanVien = nhanVien;
	}

	@ManyToOne
	@JoinColumn(name = "soThe")
	private TheThuVien theThuVien;
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	@OneToMany(mappedBy ="phieuMuon" , fetch = FetchType.EAGER)
	private List<ChiTietPhieuMuon> dsChiTietPhieuMuon;

	public PhieuMuon() {
		super();
	}

	public String getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(String maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
	}

	public LocalDate getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(LocalDate ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public TheThuVien getTheThuVien() {
		return theThuVien;
	}

	public void setTheThuVien(TheThuVien theThuVien) {
		this.theThuVien = theThuVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<ChiTietPhieuMuon> getDsChiTietPhieuMuon() {
		return dsChiTietPhieuMuon;
	}

	public void setDsChiTietPhieuMuon(List<ChiTietPhieuMuon> dsChiTietPhieuMuon) {
		this.dsChiTietPhieuMuon = dsChiTietPhieuMuon;
	}

	@Override
	public String toString() {
		return "PhieuMuon [maPhieuMuon=" + maPhieuMuon + ", ngayMuon=" + ngayMuon + ", theThuVien=" + theThuVien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhieuMuon == null) ? 0 : maPhieuMuon.hashCode());
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
		PhieuMuon other = (PhieuMuon) obj;
		if (maPhieuMuon == null) {
			if (other.maPhieuMuon != null)
				return false;
		} else if (!maPhieuMuon.equals(other.maPhieuMuon))
			return false;
		return true;
	}

	public PhieuMuon(LocalDate ngayMuon, TheThuVien theThuVien) {
		super();
		this.ngayMuon = ngayMuon;
		this.theThuVien = theThuVien;
	}
}
