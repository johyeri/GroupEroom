package com.eroom.gw.calendar.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.store.CalendarStore;

@Repository
public class CalendarStoreLogic implements CalendarStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Calendar> selectAllCal(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar selectOneCal(Calendar calendar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCal(Calendar calendar) {
		return sqlSession.insert("calMapper.insertCal", calendar);
	}

	@Override
	public int updateCal(Calendar calendar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCal(int calNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
