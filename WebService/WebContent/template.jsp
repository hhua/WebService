
<jsp:include page="header.jsp" />
	
	<div class="row-fluid" >
			
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
					 	  		<span class="add-on">State</span>
						  		<input type="text"  name="state" class="input" style="height: 30px;" placeholder="State" value="${ form.state }">
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
										<div id="segment" class="span6 searchbox">
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
												
												<div id="chart_div"></div>
												<!-- 
												<div style="padding-left: 5px; padding-right: 5px;">
													<p><b>Divorced-Female: </b>${gender.divorcedFemale }</p>
													<p><b>Divorced-Male: </b>${gender.divorcedMale }</p>
													<p><b>Married-Female: </b>${gender.marriedFemale }</p>
													<p><b>Married-Male: </b>${gender.marriedMale }</p>
													<p><b>Single-Female: </b>${gender.singleFemale }</p>
													<p><b>Single-Male: </b>${gender.singleMale }</p>
													<p><b>Widowed-Female: </b>${gender.widowedFemale }</p>
													<p><b>Widowed-Male: </b>${gender.widowedMale }</p>
												</div>
												 -->
											</div>
										</div>
								</div>
							</div>
								
								<div class="row-fluid" style="margin-left: 20px">
										<div id="age" class="searchbox span11" >
											<h4 style="border-bottom:1px solid rgb(35,116,255); padding-bottom: 5px; padding-left: 10px;">Age information of People</h4>
											<!-- 
											<div class="progress span11">
												<div class="bar bar-success progress-striped" style="width: ${age.zero }%;">0s</div>
											  	<div class="bar bar-success" style="width: ${age.ten }%;">10s</div>
											  	<div class="bar bar-info" style="width: ${age.twenty }%;">20s</div>
											  	<div class="bar bar-info" style="width: ${age.thirty }%;">30s</div>
											  	<div class="bar" style="width: ${age.forty }%;">40s</div>
											  	<div class="bar" style="width: ${age.fifty }%;">50s</div>
											  	<div class="bar bar-warning" style="width: ${age.sixseventy }%;"> >=60s</div>
											</div>
											 -->
											 <div id="chart_div1" style="width: 900px; height: 300px;"></div>
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
										</div>
									</div>
										
								<div>
								 
						</div>
					</c:otherwise>
			</c:choose>
	</div>

  <jsp:include page="footer.jsp" />
  
