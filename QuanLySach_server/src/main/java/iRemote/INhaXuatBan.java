package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhaXuatBan;

public interface INhaXuatBan extends Remote{
	public List<NhaXuatBan> getAllNXB() throws RemoteException;
}
