package com.eroom.gw.approval.store;

import java.awt.List;
import java.util.ArrayList;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.common.PageInfo;

public interface ApprovalStore {

	/**
	 * 게시물 등록
	 * @param approval
	 * @return
	 */
	public int insertApproval(Approval approval);
	
	/**
	 * 게시물 전체 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Approval> selectAllList(PageInfo pi);
	
	/**
	 * 게시물 상세 조회
	 * @param approvalNo
	 * @return
	 */
	public Approval selectOne(int approvalNo);
	
	/**
	 * 게시물 삭제
	 * @param approvalNo
	 * @return
	 */
	public int deleteApproval(int approvalNo);
	
	/**
	 * 게시물 상태 변경 
	 * @param approval
	 * @return
	 */
	public int updateState(Approval approval);
	
	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return
	 */
	public int insertReply(ApprovalReply reply);
	
	/**
	 * 댓글 전체 조회
	 * @param approvalNo
	 * @return
	 */
	public ArrayList<ApprovalReply> selectAllList(int approvalNo);
	
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public int updateReply(ApprovalReply reply);
	
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public int deleteReply(ApprovalReply reply);
	
}