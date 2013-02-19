<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />
	
	<div class="row-fluid" >
			
			<div class="span12 searchbox" >
				<h5 class="lead">Business Loans and Grants</h5>
				<jsp:include page="error-list.jsp" />
				<form class="form-inline" method="POST" action="grantloan.do" style="margin-left: 20px;">
					 	  <!--   <label class="control-label" for="inputLoc">Location</label> -->
					 	 <div class="input-prepend">
						  		<span class="add-on">State</span>
						  		<input type="text" id="inputArea" name="area" class="input input-large simplein" placeholder="State" value="${ form.state }">
						  </div>
 						  <span style="margin-left: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
					
					<c:choose>
					<c:when test="${ empty loansList }">
					</c:when>
					<c:otherwise>
					<table class="table table-striped">
							<thead>
								<tr class="info" style="text-align: center;">
									<th style="text-align: left;">Program</th>
									<th style="text-align: left;">Agency</th>
									<th style="text-align: left;">URL</th>
									<th style="text-align: left;">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="loans" items="${loans}">
									<tr>
										<td style="text-align: left;">${loans.program} </td>
										<td style="text-align: left;">${loans.agency} </td>
										<td style="text-align: left;"><a href ="javascript:click('${loans.url}');">${loans.url}</a></td>
										<td style="text-align: left;">${loans.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:otherwise>
						</c:choose>
			</div>
			</div>
			
  <jsp:include page="footer.jsp" />
  
