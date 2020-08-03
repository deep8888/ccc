package model.DTO;

import java.util.List;

public class PackageDTO {
	ClassesDTO classesDTO;
	List<ProductDTO> product;
	public ClassesDTO getClassesDTO() {
		return classesDTO;
	}
	public void setClassesDTO(ClassesDTO classesDTO) {
		this.classesDTO = classesDTO;
	}
	public List<ProductDTO> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}
	

}
