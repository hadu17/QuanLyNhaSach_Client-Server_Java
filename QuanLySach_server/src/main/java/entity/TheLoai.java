package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dao.TheLoaiDao;

@Entity
public class TheLoai implements Serializable{
	@Id
	private String maTheLoai;
	@Column(columnDefinition = "nvarchar(100)")
	private String tenTheLoai;
	@OneToMany(mappedBy = "theLoai")
	private List<Sach> dsSach;
	public TheLoai(String tenTheLoai) {
		super();
		this.tenTheLoai = tenTheLoai;
	}
	public TheLoai() {
		super();
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	public List<Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(List<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTheLoai == null) ? 0 : maTheLoai.hashCode());
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
		TheLoai other = (TheLoai) obj;
		if (maTheLoai == null) {
			if (other.maTheLoai != null)
				return false;
		} else if (!maTheLoai.equals(other.maTheLoai))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TheLoai [maTheLoai=" + maTheLoai + ", tenTheLoai=" + tenTheLoai + "]";
	}
	

}
