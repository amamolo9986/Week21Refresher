var submitBtn = document.querySelector(`#submitBtn`)
var username = document.querySelector(`#username`)
var users = []

submitBtn.addEventListener(`click`, () => {
    var username = document.querySelector(`#username`)
    var password = document.querySelector(`#password`)

    if (username.value == `` || password.value == ``) {
        alert(`Please enter a username or password`)
    } else {
        console.log(`Inputs valid for form submission`)
        var user = {
            "username" : username.value,
            "password" : password.value
        }
        users.push(user)
    }
})

username.addEventListener(`blur`, () => {
    fetch(`http://localhost:8080/users/validation`)
    .then((response) => {
        console.log(response)
    })
})