function cadastrarLivro() {
  var titulo = document.getElementById("tituloLivro").value;
  var autor = document.getElementById("autor").value;
  var paginas = document.getElementById("paginas").value;
  var status = document.getElementById("statusLivro").value;

  var table = document.getElementById("tableLivros");
  var body = document.getElementById("bodyTableLivro");
  var row = body.insertRow(-1);

  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  var cell4 = row.insertCell(3);
  var cell5 = row.insertCell(4);
  var cell6 = row.insertCell(5);

  cell1.innerHTML = row.rowIndex;
  cell2.innerHTML = titulo;
  cell3.innerHTML = autor;
  cell4.innerHTML = paginas;
  cell5.innerHTML = status;
  cell6.innerHTML = "<input id='deleteButton' type='button' class='btn btn-light' value='Apagar' >";

  document.getElementById("tituloLivro").value = '';
  document.getElementById("autor").value = '';
  document.getElementById("paginas").value = '';
}

function cadastrarFilme() {
  var titulo = document.getElementById("tituloFilme").value;
  var diretor = document.getElementById("diretor").value;
  var duracao = document.getElementById("duracao").value;
  var status = document.getElementById("statusFilme").value;

  var table = document.getElementById("tableFilmes");
  var body = document.getElementById("bodyTableFilmes");
  var row = body.insertRow(-1);

  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  var cell4 = row.insertCell(3);
  var cell5 = row.insertCell(4);
  var cell6 = row.insertCell(5);

  cell1.innerHTML = row.rowIndex;
  cell2.innerHTML = titulo;
  cell3.innerHTML = diretor;
  cell4.innerHTML = duracao;
  cell5.innerHTML = status;
  cell6.innerHTML = "<input id='deleteButton' type='button' class='btn btn-light' value='Apagar'>";

  document.getElementById("tituloFilme").value = '';
  document.getElementById("diretor").value = '';
  document.getElementById("duracao").value = '';
}

function cadastrarJogo() {
  var titulo = document.getElementById("tituloJogo").value;
  var desenvolvedora = document.getElementById("diretor").value;
  var plataforma = document.getElementById("plataforma").value;
  var status = document.getElementById("statusJogo").value;

  var table = document.getElementById("tableJogos");
  var body = document.getElementById("bodyTableJogos");
  var row = body.insertRow(-1);

  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  var cell4 = row.insertCell(3);
  var cell5 = row.insertCell(4);
  var cell6 = row.insertCell(5);

  cell1.innerHTML = row.rowIndex;
  cell2.innerHTML = titulo;
  cell3.innerHTML = desenvolvedora;
  cell4.innerHTML = plataforma;
  cell5.innerHTML = status;
  cell6.innerHTML = "<input type='button' id='deleteButton' class='btn btn-light' value='Apagar'>";

  document.getElementById("tituloJogo").value = '';
  document.getElementById("desenvolvedora").value = '';
}

$(document).ready(function() {
  $(document).on('click', '#deleteButton', function() {
    $(this).closest('tr').remove();
  });
});