package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.PhieuMuon;
import hibernateCfg.HibernateConfig;
import iRemote.IPhieuMuon;

public class PhieuMuonDao extends UnicastRemoteObject implements IPhieuMuon{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory=null;
	public PhieuMuonDao() throws RemoteException {
		sessionFactory=HibernateConfig.getInstance().getSessionFactory();
	}
	@Override
	public boolean themPhieuMuon(PhieuMuon phieuMuon) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(phieuMuon);
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
	public PhieuMuon getPhieuMuon(String maPhieu) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			PhieuMuon phieuMuon= session.find(PhieuMuon.class, maPhieu);
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
	public List<PhieuMuon> getPhieuMuonByDate(LocalDate date) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query=" select * from PhieuMuon as p "
					+ "  where p.ngayMuon='"+date+"'";
			List<PhieuMuon> phieuMuon= session.createNativeQuery(query,PhieuMuon.class).getResultList();
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
	public List<PhieuMuon> getSoLuongFrom(int from, int to) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query="  select * from PhieuMuon order by maPhieuMuon offset "+from+" rows fetch next "+(to-from)+" rows only ";
			List<PhieuMuon> phieuMuon= session.createNativeQuery(query,PhieuMuon.class).getResultList();
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	public static void main(String[] args) throws RemoteException {
		PhieuMuonDao phieuMuonDao= new PhieuMuonDao();
		System.out.println(phieuMuonDao.getSoLuongFrom(0, 50));
	}
	@Override
	public int tongSoDong() throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			int soDong = (int) session.createNativeQuery(" select COUNT(maPhieuMuon) from PhieuMuon").getSingleResult();
			tr.commit();
			return soDong;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return -1;
	}
	@Override
	public List<PhieuMuon> timPhieuMuonBangTheThuVien(String maThe) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query=" select * from PhieuMuon where soThe='"+maThe+"'";
			List<PhieuMuon> phieuMuon= session.createNativeQuery(query,PhieuMuon.class).getResultList();
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<PhieuMuon> timPhieuMuonBangSdtDocGia(String sdt) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query="SELECT        p.* "
					+ "FROM            PhieuMuon AS p INNER JOIN "
					+ "                         TheThuVien AS t ON p.soThe = t.soThe INNER JOIN "
					+ "                         DocGia AS d ON t.soThe = d.maDocGia "
					+ "where d.soDienThoai='"+sdt+"'";
			List<PhieuMuon> phieuMuon= session.createNativeQuery(query,PhieuMuon.class).getResultList();
			tr.commit();
			return phieuMuon;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
