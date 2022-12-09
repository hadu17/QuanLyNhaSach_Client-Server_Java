package hibernateCfg;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.ChiTietMuonPK;
import entity.ChiTietPhieuMuon;
import entity.DocGia;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.Sach;
import entity.TacGia;
import entity.TaiKhoan;
import entity.TheLoai;
import entity.TheThuVien;


public class HibernateConfig {
	public static SessionFactory sessionFactory = null;
	public static HibernateConfig instance = new HibernateConfig();

	public static HibernateConfig getInstance() {
		return instance;
	}

	public HibernateConfig() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(DocGia.class)
				.addAnnotatedClass(NhaXuatBan.class)
				.addAnnotatedClass(TheLoai.class)
				.addAnnotatedClass(TacGia.class)
				.addAnnotatedClass(Sach.class)
				.addAnnotatedClass(NhanVien.class)
				.addAnnotatedClass(TheThuVien.class)
				.addAnnotatedClass(PhieuMuon.class)
				.addAnnotatedClass(ChiTietPhieuMuon.class)
				.addAnnotatedClass(ChiTietMuonPK.class)
				.addAnnotatedClass(TaiKhoan.class)
				.getMetadataBuilder().build();
		if (sessionFactory == null) {
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		SessionFactory factory= HibernateConfig.getInstance().getSessionFactory();
	}
}
