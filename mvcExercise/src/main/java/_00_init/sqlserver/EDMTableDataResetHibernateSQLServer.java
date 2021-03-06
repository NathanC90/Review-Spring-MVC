package _00_init.sqlserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.store.model.BookBean;
import com.web.store.model.CompanyBean;
import com.web.store.model.MemberBean;

/**
 * 
 */
public class EDMTableDataResetHibernateSQLServer {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, SerialException, SQLException {
		System.out.println("Maven + Hibernate + SQLServer 新增多筆資料到JSPDB");
		Session session = HibernateUtil_SQLServer.getSessionFactory().openSession();
		Transaction tx = null;
		int count = 0;
		try (
		// Input.txt存放要新增的多筆資料
		InputStreamReader isr0 = new InputStreamReader(new FileInputStream(
				"data/Input.txt"), "UTF-8");

		BufferedReader br = new BufferedReader(isr0);)
		// 由檔案("data/Input.txt")讀入Member的資料，然後寫入資料庫
		{
			String line = "";
			while ((line = br.readLine()) != null) {
				// 未處理BOM字元，若有需要，請自行加入
				String[] sa = line.split("\\|");
				try {
					tx = session.beginTransaction();
					MemberBean member = new MemberBean();
					member.setMemberId(sa[0]);
					member.setName(sa[1]);
					member.setPassword(GlobalService.getMD5Endocing(
							GlobalService.encryptString("123"))); 
					member.setAddress(sa[3]);
					member.setEmail(sa[4]);
					member.setTel(sa[5]);
					member.setUserType(sa[6]);
					member.setTotalAmt(Double.parseDouble(sa[7]));
					member.setTs(new java.sql.Timestamp(System
							.currentTimeMillis()));
					// --------------處理Blob(圖片)欄位----------------
					// Blob sb = fileToBlob(sa[9]);
					// fileToBlob為自己編寫的方法,
					// 本程式後來改用 Hibernate 4.3 提供的標準API:
					// Hibernate.getLobCreator(session).createBlob(is, size)
					File f = new File(sa[8]);
					System.out.println(f.getAbsolutePath());
					long size = f.length();
					InputStream is = new FileInputStream(f);
					Blob sb = Hibernate.getLobCreator(session).
							createBlob(is, size);
					member.setMemberImage(sb);
					String imageFileName = sa[8].substring(sa[8]
							.lastIndexOf("/") + 1);
					member.setFileName(imageFileName);
					// --------------處理Clob欄位----------------
					// fileToClob為自己編寫的方法
					// Clob clob = fileToClob(sa[10]);
					// 本程式後來改用 Hibernate 4.3 提供的標準API:
					// Hibernate.getLobCreator(session).createBlob(reader, size)
					File f10 = new File(sa[9]);
					size = meteringReader(f10);
					Reader reader = new FileReader(f10);
					Clob clob = Hibernate.getLobCreator(session).
							createClob(reader, size);
					member.setComment(clob);
					member.setUnpaid_order_amount(0.0);
					session.save(member);
					session.flush();
					tx.commit();
					count++;
					System.out.println("新增" + count + "筆記錄:" + sa[1]);
				} catch (Exception e) {
					e.printStackTrace();
					if (tx != null) {
						tx.rollback();
					}
				} finally {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// -------------讀取BookCompany資料，寫入資料庫----------------
		// 定義儲存CompanyBean的List物件，當讀入每筆BookCompany資料後，不立即
		// 寫入資料庫而是等到讀入BookBean時，將對應的BookCompany存入BookBean，
		// 再寫入BookBean(當然同時寫入CompanyBean)
		List<CompanyBean> list = new ArrayList<>();
		try (
			// data/bookCompany.dat存放要新增的n筆資料
			InputStreamReader isr0 = new InputStreamReader(
					            new FileInputStream("data/bookCompany.dat"), "UTF-8");
			BufferedReader br = new BufferedReader(isr0);
			)
			{
				String line = "";
				while ((line = br.readLine()) != null) {
					String[] sa = line.split("\\|");
						CompanyBean bc = new CompanyBean();
						bc.setName(sa[0]);
						bc.setAddress(sa[1]);
						bc.setUrl(sa[2]);
						list.add(bc);
						count++;
						System.out.println("新增" + count + "筆記錄:" + sa[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		// ------------- 由檔案(data/book.dat)讀取Book資料，寫入資料庫-----------------------
		try (
		InputStreamReader isr0 = new InputStreamReader(new FileInputStream(
				"data/book.dat"), "UTF-8");
		BufferedReader br = new BufferedReader(isr0);)
		{
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] sa = line.split("\\|");
				try {
					tx = session.beginTransaction();
					BookBean book = new BookBean();
					book.setTitle(sa[0]);
					book.setAuthor(sa[1]);
					book.setPrice(Double.parseDouble(sa[2])); 
					book.setDiscount(Double.parseDouble(sa[3]));
				
					if (Integer.parseInt(sa[4]) <= list.size() ) {
					   book.setCompanyBean(list.get(Integer.parseInt(sa[4]) - 1 ));
					}
					Blob sb = EDMUtils.fileToBlob("data/images/smallPic/" + sa[5]);
					book.setCoverImage(sb);
					String filename = sa[5]
							.substring(sa[5].lastIndexOf("\\") + 1);
					book.setFileName(filename);
					book.setBookNo(sa[6]);
					// --------------處理Blob(圖片)欄位----------------
					int stock = 0;
					try {
						stock = Integer.parseInt(sa[7]);
					} catch(NumberFormatException e){
						e.printStackTrace();
					}
					book.setStock(stock);
					book.setCategory(sa[8]);
					session.save(book);
					tx.commit();
					count++;
					System.out.println("新增" + count + "筆記錄:" + sa[1]);
				} catch (Exception e) {
					e.printStackTrace();
					if (tx != null) {
						tx.rollback();
					}
				} finally {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (session != null) {
			session.close();
		}
		HibernateUtil_SQLServer.close();
	}

	// 計算一個文字檔的字元數
	private static long meteringReader(File f10) {
		long total = 0;
		int len = 0;
		try (FileReader reader = new FileReader(f10);) {
			char[] ca = new char[8192];
			while ((len = reader.read(ca)) != -1) {
				total += len;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return total;
	}
}
