<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script>
	
</script>
</head>
<body>
	<form name='dashboardForm' method="POST">
		<div class="container">
			<div class='row'>&nbsp;</div>
			<div class="pricing-area text-center">
				<div class="row">
					<div class="col-sm-4 plan price-two wow fadeInDown">
						<ul>
							<li class="heading-two"
								style="font-family: BEBAS; font-size: 25px; margin-top: 43px; text-align: center; color: #fff;">
								List Campaigns <span id='listcampaigns'></span>

							</li>
							<div id='campaign'
								style='min-height: 200px; text-align: left; padding-left: 50px;'>
							</div>

							<li class="plan-action"><a href="listcampaigns"
								class="btn btn-primary">Details</a></li>
						</ul>
					</div>
					<div class="col-sm-4 plan price-two wow fadeInDown">
						<ul>
							<li class="heading-two"
								style="font-family: BEBAS; font-size: 25px; margin-top: 43px; text-align: center; color: #fff;">
								Add Contacts<span id='editcampaigns'></span>

							</li>
							<div id='contactshistory'
								style='min-height: 200px; text-align: left; padding-left: 50px;'>
							</div>

							<li class="plan-action"><a href="editcampaigns"
								class="btn btn-primary">Details</a></li>
						</ul>
					</div>
					<!-- <div class="col-sm-3 plan price-two wow fadeInDown">
						<ul>
							<li class="heading-two"
								style="font-family: BEBAS; font-size: 25px; margin-top: 43px; text-align: center; color: #fff;">
								Contacts History<span id='contactshistory'></span>

							</li>
							<div id='contactshistory'
								style='min-height: 200px; text-align: left; padding-left: 50px;'>
							</div>

							<li class="plan-action"><a href="contactshistory"
								class="btn btn-primary">Details</a></li>
						</ul>
					</div> -->
					<div class="col-sm-4 plan price-two wow fadeInDown">
						<ul>
							<li class="heading-two"
								style="font-family: BEBAS; font-size: 25px; margin-top: 43px; text-align: center; color: #fff;">
								Configure FTP <span id='configureftppath'></span>

							</li>
							<div id='configureftppath'
								style='min-height: 200px; text-align: left; padding-left: 50px;'>
							</div>

							<li class="plan-action"><a href="configureftppath" 
								class="btn btn-primary">Details</a></li>
						</ul>
					</div>
					

				</div>
			</div>
		</div>
	</form>
</body>
</html>
<%@ include file="footer.jsp"%>