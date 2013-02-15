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
var locations = [
              <c:forEach var="place" items="${places}">
                  		["${place.name}",
                  		"${place.latitude}",
                  		"${place.longitude}"],
               </c:forEach>
        ];
              	

var locations1 = [
                  ['Bondi Beach', 40.44, -80.00],
                  ['Coogee Beach', 40.441, -80.01],
                  ['Cronulla Beach', 40.442, -80.02],
                  ['Manly Beach', 40.44, -80.03]
                ];
	function initialize() {
		var mapOptions = {
			center: new google.maps.LatLng(40.44, -80.00),
			zoom: 14,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_canvas"),
			mapOptions);
	
		var infowindow = new google.maps.InfoWindow();
	
		var marker, i;
	
		for (i = 0; i < locations.length; i++) {  
			marker = new google.maps.Marker({
				position: new google.maps.LatLng(locations[i][1], locations[i][2]),
				map: map
			});
		
			google.maps.event.addListener(marker, 'click', (function(marker, i) {
				return function() {
		 		infowindow.setContent(locations[i][0]);
				infowindow.open(map, marker);
			}
			})(marker, i));
		}	

}

            	
</script>

<div class="row-fluid" class="span12">
	<div class="span12" style="border: 1px solid #F5F5F5; border-radius: 5px; box-shadow: 5px 5px 2px #F5F5F5">
		<div style="padding-left: 15px;">
			<jsp:include page="error-list.jsp" />
			<br />
			<p class="lead">Simple Search</p>
			<form class="form-horizontal" method="POST" action="simple-search.do" class="form-inline">
				<div class="input-prepend">
						<span class="add-on"><i class="icon-map-marker"></i></span>
						<input type="text" id="search"  class="input-xxlarge" placeholder="Places you want, e.g. Restaurant in Pittsburgh"
							name="searchPlaces">
				</div>
				<button type="submit" class="btn"><i class="icon-search"></i>Search</button>
				
			</form>
		</div>
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

