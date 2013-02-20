
<!DOCTYPE html>
<html>
  	<head>
	    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	    <link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
	    <link href="css/style.css" rel="stylesheet" type="text/css" />
		
 	</head>
  
  	<body onload="initialize()" id="indexbody"> 
  		
  		<div id="bodycontainer" align="center">
  			
	  		<div id="header">
	  			<h1>Portal for Small Businesses</h1>
	  		</div>
	  		
	  		
	  		<div style="margin-top: 20px; ">
	  			<p class="handwrite">Guide to starting your business..</p> 
	  		</div>
	  		
	  		<div id="mainbody" align="center">
	  			
	  			<a href="simplesearch.jsp">
		  			<div id="competitor1" class="navbox">
		  				<p class="step">Know Your Competitors</p>
		  				<p style="margin-left: 10px;">Locations, Reviews, Ratings</p>
		  			</div>
	  			</a>
	  			
	  			<a href="demographic.jsp">
		  			<div id="demographic1" class="navbox">
		  				<p class="step">Research Demographics</p>
		  				<p style="margin-left: 10px;">Income, Segmentation of People, Gender and Age Stats</p>
		  			</div>
	  			</a>
	  			
	  			<a href="policy.jsp">
		  			<div id="policy1" class="navbox">
		  				<p class="step">Licenses and Permits</p>
		  				<p style="margin-left: 10px;">Description of Licenses and Permits </p>
		  			</div>
	  			</a>
	  			
	  			<a href="grantloan.do">
		  			<div id="loan1" class="navbox">
		  				<p class="step">Loans and Grants</p>
		  				<p style="margin-left: 10px;">Loan and Grant programs with descriptions</p>
		  			</div>
	  			</a>
	  			
	  			<a href="recommendedwebsites.do">
		  			<div id="recommend1" class="navbox">
		  				<p class="step">Learn From Websites</p>
		  				<p style="margin-left: 10px;">Pointers to recommended websites</p>
		  			</div>
	  			</a>
	  		</div>
	  	</div>
	  		
	  		
	  	</div>
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


<!--  old version homepage
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
	 
		  
		  </div> 
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
-->