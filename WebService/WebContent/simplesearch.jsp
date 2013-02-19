<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="header.jsp" />

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBJGCKsWDcydBbj083edCvnTBLRrIJozOw&sensor=false">
	
</script>

<script type="text/javascript" src="js/places-categories.js">
	
</script>

<script type="text/javascript">
	var locations = [
			<c:forEach var="place" items="${places}">["${place.name}",
					"${place.latitude}", "${place.longitude}",
					"${place.address}", "${place.rating}", "${place.priceLevel}, $place.website"], </c:forEach> ];

	function initialize() {
		var location = new google.maps.LatLng(40.44, -80);

		var mapOptions = {
			center : location,
			//center : new google.maps.LatLng(40.44, -80),
			zoom : 13,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};

		var map = new google.maps.Map(document.getElementById("map_canvas"),
				mapOptions);

		// Check for geolocation support
		if (navigator.geolocation) {
			// Use method getCurrentPosition to get coordinates
			navigator.geolocation
					.getCurrentPosition(function show_map(position) {
						if (locations.length != 0) {
							cur_latitude = locations[0][1];
							cur_longitude = locations[0][2];
							//console.log(cur_latitude);
						} else {
							cur_latitude = position.coords.latitude;
							cur_longitude = position.coords.longitude;
						}

						// let's show a map or do something interesting!
						//alert(cur_latitude + ',' + cur_longitude);
						map.setCenter(new google.maps.LatLng(cur_latitude,
								cur_longitude));

						var mylng = document.getElementById("longitude");
						var mylat = document.getElementById("latitude");
						mylng.value = cur_longitude;
						mylat.value = cur_latitude;

					});
		}

		// add select options
		addPlacesOptions();

		/* var map = new google.maps.Map(document.getElementById("map_canvas"));
		map.setCenter(new google.maps.LatLng(cur_latitude, 
				cur_longitude), 14);
		map.setMapTypeId(google.maps.MapTypeId.ROADMAP); */

		var infowindow = new google.maps.InfoWindow();

		var marker, i;

		for (i = 0; i < locations.length; i++) {
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(locations[i][1],
						locations[i][2]),
				map : map
			});

			var contentString = '<div><h4>' + locations[i][0]
					+ '</h4><address>' + locations[i][3]
					+ '</address><p>Rating: ' + locations[i][4] + ' Price Level: ' + location[i][5] + '</p></div>';

			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent(contentString);
							infowindow.open(map, marker);
						}
					})(marker, i));
		}

	}
</script>

<div class="row-fluid" class="span12">
	<div class="span12"
		style="border: 1px solid #F5F5F5; border-radius: 5px; box-shadow: 5px 5px 2px #F5F5F5">
		<div style="padding-left: 15px;">
			<jsp:include page="error-list.jsp" />
			<br />
			<p class="lead">Search</p>
			<form class="form-horizontal form-inline" method="POST"
				action="simple-search.do">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-map-marker"></i></span> <input
						type="text" id="search" class="input-xxlarge"
						placeholder="Places you want, e.g. Restaurant in Pittsburgh"
						name="searchPlaces"><input type="text"
						placeholder="Location" name="searchLocation">
				</div>
				<input type="hidden" id="longitude" name="longitude" /> <input
					type="hidden" id="latitude" name="latitude" /> <select
					id="place-types" name="placeTypes">

				</select>
				<button type="submit" class="btn">
					<i class="icon-search"></i>Search
				</button>

			</form>
		</div>
	</div>

	<div id="result" class="row-fluid">

		<div id="searchresult" class="span4">
			<h4 class="lead">Detail Search Results</h4>
			<c:choose>
				<c:when test="${ empty places }">
				</c:when>
				<c:otherwise>

					<div id="competitorList"
						style="float: left; border-right: 2px solid #f5f5f5">
						<script src="http://code.jquery.com/jquery-latest.js"></script>
						<c:forEach var="competitor" items="${places}" varStatus="theCount">
							<div class="showdetail" name="div${theCount.index}">
								${competitor.name} ${competitor.rating} ${competitor.priceLevel}
								<script type="text/javascript"
									src="http://code.jquery.com/jquery-latest.js"></script>

							</div>

						</c:forEach>
						<script type="text/javascript">
							// Show chosen div, and hide all others
							$(".showdetail").click(
									function() {
										$("#" + $(this).attr("name")).show(
												'fast').siblings('div').hide();
									});
						</script>
					</div>
					<div id="competitorDetail">
						<c:forEach var="competitor" items="${places}" varStatus="theCount">

							<!--  Place detail information here, inside the DIV -->
							<div id="div${theCount.index}" style="display: none;">
								${competitor.name} <br>
								<address>${competitor.address}</address>
								${competitor.phone} <br> <a href="${competitor.website}">Home
									page</a> <br> <a href="${competitor.url}">See Detail Page</a>
								<br>

							</div>
						</c:forEach>
					</div>
					<!--
						<table class="table table-hover span12">
							<thead>
								<tr>
									<th>Name</th>
									<th>Address</th>
									<th>Rating</th>
									<th>Phone</th>
									<th>URL</th>
									<th>Website</th>
									<th>Price Level</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="competitor" items="${places}">
									<tr>
										<td>${competitor.name}</td>
										<td>${competitor.address}</td>
										<td>${competitor.rating}</td>
										<td>${competitor.phone}</td>
										<td><a href = "${competitor.url}">See Detail Page</a></td>
										<td><a href = "${competitor.website}">Home page</a></td>
										<td>${competitor.priceLevel}</td>
									</tr>
									<div id="${competitor.name}">
										${competitor.name} THIS IS TEST
									</div>
								</c:forEach>
							</tbody>
						</table>
						-->
				</c:otherwise>
			</c:choose>
		</div>
		<div class="span8" style="margin: 0px; padding: 0px; clear: right;">
			<div id="map_canvas" style="width: 800px; height: 560px;margin-top: 15px;"></div>
		</div>
	</div>
</div>

<!--  
	<script type="text/javascript">
		$('#myTab li').click(function(e) {
			e.preventDefault();
			$(this).tab('show');
		})
	</script>
-->



<jsp:include page="footer.jsp" />

