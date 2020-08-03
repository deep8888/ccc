package controller.creatorCenter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.creative.DemandCkAction;

public class CreatorCenterController extends HttpServlet implements Servlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI =  request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		String path;
		
		if(command.equals("/cen/classCreateExit.cen")) {
			// 나가기 버튼 클릭시 크리에이터 메인으로 이동
			path = "/creatorCenter/main/creatorMain.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
			
		}else if(command.equals("/cen/classNewCreate.cen")) {
			// 새로 만들기 버튼, CCC메인에서 처음 크리에이터 센터 이동시 클래스 1개 생성
			
			ClassNewCreate action = new ClassNewCreate();
			action.excute(request);
			response.sendRedirect("sessionReset.cen");
			
		}else if(command.equals("/cen/classWritePro.cen")) {
			// 클래스 작성 중 저장하기 버튼 클릭시 저장처리
			ClassWritePro action = new ClassWritePro();
			action.excute(request);
			response.sendRedirect("classSelect.cen");
			
		}else if(command.equals("/cen/classAddURL.cen")) {
			// 클래스 등록화면 저장시 저장처리
			ClassAddURL action = new ClassAddURL();
			action.excute(request);
			response.sendRedirect("classListSelect.cen");
			
		}else if(command.equals("/cen/classSelect.cen")) {
			// 업데이트 이후 대상 조회
			ClassSelect action = new ClassSelect();
			action.excute(request);
			response.sendRedirect("classListSelect.cen");
			
		}else if(command.equals("/cen/classListSelect.cen")) {
			// CLASSES_LIST 조회
			ClassListSelect action = new ClassListSelect();
			action.excute(request);
			response.sendRedirect("creatorInfoSelect.cen");
			
		}else if(command.equals("/cen/classCreatorWrite.cen")) {
			// 크리에이터 소개 저장시 처리 컨트롤러
			CreatorWriteSave action = new CreatorWriteSave();
			action.excute(request);
			response.sendRedirect("creatorInfoSelect.cen");
		}else if(command.equals("/cen/creatorInfoSelect.cen")) {
			CreatorInfoSelect action = new CreatorInfoSelect();
			action.excute(request);
			path = "/creatorCenter/main/classCreateMain.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
		}else if(command.equals("/cen/openChekResult.cen")) {
			OpenChekResult action = new OpenChekResult();
			action.excute(request);
			
			path = "/creatorCenter/main/classCreateMain.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
		}else if(command.equals("/cen/myClass.cen")) {
			path="/creatorCenter/menu/myClass.jsp";
			classesSelectionAction action=new classesSelectionAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/cen/myClassDel.cen")) {
			ClassesDelAction action=new ClassesDelAction();
			action.execute(request);
			response.sendRedirect("classCreateExit.cen");
			
		}else if(command.equals("/cen/sessionReset.cen")) {
			// 새로운 클래스 생성시 세션 초기화
			SessionResetAction action = new SessionResetAction();
			try {
				action.excute(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			path = "/creatorCenter/main/classCreateMain.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
		}
		
		else if (command.equals("/cen/CreateBoard.cen")) { // 공지사항
			BoardCreateSelect action = new BoardCreateSelect();
			action.execute(request);
			path = "/creatorCenter/menu/board.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
		} else if (command.equals("/cen/CreateBoardList.cen")) { // 공지사항
			BoardCreateSelect action = new BoardCreateSelect();
			action.execute(request);
			path = "/creatorCenter/main/board_creator_list.jsp";
			RequestDispatcher dispacher = request.getRequestDispatcher(path);
			dispacher.forward(request, response);
		} else if (command.equals("/cen/boardCreateWrite.cen")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/creatorCenter/menu/board_create_write.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/cen/boardCreateWritePro.cen")) {
			BoardCreateWriteProAction action = new BoardCreateWriteProAction();
			action.execute(request);
			response.sendRedirect("CreateBoardList.cen");
		} else if (command.equals("/cen/CreateboardView.cen")) { //뷰
			path = "/creatorCenter/menu/board_create_view.jsp";
			BoardCreateDetailAction action = new BoardCreateDetailAction();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/cen/boardCreateModify.cen")) {
			BoardCreateDetailAction action = new BoardCreateDetailAction();
			action.execute(request);
			path = "/creatorCenter/menu/board_create_modify.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/cen/boardCreateModifyPro.cen")) {
			BoardCreateModifyAction action = new BoardCreateModifyAction();
			action.execute(request);
			response.sendRedirect("CreateboardView.cen?num=" + request.getParameter("boardNum"));
		} else if (command.equals("/cen/boardCreateDelete.cen")) {
			path = "/creatorCenter/menu/board_create_delete.jsp";
			request.setAttribute("boardNum", request.getParameter("num"));
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (command.equals("/cen/boardCreateDeletePro.cen")) {
			BoardCreateDeleteAction action = new BoardCreateDeleteAction();
			action.execute(request);
			response.sendRedirect("CreateBoardList.cen");
		} else if (command.equals("/cen/optionck.cen")) { // 공지 옵션 변경
			BoardOptionAction action = new BoardOptionAction();
			action.execute(request);
			response.sendRedirect("CreateBoardList.cen");
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
