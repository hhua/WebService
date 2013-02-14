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
		var myLatlng = new google.maps.LatLng(40.440001, -80.00000);
		var marker1 = new google.maps.Marker({
			position : myLatlng,
			title : "Competitor1"
		});
		marker1.setMap(map);

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
		<form class="form-horizontal" method="POST"
			action="simple-search.do">
			<div class="control-group">
				<div class="controls">
					<input type="text" id="search"
						placeholder="Places you want" name="searchPlaces">
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
				Dispay a list of competitors <br> One <br> Two <br>
			</div>
			<div class="tab-pane fade" id="profile">
				Show some data <br> Population <br> race

			</div>
		</div>
	</div>

</div>

<jsp:include page="footer.jsp" />

