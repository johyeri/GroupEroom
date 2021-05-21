package com.eroom.gw.cboard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.cboard.service.CBoardService;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.common.Search;

@Controller
public class CBoardController {
	
	@Autowired
	
	private CBoardService service;
	
	
	//전체 조회:)
	@RequestMapping(value="cBoardListView.do", method=RequestMethod.GET)
	public ModelAndView boardListView(ModelAndView mv
											, @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page !=null) ? page : 1;
		int listCount = service.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<CBoard> list = service.printAll(pi);
		if(!list.isEmpty()) {
			mv.addObject("cBoardList",list);
			mv.addObject("pi", pi);
			mv.setViewName("cBoard/cBoardListView");
		}else {
			mv.addObject("msg", "게시글 전체조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//검색 :)
	@RequestMapping(value="cBoardSearch.do")
	public String boardSearch(@ModelAttribute Search search, Model model,@RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page !=null) ? page : 1;
		int listCount = service.getSearchListCount(search);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<CBoard> searchList = service.printSearchAll(search,pi);
		if(!searchList.isEmpty()) {
			model.addAttribute("cBoardList",searchList);
			model.addAttribute("pi", pi);
			model.addAttribute("search",search);
			return "cBoard/cBoardSearchListView";
		}else {
			model.addAttribute("msg", "검색 실패");
			return "common/errorPage";
		}
	}
	
	//작성폼
	@RequestMapping(value="boardWriteView.kh", method=RequestMethod.GET)
	public String boardWriteView() {
		return "";
	}
	
	// 게시글 등록
	@RequestMapping(value="boardRegister.kh", method=RequestMethod.POST)
	public ModelAndView boardRegister(ModelAndView mv, 
			@ModelAttribute CBoard cBoard, 
			@RequestParam(value="uploadFile", required=false)MultipartFile uploadFile, 
			HttpServletRequest request) {
		
		
		return mv ;
		
	}

	private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\buploadFiles";
		
		
		// 저장 폴더 설정
		File folder = new File(savePath);
		// 폴더 없으면 자동 생성
		if(!folder. exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = uploadFile.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + 
											originalFileName.substring(originalFileName.lastIndexOf(".")+1); //거꾸로 위치,=>확장자명
		String filePath = folder + "\\" + renameFileName;
		// 파일저장
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//리턴
		return renameFileName;
	}
	
	//게시글 상세 :)
	@RequestMapping(value="cBoardDetail.do", method=RequestMethod.GET)
	public ModelAndView boardDetailView(ModelAndView mv,@RequestParam("cBoardNo")int cBoardNo) {
		CBoard cBoard = service.printOne(cBoardNo);
		if(cBoard !=null) {
			service.addReadCount(cBoardNo);
			mv.addObject("cBoard",cBoard);
			mv.setViewName("cBoard/cBoardDetailView");
		}else {
			mv.addObject("msg", "상세조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 게시글 수정페이지 이동
	@RequestMapping(value="boardModifyView.kh", method=RequestMethod.GET)
	public String boardModifyView(@RequestParam("boardNo")int boardNo, Model model) {
		return null;
		
	}
	
	@RequestMapping(value="boardUpdate.kh", method=RequestMethod.POST)
	public ModelAndView boardModify(ModelAndView mv,
									HttpServletRequest request,
									@ModelAttribute CBoard cBoard,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {

		return mv;
		
	}
//	public ModelAndView boardModifyView(@RequestParam("boardNo")int boardNo, ModelAndView mv) {
//		Board board = bService.printOne(boardNo);
//		if(board !=null) {
//			mv.addObject("board",board).setViewName("board/boardUpdateView");
//		}else {
//			
//		}
//		return mv;
//	}
	
	//게시글 삭제
	@RequestMapping(value="boardDelete.kh", method=RequestMethod.GET)
	public String boardDelete(Model model, 
					@RequestParam("boardNo") int boardNo,
					@RequestParam("renameFileName") String fileName,
					HttpServletRequest request) {
		
		//업로드된 파일 삭제
		if(fileName != null) {
			deleteFile(fileName, request);
		}	
		
		int result = service.removeBoard(boardNo);
		if(result>0) {
			return "redirect:boardList.kh";
		}else {
			model.addAttribute("msg","삭제실패");
			return "common/errorPgae";			
		}
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\buploadFiles";
		File file = new File(savePath + "\\" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
	
	@ResponseBody //스트링 보낼때만 사용
	@RequestMapping(value="addReply.kh", method=RequestMethod.POST)
	public String addCmt(@ModelAttribute CBoardCmt cmt, HttpSession session) {
		return null;
	}
	
	//댓글목록
	@RequestMapping(value="replyList.kh", method=RequestMethod.GET)
	public void getCmtList(HttpServletResponse response, @RequestParam("boardNo") int boardNo) throws Exception {

	}
	
	// 댓글 삭제
	@ResponseBody //성공,실패 얘네 스트링이자너 
	@RequestMapping(value="deleteReply.kh", method=RequestMethod.GET)
	public String removeCmt(@ModelAttribute CBoardCmt cmt, Model model) {
		return null;
		
		
	}
	

}
