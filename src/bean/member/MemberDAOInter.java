package bean.member;

public interface MemberDAOInter {
	
	// select 아이디 검색 기존 회원인지 확인
	public int checkId(MemberDTO dto) throws Exception;
	
	// 회원정보 insert
	public void insert(MemberDTO dto) throws Exception;
	
	

}
