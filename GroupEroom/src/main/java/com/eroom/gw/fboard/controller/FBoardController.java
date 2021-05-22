package com.eroom.gw.fboard.controller;

import java.util.ArrayList;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
import com.eroom.gw.fboard.service.FBoardService;
import com.eroom.gw.member.domain.Member;

@Controller
public class FBoardController {
	
	@Autowired
	private FBoardService fService;
	
//게시글리스트 조회
	@RequestMapping(value="fBoardListView.do")
	public ModelAndView fBoardListView(ModelAndView mv,
									@RequestParam(value="page", required=false) Integer page) {	
		int currentPage = (page != null) ? page : 1;
		int listCount = fService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage,  listCount);
		
		ArrayList<Freeboard> fList = fService.printAll(pi);
		if(!fList.isEmpty()) {
			mv.addObject("fList", fList);
			mv.addObject("pi", pi);
			mv.setViewName("fBoard/fBoardListView");
		}else {
			System.out.println("실패");
			mv.addObject("msg", "리스트 불러오기 실패");
			mv.setViewName("fBoard/errorPage");
		}
		return mv;
	}
	
//게시글 상세조회
	@RequestMapping(value="fBoardDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView fBoardDetail(ModelAndView mv,
									@RequestParam("fBoardNo") int fBoardNo) {
		//조회수 증가
		fService.addHits(fBoardNo);
		
		//상세조회 불러오기
		Freeboard fBoard = fService.printOne(fBoardNo);
		if(fBoard != null) {
			mv.addObject("fBoard", fBoard).setViewName("fBoard/fBoardDetailView");
		}else {
			mv.addObject("msg", "게시글 상세 조회 실패");
			mv.setViewName("fBoard/errorPage");
		}
		return mv;
	}
	
//게시글 등록화면단
	@RequestMapping(value="fBoardWriteView.do")
	public String fBoardWriteView() {
		return "fBoard/fBoardWriteForm";
	}
	
//게시글 등록
	@RequestMapping(value="fBoardRegister.do", method=RequestMethod.POST)
	public ModelAndView fBoardRegister(ModelAndView mv,
									@ModelAttribute Freeboard fBoard, @ModelAttribute FreeboardFile fBoardFile,
									@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, 
									MultipartHttpServletRequest request, HttpSession session) {
//		if(!uploadFile.getOriginalFilename().equals("")) {
//			Map renameFileName = saveFile(uploadFile, request);
//			if(renameFileName != null) {
//				fBoardFile.setOriginalFilename(uploadFile.getOriginalFilename());
//				fBoardFile.setRenameFilename(renameFileName);
//			}
//		}
		Member loginUser = (Member)session.getAttribute("loginUser");
		fBoard.setMemberId(loginUser.getMemberId());
		
		int result = 0;
		String path = "";
		result = fService.registerFBoard(fBoard);
		if(result > 0) {
			path = "redirect:fBoardListView.do";
		}else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

//파일첨부
	@RequestMapping(value="multipartUpload.do", method = RequestMethod.POST)
	public Map<String, Object> saveFile (MultipartFile file, MultipartHttpServletRequest request) {
		
		return null;
	}
	
//게시글 수정화면단
	@RequestMapping(value="fBoardModifyView.do")
	public ModelAndView fBoardModifyView(ModelAndView mv, @RequestParam("fBoardNo") int fBoardNo) {
		return mv;
	}
	
//게시글 수정
	@RequestMapping(value="fBoardUpdate.do", method=RequestMethod.POST)
	public ModelAndView fBoardUpdate(ModelAndView mv, HttpServletRequest request,
									@ModelAttribute Freeboard fBoard, @ModelAttribute FreeboardFile fBoardFile,
									@RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		return mv;
	}
	
//게시글 삭제
	@RequestMapping(value="fBoardDelete.do")
	public String fBoardDelete(Model model, @RequestParam("fBoardNo") int fBoardNo,
								@RequestParam("renameFilename") String renameFileName,
								HttpServletRequest request) {
		return "";
	}
	
//파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
//댓글리스트
	@RequestMapping(value="fbCmtList.do")
	public void getFBoardCmtList(HttpServletResponse response, @RequestParam("fBoardNo") int fBoardNo) {
		
	}
	
//댓글등록
	@RequestMapping(value="fbCmtAdd.do", method=RequestMethod.POST)
	public String addFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt, HttpSession session) {
		return "";
	}
	
//댓글수정
	@ResponseBody
	@RequestMapping(value="fbCmtModify.do", method=RequestMethod.POST)
	public String modifyFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
		return null;
	}
	
//댓글삭제
	@ResponseBody
	@RequestMapping(value="fbCmtDelete.do", method=RequestMethod.POST)
	public String removeFBoardCmt(@ModelAttribute FreeboardCmt fBoardCmt) {
	return "";
	}
	
	
	
	
}
