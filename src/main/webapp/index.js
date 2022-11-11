/**
 * 
 */
 
 const message = "hello world"
 
 console.log(message)
 
 const roomNumberInput = document.getElementById('roomNumber')
 const numberOfBedsInput = document.getElementById('numberOfBeds')
 const bedSizeInput = document.getElementById('bedSize')
 const isVacantInput = document.getElementById('isVacant')
 const form = document.getElementById('form')
 const errorElement = document.getElementById('error')
 
 form.addEventListener('submit', (e) => {
 	let errorMessages = []
 	
 	if(roomNumberInput.value === '' || roomNumberInput.value == null || isNaN(roomNumberInput.value)) {
 		errorMessages.push("Room Number is missing or invalid")
 	}
 	
 	if(numberOfBedsInput.value === '' || numberOfBedsInput.value == null || isNaN(numberOfBedsInput.value)) {
 		errorMessages.push("Number of Beds is missing or invalid")
 	}
 	
 	if(bedSizeInput.value === '' || bedSizeInput.value == null) {
 		errorMessages.push("Bed Size is missing")
 	}
 	
 	if(isVacantInput.value === '' || isVacantInput.value == null || (isVacantInput.value.toLowerCase() != 'y' && isVacantInput.value.toLowerCase() != 'n')) {
 		errorMessages.push("Vacancy invalid: must be a 'y' or 'n'")
 	}
 	
 	if (errorMessages.length > 0) {
 		e.preventDefault()
 		errorElement.innerText = errorMessages.join(', ')	
 	}
 
 })
 
 