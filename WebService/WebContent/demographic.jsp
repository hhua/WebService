<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Divorced Female', ${gender.divorcedFemale }],
          ['Divorced Male', ${gender.divorcedMale }],
          ['Single Female', ${gender.singleFemale }],
          ['Single Male', ${gender.singleMale }],
          ['Married Female', ${gender.marriedFemale }],
          ['Married Male', ${gender.marriedMale }],
          ['Widowed Female', ${gender.widowedFemale}],
          ['Widowed Male', ${gender.widowedMale }],
        ]);

        // Set chart options
        var options = {'title':'Gender Information(Percentage)',
                       'width':450,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    
     <script type="text/javascript" src="https://www.google.com/jsapi"></script>
								    <script type="text/javascript">
								      google.load("visualization", "1", {packages:["corechart"]});
								      google.setOnLoadCallback(drawChart);
								      function drawChart() {
								        var data = google.visualization.arrayToDataTable([
								          ['Age Decade', 'Percentage'],
								          ['0s',  ${age.zero }],
								          ['10s',  ${age.ten }],
								          ['20s',  ${age.twenty }],
								          ['30s',  ${age.thirty }],
								          ['40s',  ${age.forty }],
								          ['50s',  ${age.fifty }],
								          ['>=60s',  ${age.sixseventy }]
								        ]);
								
								        var options = {
								          title: 'Age Decades',
								        };
								
								        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div1'));
								        chart.draw(data, options);
								      }
								    </script>

<jsp:include page="header.jsp" />

	
	<div class="row-fluid"  style="min-width: 1000px;">

			
			<div class="span12 searchbox" >
				<h5 class="lead">Search Demographic Information</h5>
				<jsp:include page="error-list.jsp" />
				<div>
				<form class="form-inline" method="POST" action="demographic.do" style="margin-left: 20px;">
					 	  <!--   <label class="control-label" for="inputLoc">Location</label> -->

						  <div class="input-prepend">
								<span class="add-on">Area</span>
								<input type="text" name="area"  class="input" style="height: 30px;" placeholder="Area" value="${ form.area }">
						</div>
						  <span style="margin-left: 20px"></span>
						  <!--  <label class="control-label" for="inputCat">Category</label> -->
						  <div class="input-prepend">
						  		<span class="add-on">City</span>
						  		<input type="text"  name="city" class="input" style="height: 30px;" placeholder="City" value="${ form.city }">
						  </div>
						  <span style="margin-left: 20px"></span>
						  <div class="input-prepend">
						  <!--  
					 	  		
						  		<input type="text"  name="state" class="input" style="height: 30px;" placeholder="State" value="${ form.state }">
						  		-->
						  		<span class="add-on">State</span>
						  		 <select name="state">
										<option value="AL">Alabama</option>
										<option value="AK">Alaska</option>
										<option value="AZ">Arizona</option>
										<option value="AR">Arkansas</option>
										<option value="CA">California</option>
										<option value="CO">Colorado</option>
										<option value="CT">Connecticut</option>
										<option value="DE">Delaware</option>
										<option value="DC">District of Columbia</option>
										<option value="FL">Florida</option>
										<option value="GA">Georgia</option>
										<option value="HI">Hawaii</option>
										<option value="ID">Idaho</option>
										<option value="IL">Illinois</option>
										<option value="IN">Indiana</option>
										<option value="IA">Iowa</option>
										<option value="KS">Kansas</option>
										<option value="KY">Kentucky</option>
										<option value="LA">Louisiana</option>
										<option value="ME">Maine</option>
										<option value="MD">Maryland</option>
										<option value="MA">Massachusetts</option>
										<option value="MI">Michigan</option>
										<option value="MN">Minnesota</option>
										<option value="MS">Mississippi</option>
										<option value="MO">Missouri</option>
										<option value="MT">Montana</option>
										<option value="NE">Nebraska</option>
										<option value="NV">Nevada</option>
										<option value="NH">New Hampshire</option>
										<option value="NJ">New Jersey</option>
										<option value="NM">New Mexico</option>
										<option value="NY">New York</option>
										<option value="NC">North Carolina</option>
										<option value="ND">North Dakota</option>
										<option value="OH">Ohio</option>
										<option value="OK">Oklahoma</option>
										<option value="OR">Oregon</option>
										<option value="PA">Pennsylvania</option>
										<option value="RI">Rhode Island</option>
										<option value="SC">South Carolina</option>
										<option value="SD">South Dakota</option>
										<option value="TN">Tennessee</option>
										<option value="TX">Texas</option>
										<option value="UT">Utah</option>
										<option value="VT">Vermont</option>
										<option value="VA">Virginia</option>
										<option value="WA">Washington</option>
										<option value="WV">West Virginia</option>
										<option value="WI">Wisconsin</option>
										<option value="WY">Wyoming</option>
									</select>
						  </div>
 						  <span style="margin-left: 20px"></span>
						  <button type="submit" class="btn"><i class="icon-search"></i>Search</button>
					</form>
					</div>
			</div>
			
			  
			<c:choose>
					<c:when test="${empty segmentList}">
							
					</c:when>
					<c:otherwise>
			
						<div class="span12 searchbox" style="margin-left: 0px;" >
								<h5 class="lead">Demographic Information of <b>${area }, ${city }, ${state }</b></h5>
								<div class="row-fluid" style="margin-left: 20px">
											
											<div id="segment" class="span6">
											<div id="gender" class="searchbox ">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Area Map</h4>
												<c:choose>
														<c:when test="${empty hasMap }">
															<p>Area Map does not exist</p>
														</c:when>
														<c:otherwise>
															<div align="center">
																<img src="${mapurl}"> <br>
																<i>If this is not the area you want to research, please check your input.</i>
															</div>
														</c:otherwise>
												</c:choose>
												
											</div>
											<div class="searchbox">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Segmentation of People</h4>
												<c:forEach var="segment" items="${segmentList}">
														<div style="border-bottom: 1px solid #F5F5F5; padding-left: 5px; padding-right: 5px;">
															<p style="padding-left: 5px;"><b>${segment.title }</b></p>
															<ul>
																<li>${segment.name }</li>
																<li>${segment.description }</li>
															</ul>
														</div>
												</c:forEach>
											</div>
										</div>
										
										
										<div id="incomeGender" class="span5">
											
											
											
											<div id="income" class="searchbox">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Median Household Income (USD)</h4>
												<div style="padding-left: 5px; padding-right: 5px;">
													<table>
														<tr>
															<td>Neighborhood</td>
															<td >
																<div class="progress progress-info" style="margin-top: 25px; width: 300px;">
																  	<div class="bar" style="width: ${income.neighborP}%"></div>
																  	&nbsp; &nbsp; ${income.neighborIncome }
																</div>
															</td>
														</tr>
														<tr>
															<td>City</td>
															<td>
																<div class="progress progress-info" style="margin-top: 25px; width: 300px;">
																  	<div class="bar" style="width: ${income.cityP}%"></div>
																  	&nbsp; &nbsp; ${income.cityIncome }
																</div>
															</td>
														</tr>
														<tr>
															<td>Nation</td>
															<td>
																<div class="progress progress-info" style="margin-top: 25px; width: 300px;">
																  	<div class="bar" style="width: ${income.nationP}%"></div>
																  	&nbsp; &nbsp; ${income.nationIncome }
																</div>
															</td>
														</tr>
													</table>
												</div>
											</div>
											
											<div id="gender" class="searchbox">
												<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Gender statistics</h4>
												<c:set var="zero1" value = "0"></c:set> 
												<c:choose>
		  							   				<c:when test= "${gender.singleFemale eq zero1 }">
		  							   						<h4>Data does not exist</h4>
		  							   				</c:when>
		  							   				<c:otherwise>
		  							   						<div id="chart_div"></div>
		  							   				</c:otherwise>
												</c:choose>
											</div>
										</div>
								</div>
							</div>
								
								<div class="row-fluid" style="margin-left: 20px">
										<div id="age" class="searchbox span11" >
											<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Age information of People</h4>
											<c:set var="zero" value = "0.0"></c:set> 
  							   				<c:choose>
	  							   				<c:when test= "${age.twenty eq zero }">
	  							   						<h4>Data does not exist</h4>
	  							   				</c:when>
	  							   				<c:otherwise>
	  							   				
											 <div id="chart_div1" style="width: 800px; height: 300px;"></div>
											<table class="table table-bordered">
													 <thead>
											                <tr>
											                  <th>Age Decades</th>
											                  <th>Percentage</th>
											                  <th>Age Decades</th>
											                  <th>Percentage</th>
											                </tr>
										              </thead>
										              <tbody>
										              		<tr>
										              				<td>0s</td>
										              				<td>${age.zero }</td>
										              				<td>10s</td>
										              				<td>${age.ten }</td>
										              		</tr>
										              		<tr>
										              				<td>20s</td>
										              				<td>${age.twenty }</td>
										              				<td>30s</td>
										              				<td>${age.thirty }</td>
										              		</tr>
										              		<tr>
										              				<td>40s</td>
										              				<td>${age.forty }</td>
										              				<td>50s</td>
										              				<td>${age.fifty }</td>
										              		</tr>
										              		<tr>
										              				<td>>=60s</td>
										              				<td>${age.sixseventy }</td>
										              				<td colspan=2></td>
										              		</tr>
										              </tbody>
											</table>
											
											</c:otherwise>
  							   				</c:choose>
										</div>
									</div>
										
								<div>
								 
						</div>
					</c:otherwise>
			</c:choose>
	</div>

  <jsp:include page="footer.jsp" />
  
