let domain = "http://localhost:7000";

const urlParams = new URLSearchParams(window.location.search);
const reimbId = urlParams.get('reimbId');

let authorId;
window.onload = async function () {
    let response = await fetch(`${domain}/check-session`);
    let result = await response.json();


    if (!result.successful) {
        window.location.href = "../../";
    }

    if (result.user.userRole === "Employee") {
        window.location.href = "../../empdashboard";
    }
    authorId = await result.user.usersId;
    await getReimbursement();
}

async function getReimbursement() {

    let response = await fetch(`${domain}/login/managerdashboard/${reimbId}`)
    let data = await response.json();
    createTable(data);
}

function createTable(data) {


    let form = document.getElementById("resolverForm");

    ///////////////FIRST NAME////////////////

    // <div class="col-md-3">
    //     <label class="form-label">First Name</label>
    //     <input type="text" class="form-control" placeholder="David" id="first" disabled>
    // </div>
    let divFirst = document.createElement("div");
    divFirst.className = "col-md-3";

    let labelFirst = document.createElement("label");
    labelFirst.className = "form-label";
    labelFirst.innerText = "First Name";

    let inputFirst = document.createElement("input");
    inputFirst.type = "text";
    inputFirst.className = "form-control";
    inputFirst.placeholder = data.reimbAuthorFirst;
    inputFirst.disabled = true;

    divFirst.appendChild(labelFirst);
    divFirst.appendChild(inputFirst);
    form.appendChild(divFirst);

    /////////////LAST NAME////////////////////

    // <div class="col-md-3">
    //     <label class="form-label">Last Name</label>
    //     <input type="text" class="form-control" placeholder="Helfer" id="last" disabled>
    // </div>
    let divLast = document.createElement("div");
    divLast.className = "col-md-3";

    let labelLast = document.createElement("label");
    labelLast.className = "form-label";
    labelLast.innerText = "Last Name";

    let inputLast = document.createElement("input");
    inputLast.type = "text";
    inputLast.className = "form-control";
    inputLast.placeholder = data.reimbAuthorLast;
    inputLast.disabled = true;

    divLast.appendChild(labelLast);
    divLast.appendChild(inputLast);
    form.appendChild(divLast);

    ////////////SUBMIT DATE///////////////////

    // <div class="col-4">
    //     <label class="form-label">Submit Date</label>
    //     <input type="text" class="form-control" placeholder="2012-10-16" id="subDate" disabled>
    // </div>
    let divSubDate = document.createElement("div");
    divSubDate.className = "col-md-4";

    let labelSubDate = document.createElement("label");
    labelSubDate.className = "form-label";
    labelSubDate.innerText = "Submit Date";

    let inputSubDate = document.createElement("input");
    inputSubDate.type = "text";
    inputSubDate.className = "form-control";
    inputSubDate.placeholder = data.submitDate;
    inputSubDate.disabled = true;

    divSubDate.appendChild(labelSubDate);
    divSubDate.appendChild(inputSubDate);
    form.appendChild(divSubDate);

    /////////////EXPENSE TYPE//////////////

    // <div class="col-3">
    //     <label class="form-label">Expense Type</label>
    //     <input type="text" class="form-control" id="type" placeholder="LODGING" disabled>
    // </div>
    let divType = document.createElement("div");
    divType.className = "col-3";

    let labelType = document.createElement("label");
    labelType.className = "form-label";
    labelType.innerText = "Expense Type";

    let inputType = document.createElement("input");
    inputType.type = "text";
    inputType.className = "form-control";
    switch (data.reimbType) {
        case 1:
            inputType.placeholder = "LODGING";
            break;
        case 2:
            inputType.placeholder = "TRAVEL";
            break;
        case 3:
            inputType.placeholder = "FOOD";
            break;
        case 4:
            inputType.placeholder = "OTHER";
    }
    inputType.disabled = true;

    divType.appendChild(labelType);
    divType.appendChild(inputType);
    form.appendChild(divType);

    //////////////EXPENSE DESCRIPTION///////////////////
    // <div class="col-5">
    //     <label class="form-label">Expense Description</label>
    //     <input type="text" class="form-control" id="desc" placeholder="Apartment, studio, or floor" disabled>
    // </div>
    let divDesc = document.createElement("div");
    divDesc.className = "col-5";

    let labelDesc = document.createElement("label");
    labelDesc.className = "form-label";
    labelDesc.innerText = "Expense Description";

    let inputDesc = document.createElement("input");
    inputDesc.type = "text";
    inputDesc.className = "form-control";
    inputDesc.placeholder = data.reimbDescription;
    inputDesc.disabled = true;

    divDesc.appendChild(labelDesc);
    divDesc.appendChild(inputDesc);
    form.appendChild(divDesc);

    //////////////////////AMMOUNT/////////////////////
    // <div class="col-md-2">
    //     <label class="form-label">Amount</label>
    //     <input type="text" class="form-control" placeholder="$100.69" disabled>
    // </div>
    let divAmount = document.createElement("div");
    divAmount.className = "col-2";

    let labelAmount = document.createElement("label");
    labelAmount.className = "form-label";
    labelAmount.innerText = "Amount";

    let inputAmount = document.createElement("input");
    inputAmount.type = "text";
    inputAmount.className = "form-control";
    inputAmount.placeholder = "$" + data.reimbAmount;
    inputAmount.disabled = true;

    divAmount.appendChild(labelAmount);
    divAmount.appendChild(inputAmount);
    form.appendChild(divAmount);

    /////////////////MANAGER FIRST NAME//////////////////
    // <div class="col-md-3">
    //     <label class="form-label">Manager First Name</label>
    //     <input type="text" class="form-control" placeholder="David" id="first" disabled>
    // </div>
    let divManFirst = document.createElement("div");
    divManFirst.className = "col-md-3";

    let labelManFirst = document.createElement("label");
    labelManFirst.className = "form-label";
    labelManFirst.innerText = "Manager First Name";

    let inputManFirst = document.createElement("input");
    inputManFirst.type = "text";
    inputManFirst.className = "form-control";
    inputManFirst.placeholder = data.reimbResolverFirst;
    inputManFirst.disabled = true;

    divManFirst.appendChild(labelManFirst);
    divManFirst.appendChild(inputManFirst);
    form.appendChild(divManFirst);

    ///////////////////MANAGER LAST NAME/////////////////////
    // <div class="col-md-3">
    //     <label class="form-label">Manager Last Name</label>
    //     <input type="text" class="form-control" placeholder="Helfer" id="last" disabled>
    // </div>
    let divManLast = document.createElement("div");
    divManLast.className = "col-md-3";

    let labelManLast = document.createElement("label");
    labelManLast.className = "form-label";
    labelManLast.innerText = "Manager Last Name";

    let inputManLast = document.createElement("input");
    inputManLast.type = "text";
    inputManLast.className = "form-control";
    inputManLast.placeholder = data.reimbResolverLast;
    inputManLast.disabled = true;

    divManLast.appendChild(labelManLast);
    divManLast.appendChild(inputManLast);
    form.appendChild(divManLast);

    ///////////////////////RESOLVE DATE//////////////////////
    // <div class="col-4">
    //     <label class="form-label">Resolve Date</label>
    //     <input type="text" class="form-control" placeholder="2012-10-16" id="subDate" disabled>
    // </div>
    let divResDate = document.createElement("div");
    divResDate.className = "col-4";

    let labelResDate = document.createElement("label");
    labelResDate.className = "form-label";
    labelResDate.innerText = "Resolve Date";

    let inputResDate = document.createElement("input");
    inputResDate.type = "text";
    inputResDate.className = "form-control";
    inputResDate.placeholder = data.resolveDate;
    inputResDate.disabled = true;

    divResDate.appendChild(labelResDate);
    divResDate.appendChild(inputResDate);
    form.appendChild(divResDate);

    //////////////////////STATUS///////////////////////////
    // <div class="col-md-4">
    //     <label class="form-label">Status</label>
    //     <select class="form-select" id="status">
    //         <option selected disabled>Select Status</option>
    //         <option value="1">Approved</option>
    //         <option value="3">Denied</option>
    //     </select>
    // </div>
    let divStatus = document.createElement("div");
    divStatus.className = "col-md-4";

    let labelStatus = document.createElement("label");
    labelStatus.className = "form-label";
    labelStatus.innerText = "Status";
    divStatus.appendChild(labelStatus);

    if (data.reimbStatus != 2) {
        let currentStatus = document.createElement("input");
        currentStatus.type = "text";
        currentStatus.className = "form-control";
        switch (data.reimbStatus) {
            case 1:
                currentStatus.placeholder = "Approved";
                break;
            case 3:
                currentStatus.placeholder = "Denied";
                break;
        }
        currentStatus.disabled = true;
        divStatus.appendChild(currentStatus);
    } else {
        let inputStatus = document.createElement("select");
        inputStatus.className = "form-select";
        inputStatus.id = "status";

        let selectDefault = document.createElement("option");
        selectDefault.innerText = "Select Status"
        selectDefault.selected = true;
        selectDefault.disabled = true;

        let selectApproved = document.createElement("option");
        selectApproved.innerText = "Approved"
        selectApproved.value = 1;

        let selectDenied = document.createElement("option");
        selectDenied.innerText = "Denied"
        selectDenied.value = 3;
        inputStatus.appendChild(selectDefault);//
        inputStatus.appendChild(selectApproved);// append options to select
        inputStatus.appendChild(selectDenied);//

        divStatus.appendChild(inputStatus);
    }

    form.appendChild(divStatus);

    /////////////////SUBMIT BUTTON///////////////////////
    // <div class="col-12">
    //     <button type="submit" class="btn btn-primary">Submit</button>
    // </div>
    if (data.reimbStatus == 2) {

        let divSubmit = document.createElement("div");
        divSubmit.className = "col-12";

        let submitBtn = document.createElement("button");
        submitBtn.type = "submit";
        submitBtn.className = "btn btn-primary";
        submitBtn.innerText = "Submit";

        divSubmit.appendChild(submitBtn);
        form.appendChild(divSubmit);
    }
}

async function updateReimbursement(e) {

    e.preventDefault();

    let statusInput = document.getElementById("status");
    let status = statusInput.value;
    let response = await fetch(`${domain}/login/managerdashboard`, {
        method: "PUT",
        body: JSON.stringify({
            reimbId: reimbId,
            reimbStatus: Number(status),
            resolverId: Number(authorId)
        })
    })
    let updated = await response.json();
    if (updated) {
        window.location = "../";
    }

}
