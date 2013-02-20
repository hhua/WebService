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
					"${place.address}", "${place.rating}", "${place.priceLevel}", "${place.website}", "${place.imgUrl}"], </c:forEach> ];

	function initialize() {
		var location = new google.maps.LatLng(40.44, -80);

		var mapOptions = {
			center : location,
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

			//console.log(locations[i][7]);
			var contentString = '<div class="row-fluid" ><div class="span6" style="text-align: left;"><h4 class="text-left">' + locations[i][0]
			+ '</h4><p class="text-left">' + locations[i][3]
			+ '</p><p class="text-left">Rating: ' + locations[i][4] + ' | Price Level: ' + locations[i][5] + '</p><p class="text-left"><a href="' + locations[i][6] + '">Homepage</a></p></div><div class="span6"><img src="' + locations[i][7] + '" style="width:200px; height: 130px;"/></div></div>';

			google.maps.event.addListener(marker, 'click',
					(function(marker, i) {
						return function() {
							infowindow.setContent(contentString);
							infowindow.open(map, marker);
						};
					})(marker, i));
		}

	}
</script>

<div class="row-fluid" class="span12" id="thisSearch">
	<div class="span12"
		style="border: 1px solid #F5F5F5; border-radius: 5px; box-shadow: 5px 5px 2px #F5F5F5">
		<div style="padding-left: 15px;">
			<jsp:include page="error-list.jsp" />
			<br />
			<p class="lead">Search</p>
			<form class="form-horizontal form-inline" method="POST"
				action="simple-search.do">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-edit"></i></span> 
					<input
						type="text" id="search" class="input-xlarge"
						placeholder="Keywords, e.g. Restaurant"
						name="searchPlaces">
				</div>
				
				<div class="input-prepend">
					<span class="add-on"><i class="icon-map-marker"></i></span> <input type="text"
							placeholder="Location" name="searchLocation">
				</div>
				
				<input type="hidden" id="longitude" name="longitude" /> <input
					type="hidden" id="latitude" name="latitude" /> 
					
					<select
						id="place-types" name="placeTypes" style="width: 160px;">

					</select>
				<button type="submit" class="btn">
					<i class="icon-search"></i>Search
				</button>

			</form>
		</div>
	</div>

	</div> <!--  end of search box -->

		<div align="center" style="margin-left: 0px; margin-top: 40px; padding-left: 0px; float: left;">
				<div id="map_canvas" style="width: 800px; height: 400px;"></div>
		</div>

	<div style="border-bottom: 2px solid #f6f6f6;">
		<div id="searchresult" style="float: left; margin-top: 15px; margin-right: 20px; border-right: 2px solid #f5f5f5; width: 275px;">
			<c:choose>
				<c:when test="${ empty places }">
					
				</c:when>
				<c:otherwise>
					
					<h4 class="lead">Search Results</h4>
					<div id="competitorList" style="float: left; overflow:auto; height: 330px; width: 100%;">
						<script src="http://code.jquery.com/jquery-latest.js"></script>
								<c:forEach var="competitor" items="${places}" varStatus="theCount">
									<a href="#div${theCount.index}" style="text-decoration: none; color: black;">
									<div class="showdetail" name="div${theCount.index}" style="border-bottom: 1.5px solid #F5F5F5; width: 100%; ">
										<h5 style="line-height: 1em;">${competitor.name}</h5>
										<p style="line-height: 1em;"><b>Rating:</b> ${competitor.rating} | <b>Price Level:</b> ${competitor.priceLevel}</p> 
									</div>
									</a>
								</c:forEach>
								<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
								<script type="text/javascript">
								              // Show chosen div, and hide all others
								            $(".showdetail").click(function () {
											    $("#" + $(this).attr("name")).show('fast').siblings('div').hide();
											});
								             
								             
								          /**   $(".showdetail").click(function () {
								            	    $("#" + $(this).attr('name')).toggle("slow");
								            	});
								          **/
											
								</script>
						</div>

				</c:otherwise>
			</c:choose>
		</div>
		

	</div>	
		
		<div style="margin-top: 5px;">
						
				<c:forEach var="competitor" items="${places}" varStatus="theCount">
						<div id="div${theCount.index}" style="display: none;" class="row-fluid">
								<div style="clear: both;" class="span12">
											<div class="span2" style="margin-left: 15px;">
												<img src="${competitor.imgUrl}" style="float: left; width:300px; height: 200px;"/>
											</div>
											<div class="span3" style="float: left; margin-left: 15px;">
												<h4>${competitor.name}</h4>
												<p style="line-height: 1em;"><b>Rating:</b> ${competitor.rating} | <b>Price Level:</b> ${competitor.priceLevel}</p>
												<b>Address:</b><address>${competitor.address}</address>
												<b>Phone:</b> ${competitor.phone} <br> 
												<a href="${competitor.website}">Home Page</a> <br> 
												<a href="#thisSearch" class="btn" style="margin-top: 20px;">Back to result list</a>
											</div>
										<div class="span7" style="overflow: auto; height: 400px;">
												<b>Reviews:</b>
												<br>
												<c:forEach var="reviews" items="${competitor.reviews }">
														<div style="border-bottom: 1.5px solid #f5f5f5; padding-top: 5px; padding-bottom: 5px;">
																<p> 
																	<b>Time:</b>  ${reviews.time}
																	<b>Author:</b> ${reviews.author}
																	<a href="${reviews.url}">Link</a>
																</p>
																${reviews.text};
														</div>
												 </c:forEach>
											</div>
									</div>
						 </div>
					</c:forEach>
					
			</div>
									


<jsp:include page="footer.jsp" />

