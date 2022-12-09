package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.Sach;

public interface ISach extends Remote{
	/**
	 * Lấy sách theo loại
	 * @param maLoai
	 * @param from
	 * @param to
	 * @return
	 * @throws RemoteException
	 */
	public List<Sach>  getSach(String maLoai,int from,int to) throws RemoteException;
	/**
	 * Thêm một sách mới
	 * @param sach
	 * @return
	 * @throws RemoteException
	 */
	public boolean  themSach(Sach sach) throws RemoteException;
	
	/**
	 * Lấy sách theo tên sach
	 * @param tenSach
	 * @param from
	 * @param to
	 * @return
	 * @throws RemoteException
	 */
	public List<Sach>  getSachTheoTen(String tenSach,int from,int to) throws RemoteException;
	/**
	 * Lấy tổng số dòng cảu bảng
	 * @return thành công : số dòng , 
	 * 			Thất bại:-1
	 * @throws RemoteException
	 */
	public int tongSoDong() throws RemoteException;
	/**
	 * Lấy sách bằng mã sách
	 * @param maSach
	 * @return
	 * @throws RemoteException
	 */
	public Sach  getSach(String maSach) throws RemoteException;
	/**
	 * Cập nhật thông tin của sách
	 * @param sach
	 * @return
	 * @throws RemoteException
	 */
	public boolean updateSach(Sach sach)throws RemoteException ;
	/**
	 * Tìm sách theo tên của tác giả
	 * @param tenTacGia
	 * @return danh sách các sách có tác giả được truyền vào
	 * @throws RemoteException
	 */
	public List<Sach>  timSachTheoTenTacGia(String tenTacGia) throws RemoteException;
}
