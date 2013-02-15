
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<jsp:include page="header.jsp" />
	  	

<!-- <script>
$(document).ready(function() {
   $("#content div").hide(); // Initially hide all content
   $("#tabs li:first").attr("id","current"); // Activate first tab
   $("#content div:first").fadeIn(); // Show first tab content
   
   $('#tabs a').click(function(e) {
       e.preventDefault();
       if ($(this).closest("li").attr("id") == "current"){ //detection for current tab
        return       
       }
       else{             
       $("#content div").hide(); //Hide all content
       $("#tabs li").attr("id",""); //Reset id's
       $(this).parent().attr("id","current"); // Activate this
       $('#' + $(this).attr('name')).fadeIn(); // Show content for current tab
       }
   });
});
</script> -->

<h4>Recommended Websites</h4>
	<script type="text/javascript">
		$('#myTab a').click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		})
	</script>
	<hr>

	<div id="display-recommendedsites" class="span12">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab"><b>Manage a Business</b></a></li>
			<li><a href="#profile1" data-toggle="tab"><b>Finance a Business</b></a></li>
			<li><a href="#profile2" data-toggle="tab"><b>Register a Business</b></a></li>
			<li><a href="#profile3" data-toggle="tab"><b>Start a Business</b></a></li>
			<li><a href="#profile4" data-toggle="tab"><b>Business Law</b></a></li>
			<li><a href="#profile5" data-toggle="tab"><b>Others</b></a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="home">
			<c:choose>
					<c:when test="${ empty manage }">
					</c:when>
					<c:otherwise>
	<!-- Manage Table --><table class="table table-striped">
							<thead>
								<tr class="info" style="text-align: center;">
									<th style="text-align: left;">Name</th>
									<th style="text-align: left;">URL</th>
									<th style="text-align: left;">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="manage" items="${manage}">
									<tr>
										<td style="text-align: left;">${manage.title} </td>
										<td style="text-align: left;">${manage.url}</td>
										<td style="text-align: left;">${manage.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:otherwise>
						</c:choose>
			</div>
			<div class="tab-pane fade" id="profile1"> 
				<!-- Manage Table --><table class="table table-striped">
							<thead>
								<tr class="info" style="text-align: center;">
									<th style="text-align: left;">Name</th>
									<th style="text-align: left;">URL</th>
									<th style="text-align: left;">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="finance" items="${finance}">
									<tr>
										<td style="text-align: left;">${finance.name} </td>
										<td style="text-align: left;">${finance.url}</td>
										<td style="text-align: left;">${finance.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table> 
			</div>
			<div class="tab-pane fade" id="profile2">
				Register a Business <br> <br> <br> <br> <br> <br> 
			</div>
			<div class="tab-pane fade" id="profile3">
				Start a Business <br> <br> <br> <br> <br> <br> 
			</div>
			<div class="tab-pane fade" id="profile4">
				Business Law <br> <br> <br> <br> <br> <br> 
			</div>
			<div class="tab-pane fade" id="profile5">
				Others <br> <br> <br> <br> <br> <br> 
			</div>
		</div>
	</div>


<jsp:include page="footer.jsp" />
	  