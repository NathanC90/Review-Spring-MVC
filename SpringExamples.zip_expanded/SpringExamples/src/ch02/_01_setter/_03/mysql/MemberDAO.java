package ch02._01_setter._03.mysql;
import java.util.List;
public interface MemberDAO {
	   /** 
	    *  新增一筆記錄
	    */
	   public Integer save(Member member);
	   
	   /** 
	    *  依主鍵讀取一筆記錄
	    */
	   public Member get(Integer pk);
	   
	   /** 
	    * 讀取多筆記錄
	    */
	   public List<Member> getAll();

	   /** 
	    *  依主鍵刪除一筆記錄
	    */
	   public Integer delete(Integer pk);
	   
	   /** 
	    *  依主鍵更新一筆記錄
	    */
	   public Integer update(Member member);
	
}
