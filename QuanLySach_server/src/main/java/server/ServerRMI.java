package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.ChiTietPhieuMuonDao;
import dao.DocGiaImpl;
import dao.NhaXuatBanDao;
import dao.NhanVienImpl;
import dao.PhieuMuonDao;
import dao.SachDao;
import dao.TacGiaDao;
import dao.TaiKhoanDao;
import dao.TheLoaiDao;
import dao.TheThuVienDao;
import iRemote.DocGiaDao;
import iRemote.IChiTiet;
import iRemote.INhaXuatBan;
import iRemote.IPhieuMuon;
import iRemote.ISach;
import iRemote.ITacGia;
import iRemote.ITaiKhoan;
import iRemote.ITheLoai;
import iRemote.ITheThuVien;
import iRemote.NhanVienDao;

public class ServerRMI {
	public ServerRMI(String host) throws RemoteException, NamingException {
		SecurityManager securityManager= System.getSecurityManager();
		if(securityManager==null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		ISach iSach= new SachDao();
		ITheLoai iTheLoai= new TheLoaiDao();
		INhaXuatBan iNhaXuatBan= new NhaXuatBanDao();
		ITacGia iTacGia= new TacGiaDao();
		DocGiaDao docGiaDao = new DocGiaImpl();
		IPhieuMuon iPhieuMuon= new PhieuMuonDao();
		IChiTiet iChiTiet= new ChiTietPhieuMuonDao();
		ITheThuVien iTheThuVien= new TheThuVienDao();
		NhanVienDao nhanVienDao= new NhanVienImpl();
		ITaiKhoan iTaiKhoan= new TaiKhoanDao();
		
		
		LocateRegistry.createRegistry(2910);
		Context context=new  InitialContext();
		context.bind("rmi://"+host+":2910/iSach", iSach);
		context.bind("rmi://"+host+":2910/iTheLoai", iTheLoai);
		context.bind("rmi://"+host+":2910/iNhaXuatBan", iNhaXuatBan);
		context.bind("rmi://"+host+":2910/iTacGia", iTacGia);
		context.bind("rmi://"+host+":2910/docGiaDao", docGiaDao);
		context.bind("rmi://"+host+":2910/iPhieuMuon",iPhieuMuon );
		context.bind("rmi://"+host+":2910/iChiTiet",iChiTiet );
		context.bind("rmi://"+host+":2910/iTheThuVien",iTheThuVien );
		context.bind("rmi://"+host+":2910/nhanVienDao",nhanVienDao );
		context.bind("rmi://"+host+":2910/iTaiKhoan",iTaiKhoan );
		System.out.println("ready");
	}
	public static void main(String[] args) throws RemoteException, NamingException, MalformedURLException, NotBoundException {
		new ServerRMI("192.168.1.11");
//		shotDown("192.168.1.11");
//		shotDown();
	}
	public static void shotDown(String host) throws RemoteException, MalformedURLException, NotBoundException {
		Naming.unbind("rmi://"+host+":2910/iSach");
		Naming.unbind("rmi://"+host+":2910/iTheLoai");
		Naming.unbind("rmi://"+host+":2910/iNhaXuatBan");
		Naming.unbind("rmi://"+host+":2910/iTacGia");
		Naming.unbind("rmi://"+host+":2910/docGiaDao");
		Naming.unbind("rmi://"+host+":2910/iPhieuMuon" );
		Naming.unbind("rmi://"+host+":2910/iChiTiet");
		Naming.unbind("rmi://"+host+":2910/iTheThuVien" );
//		UnicastRemoteObject.unexportObject(true);
		System.exit(1);
	}
}
