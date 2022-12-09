package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DocGia;

public interface DocGiaDao extends Remote{
 public List<DocGia> layDSDocGia(DocGia docGia)throws RemoteException;
 public boolean themDocGia(DocGia docGia)throws RemoteException;
 public int tongTrang(String txtSearch, int limit)throws RemoteException;
 public List<DocGia> layDanhSachDocGia(int page, String ten, int limit)throws RemoteException;
 public DocGia layDocGiaTheoMa(String ma) throws RemoteException;
 public List<DocGia> layDocGiaTheoTen(String ten) throws RemoteException;
 public boolean capNhatDocGia(DocGia docGia) throws RemoteException;
 public boolean xoaDocGia(String docGia) throws RemoteException;
// public String phatSinhMaTuDong()throws RemoteException;
}
