async function logout(){
    await fetch("http://localhost:7000/logout", {
        method: "DELETE"
    })
    window.location.href = "../"
}