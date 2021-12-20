let domain = "http://localhost:7000";
let authorId;
window.onload = async function () {

    let response = await fetch(`${domain}/check-session`);
    let result = await response.json();


    if (!result.successful) {
        window.location.href = "../";
    }

    if (result.user.userRole === "Financial Manager") {
        window.location.href = "../managerdashboard";
    }
    authorId = result.user.usersId;
    getAllReimbursementsForEmp();
}

async function getAllReimbursementsForEmp() {

    let response = await fetch(`${domain}/login/empdashboard/${authorId}`);
    let data = await response.json();
    populateTable(data);
}



async function createReimbursement(e) {

    e.preventDefault();

    let amountInput = document.getElementById("amount");
    let descInput = document.getElementById("desc");
    let typeInput = document.getElementById("type");
    let amount = Number(amountInput.value);
    let desc = descInput.value;
    let type = typeInput.value;

    let response = await fetch(`${domain}/login/empdashboard/${authorId}`, {
        method: "POST",
        body: JSON.stringify({
            reimbAmount: amount,
            reimbDescription: desc,
            reimbType: type,
            authorId: authorId
        })
    })

    let created = response.json();
    if (created) {
        getAllReimbursementsForEmp();
    }

}

function populateTable(reimbList) {


    let filter = document.getElementById("filter");
    console.log(filter.value);
    let tBodyElem = document.getElementById("tbody");
    tBodyElem.innerHTML = "";
    if (filter.value == 0) {

        reimbList.forEach(function (reimb) {

            // <tr>
            //     <th scope="row">1</th>
            //     <td>Mark</td>
            //     <td>Otto</td>
            //     <td>Pending</td>
            //     <td><button type="button" class="btn btn-outline-info"
            //         onclick="getReimbursement(event)">View</button></td>
            // </tr>

            let tRowElem = document.createElement("tr");
            tRowElem.id = reimb.reimbId;
            tRowElem.className = "reimbursement";
            let tHeadElem = document.createElement("th");
            tHeadElem.scope = "row";
            tHeadElem.innerHTML = reimb.reimbId;

            let tDataFirst = document.createElement("td");
            tDataFirst.innerHTML = reimb.reimbAuthorFirst;

            let tDataLast = document.createElement("td");
            tDataLast.innerHTML = reimb.reimbAuthorLast;

            let tDataStatus = document.createElement("td");
            let status = reimb.reimbStatus;
            switch (status) {
                case 1:
                    tDataStatus.innerText = "Approved";
                    tRowElem.className = "table-success";
                    break;
                case 2:
                    tDataStatus.innerText = "Pending";
                    tRowElem.className = "table-warning";
                    break;
                case 3:
                    tDataStatus.innerText = "Denied";
                    tRowElem.className = "table-danger";
                    break;
                default:
                    tDataStatus.innerText = "No Status";
            }


            let btn = document.createElement("button");
            btn.type = "button";
            btn.className = "btn btn-info";
            btn.innerText = "View";
            btn.id = reimb.reimbId;
            btn.addEventListener("click", function () {
                window.location = "./emp-reimb/?reimbId=" + reimb.reimbId;
            })

            let tDataBtn = document.createElement("td");
            tDataBtn.appendChild(btn);
            tRowElem.appendChild(tHeadElem);
            tRowElem.appendChild(tDataFirst);
            tRowElem.appendChild(tDataLast);
            tRowElem.appendChild(tDataStatus);
            tRowElem.appendChild(tDataBtn);
            tBodyElem.appendChild(tRowElem);
        });

    } else if (filter.value == 1) {

        let approved = reimbList.filter(reimb => reimb.reimbStatus == 1);

        approved.forEach(function (reimb) {

            // <tr>
            //     <th scope="row">1</th>
            //     <td>Mark</td>
            //     <td>Otto</td>
            //     <td>Pending</td>
            //     <td><button type="button" class="btn btn-outline-info"
            //         onclick="getReimbursement(event)">View</button></td>
            // </tr>

            let tRowElem = document.createElement("tr");
            tRowElem.id = reimb.reimbId;
            tRowElem.className = "reimbursement";
            let tHeadElem = document.createElement("th");
            tHeadElem.scope = "row";
            tHeadElem.innerHTML = reimb.reimbId;

            let tDataFirst = document.createElement("td");
            tDataFirst.innerHTML = reimb.reimbAuthorFirst;

            let tDataLast = document.createElement("td");
            tDataLast.innerHTML = reimb.reimbAuthorLast;

            let tDataStatus = document.createElement("td");
            tDataStatus.innerText = "Approved";
            tRowElem.className = "table-success";

            let btn = document.createElement("button");
            btn.type = "button";
            btn.className = "btn btn-info";
            btn.innerText = "View";
            btn.id = reimb.reimbId;
            btn.addEventListener("click", function () {
                window.location = "./reimbursement/?reimbId=" + reimb.reimbId;
            })

            let tDataBtn = document.createElement("td");
            tDataBtn.appendChild(btn);
            tRowElem.appendChild(tHeadElem);
            tRowElem.appendChild(tDataFirst);
            tRowElem.appendChild(tDataLast);
            tRowElem.appendChild(tDataStatus);
            tRowElem.appendChild(tDataBtn);
            tBodyElem.appendChild(tRowElem);
        });
    } else if (filter.value == 2) {

        let pending = reimbList.filter(reimb => reimb.reimbStatus == 2);

        pending.forEach(function (reimb) {

            // <tr>
            //     <th scope="row">1</th>
            //     <td>Mark</td>
            //     <td>Otto</td>
            //     <td>Pending</td>
            //     <td><button type="button" class="btn btn-outline-info"
            //         onclick="getReimbursement(event)">View</button></td>
            // </tr>

            let tRowElem = document.createElement("tr");
            tRowElem.id = reimb.reimbId;
            tRowElem.className = "reimbursement";
            let tHeadElem = document.createElement("th");
            tHeadElem.scope = "row";
            tHeadElem.innerHTML = reimb.reimbId;

            let tDataFirst = document.createElement("td");
            tDataFirst.innerHTML = reimb.reimbAuthorFirst;

            let tDataLast = document.createElement("td");
            tDataLast.innerHTML = reimb.reimbAuthorLast;

            let tDataStatus = document.createElement("td");
            tDataStatus.innerText = "Pending";
            tRowElem.className = "table-warning";

            let btn = document.createElement("button");
            btn.type = "button";
            btn.className = "btn btn-info";
            btn.innerText = "View";
            btn.id = reimb.reimbId;
            btn.addEventListener("click", function () {
                window.location = "./reimbursement/?reimbId=" + reimb.reimbId;
            })

            let tDataBtn = document.createElement("td");
            tDataBtn.appendChild(btn);
            tRowElem.appendChild(tHeadElem);
            tRowElem.appendChild(tDataFirst);
            tRowElem.appendChild(tDataLast);
            tRowElem.appendChild(tDataStatus);
            tRowElem.appendChild(tDataBtn);
            tBodyElem.appendChild(tRowElem);
        });
    } else if (filter.value == 3) {

        let denied = reimbList.filter(reimb => reimb.reimbStatus == 3);

        denied.forEach(function (reimb) {

            // <tr>
            //     <th scope="row">1</th>
            //     <td>Mark</td>
            //     <td>Otto</td>
            //     <td>Pending</td>
            //     <td><button type="button" class="btn btn-outline-info"
            //         onclick="getReimbursement(event)">View</button></td>
            // </tr>

            let tRowElem = document.createElement("tr");
            tRowElem.id = reimb.reimbId;
            tRowElem.className = "reimbursement";
            let tHeadElem = document.createElement("th");
            tHeadElem.scope = "row";
            tHeadElem.innerHTML = reimb.reimbId;

            let tDataFirst = document.createElement("td");
            tDataFirst.innerHTML = reimb.reimbAuthorFirst;

            let tDataLast = document.createElement("td");
            tDataLast.innerHTML = reimb.reimbAuthorLast;

            let tDataStatus = document.createElement("td");
            tDataStatus.innerText = "Denied";
            tRowElem.className = "table-danger";

            let btn = document.createElement("button");
            btn.type = "button";
            btn.className = "btn btn-info";
            btn.innerText = "View";
            btn.id = reimb.reimbId;
            btn.addEventListener("click", function () {
                window.location = "./reimbursement/?reimbId=" + reimb.reimbId;
            })

            let tDataBtn = document.createElement("td");
            tDataBtn.appendChild(btn);
            tRowElem.appendChild(tHeadElem);
            tRowElem.appendChild(tDataFirst);
            tRowElem.appendChild(tDataLast);
            tRowElem.appendChild(tDataStatus);
            tRowElem.appendChild(tDataBtn);
            tBodyElem.appendChild(tRowElem);
        });
    }
}

