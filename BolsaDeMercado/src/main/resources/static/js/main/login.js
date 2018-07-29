$('#loginForm').on('submit', function(e) {
	
	$.ajax({
		type: "POST",
		url: "/user/checkUserCredentials",
		data : $(this).serialize(),
    }).done(function( data ) {
    	
    	var errorList = "";
    
    	if (data.length > 0) {
    		$.each(data, function(key, error) {
    			errorList = errorList + "<p>"+error+"</p>";
    		});
    		
    		$('#errorList').slideUp(function() {
    			$('#errorList div').html(errorList);
    			$('#errorList').slideDown();
    		});
    	} else {
    		window.location.replace("/establecimientos/listAllEstablecimientosByPersona");
    	}
    });
	e.preventDefault();
});