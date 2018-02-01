package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.GuestbookVo;


@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> getList() {
		
		List<GuestbookVo> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	public void insert(GuestbookVo guestbookVo) {
		
		sqlSession.insert("guestbook.insert", guestbookVo);
		
	}
	public void delete(@RequestParam("no")int no,
					   @RequestParam("password") String password) {
		sqlSession.delete("guestbook.delete", no);
		
	}
	
}

