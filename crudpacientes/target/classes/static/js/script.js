$(document).ready(function(){
  $("#pesquisa").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#pacientesTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});


$(document).ready(function(){
  $('#pacientesTable').pageMe({
    pagerSelector:'#paginacao',
    activeColor: 'blue',
    prevText:'Anterior',
    nextText:'Próximo',
    showPrevNext:true,
    hidePageNumbers:false,
    perPage:5
  });
});
