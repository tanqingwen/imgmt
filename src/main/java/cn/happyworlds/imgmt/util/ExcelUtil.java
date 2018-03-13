package cn.happyworlds.imgmt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.happyworlds.imgmt.util.SysDateFormat;

public class ExcelUtil {

	/**
	 * 根据List导出xls表格
	 * 
	 * @param title
	 *            表格名
	 * @param header
	 *            表格标题
	 * @param data
	 *            表格数据
	 * @param headExtra
	 *            头部附加数据
	 * @param footExtra
	 *            尾部附加数据
	 * @param operator
	 *            操作员
	 * @return 表格文件下载地址
	 * @throws Exception
	 * 
	 * 第一行是**统计报表
	 * 开始时间，结束时间
	 * 查询列表号
	 * 统计查询信息
	 * 数量
	 * 空三行
	 * 打印日期，打印人
	 * 
	 * 标题，查询列表号，统计查询信息，开始结束时间，数量，打印人（使用者）
	 */
	public static void downList(String title, List header, List list, Map headExtra, Map footExtra, String operator,HttpServletResponse resp) throws Exception {
		
		try{
			
		} catch(Exception e){
			
		} finally{
			
		}
		
		String nowtime = SysDateFormat.getNowDate("yyyyMMddHHmm");
		String filename = "REPORT_"+ nowtime +"_"+ (int) (Math.random() * 10000) + ".xls";
		
//		resp.setContentType("application/msexcel;charset=GBK");
		resp.setHeader("Content-disposition", "attachment;filename="+filename);
		OutputStream os = resp.getOutputStream();
//		FileOutputStream os = new FileOutputStream("E://uploadReport/"+title+".xls");
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(title);
		Row rowHeader = sheet.createRow(0);
		
		int filerow=0;
		// 写入标题（报表名）
		//CellRangeAddress（开始行数，结束行数，开始列数，结束列数）0到1是两行
		int size = 1;
		if(header!=null){
			size = header.size();
		}
		CellRangeAddress cra=new CellRangeAddress(0, 1, 0, size-1);
		sheet.addMergedRegion(cra);
		Cell cell = rowHeader.createCell(0);
        cell.setCellValue(title);
        rowHeader = sheet.createRow(2);
		//标题占两行，之后的行数从2开始
        filerow=2;

		// 附加头部信息，开始结束时间，占一行
		if (headExtra != null) {
			int filecol =0;//列数
			for (Iterator iter = headExtra.entrySet().iterator(); iter.hasNext();) {
				Entry entry = (Entry) iter.next();
				if(filecol % 2==0){
					Cell cell1 = rowHeader.createCell(filecol);
			        cell1.setCellValue(entry.getKey().toString());
				}
				filecol+=1;
				Cell cell2 = rowHeader.createCell(filecol);
		        cell2.setCellValue(entry.getValue().toString());
				filecol+=1;
			}
			filerow += 1;
		}

		// 查询列表号,list存入中文
		if(header!=null){
			Row headerRow = sheet.createRow(filerow);
			int filecol =0;
			for (int h = 0; h < header.size(); h++) {
				Cell cellheader = headerRow.createCell(filecol);
		        cellheader.setCellValue(header.get(h).toString());
		        filecol++;
			}
			filerow += 1;
		}
		
		// 数据信息
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				Row listRow = sheet.createRow(filerow+i);
				for (int j = 0; j < header.size(); j++) {
					String str = (String) (((HashMap) list.get(i)).values().toArray())[j];
					Cell cellList = listRow.createCell(j);
					cellList.setCellValue(str);
				}
			}
			filerow += list.size();
		}
		
		// 附加尾部信息
		if (footExtra != null) {
			Row row = sheet.createRow(filerow);
			for (Iterator iter = footExtra.entrySet().iterator(); iter.hasNext();) {
				Entry entry = (Entry) iter.next();
				Cell cellfootExtraKey= row.createCell(0);
				cellfootExtraKey.setCellValue(entry.getKey().toString());
				Cell cellfootExtraValue= row.createCell(1);
				cellfootExtraValue.setCellValue(entry.getValue().toString());
			}
			filerow += 4;
		}

		// 附加打印信息
		Row row = sheet.createRow(filerow);
		Cell celloperatordate1= row.createCell(0);
		celloperatordate1.setCellValue("打印日期");
		String operatortime = SysDateFormat.getNowDate("MM-dd HH:mm");
		Cell celloperatordate2= row.createCell(1);
		celloperatordate2.setCellValue(operatortime);
		if (operator != null) {
			Cell celloperatorman1= row.createCell(2);
			celloperatorman1.setCellValue("打印人");
			Cell celloperatorman2= row.createCell(3);
			celloperatorman2.setCellValue(operator);
		}

		workbook.write(os);
		os.flush();
		os.close();
		workbook.close();
	}
	
	public static void downLoad(String title,String headerTitle, List header, Map<String, Map<String,String>> twocol, String onecolstr,Map<String,String> foot,String fname,HttpServletResponse resp) throws Exception {
		String nowtime = SysDateFormat.getNowDate("yyyyMMddHHmm");
		String filename = fname+"_"+ nowtime +"_"+ (int) (Math.random() * 10000) + ".xls";
		
		resp.setHeader("Content-disposition", "attachment;filename="+filename);
		OutputStream os = resp.getOutputStream();
//		FileOutputStream os = new FileOutputStream("E://uploadReport/"+title+".xls");
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(title);
		Row rowHeader = sheet.createRow(0);
		
		int filerow=0;
		CellRangeAddress titlecra=new CellRangeAddress(0, 1, 0, header.size()-1);
		sheet.addMergedRegion(titlecra);
		Cell cell = rowHeader.createCell(0);
        cell.setCellValue(headerTitle);
        rowHeader = sheet.createRow(2);
        filerow=2;

		Row headerRow = sheet.createRow(filerow);
		int headercol =0;
		for (int h = 0; h < header.size(); h++) {
			Cell cellheader = headerRow.createCell(headercol);
	        cellheader.setCellValue(header.get(h).toString());
	        headercol++;
		}
		filerow += 1;
		
		int ksrow = filerow;
		int jsrow = filerow;
		int kscol = 0;
		int jscol = 0;
		int onecolrow=0;
		Row listRow = sheet.createRow(filerow);
		Cell celllist = null;
		
		if(onecolstr!=null){
			if(twocol != null){
				for (String twokey:twocol.keySet()) {
					Map<String, String> list = twocol.get(twokey);
					onecolrow += list.size();
				}
			}else{
				onecolrow = 1;
			}
			jsrow = ksrow+onecolrow-1;
			CellRangeAddress onecra=new CellRangeAddress(ksrow, jsrow, kscol,jscol);
			sheet.addMergedRegion(onecra);
			celllist = listRow.createCell(kscol);
			celllist.setCellValue(onecolstr);
			kscol++;
			jscol++;
		}
		if(twocol != null){
			int i = filerow ;
			for (String twokey:twocol.keySet()) {
				Map<String, String> list = twocol.get(twokey);
				listRow.setRowNum(ksrow);
				int size = list.size();
				if(list.size()==0){
					size = 1;
				}
				jsrow=ksrow+size-1;
				CellRangeAddress twolistcra=new CellRangeAddress(ksrow, jsrow, kscol,jscol);
				sheet.addMergedRegion(twolistcra);
				celllist = listRow.createCell(kscol);
				celllist.setCellValue(twokey);
				for (String threeFourstr : list.keySet()) {
					listRow.setRowNum(i);
					celllist = listRow.createCell(kscol+1);
					celllist.setCellValue(threeFourstr);
					celllist = listRow.createCell(kscol+2);
					celllist.setCellValue(list.get(threeFourstr));
					i++;
				}
				ksrow+=size;
			}
			filerow += ksrow-filerow;
		}

		if (foot != null) {
			Row row = sheet.createRow(filerow);
			int footcol =0;
			for (Iterator iter = foot.entrySet().iterator(); iter.hasNext();) {
				Entry entry = (Entry) iter.next();
				if(footcol % 2==0){
					Cell cellfootExtraKey = row.createCell(footcol);
					cellfootExtraKey.setCellValue(entry.getKey().toString());
				}
				footcol+=1;
				Cell cellfootExtraValue = row.createCell(footcol);
				cellfootExtraValue.setCellValue(entry.getValue().toString());
				footcol+=1;
			}
		}

		workbook.write(os);
		os.flush();
		os.close();
	}

}
