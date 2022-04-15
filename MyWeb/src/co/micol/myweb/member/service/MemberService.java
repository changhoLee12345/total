package co.micol.myweb.member.service;

import java.util.List;

import co.micol.myweb.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	boolean idCheck(String id);
}
