# note-api-data

Can be used postman to perform all the below operations ...
1) Create a note
Rest URL : http://localhost:8080/note
Set Header properties: Content-Type - application/json 
Payload:

{
"id": "123",
"name": "Enterprise Java",
"description":"Enterprise Java Description"
}


2) View a list of notes
Set Header properties: Content-Type - application/json 
Rest URL : http://localhost:8080/note/123

3) Update a note
Rest URL : http://localhost:8080/note
Set Header properties: Content-Type - application/json 

Payload:

{
"id": "456",
"name": "Enterprise Java edition",
"description":"Enterprise Java Description"
}

4) Delete a note
Set Header properties: Content-Type - application/json 
Rest URL : http://localhost:8080/note/123

