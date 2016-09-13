package com.xtu.graduation.teacher.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtu.graduation.department.entity.Department;
import com.xtu.graduation.department.service.IDepartmentService;
import com.xtu.graduation.subject.entity.SubjectResult;
import com.xtu.graduation.subject.service.ISubjectResultService;
import com.xtu.graduation.teacher.entity.Teacher;

@RequestMapping("/teacherDownload")
@Controller
public class TeacherDownloadExcel {
	
	@Autowired
	private ISubjectResultService subjectResultsService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	
	@ResponseBody
	@RequestMapping("/downLoadAll")
	public void downloadAllExcel(HttpSession httpSession,HttpServletResponse response){
		//获取需要导出的数据
		List<SubjectResult> subjectResults = this.subjectResultsService.findAllSubjectResult();
		//可以捕获内存缓冲区的数据，转换成字节数组
		ByteArrayOutputStream ops = new ByteArrayOutputStream();
		try {
			//生成设置文件名称
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String fileName = new String(("全校选题结果_" + df.format( new Date() )).getBytes(),"ISO-8859-1"); 
			//将生成的excel的对象写入到输出流中，并将其转换为字节数组
			this.writeExcel(ops, subjectResults, "全校选题结果");
			byte[] content = ops.toByteArray();
			InputStream is = new ByteArrayInputStream(content); 
			//设置返回值
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" +(fileName+".xls"));
			byte[] buff = new byte[2048];
			int bytesRead;
			// 将数据保存到response的输出流中
			while (-1 != (bytesRead = is.read(buff, 0, buff.length))) {
				response.getOutputStream().write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("/downLoadMyself")
	public void downLoadMyself(HttpSession httpSession,HttpServletResponse response){
		//获取需要导出的数据
		Teacher teacher = (Teacher) httpSession.getAttribute("user");
		List<SubjectResult> subjectResults = this.subjectResultsService.findAllSubjectResultByTeacherId(teacher.getTeacherId());
		//可以捕获内存缓冲区的数据，转换成字节数组
		ByteArrayOutputStream ops = new ByteArrayOutputStream();
		try {
			//设置下载文件名
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String fileName = new String(("我的选题结果_" + df.format( new Date() )).getBytes(),"ISO-8859-1"); 
			//将生成的excel的对象写入到输出流中，并将其转换为字节数组
			this.writeExcel(ops, subjectResults, "我的选题结果");
			byte[] content = ops.toByteArray();
			InputStream is = new ByteArrayInputStream(content); 
			//设置返回值
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + (fileName + ".xls"));
			byte[] buff = new byte[2048];
			int bytesRead;
			// 将数据保存到response的输出流中
			while (-1 != (bytesRead = is.read(buff, 0, buff.length))) {
				response.getOutputStream().write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("/downLoadDepartment")
	public void downLoadDepartment(HttpSession httpSession,HttpServletResponse response){
		//获取需要导出的数据
		Teacher teacher = (Teacher) httpSession.getAttribute("user");
		Department department = this.departmentService.findDepartmentById(teacher.getDepartmentId());
		List<SubjectResult> subjectResults = this.subjectResultsService.findAllSubjectResultByDepartment(teacher.getDepartmentId());
		//可以捕获内存缓冲区的数据，转换成字节数组
		ByteArrayOutputStream ops = new ByteArrayOutputStream();
		try {
			//设置下载文件名
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String fileName = new String(( department.getDepartmentName()+"选题结果_" + df.format( new Date() )).getBytes(),"ISO-8859-1"); 
			//将生成的excel的对象写入到输出流中，并将其转换为字节数组
			this.writeExcel(ops, subjectResults, "全校选题结果");
			byte[] content = ops.toByteArray();
			InputStream is = new ByteArrayInputStream(content); 
			//设置返回值
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + (fileName + ".xls"));
			byte[] buff = new byte[2048];
			int bytesRead;
			// 将数据保存到response的输出流中
			while (-1 != (bytesRead = is.read(buff, 0, buff.length))) {
				response.getOutputStream().write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeExcel(ByteArrayOutputStream ops, List<SubjectResult> subjectResults,String sheetTitle) throws IOException {
		// 创建excel对象
		@SuppressWarnings("resource")
        Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet(sheetTitle	);
		Row row = null;
		Cell cell = null;
		String[] headers = { "课题id","课题名称", "教师姓名", "教师工号", "学生姓名","学生学号 ","课题方向","课题难度","课题类型","院系名称"};
		// 创建表头
		row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		int k = 1;
		// 填充内容
		for (SubjectResult subjectResult : subjectResults) {
			row = sheet.createRow(k);
			cell = row.createCell(0);
			cell.setCellValue(subjectResult.getGraduationSubjectId());
			cell = row.createCell(1);
			cell.setCellValue(subjectResult.getSubjectName());
			cell = row.createCell(2);
			cell.setCellValue(subjectResult.getTeacherName());
			cell = row.createCell(3);
			cell.setCellValue(subjectResult.getTeacherSno());
			cell = row.createCell(4);
			cell.setCellValue(subjectResult.getStudentName());
			cell = row.createCell(5);
			cell.setCellValue(subjectResult.getStudentSno());
			cell = row.createCell(6);
			cell.setCellValue(subjectResult.getSubjectOrientation());
			cell = row.createCell(7);
			cell.setCellValue(subjectResult.getLevel());
			cell = row.createCell(8);
			cell.setCellValue(subjectResult.getSubjectType());
			cell = row.createCell(9);
			cell.setCellValue(subjectResult.getDepartName());
			k++;
		}
		wb.write(ops);
	}
	
}
