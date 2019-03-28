<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp" >
  <jsp:param name="title" value="商品詳細確認画面" />
</jsp:include>

	<div id="container">
	<div id="page-title">
		<h1>Product Detail</h1>
		<p>商品詳細</p>
	</div>
	 	<s:if test="descriptionErrorMessage != null">
			<s:if test="!descriptionErrorMessage.isEmpty()">
				<div id="error">
					<div class="error-box">
						<p><s:property value="descriptionErrorMessage"/></p>
					</div>
				</div>
			</s:if>
		</s:if>
	</div>
	<s:else>
	<div id="container">
		<div id="detail-list">
			  <div id="item-column">
			  	<div id="item-column-box">
			  		<div id="item-column-img-box">
			  			<div id="item-opcity-box"></div>
			  			<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>'>
			  		</div>
			  	</div>
			  </div>
			<div id="item-column">
			 <div id="item-column-box">
			 <s:form action="AddCartAction">
			 	<div id="nep-item-table">
			 		<table>
						<tr>
							<th><s:label value="商品名"/></th>
							<td><span id="main"><s:property value="%{#session.productName}"/></span></td>
						</tr>
						<tr>
							<th><s:label value="商品名ふりがな"/></th>
							<td><span><s:property value="%{#session.productNameKana}"/></span></td>
						</tr>
						<tr>
							<th><s:label value="値段"/></th>
							<td><span><s:property value="%{#session.price}"/>円</span></td>
						</tr>
						<tr>
							<th><s:label value="購入個数"/></th>
							<td><span><s:select name="productCount" list="%{#session.productCountList}"/>個</span></td>
						</tr>
						<tr>
							<th><s:label value="発売会社名"/></th>
							<td><span><s:property value="%{#session.releaseCompany}"/></span></td>
						</tr>
						<tr>
							<th><s:label value="発売年月日"/></th>
							<td><span><s:property value="%{#session.releaseDate}"/></span></td>
						</tr>
						<tr>
							<th><s:label value="商品詳細情報"/></th>
							<td><span><s:property value="%{#session.productDescription}"/></span></td>
						</tr>
					</table>
			 	</div>

					<div id="submit">
						<div id="submit-btn">
							<s:submit value="カートに追加"/>
						</div>
					</div>
			</s:form>
		 </div>
			</div>
		</div>
	</div>
	<div id="container">
		<div id="page-title">
			<h1>recommend</h1>
			<p>おすすめ商品</p>
		</div>
		<div id="recommend-list">
			<s:iterator value="#session.productInfoDTOList">
			<div id="recommend-item">
				<div id="recommend-item-box">
					<div id="item-image">
						<a href='<s:url action="ProductDetailsAction">
						<s:param name="productId" value="%{productId}"/></s:url>'>
						<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'></a>
					</div>
					<div id="recommend-item-text">
						<h3><s:property value="productName"/></h3>
					</div>
				</div>
			</div>
			</s:iterator>
		</div>
	</div>
 </s:else>
</body>
</html>