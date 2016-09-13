package com.xtu.graduation.student.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xtu.graduation.student.entity.Student;
import com.xtu.graduation.subject.entity.GraduationSubject;
import com.xtu.graduation.subject.entity.SubjectResult;

@Transactional
public interface IStudentService {
	
	public void addStudent(Student stu);
	public void updateStudent(Student stu);
	public void deleteStudent(Student stu);
	/**
	 * 通过id删除学生信息
	 * @param id
	 */
	public void deleteStudentById(Long id);
	/**
	 * 通过学号sno删除学生信息
	 * @param sno
	 */
	public void deleteStudentBySno(String sno);
	/**
	 * 通过id查找学生信息
	 * @param id
	 * @return
	 */
	public Student findStudentById(Long id);
	/**
	 * 通过学号查找学生
	 * @param sno
	 * @return
	 */
	public Student findStudentBySno(String sno);
	/**
	 * 通过姓名查找学生
	 * @param name
	 * @return
	 */
	public List<Student> findStudentByName(String name);
	
	/**
	 * 通过所属院系名称查找学生
	 * @param name
	 * @return
	 */
	public List<Student> findStudentByDepartmentName(String departmentName);
	
	/**
	 * 通过院系id查询毕业设计题目
	 * @param departmentId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByDepartmentId(Long departmentId);
	
	/**
	 * 通过院系id查询毕业设计题目
	 * @param departmentId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByDepartmentIdNotConfirm(Long departmentId);
	
	/**
	 * 通过学生id查询所有该学生已经选择了的课题
	 * @param studentId
	 * @return
	 */
	public List<GraduationSubject> findGraduationSubjectByStudentId(Long studentId);
	
	/**
	 * 选择课题： 1.根据传入的graduationSubjectId找到对应的课题 
	 * 		   2.根据studentId找到对应的学生
	 *         3.将相应的信息保存到SubjectIdeal表中
	 *         4.student表中 presentIdealNum 字段值 +1
	 * @param graduationSubjectId
	 * @param studentId
	 */
	public String chooseGraduationSubject(Long graduationSubjectId,Long studentId);
	
	/**
	 * 删除选题操作:	1.根据传入的graduationSubjectId找到对应的课题 
	 * 				2.根据studentId找到对应的学生
	 * 				3.根据studentId和graduationSubjectId找到对应的选题志愿
	 * 				4.查看该志愿是否是isConfirm的(true代表已经被处理，false代表没有,若被选中，则无法删除选题，若没有被选中，则可以删除选题)
	 * 				5.删除改志愿
	 * 				6.将该学生的当前志愿数-1
	 * 				7.将该选题的当前选题人数-1
	 * 				8.发送邮件通知教师
	 * @param graduationSubjectId
	 * @param studentId
	 * @return
	 */
	public String deleteSubjectDeal(Long graduationSubjectId,Long studentId);
	
	/**
	 * 根据传参搜索选题，并剔除学生已经选择了或选择过的选题
	 * @param subjectName
	 * @param teacherName
	 * @param subjectOrientation
	 * @param level
	 * @param subjectType
	 * @param departmentId
	 * @return
	 */
	public List<GraduationSubject> searchSubjct(String subjectName,String teacherName,
			String subjectOrientation,String level,String subjectType,Long departmentId,Long studentId);
	
	/**
	 * 根据学生id查询学生的选题结果
	 * @param studentId
	 * @return
	 */
	public SubjectResult findSubjectResultByStudentId(Long studentId);
}
