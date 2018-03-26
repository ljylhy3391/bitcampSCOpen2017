package com.bitcamp.open.member.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bitcamp.open.member.model.Member;

@SuppressWarnings("deprecation")
public class MemberListXlsView extends AbstractExcelView
{
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		// 컨트롤러에서 전송한 memberList를 받아옴
		List<Member> memberList = (List<Member>) model.get("memberList");
		int rowNum = 1;
		for (Member member : memberList) {
			createMemberListRow(sheet, member, rowNum++);
		}

		String fileName = "memberList.xls";
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook)
	{
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "회원 리스트");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}
	
	private void createColumnLabel(HSSFSheet sheet)
	{
		HSSFRow firstRow = sheet.createRow(0);
		
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("회원번호");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("이름");
		
		cell = firstRow.createCell(2);
		cell.setCellValue("아이디");

		
		cell = firstRow.createCell(3);
		cell.setCellValue("가입일");
	}
	
	private void createMemberListRow(HSSFSheet sheet, Member member, int rowNum)
	{
		HSSFRow row = sheet.createRow(rowNum);
		
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(member.getIdx());
		
		cell = row.createCell(1);
		cell.setCellValue(member.getMember_name());
		
		cell = row.createCell(2);
		cell.setCellValue(member.getMember_id());
		
		cell = row.createCell(3);
		cell.setCellValue(member.getMember_date());
	}
}
