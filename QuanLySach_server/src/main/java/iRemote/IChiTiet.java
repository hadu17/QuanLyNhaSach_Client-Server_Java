package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChiTietPhieuMuon;

public interface IChiTiet extends Remote{
	public List<ChiTietPhieuMuon> getChiTietByMaPhieuMuon(String maPhieuMuon) throws RemoteException;
	public ChiTietPhieuMuon getChiTietByMa(String maPhieuMuon,String maSach) throws RemoteException;
	public boolean themChiTiet(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
	public boolean suaChiTiet(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException;
}
