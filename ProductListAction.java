package com.internousdev.neptune.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.neptune.dao.MCategoryDAO;
import com.internousdev.neptune.dao.ProductInfoDAO;
import com.internousdev.neptune.dto.MCategoryDTO;
import com.internousdev.neptune.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {

	private int productId;
	private int categoryId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private List<MCategoryDTO> mCategoryDTOList=new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute(){
		if(session.isEmpty()){
			return "sessionErr";
		}
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		productInfoDTOList=productInfoDAO.getProductInfoList();

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			mCategoryDTOList=mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		return SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public List<MCategoryDTO> getmCategoryDTOList() {
		return mCategoryDTOList;
	}
	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}