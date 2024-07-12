package com.coderscampus.javascriptpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	*/
}











