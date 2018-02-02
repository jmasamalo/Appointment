 
function getAppointments(){

	var contextRoot = "/" + window.location.pathname.split('/')[1];
	// serializeObject – custom function to take form data and structure it as a JSON object 
	// e.g. [{ x: 5, y: 6 }]
	var dataToSend = JSON.stringify(serializeObject($('#searchForm')));
	
	
	$.ajax({
		url: contextRoot+'/ajax/',
		type: 'POST',
		dataType: "json",// Accept header
		data : dataToSend,
		contentType : 'application/json', // Sends - Content-type
		success: function(response) {
			$('#appointmentsTable').html("");
			$("#appointmentsTable").append( '<table><tr><th>Date</th><th>Time</th><th>Description</th></tr>'); 
			
			$.each(response, function(i, appointment) {
				$("#appointmentsTable").append( '<tr>');
				$("#appointmentsTable").append('<td>' + timeConverter(appointment.dateTime)[0] + '</td>');
				$("#appointmentsTable").append('<td>' + timeConverter(appointment.dateTime)[1] + '</td>');
				$("#appointmentsTable").append('<td>' + appointment.description + '</td>');
				$("#appointmentsTable").append( '</tr>');
			});
			
			$("#appointmentsTable").append('</table>');
			make_visible('appointmentsTable');
			make_hidden('errors');
		},

		error: function(errorObject){
			
			console.log(errorObject);
			
			$('#errors').html("");
			$("#errors").append('Error: Sorry, there is an interal ajax call error for your search');
			make_visible('errors');
		}
	
	});
	

}


function newSelected(){
	
	make_visible('addForm');
	make_visible('cancelButton');
	make_hidden('errors');
	make_hidden('newButton');
}

function cancelSelected(){
	
	make_hidden('addForm');
	make_hidden('cancelButton');
	make_hidden('errors');
	make_visible('newButton');
}


toggle_visibility = function(id) {
    var element = document.getElementById(id);
    if(element.style.display == 'block')
    	element.style.display = 'none';
    else
    	element.style.display = 'block';
 }	

make_hidden = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'none';
        }	   

make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
 }	   

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

}
 
function timeConverter(UNIX_timestamp){
	  var a = new Date(UNIX_timestamp);
	  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	  var year = a.getFullYear();
	  var month = months[a.getMonth()];
	  var day = a.getDate();
	  var hour = a.getHours();
	  var min = a.getMinutes();
	  var sec = a.getSeconds();
	  var time = day + '-' + month + '-' + year + '  ' + hour + ':' + min + ':' + sec ;
	  var dateV = day + ' ' + month + ' ' + year ;
	  var timeV = hour + ':' + min + ':' + sec ;
	  return [dateV,timeV];
}

