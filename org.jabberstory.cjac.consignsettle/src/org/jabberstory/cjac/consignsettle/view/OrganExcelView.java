package org.jabberstory.cjac.consignsettle.view;

import java.io.BufferedOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class OrganExcelView extends AbstractExcelView{

	@SuppressWarnings({ "unchecked" })
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Type", "application/unknown;charset=UTF-8");		
		response.setHeader("Content-Disposition","attachment; filename="+ this.getFileName());
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		List organs = (List<Organ>)model.get("organs");
		
		HSSFSheet sheet = this.createSheet(workbook);
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
		
		int rowNum = 1;
		for(int i=0; i<organs.size(); i++){
			Organ organ = (Organ)organs.get(i);
			rowNum = addOrganRow(sheet, cellStyle, rowNum, organ);
		}	

		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		workbook.write(out);
		out.flush();
		out.close();
		
	}
	
	@SuppressWarnings("deprecation")
	private int addOrganRow(HSSFSheet sheet, HSSFCellStyle cellStyle, int rowNum, Organ organ){
		HSSFRow row = sheet.createRow(rowNum++);
		
		row.createCell((short)0).setCellValue(organ.getBusinessName());
		row.createCell((short)1).setCellValue(organ.getProjectName());
		row.createCell((short)2).setCellValue(organ.getResearchAgency());
		row.createCell((short)3).setCellValue(organ.getResearchResponsiblePerson());
		row.createCell((short)4).setCellValue(organ.getContractStartDate());
		row.createCell((short)5).setCellValue(organ.getContractEndDate());
		row.createCell((short)6).setCellValue(organ.getUseResultDate());
		row.createCell((short)7).setCellValue(organ.getFormalObjectAcceptanceDate());
		row.createCell((short)8).setCellValue(organ.getFormalObjectResultDate());
		row.createCell((short)9).setCellValue(organ.getConsignSettlementResultDate());
		row.createCell((short)10).setCellValue("-");
		row.createCell((short)11).setCellValue(organ.getGovContributeAmount());
		row.createCell((short)12).setCellValue("-");
		row.createCell((short)13).setCellValue(organ.getGoodsAmount());
		row.createCell((short)14).setCellValue("-");
		row.createCell((short)15).setCellValue(organ.getTotalCashAmount());
		row.createCell((short)16).setCellValue(organ.getGovInterests());
		row.createCell((short)17).setCellValue(organ.getConsignSettlementCommission());
		row.createCell((short)18).setCellValue(organ.getCurrentAccount());
		row.createCell((short)19).setCellValue(organ.getCurrentInterest());
		row.createCell((short)20).setCellValue(organ.getCurrentNonPropriety());
		row.createCell((short)21).setCellValue(organ.getCurrentSubTotal());
		row.createCell((short)22).setCellValue(organ.getCurrentRedemtion());
		row.createCell((short)23).setCellValue("-");
		row.createCell((short)24).setCellValue(organ.getConsignSettlementPerson());
		row.createCell((short)25).setCellValue("-");
		
		return rowNum;
	}
	
	@SuppressWarnings({ "deprecation" })
	private HSSFSheet createSheet(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.createSheet("정산현황");
		
		HSSFRow header = sheet.createRow(0);
		header.createCell((short)0).setCellValue("사업명");
		header.createCell((short)1).setCellValue("과제명");
		header.createCell((short)2).setCellValue("연구기관명");
		header.createCell((short)3).setCellValue("연구책임자");
		header.createCell((short)4).setCellValue("당해년도협약기간(시작일)");
		header.createCell((short)5).setCellValue("당해년도협약기간(종료일)");
		header.createCell((short)6).setCellValue("사용실적제출일");
		header.createCell((short)7).setCellValue("이의신청접수일");
		header.createCell((short)8).setCellValue("결과통보일");
		header.createCell((short)9).setCellValue("정산결과보고일");
		header.createCell((short)10).setCellValue("총연구개발비");
		header.createCell((short)11).setCellValue("정부출연금");
		header.createCell((short)12).setCellValue("기업부담금(현금)");
		header.createCell((short)13).setCellValue("기업부담금(현물)");
		header.createCell((short)14).setCellValue("기업부담금(소계)");
		header.createCell((short)15).setCellValue("총현금");
		header.createCell((short)16).setCellValue("정부지분");
		header.createCell((short)17).setCellValue("위탁정산수수료");
		header.createCell((short)18).setCellValue("총환수대상액(사용잔액)");
		header.createCell((short)19).setCellValue("총환수대상액(발생이자)");
		header.createCell((short)20).setCellValue("총환수대상액(부적정집행액)");
		header.createCell((short)21).setCellValue("총환수대상액(소계)");
		header.createCell((short)22).setCellValue("총환수대상액(환수대상액)");
		header.createCell((short)23).setCellValue("검토의견(부적정집행내역)");
		header.createCell((short)24).setCellValue("정산담당자");
		header.createCell((short)25).setCellValue("비고");
		
		return sheet;
	}
	
	private String getFileName(){
		Calendar cal = Calendar.getInstance( );
	    String s = String.format("%04d-%02d-%02d%02d:%02d:%02d",
	                                 cal.get(Calendar.YEAR),
	                                 (cal.get(Calendar.MONTH) + 1),
	                                 cal.get(Calendar.DAY_OF_MONTH),
	                                 cal.get(Calendar.HOUR_OF_DAY),
	                                 cal.get(Calendar.MINUTE),
	                                 cal.get(Calendar.SECOND)
	                             );
		
		return "cjac" + s + ".xls";
	}
}
