package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TacGia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maTacGia;;
	@Column(columnDefinition = "nvarchar(50)")
	private String tenTacGia;
	private String email;
	@Column(columnDefinition = "nvarchar(200)")
	private String ghiChu;
	@OneToMany(mappedBy = "tacGia")
	private List<Sach> dsSach;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTacGia == null) ? 0 : maTacGia.hashCode());
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
		TacGia other = (TacGia) obj;
		if (maTacGia == null) {
			if (other.maTacGia != null)
				return false;
		} else if (!maTacGia.equals(other.maTacGia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TacGia [maTacGia=" + maTacGia + ", tenTacGia=" + tenTacGia + ", email=" + email + ", ghiChu=" + ghiChu
				+ "]";
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public List<Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(List<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	public TacGia() {
		super();
	}
	public TacGia(String tenTacGia, String email, String ghiChu) {
		super();
		this.tenTacGia = tenTacGia;
		this.email = email;
		this.ghiChu = ghiChu;
	}
	
}
