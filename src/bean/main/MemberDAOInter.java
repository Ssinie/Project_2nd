package bean.main;

public interface MemberDAOInter {
	
	// select 아이디 검색 - 가입된 회원인지 확인
	public int checkId(MemberDTO dto) throws Exception;
	
	// 회원가입 - 최초 로그인 시 DB insert
	public void join(MemberDTO dto) throws Exception;
	
	// 마지막 로그인 날짜 update
	public void loginLog(MemberDTO dto) throws Exception;
	
//	// 회원탈퇴 update - status 1 --> 10
//	public void deleteInfo(MemberDTO dto) throws Exception;
}
