<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />
	
	<div class="row-fluid" >
			
			<div class="span12 searchbox" >
				<h5 class="lead">Search Demographic Information</h5>
				<jsp:include page="error-list.jsp" />
				<form class="form-inline" method="POST" action="demographic.do" style="margin-left: 20px;">
					 	  <!--   <label class="control-label" for="inputLoc">Location</label> -->
					 	 <div class="input-prepend">
						  		<span class="add-on">Area</span>
						  		<input type="text" id="inputArea" name="area" class="input input-large simplein" placeholder="Neighborhood Area" value="${ form.area }">
						  </div>
						  <span style="margin-left: 20px"></span>
						  <!--  <label class="control-label" for="inputCat">Category</label> -->
						  <div class="input-prepend">
						  		<span class="add-on">City</span>
						  		<input type="text" id="inputCity" name="city" class="input input-large simplein" placeholder="City" value="${ form.city }">
						  </div>
						  <span style="margin-left: 20px"></span>
						  <div class="input-prepend">
					 	  		<span class="add-on">State</span>
						  		<input type="text" id="inputstate" name="state" class="input input-large simplein" placeholder="State" value="${ form.state }">
						  </div>
 						  <span style="margin-left: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
			</div>
			
			  
			<c:choose>
					<c:when test="${empty segmentList}">
							
					</c:when>
					<c:otherwise>
			
						<div class="span12 searchbox" style="margin-left: 0px;" >
								<h5 class="lead">Demographic Information of <b>${area }, ${city }, ${state }</b></h5>
							
							
								<div class="row-fluid" style="margin-left: 20px">
										<div id="segment" class="span6 searchbox">
											<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Segmentation of People</h4>
											<c:forEach var="segment" items="${segmentList}">
													<div style="border-bottom: 1px solid #F5F5F5; padding-left: 5px; padding-right: 5px;">
														<p style="padding-left: 5px;"><b>${segment.title }</b></p>
														<ul>
															<li>${segment.name }</li>
															<li>${segment.description }</li>
														</ul>
													</div>
											</c:forEach>
										</div>
										
										
										<div id="incomeGender" class="span5">
											<div id="income" class="searchbox">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Median Household Income (USD)</h4>
												<div style="padding-left: 5px; padding-right: 5px;">
													<p><b>Neighborhood: </b>${income.neighborIncome }</p>
													<p><b>City: </b>${income.cityIncome }</p>
													<p><b>Nation: </b>${income.nationIncome }</p>
												</div>
											</div>
											
											<div id="gender" class="searchbox">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Gender statistics</h4>
											</div>
										</div>
								</div>
							</div>
					</c:otherwise>
			</c:choose>
	</div>

  <jsp:include page="footer.jsp" />
  
