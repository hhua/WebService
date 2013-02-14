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
					 <form class="form-inline">
					 	  <!--   <label class="control-label" for="inputLoc">Location</label> -->
					 	  <div class="input-prepend">
					 	  		<span class="add-on"><i class="icon-map-marker"></i></span>
						  		<input type="text" id="inputLoc" class="input input-large simplein" placeholder="Location">
						  </div>
						  <span style="margin-left: 10px"></span>
						  <!--  <label class="control-label" for="inputCat">Category</label> -->
						  <div class="input-prepend">
						  		<span class="add-on"><i class="icon-list-alt"></i></span>
						  		<input type="text" id="inputCat" class="input input-large simplein" placeholder="Business Category">
						  </div>
 						  <span style="margin-left: 10px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
				</div>
				
				<div id="advancedsearch">
					 <h2  class="lead"  align="center" >Advanced Search</h2>
				      <div class="row-fluid">
				      		<div class="span3 searchbox" style="border-top: 2px solid rgb(153,182,29);">
				      				<h5>Competitor Research</h5>
				      				<hr>
									<div class="customerSearch">
										<input type="text" placeholder="condition 1">
										<input type="text" placeholder="condition 2">
										<button class="btn">Search</button>
									</div>
									<hr>
				      				<div class="customerLink">
				      					<a href="#" >Customize Search &raquo;</a>
				      				</div>
				      		</div>
				      		
				      		<div class="span3 searchbox" style="border-top: 2px solid rgb(252,215,36);">
				      				<h5>Demographic Research</h5>
									<hr>
									<div class="customerSearch">
										<input type="text" placeholder="condition 1">
										<input type="text" placeholder="condition 2">
										<button class="btn">Search</button>
									</div>
									<hr>
				      				<div class="customerLink">
				      					<a href="#" >Customize Search &raquo;</a>
				      				</div>
				      		</div>
				      		
				      		<div class="span3 searchbox" style="border-top: 2px solid rgb(35,116,255);">
				      				<h5>Real Estate</h5>
				      				<hr>
									<div class="customerSearch">
										<input type="text" placeholder="condition 1">
										<input type="text" placeholder="condition 2">
										<button class="btn">Search</button>
									</div>
									<hr>
				      				
				      				<div class="customerLink">
				      					<a href="#" >Customize Search &raquo;</a>
				      				</div>
				      		</div>
				      		
				      		<div class="span3 searchbox" style="border-top: 2px solid rgb(153,182,29);">
				      				<h5>Policy</h5>
				      				<hr>
									<div class="customerSearch">
										<input type="text" placeholder="condition 1">
										<input type="text" placeholder="condition 2">
										<button class="btn">Search</button>
									</div>
									<hr>
				      				
				      				<div class="customerLink">
				      					<a href="#" >Customize Search &raquo;</a>
				      				</div>
				      		</div>
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
