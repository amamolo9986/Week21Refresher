package com.coderscampus.javascriptpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.javascriptpractice.domain.User;

@SpringBootApplication
public class Week21RefresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week21RefresherApplication.class, args);
	}

	/* JS Notes
	 * 
	 * Video 1: Setting up the project
	 * 
	 * 
	 * Video 2: Hello World
	 * JS lives in a web page and a browser is in charge of working with JS.
	 * They essentially have JS engines that can be used to interpret.
	 * 
	 * "Client Side" language. JS can be ran on the server, but thats Node JS. 
	 * 
	 * Is declared in the head or the body of HTML page using <script><script/>
	 * 
	 * 
	 * Video 3: Declaring Variables in JS
	 * Data types exist but they are handled for us by the JS engine. We dont 
	 * define types explicitly. we say "var variableName = literal".
	 * JS has something called dynamic typing, this means that it tries to figure 
	 * out the data type based on code context. a literal surround by quote or
	 * backtick will be interpreted as string, etc.
	 * 
	 * Side note, == checks value, === checks value and type
	 * 
	 * 
	 * Video 4: Data Types 
	 * Objects in JS are created by using curly brackets
	 * var person = {
            'firstName': 'Alex',
            'lastName': 'McMahon',
            'age': '28',
            'address': {
                'line 1': '123 Fake Street',
                'line 2': 'apt 3',
                'city': 'San Antonio',
                'state': 'Texas'
            }
        }
	 * 
	 * 
	 * Video 5: Selecting Objects from the DOM
	 * Selecting an element in order to do something with it. 
	 * We will demonstrate this by adding a button, when we click on the button, we 
	 * want to validate the form to make sure the username and password was entered, 
	 * then the form is sent.
	 * 
	 * How do we do that? We have to select it first. To select, we add an Id, then we 
	 * are able to select the Id by accessing the DOM in which it is stored, or 
	 * Document Object Model.
	 * 
	 * NOTE: Most elements should have an ID assigned upon creation
	 * 
	 * HTML pages have a DOM: Document Object Model
	 * This is what we are selecting from, it holds the data for all elements on the page.
	 * 
	 * So we have given the submit button we created an id of "submitBtn", and we select
	 * it by saying 'document.querySelector("#submitBtn")'. And this will return the 
	 * object that we can then assign to a variable.
	 * 
	 * var submitBtn = document.querySelector("#submitBtn")
	 * 
	 * 
	 * Vid 6: Event Listeners
	 * 
	 * So the concept that we're looking at here is when we click the submit button, we
	 * want to validate the login forms. And by that we mean did they type the username
	 * and the password and is the username in the db, or something like that.
	 * 
	 * So how do we add functionality now that we've selected the submit button?
	 * 
	 * Well we add whats called an event listener. when the button is interacted with, the event
	 * listener tells it what to do. When something is selected, an event listener executes
	 * an action when an interaction is specified. 
	 * 
	 * When you hover, do this, when you click, do this, when your mouse leaves the button, do
	 * this, etc.
	 * 
	 * So we say submitBtn.addEventListener(`click`) because we want to verify the forms on click.
	 * But we can also add a function directly into the parameter, and the word'function' 
	 * is a keyword in js to define a method, it also takes params and a body, then
	 * we give the function a name. We can do this in two ways:
	 * 
	 * 		submitBtn.addEventListener(`click`, submitBtnClick)
	 * 		function submitBtnClick(){
	 * 			alert(`Hey! I've been clicked`)
	 * 		}
	 * 
	 * 		submitBtn.addEventListener(`click`, function submitBtnClick(){
     *      alert(`Hey! I've been clicked!`)
     *   	})
	 * 
	 * 
	 * Vid 7: More Event Listeners and Arrow Function
	 * 
	 * Going back to the previous video, we can also write the function without giving
	 * it a name if we dont need to reference it in multiple places.
	 * 
	 * So if we have 'function doSomething()' we would need this name if we have multiple
	 * event listeners like this 
	 * 
	 * submitBtn.addEventListener(`click`, doSomething)
	 * submitBtn.addEventListener(`mouseover`, doSomething)
	 * 
	 * now lets try to add a query selector to the username, and we dont need to add an 
	 * ID because its a th:field and the id will automatically be the field name for this
	 * expression "th:field="${user.username}"
	 * 
	 * And something else thats cool, we have lambdas in JS too, so we can drop the word
	 * function and leave the brackets, and we can also drop the curly brackets.
	 * 
	 * 		usernameField.addEventListener(`focus`, () =>
     *      console.log(`Username box boii`)
     *   )
     *   
     * Next video we will do the actual validation that we were talking about
	 * 
	 * 
	 * Video 8: Validating and Debugging - GOOD INFO IN THIS ONE
	 * 
	 * So in the start of this video, Trevor is getting rid of all of the JS examples
	 * that we worked on, so i'll clear them and add them in here so i have the reference.
	 * They can just be pasted back into VS if i want to see the examples again.
	 * 
	 * 
	 *  <script type="text/javascript">
	
        var name = `Alex`
        var age = 28

        console.log(`hello world, my name is ` + name + ` and i am ` + age + ` years old`)
        console.log(`hello world, my name is ${name} and i'm ${age} years old`)
        console.log(`the value of "age" is: ${age}, the data type is ${typeof age}`)

        var car
        var tesla = null

        console.log(`the value of "car" is: ${car}`)
        console.log(`the value of "tesla" is: ${tesla}`)

        console.log(`5 + 10 = ${5 + 10}`)

        var person = {
            'firstName': 'Alex',
            'lastName': 'McMahon',
            'age': '28',
            'address': {
                'line 1': '123 Fake Street',
                'line 2': 'apt 3',
                'city': 'San Antonio',
                'state': 'Texas'
            }
        }
        console.log(person)
        
        
        var submitBtn = document.querySelector(`#submitBtn`)
        console.log(`submitBtn is:`)
        console.log(submitBtn)

        submitBtn.addEventListener(`click`, submitBtnClick)
        
        function submitBtnClick () {
            alert(`I've been clicked!`)
        }

        submitBtn.addEventListener(`mouseover`, function(){
            console.log(`Someone's hoveringgggg`)
        })

        var usernameField = document.querySelector(`#username`)

        usernameField.addEventListener(`focus`, () =>
            console.log(`Username box boii`)
        )
    </script>
    *
    *
    * And now what we have left essentially is the query selector for the submit
    * button and the click event listener. Then we will add a function call to it,
    * then we assign a query selector to the username, then we will do the same 
    * for the password. Now we add a conditional statement to validate.
    * 
    * We added our conditional statement, but it didnt work, so now trevor is showing
    * us how to debug JS. What we do is navigate to the sources tab in dev tools and 
    * you select a break point from within that, then click the element on the page you
    * are working on to initiate the debugger. This starts around 3 minutes.
    * 
    * 
    * Video 9: Objects and Arrays
    * 
    * Starts by taking script out of the html directly and putting it in its own file
    * 
    * Now lets move on to arrays and objects. So lets say that we want to keep a history 
    * of login attempts - for no real reason other than demonstration.
    * 
    * So we create a user object, and while login attempts are valid, we assign a username
    * and a password to this user object, then we store it in an array of users.
    * 
    * {} = Objects; [] = Arrays
    * 
    * User Object: 
    *	var user = {
    *        "username" : username.value,
    *        "password" : password.value
    *    }
    * 
    * Array of Users:
    * 	var users = []
    * 
    * And to add a user to an array we dont say users.add (user), we say users.push(user).
    * 
    * We can check to see if it assigned the username and password and stored in the array
    * by creating a break point on our users.push line, filling in the fields, stepping 
    * over, then hovering over the array and the user object. We should see the user pop up.
    * 
    * Video 10: Fetch API
    * 
    * 
    * This is more advanced but we have seen this before 
    * 
    * Fetch is a JS method that can be leveraged to complete an HTTP request to an end point
    * but instead of using postman we are using JS. JS is performing the HTTP request for us 
    * and what it can do is communicate to the controllers in the server side.
    * 
    * But specifically this fetch will talk to RestControllers, and instead of returning
    * a view, it returns objects in JSON format. Then we can do something with this JSON formatted
    * object in JS.
    * 
    * So how are we going to use this inside of our code?
    * 
    * Well with what we have now, we can have it validate the username to see if the username 
    * exists. A real world version of this is if youre registering for a website, it may 
    * let you know if a particular username has already been taken.
    * 
    * So to start this, we can add a query selector to the username field, then we add an event
    * listener to that username field.
    * 
    * So we're saying, "on blur, or when we leave the username text box, do something." And now
    * we can set up our function with our fetch api.
    * 
    * Now to do this we set up a fetch parameter, and within that we add the endpoint we
    * want to fetch. So we'll add this fetch(`http://localhost:8080/users/validation`) and
    * this doesnt exist yet, so we create it.
    * 
    * We will create a user controller that is a rest controller, then create the mapping for
    * the fetch api endpoint.
    * 
    * After we do that, we add a .then() to say, once you've retrieved this method from this 
    * endpoint, THEN do something. So, "then", a "response method", then "the methods signature".
    * So you retrieve the endpoint, then you respond with this method, basically.
    * 
    * .then((respond) => {
    * 
    * })
    * 
    * then we just added a console log with the response and now we can see when we tab out of 
    * the username field, we see the request being sent. We cant really read the response 
    * yet, but we'll learn how to do that.
    * 
    * At 20 min he shows us how it works in debug mode
    * 
    * Video 11: Fetch API Customizations
    * 
    * 
    * So just to reiterate, if we have not noticed, this "fetch(`http://localhost:8080/users/validation`)"
    * essentially performs a get request. because the /validation endpoint is a get mapping
    * endpoint. And also, by default, it performs a get request. But how can we modify it to do 
    * something other than a get request? Like a post? Well we can overload this fetch to become a 
    * post.
    * 
    * and typically when we want to send data to the server, we want to send it as a post rather 
    * than a get. It can be sent as a get, we just cant send data with a get inside of the body
    * of the request. Remember a request has a header and a body and with a get there is no 
    * body so you would have to send it in the URL. for example:
    * 	"fetch(`http://localhost:8080/users/validation?username=${username.value}&password=${password.value}`)"
    * 
    * And all together like this as a get:
    * 
    * username.addEventListener(`blur`, () => {
    * 	var username = document.querySelector(`#username`)
    * 	var password = document.querySelector(`#password`)
    * 	fetch(`http://localhost:8080/users/validation?username=${username.value}&password=${password.value}`)
    * 	.then((response) => {
    *    	console.log(response)
    * 	})
    * })
    * 
    * But we arent actually getting any access to the body of the response. Theres a request and a 
    * response. Request is what we're sending, response is what we're receiving. so with this code
    * above, we can type in a username and apassword in the fields and we can see what we are 
    * sending, but all we get in return is the response object. we need to gain access to the body
    * within that object to see what is actually being received.
    * 
    * To do that we have to say:
    * 	.then((response) => {
    *    	return response.json()
    * 	})
    * 
    * and what this will so is take the entire body and turn it into a json format. then you can 
    * syso that data. 
    * 
    * 	.then((response) => {
    *    	return response.json()
    * 	})
    * 	.then((jsonResponse) => {
    * 		console.log(jsonResponse
    * 	})
    * 
    * jsonResponse can be called anything, this is just what i called it.
    * 
    * And now when we do this, we get the response "true" which makes sense, because that is 
    * what we are sending back in our get mapping. I will commit this here so we can see the example.
    * 
    * And there is also a shorter way to write this. If we remove the curly brackets around the 
    * return, the return keyword is assumed. See below
    * 
    *  	.then((response) => response.json())
    * 	.then((jsonResponse) => {
    * 		console.log(jsonResponse
    * 	})
    * 
    * 
    * Next video we will modify this to be a post request instead.
    * 
    * Video 12: Fetch API with Post
    * 
    * 
    * We saw in the previous video how to do a get request with a get mapping, but what about a 
    * post? Lets create a post mapping method in our controller to start. Trevor names these 
    * methods "exists", but i named them both "validation" just making a note so i dont get
    * confused when reading this later.
    * 
    * So this post will act differently in terms of how data is passed into the java method.
    * He said that we may be tempted to set it up similarly to the get, and he will show us that
    * is doesnt work that way, then also show us the right way to do it. 
    * 
    * So we temporarily have the get and post matching, then we go into our JS to set up the post.
    * remember that we do not pass data through the URL params for a post mapping, just a get. so we 
    * delete the URL params for our fetch.
    * 
    * Next we need to oevrload this fetch method to use the two arg, and the second one is an object.
    * Similar to an event lister where the first arg is the event and the second one is the function.
    * 
    * Now within this object we specify a few things, one being the method, which is post - and 
    * remember the objects in JS are key value pairs. Next we add the header, and the value 
    * for this is actually another object, and it specifies the content to be sent in json format.
    * By default the content is sent as plain text and we have to say "hey, thi sneeds to be json"
    * And then finally we have the body of the request. And with the body, you can pass data a few 
    * different ways, one is we can pass the values as strings and as objects, but we should 
    * really pass them as objects because its better.
    * 
    * Fetch with a String body:
    * 
    * body: `{
    *         "username": "${username.value}"
    *         "password": "${password.value}"
    *     }`
    *     
    *     and like this, we pull from the username and password query selectors.
    * 
    * Technically a body needs to be a string in order to be sent, and we can type it as a 
    * string, but its tedious and varbose and we are lazy. so we create the user object
    * instead, and this object will contain a username and a password, then we can use a methiod
    * called JSON.stringify() and we pass the object through the params, and this is how we can
    * pass the body off as a string.
    * 
    * So we end up with this instead:
    * 
    * var user = {
    *         "username": username.value,
    *         "password": password.value
    *     }
	* 
    * fetch(`http://localhost:8080/users/validation`, {
    *     method: "POST",
    *     headers: {
    *         "Content-Type": "application/json"
    *     },
    *     body: JSON.stringify(user)
    * })
    * 
    * So now we test, and remember that we are testing the incorrect way if writing the postmapping
    * mathod in the java side, and when we run it and try to submit, we get a null for the username
    * and the password. why is that? Well we arent accepting the data in a proper format. Remember
    * we are sending an object with two keys and two values, not two strings. So we need to pass 
    * the user object through these params instrad of the two strings.
    * 
    * So instead of this:
    * 
    * @PostMapping("/validation")
	* public boolean postExists(String username, String password) {
	* 	System.out.println("Username = " + username + ", Password = " + password);
	* 	return true;
	* }
	* 
	* We say this: 
	* 
    * @PostMapping("/validation")
	* public Boolean postValidated(User user) {
	* 	System.out.println("Username = " + user.getUsername() + ", Password = " + user.getPassword());
	* 	return true;
	* }
    * 
    * And finally we need to annotate @RequestBody in our param before the user object in the 
    * postMapping method.
    * 
    * And we are GOOD.
    * 
    * We dont have the User object addeds to the database, so we will independently add this to the DB.
    * we should also check to see if the username is valid in the database. just a little mini assignment.
    * 
    * But thats about it for this one.
    * 
    * Unit 22 Vid 1: Creating Another Registration Page
    * 
    * 
    * Create registration html page, we create a form of method post and nest some divs in there
    * for a username and password inout, a confirm password, and a submit button. Side note, by
    * default, if you create a button within a form and do not specify the button type, it wil
    * default to "type="submit""
    * 
    * We then create a getmapping and postmapping in the user controller. but thje user controller 
    * is set up as a Rest Controller so we have to modify this such that we are able to use both a 
    * regular and a rest controller. how we do that is change the annotation to @Controller, then 
    * on each controller that we need to be a rest, we annotate it with @ResponseBody.
    * 
    * Controller returns a View
    * Rest Controller returns an Object
    * 
    * Now we can set this up properly. We can set up the registration page to check if a username 
    * exists, we can set up the password confitmation, and we can also set up the post mapping for
    * the submit button.
    * 
    * We will also learn about call backs and promises.
    * 
    * 
    * Unit 22 Vid 2: Adding a Unique Constraint on Username
    * 
    * 
    * We will allow the registration page to actually create a user within the data base
    * We are also creating the table and everything, but i already did that.
    * 
    * PS dont forget that post mappings should always return a "redirect:" before the endpoint
    * 
    * Now that we have that set up, how can we make sure that we do not create usernames that 
    * are not unique? We can use the @Column annotation and set it to true. Now by DEFAULT
    * this is set to false, so we have to explicitly say @Column(unique = true) above our
    * field.
    * 
    * We get a 500 error on the client side and a Duplicate Entry exception on the server side.
    * 
    * WE dont want to see these errors, its like the last line of defense that the DB has, so this
    * is where JS should come in. We can check if a user exists on a blur event when the username
    * field has been tabed out so we dont have to see this ugly whitelabel page
    * 
    * 
    * Vid 3: Handling a fetched response
    * 
    * 
    * Now we're getting into the concept of augmenting our code with some JS such that we will 
    * perform a check to see if a username already exists before submitting the form.
    * 
    * first thing we will do is create the JS page. WE can add it into the HTML itself, but thats 
    * messy.
    * 
    * So here are the steps:
    * 
    * Create a query selector for the username text box - usernameTextBox
    * Add event listener on blur of usernameTextBox
    * Create fetch API - and endpoints should match the endpoints in controllers, not full http
    * Create the object to pass through JSON stringify, in this case its user and we omit password
    * Then when we get a response, we do something with it. We do that with .then()
    * Create variable for the response, we use data
    * Then we create a conditional for that data response, if true, do something, else, something else 
    * 
    * 
    * Vid 4: Finding Existing Users Logic
    * 
    * I did this logic after the last video but i will take notes on it anyways
    * 
    * I will list the steps like the previous video:
    * 
    * In the Validation endpoint we call the userService.findByUsername method
    * Add a parameter of user.getUsername
    * Create the method within the userService
    * Within the service we return the userRepo.findByUsername(username)
    * Then we also create the method within the Repo
    * Then we return (user!=null) in the controller because we are returning the boolean value
    * 	based off of "is the user not equal to null? yes or no." We want that to be a yes, so 
    * 	that way we basically say "this user exists, execute the method."
    * 
    * 
    * So now that we have this figured out, we can introduce the concept of a callback, which is 
    * also the predecessor for a promise. so we should really understand what a callback is first.
    * 
    * So how can we make use of this? Well the purpose of a callback is to execute a method when 
    * something that is asynchronously running, is finished. so you 'callbacl' to the moment that
    * whatever you were waiting for, is finished, to execute the next step. 
    * 
    * You have to put sauce on the pasta but only after its finished cooking, so you bake garlic 
    * bread while you wait, and then when the pasta is done, you 'callback' the pasta sauce
    * 
    * So we'll add a textbox glow animation callback that will glow red for a non unique
    * username.
    * 
    * He then finds a function for a JS animation and explains it - around the 11 minute mark
    * 
    * Then he says that we will take this code and modify it for our text box.
    * 
    * 
    * Vid 5: Callbacks
    * 
    * We want to create some sort of animation to provide a visual for when a username already 
    * exists in the database. 
    * 
    * So to do this we want to call a function to do this, and the function that we call, we will 
    * pass a parameter to that function that will also contain another function called a callback
    * function.
    * 
    * So within the first function we call the second function at the end.
    * 
    * So lets create a function called showErrorAnimation(), and then at the end of this function
    * we want to execute the callback. The empty function will look like this:
    * 
    * function showErrorAnimation(callback){
    *
    * 	callback
    * }
    * 
    * So the first thing we need to do is call the actual showErrorAnimation function in our if 
    * statement so it gets executed if a username does exist in the db.
    * 
    * He does a brief explanation of the callback flow at about 3 minutes, but it doesnt really
    * make sense to me. I think hes going to go more in depth soon with some console logs.
    * Yes he did this and i added some notes in the logs so we can see the order in which the 
    * flow is moving. I also committed this so theyre saved in github history. 
    * 
    * 
    * So now we'll actually go ahead and work on the animation that we were wanting to create.
    * The method we are wanting to call is the setInterval() method, and what this will do is 
    * allow us to repeatedly call a function over and over again after a specified number of 
    * milliseconds until a certain amount of time has lapsed.
    * 
    * So we will create an in line function within this method and our second parameter is the 
    * actual sleep time, so we can say something like 5 milliseconds.
    * 
    * So i wrote everything in the js file with notes on how it worked then i committed it again
    * so its in github for reference. 
    * 
    * Trevor then goes on to explain that this can get pretty convoluted really quickly because
    * you can have callbacks within callbacks within callbacks. and you can just keep nesting 
    * these things, and that the much better solution is promises. so thats the next video.
    * 
    * 
    * 
    * Video 6: Promises and the let keyword
    * 
    * So how we will navigate this is we will essentially refactor the code that we just wrote 
    * in the callback lesson and replace it with the more favorable approach, which is a promise.
    * 
    * I was going to leave all of the callback notes here before we change them, but i have them
    * committed so i will refer to them in my vid 5 commit history.
    * 
    * 
    * So before we start refactoring the code, lets dive into what a promise is and what it looks 
    * like syntactically.
    * 
    * 
    * So lets say we have something called myPromise that we will instantiate with the new 
    * keyword: var myPromise = new Promise()
    * Now within this promise we will have a function with two parameters, resolve and reject, 
    * and within the scope of the function we can essentially envoke a resolve or a reject.
    * 
    * So lets create a variable, and instead of using var we'll use the let keyword. This 
    * will allow scoping, its how we use every variable in java, its available within the 
    * scope of the method, and var is function scoped. NOTE: Let also tends to be the prefered 
    * method.
    * 
    * So trevor shows us an example of how to instantiate a promise, call either the resolve
    * or reject variables within the promise, and then call the promise itself. I will show 
    * you below
    * 
    * 
    * var myPromise = new Promise((resolve, reject) => {
    * 	let i = 1
	*
    * 	if (i === 1){
    * 	   resolve(`Hey, i equals 1, so we're cool`)
    * 	} else {
    *	    reject(`Absolute fail, i is not 1`)
    * 	}
	* })
    * 
    * so we set i equal to one and then add a message for the reject and the resolve. So we 
    * then call the myPromise function like this:
    * 
    * myPromise.then((message) =>{
    * 	console.log(message)
	* })
    * 
    * and it says "call this myPromise function, THEN display the appropriate message. However,
    * if the function results in a reject, it will throw an exception, so we need to catch it.
    * 
    *
    * myPromise.then((message) =>{
    * 	console.log(message)
	* }).catch((message) => {
    * console.log(message)
	* })
    *
    * He says that this is what it would look like if we are building promises out ourselves, but
    * typically we dont do that. we normally leverage other peoples code and promises.
    * 
    * for example, when we look at out fetch function, it returns a .then, that ,then is a 
    * promise. a fetch returns a promise and in order to use them we use a .then.
    * 
    * So now we will move on to the refactoring of the callback, i will comment out this promise
    * code and move it down to the bottom of the code so we can reference it later.
    * 
    * 
    * So now looking at the existing callback, trevor is saying that we can basically turn it into
    * a promise.  
    *
    * I'm going to make the revisions and not keep any of the callback notes because i have them in 
    * the commit.
    * 
	* Also note: When a function call is followed by .then() the parameter in 'then' will always 
	* hold the value passed to resolve
	* 
    *
    * Vid 7: Query Selector All and Font Awesome
    * 
    * He opens this video by talking about query selectors and that there is another version that
    * is query selector all. What this does is return more than one element from the screen that
    * can be grabbed. This is helpful when we want to grab a group of things and do something with
    * the group of things.
    * 
    * He then starts to talk about how sometimes for password input fields theres a little eye icon
    * and when you push it it reveals the password. i imagine we will be using the query select all
    * to execute this
    * Okay yes, he then proceeds to talk about how we will need two separate eye icons, each being 
    * tied to a different function.
    * So for the icon we will be using font awesome.
    * 
    * So we go to our kit, pull the line of js, and drop it into our html page header, and now we
    * have access to the icons. So now how do we get the icons? Well we find the icon we want, we
    * click on it, and it gives us the code. Now its an element for us to paste wherever we like.
    * So we put it in our password divs.
    * 
    * Now we have to write the code that says "when i click the eye, do something" and thats all
    * going to be js. So we make the query selector all and the class name for the icons we just 
    * inserted.
    * 
    * Note - query selectors: select by class = ".className", select by id = "#idName"
    * 
    * Also QuerySelectorAll returns a nodeList, so when we add a console log we can see that there
    * is a node list now and we have two elements in that list because we added two icons. So now how 
    * do we do something with this list? Well we can create a forEach loop that iterated through the 
    * icons. So that'll look like this 
    * 
    * eyeIcons.forEach( (eyeIcon) => {
    * )} 
    * 
    * And this "eyeIcon" in the parameter is the name of each element within the list, its just a 
    * variable, we can name it whatever we like. And then within the for each loop we can say 
    * "variableName." and then perform operations on the elements.
    * 
    * So how we'll start off is by adding a click event listener on the icons and creating a console
    * log of itself, then we can add id's for each icon in the html, one for password and one for 
    * confirm password. and now when we click on the icons, it will concole log the one that we clicked, 
    * whether it be the password eye or the confirm password eye
    * 
    * Okay so we tested this and it works! So what we want to do now is whenever we click on the eye
    * icon, we want it to do two things: first we want it to visually change into another icon, and 
    * functionally we want it to change the appearance of the characters within the input.
    * 
    * and we can use something called "classList" and i think it shows us the classes associated with 
    * certain elements. So both of our eye icons have the name 'fa-eye' attached to them, so we will 
    * iterate through the elements by saying 'if the eye icon class list contains 'fa-eye', do something'.
    * And we can say 'eyeIcon.classList.replace()', and the parameters are (currentElement, replacement)
    * and this will replace from one icon to the other.
    * 
    * classList has a few methods, we can google them to see what all it can do, but replace is one of
    * them.
    * 
    * So we're able to swap the icons from one to another, but now we need to change the password
    * text within the input. To do this, we need to create another if statement. Two more rather.
    * 
    * We originally had this if statement that said "if the element contains a specific key word,
    * change the icon from regular, to a slash, else, change it from slash to regular. Now this new
    * if statement that allows us to change the text will be nested within this statement.
    * 
    * To do this we need to create a query selector on the inputs so that we can toggle the type
    * between test and password, then we can say if type = text, change to password, and vice versa.
    * 
    * 
    * Vid 8: Async and Await
    * 
    * So there is a way to work with promises that feels slightly more familiar/more synchronous
    * Trevor says. This is Async and Await. We can take any promise and give it the syntax/structure
    * to behave like a synchronous structure and flow.
    * 
    * he then goes through and explains the flow of the code that we currently have for the first 6
    * ish minutes.
    * 
    * So how do we use async and await? Well we have to start by extracting the promise code and
    * and use it to create its own function. So basically all of the fetch and .then code we will
    * extract and move. Now we create the function and we will name it "checkIfUserExists", and we
    * will pass in a user, then we call that function and the passed in user where we just removed 
    * the code from.
    * 
    * So now that everything is in place, we test the code and it still works as it did before, 
    * but its still asynchronous. So here is where the keywords come in, before our newly constructed
    * function, we add the async keyword and we will add the await before the fetch in that function.
    * 
    * What this says is to execute the promise, but physically wait until the promise is resolved or
    * rejected before you move on. He also sets the await equal to the responseEntity which i dont 
    * fully understand to be honest. He's changing a lot of things very quickly and i'm not super able
    * to follow the why's. i am at minute 12.
    *  
    * I will just watch from here on out and not take notes
    * 
    * 
    * 
    * 
    * 
    * 
    *
    * 
    * 
    * 
    * 
	*/
}












