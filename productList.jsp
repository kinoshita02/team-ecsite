<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" >
  <jsp:param name="title" value="商品一覧画面" />
</jsp:include>
      <div id="container">
      	<div id="page-title">
			<h1>Product List</h1>
			<p>商品一覧</p>
		</div>
		<div id="product-list">			
			<s:if test="!keywordsErrorMessageList != null">
					<s:iterator value="keywordsErrorMessageList">
					<div id="error">
						<div class="error-box">
							<p><s:property /></p>
						</div>
					</div>
					</s:iterator>
			</s:if>
			<s:if test="productInfoDTOList == null">
			<div id="error">
				<div class="error-box">
					<p>検索結果がありません。</p>
				</div>
			</div>
				
			</s:if>
			<s:else>
			<s:iterator value="productInfoDTOList">
				<div id="item">
					<div id="item-box">
						<div id="item-image">
							<a href='<s:url action="ProductDetailsAction">
							<s:param name="productId" value="%{productId}"/></s:url>'>
							<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
							class="item-image-box-200"/></a>
						</div>
						<div id="item-text">
							<h3><s:property value="productName"/></h3>
							<p><s:property value="productNameKana"/></p>
							<p><s:property value="price"/>円</p>
						</div>
					</div>
				</div>
			</s:iterator>
			</s:else>
			</div>
		</div>
</body>
</html>