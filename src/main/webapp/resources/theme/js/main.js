
jQuery(document ).ready(function() {
	
	jQuery("#customersList").on( "click", "#addButton", function() {
		showDialog("/Customer/addEdit?id=");
	});
	
	
	jQuery("#customersList").on( "click", "#editButton", function() {
		showDialog("/Customer/addEdit?id=" + jQuery(this).attr("customerId"));
	});
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
        	
        	jQuery("#dateOfBirth").datepicker({
        		  dateFormat: "dd.MM.yyyy",
        		  showButtonPanel: true
        	});
        	
        	//jQuery("#csrf").attr("value", jQuery("meta[name='_csrf']").attr("content"));
        	//jQuery("#csrf").attr("name", jQuery("meta[name='_csrf_header']").attr("content"));
        	jQuery("#saveAction").attr("action", "/Customer/saveCustomer?_csrf=" + jQuery("meta[name='_csrf']").attr("content"));
        	
        },
        dataType : 'html'
    });
}