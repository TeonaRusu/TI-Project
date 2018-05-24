function welcomeDisplay()
    {
    	var x = document.getElementById("welcome");
        setTimeout(function(){ x.style.display = "none" }, 3000);
    }

function addCell(row, data) {
	var cell = document.createElement("td");
	cell.innerHTML = data;
	row.appendChild(cell);
}


function createTabel(myBooks){
//	var body = document.getElementsByClassName("showTable")[0];
//	var table = document.createElement("table");
//	var tableBody = document.createElement("tbody");
//	tableBody.innerHTML += "<tr>" + "<th>FILE ID</th>" + 
//									"<th>USER ID</th>"+
//									"<th>NAME</th>" + 
//									"<th>TYPE</th>" + 
//									"<th>SIZE</th>" + "</tr>";
//
//	for(var i = 0; i < json.length; ++i)
//	{
//		var file_id = json.FileID;
//		var user_id = json.UserID;
//		var name = json.Name;
//		var type = json.Type;
//		var size = json.Size;
//
//		addCell("<tr>", file_id);
//		addCell("<tr>", user_id);
//		addCell("<tr>", name);
//		addCell("<tr>", type);
//		addCell("<tr>", syze);
//	}
//
//
//	table.appendChild(tableBody);
//	body.appendChild(table);
	var col = [];
    for (var i = 0; i < myBooks.length; i++) {
        for (var key in myBooks[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");

    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    var tr = table.insertRow(-1);                   // TABLE ROW.

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (var i = 0; i < myBooks.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = myBooks[i][col[j]];
        }
    }

    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function loadFiles(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	       
	    	console.log(this.responseText);
			var json = JSON.parse(this.responseText);
			createTabel(json);
		}

	};
	xhttp.open("GET", id, true);
	xhttp.send();
}