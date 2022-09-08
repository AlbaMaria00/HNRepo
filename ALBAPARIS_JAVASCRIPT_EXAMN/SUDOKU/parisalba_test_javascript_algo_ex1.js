
//I DONT KNOW HOW TO READ IT FROM THE PDF FILE SO I COPIED IT
var array_number = new Array(9);
array_number[0] = "4 2 7 3 5 1 9 8 6";
array_number[1] = "9 8 3 7 6 2 5 1 4";
array_number[2] = "1 5 6 8 9 4 7 2 3";
array_number[3] = "2 3 9 1 8 5 4 6 7";
array_number[4] = "7 4 1 6 3 9 2 5 8";
array_number[5] = "5 6 8 2 4 7 1 3 9";
array_number[6] = "8 7 2 9 1 3 6 4 5";
array_number[7] = "3 9 5 4 2 6 8 7 1";
array_number[8] = "6 1 4 5 7 8 3 9 2";

var numero;
var array_new = [];
//FIRS WE SPLIT EACH ARRAY
array_number.forEach((element) => {
  numero = element.split(" ");
  array_new.push(numero);
});



var to_verify;
var row_id = 0;
//CREATION OF THE TABLE
function F12(tableData) {
  //CREATE TABLE
  to_verify = document.createElement("table");
  to_verify.setAttribute("id", "info");
  var tableBody = document.createElement("tbody");

  tableData.forEach(function (rowData) {
    var row = document.createElement("tr");
    row.setAttribute("id", row_id++);
    rowData.forEach(function (cellData) {
      var cell = document.createElement("td");
      cell.appendChild(document.createTextNode(cellData));
      row.appendChild(cell);
    });

    tableBody.appendChild(row);
  });

  to_verify.appendChild(tableBody);
  document.body.appendChild(to_verify);
};

F12(array_new);

//FUNCTION TO READ DE TABLE
function F11() {
    //if i dont put this, the table collapse
  document.getElementById("info2").innerHTML = "";
  var myTab = document.getElementById("info");
  for (i = 1; i < myTab.rows.length; i++) {
    var objCells = myTab.rows.item(i).cells;
    for (var j = 0; j < objCells.length; j++) {
      info.innerHTML = info.innerHTML + " " + objCells.item(j).innerHTML;
    }
    info.innerHTML = info.innerHTML + "<br />";
  }
}

F11();
