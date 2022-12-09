package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Transaction;

import entity.DocGia;
import entity.NhanVien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateCfg.HibernateConfig;
import iRemote.NhanVienDao;

public class NhanVienImpl extends UnicastRemoteObject implements NhanVienDao {
	private SessionFactory sessionFactory;

	public NhanVienImpl() throws RemoteException {
		sessionFactory = HibernateConfig.getInstance().getSessionFactory();
	}

	@Override
	public List<NhanVien> layDSNhanVien(NhanVien nhanVien) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> listNhanVien;
		String sql = "select * from NhanVien";
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();

		}
		session.close();
		return null;
	}

	@Override
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(nhanVien);
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
	public List<NhanVien> layDanhSachNhanVien(int page, String ten, int limit) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (ten == null)
			ten = "";

		if (limit <= 0) {
			limit = 20;
		}

		int offset = page * limit;// lay du lieu bat dau tu vi tri page*20
//		System.out.println(offset+" - "+ page);
		try {
			tr.begin();

			String sql = "SELECT *FROM NhanVien  where tenNhanVien like '%" + ten
					+ "%'  order by maNhanVien asc OFFSET " + offset + "  ROWS FETCH NEXT " + limit + "  ROWS ONLY;";
			List<NhanVien> dsKH = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			System.out.println(dsKH);
			return dsKH;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int tongTrang(String txtSearch, int limit) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (txtSearch == null)
			txtSearch = "";

		if (limit <= 0) {
			limit = 20;
		}
		try {
			tr.begin();
			String sql = "select count(*) from NhanVien where tenNhanVien like N'%" + txtSearch + "%' ";
			int result = Integer.parseInt(session.createNativeQuery(sql).uniqueResult().toString());
			System.out.println("Tongtrang");
			System.out.println(result);
			tr.commit();
			return result % limit == 0 ? result / limit : (result / limit) + 1;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("tongHang: " + e.getMessage());
			tr.rollback();

		} finally {
			session.close();
		}
		return 0;
	}

//	@Override
	public NhanVien layNhanVienTheoMa(String ma) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		String sql = "Select * from NhanVien where maNhanVien like N'%" + ma + "%'";
		try {
			tr.begin();
			NhanVien dG =session.createNativeQuery(sql, NhanVien.class).getSingleResult();
			tr.commit();
			System.out.println();
			return dG;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public boolean capNhatNhanVien(NhanVien nhanVien) throws RemoteException {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean xoaNhanVien(String nhanVien) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();

		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.delete(session.find(NhanVien.class, nhanVien));
			tr.commit();

			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}

	@Override
	public List<NhanVien> layNhanVienTheoTen(String ten) throws RemoteException {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();

		String sql = "Select * from NhanVien where tenNhanVien like N'%" + ten + "%'";
		try {
			tr.begin();
			List<NhanVien> dG = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			System.out.println(dG);
			return dG;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}
	public static void main(String[] args) throws RemoteException {
		NhanVienImpl nhanVienImpl= new NhanVienImpl();
		System.out.println(nhanVienImpl.layNhanVienTheoMa("NV0002" ));
	}

}
