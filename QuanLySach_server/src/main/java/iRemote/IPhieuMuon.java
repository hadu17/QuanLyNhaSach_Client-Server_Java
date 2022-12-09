package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import entity.PhieuMuon;

public interface IPhieuMuon extends Remote {
	public boolean themPhieuMuon(PhieuMuon phieuMuon) throws RemoteException;

	public PhieuMuon getPhieuMuon(String maPhieu) throws RemoteException;

	public List<PhieuMuon> getPhieuMuonByDate(LocalDate date) throws RemoteException;

	public List<PhieuMuon> getSoLuongFrom(int from, int to) throws RemoteException;

	public int tongSoDong() throws RemoteException;

	public List<PhieuMuon> timPhieuMuonBangTheThuVien(String maThe) throws RemoteException;
	
	public List<PhieuMuon> timPhieuMuonBangSdtDocGia(String sdt) throws RemoteException;
}
