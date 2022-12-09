package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao extends Remote{
 public List<NhanVien> layDSNhanVien(NhanVien nhanVien)throws RemoteException;
 public boolean themNhanVien(NhanVien nhanVien)throws RemoteException;
 public int tongTrang(String txtSearch, int limit)throws RemoteException;
 public List<NhanVien> layDanhSachNhanVien(int page, String ten, int limit)throws RemoteException;
 public NhanVien layNhanVienTheoMa(String ma) throws RemoteException;
 public List<NhanVien> layNhanVienTheoTen(String ten) throws RemoteException;
 public boolean capNhatNhanVien(NhanVien nhanVien) throws RemoteException;
 public boolean xoaNhanVien(String nhanVien) throws RemoteException;
// public String phatSinhMaTuDong()throws RemoteException;
}
