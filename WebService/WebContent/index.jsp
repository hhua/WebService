<!DOCTYPE html>
<html>
  	<head>
	    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	    <link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
	    <link href="css/style.css" rel="stylesheet" type="text/css" />
		
 	</head>
  
  	<body  onload="initialize()"> 
  	
	  	<div class="container">
		  	
			<div id="indexicon" align="center" style="margin-bottom: 20px;">
				<img style="height: 180px;"src="img/drive-business.jpg" />
				<h2 style="text-shadow: 0.1em 0.1em 0.1em #F5F5F5; margin-top: -10px;">Small Business Portal</h2>
			</div>
	
			<div class="row-fluid">
				<div id="simplesearch" align="center" >
					 <h2 class="lead">Simple Search</h2>
					 <!--  
					 <form class="form-inline">
					 	  <div class="input-prepend">
					 	  		<span class="add-on"><i class="icon-map-marker"></i></span>
						  		<input type="text" id="inputLoc" class="input input-large simplein" placeholder="Location">
						  </div>
						  <span style="margin-left: 10px"></span>
						  <div class="input-prepend">
						  		<span class="add-on"><i class="icon-list-alt"></i></span>
						  		<input type="text" id="inputCat" class="input input-large simplein" placeholder="Business Category">
						  </div>
 						  <span style="margin-left: 10px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
					-->
					<form class="form-horizontal" method="POST" action="simple-search.do" class="form-inline">
						<div class="input-prepend">
								<span class="add-on"><i class="icon-map-marker"></i></span>
								<input type="text" id="search"  class="input-xxlarge" placeholder="Places you want, e.g. Restaurant in Pittsburgh"
									name="searchPlaces">
						</div>
						<button type="submit" class="btn"><i class="icon-search"></i>Search</button>
						
					</form>
				</div>
				
				<div id="advancedsearch" align="center">
					 <h2  class="lead"  align="center" >Advanced Search</h2>
				
		  	  		<div class="nav_index" >
				  		<ul>
				  			<li id="competitor" class="lead"><a href="">Competitor</a></li>
				  			<li id="demographic" class="lead"><a href="">Demographic</a></li>
				  			<li id="policy" class="lead"><a href="">Policy</a></li>
				  			<li id="website" class="lead"><a href="">Recommend Website</a></li>
				  		</ul>
			  		</div>
			  		</div>
	 
		  
		  </div> <!--  end of container -->
		  <div id="footer">
				<div class="container" align="center">
					<hr>
					<p class="muted credit"> 
						<a href="#myModal"	data-toggle="modal">Privacy Policy</a> | 
						<a href="#myModal"	data-toggle="modal">Terms of Use</a> 
						&copy; Team Snipers
					</p>
				</div>
		  </div>
	  
	  	<script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	    <script src="js/bootstrap-datepicker.js"></script>
	    <script src="js/datepicker.js"></script>
	    <script src="js/bootstrap-tab.js"></script>
	  
	  </body>
</html>
