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
	  	<div class="row-fluid">
  		<div class="span12">
  			<h1>Header!</h1>
  		</div>
  		<div class="span12" align="center" style="margin-left: 0px; padding-left: 0px;">
  			<div id="map_canvas" style="width:80%; height:400px;"></div>
  		</div>
  		</div>

	

<jsp:include page="footer.jsp" />

