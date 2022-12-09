package iRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.TaiKhoan;

public interface ITaiKhoan extends Remote{
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) throws RemoteException;
	public boolean themTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;
	public boolean suaTaiKhoan(TaiKhoan taiKhoan) throws RemoteException;
	public boolean xoaTaiKhoan(String tenTaiKhoan) throws RemoteException;
}
