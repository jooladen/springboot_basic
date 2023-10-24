/********************************************
 *  JQuery 사용
 ********************************************/

 $(document).ready(() => {
	$("tbody tr").click((e) => {	
		var $target = $(e.target);
		var $tr = $target.parents();
		var $no = $tr.find("td.d-none").text();
		if($no == '') {return;}
		else {location.href = "/user/select?no=" + $no;}
	});
	
	$("#pwd2").change(() => {
		var $pwd2 = $("#pwd2").val();
		console.log($pwd2);
		$("#pwd").val($pwd2);
		console.log($("#pwd").val());
	});
});