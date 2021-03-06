<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="edu.cmu.ebiz.task8.bean.SimpleSearchPlacesBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


<jsp:include page="header.jsp" />

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBJGCKsWDcydBbj083edCvnTBLRrIJozOw&sensor=false">
	
</script>

<script type="text/javascript">
	var citymap = {};
	citymap['pittsburgh'] = {
		center : new google.maps.LatLng(40.437, -80.00000),
		population : 2842518
	};
	var cityCircle;

	function initialize() {
		var mapOptions = {
			center : new google.maps.LatLng(40.44, -80.00),
			zoom : 14,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);

		//add marker  
		var myLatlngs = new Array();
		var markers = new Array();
		<%
			List<SimpleSearchPlacesBean> searchPlaces = (ArrayList<SimpleSearchPlacesBean>) request.getAttribute("places");

			for(int i = 0; searchPlaces != null && i < searchPlaces.size(); i++){		
		%>
		
		myLatlngs[<%= i %>] = new google.maps.LatLng(<%= searchPlaces.get(i).getLatitude() %>, <%= searchPlaces.get(i).getLongitude() %>);
		markers[<%= i %>] = new google.maps.Marker({
			position : myLatlngs[<%= i %>],
			map: map,
			title : <%= searchPlaces.get(i).getName() %>
		});
		
		<%
			}
		%>
		
		// add circle
		for ( var city in citymap) {
			// Construct the circle for each value in citymap. We scale population by 20.
			var populationOptions = {
				strokeColor : "#FF0000",
				// strokeOpacity: 0.95,
				// strokeWeight: 1,
				fillColor : "#FF0000",
				fillOpacity : 0.95,
				map : map,
				center : citymap[city].center,
				radius : 100
			};
			cityCircle = new google.maps.Circle(populationOptions);
		}
	}
</script>

<div class="row-fluid" class="span12" onload="initialize()">
	<div class="span12">
		<jsp:include page="error-list.jsp" />
		<br />
		<form class="form-horizontal" method="POST" action="simple-search.do">
			<div class="control-group">
				<div class="controls">
					<input type="text" id="search" placeholder="Places you want"
						name="searchPlaces">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Search</button>
				</div>
			</div>
		</form>
	</div>
	<div class="span12">
		<h4>Search result of Restaurant in Pittsburgh area</h4>
	</div>
	<div class="span12" align="center"
		style="margin-left: 0px; padding-left: 0px;">
		<div id="map_canvas" style="width: 800px; height: 600px;"></div>
	</div>

	<!--
  		<div class=“span8” id="display-simpleresult">
  			<table class="table">
 				<thead>
 					<tr>
 						<th>head</th>
 					</tr>
 				</thead>
 				<tbody>
 					<tr>
 						<th>body</th>
 					</tr>
 				</tbody>
			</table>
  		</div>
  		  -->
	<hr>
	<h4>Detail Search Results</h4>
	<script type="text/javascript">
		$('#myTab a').click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		})
	</script>

	<div id="display-simpleresult" class="span12">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab"><b>Competitor
						Information</b></a></li>
			<li><a href="#profile" data-toggle="tab"><b>Demographic
						Information</b></a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="home">
				<c:choose>
					<c:when test="${ empty places }">
					</c:when>
					<c:otherwise>
						<table class="table table-striped span12">
							<thead>
								<tr>
									<th>Name</th>
									<th>Address</th>
									<th>Rating</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="competitor" items="${places}">
									<tr>
										<td>${competitor.name}</td>
										<td>${competitor.address}</td>
										<td>${competitor.rating}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="tab-pane fade" id="profile">
				Show some data <br> Population <br> race

			</div>
		</div>
	</div>

</div>

<jsp:include page="footer.jsp" />

