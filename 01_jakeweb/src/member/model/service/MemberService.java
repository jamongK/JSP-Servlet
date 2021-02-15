package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

/**
 * 업무 로직 담당.
 * 
 * Connection 객체 생성
 * Dao에 업무로직 하달
 * 트랜잭션 처리 (commit, rollback)
 * 자원반납 (close)
 *
 */
public class MemberService {
	private MemberDao memberDao = new MemberDao();

	public Member selectOne(String memberId) {
		// 1. Connection 객체 생성
		Connection conn = getConnection();
		
		// 2. DAO 요청
		Member member = memberDao.selectOne(conn, memberId);
		
		// 3. 트랜잭션 관리(DML만)
		// 4. 자원반납
		close(conn);
		
		return member;
	}

}
