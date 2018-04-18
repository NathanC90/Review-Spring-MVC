package ch05.ex09.model;

import java.util.Collection;

public interface MemberDAO {

	public int saveMember(Member mem);
	public Member getMember(int id);
	public Member loadMember(int id);
	public boolean idExists(String id);
	public int updateMember(Member mem);
	public int deleteMember(String pk) ;
	public Collection<Member> getAllMembers();
}
