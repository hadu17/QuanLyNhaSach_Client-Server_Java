package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TacGia;

public interface ITacGia extends Remote{
	public List<TacGia> getAllTacGia() throws RemoteException ;
}
