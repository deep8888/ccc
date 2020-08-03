package model.DTO;

import java.util.List;

public class ClassesListPackageDTO {
	ClassesDTO classesDTO;
	List<ClassesListDTO> classesList;
	public ClassesDTO getClassesDTO() {
		return classesDTO;
	}
	public void setClassesDTO(ClassesDTO classesDTO) {
		this.classesDTO = classesDTO;
	}
	public List<ClassesListDTO> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<ClassesListDTO> classesList) {
		this.classesList = classesList;
	}
	
	

}
