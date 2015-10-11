
jQuery(document ).ready(function() {
	
	jQuery("#customersList").on( "click", "#addButton", function() {
		showDialog("addEdit?id=");
	});
	
	
	jQuery("#customersList").on( "click", "#editButton", function() {
		showDialog("addEdit?id=" + jQuery(this).attr("customerId"));
	});
	
	jQuery("#customersList").on( "click", "#logOutButton", function(e) {
		// TODO: remove this and add working out logging
		alert("In this developement phase it's not possible to log out!");
		e.preventDefault();
	});
	
	jQuery("#customersList").on( "click", "#deleteButton", function(e) {
		var result = window.confirm('Are you sure you want to do it?');
        if (result == false) {
            e.preventDefault();
        };
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
        		  dateFormat: "dd.mm.yy",
        		  showButtonPanel: true
        	});
        	
        	
        	jQuery("#saveAction").attr("action", "saveCustomer?_csrf=" + jQuery("meta[name='_csrf']").attr("content"));
        	
        },
        dataType : 'html'
    });
}