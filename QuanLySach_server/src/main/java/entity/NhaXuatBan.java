package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NhaXuatBan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5927388503514172918L;
	@Id
	private String maNhaXuatBan;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenNhaXuatBan;
	@Column(columnDefinition = "nvarchar(200)")
	private String diaChi;
	private String email;
	@OneToMany(mappedBy = "nhaXuatBan")
	private List<Sach> dsSach;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhaXuatBan == null) ? 0 : maNhaXuatBan.hashCode());
		return result;
	}
	public NhaXuatBan() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaXuatBan other = (NhaXuatBan) obj;
		if (maNhaXuatBan == null) {
			if (other.maNhaXuatBan != null)
				return false;
		} else if (!maNhaXuatBan.equals(other.maNhaXuatBan))
			return false;
		return true;
	}
	public String getMaNhaXuatBan() {
		return maNhaXuatBan;
	}
	public void setMaNhaXuatBan(String maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}
	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}
	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(List<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	@Override
	public String toString() {
		return "NhaXuatBan [maNhaXuatBan=" + maNhaXuatBan + ", tenNhaXuatBan=" + tenNhaXuatBan + ", diaChi=" + diaChi
				+ ", email=" + email + "]";
	}
	public NhaXuatBan(String tenNhaXuatBan, String diaChi, String email) {
		super();
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.diaChi = diaChi;
		this.email = email;
	}
}
