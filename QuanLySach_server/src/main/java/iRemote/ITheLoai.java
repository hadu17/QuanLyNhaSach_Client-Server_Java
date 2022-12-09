package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TheLoai;

public interface ITheLoai extends Remote{
	public List<TheLoai> getAllTheLoai() throws RemoteException;
}
