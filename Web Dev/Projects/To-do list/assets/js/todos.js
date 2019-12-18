// Check Off Todos by clicking

$("ul").on("click","li",function(){
	$(this).toggleClass("completed");
});

// Click on X to delete todo
$("ul").on("click", "span", function(event){
	$(this).parent().fadeOut(500,function(){
	// Refers to the parent		
	$(this).remove();	
	});
	event.stopPropagation();
});

// Create and add new li to ul
$("input[type='text']").keypress(function(event){
	if(event.which === 13){
	// grabbing new todo text from input
	var todoText = $(this).val();
	$(this).val("");
	// create a new li and add to ul
	$("ul").append("<li><span><i class='fa fa-trash'></i></span> " + todoText + "</li>");
	}
})

// Toggle input
$(".fa-plus").click(function(){
	$("input[type='text']").fadeToggle();
})