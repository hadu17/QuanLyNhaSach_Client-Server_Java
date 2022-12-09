package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietMuonPK implements Serializable{
	private String phieuMuon;
	private String sach;
	public ChiTietMuonPK() {
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
		ChiTietMuonPK other = (ChiTietMuonPK) obj;
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
	public String getPhieuMuon() {
		return phieuMuon;
	}
	public void setPhieuMuon(String phieuMuon) {
		this.phieuMuon = phieuMuon;
	}
	public String getSach() {
		return sach;
	}
	public void setSach(String sach) {
		this.sach = sach;
	}
	@Override
	public String toString() {
		return "ChiTietMuonPK [phieuMuon=" + phieuMuon + ", sach=" + sach + "]";
	}
	
}
