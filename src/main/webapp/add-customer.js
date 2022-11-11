/**
 * 
 */
 
 const message = "Hello World"
 
 console.log(message)
 
 const firstNameInput = document.getElementById('firstName')
 const lastNameInput = document.getElementById('lastName')
 const phoneNumberInput = document.getElementById('phoneNumber')
 const emailInput = document.getElementById('email')
 
 const form = document.getElementById('form')
 const errorElement = document.getElementById('error')
 
 form.addEventListener('submit', (e) => {
 	let errorMessages = []
 	
 	if (firstNameInput.value === '' || firstNameInput.value == null) {
 		errorMessages.push("First name is missing")
 	}
 	
 	if (lastNameInput.value === '' || lastNameInput.value == null) {
 		errorMessages.push("Last name is missing")
 	}
 	
 	if (phoneNumberInput.value === '' || phoneNumberInput.value == null) {
 		errorMessages.push("Phone number is invalid")
 	} else if (phoneNumberInput.value[3] != '-' || phoneNumberInput.value[6] != '-' || phoneNumberInput.value.length != 12) {
 		errorMessages.push("Phone number format is ***-***-****")
 	}
 	
 	if(emailInput.value === '' || emailInput.value == null) {
 		errorMessages.push("Email is missing or invalid")
 	}
 	
 	if (errorMessages.length > 0) {
 		e.preventDefault()
 		errorElement.innerText = errorMessages.join(', ')	
 	}
 
 })
 
 