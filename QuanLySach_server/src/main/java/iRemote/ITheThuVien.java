package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.TheThuVien;

public interface ITheThuVien extends Remote{
	public TheThuVien getTheThuVien(String ma) throws RemoteException;
	
}
