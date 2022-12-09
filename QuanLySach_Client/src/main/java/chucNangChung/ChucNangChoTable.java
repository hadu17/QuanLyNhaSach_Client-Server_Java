package chucNangChung;

import javax.swing.table.DefaultTableModel;

public class ChucNangChoTable {
	
	/**
	 * Xóa dòng cho table
	 * @param model
	 */
	public static void XoaDongTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}
	/**
	 * Chức năng giúp thêm vào những hàng rỗng cho đẹp bảng
	 * 
	 * @param model
	 */
	public static void addNullDataTable(DefaultTableModel model) {
		for (int i = 0; i < 30; i++) {
			model.addRow(new Object[] { null, null, null, null, null, null, null });
		}
	}

}
