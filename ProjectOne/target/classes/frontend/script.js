let domain = "http://localhost:7000"
window.onload = async function () {
    let response = await fetch(`${domain}/check-session`);
    let result = await response.json();

    if (result.successful) {
        if (result.user.userRole === "Financial Manager") {
            window.location = "./managerdashboard";
        }
        else if (result.user.userRole === "Employee") {
            window.location = "./empdashboard";
        }
    }
}

async function getUser(e) {
    e.preventDefault();
    let usernameInput = document.getElementById("username");
    let passwordInput = document.getElementById("password");

    let username = usernameInput.value;
    let password = passwordInput.value;

    let response = await fetch(`${domain}/login?username=${username}&password=${password}`, {
        method: "POST",
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    let author = await response.json();

    if (author.successful) {
        switch (author.user.userRole) {
            case "Financial Manager":
                window.location = "./managerdashboard";
                break;
            case "Employee":
                window.location = "./empdashboard";
                break;
            default:
                console.log("No user found");
        }
    } else {
        console.log(author.message);
        console.log(author);
    }

}










