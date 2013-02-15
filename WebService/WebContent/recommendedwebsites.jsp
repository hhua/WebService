
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="header.jsp" />

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
				<!-- Manage Table --><table class="table table-striped">
							<thead>
								<tr class="info" style="text-align: center;">
									<th style="text-align: left;">Name</th>
									<th style="text-align: left;">URL</th>
									<th style="text-align: left;">Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="manage" items="${managebusiness}">
									<tr>
										<td style="text-align: left;">${manage.name} </td>
										<td style="text-align: left;">${manage.url}</td>
										<td style="text-align: left;">${manage.description} </td> 
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
								<c:forEach var="sites" items="${recommendedsites}">
									<tr>
										<td style="text-align: left;">${sites.name} </td>
										<td style="text-align: left;">${sites.url}</td>
										<td style="text-align: left;">${sites.description} </td> 
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