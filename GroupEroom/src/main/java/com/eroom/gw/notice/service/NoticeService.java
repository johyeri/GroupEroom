package com.eroom.gw.notice.service;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.notice.domain.Notice;

public interface NoticeService {

	public int getListCount();
	public ArrayList<Notice> printAll(PageInfo pi);
	public int addReadCount(int noticeNo); // 조회수증가
	public Notice printOne(int noticeNo); // 상세조회
	public int registerNotice(Notice notice); //등록
	public int modifyNotice(Notice notice); // 수정
	public int removeNotice(int noticeNo); //삭제
	
	
	
	
}
