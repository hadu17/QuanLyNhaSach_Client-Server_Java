package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.ChiTietPhieuMuon;
import hibernateCfg.HibernateConfig;
import iRemote.IChiTiet;

public class ChiTietPhieuMuonDao extends UnicastRemoteObject implements IChiTiet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory= null;
	
	public ChiTietPhieuMuonDao() throws RemoteException{
		sessionFactory= HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public List<ChiTietPhieuMuon> getChiTietByMaPhieuMuon(String maPhieuMuon) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query=" select * from ChiTietPhieuMuon as p "
					+ "  where p.maPhieuMuon='"+maPhieuMuon+"'";
			List<ChiTietPhieuMuon> phieuMuon= session.createNativeQuery(query,ChiTietPhieuMuon.class).getResultList();
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public ChiTietPhieuMuon getChiTietByMa(String maPhieuMuon, String maSach) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			ChiTietPhieuMuon phieuMuon= session.createNativeQuery("select * from ChiTietPhieuMuon where maPhieuMuon='"+maPhieuMuon+"' and maSach='"+maSach+"'",ChiTietPhieuMuon.class).getSingleResult();
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean themChiTiet(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(ChiTietPhieuMuon.class.getName(),chiTietPhieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean suaChiTiet(ChiTietPhieuMuon chiTietPhieuMuon) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(ChiTietPhieuMuon.class.getName(),chiTietPhieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
}
