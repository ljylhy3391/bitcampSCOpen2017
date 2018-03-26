package com.bitcamp.open.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.open.member.Model.Member;

@SuppressWarnings("deprecation")
public class PageRanksView extends AbstractExcelView {
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		// 1. 시트 생성
		HSSFSheet sheet = createFirstSheet(workbook);

		// 2. 라벨 처리
		createColumnLabel(sheet);

		// 3. 각 행별 데이터 처리
		List<Member> list = (List<Member>) model.get("member");

		int rowNum = 1;

		for (Member e : list) {
			createPageRankRow(e, sheet, rowNum++);
		}

		// 파일 이름설정
		response.setHeader("Content-Disposition", "attachment; filename=\"Member.xls\";");

	}

	// 시트를 생성해주는 메서드
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		// 시트생성
		HSSFSheet sheet = workbook.createSheet();
		// 생성된 시트 이름 설정
		workbook.setSheetName(0, "페이지 순위");
		// 시트 컬럼의 사이즈 지정
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	// 시트의 첫번째 라인(행)의 셀 설정 ( 라벨 설정 )
	private void createColumnLabel(HSSFSheet sheet) {
		// 첫번재 행 생성 : sheet.createRow(0) <- 0 첫번째 행을의미
		HSSFRow firstRow = sheet.createRow(0);
		// 만들어진 행에서 첫번재 샐 생성 <- 0 은 첫번째를 의미
		HSSFCell cell = firstRow.createCell(0);
		// 만들어진 샐의 내용 설정
		cell.setCellValue("idx");
		// 두번째 샐 생성 : (1)
		cell = firstRow.createCell(1);
		// 두번째 샐의 내용 설정
		cell.setCellValue("아이디");
		// 세번째 샐의 내용 설정
		cell = firstRow.createCell(2);
		// 세번째 샐의 내용 설정
		cell.setCellValue("이름");
		// 네번째 샐의 내용 설정
		cell = firstRow.createCell(3);
		// 네번째 샐의 내용 설정
		cell.setCellValue("등록일");
	}

	// 원본데이터의 내용들을 각 행에 출력
	private void createPageRankRow(Member member,HSSFSheet sheet,  int rowNum) {

		// 매개변수 PageRank rank : 표현할 원본 데이터
		// int rowNum : 몇번째 행을 행성할지에 대한 데이터

		// rowNum 번째 행 생성
		HSSFRow row = sheet.createRow(rowNum);
		// 첫번째 샐 생성
		HSSFCell cell = row.createCell(0);
		// 샐 데이터 설정
		cell.setCellValue(member.getIdx());
		// 두번째 샐 생성
		cell = row.createCell(1);
		// 샐 데이터 설정
		cell.setCellValue(member.getMember_id());
		// 세번째 샐 생성 
		cell = row.createCell(2);
		// 샐 데이터 설정
		cell.setCellValue(member.getMember_name());
		cell = row.createCell(3);
		// 샐 데이터 설정
		cell.setCellValue(member.getRegdate());
	}

}
