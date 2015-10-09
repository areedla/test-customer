jQuery("#customersList").on( "click", "addButton", function() {
	console.log(jQuery(this).attr("customerId"));
});


jQuery("#customersList").on( "click", "editButton", function() {
	console.log(jQuery(this).attr("customerId"));
});


jQuery("#customersList").on( "click", "addButton", function() {
	console.log(jQuery(this).attr("customerId"));
});

function showDialog(url){
    
    jQuery.ajax({
    	
        type : "GET",
        url : url,
        cache: false,
        data : null,
        
        beforeSend: function() {        	
        	if (jQuery("#dialog").is(":visible")) {
            	jQuery("#dialog").dialog("close");
            }
        },
        
        success : function(data) {
        	jQuery("#dialog").html(data);
        	jQuery("#dialog").dialog({
        		modal: true,
        	});
        	
        	jQuery("#dialog").dialog("open");
        	
        	// keskele
        	jQuery("#dialog").dialog({
                position: { 
                    my: 'center',
                    at: 'center'
                }
            });
        },
        dataType : 'html'
    });
}