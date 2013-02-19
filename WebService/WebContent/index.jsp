
<!DOCTYPE html>
<html>
  	<head>
	    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	    <link href="css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
	    <link href="css/style.css" rel="stylesheet" type="text/css" />
		
 	</head>
  
  	<body onload="initialize()"> 
  		
  		<div id="bodycontainer" align="center">
  			
	  		<div id="header">
	  			<h1>Small Business Portal</h1>
	  		</div>
	  		
	  		<div id="simple">
	  			<p class="lead">You can just do a simple search</p>
	  			<form class="form-horizontal form-inline" method="POST"
				action="simple-search.do">
				<div class="input-prepend">
					<span class="add-on"><i class="icon-map-marker"></i></span> <input
						type="text" id="search" class="input-xlarge"
						placeholder="Places you want, e.g. Restaurant in Pittsburgh"
						name="searchPlaces">
				</div>
				<input type="hidden" id="longitude" name="longitude"/>
				<input type="hidden" id="latitude" name="latitude"/>
				<select id="place-types" name="placeTypes">

				</select>
				<button type="submit" class="btn">
					<i class="icon-search"></i>Search
				</button>
				<button type="submit" class="btn">Advanced Search</button>

			</form>
	  			
	  		</div>
	  		
	  		<div style="border-top: 1px solid #F5F5F5">
	  			<p class="lead">To start a business, here are some information you might need to do</p> 
	  		</div>
	  		
	  		<div id="mainbody" align="center">
	  			
	  			<a href="simplesearch.jsp">
		  			<div id="competitor1" class="navbox">
		  				<p class="step">Know Your Competitor</p>
		  				<p>Function Instruction</p>
		  			</div>
	  			</a>
	  			
	  			<a href="demographic.jsp">
		  			<div id="demographic1" class="navbox">
		  				<p class="step">Research Potential Market</p>
		  				<p>Function Instruction</p>
		  			</div>
	  			</a>
	  			
	  			<a href="policy.jsp">
		  			<div id="policy1" class="navbox">
		  				<p class="step">Get Licenses and Permits</p>
		  				<p>Function Instruction</p>
		  			</div>
	  			</a>
	  			
	  			<a href="policy.jsp">
		  			<div id="loan1" class="navbox">
		  				<p class="step">Get Some Money</p>
		  				<p>Function Instruction</p>
		  			</div>
	  			</a>
	  			
	  			<a href="recommendedwebsites.do">
		  			<div id="recommend1" class="navbox">
		  				<p class="step">Learn From Websites</p>
		  				<p>Function Instruction</p>
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