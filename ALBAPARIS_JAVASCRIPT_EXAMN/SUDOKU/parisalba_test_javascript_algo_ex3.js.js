var column_data = [];
var columnNum;
var row_data = [];
var cellNum;
var cell_data = [];
var rows;
// FOR ROWS
function F31() {
  for (let i = 0; i < to_verify.rows.length; i++) {
    row_data.push(to_verify.rows[i].outerText.split(" "));
  }
  F21(row_data);
}
F31();

//EACH REGION OF THE TABLE
function F33() {
  for (let i = 0; i < to_verify.rows.length; i++) {
    for (let j = 0; j < to_verify.rows.length; j++) {
      cellNum = to_verify.rows[i].cells[j].outerText;
      cell_data.push(cellNum);
    }
  }
  F21(cell_data);
  return cell_data;
}
var results;
//CREATION OF THE TABLE FOR SHOW THE RESULTS

function RESULTTABLE(tableData) {
  //CREATE TABLE
  results = document.createElement("table");
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

  results.appendChild(tableBody);
  document.body.appendChild(results);
}
//IF IT'S FALSE(THERE ARE REPEAT NUMBERS)
if (F33() == false) {
  //CREATE THE TABLE AND PASS THE REPEATED NUMBER ARRAY(F33() RETURN AN ARRAY)
  RESULTTABLE(F33());
}
