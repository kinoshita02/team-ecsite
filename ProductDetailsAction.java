package com.internousdev.neptune.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.neptune.dao.MCategoryDAO;
import com.internousdev.neptune.dao.ProductInfoDAO;
import com.internousdev.neptune.dto.MCategoryDTO;
import com.internousdev.neptune.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {

	private String productId;
	private int categoryId;
	private int status;
	private String descriptionErrorMessage;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute(){
		if(session.isEmpty()){
			return "sessionErr";
		}

		int intProductId = 0;
		try {
			intProductId = Integer.parseInt(productId);
		}catch (NumberFormatException e) {
			return ERROR;
		}

		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();

		productInfoDTO=productInfoDAO.getProductInfo(intProductId);
		session.put("id", productInfoDTO.getId());
		session.put("productId", productInfoDTO.getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productNameKana", productInfoDTO.getProductNameKana());
		session.put("categoryId", productInfoDTO.getCategoryId());
		session.put("price", productInfoDTO.getPrice());
		session.put("imageFilePath", productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());
		session.put("releaseDate", productInfoDTO.getReleaseDate());
		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("productDescription", productInfoDTO.getProductDescription());
		List<Integer> productCountList=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList",productCountList);
		if(productInfoDTO.getProductName() == null){
			status = 1;
		}else{
			status=productInfoDTO.getStatus();
		}

		if(status == 1){
			setDescriptionErrorMessage("商品の詳細情報がありません");
			return SUCCESS;
		}

		productInfoDTOList=productInfoDAO.getProductInfoListByCategory(productInfoDTO.getCategoryId(),productInfoDTO.getProductId(),0,3);
		Iterator<ProductInfoDTO> iterator=productInfoDTOList.iterator();
		if(!(iterator.hasNext())){
			productInfoDTOList=null;
		}
		if(!productInfoDTOList.isEmpty() || productCountList==null){
			session.put("productInfoDTOList", productInfoDTOList);
		}
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList",mCategoryDTOList);
		}

		return SUCCESS;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescriptionErrorMessage() {
		return descriptionErrorMessage;
	}

	public void setDescriptionErrorMessage(String descriptionErrorMessage) {
		this.descriptionErrorMessage = descriptionErrorMessage;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}
	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDTOList;
	}
	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}